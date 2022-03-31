# Redis



------

[TOC]

### 什么是NoSQL?

NoSQL，泛指非关系型的数据库。随着互联网[web2.0](https://baike.baidu.com/item/web2.0/97695)网站的兴起，传统的关系数据库在处理web2.0网站，特别是超大规模和高并发的[SNS](https://baike.baidu.com/item/SNS/10242)类型的web2.0纯[动态网](https://baike.baidu.com/item/动态网)站已经显得力不从心，出现了很多难以克服的问题，而非关系型的数据库则由于其本身的特点得到了非常迅速的发展。NoSQL数据库的产生就是为了解决大规模数据集合多重数据种类带来的挑战，特别是大数据应用难题。

```
NoSql
- 不仅仅是数据
- 没有固定的查询语言
- 键值对存储、列存储、文档存储、图形数据库等等
- 最终一致性
- 高性能、高可用、高扩展
- 无强制schema, 方便快速上手

```

### Nosql四大分类

1. **KV键值对**:

   Redis

2. **文档型数据库(bson,和json一样)**

   MongoDB

3. **列式存储**

   Hbase

4. **Graph 图形数据库**



**优缺点对比:** 

![image-20220330220113128](/home/cby/snap/typora/57/.config/Typora/typora-user-images/image-20220330220113128.png)



### Redis概述

- Redis（Remote Dictionary Server )，即远程字典服务，是一个开源的使用ANSI [C语言](https://baike.baidu.com/item/C语言)编写、支持网络、可基于内存亦可持久化的日志型、Key-Value[数据库](https://baike.baidu.com/item/数据库/103728)，并提供多种语言的API.
- redis是一个key-value[存储系统](https://baike.baidu.com/item/存储系统)。和Memcached类似，它支持存储的value类型相对更多，包括string(字符串)、list([链表](https://baike.baidu.com/item/链表))、set(集合)、zset(sorted set --有序集合)和hash（哈希类型）。这些[数据类型](https://baike.baidu.com/item/数据类型)都支持push/pop、add/remove及取交集并集和差集及更丰富的操作，而且这些操作都是原子性的。在此基础上，redis支持各种不同方式的排序。与memcached一样，为了保证效率，数据都是缓存在内存中。区别的是redis会周期性的把更新的数据写入磁盘或者把修改操作写入追加的记录文件，并且在此基础上实现了master-slave(主从)同步.
- Redis 是一个高性能的key-value数据库。 redis的出现，很大程度补偿了[memcached](https://baike.baidu.com/item/memcached)这类key/value存储的不足，在部 分场合可以对关系数据库起到很好的补充作用。它提供了Java，C/C++，C#，PHP，JavaScript，Perl，Object-C，Python，Ruby，Erlang等客户端，使用很方便

中文文档: http://www.redis.cn/commands.html

#### Redis 能做什么

1. 内存存储, 持久化 -- RDB、AOF
2. 效率高，基于内存实现数据访问，可以用于高速缓存
3. 发布订阅系统
4. 地图信息分析
5. 计时器、计数器

   ......

#### 特性

- 多样的数据类型

- 持久化

- 集群

- 事物

   ......

### 性能测试工具

自带性能测试工具 - redis benchmark 

`docker启动redis`

```
redis:
  image: redis:alpine3.13
  container_name: docker_redis
  deploy:
    resources:
      limits:
        cpus: "0.50"
        memory: 4G
      reservations:
        cpus: "0.25"
        memory: 1G
  volumes:
    - /home/${USER}/redis/data:/data
  ports:
    - 6379:6379
```

进入容器:执行 `redis-benchmark  -c 10000  -n 1000 -t get`  并发量10000,执行1000次

![](/home/cby/Pictures/Screenshot from 2022-03-31 20-46-42.png)

结果:总耗时18毫秒

