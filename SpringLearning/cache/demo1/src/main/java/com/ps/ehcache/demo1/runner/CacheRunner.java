package com.ps.ehcache.demo1.runner;


import com.ps.ehcache.demo1.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Service
public class CacheRunner implements CommandLineRunner {
    @Autowired
    private MusicService musicService;

    @Autowired
    private CacheManager cacheManager;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Spring Boot Ehcache 2 Caching Example Configuration");
        System.out.println("using cache manager: " + cacheManager.getClass().getName());
        musicService.clearCache();

        play("trombone");
        play("guitar");
        play("trombone");
        play("bass");
        play("trombone");
    }
    private void play(String instrument){
        System.out.println("Calling: " + MusicService.class.getSimpleName() + ".play(\"" + instrument + "\");");
        musicService.play(instrument);
    }
}
