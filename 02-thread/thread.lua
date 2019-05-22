
local copas = require("copas")

function pingpong(msg, delay)
	for i = 1, 10 do
		print(msg)
		copas.sleep(delay)
	end
end

copas.addthread(pingpong, "*** Ping ***", 0.033)
copas.addthread(pingpong, "=== Pong ===", 0.100)

copas.loop()
