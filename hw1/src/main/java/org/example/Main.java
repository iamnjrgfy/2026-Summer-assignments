package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        KeelungSighsCrawler crawler = new KeelungSighsCrawler();
        crawler.getItems("qidu");
        Sight[] sights = crawler.getItems("qidu");
        for (Sight s : sights) {
            System.out.println(s);
        }
    }
}
