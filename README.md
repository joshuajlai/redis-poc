# redis-poc [![Build Status][travis:svg]][travis]

A Redis Cluster connection via Jedis proof-of-concept in Java.

This Java application will inject random data into a Redis Cluster running in _actual Redis Cluster mode_, as opposed to
the legacy way of clustering/sharding Redis through a proxy or on the clients. This has been tested against Redis
Cluster 3.2.8 with three primary write nodes; replication has been confirmed as working when writing to primaries.

## Compilation

This project uses Maven for building. To build a "fat jar," please execute:

```
$ mvn package install
```

An archive will be created in `target/redis-poc-${version}.jar` which is runnable directly.

## Execution

To execute this project, please simply pass the `-jar` option to `java`, provided that you have Java 8, and a Redis
Cluster host and port over TCP:

```
$ VERSION=0.1
$ java -jar target/redis-poc-${VERSION}.jar redis.domain.com:6379
```

This will now connect to `redis.domain.com` on the default Redis port, `6379` and will start dumping random data into
Redis Cluster.

 [travis]: https://travis-ci.org/joshuajlai/redis-poc
 [travis:svg]: https://travis-ci.org/joshuajlai/redis-poc.svg?branch=develop
