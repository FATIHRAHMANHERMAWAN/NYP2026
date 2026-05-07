package com.bank.app.people;

public class Kisi {
    private String ad;
    private String soyad;
    private String email;
    private int telefonNumarasi;

    // UML Diyagramındaki Constructor
    public Kisi(String ad, String soyad, String email, int telefonNumarasi) {
        this.ad = ad;
        this.soyad = soyad;
        this.email = email;
        this.telefonNumarasi = telefonNumarasi;
    }

    // Getters ve Setters
    public String getAd() { return ad; }
    public void setAd(String ad) { this.ad = ad; }
    
    public String getSoyad() { return soyad; }
    public void setSoyad(String soyad) { this.soyad = soyad; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public int getTelefonNumarasi() { return telefonNumarasi; }
    public void setTelefonNumarasi(int telefonNumarasi) { this.telefonNumarasi = telefonNumarasi; }

    @Override
    public String toString() {
        return "Ad: " + ad + ", Soyad: " + soyad + ", Email: " + email + ", Tel: " + telefonNumarasi;
    }
}