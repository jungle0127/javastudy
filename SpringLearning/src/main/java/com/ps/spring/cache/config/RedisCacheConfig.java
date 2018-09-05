package com.ps.spring.cache.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

@Configuration
@EnableAutoConfiguration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {
	@Value("${spring.redis.host}")
	private String host;

	@Value("${spring.redis.port}")
	private int port;

	@Value("${spring.redis.timeout}")
	private int timeout;

	@Value("${spring.redis.database}")
	private int database;

	@Value("${spring.redis.password}")
	private String password;
	
	@Value("${spring.redis.sentinel.nodes}")
	private String redisNodes;

	@Value("${spring.redis.sentinel.master}")
	private String master;

	/**
	 * redis哨兵配置
	 * 
	 * @return
	 */
	@Bean
	public RedisSentinelConfiguration redisSentinelConfiguration() {
		RedisSentinelConfiguration configuration = new RedisSentinelConfiguration();
		String[] host = redisNodes.split(",");
		for (String redisHost : host) {
			String[] item = redisHost.split(":");
			String ip = item[0];
			String port = item[1];
			configuration.addSentinel(new RedisNode(ip, Integer.parseInt(port)));
		}
		configuration.setMaster(master);
		return configuration;
	}

	public JedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory factory = new JedisConnectionFactory(redisSentinelConfiguration());
	}
}
