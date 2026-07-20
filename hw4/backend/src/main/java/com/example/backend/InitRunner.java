package com.example.backend;

import org.springframework.boot.ApplicationArguments; 
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class InitRunner implements ApplicationRunner{

    private SightService sightService;
    public InitRunner(SightService sightService) {
        this.sightService = sightService;
    }

    @Override
    public void run(ApplicationArguments arg) throws Exception {
        sightService.initDatabase();
    }
}
