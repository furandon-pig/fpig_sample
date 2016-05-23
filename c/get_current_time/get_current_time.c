/* get_current_time.c */

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(int argc, char *argv[])
{
        time_t tval;
        char buf[BUFSIZ], *s;
	struct tm *t;

        time(&tval);
	t= localtime(&tval);

	s = buf;

        s += strftime(s, BUFSIZ, "%G/", t);
        s += strftime(s, BUFSIZ, "%m/", t);
        s += strftime(s, BUFSIZ, "%d ", t);
        s += strftime(s, BUFSIZ, "%H:", t);
        s += strftime(s, BUFSIZ, "%M:", t);
        s += strftime(s, BUFSIZ, "%S", t);

	puts(buf);

        return 0;
}
