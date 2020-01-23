package Bankkonten;

public class Girokonto extends Konto {
    private static int kontoArt  = 1;

    @Override
    public double getDispoGrenze() {
        return -5000;
    }

    @Override
    public double getFührungsGebühr() {
        if(this.getKontostand() > 1000) {
            return 0;
        }
        return führungsGebühr;
    }

    Girokonto() {
        super.kontonummer = new Kontonummer(kontoArt);
    }
}
