package com.bank.app.accounts;

import java.util.Random;

public class BankaHesabi {

     // UML Diyagramındaki degiskenler
    private String iban;
    private double bakiye;

    // UML Diyagramındaki Constructor
    public BankaHesabi(double bakiye) {
        this.bakiye = bakiye;
        
        // iban string builder yapisi kullandik
        Random rand = new Random();
        StringBuilder sb = new StringBuilder("TR");
        for(int i=0; i<10; i++) {
            //0-9 sayilar gelecektir
            sb.append(rand.nextInt(10));
        }
        iban = sb.toString();
    }

    // bu getter fuctionlar musteri sinifinda kullanilmistir
 
    public double getBakiye() {
         return bakiye;
     }
     
    public void setBakiye(double bakiye) { 
        this.bakiye = bakiye;
    }

    @Override
    public String toString() {
        return "IBAN: " + iban + ", Bakiye: " + bakiye;
    }
}