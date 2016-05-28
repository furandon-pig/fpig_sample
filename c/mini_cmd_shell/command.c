/*
 * command.c
 */

#include "command.h"

char g_cmd_buf[BUFSIZ];

command_t cmd_tbl[] = {
	{ "help", 0, cmd_help, "show help." },
	{ "?", 0, cmd_help, "show help." },
	{ NULL, 0, NULL, NULL }	/* terminate */
};

static int dispatch_command(int argc, char *argv[], void *data)
{
	int i, r;

	for (i = 0; cmd_tbl[i].cmd != NULL; i++) {
		r = strncasecmp(argv[0], cmd_tbl[i].cmd, cmd_tbl[i].cmd_len);
		if (r == 0)
			return cmd_tbl[i].func(argc, argv, data);
	}

	return -1;
}

int parse_command(char *line, void *data)
{
	int argc;
	char *argv[MAX_COMMAND_ARGS];
	char *c;

	argc = 0;
	c = strchr(line, '\n');
	if (c)
		*c = '\0';
	c = line;
	if (c == '\0')
		return 0;

	while (*c != '\0') {
		SKIP_WHITE_CHAR(c);
		argv[argc++] = c;
		SKIP_CHAR(c);
		SKIP_WHITE_CHAR(c);
	}
	argc--;	/* XXX */

	return dispatch_command(argc, argv, data);
}

int init_command(void)
{
	int i;

	for (i = 0; cmd_tbl[i].cmd != NULL; i++)
		cmd_tbl[i].cmd_len = strlen(cmd_tbl[i].cmd);

	return 0;
}

int cmd_help(int argc, char *argv[], void *data)
{
	char *c = g_cmd_buf;
	int i;

	for (i = 0; cmd_tbl[i].cmd != NULL; i++) {
		c += sprintf(c, "%s: %s\n",
				cmd_tbl[i].cmd, cmd_tbl[i].help);
	}
	printf("%s\n", g_cmd_buf);

	return 0;
}

#ifdef UNIT_TEST
int main(int argc, char *argv[])
{
	char buf[BUFSIZ];

	init_command();

	printf("Ctrl-D to quit. > ");
	while (fgets(buf, BUFSIZ, stdin)) {
		parse_command(buf, NULL);
		printf("Ctrl-D to quit. > ");
	}
	printf("\n");

	exit(EXIT_SUCCESS);
}
#endif	/* UNIT_TEST */

