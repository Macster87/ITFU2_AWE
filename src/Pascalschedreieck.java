import java.util.Scanner;

public class Pascalschedreieck {

    private static final Scanner input = new Scanner(System.in);

    private static void pascal(int n) {
        // Die größte Zahl in der Pyramide ist unten in der Mitte.
        // Wenn die Höhe der Pyramide (n) über 29 ist, dann ist jene Zahl größer als ein Integer.
        if (n > 29) {
            System.out.println("Integer-Begrenzung wird überschritten");
        } else {
            int[][] mainarray = new int[n+1][];

            for (int reihe = 0; reihe <= n; reihe++) {

                // Neue Zeile anlegen
                mainarray[reihe] = new int[reihe+1];

                int feld = 1;

                for (int spalte = 0; spalte <= reihe; spalte++) {

                    // Dieser Spezial-Fall muss abgefragt werden, weil wenn im else-Teil die spalte=0 wäre, dann
                    // würde man durch 0 teilen und das mag Java nicht.
                    if(spalte == 0) {
                        feld = 1;
                    } else {
                        feld = feld * ((reihe + 1) - spalte) / spalte;
                    }

                    // Entsprechende Nummer in das Feld schreiben
                    mainarray[reihe][spalte] = feld;
                }
            }
            showPascal(mainarray);
        }
    }

    private static void showPascal(int[][] d) {

        /* Anzahl der Stellen der größten Zahl bestimmen.
           Die ist immer ganz unten in der Mitte.
           Anhand dessen wird die Anzahl der vorangestellten Leerzeichen bestimmt und der
           Abstand für z.B. printf(%6d) weiter unten. Bei max. 3-stelligen Zahlen reicht auch %4d

        Stringbuilder war eine Idee der IDE. Könnte man auch mit String = String + " " machen.*/
        StringBuilder buffer = new StringBuilder();

        /* Die Zahl mit den meisten Stellen ist ganz unten in der Mitte.
           Die Anzahl der Zeichen wird ermittelt um den Multiplikator "buffercount" zu erhalten.
           Dieser hilft beim Erzeugen der vorangestellten Leerzeichen, sowie bei dem Mindestabstand
           in den Feldern wenn z.B. %6d zum Einsatz kommt. */
        int buffercount = String.valueOf(    d[ d.length-1 ]
                                              [ d[d.length-1 ].length/2 ]
                                        ).length();

        if(buffercount%2 != 0) {
            buffercount = (buffercount+1)/2;
        }

        // Aneinanderreihen von Leerzeichen
        for(int i = 1; i <= buffercount; i++) {
            buffer.append(" ");
        }

        // Baum zeichnen
        for (int zeile = 0; zeile < d.length; zeile++) {

            // Vorangestellte Leerzeichen einfügen
            for (int j = d.length - zeile; j > 1; j--) {
                System.out.print(buffer);
            }

            for (int spalte = 0; spalte <= zeile; spalte++) {
                    /* Buffercount * 2 weil der Mindestabstand muss immer ein Vielfaches von 2 sein und gleichzeitig muss
                       der Mindestabstand immer größer sein als die Stellen der Größten Zahl.
                       Beispiel:  Größte Zahl 123 ==> Mindestabstand %4d
                                  Größte Zahl 1234 => Mindestabstand %6d */
                    System.out.printf("%"+buffercount*2+"d", d[zeile][spalte]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Konsoleneingabe
        System.out.println("Höhe des Dreiecks eingeben: ");
        pascal(input.nextInt());
    }
}
