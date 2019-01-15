package com.szt.config;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Component
public  class RedisUtil implements Serializable{

//    @Autowired
//     private RedisTemplate redisTemplate;
        @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private HashOperations<String, String, Object> hashOperations;
    @Autowired
    private ListOperations<String, Object> listOperations;
    @Autowired
    private SetOperations<String, Object> setOperations;
    @Autowired
    private ZSetOperations<String, Object> zSetOperations;
    /**  默认过期时长，单位：秒 */
    public final static long DEFAULT_EXPIRE = 60 * 60 * 24;
    /**  不设置过期时长 */
    public final static long NOT_EXPIRE = -1;
    private final static Gson gson = new Gson();
    public RedisUtil() {
    }
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory)
    {
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setKeySerializer(jackson2JsonRedisSerializer);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.setHashKeySerializer(jackson2JsonRedisSerializer);
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }

    public void remove(String... keys) {
        String[] var2 = keys;
        int var3 = keys.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String key = var2[var4];
            this.remove(key);
        }

    }

//    public void removePattern(String pattern) {
//        Set<Serializable> keys = this.redisTemplate.keys(pattern);
//        if (keys.size() > 0) {
//            this.redisTemplate.delete(keys);
//        }
//
//    }

    public void remove(String key) {
        if (this.exists(key)) {
            this.redisTemplate.delete(key);
        }

    }
//
//    public boolean exists(String key) {
//        return this.redisTemplate.hasKey(key);
//    }
    /**
     * JSON数据，转成Object
     */
    private <T> T fromJson(String json, Class<T> clazz){
        return gson.fromJson(json, clazz);
    }

    public boolean setHash(String key1, String key2, Object value) {
        boolean result = false;
        try {
            hashOperations.put(key1, key2, value);
            result = true;
        } catch (Exception var6) {
            var6.printStackTrace();
        }

        return result;
    }
    public boolean exists(String key) {
        return this.redisTemplate.hasKey(key);
    }
        public <T> T get(String key, Class<T> clazz) {
        return get(key, clazz, NOT_EXPIRE);
    }

    public Object get(String key) {
        Object result = null;
        ValueOperations<String, Object> operations = this.redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }
        public <T> T get(String key, Class<T> clazz, long expire) {
        T value = (T) this.redisTemplate.opsForValue().get(key);
//        if(expire != NOT_EXPIRE){
//            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
//        }
        return value;
    }
    public boolean set(String key, Object value) {
        boolean result = false;
    //    redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(SysUserEntity.class));
        try {
            redisTemplate.opsForValue().set(key, value);
            result = true;
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        return result;
    }
    public  boolean setObjec(String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<String, Object> operations = this.redisTemplate.opsForValue();
            operations.set(key, JSON.toJSONString(value));
            result = true;
        } catch (Exception var5) {
            var5.printStackTrace();
        }
        return result;
    }


    public boolean set(String key, Object value, Long expireTime) {
        boolean result = false;

        try {
            ValueOperations<String, Object> operations = this.redisTemplate.opsForValue();
            operations.set(key, value);
            this.redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception var6) {
            var6.printStackTrace();
        }

        return result;
    }
    public <T> boolean setList(String key, List<T> value) {
        boolean result = false;
        try {
            listOperations.leftPushAll(key,value.toArray());
            result = true;
        } catch (Exception var6) {
            var6.printStackTrace();
        }

        return result;
    }
    public <T> List<T> getList(String key) {
        List<T> list=new ArrayList<T>();
        try {
            list = (List<T>) listOperations.range(key,0,-1);
        } catch (Exception var6) {
            var6.printStackTrace();
        }

        return list;
    }
//    public Object getHashs(String key) {
//        Object result = null;
//        result = this.redisTemplate.opsForHash().entries(key);
//        return result;
//    }
    public <T> void  hSetMap(String key, Map<String, T> map){
        hashOperations.putAll(key,map);
    }
    public <T> T  hGetMap(String key, String mapKey){
        return (T) hashOperations.get(key,mapKey);
    }

    public <T> T  hGetMap(String key){
        Map<String, Object> maps  = hashOperations.entries(key);
        return (T)  maps;
    }
    public void deleteMap(String key,String mapKey){
        hashOperations.delete(key,mapKey);
    }
    public Object getHash(String key1, String key2) {
        Object result = null;
        result = this.redisTemplate.opsForHash().get(key1, key2);
        return result;
    }

    public Object getHashs(String key) {
        Object result = null;
        result = this.redisTemplate.opsForHash().entries(key);
        return result;
    }



    public void delete(String key) {
        redisTemplate.delete(key);
    }
}
