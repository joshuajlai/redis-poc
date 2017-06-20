package com.juiceboxindustries.redispoc;

import redis.clients.jedis.*;
import com.thedeanda.lorem.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

class RandomWrite {

    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            System.out.println("Usage: java -jar redis-poc.jar <host> <port>");
            System.exit(1);
        }
        String serverDns = args[0];
        String port = args[1];

        RedisClient redisClient = new RedisClient(serverDns, new Integer(port));
        redisClient.connect();

        RandomWrite randomWrite = new RandomWrite();
        while (true) {
            randomWrite.writeRandomData(redisClient);
            Thread.sleep(1000);
        }
    }

    public void writeRandomData(RedisClient redisClient) {
        JedisCluster client = redisClient.getClient();
        Date currentDate = new Date();
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Lorem lorem = LoremIpsum.getInstance();
        String someValue = lorem.getWords(5, 10);
        client.set(df.format(currentDate), someValue);
    }
}
