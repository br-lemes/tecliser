
all: Hello.class
	@echo "=== JAVA ==========================================================="
	@java Hello
	@echo "=== LUA ============================================================"
	@lua hello.lua

Hello.class: Hello.java
	@javac $^

clean:
	rm -f Hello.class

.PHONY: all clean
