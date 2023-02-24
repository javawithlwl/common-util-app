package com.careerit.cup.cbook.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.benmanes.caffeine.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.concurrent.ConcurrentMap;

@RestController
@RequestMapping("/api/v1/cache")
public class CacheDetailsController {
      @Autowired
      private CacheManager cacheManager;


      @GetMapping("/names")
      public Collection<String> getCacheNames(){
        return cacheManager.getCacheNames();
      }
      @GetMapping("/entries/{cachename}")
      public String getEntriesFromCache(@PathVariable("cachename")String cacheName) throws JsonProcessingException {
        Cache<Object, Object> cache = (Cache<Object, Object>) cacheManager.getCache(cacheName).getNativeCache();
        ConcurrentMap<Object, Object> map = cache.asMap();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(map);
      }
}
