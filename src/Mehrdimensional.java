import java.lang.Math;

public class Mehrdimensional {

    private static char [][] t = {  { 'a', 'b', 'c', 'd'  },
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

    public static void magischesQuadrat(int n) {

        // Erstes wichtiges Kriterium
        if(n%2 == 0) {
            System.out.println("Die Zahl muss ungerade sein !");
        } else {
            int[][] quadrat = new int[n][n];

            int x = 0;
            int y = n/2;

            int k = 1;

            quadrat[x][y] = k;

            while(k < n*n) {
                k++;
                // Fall c) : Muss zuerst wegen Check auf bereits belegte Zelle.
                if ((x - 1 < 0 && y + 1 >= n) || (quadrat[x-1][y+1] != 0)) {
                    y = y + 1;
                    quadrat[x][y] = k;
                // Fall a)
                } else if(x-1 < 0 && y+1 < n) {
                    x = n-1;
                    y = y+1;
                    quadrat[x][y] = k;
                // Fall b)
                } else if(x-1 < n && y+1 >= n) {
                    x = x-1;
                    y = 0;
                    quadrat[x][y] = k;
                // Normalfall
                } else {
                    x = x - 1;
                    y = y + 1;
                    quadrat[x][y] = k;
                }
            }


            //System.out.println(quadrat[0][n/2]);
            showQuadrat(quadrat);
        }
    }

    // Hilfsmethode zur Ausgabe des Quadrats in der Konsole
    private static void showQuadrat(int[][] quadrat) {
        for(int i = 0; i < quadrat[0].length; i++) {
            for(int j = 0; j < quadrat[0].length; j++) {
                System.out.print(quadrat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //EinsA();
        //EinsB();
        //EinsC();
        magischesQuadrat(7);
    }
}
