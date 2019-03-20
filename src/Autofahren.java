public class Autofahren {
    public static void main(String[] args) {
        Auto a = new Auto("meins", "rot");
        Auto b = new Auto("deins", "blau");

        System.out.println("Auto A Geschwindigkeit: "+ a.getGeschwindigkeit());
        System.out.println("Auto A Farbe: "+ a.getFarbe());

        System.out.println();

        System.out.println("Auto B Geschwindigkeit: "+ b.getGeschwindigkeit());
        System.out.println("Auto B Farbe: "+ b.getFarbe());

        System.out.println();

        Auto c = new Auto();
        System.out.println("Auto C Eigentümer: "+ c.getEigentuemer());
        System.out.println("Auto C Farbe: "+ c.getFarbe());
    }
}
