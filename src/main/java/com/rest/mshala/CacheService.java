package com.rest.mshala;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@Service
public class CacheService {

    private static Cache<String, String> cache;

    @PostConstruct
    private void init(){
        cache = CacheBuilder.newBuilder()
                .maximumSize(1000)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .build();
    }

    public void put(String key, String value){
        cache.put(key, value);
    }

    public boolean verify(String key, String value){
        String tValue = cache.getIfPresent(key);
        return value.equalsIgnoreCase(tValue);
    }
}
