public class Pascalschedreieck {

    private static void pascal(int n) {

        if (n > 29) {
            System.out.println("Integer-Begrenzung wird überschritten");
        } else {
            int[][] mainarray = new int[n+1][];

            for (int reihe = 0; reihe <= n; reihe++) {
                mainarray[reihe] = new int[reihe+1];
                int feld = 1;

                for (int zeile = 0; zeile <= reihe; zeile++) {
                    if(zeile == 0) {
                        feld = 1;
                    } else {
                        feld = feld * ((reihe + 1) - zeile) / zeile;
                    }
                    mainarray[reihe][zeile] = feld;
                }
            }
            showPascal(mainarray);
        }
    }

    private static void showPascal(int[][] d) {

        // Anzahl der Stellen der größten Zahl bestimmen.
        // Die ist immer ganz unten in der Mitte.
        // Anhand dessen wird die Anzahl der vorangestellten Leerzeichen bestimmt und der
        // Abstand für z.B. printf(%6d) weiter unten. Bei max. 3-stelligen Zahlen reicht auch %4d
        StringBuilder buffer = new StringBuilder();
        int buffercount = String.valueOf(d[d.length-1][d[d.length-1].length/2]).length();
        if(buffercount%2 != 0) {
            buffercount = (buffercount+1)/2;
        }

        for(int i = 1; i <= buffercount; i++) {
            buffer.append(" ");
        }

        // Baum zeichnen
        for (int zeile = 0; zeile < d.length; zeile++) {

            //Vorangestellte Leerzeichen einfügen
            for (int j = d.length - zeile; j > 1; j--) {
                System.out.print(buffer);
            }

            for (int spalte = 0; spalte <= zeile; spalte++) {
                    System.out.printf("%"+buffercount*2+"d", d[zeile][spalte]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        pascal(5);
    }
}
