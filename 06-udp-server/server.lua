local socket = require("socket")

local PORT = 7070 -- Se não der, 6060

local server = socket.udp()
server:setsockname("*", PORT)
print("Servidor UDP Lua escutando na porta: " .. PORT)
while true do
	local msg, ip, port = server:receivefrom()
	if  msg then
		print(string.format("Recebido de %s: %s", ip, msg))
		server:sendto(msg:upper(), ip, port)
	end
end
