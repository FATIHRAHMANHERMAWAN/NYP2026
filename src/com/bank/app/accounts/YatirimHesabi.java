package com.bank.app.accounts;

public class YatirimHesabi extends BankaHesabi {
    private String hesapTuru;

    // UML Diyagramındaki Constructor
    public YatirimHesabi(double bakiye) {
        super(bakiye);
        this.hesapTuru = "Yatirim";
    }


    // para ekleme sistemi
    public void paraEkle(double miktar) {
        if (miktar > 0) {
            // bursa super() kullanmadik nedenide override kullanmadik
            this.setBakiye(this.getBakiye() + miktar);
            System.out.println("Yatırım hesabına " + miktar + " eklendi.");
        }
    }

    public void paraCek(double miktar) {
        if (this.getBakiye() >= miktar) {
            this.setBakiye(this.getBakiye() - miktar);
            System.out.println("Yatırım hesabından " + miktar + " çekildi.");
        } else {
            System.out.println("Yatırım hesabında yeterli bakiye yok.");
        }
    }

    // public String getHesapTuru() { return hesapTuru; }
    // public void setHesapTuru(String hesapTuru) { this.hesapTuru = hesapTuru; }

    @Override
    public String toString() {
        return super.toString() + ", Tür: " + hesapTuru;
    }
}