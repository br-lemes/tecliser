local socket = require("socket")

local PORT = 7070 -- Se não der, 6060
local SERVER = "localhost"

local client = socket.udp()
client:setpeername(SERVER, PORT)
local msg
if arg[1] then
	msg = arg[1]
else
	io.stdout:write("Digite uma mensagem: ")
	msg = io.stdin:read("*l")
end
client:send(msg)
print(string.format("Datagrama UDP enviado para %s:%d", SERVER, PORT))
local msg, e = client:receive()
client:close()
if msg then
	print(string.format("Resposta: %s", msg))
else
	print(string.format("Sem resposta: %s", e))
end
