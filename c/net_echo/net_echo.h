/* net_echo.h */

#ifndef _SESSION_H_
#define _SESSION_H_

#include <sys/socket.h>
#include <sys/select.h>

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <netdb.h>
#include <errno.h>
#include <ctype.h>

#define ECHO_MAX_CLIENTS 12
#define ECHO_PORT "7777"

typedef struct client_sock {
	int sock;
} client_sock_t;

typedef struct conn_info {
	int sock;
	client_sock_t cli[ECHO_MAX_CLIENTS];
	int cli_idx;
	struct addrinfo ai;
} conn_info_t;

int create_server(
	const char *hostname,
	const char *server_port,
	conn_info_t *conn);

int server_loop(conn_info_t *conn);

#endif /* _SESSION_H_ */

