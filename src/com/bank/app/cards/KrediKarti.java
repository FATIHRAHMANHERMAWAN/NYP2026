package com.bank.app.cards;

import java.util.Random;

public class KrediKarti {
    private String kartNumarasi;
    private double limit;
    private double guncelBorc;
    private double kullanilabilirLimit;

    // UML Diyagramındaki Constructor
    public KrediKarti(double limit, double guncelBorc) {
        this.limit = limit;
        this.guncelBorc = guncelBorc;
        this.kullanilabilirLimit = limit - guncelBorc;
        
        // kartNumarasi otomatik random türetiliyor
        Random rand = new Random();
        this.kartNumarasi = String.format("%04d-%04d-%04d-%04d", 
            rand.nextInt(10000), rand.nextInt(10000), rand.nextInt(10000), rand.nextInt(10000));
    }

    // Getters ve Setters
    public String getKartNumarasi() { return kartNumarasi; }
    public void setKartNumarasi(String kartNumarasi) { this.kartNumarasi = kartNumarasi; }

    public double getLimit() { return limit; }
    public void setLimit(double limit) { 
        this.limit = limit; 
        this.kullanilabilirLimit = limit - this.guncelBorc; // Limit değişirse güncellenir
    }

    public double getGuncelBorc() { return guncelBorc; }
    public void setGuncelBorc(double guncelBorc) { 
        this.guncelBorc = guncelBorc; 
        this.kullanilabilirLimit = this.limit - guncelBorc; // Borç değişirse güncellenir
    }

    public double getKullanilabilirLimit() { return kullanilabilirLimit; }
    public void setKullanilabilirLimit(double kullanilabilirLimit) { this.kullanilabilirLimit = kullanilabilirLimit; }

    @Override
    public String toString() {
        return "Kart No: " + kartNumarasi + ", Limit: " + limit + ", Borç: " + guncelBorc;
    }
}