package com.bank.app.accounts;

import com.bank.app.cards.KrediKarti;


// bankahesabindan miras aldik
public class VadesizHesap extends BankaHesabi {
    private String hesapTuru;

    // UML Diyagramındaki Constructor
    public VadesizHesap(double bakiye) {
        super(bakiye);
        this.hesapTuru = "Vadesiz";
    }


    // para transferi fongsyonu

    public void paraTransferi(BankaHesabi aliciHesap, BankaHesabi gonderenHesap, double miktar) {

        // eger gonderen hesabi esit veya daha fazla bakiye varsa, transfer islemi gerceklestirebilir
        if (gonderenHesap.getBakiye() >= miktar) {
            gonderenHesap.setBakiye(gonderenHesap.getBakiye() - miktar);
            aliciHesap.setBakiye(aliciHesap.getBakiye() + miktar);
            System.out.println("Transfer basarılı. Miktar: " + miktar);
        } else {
            System.out.println("Yetersiz bakiye. Transfer iptal edildi.");
        }
    }

    //kredi karti bord odeme yontemi
    public void krediKartiBorcOdeme(KrediKarti kart, double miktar) {
        if (this.getBakiye() >= miktar) {
            this.setBakiye(this.getBakiye() - miktar);
            kart.setGuncelBorc(kart.getGuncelBorc() - miktar);

            // Kullanılabilir limit güncelleniyoruz tabiki
            kart.setKullanilabilirLimit(kart.getLimit() - kart.getGuncelBorc());
            System.out.println("Kredi kartı borcu ödendi. Ödenen: " + miktar);
        } else {
            System.out.println("Hesapta yeterli bakiye yok.");
        }
    }

    // public String getHesapTuru() { return hesapTuru; }
    // public void setHesapTuru(String hesapTuru) { this.hesapTuru = hesapTuru; }

    @Override
    public String toString() {
        return super.toString() + ", Tür: " + hesapTuru;
    }
}