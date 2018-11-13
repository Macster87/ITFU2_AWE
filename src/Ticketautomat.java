@SuppressWarnings({"SameParameterValue", "unused"})
class Ticketautomat {
    
    /*######################################################################
    ATTRIBUTE
    ######################################################################*/
    
    //Ticketpreis
    private final int preis;
    // Summe des bisher eingeworfenen Geldes
    private final int[] bisherGezahlt;
    
    //Münzen
    // [0] = 10Cent, [1] = 20Cent, [2] = 50Cent, [3] = 1Euro, [4] = 2Euro
    private final int[] wechselgeldvorrat;

    /*######################################################################
    KONSTRUKTOR
    ######################################################################*/
    
    private Ticketautomat(int ticketpreis) {
        preis = ticketpreis;
        bisherGezahlt = new int[5];
        wechselgeldvorrat = new int[5];
        
        for(int i = 0; i<5 ; i++) {
            wechselgeldvorrat[i] = 5;
            bisherGezahlt[i] = 0;
        }
    }
    
    /*######################################################################
    HILFSMETHODEN (Zwischenrechnungen und schönere Konsolen-Ausgaben usw.)
    ######################################################################*/
    
    //Zeigt den Status des Wechselgeldvorrats
    private static void zeigeVorrat(int[] block) {
        if(block == null) {
            System.out.println("# Nicht Wechselbar.");
        } else {
            System.out.println(
                block[0]+"x10Cent | "+
                block[1]+"x20Cent | "+
                block[2]+"x50Cent | "+
                block[3]+"x1Euro | "+
                block[4]+"x2Euro | ");
        }   
    }
    
    //Schönere Euro/Cent-Darstellung für die Konsole
    private static String asEuro(int betrag) {
        String ausgabe = "";
        
        if(betrag < 0) {
            ausgabe = "UNGÜLTIG";
        } else if(betrag < 100) {
            ausgabe = betrag + " Cent";
        } else if(betrag % 100 == 0) {
            ausgabe = (betrag / 100) + " €";
        } else if (betrag > 100) {
            ausgabe = (betrag/100) + "," + (betrag%100) + " €";
        } 
        return ausgabe;
    }
    
    //Gibt die Gesamtsumme der Münzen als Integer zurück
    //Nicht zu verwechseln mit "asEuro()" welche einen String zurückgibt für bessere Lesbarkeit
    private static int toCent(int[] block) {
        if(block == null) {
            return 0;
        }
        return block[0]*10 + block[1]*20 + block[2]*50 + block[3]*100 +block[4]*200;
    }
    
    //Geldhaufen addieren
    private int[] addWechselgeldvorrat(int[] haufen1, int[] haufen2) {
        haufen1[0] = haufen1[0] + haufen2[0];
        haufen1[1] = haufen1[1] + haufen2[1];
        haufen1[2] = haufen1[2] + haufen2[2];
        haufen1[3] = haufen1[3] + haufen2[3];
        haufen1[4] = haufen1[4] + haufen2[4];
        return haufen1;
    }
    
    //Geldhaufen subtrahieren
    private void subWechselgeldvorrat(int[] haufen1, int[] haufen2) {
        haufen1[0] = haufen1[0] - haufen2[0];
        haufen1[1] = haufen1[1] - haufen2[1];
        haufen1[2] = haufen1[2] - haufen2[2];
        haufen1[3] = haufen1[3] - haufen2[3];
        haufen1[4] = haufen1[4] - haufen2[4];
    }
    
    /*######################################################################
    Münz Methoden - Weil gefordert...
    ######################################################################*/
    
    private void einwurf10C() {
        einwurf(10);
    }
    
    private void einwurf20C() {
        einwurf(20);
    }
    
    public void einwurf50C() {
        einwurf(50);
    }
    
    public void einwurf1E() {
        einwurf(100);
    }
    
    private void einwurf2E() {
        einwurf(200);
    }
    
