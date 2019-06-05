local socket = require("socket")

local PORT = 7070 -- Se não der, 6060

local server = socket.bind("*", PORT)
print("Lua server listening to port: " .. PORT)
while true do
	local client = server:accept()
	print("\nConnection from: " .. client:getpeername())
	if client then
		local msg = client:receive()
		print("Received: " .. msg)
		if msg then
			client:send(msg:upper() .. "\n")
		end
	end
end
