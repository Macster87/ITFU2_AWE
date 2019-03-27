public class Auto {

    private String eigentuemer;
    private String farbe;
    private int richtung = 0;
    private double geschwindigkeit = 0;

    public Auto() {
        this.eigentuemer = "meiner";
        this.farbe = "schwarz";
    }

    public Auto(String eigentuemer, String farbe) {
        this.eigentuemer = eigentuemer;
        this.farbe = farbe;
    }

    public void lenken(int value) {
        if(value > 90 || value < -90) return;
        richtung = value;
    }

    public void lenken(String anweisung) {
        switch (anweisung) {
            case "links": richtung = -90;
            case "rechts": richtung = 90;
            case "halb links": richtung = -45;
            case "halb rechts": richtung = 45;
            case "geradeaus": richtung = 0;
            default: richtung = 0;
        }
    }

    public void beschleunigen(double value) {
        this.geschwindigkeit = value;
    }

    public String getEigentuemer() {
        return eigentuemer;
    }

    public void setEigentuemer(String eigentuemer) {
        this.eigentuemer = eigentuemer;
    }

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    public int getRichtung() {
        return richtung;
    }

    public double getGeschwindigkeit() {
        return geschwindigkeit;
    }
}
