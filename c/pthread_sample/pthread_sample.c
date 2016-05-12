/* pthread_sample.c */

#include <stdio.h>
#include <unistd.h>
#include <pthread.h>

volatile static int g_count = 0;
volatile static int g_flg_active = 1;

void *th_handler(void *arg)
{
	while (g_flg_active) {
		g_count++;
		sleep(1);
	}

	return NULL;
}

int main(int argc, char *argv[])
{
	char line[BUFSIZ];
	pthread_t pt;

	pthread_create(&pt, NULL, th_handler, (void *)NULL);

	printf("Ctrl-D to quit. > ");
	while (fgets(line, BUFSIZ, stdin)) {
		printf("%s", line);
		printf("Ctrl-D to quit. > ");
	}
	puts("");

	g_flg_active = 0;
	pthread_join(pt, NULL);

	printf("count= %d\n", g_count);

	return 0;
}

