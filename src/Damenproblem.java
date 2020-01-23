public class Damenproblem {

    // Acht Damen auf ein 8x8 Schachfeld, ohne dass sie sich gegenseitig schlagen
    // Mache das auf so viele Arten wie möglich und zeig die Anzahl möglicher Lösungen an.

    private static boolean[][] schachbrett = new boolean[8][8];
    private static int counter = loesungen(schachbrett, 0);

    private static void zeigeSchachbrett() {
        for(int i = 0; i < schachbrett.length;i++) {
            for(int j = 0; j < schachbrett[i].length; j++) {
               if(schachbrett[i][j] = true) {
                   System.out.print("X");
               } else {
                   System.out.print("O");
               }
            }
            System.out.println();
        }
    }

    private static boolean checkLinks(int x, int y) {
        for(int i = x; i >= 0; i--) {
            if (schachbrett[i][y]) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkLinksOben(int x, int y) {
        int i = x;
        int j = y;

        while(i >= 0 && j < schachbrett[0].length  ) {
            if(schachbrett[i][j]) {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }


    private static boolean checkLinksUnten(int x, int y) {
        int i = x;
        int j = y;

        while(i >= 0 && j >= 0) {
            if(schachbrett[i][j]) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }

    private static boolean check(int x, int y) {
        return checkLinks(x, y) && checkLinksOben(x, y) && checkLinksUnten(x, y);
    }

    private static int loesungen(boolean[][] schachbrett, int reihe) {
        if(reihe == schachbrett.length) {
            return 1;
        }

        int counter = 0;
        for(int spalte = 0; spalte < schachbrett.length; spalte++) {
            if(!check(reihe, spalte)) {
                continue;
            }
            schachbrett[reihe][spalte] = true;
            // Rekursion
            counter = counter + loesungen(schachbrett, reihe + 1);
            schachbrett[reihe][spalte] = false;
            //if(counter == 42) zeigeSchachbrett();
        }

        return counter;
    }

    public static void main(String[] args) {
        System.out.println(counter);
    }
}