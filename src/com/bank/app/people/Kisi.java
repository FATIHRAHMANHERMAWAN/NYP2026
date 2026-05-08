package com.bank.app.people;

// burda bir ata sinifi (her kisiye template olusturduk)
public class Kisi {
    private String ad;
    private String soyad;
    private String email;
    private int telefonNumarasi;

// bir constructor yazdik, icinde bir kisinin gereken ozellikler icerir
    public Kisi(String ad, String soyad, String email, int telefonNumarasi) {
        this.ad = ad;
        this.soyad = soyad;
        this.email = email;
        this.telefonNumarasi = telefonNumarasi;
    }


    // bu get metotlar service sinifinda kullanilacaktir
    public String getAd() {
         return ad;
    }
    
    public String getSoyad() { 
        return soyad;
     }

 // burda toString method overriding yapisi kullandik
    @Override
    public String toString() {
        return "Ad: " + ad + ", Soyad: " + soyad + ", Email: " + email + ", Tel: " + telefonNumarasi;
    }
}