
all: Main.class
	@echo "=== JAVA THREAD ===================================================="
	@java Main

Main.class: Main.java
	@javac $^

clean:
	rm -f Main.class PingPong.class

.PHONY: all clean
