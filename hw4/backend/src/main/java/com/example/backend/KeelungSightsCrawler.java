package com.example.backend;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

@Component
public class KeelungSightsCrawler {

    public KeelungSightsCrawler() {}

    public Sight[] getItems(String zone) {
        String url = "https://www.travelking.com.tw/tourguide/taiwan/keelungcity/" + zone + "/";
        try {
            Document doc = Jsoup.connect(url).get();
            Elements links = doc.select("#guide-point .box a[href]");
            Sight sights[] = new Sight[links.size()];

            for (int i = 0;i < links.size();++i) {
                String linkHref = links.get(i).absUrl("href");
                try {
                    Document Newdoc = Jsoup.connect(linkHref).get();
                    Sight s = new Sight();
                    s.setSightName(Newdoc.select(".h1").text());
                    s.setZone(doc.select(".this_title").text());
                    s.setCategory(Newdoc.select("cite strong").text());
                    Element elementUrl = Newdoc.select("#galleria .gpic img").first();
                    String imgUrl;
                    if (elementUrl != null) {
                        imgUrl = elementUrl.attr("src");
                    } else {
                        imgUrl = "No PhotoUrl";
                    }

                    s.setPhotoUrl(imgUrl);
                    s.setDescription(Newdoc.select(".text ").text());
                    s.setAddress(Newdoc.select("#point_data span").text());

                    sights[i] = s;

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            return sights;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
