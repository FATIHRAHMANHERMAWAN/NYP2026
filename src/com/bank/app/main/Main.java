package com.bank.app.main;

import com.bank.app.service.BankaService;
import com.bank.app.people.Musteri;

import com.bank.app.accounts.BankaHesabi;
import com.bank.app.accounts.VadesizHesap;
import com.bank.app.accounts.YatirimHesabi;
import com.bank.app.cards.KrediKarti;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Sistem basladi  ---\n");

        // musteri olusturma

        BankaService bankaService = new BankaService();
        Musteri musteri1 = new Musteri("Ali", "Yılmaz","ali@btu.edu.tr", 5551234);
        Musteri musteri2 = new Musteri("Fatih", "Kaya", "fatih@btu.edu.tr", 5059876);

        bankaService.musteriEkle(musteri1);
        bankaService.musteriEkle(musteri2);
        System.out.println(musteri1.toString() + "\n");


        // 2. MüSteri adına hesap açma
        System.out.println("[2] HESAPLAR AÇILIYOR...");
        musteri1.hesapEkle("Vadesiz");
        musteri1.hesapEkle("Yatirim");
        musteri2.hesapEkle("Vadesiz");
        
        BankaHesabi aliVadesiz = musteri1.getHesaplar().get(0);
        BankaHesabi aliYatirim = musteri1.getHesaplar().get(1);
        BankaHesabi fatihVadesiz = musteri2.getHesaplar().get(0);
        System.out.println();

        // 3. Hesaba para yatırma (Yatırım Hesabı üzerinden test)
        System.out.println("[3] HESABA PARA YATIRILIYOR...");
        ((YatirimHesabi) aliYatirim).paraEkle(5000.0);
        aliVadesiz.setBakiye(2000.0); // Test amaçlı bakiye ataması
        System.out.println("Ali Vadesiz Bakiye: " + aliVadesiz.getBakiye());
        System.out.println();

        // 4. Hesaplar arasında para transferi gerçekleStirme
        System.out.println("[4] PARA TRANSFERI...");
        // Ali, fatih 'ye 500 TL gönderiyor
        ((VadesizHesap) aliVadesiz).paraTransferi(fatihVadesiz, aliVadesiz, 500.0);
        System.out.println("Ali Kalan Bakiye: " + aliVadesiz.getBakiye());
        System.out.println("Fatih Yeni Bakiye: " + fatihVadesiz.getBakiye() + "\n");

        // 5. MüSteriye kredi kartı tanımlama
        System.out.println("[5] KREDI KARTI TANIMLAMA...");
        musteri1.krediKartiEkle(10000.0);
        KrediKarti aliKart = musteri1.getKrediKartlari().get(0);
        
        // Kartla harcama simülasyonu
        aliKart.setGuncelBorc(1500.0);
        System.out.println("Ali Kart Borcu: " + aliKart.getGuncelBorc() + "\n");

        // 6. Kredi kartı borcu ödeme iSlemi yapma
        System.out.println("[6] KREDI KARTI BORCU ÖDEME...");
        ((VadesizHesap) aliVadesiz).krediKartiBorcOdeme(aliKart, 500.0);
        System.out.println("Ali Kart Kalan Borç: " + aliKart.getGuncelBorc());
        System.out.println("Ali Vadesiz Kalan Bakiye: " + aliVadesiz.getBakiye() + "\n");

        // 7. Gerekli Sartlar sağlandığında hesap silme iSlemi
        System.out.println("[7] HESAP SILME ISLEMI...");
        // Ali'nin vadesiz hesabını silmeyi deniyoruz (Içinde para var, silmemeli)
        System.out.println("> Içi Dolu Hesap Silme Denemesi:");
        musteri1.hesapSil(aliVadesiz);
        
        // Ali'nin parasını çekip sıfırlayalım ve tekrar deneyelim
        System.out.println("> Bakiye Sıfırlanıp Tekrar Deneniyor:");
        aliVadesiz.setBakiye(0.0);
        musteri1.hesapSil(aliVadesiz);



    }
}