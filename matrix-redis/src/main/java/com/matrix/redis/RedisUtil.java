package com.matrix.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 功能：Redis连接池
 *
 * @author matrix
 * @version 1.0
 * @date 2016年3月15日
 */
public class RedisUtil {

	/**
	 * Redis服务器地址
	 */
	private static String IP = "192.168.1.118";

	/**
	 * Redis的端口号
	 */
	private static int PORT = 6379;

	/**
	 * 访问redis服务密码
	 */
	private static String AUTH = "111111";

	/**
	 * 可用链接实例的最大数目，默认为8；如果赋值为-1，表示不限制；如果pool已经分配了maxActive个jedis实例，
	 * 则此时pool的状态为exhausted(耗尽)。
	 */
	private static int MAX_ACTIVE = 1024;

	/**
	 * 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
	 */
	private static int MAX_IDLE = 200;

	/**
	 * 等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
	 */
	private static int MAX_WAIT = 1000;

	/**
	 * 连接超时时间
	 */
	private static int TIMEOUT = 10000;

	/**
	 * 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
	 */
	private static boolean TEST_ON_BORROW = true;

	private static JedisPool jedisPool = null;

	/**
	 * 初始化Redis连接池
	 */
	static {
		try {
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxWaitMillis(MAX_WAIT);
			config.setMaxIdle(MAX_IDLE);
			config.setTestOnBorrow(TEST_ON_BORROW);
			config.setMaxTotal(MAX_ACTIVE);
			jedisPool = new JedisPool(config, IP, PORT, TIMEOUT, AUTH);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 获取jedis实例
	 * 
	 * @return
	 */
	public synchronized static Jedis getJedis() {
		try {
			if (jedisPool != null) {
				Jedis jedis = jedisPool.getResource();
				return jedis;
			} else {
				throw new RuntimeException();
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	/**
	 * 释放reids资源
	 * 
	 * @param jedis
	 */
	public static void returnResource(final Jedis jedis) {
		if (jedis != null) {
			jedis.close();
		}
	}

}
