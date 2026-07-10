package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class KeelungSighsCrawler {
    public KeelungSighsCrawler() {}

    public Sight[] getItems(String zone) {
        String url = "https://www.travelking.com.tw/tourguide/taiwan/keelungcity/" + zone + "/";


        try {
            Document doc = Jsoup.connect(url).get();
            Elements links = doc.select("#guide-point .box ul li a[href]");
            Sight[] sights = new Sight[links.size()];

            for (int i = 0;i < links.size();++i) {
                try {
                    String SecondUrl = links.get(i).absUrl("href");
                    Document Seconddoc = Jsoup.connect(SecondUrl).get();
                    Sight s = new Sight();
                    s.setSightName(Seconddoc.select(".h1 span").text());
                    s.setZone(doc.select(".this_title").text());
                    s.setCategory(Seconddoc.select("cite strong").text());
                    Element imgElement = Seconddoc.select("#galleria .gpic img").first();
                    String imgUrl = imgElement.attr("src");
                    s.setPhotoURL(imgUrl);
                    s.setDescription(Seconddoc.select(".text").text());
                    s.setAddress(Seconddoc.select("#point_data span").text());

                    sights[i] = s;
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
            return sights;

        } catch(Exception e) {
            System.err.println(e.getMessage());
            return new Sight[0];
        } 
    }
}
