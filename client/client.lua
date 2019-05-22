local socket = require("socket")

local client = socket.tcp()
client:connect("localhost", 7070)
client:send("hello world!\n")
local msg = client:receive()
client:close()

print(msg)
