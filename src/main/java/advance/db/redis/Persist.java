/*
 * Copyright (c) 2018, 2018, Travel and/or its affiliates. All rights reserved.
 * TRAVEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package advance.db.redis;

import redis.clients.jedis.*;
import redis.clients.jedis.params.geo.GeoRadiusParam;
import redis.clients.jedis.params.sortedset.ZAddParams;
import redis.clients.jedis.params.sortedset.ZIncrByParams;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author flysLi
 * @ClassName Persist
 * @Decription TODO
 * @Date 2019/1/28 14:18
 * @Version 1.0
 */
public class Persist implements JedisCommands {
    static final String host = "localhost";

    public static void main(String[] args) {
        Jedis jedis = new Jedis(host, 6380);
        long s = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            jedis.set("kew" + i, "val" + i);
        }
        jedis.close();
        long e = System.currentTimeMillis();
        System.out.println("time:\t" + (e - s));
    }

    @Override
    public String set(String s, String s1) {
        return null;
    }

    @Override
    public String set(String s, String s1, String s2, String s3, long l) {
        return null;
    }

    @Override
    public String set(String s, String s1, String s2) {
        return null;
    }

    @Override
    public String get(String s) {
        return null;
    }

    @Override
    public Boolean exists(String s) {
        return null;
    }

    @Override
    public Long persist(String s) {
        return null;
    }

    @Override
    public String type(String s) {
        return null;
    }

    @Override
    public Long expire(String s, int i) {
        return null;
    }

    @Override
    public Long pexpire(String s, long l) {
        return null;
    }

    @Override
    public Long expireAt(String s, long l) {
        return null;
    }

    @Override
    public Long pexpireAt(String s, long l) {
        return null;
    }

    @Override
    public Long ttl(String s) {
        return null;
    }

    @Override
    public Long pttl(String s) {
        return null;
    }

    @Override
    public Boolean setbit(String s, long l, boolean b) {
        return null;
    }

    @Override
    public Boolean setbit(String s, long l, String s1) {
        return null;
    }

    @Override
    public Boolean getbit(String s, long l) {
        return null;
    }

    @Override
    public Long setrange(String s, long l, String s1) {
        return null;
    }

    @Override
    public String getrange(String s, long l, long l1) {
        return null;
    }

    @Override
    public String getSet(String s, String s1) {
        return null;
    }

    @Override
    public Long setnx(String s, String s1) {
        return null;
    }

    @Override
    public String setex(String s, int i, String s1) {
        return null;
    }

    @Override
    public String psetex(String s, long l, String s1) {
        return null;
    }

    @Override
    public Long decrBy(String s, long l) {
        return null;
    }

    @Override
    public Long decr(String s) {
        return null;
    }

    @Override
    public Long incrBy(String s, long l) {
        return null;
    }

    @Override
    public Double incrByFloat(String s, double v) {
        return null;
    }

    @Override
    public Long incr(String s) {
        return null;
    }

    @Override
    public Long append(String s, String s1) {
        return null;
    }

    @Override
    public String substr(String s, int i, int i1) {
        return null;
    }

    @Override
    public Long hset(String s, String s1, String s2) {
        return null;
    }

    @Override
    public String hget(String s, String s1) {
        return null;
    }

    @Override
    public Long hsetnx(String s, String s1, String s2) {
        return null;
    }

    @Override
    public String hmset(String s, Map<String, String> map) {
        return null;
    }

    @Override
    public List<String> hmget(String s, String... strings) {
        return null;
    }

    @Override
    public Long hincrBy(String s, String s1, long l) {
        return null;
    }

    @Override
    public Double hincrByFloat(String s, String s1, double v) {
        return null;
    }

    @Override
    public Boolean hexists(String s, String s1) {
        return null;
    }

    @Override
    public Long hdel(String s, String... strings) {
        return null;
    }

    @Override
    public Long hlen(String s) {
        return null;
    }

    @Override
    public Set<String> hkeys(String s) {
        return null;
    }

    @Override
    public List<String> hvals(String s) {
        return null;
    }

    @Override
    public Map<String, String> hgetAll(String s) {
        return null;
    }

    @Override
    public Long rpush(String s, String... strings) {
        return null;
    }

    @Override
    public Long lpush(String s, String... strings) {
        return null;
    }

    @Override
    public Long llen(String s) {
        return null;
    }

    @Override
    public List<String> lrange(String s, long l, long l1) {
        return null;
    }

    @Override
    public String ltrim(String s, long l, long l1) {
        return null;
    }

    @Override
    public String lindex(String s, long l) {
        return null;
    }

    @Override
    public String lset(String s, long l, String s1) {
        return null;
    }

    @Override
    public Long lrem(String s, long l, String s1) {
        return null;
    }

    @Override
    public String lpop(String s) {
        return null;
    }

    @Override
    public String rpop(String s) {
        return null;
    }

    @Override
    public Long sadd(String s, String... strings) {
        return null;
    }

    @Override
    public Set<String> smembers(String s) {
        return null;
    }

    @Override
    public Long srem(String s, String... strings) {
        return null;
    }

    @Override
    public String spop(String s) {
        return null;
    }

    @Override
    public Set<String> spop(String s, long l) {
        return null;
    }

    @Override
    public Long scard(String s) {
        return null;
    }

    @Override
    public Boolean sismember(String s, String s1) {
        return null;
    }

    @Override
    public String srandmember(String s) {
        return null;
    }

    @Override
    public List<String> srandmember(String s, int i) {
        return null;
    }

    @Override
    public Long strlen(String s) {
        return null;
    }

    @Override
    public Long zadd(String s, double v, String s1) {
        return null;
    }

    @Override
    public Long zadd(String s, double v, String s1, ZAddParams zAddParams) {
        return null;
    }

    @Override
    public Long zadd(String s, Map<String, Double> map) {
        return null;
    }

    @Override
    public Long zadd(String s, Map<String, Double> map, ZAddParams zAddParams) {
        return null;
    }

    @Override
    public Set<String> zrange(String s, long l, long l1) {
        return null;
    }

    @Override
    public Long zrem(String s, String... strings) {
        return null;
    }

    @Override
    public Double zincrby(String s, double v, String s1) {
        return null;
    }

    @Override
    public Double zincrby(String s, double v, String s1, ZIncrByParams zIncrByParams) {
        return null;
    }

    @Override
    public Long zrank(String s, String s1) {
        return null;
    }

    @Override
    public Long zrevrank(String s, String s1) {
        return null;
    }

    @Override
    public Set<String> zrevrange(String s, long l, long l1) {
        return null;
    }

    @Override
    public Set<Tuple> zrangeWithScores(String s, long l, long l1) {
        return null;
    }

    @Override
    public Set<Tuple> zrevrangeWithScores(String s, long l, long l1) {
        return null;
    }

    @Override
    public Long zcard(String s) {
        return null;
    }

    @Override
    public Double zscore(String s, String s1) {
        return null;
    }

    @Override
    public List<String> sort(String s) {
        return null;
    }

    @Override
    public List<String> sort(String s, SortingParams sortingParams) {
        return null;
    }

    @Override
    public Long zcount(String s, double v, double v1) {
        return null;
    }

    @Override
    public Long zcount(String s, String s1, String s2) {
        return null;
    }

    @Override
    public Set<String> zrangeByScore(String s, double v, double v1) {
        return null;
    }

    @Override
    public Set<String> zrangeByScore(String s, String s1, String s2) {
        return null;
    }

    @Override
    public Set<String> zrevrangeByScore(String s, double v, double v1) {
        return null;
    }

    @Override
    public Set<String> zrangeByScore(String s, double v, double v1, int i, int i1) {
        return null;
    }

    @Override
    public Set<String> zrevrangeByScore(String s, String s1, String s2) {
        return null;
    }

    @Override
    public Set<String> zrangeByScore(String s, String s1, String s2, int i, int i1) {
        return null;
    }

    @Override
    public Set<String> zrevrangeByScore(String s, double v, double v1, int i, int i1) {
        return null;
    }

    @Override
    public Set<Tuple> zrangeByScoreWithScores(String s, double v, double v1) {
        return null;
    }

    @Override
    public Set<Tuple> zrevrangeByScoreWithScores(String s, double v, double v1) {
        return null;
    }

    @Override
    public Set<Tuple> zrangeByScoreWithScores(String s, double v, double v1, int i, int i1) {
        return null;
    }

    @Override
    public Set<String> zrevrangeByScore(String s, String s1, String s2, int i, int i1) {
        return null;
    }

    @Override
    public Set<Tuple> zrangeByScoreWithScores(String s, String s1, String s2) {
        return null;
    }

    @Override
    public Set<Tuple> zrevrangeByScoreWithScores(String s, String s1, String s2) {
        return null;
    }

    @Override
    public Set<Tuple> zrangeByScoreWithScores(String s, String s1, String s2, int i, int i1) {
        return null;
    }

    @Override
    public Set<Tuple> zrevrangeByScoreWithScores(String s, double v, double v1, int i, int i1) {
        return null;
    }

    @Override
    public Set<Tuple> zrevrangeByScoreWithScores(String s, String s1, String s2, int i, int i1) {
        return null;
    }

    @Override
    public Long zremrangeByRank(String s, long l, long l1) {
        return null;
    }

    @Override
    public Long zremrangeByScore(String s, double v, double v1) {
        return null;
    }

    @Override
    public Long zremrangeByScore(String s, String s1, String s2) {
        return null;
    }

    @Override
    public Long zlexcount(String s, String s1, String s2) {
        return null;
    }

    @Override
    public Set<String> zrangeByLex(String s, String s1, String s2) {
        return null;
    }

    @Override
    public Set<String> zrangeByLex(String s, String s1, String s2, int i, int i1) {
        return null;
    }

    @Override
    public Set<String> zrevrangeByLex(String s, String s1, String s2) {
        return null;
    }

    @Override
    public Set<String> zrevrangeByLex(String s, String s1, String s2, int i, int i1) {
        return null;
    }

    @Override
    public Long zremrangeByLex(String s, String s1, String s2) {
        return null;
    }

    @Override
    public Long linsert(String s, BinaryClient.LIST_POSITION list_position, String s1, String s2) {
        return null;
    }

    @Override
    public Long lpushx(String s, String... strings) {
        return null;
    }

    @Override
    public Long rpushx(String s, String... strings) {
        return null;
    }

    @Override
    public List<String> blpop(String s) {
        return null;
    }

    @Override
    public List<String> blpop(int i, String s) {
        return null;
    }

    @Override
    public List<String> brpop(String s) {
        return null;
    }

    @Override
    public List<String> brpop(int i, String s) {
        return null;
    }

    @Override
    public Long del(String s) {
        return null;
    }

    @Override
    public String echo(String s) {
        return null;
    }

    @Override
    public Long move(String s, int i) {
        return null;
    }

    @Override
    public Long bitcount(String s) {
        return null;
    }

    @Override
    public Long bitcount(String s, long l, long l1) {
        return null;
    }

    @Override
    public Long bitpos(String s, boolean b) {
        return null;
    }

    @Override
    public Long bitpos(String s, boolean b, BitPosParams bitPosParams) {
        return null;
    }

    @Override
    public ScanResult<Map.Entry<String, String>> hscan(String s, int i) {
        return null;
    }

    @Override
    public ScanResult<String> sscan(String s, int i) {
        return null;
    }

    @Override
    public ScanResult<Tuple> zscan(String s, int i) {
        return null;
    }

    @Override
    public ScanResult<Map.Entry<String, String>> hscan(String s, String s1) {
        return null;
    }

    @Override
    public ScanResult<Map.Entry<String, String>> hscan(String s, String s1, ScanParams scanParams) {
        return null;
    }

    @Override
    public ScanResult<String> sscan(String s, String s1) {
        return null;
    }

    @Override
    public ScanResult<String> sscan(String s, String s1, ScanParams scanParams) {
        return null;
    }

    @Override
    public ScanResult<Tuple> zscan(String s, String s1) {
        return null;
    }

    @Override
    public ScanResult<Tuple> zscan(String s, String s1, ScanParams scanParams) {
        return null;
    }

    @Override
    public Long pfadd(String s, String... strings) {
        return null;
    }

    @Override
    public long pfcount(String s) {
        return 0;
    }

    @Override
    public Long geoadd(String s, double v, double v1, String s1) {
        return null;
    }

    @Override
    public Long geoadd(String s, Map<String, GeoCoordinate> map) {
        return null;
    }

    @Override
    public Double geodist(String s, String s1, String s2) {
        return null;
    }

    @Override
    public Double geodist(String s, String s1, String s2, GeoUnit geoUnit) {
        return null;
    }

    @Override
    public List<String> geohash(String s, String... strings) {
        return null;
    }

    @Override
    public List<GeoCoordinate> geopos(String s, String... strings) {
        return null;
    }

    @Override
    public List<GeoRadiusResponse> georadius(String s, double v, double v1, double v2, GeoUnit geoUnit) {
        return null;
    }

    @Override
    public List<GeoRadiusResponse> georadius(String s, double v, double v1, double v2, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam) {
        return null;
    }

    @Override
    public List<GeoRadiusResponse> georadiusByMember(String s, String s1, double v, GeoUnit geoUnit) {
        return null;
    }

    @Override
    public List<GeoRadiusResponse> georadiusByMember(String s, String s1, double v, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam) {
        return null;
    }

    @Override
    public List<Long> bitfield(String s, String... strings) {
        return null;
    }
}
