local socket = require("socket")
local copas = require("copas")

local PORT = 7070 -- Se não der, 6060

function handler(client)
	client = copas.wrap(client)
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

local server = socket.bind("*", PORT)
print("Servidor Lua multithread escutando na porta: " .. PORT)
copas.addserver(server, handler)
copas.loop()
