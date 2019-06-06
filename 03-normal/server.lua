local socket = require("socket")

local PORT = 7070 -- Se não der, 6060

local server = socket.bind("*", PORT)
print("Servidor Lua escutando na porta: " .. PORT)
while true do
	local client = server:accept()
	print("\nConexão de: " .. client:getpeername())
	if client then
		local msg = client:receive()
		print("Recebido: " .. msg)
		if msg then
			client:send(msg:upper() .. "\n")
		end
	end
end
