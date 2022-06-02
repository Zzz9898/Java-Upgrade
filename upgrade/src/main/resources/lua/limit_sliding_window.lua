local key = KEYS[1];
local period = ARGV[1];
local now_time = ARGV[2];
local before_time = ARGV[3];
local count = ARGV[4];
redis.call("zadd", key, now_time, now_time);
redis.call("zremrangebyscore", key, 0, before_time);
local current = redis.call("zcard", key);
if tonumber(current) > tonumber(count) then
    redis.call('zrem', key, now_time)
else
    redis.call("expire", key, period);
end
return current;