package com.agileengine.skeleton.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SimpleScheduler {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleScheduler.class);

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        LOGGER.info("AAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
    }

}