//package com.szt.common.utils;
//
//import com.google.gson.Gson;
//import com.szt.modules.sys.vo.QuerySysBusConfigListVO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.*;
//import org.springframework.stereotype.Component;
//
//import java.io.Serializable;
//import java.util.Map;
//import java.util.concurrent.TimeUnit;
//
///**
// * Redis工具类
// *
// * @author chenshun
// * @email sunlightcs@gmail.com
// * @date 2017-07-17 21:12
// */
//@Component
//public class RedisUtils implements Serializable {
//    @Autowired
//    private RedisTemplate<String, Object> redisTemplate;
//    @Autowired
//    private ValueOperations<String, String> valueOperations;
//    @Autowired
//    private HashOperations<String, String, Object> hashOperations;
//    @Autowired
//    private ListOperations<String, Object> listOperations;
//    @Autowired
//    private SetOperations<String, Object> setOperations;
//    @Autowired
//    private ZSetOperations<String, Object> zSetOperations;
//    /**  默认过期时长，单位：秒 */
//    public final static long DEFAULT_EXPIRE = 60 * 60 * 24;
//    /**  不设置过期时长 */
//    public final static long NOT_EXPIRE = -1;
//    private final static Gson gson = new Gson();
//
//    public void set(String key, Object value, long expire){
//        valueOperations.set(key, toJson(value));
//        if(expire != NOT_EXPIRE){
//            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
//        }
//    }
//
//    public void set(String key, Object value){
//        set(key, value, DEFAULT_EXPIRE);
//    }
//
//    public <T> T get(String key, Class<T> clazz, long expire) {
//        String value = valueOperations.get(key);
//        if(expire != NOT_EXPIRE){
//            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
//        }
//        return value == null ? null : fromJson(value, clazz);
//    }
//
//    public <T> T get(String key, Class<T> clazz) {
//        return get(key, clazz, NOT_EXPIRE);
//    }
//
//    public String get(String key, long expire) {
//        String value = valueOperations.get(key);
//        if(expire != NOT_EXPIRE){
//            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
//        }
//        return value;
//    }
//
//    public String get(String key) {
//        return get(key, NOT_EXPIRE);
//    }
//
//    public void delete(String key) {
//        redisTemplate.delete(key);
//    }
//
//    /**
//     * Object转成JSON数据
//     */
//    private String toJson(Object object){
//        if(object instanceof Integer || object instanceof Long || object instanceof Float ||
//                object instanceof Double || object instanceof Boolean || object instanceof String){
//            return String.valueOf(object);
//        }
//        return gson.toJson(object);
//    }
//
//    /**
//     * JSON数据，转成Object
//     */
//    private <T> T fromJson(String json, Class<T> clazz){
//        return gson.fromJson(json, clazz);
//    }
//    public boolean setHash(String key1, String key2, Object value) {
//        boolean result = false;
//        try {
//            this.redisTemplate.opsForHash().put(key1, key2, value);
//            result = true;
//        } catch (Exception var6) {
//            var6.printStackTrace();
//        }
//
//        return result;
//    }
//    public boolean exists(String key) {
//        return this.redisTemplate.hasKey(key);
//    }
//
//    public Object getHash(String key1, String key2) {
//        Object result = null;
//        result = this.redisTemplate.opsForHash().get(key1, key2);
//        return result;
//    }
//
//    public Object getHashs(String key) {
//        Object result = null;
//        result = this.redisTemplate.opsForHash().entries(key);
//        return result;
//    }
//    public <T> void  hSetMap(String key, Object obj){
//        System.out.println(1111);
//        redisTemplate.boundHashOps(key).putAll((Map<?, ?>) obj);
//    }
//    public <T> T  hGetMap(String key, String mapKey){
//        return (T) redisTemplate.boundHashOps(key).get(mapKey);
//    }
//    public void removeHash(String key1, String key2) {
//        if (this.exists(key1)) {
//            this.redisTemplate.opsForHash().delete(key1, new Object[]{key2});
//        }
//
//    }
//}
