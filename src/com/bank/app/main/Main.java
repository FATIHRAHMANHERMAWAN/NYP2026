package com.bank.app.main;

import com.bank.app.service.BankaService;
import com.bank.app.people.Musteri;

import com.bank.app.accounts.BankaHesabi;
import com.bank.app.accounts.VadesizHesap;
import com.bank.app.accounts.YatirimHesabi;
import com.bank.app.cards.KrediKarti;

public class Main {
    public static void main(String[] args) {

        // 1. musteri olusturmak
        Musteri musteri1 = new Musteri("Fatih", "Rahman","fatih@btu.edu.tr", 5551234);
        Musteri musteri2 = new Musteri("Rohma", "Ilmiah", "rohma@btu.edu.tr", 5059876);


        BankaService bankaService = new BankaService();

        bankaService.musteriEkle(musteri1);
        bankaService.musteriEkle(musteri2);


        // 2.musteri adina hesap acma

        musteri1.hesapEkle("vadesiz");
        musteri1.hesapEkle("yatirim");
        musteri2.hesapEkle("vadesiz");

        BankaHesabi fatihVadesiz = musteri1.getHesaplar().get(0);
        BankaHesabi fatihYatirim = musteri1.getHesaplar().get(1);
        BankaHesabi rohmaVadesiz = musteri2.getHesaplar().get(0);

        // 3. hesaba yatirma islemi 


        fatihYatirim.paraEkle(5000);
        fatihVadesiz.setBakiye(2000);

        System.out.println("Fatinin vadesiz bakiye " + fatihVadesiz.getBakiye());

        // 4. hesaplar transferi 

        fatihVadesiz.paraTransferi(rohmaVadesiz, fatihVadesiz, 500);
         System.out.println("Fatinin vadesiz bakiye " + fatihVadesiz.getBakiye());
         System.out.println("Rohma vadesiz bakiye " + rohmaVadesiz.getBakiye());

        // 5. mUsteri kredi karti

        musteri1.krediKartiEkle(10000);
        KrediKarti fatihkredikart = musteri1.getKrediKartlari().get(0);

        fatihkredikart.setGuncelBorc(1500);

        System.out.println(fatihkredikart.getGuncelBorc());

        // 6. kredi karti borcu silmel

        fatihVadesiz.krediKartiBorcOdeme(fatihkredikart, 500);
        System.out.println(fatihkredikart.getGuncelBorc());
         System.out.println("Fatinin vadesiz bakiye " + fatihVadesiz.getBakiye());


        // Gerekli sartlar sagladiginda hesap silme hesabi

        musteri1.hesapSil(fatihVadesiz);
        

        fatihVadesiz.setBakiye(0.0);
         musteri1.hesapSil(fatihVadesiz);










    }
}