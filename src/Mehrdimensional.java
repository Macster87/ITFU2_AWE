class Mehrdimensional {

    private static final char [][] t = {  { 'a', 'b', 'c', 'd'  },
                                    { 'e', 'f', 'g', 'h'  },
                                    { 'i', 'j', 'k', 'l'  } };

    public static void EinsA() {
        for(int i = 0; i < 3; i++) {
            for(int j = 3; j > -1; j--) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void EinsB() {
        for(int i = 2; i > -1; i--) {
            for(int j = 3; j > -1; j--) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void EinsC() {
        for(int j = 0; j < 4; j++) {
            for(int i = 0; i < 3; i++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }
    }

    /* ##########################
    AUFGABEN: Magisches Quadrat
    ########################## */

    private static void magischesQuadrat(int n) {

        // Erstes wichtiges Kriterium
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
                    x = n-1;
                    y = y+1;
                //Regel b)
                // Wenn x im Rahmen liegt, aber y nach rechts raus geht
                } else if(x-1 >= 0 && y+1 > n-1) {
                    x = x-1;
                    y = 0;
                // Regel c)
                // Wenn x nach oben raus geht und y nach rechts raus geht.
                } else if(x-1 < 0 && y+1 > n-1) {
                    x = x+1;
                } else if(quadrat[x-1][y+1] != 0) {
                    x = x+1;
                } else {
                    x = x-1;
                    y = y+1;
                }

                quadrat[x][y] = k;
            }

            showQuadrat(quadrat);
            checkQuadrat(quadrat);
        }
    }

    // Hilfsmethode zur Ausgabe des Quadrats in der Konsole, damit es schön aussieht
    private static void showQuadrat(int[][] quadrat) {

        int maximaleZahlengroesse = getDigits(quadrat[0].length * quadrat[0].length);

        for(int i = 0; i < quadrat[0].length; i++) {
            for(int j = 0; j < quadrat[0].length; j++) {
                // Leerzeichen vor die Zahlen wenn sie entsprechend klein sind
                StringBuilder result = new StringBuilder();
                for(int m = 0; m < maximaleZahlengroesse-getDigits(quadrat[i][j]); m++) {
                    result.append(" ");
                }

                System.out.print(result.toString() + quadrat[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Hilfsmethode: Anzahl an Stellen in einer Integer-Zahl
    // Notwendig um bei showQuadrat() entsprechend viele Leerzeichen einzufügen, damit die Zahlen in der Konsole gut ausgerichtet sind.
    private static int getDigits(int number) {
        if (number < 100000) {
            if (number < 100) {
                if (number < 10) {
                    return 1;
                } else {
                    return 2;
                }
            } else {
                if (number < 1000) {
                    return 3;
                } else {
                    if (number < 10000) {
                        return 4;
                    } else {
                        return 5;
                    }
                }
            }
        } else {
            if (number < 10000000) {
                if (number < 1000000) {
                    return 6;
                } else {
                    return 7;
                }
            } else {
                if (number < 100000000) {
                    return 8;
                } else {
                    if (number < 1000000000) {
                        return 9;
                    } else {
                        return 10;
                    }
                }
            }
        }
    }

    // Prüfen ob das Quadrat richtig ist, mit der Quersumme jeder Zeile, Spalte und den beiden Diagonalen
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
