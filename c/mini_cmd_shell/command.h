/*
 * command.h
 */

#ifndef _COMMAND_H_
#define _COMMAND_H_

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <ctype.h>

#define MAX_COMMAND_ARGS	16

typedef struct command {
	char *cmd;
	int cmd_len;
	int (*func)(int argc, char *argv[], void *data);
	char *help;
} command_t;

#define SKIP_CHAR(c)							\
	do {								\
		while (isprint((int)*c) && *c != ' ' && *c != '\t')	\
			c++;						\
		*c++ = '\0';						\
	} while (0)

#define SKIP_WHITE_CHAR(c)			\
	do {					\
		while (*c == ' ' || *c == '\t')	\
			c++;			\
	} while (0)

int cmd_help(int argc, char *argv[], void *data);
int parse_command(char *line, void *data);
int init_command(void);

#endif	/* _COMMAND_H_ */
