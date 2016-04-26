# Makefile

CC	= gcc
DEBUG	= -Wall -Werror -g
CFLAGS	=
LIBS	=

all:
	make server
	make client

server: echo_server.c
	$(CC) -o echo_server echo_server.c $(CFLAGS) $(LIBS)

client: echo_client.c
	$(CC) -o echo_client echo_client.c $(CFLAGS) $(LIBS)

clean:
	rm echo_server

rebuild:
	make clean
	make all

