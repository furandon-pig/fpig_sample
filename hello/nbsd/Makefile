.include <bsd.own.mk>

.if exists(${MACHINE_ARCH}.s)
PROG=		hello
MAN=		# empty
LDFLAGS=	-nostdlib
SRCS=		${MACHINE_ARCH}.s
.endif

.include <bsd.prog.mk>
