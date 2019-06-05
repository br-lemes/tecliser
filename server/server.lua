local socket = require("socket")

local server = socket.bind("*", 7070) -- Se não der, 6060
while true do
	local client = server:accept()
	print("Connection from: " .. client:getpeername())
	if client then
		local msg = client:receive()
		print("Received: " .. msg)
		if msg then
			client:send(msg:upper() .. "\n")
		end
	end
end
