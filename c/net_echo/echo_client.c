/* echo_client.c */

#include "net_echo.h"

int connect_server(const char *hostname, const char *server_port)
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

		r = connect(sock, res->ai_addr, res->ai_addrlen);
		if (r < 0) {
			close(sock);
			cause = "connect() failed.";
				continue;
		}
		break;
	}
	freeaddrinfo(res0);
	if (r < 0) {
		return -1;
	}

	return sock;
}

int main(int argc, char *argv[])
{
	char buf[BUFSIZ], buf2[BUFSIZ];
	conn_info_t conn;
	int sock, r;
	char *c;

	memset(&conn, 0, sizeof(conn));

	sock = connect_server("localhost", ECHO_PORT);
	if (sock == -1) {
		return 0;
	}

	printf("echo> ");
	while (fgets(buf, BUFSIZ, stdin)) {
		c = strchr(buf, '\n');
		if (c) {
			*c = '\0';
		}

		write(sock, buf, strlen(buf));
		r = read(sock, buf2, BUFSIZ);
		if (r != -1) {
			buf2[r] = '\0';
			printf("%s\n", buf2);
		}

		printf("echo> ");
	}
	printf("\n");

	close(sock);

	return 0;
}

