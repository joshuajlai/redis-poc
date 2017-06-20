package com.juiceboxindustries.redispoc;

import java.util.*;
import redis.clients.jedis.*;

class RedisClient {

    private String host = "";
    private int port;
    private JedisCluster jedisCluster = null;

    public RedisClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void createClient(String host, int port) {
        Set<HostAndPort> jedisClusterNode = new HashSet<HostAndPort>();
        jedisClusterNode.add(new HostAndPort(host, port));
        this.jedisCluster = new JedisCluster(jedisClusterNode);
    }

    public JedisCluster connect() {
        if (null == this.jedisCluster) {
            this.createClient(this.host, this.port);
        }

        return this.jedisCluster;
    }

    public JedisCluster getClient()
    {
        if (null == this.jedisCluster) {
            this.connect();
        }
        return this.jedisCluster;
    }
}
