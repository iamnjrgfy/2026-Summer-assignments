package com.example.backend;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
public class SightController {
    private final SightService sightService;

    public SightController(SightService sightService) {
        this.sightService = sightService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("api/sights/{zone}")
    public List<Sight> getSight(@PathVariable String zone) {
        return sightService.getSightByZone(zone);
    }
}
