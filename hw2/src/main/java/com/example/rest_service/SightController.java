package com.example.rest_service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SightController {
    private final SightService sightService;

    public SightController(SightService sightService) {
        this.sightService = sightService;
    }

    @GetMapping("api/sights/{zone}")
    public ResponseEntity<List<Sight>> getSight(@PathVariable String zone) {
        List<Sight> sights = sightService.getSightByZone(zone);
        return  (sights == null)
            ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
            : ResponseEntity.status(HttpStatus.OK).body(sights);
    }



}
