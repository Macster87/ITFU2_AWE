package Bankkonten;

public abstract class Konto {
    Kontonummer kontonummer;
    static double führungsGebühr = 3; // Pro Monat
    private static double einzahlGebühr = 0; // Pro Einzahlung
    private static double auszahlGebühr = 0.20; // Pro Auszahlung
    static double dispoGrenze = 0;
    private double kontostand = 0;

    public double getAuszahlGebühr() {
        return auszahlGebühr;
    }

    public double getEinzahlGebühr() {
        return einzahlGebühr;
    }

    public double getDispoGrenze() {
        return dispoGrenze;
    }

    public double getFührungsGebühr() {
        return führungsGebühr;
    }

    public Kontonummer getKontonummer() {
        return kontonummer;
    }

    public double getKontostand() {
        return kontostand;
    }

    public double auszahlung(double input) {
        double betrag = Math.abs(input);
        if(getKontostand()-betrag-this.auszahlGebühr > getDispoGrenze() && betrag > 0) {
            System.out.println("Auszahlung: " + betrag + " €");
            this.kontostand = getKontostand() - betrag-getAuszahlGebühr();
        }
        return this.kontostand;
    }

    public double einzahlung(double input) {
        double betrag = Math.abs(input);
        this.kontostand = this.kontostand + betrag-einzahlGebühr;
        return this.kontostand;
    }
}