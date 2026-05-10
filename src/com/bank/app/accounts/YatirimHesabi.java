package com.bank.app.accounts;

public class YatirimHesabi extends BankaHesabi {
    private String hesapTuru;

    // UML Diyagramındaki Constructor
    public YatirimHesabi(double bakiye) {
        super(bakiye);
        hesapTuru = "Yatirim";
    }


    // para ekleme sistemi

     @Override
    public void paraEkle(double miktar) {
        if (miktar > 0) {
            // bursa super() kullanmadik nedenide override kullanmadik
            setBakiye(getBakiye() + miktar);
            System.out.println("Yatırım hesabına " + miktar + " eklendi.");
        }
    }

     @Override
    public void paraCek(double miktar) {
        if (getBakiye() >= miktar) {
            setBakiye(getBakiye() - miktar);
            System.out.println("Yatırım hesabından " + miktar + " çekildi.");
        } else {
            System.out.println("Yatırım hesabında yeterli bakiye yok.");
        }
    }

 
    @Override
    public String toString() {
        return super.toString() + ", Tür: " + hesapTuru;
    }
}