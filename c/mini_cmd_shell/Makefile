# Makefile

BIN	= command
SRC	= $(BIN).c

CC	= gcc
DEBUG	= -Wall -Werror -g
CFLAGS	= -DUNIT_TEST
LIBS	=

all: $(SRC)
	$(CC) $(DEBUG) -o $(BIN) $(SRC) $(CFLAGS) $(LIBS)

clean:
	rm $(BIN)

run:
	./$(BIN)

rebuild:
	make clean
	make all

