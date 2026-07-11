package com.example.rest_service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SightService {

    private final  List<Sight> allsights = new ArrayList<>();
    private final Map<String,String> zoneMap = new HashMap<>();

    public SightService () {
        zoneMap.put("qidu", "七堵區");
        zoneMap.put("zhongshan", "中山區");
        zoneMap.put("zhongzheng", "中正區");
        zoneMap.put("renai", "仁愛區");
        zoneMap.put("anle", "安樂區");
        zoneMap.put("xinyi", "信義區");
        zoneMap.put("nuannuan", "暖暖區");

        KeelungSightsCrawler crawler = new KeelungSightsCrawler();
        String[] zones = {"qidu", "zhongshan", "zhongzheng", "renai", "anle", "xinyi", "nuannuan"};
        for (String zone : zones) {
            Sight[] sights = crawler.getItems(zone);
            for (Sight sight : sights) {
                if (sight != null) allsights.add(sight);
            }
        }
    }

    public List<Sight> getSightByZone(String zone) {
        List<Sight> filtered = new ArrayList<>();
        String target = zoneMap.get(zone);
        for (Sight sight : allsights) {
            if (sight.getZone().contains(target)) {
                filtered.add(sight);
            }
        }
        return filtered;
    }
}
