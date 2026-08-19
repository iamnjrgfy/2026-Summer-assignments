package com.example.hw5;
import java.util.List;

import org.springframework.http.ResponseEntity;
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
    @GetMapping("/api/sights/{zone}")
    public ResponseEntity<List<Sight>> getSight(@PathVariable String zone) {
        List<Sight> sights = sightService.getSightByZone(zone);

        if (sights == null || sights.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sights);
    }
}
