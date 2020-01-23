package bmi;

import java.util.Random;

public class Person {
    private static int groesseObergrenze = 185;
    private static int groesseUntergrenze = 140;
    private static int gewichtUntergrenze = 55;
    private static int gewichtObergrenze = 110;
    private String name;
    private String vorname;
    private int groesse; // in cm
    private int gewicht; // in kg

    Person(String name, String vorname) {
        this.name = name;
        this.vorname = vorname;
        this.groesse = randomGroesse();
        this.gewicht = randomGewicht();
    }

    private static int randomGewicht() {
        return gewichtUntergrenze + getRandomInt(gewichtObergrenze - gewichtUntergrenze);
    }

    private static int randomGroesse() {
        return groesseUntergrenze + getRandomInt(groesseObergrenze - groesseUntergrenze);
    }

    private static int getRandomInt(int ceilingExclusive) {
        Random random = new Random();
        return random.nextInt(ceilingExclusive);
    }

    public int getGroesse() {
        return groesse;
    }

    public void setGroesse(int groesse) {
        this.groesse = groesse;
    }

    public int getGewicht() {
        return gewicht;
    }

    public void setGewicht(int gewicht) {
        this.gewicht = gewicht;
    }

    int getBMI() {
        float meter = (float) this.groesse / 100;
        return (int) (this.gewicht / Math.pow(meter, 2));
    }

    String getName() {
        return name;
    }

    String getVorname() {
        return vorname;
    }

    @Override
    public String toString() {
        return this.vorname + " " + this.name + " [" + this.gewicht + "kg bei " + this.groesse + "cm = BMI " + this.getBMI() + " - " + this.getBMIclass() + "]";
    }

    String getBMIclass() {
        if (this.getBMI() < 16) {
            return "Starkes Untergewicht";
        } else if (this.getBMI() >= 16 && this.getBMI() < 17) {
            return "Mäßiges Untergewicht";
        } else if (this.getBMI() >= 17 && this.getBMI() < 18.5) {
            return "Leichtes Untergewicht";
        } else if (this.getBMI() >= 25 && this.getBMI() < 30) {
            return "Präadipositas";
        } else if (this.getBMI() >= 30 && this.getBMI() < 35) {
            return "Adipositas Grad I";
        } else if (this.getBMI() >= 35 && this.getBMI() < 40) {
            return "Adipositas Grad II";
        } else if (this.getBMI() > 40) {
            return "Adipositas Grad III";
        }
        return "Normalgewicht";
    }
}
