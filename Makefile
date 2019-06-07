
DIRLIST=01-hello 02-thread 03-normal 04-multithread client

all:
	@for i in $(DIRLIST); do $(MAKE) -C $$i; done

clean:
	@for i in $(DIRLIST); do $(MAKE) -C $$i clean; done

.PHONY: all clean
