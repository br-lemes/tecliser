local socket = require("socket")

local PORT = 7070 -- Se não der, 6060

local server = socket.bind("*", PORT)
print("Servidor Lua escutando na porta: " .. PORT)
while true do
	local client = server:accept()
	local address = client:getpeername()
	print("Conexão de: " .. address)
	if client then
		local msg = client:receive()
		print(string.format("Recebido de %s: %s", address, msg))
		if msg then
			client:send(msg:upper() .. "\n")
		end
	end
end
