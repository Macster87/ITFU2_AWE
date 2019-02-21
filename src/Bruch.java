public class Bruch {

    private int zaehler;
    private int nenner;

    public Bruch(int zaehler, int nenner) {
        this.zaehler = zaehler;
        this.nenner = nenner;
    }

    public int getZaehler() {
        return zaehler;
    }

    public int getNenner() {
        return nenner;
    }

    public void setZaehler(int zaehler) {
        this.zaehler = zaehler;
    }

    public void setNenner(int nenner) {
        this.nenner = nenner;
    }

    @Override
    public String toString() {
        return zaehler + "/" + nenner;
    }

    public double asDouble() {
        return (double)zaehler/nenner;
    }

    public Bruch mult(int faktor) {
        return new Bruch(zaehler*faktor, nenner*faktor);
    }

    private Bruch mult(Bruch faktor) {
        Bruch result = new Bruch(faktor.getZaehler()*zaehler, faktor.getNenner()*nenner);
        result.kuerze();
        return result;
    }

    public Bruch add(int summand) {
        return new Bruch(zaehler+(summand*nenner), nenner);
    }

    public Bruch add(Bruch summand) {
        int x = summand.getNenner();
        int kgV = x * (nenner / ggT(x,nenner));

        int multiplikatorEins = kgV/summand.nenner;
        int multiplikatorZwei = kgV/nenner;

        int result = (multiplikatorZwei*zaehler) + (multiplikatorEins*summand.getZaehler());

        return new Bruch(result,kgV);
    }

    public Bruch div(int divisor) {
        return new Bruch(zaehler, nenner*divisor);
    }

    public Bruch div(Bruch divisior) {
        //TODO: Implement
        return null;
    }

    public Bruch sub(int subtrahend) {
        return new Bruch(zaehler-(subtrahend*nenner), nenner);
    }

    public Bruch sub(Bruch subtrahend) {
        return null;
    }

    private void kuerze() {
        int teiler = ggT(zaehler, nenner);
        zaehler = zaehler/teiler;
        nenner = nenner/teiler;
    }

    public static int ggT(int a, int b) {
        if (a == 0)
        {
            return b;
        }
        else
        {
            while (b != 0)
            {
                if (a > b)
                {
                    a = a - b;
                }
                else
                {
                    b = b - a;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        Bruch a, b, c, d;
        a = new Bruch(3,4);
        b = new Bruch(5,3);
        c = a.mult(b);
        d = a.add(b);
        System.out.println("a = " + a + " [3/4]");
        System.out.println("b = " + b + " [5/3]");
        System.out.println("c = " + c + " [5/4]");
        System.out.println("d = " + d + " [29/12]");
    }
}
