package com.bank.app.people;

import com.bank.app.accounts.BankaHesabi;
import com.bank.app.accounts.VadesizHesap;
import com.bank.app.accounts.YatirimHesabi;
import com.bank.app.cards.KrediKarti;

import java.util.ArrayList;
import java.util.Random;

public class Musteri extends Kisi {
    private String musteriNumarasi;
    private ArrayList<BankaHesabi> hesaplar;
    private ArrayList<KrediKarti> krediKartlari;

    // UML Diyagramındaki Constructor
    public Musteri(String ad, String soyad, String email, int telefonNumarasi) {
        super(ad, soyad, email, telefonNumarasi);
        
        // musteriNumarasi otomatik random türetiliyor
        Random rand = new Random();
        this.musteriNumarasi = String.valueOf(rand.nextInt(900000) + 100000); // 6 haneli
        
        this.hesaplar = new ArrayList<>();
        this.krediKartlari = new ArrayList<>();
    }

    // Parametreye göre ilgili nesneyi oluşturup ArrayList'e ekler
    public void hesapEkle(String hesapTuru) {
        if (hesapTuru.equalsIgnoreCase("Vadesiz")) {
            hesaplar.add(new VadesizHesap(0.0));
            System.out.println("Vadesiz hesap eklendi.");
        } else if (hesapTuru.equalsIgnoreCase("Yatirim")) {
            hesaplar.add(new YatirimHesabi(0.0));
            System.out.println("Yatırım hesabı eklendi.");
        } else {
            System.out.println("Geçersiz hesap türü.");
        }
    }

    public void krediKartiEkle(double limit) {
        KrediKarti yeniKart = new KrediKarti(limit, 0.0);
        krediKartlari.add(yeniKart);
        System.out.println("Kredi kartı tanımlandı. Kart No: " + yeniKart.getKartNumarasi());
    }

    public void hesapSil(BankaHesabi hesap) {
        if (hesap.getBakiye() > 0) {
            System.out.println("Lütfen öncelikle bakiyenizi başka bir hesaba aktarınız.");
        } else {
            hesaplar.remove(hesap);
            System.out.println("Hesap başarıyla silindi.");
        }
    }

    public void krediKartiSil(KrediKarti kart) {
        if (kart.getGuncelBorc() > 0) {
            System.out.println("Lütfen öncelikle borç ödemesi yapınız.");
        } else {
            krediKartlari.remove(kart);
            System.out.println("Kredi kartı başarıyla silindi.");
        }
    }

    // Getters ve Setters
    public String getMusteriNumarasi() { return musteriNumarasi; }
    public void setMusteriNumarasi(String musteriNumarasi) { this.musteriNumarasi = musteriNumarasi; }
    
    public ArrayList<BankaHesabi> getHesaplar() { return hesaplar; }
    public void setHesaplar(ArrayList<BankaHesabi> hesaplar) { this.hesaplar = hesaplar; }
    
    public ArrayList<KrediKarti> getKrediKartlari() { return krediKartlari; }
    public void setKrediKartlari(ArrayList<KrediKarti> krediKartlari) { this.krediKartlari = krediKartlari; }

    @Override
    public String toString() {
        return super.toString() + ", Müşteri No: " + musteriNumarasi;
    }
}