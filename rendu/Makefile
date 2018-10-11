NAME	=	avaj_launcher

SRCDIR	=	.
SRC		=	Main.java

SRCS	=	$(addprefix $(CDIR), $(CRES))
CLASSES	=	$(SRCS:.java=.class)

JFLAGS	=	-sourcepath @sources.txt
JC		=	/usr/bin/javac

FFLAGS	=	. -name '*.java' > sources.txt
FIND	=	/usr/bin/find

RM		=	/bin/rm -rf
ECHO	=	/usr/bin/printf

all			:	$(NAME)

.java.class	:
				$(JC) $(JFLAGS) $(SRCS)

$(NAME)		:
				$(FIND) $(FFLAGS)
				$(JC) $(JFLAGS)
				@$(ECHO) "\033[32m> Executable compiled\033[0m\n"

clean		:
				@$(RM) $(CLASSES)
				@$(ECHO) "\033[31m> Directory cleaned\033[0m\n"

fclean		:	clean
				@$(RM) $(NAME)
				@$(ECHO) "\033[31m> Removed executable\033[0m\n"

re			:	fclean all

.SUFFIXES	:	.java .class
.PHONY		:	all clean fclean re .classes

.DEFAULT_GOAL	:=	all