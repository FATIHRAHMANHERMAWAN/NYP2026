package com.bank.app.people;

import com.bank.app.accounts.BankaHesabi;
import com.bank.app.accounts.VadesizHesap;
import com.bank.app.accounts.YatirimHesabi;
import com.bank.app.cards.KrediKarti;


import java.util.ArrayList;
import java.util.Random;

// burda musteri sinifi kisi sinifindan miras islemi almistir

public class Musteri extends Kisi {
    private String musteriNumarasi;
    private ArrayList<BankaHesabi> hesaplar;
    private ArrayList<KrediKarti> krediKartlari;

    // Uml diyagramdaki beriltilen constructor

    public Musteri(String ad, String soyad, String email, int telefonNumarasi) {

        // superin kullanisi verileri kisi sinifina aktarmak icindir
        super(ad, soyad, email, telefonNumarasi);
        
         // range : 1000 - 9999 ve sonuc hep string olacaktir
        Random rand = new Random();
        this.musteriNumarasi = String.valueOf(rand.nextInt(900000) + 100000); // 6 haneli
        
        // object initialization 
        this.hesaplar = new ArrayList<>();
        this.krediKartlari = new ArrayList<>();
    }

    // hesapturune gore siniflandirim ilgili nesne yaratmak
    public void hesapEkle(String hesapTuru) {

        // equals yerine equalsIgnoreCase kullandik amaci buyuk kucuk farketmemek
        // add function ArrayList bir ozelligidir (eklemek)
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

    // kredikarti diger karttan farkli package oldugu icin ozel bir function yazdik

    public void krediKartiEkle(double limit) {
        KrediKarti yeniKart = new KrediKarti(limit, 0.0);
        krediKartlari.add(yeniKart);
        System.out.println("Kredi kartı tanımlandı. Kart No: " + yeniKart.getKartNumarasi());
    }

    public void hesapSil(BankaHesabi hesap) {

        // silme kurali hesabin her hangi bir bakiye olmamasidir

        if (hesap.getBakiye() > 0) {
            System.out.println("Lütfen öncelikle bakiyenizi başka bir hesaba aktarınız.");
        } else {
            // remove() bir ArrayList functiondur
            hesaplar.remove(hesap);
            System.out.println("Hesap başarıyla silindi.");
        }
    }

    public void krediKartiSil(KrediKarti kart) {
        // silme kurali hesabin her hangi bir borc olmamasidir

        if (kart.getGuncelBorc() > 0) {
            System.out.println("Lütfen öncelikle borç ödemesi yapınız.");
        } else {

            // remove() bir ArrayList functiondur
            krediKartlari.remove(kart);
            System.out.println("Kredi kartı başarıyla silindi.");
        }
    }

   
     // burda toString method overriding yapisi kullandik


    @Override
    public String toString() {

        // bursa ana sinifindaki toString cagirdik 
        return super.toString() + ", Müşteri No: " + musteriNumarasi;
    }
}