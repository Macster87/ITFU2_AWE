package t1p;

public class Schueler extends Person {

    protected int stufe;
    protected int abijahrgang;
    protected final String lieblingsessen;

    public Schueler(String pName, int pGeburtsjahr, int stufe, int abijahrgang) {
        super(pName, pGeburtsjahr);
        this.abijahrgang = abijahrgang;
        this.stufe = stufe;
        this.lieblingsessen = "Pizza";
    }

    public int getStufe() {
        return stufe;
    }

    public int getAbijahrgang() {
        return abijahrgang;
    }

    public String getLieblingsessen() {
        return lieblingsessen;
    }

    public void schreibeInfo(){
        super.schreibeInfo();
        System.out.println("Ich bin in der "+stufe+". Stufe und Abi-Jahrgang "+abijahrgang+".");
        System.out.println("Mein Lieblingsessen ist "+lieblingsessen+".");
    }

}
