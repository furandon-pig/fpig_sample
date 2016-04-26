/* echo_server.c */

#include "net_echo.h"

int create_server(const char *hostname, const char *server_port,
		conn_info_t *conn)
{
	struct addrinfo hints, *res, *res0;
	int sock, error, r;
	char *cause;

	memset(&hints, 0, sizeof(hints));
	hints.ai_family = PF_INET;
	hints.ai_socktype = SOCK_STREAM;
	hints.ai_flags = AI_PASSIVE;

	error = getaddrinfo(NULL, server_port, &hints, &res0);
	if (error) {
		fprintf(stderr, "getaddrinfo() fail: %s", gai_strerror(error));
		return -1;
	}

	sock = -1;
	cause = "";
	for (res = res0; res; res = res->ai_next) {
		sock = socket(res->ai_family, res->ai_socktype,
				res->ai_protocol);

		r = bind(sock, res->ai_addr, res->ai_addrlen);
		if (r < 0) {
			close(sock);
			cause = "bind() failed.";
				continue;
		}

		listen(sock, 5);
		break;
	}
	conn->sock = sock;
	memcpy(&conn->ai, res, sizeof(conn_info_t));

	if (sock == -1) {
		fprintf(stderr, "%s\n", cause);
	}

	return 0;
}

int cleanup_server(conn_info_t *conn)
{
	close(conn->sock);
	freeaddrinfo(&conn->ai);

	return 0;
}

int server_loop(conn_info_t *conn)
{
	fd_set fds, fds_save;
	int is_loop, idx, r, i;
	int new_sock;
	char buf[BUFSIZ];
	char *c;

	if (conn == NULL) {
		return -1;
	}

	is_loop = 1;
	memset(buf, 0, BUFSIZ);

	FD_ZERO(&fds_save);
	FD_SET(conn->sock, &fds_save);

	while (is_loop) {
		fds = fds_save;

		r = select(16, &fds, NULL, NULL, NULL);
		switch (r) {
			case -1:
				if (errno == EINTR) {
					continue;
				}
				is_loop = 0;
				break;
			case 0:
				/* select() timeout */
				continue;
			default:
				break;
		}

		if (FD_ISSET(conn->sock, &fds)) {
			FD_CLR(conn->sock, &fds);

			new_sock = accept(conn->sock,
					conn->ai.ai_addr,
					&conn->ai.ai_addrlen);
			conn->cli[conn->cli_idx].sock = new_sock;

			FD_SET(conn->cli[conn->cli_idx].sock,
					&fds_save);
			conn->cli_idx++;
			fprintf(stderr, "accept new client, sock= %d.\n", new_sock);
		}

		idx = conn->cli_idx;
		for (i = 0; i < idx; i++) {
			if (! FD_ISSET(conn->cli[i].sock, &fds)) {
				continue;
			}

			FD_CLR(conn->cli[i].sock, &fds);
			r = read(conn->cli[i].sock, buf, BUFSIZ);
			switch (r) {
				case -1:
				case 0:
					if (r == -1) {
						fprintf(stderr, "read() failed.\n");
					} else {
						fprintf(stderr, "peer connection closed. sock= %d\n", conn->cli[i].sock);
					}
					FD_CLR(conn->cli[i].sock, &fds_save);
					conn->cli_idx--;
					continue;
				default:
					break;
			}
			buf[r] = '\0';

			c = strchr(buf, '\r');
			if (c) {
				*c = '\0';
			}
			for (c = buf; *c; c++) {
				*c = toupper(*c);
			}

			/* echo back */
			r = write(conn->cli[i].sock, buf, strlen(buf));
		}
	}

	/* XXX */

	cleanup_server(conn);

	return 0;
}

int main(int argc, char *argv[])
{
	int r;
	conn_info_t conn;

	memset(&conn, 0, sizeof(conn));

	r = create_server(NULL, ECHO_PORT, &conn);
	if (r == -1) {
		return 0;
	}

	printf("listen port= %s\n", ECHO_PORT);

	server_loop(&conn);

	return 0;
}

