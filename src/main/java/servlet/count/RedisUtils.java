package servlet.count;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.exceptions.JedisConnectionException;

public enum RedisUtils {
    //枚举单例
    INSTANCE;

    private final JedisPool pool;
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 6379;
    //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8
    private static final int MAX_IDLE = 5;
    //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态exhausted(耗尽)。
    private static final int MAX_ACTIVE = 10;
    //等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时,如果超过等待时间，则直接抛出JedisConnectionException；
    private static final long MAX_WAIT = 10000;
    //设置客户端连接时的超时时间，单位为秒。当客户端在这段时间内没有发出任何指令，那么关闭该连接设置客户端连接时的超时时间，单位为秒。
    //当客户端在这段时间内没有发出任何指令，那么关闭该连接。
    private static final int TIMEOUT = 10000;

    private RedisUtils() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(MAX_IDLE);
        config.setMaxTotal(MAX_ACTIVE);
        config.setMaxWaitMillis(MAX_WAIT);
        pool = new JedisPool(config, HOST, PORT, TIMEOUT, null);
    }

    /**
     * redis的key自增1
     *
     * @param key
     */
    public void incr(String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            jedis.incr(key);
            pool.returnResource(jedis);
        } catch (JedisConnectionException e) {
            if (null != jedis) {
                pool.returnBrokenResource(jedis);
            }
            throw new JedisConnectionException(e);
        }
    }

    /**
     * 获得key的值
     *
     * @param key
     * @return
     */
    public String get(String key) {
        String result = null;
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            result = jedis.get(key);
            pool.returnResource(jedis);
        } catch (JedisConnectionException e) {
            if (null != jedis) {
                pool.returnBrokenResource(jedis);
            }
            throw new JedisConnectionException(e);
        }
        return result;
    }
}
