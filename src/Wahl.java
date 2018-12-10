import java.util.Scanner;

class Wahl {

    private static final int anzahlKandidaten = 20;

    private static final int[] liste = new int[anzahlKandidaten+1];
    private static final Scanner input = new Scanner(System.in);
    private static double[] prozentliste = new double[anzahlKandidaten+1];
    private static int gesamtStimmen = 0;

    private static int getStimmen(int kandidat) {
        return liste[kandidat];
    }

    private static double percentOf(int kandidat, int gesamtStimmen) {
        return (double)(liste[kandidat]/gesamtStimmen)*100;
    }

    private static void wahldurchgang() {

        boolean wahlvorgang = true;

        while(wahlvorgang) {
            int wahl = input.nextInt();

            // Abbruch wenn Negativ
            if(wahl < 0) {
                wahlvorgang = false;



             // Ungültige Stimmen auf liste[0] ablegen
            } else if(wahl > anzahlKandidaten) {
                liste[0]++;
                System.out.println("Ungültige Stimme");
            // Normale Stimme ablegen
            } else {
                liste[wahl]++;
                gesamtStimmen++;
                System.out.println("Eine Stimme für " + wahl);
            }
        }
    }

    public static void main(String[] args) {
        wahldurchgang();
    }



}
