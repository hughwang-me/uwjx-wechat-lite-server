package com.uwjx.wechat.lite.server.service.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author wanghuan
 * @link https://huan.uwjx.com
 * @date 2021/5/26 20:09
 */
@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    
    public List<String> keys(String pattern) {
        if (this.redisTemplate == null) {
            return null;
        } else {
            try {
                Set<String> set = this.redisTemplate.keys(pattern);
                assert set != null;
                return Lists.newArrayList(set);
            } catch (Exception var3) {
                var3.printStackTrace();
                return null;
            }
        }
    }

    
    public boolean hasKey(String key) {
        try {
            return this.redisTemplate.hasKey(key);
        } catch (Exception var3) {
            var3.printStackTrace();
            return false;
        }
    }

    
    public boolean expire(String key, long seconds) {
        try {
            this.redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
        } catch (Exception var5) {
            var5.printStackTrace();
            return false;
        }
        return true;
    }

    
    public long ttl(String key) {
        try {
            return this.redisTemplate.getExpire(key, TimeUnit.SECONDS);
        } catch (Exception var3) {
            var3.printStackTrace();
            return 0L;
        }
    }

    
    public boolean set(String key, String value) {
        try {
            this.redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception var4) {
            var4.printStackTrace();
            return false;
        }
    }

    
    public String get(String key) {
        try {
            return this.redisTemplate.opsForValue().get(key);
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

    
    public boolean setBytes(byte[] key, byte[] value) {
        return false;
    }

    
    public byte[] getBytes(byte[] key) {
        return new byte[0];
    }


    
    public boolean delete(String key) {
        try {
            this.redisTemplate.delete(key);
            return true;
        } catch (Exception var3) {
            var3.printStackTrace();
            return false;
        }
    }

    
    public List<Object> values(String key) {
        try {
            return this.redisTemplate.opsForHash().values(key);
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

    
    public List<String> hKeys(String pattern) {
        try {
            Set<Object> set = this.redisTemplate.opsForHash().keys(pattern);
            Iterator<Object> iterator = set.iterator();
            ArrayList<String> list = Lists.newArrayList();

            while(iterator.hasNext()) {
                list.add(iterator.next().toString());
            }

            return list;
        } catch (Exception var5) {
            var5.printStackTrace();
            return null;
        }
    }

    
    public boolean hSet(String key, String field, String value) {
        try {
            this.redisTemplate.opsForHash().put(key, field, value);
            return true;
        } catch (Exception var5) {
            var5.printStackTrace();
            return false;
        }
    }

    
    public String hGet(String key, String field) {
        try {
            Object object = this.redisTemplate.opsForHash().get(key, field);
            return object == null ? null : object.toString();
        } catch (Exception var4) {
            var4.printStackTrace();
            return null;
        }
    }

    
    public boolean hSetBytes(byte[] key, byte[] field, byte[] value) {
        return false;
    }

    
    public byte[] hGetBytes(byte[] key, byte[] field) {
        return new byte[0];
    }


    
    public List<String> hVals(String key) {
        try {
            List<Object> objects = this.redisTemplate.opsForHash().values(key);
            List<String> list = Lists.newArrayList();
            Iterator var4 = objects.iterator();

            while(var4.hasNext()) {
                Object obj = var4.next();
                list.add(obj.toString());
            }

            return list;
        } catch (Exception var6) {
            var6.printStackTrace();
            return null;
        }
    }

    
    public long hDelete(String key, String field) {
        try {
            return this.redisTemplate.opsForHash().delete(key, new Object[]{field});
        } catch (Exception var4) {
            var4.printStackTrace();
            return -1L;
        }
    }

    
    public long increment(String key) {
        return 0;
    }

    
    public long increment(String key, long length) {
        return 0;
    }

    
    public long hIncrement(String key, String field) {
        return 0;
    }

    
    public long hIncrement(String key, String field, long length) {
        return 0;
    }

    
    public long size(String key) {
        try {
            return this.redisTemplate.opsForHash().size(key);
        } catch (Exception var3) {
            var3.printStackTrace();
            return -1L;
        }
    }
}
