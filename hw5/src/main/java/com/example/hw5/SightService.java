package com.example.hw5;
import org.springframework.stereotype.Service;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SightService {
    
    private final SightRepository repository;
    private final KeelungSightsCrawler crawler;
    private final Map<String,String> zoneMap = new HashMap<>();
    
    public SightService(SightRepository repository,KeelungSightsCrawler crawler){
        zoneMap.put("qidu", "七堵區");
        zoneMap.put("zhongshan", "中山區");
        zoneMap.put("zhongzheng", "中正區");
        zoneMap.put("renai", "仁愛區");
        zoneMap.put("anle", "安樂區");
        zoneMap.put("xinyi", "信義區");
        zoneMap.put("nuannuan", "暖暖區");

        this.repository = repository;
        this.crawler = crawler;
    }

    

    public List<Sight> getSightByZone(String zoneKey) {
        String zone = zoneMap.get(zoneKey);
        return repository.findByZone(zone);
    }

    public void initDatabase() {

        try {
            long count = repository.count();
            if (count == 0) loadSights();
        } catch (Exception e) {
            System.out.println("資料庫可能不存在，正在嘗試重新建立並載入資料...");
            loadSights();
        }
    }

    public void loadSights() {
        String[] towns = {"Town1-1","Town1-2","Town1-3","Town1-4","Town1-5","Town1-6","Town1-7"};

        for (String town : towns) {
            Sight[] sights = crawler.getItems(town);
            repository.saveAll(Arrays.asList(sights));
        }
    }

//        if (repository.count() == 0) {
//            String[] zones = {"qidu", "zhongshan", "zhongzheng", "renai", "anle", "xinyi", "nuannuan"};
//            for (String zone : zones) {
//                Sight[] sights = crawler.getItems(zone);
//                repository.saveAll(Arrays.asList(sights));
//            }
//            String[] towns = {"Town1-1", "Town1-2", "Town1-3", "Town1-4", "Town1-5", "Town1-6", "Town1-7"};
//            for (String town : towns) {
//                Sight[] sights = crawler.getItems(town);
//                repository.saveAll(Arrays.asList(sights));
//            }
//        }

}
