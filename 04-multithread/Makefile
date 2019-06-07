
all: Handler.class Server.class

Handler.class: Handler.java
	javac $^

Server.class: Server.java
	javac $^

clean:
	rm -f Handler.class Server.class

.PHONY: all clean
