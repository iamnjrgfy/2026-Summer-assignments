package com.example.hw5;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

@Component
public class KeelungSightsCrawler {

    public KeelungSightsCrawler() {}

    public Sight[] getItems(String town) {

        String url = "https://okgo.tw/buty/keelung.html";

        try {
            Document doc = Jsoup.connect(url).get();
            Elements links = doc.select("#"+ town + "  ul  li a[href]");
            Sight[] sights = new Sight[links.size()];

            for (int i = 0;i < links.size();++i) {
                String detailUrl = links.get(i).absUrl("href");
                try {
                    Document detail = Jsoup.connect(detailUrl).get();

                    Sight s = new Sight();
                    //set name
                    s.setSightName(detail.select(".sec3 h2").text());

                    //set address
                    String fullText = detail.select(".sec3").text();
                    String address = "";
                    if (fullText.contains("地址：")) {
                        int startIndex = fullText.indexOf("地址：") + 3;
                        int endIndex = fullText.indexOf("文章來源",startIndex);
                        if (endIndex == -1) endIndex = startIndex;
                        address = fullText.substring(startIndex,endIndex).trim();
                    }
                    s.setAddress(address);

                    //set description
                    s.setDescription(detail.select("div.sec3 > div:not(#FontSize):not(#Buty_View_PicSource)").text());

                    //set photo url
                    Element photoItem = detail.select(".sec3 #Buty_View_PicSource .pic img").first();
                    if (photoItem != null) {
                        s.setPhotoUrl(photoItem.attr("src"));
                    } else {
                        s.setPhotoUrl("-");
                    }
                    //set zone
                    s.setZone(detail.select(".sec3 strong a[href*=town]").text());

                    sights[i] = s;
                }catch (Exception e) {
                    System.err.println(e.getMessage());
                    return new Sight[0];
                }
            }
            return sights;

        }catch (Exception e) {
            System.err.println(e.getMessage());
            return new Sight[0];
        }

//        String url = "https://www.travelking.com.tw/tourguide/taiwan/keelungcity/" + zone + "/";
//        try {
//            Document doc = Jsoup.connect(url).get();
//            Elements links = doc.select("#guide-point .box a[href]");
//            Sight sights[] = new Sight[links.size()];
//
//            for (int i = 0;i < links.size();++i) {
//                String linkHref = links.get(i).absUrl("href");
//                try {
//                    Document Newdoc = Jsoup.connect(linkHref).get();
//                    Sight s = new Sight();
//                    s.setSightName(Newdoc.select(".h1").text());
//                    s.setZone(doc.select(".this_title").text());
//                    s.setCategory(Newdoc.select("cite strong").text());
//                    Element elementUrl = Newdoc.select("#galleria .gpic img").first();
//                    String imgUrl;
//                    if (elementUrl != null) {
//                        imgUrl = elementUrl.attr("src");
//                    } else {
//                        imgUrl = "No PhotoUrl";
//                    }
//
//                    s.setPhotoUrl(imgUrl);
//                    s.setDescription(Newdoc.select(".text ").text());
//                    s.setAddress(Newdoc.select("#point_data span").text());
//
//                    sights[i] = s;
//
//                } catch (Exception e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            return sights;
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
    }
}
