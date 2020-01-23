package Bankkonten;

public class Sparkonto extends Konto{
    static int kontoArt  = 2;

    public Sparkonto() {
        kontonummer = new Kontonummer(kontoArt);
    }

    @Override
    public double getFührungsGebühr() {
        return 0;
    }
}
