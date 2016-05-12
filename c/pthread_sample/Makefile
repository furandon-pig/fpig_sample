# Makefile

BIN=pthread_sample
SRC=$(BIN).c

CC=gcc
DEBUG=-Wall -Werror -g
CFLAGS=
LIBS=-lpthread

all: $(SRC)
	$(CC) $(DEBUG) -o $(BIN) $(SRC) $(CFLAGS) $(LIBS)

clean:
	rm $(BIN)

rebuild:
	make clean
	make all

