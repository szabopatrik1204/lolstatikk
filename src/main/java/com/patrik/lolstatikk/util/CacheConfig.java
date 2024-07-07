package com.patrik.lolstatikk.util;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableCaching
@Configuration
public class CacheConfig implements WebMvcConfigurer {

    @Bean(name = "springCM")
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("cacheLatest");
    }
}