    private void einwurf(int einwurf) {
        if(einwurf == 10) {
            wechselgeldvorrat[0]++;
            bisherGezahlt[0]++;
        } else if(einwurf == 20) {
            wechselgeldvorrat[1]++;
            bisherGezahlt[1]++;
        } else if(einwurf == 50) {
            wechselgeldvorrat[2]++;
            bisherGezahlt[2]++;
        } else if(einwurf == 100) {
            wechselgeldvorrat[3]++;
            bisherGezahlt[3]++;
        } else if(einwurf == 200) {
            wechselgeldvorrat[4]++;
            bisherGezahlt[4]++;
        }
        System.out.println("+" + asEuro(einwurf) + " | Gesamt: " + asEuro(toCent(bisherGezahlt)));
        
        //zeigeVorrat(wechselgeldvorrat);
        
        if(toCent(bisherGezahlt) >= preis) {
            ticketAusstellen();
        } else {
            System.out.println("Nicht genug Geld. Noch mindestns " + asEuro(preis-toCent(bisherGezahlt)) + " einwerfen.");
        }
    }
    
    private void ticketAusstellen() {
        ticketDrucken();
        
        System.out.println("Genug Geld. Wechselgeld: " + asEuro(toCent(bisherGezahlt)-preis));
        int[] rueckgeld = wechselbar(toCent(bisherGezahlt)-preis);
        zeigeVorrat(rueckgeld);

        assert rueckgeld != null;
        subWechselgeldvorrat(wechselgeldvorrat, rueckgeld);
    }

    private void ticketDrucken() {
            System.out.println();
            System.out.println("###################################");
            System.out.println("##### Ticket für "+asEuro(preis) + " #####");
            System.out.println("###################################");
            System.out.println();
    }

    private int[] wechselbar(int wechselgeld) {
        int[] benoetigt = new int[5];
        
        for(int i = 0; i<5 ; i++) {
            benoetigt[i] = 0;
        }
        
        if(wechselgeld % 10 != 0) {
            System.out.println("Ungültiger Ticketpreis - Nicht Wechselbar");
            return null;
        }
        
        while(wechselgeld / 200 >= 1 && benoetigt[4] < wechselgeldvorrat[4]) {
            wechselgeld = wechselgeld - 200;
            benoetigt[4]++;
        }
        
        while(wechselgeld / 100 >= 1 && benoetigt[3] < wechselgeldvorrat[3]) {
            wechselgeld = wechselgeld - 100;
            benoetigt[3]++;
        }
        
        while(wechselgeld / 50 >= 1 && benoetigt[2] < wechselgeldvorrat[2]) {
            wechselgeld = wechselgeld - 50;
            benoetigt[2]++;
        }
        
        while(wechselgeld / 20 >= 1 && benoetigt[1] < wechselgeldvorrat[1]) {
            wechselgeld = wechselgeld - 20;
            benoetigt[1]++;
        }
        
        while(wechselgeld / 10 >= 1 && benoetigt[0] < wechselgeldvorrat[0]) {
            wechselgeld = wechselgeld - 10;
            benoetigt[0]++;
        }
            
        if(wechselgeld != 0) {
            System.out.println("Nicht ausreichend Kleingeld - Nicht Wechselbar");
            return null;
        }
        
        return benoetigt;
    }
    
    public void automatLeeren() {
        //Geldkassette wieder auf 5 von jeder Sorte zurücksetzen.
        //Wird nicht genutzt, aber warum nicht...
        for(int i = 0; i<5 ; i++) {
            wechselgeldvorrat[i] = 5;
        }
    }
    
    /*######################################################################
    MAIN-METHODE
    ######################################################################*/

    public static void main(String[] args) {
        //Instanz von Ticketautomat erstellen
        Ticketautomat ticket = new Ticketautomat(270);
        
        //Begrüßung
        System.out.println("### Willkommen, der Ticketpreis beträgt "+asEuro(ticket.preis));
        System.out.println();
        //zeigeVorrat(ticket.wechselgeldvorrat);
        
        ticket.einwurf10C();
        ticket.einwurf20C();
        ticket.einwurf2E();
        ticket.einwurf20C();
        ticket.einwurf20C();
        ticket.einwurf2E();
        
        zeigeVorrat(ticket.wechselgeldvorrat);
    }
}