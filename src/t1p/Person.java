package t1p;

public class Person {
    // Attribute
    protected String name;
    protected int geburtsjahr;

    // Konstruktor
    public Person(String pName, int pGeburtsjahr){
        name = pName;
        geburtsjahr = pGeburtsjahr;
    }
    // get-Methoden
    public String getName(){
        return name;
    }
    public int getGeburtsjahr(){
        return geburtsjahr;
    }

    // Ausgabe in Konsole
    public void schreibeInfo(){
        System.out.println("Mein Name ist "+name+".");
        System.out.println("Ich bin im Jahr "+geburtsjahr+" geboren.");
    }
}
