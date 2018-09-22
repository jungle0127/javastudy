package com.ps.ehcache.logger;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;

public class EventLogger implements CacheEventListener<Object,Object> {
    @Override
    public void onEvent(CacheEvent<?, ?> cacheEvent) {
        System.out.println("Event: " + cacheEvent.getType() + " Key: " + cacheEvent.getKey() + " old value: " + cacheEvent.getOldValue() + " new value: " + cacheEvent.getNewValue());
    }
}
