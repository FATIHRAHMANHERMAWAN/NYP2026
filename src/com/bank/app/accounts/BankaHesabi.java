package com.bank.app.accounts;

import java.util.Random;

public class BankaHesabi {
    private String iban;
    private double bakiye;

    // UML Diyagramındaki Constructor
    public BankaHesabi(double bakiye) {
        this.bakiye = bakiye;
        
        // iban otomatik random türetiliyor
        Random rand = new Random();
        StringBuilder sb = new StringBuilder("TR");
        for(int i=0; i<10; i++) {
            sb.append(rand.nextInt(10));
        }
        this.iban = sb.toString();
    }

    // Getters ve Setters
    public String getIban() { return iban; }
    public void setIban(String iban) { this.iban = iban; }

    public double getBakiye() { return bakiye; }
    public void setBakiye(double bakiye) { this.bakiye = bakiye; }

    @Override
    public String toString() {
        return "IBAN: " + iban + ", Bakiye: " + bakiye;
    }
}