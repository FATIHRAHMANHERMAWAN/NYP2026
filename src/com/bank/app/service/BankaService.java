package com.bank.app.service;

import com.bank.app.people.Musteri;
import java.util.ArrayList;

// İş mantığını yönetecek temel servis sınıfı
public class BankaService {
    
    private ArrayList<Musteri> sistemdekiMusteriler;

    public BankaService() {
        this.sistemdekiMusteriler = new ArrayList<>();
    }
    // menambahkan object musteri kedalam sistemdekimusteriler arraylist
    public void musteriEkle(Musteri m) {
        sistemdekiMusteriler.add(m);
        System.out.println("Yeni müşteri sisteme eklendi: " + m.getAd() + " " + m.getSoyad());
    }

    //getter method sistemdeki musteriler icin
    public ArrayList<Musteri> getSistemdekiMusteriler() {
        return sistemdekiMusteriler;
    }
}