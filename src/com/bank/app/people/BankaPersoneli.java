package com.bank.app.people;

import java.util.ArrayList;
import java.util.Random;

public class BankaPersoneli extends Kisi {
    
    // Uml diyagramdaki beriltilen degiskenler
    private String personelID;
    private ArrayList<Musteri> musteriler;

    // Uml diyagramdaki beriltilen constructor
    public BankaPersoneli(String ad, String soyad, String email, int telefonNumarasi) {
        // superin kullanisi verileri kisi sinifina aktarmak icindir
        super(ad, soyad, email, telefonNumarasi);
        
        // personelID otomatik random türetiliyor
        Random rand = new Random();

        // range : 1000 - 9999 ve sonuc hep string olacaktir
        this.personelID = "PERS-" + (rand.nextInt(9000) + 1000);
        
        // object initialization
        this.musteriler = new ArrayList<>();
    }

     // burda toString method overriding yapisi kullandik

    @Override
    public String toString() {
        return super.toString() + ", Personel ID: " + personelID;
    }
}