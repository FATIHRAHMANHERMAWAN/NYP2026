package com.bank.app.service;

import com.bank.app.people.Musteri;
import java.util.ArrayList;

// İş mantığını yönetecek temel servis sınıfı
public class BankaService {
    private ArrayList<Musteri> sistemdekiMusteriler;

    public BankaService() {
        this.sistemdekiMusteriler = new ArrayList<>();
    }

    public void musteriEkle(Musteri m) {
        sistemdekiMusteriler.add(m);
        System.out.println("Yeni müşteri sisteme eklendi: " + m.getAd() + " " + m.getSoyad());
    }

    public ArrayList<Musteri> getSistemdekiMusteriler() {
        return sistemdekiMusteriler;
    }
}