package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[] zones = {"qidu","zhongshan","zhongzheng","renai","anle","xinyi","nuannuan"};
        for (String zone : zones) {
            KeelungSighsCrawler crawler = new KeelungSighsCrawler();
            Sight[] sights = crawler.getItems(zone);
            for (Sight s : sights) {
                System.out.println(s);
            }
            System.out.println();
        }
    }
}
