package com.ps.ehcache.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.List;
// DEMO from  https://www.youtube.com/watch?v=5WZKx4UbUfU&index=15&list=PLLPovsDEpByYrLQOLxlqQFWIlZV2314y_
// useless for this demo1 project

//@Configuration
//@PropertySource(value = "classpath:redis.properties")
public class RedisConfig {
    @Value("${redis.maxTotal}")
    private Integer redisMaxTotal;
    @Value("${redis.node1.host}")
    private String redisNode1Host;
    @Value("${redis.node1.port}")
    private String redisNode1Port;

    private JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(this.redisMaxTotal);
        return jedisPoolConfig;
    }
    @Bean
    public ShardedJedisPool shardedJedisPool(){
        List<JedisShardInfo> jedisShardInfoList = new ArrayList<>();
        jedisShardInfoList.add(new JedisShardInfo(redisNode1Host,redisNode1Port));
        return new ShardedJedisPool(jedisPoolConfig(),jedisShardInfoList);
    }
}
