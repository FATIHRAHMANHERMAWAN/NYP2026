package com.bank.app.people;

import java.util.ArrayList;
import java.util.Random;

public class BankaPersoneli extends Kisi {
    private String personelID;
    private ArrayList<Musteri> musteriler;

    // UML Diyagramındaki Constructor
    public BankaPersoneli(String ad, String soyad, String email, int telefonNumarasi) {
        super(ad, soyad, email, telefonNumarasi);
        
        // personelID otomatik random türetiliyor
        Random rand = new Random();
        this.personelID = "PERS-" + (rand.nextInt(9000) + 1000);
        
        this.musteriler = new ArrayList<>();
    }

    // Getters ve Setters
    public String getPersonelID() { return personelID; }
    public void setPersonelID(String personelID) { this.personelID = personelID; }

    public ArrayList<Musteri> getMusteriler() { return musteriler; }
    public void setMusteriler(ArrayList<Musteri> musteriler) { this.musteriler = musteriler; }

    @Override
    public String toString() {
        return super.toString() + ", Personel ID: " + personelID;
    }
}