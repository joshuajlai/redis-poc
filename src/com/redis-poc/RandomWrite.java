package com.redis-poc;

import redis.clients.jedis.*;

class RandomWrite {

    public void main(String[] args) {
        if (args.length < 2) {
            sys.println("Usage: java -jar redis-poc.jar <host> <port>")
        }
        String serverDns = args[0];
        int port = args[1];
        redisClient = new GrindrRedisClient(serverDns, port);
        redisClient->connect();
        while (true) {
            this.writeRandomData(redisClient);
        }
    }

    public void writeRandomData(GrindrRedisClient redisClient) {
        JedisCluster client = redisClient.getClient()
        Date currentDate = new Date();
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Lorem lorem = LoremIpsum.getInstance();
        String someValue = lorem.getWords(5, 10);
        client.set(df.format(currentDate), someValue);
    }
}
