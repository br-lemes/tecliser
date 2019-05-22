
all: Hello.class
	@echo "=== JAVA ==========================================================="
	@java Hello
	@echo "=== LUA  ==========================================================="
	@lua hello.lua

Hello.class: Hello.java
	@javac $^

clean:
	rm Hello.class

.PHONY: all clean
