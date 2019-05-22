
all: Hello.class
	@java Hello
	@lua hello.lua

Hello.class: Hello.java
	javac $^

clean:
	rm Hello.class

.PHONY: all clean
