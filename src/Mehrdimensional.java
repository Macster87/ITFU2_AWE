class Mehrdimensional {

    /* #######################################
    AUFGABENTEIL: Mehrdimensionales Array
    ####################################### */

    private static final char [][] t = {  { 'a', 'b', 'c', 'd'  },
                                    { 'e', 'f', 'g', 'h'  },
                                    { 'i', 'j', 'k', 'l'  } };

    // Aufgabe 1a)
    public static void EinsA() {
        for(int i = 0; i < 3; i++) {
            for(int j = 3; j > -1; j--) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Aufgabe 1b)
    public static void EinsB() {
        for(int i = 2; i > -1; i--) {
            for(int j = 3; j > -1; j--) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Aufgabe 1c)
    public static void EinsC() {
        for(int j = 0; j < 4; j++) {
            for(int i = 0; i < 3; i++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }
    }

    /* #######################################
    AUFGABENTEIL: Magisches Quadrat
    ####################################### */

    private static void magischesQuadrat(int n) {

        // Erstes wichtiges Kriterium: Die Zahl muss ungerade sein, sonst funktioniert das Ganze nicht.
        if(n%2 == 0) {
            System.out.println("Die Zahl muss ungerade sein !");
        } else {
            int[][] quadrat = new int[n][n];

            // Die 1 setzen
            int x = 0;
            int y = n/2; // ungrader int durch 2 geteilt wird automatisch abgerundet
            int k = 1;
            quadrat[x][y] = k;

            // x = Reihe // y = Spalte

            while(k < n*n) {
                // Ersteinmal um 1 erhöhen
                k++;

                // Regel a)
                // Wenn x nach oben raus geht, aber y noch im Rahmen liegt
                if(x-1 < 0 && y+1 <= n-1) {
                    // Koordinaten für diesen Fall setzen:
                    x = n-1;
                    y = y+1;
                //Regel b)
                // Wenn x im Rahmen liegt, aber y nach rechts raus geht
                } else if(x-1 >= 0 && y+1 > n-1) {
                    // Koordinaten für diesen Fall setzen:
                    x = x-1;
                    y = 0;
                // Regel c)
                // Wenn x nach oben raus geht und y nach rechts raus geht ODER wenn das Feld bereits belegt ist.
                } else if((x-1 < 0 && y+1 > n-1) || (quadrat[x-1][y+1] != 0)) {
                    // Koordinaten für diesen Fall setzen:
                    x = x+1;
                // Ansonsten ganz normal: 1 Feld nach oben, 1 Feld nach rechts
                } else {
                    x = x-1;
                    y = y+1;
                }

                // Zahl an den entsprechenden Koordinaten eintragen.
                quadrat[x][y] = k;
            }

            showQuadrat(quadrat);
            checkQuadrat(quadrat);
        }
    }

    // Hilfsmethode zur Ausgabe des Quadrats in der Konsole, damit es schön aussieht
    private static void showQuadrat(int[][] quadrat) {

        // Anzahl an Stellen für die größtmögliche Zahl feststellen.
        int maximaleZahlengroesse = String.valueOf(quadrat[0].length*quadrat[0].length).length();

        for(int i = 0; i < quadrat[0].length; i++) {
            for(int j = 0; j < quadrat[0].length; j++) {
                // String.format() um die Zahl mit entsprechend vorangestellten Leerstellen auszugeben,
                // damit das Quadrat in der Konsole nicht verschoben ist.
                System.out.print(String.format("%"+maximaleZahlengroesse+"d ",quadrat[i][j]));
            }
            System.out.println(); // Neue Zeile
        }
    }

    // Prüfen ob das Quadrat richtig ist, mit der Quersumme jeder Zeile, Spalte und den beiden Diagonalen
    // Für die pure Lösung des Problems nicht notwendig, aber vor allem bei großen Quadraten besser als
    // manuell nachrechnen.
    private static void checkQuadrat(int[][] quadrat) {

        boolean zeilenCheck = true;
        boolean spaltenCheck = true;
        boolean diagonalenCheck = true;

        int checksumme = 0;
        int temp = 0;

        // Zeilen checken
        for(int i = 0; i < quadrat[0].length; i++) {

            for(int j = 0; j < quadrat[0].length; j++) {
                temp = temp + quadrat[i][j];
            }
            if(checksumme == 0) {
                checksumme = temp;
            } else if (temp != checksumme){
                zeilenCheck = false;
            }
            temp = 0;
        }

        // Spalten checken
        for(int i = 0; i < quadrat[0].length; i++) {

            for(int j = 0; j < quadrat[0].length; j++) {
                temp = temp + quadrat[j][i];
            }
            if(checksumme == 0) {
                checksumme = temp;
            } else if (temp != checksumme){
                spaltenCheck = false;
            }
            temp = 0;
        }

        // 1. Diagonalen checken
        for(int i = 0; i < quadrat[0].length; i++) {
            temp = temp + quadrat[i][i];
        }
        if(temp != checksumme) {
            diagonalenCheck = false;
        }
        temp = 0;

        // 2. Diagonale checken
        for(int i = 0; i < quadrat[0].length; i++) {
            temp = temp + quadrat[quadrat[0].length-1][i];
        }
        if(temp != checksumme) {
            diagonalenCheck = false;
        }

        System.out.println();
        System.out.println("Checksumme = " + checksumme);
        System.out.println("Zeilencheck = " + zeilenCheck);
        System.out.println("Spaltencheck = " + spaltenCheck);
        System.out.println("Diagonalencheck = " + diagonalenCheck);

    }

    public static void main(String[] args) {
        //EinsA();
        //EinsB();
        //EinsC();
        magischesQuadrat(9);
    }
}
