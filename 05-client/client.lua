local socket = require("socket")

local PORT = 7070 -- Se não der, 6060
local SERVER = "localhost"

local client = socket.tcp()
local r, e = client:connect(SERVER, PORT)
client:settimeout(10)
if r then
	print(string.format("Conectado em %s:%d", SERVER, PORT))
	if arg[1] then
		client:send(arg[1] .. "\n")
	else
		io.stdout:write("Digite uma mensagem: ")
		local msg = io.stdin:read("*l")
		client:send(msg .. "\n")
	end
	local msg, e = client:receive()
	client:close()
	if msg then
		print(string.format("Resposta: %s", msg))
	else
		print(string.format("Sem resposta: %s", e))
	end
else
	print(string.format("Não foi possível conectar em %s:%d => %s", SERVER, PORT, e))
end
