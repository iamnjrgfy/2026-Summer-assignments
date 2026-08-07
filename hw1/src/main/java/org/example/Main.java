package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[] towns = {"Town1-1","Town1-2","Town1-3","Town1-4","Town1-5","Town1-6","Town1-7"};
        for (String town : towns) {
            KeelungSighsCrawler crawler = new KeelungSighsCrawler();
            Sight[] sights = crawler.getItems(town);
            for (Sight s : sights) {
                System.out.println(s);
            }
            System.out.println();
        }
    }
}
