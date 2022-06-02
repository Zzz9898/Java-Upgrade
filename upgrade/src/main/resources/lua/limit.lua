local key = KEYS[1]
local period = tonumber(ARGV[1])
local current = redis.call('incr', key)
if tonumber(current) == 1 then
    redis.call('expire', key, period)
end
return tonumber(current)