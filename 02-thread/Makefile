
all:
	@make -sC Thread
	@make -sC Runnable
	@echo "=== LUA (COPAS) ===================================================="
	@lua thread.lua

clean:
	@make -sC Thread clean
	@make -sC Runnable clean

.PHONY: all clean
