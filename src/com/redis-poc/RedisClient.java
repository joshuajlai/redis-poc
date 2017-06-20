package com.redis-poc;

import redis.clients.jedis.*;

class RedisClient {

    private string host = "";
    private int port = null;
    private JedisCluster jedisCluster = null;

    public function RedisClient(string host, int port) {
        this.host = host;
        this.port = port;
    }

    public function createClient(string host, int port) {
        Set<HostAndPort> jedisClusterNode = new HashSet<HostAndPort>();
        jedisClusterNode.add(new HostAndPort(host, port));
        this.jedisCluster = new JedisCluster(jedisClusterNode);
    }

    public function connect() {
        if (null == this.jedisCluster) {
            this.createClient(this.host, this.port);
        }

        return this.jedisCluster;
    }

    public function getClient()
    {
        if (null == this.jedisCluster) {
            this.connect();
        }
        return this.jedisCluster;
    }
}
