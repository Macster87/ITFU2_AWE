package t1p;

public class Lehrer extends Person {
    // Attribute
    private String erstesFach;
    private String zweitesFach;

    // Konstruktor
    public Lehrer(String name, int geburtsjahr, String erstesFach, String zweitesFach) {
        super(name, geburtsjahr);
        this.erstesFach = erstesFach;
        this.zweitesFach = zweitesFach;
    }

    // get-Methoden
    public String getErstesFach() {
        return erstesFach;
    }

    public String getZweitesFach() {
        return zweitesFach;
    }

    // Ausgabe in Konsole
    public void schreibeInfo(){
        super.schreibeInfo();
        System.out.println("Ich unterrichte "+erstesFach+" und "+zweitesFach+".");
    }
}