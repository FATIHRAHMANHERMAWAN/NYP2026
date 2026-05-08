package com.bank.app.cards;

import java.util.Random;

public class KrediKarti {

    // Uml diyagramdaki beriltilen degiskenler

    private String kartNumarasi;
    private double limit;
    private double guncelBorc;
    private double kullanilabilirLimit;

    // Uml diyagramdaki beriltilen constructor
    public KrediKarti(double limit, double guncelBorc) {
        this.limit = limit;
        this.guncelBorc = guncelBorc;

        // kullanilabilir limit ifadesi = limit - guncelborc
        this.kullanilabilirLimit = limit - guncelBorc;
        
        // kartNumarasi otomatik random türetiliyor 16 haneli
        // " - " bir ayrac kulanilir. %d04d sonucu hep 0000 olacaktir
        Random rand = new Random();
        this.kartNumarasi = String.format("%04d-%04d-%04d-%04d", 
            rand.nextInt(10000), rand.nextInt(10000), rand.nextInt(10000), rand.nextInt(10000));
    }

    // bu getter fuctionlar musteri, accountlar sinifinda kullanilmistir

    public String getKartNumarasi() { 

        return kartNumarasi; 
    }
    
    
    public double getLimit() {
        return limit;
    }

    public double getGuncelBorc() { 

        return guncelBorc; 
    }
    public void setGuncelBorc(double guncelBorc) { 
        this.guncelBorc = guncelBorc; 
        this.kullanilabilirLimit = this.limit - guncelBorc; // Borç değişirse güncellenir
    }

    public void setKullanilabilirLimit(double kullanilabilirLimit) {
        this.kullanilabilirLimit = kullanilabilirLimit;
    }
    

     // burda toString method overriding yapisi kullandik

    @Override
    public String toString() {
        return "Kart No: " + kartNumarasi + ", Limit: " + limit + ", Borç: " + guncelBorc;
    }
}