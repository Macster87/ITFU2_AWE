import java.util.Random;


public class Sorticus {
    // Vorgegebene Arrays
    private static int[] a1 = {10, 20, 1, 8, 9};
    private static int[] a2 = {1, 2, 17, 3, 8};
    private static int[] a3 = {5, 6, 22, 80, 2};
    private static int[] a4 = {7, 8, 42, 2, 2, 4711};
    private static int[] a5 = {80, 8086, 6502, 68000, -753};

    // Zufalls-Deklaration
    private static final Random rnd = new Random();

    /**
     * Methode zur Bestimmung der Position der kleinsten Zahl in einem Array. Ähnlich wie die Methode in der Klasse "Methode"
     * jedoch mit einem zusätzlichem Start-Parameter, wenn man die Suche von anderer Stelle aus vorwärts ausführen möchte.
     * @param input Ein beliebiges Array mit Integer-Zahlen
     * @param start Startposition. Die Suche wird rechts dieser Position ablaufen.
     * @return Die Positions-Nummer im Array der kleinsten Zahl im gewähltem Abschnitt.
     */
    private static int getSmallestNumberPosition(int[] input, int start) {
        int min = 2147483647;

        for(int i = start; i < input.length; i++) {
            if(input[i] < min) {
                min = input[i];
                start = i;
            }
        }
        return start;
    }

    /**
     * Standard Selection-Sort Algorithmus
     * @param input Ein beliebiges Array mit Integer-Zahlen
     * @return Jenes Array aufsteigend sortiert
     */
    private static int[] selectionSort(int[] input) {

        int tmp;

        for(int i = 0; i < input.length-1; i++) {
            int position = getSmallestNumberPosition(input, i+1);
                if(input[position] < input[i]) {
                    tmp = input[position];
                    input[position] =  input[i];
                    input[i] = tmp;
                }
        }

        return input;
    }

    /**
     * Standard Bubble-Sort Algorithmus
     * @param input Ein beliebiges Array mit Integer-Zahlen
     * @return Jenes Array aufsteigend sortiert
     */
    private static int[] bubbleSort(int[] input) {
        boolean finished = false;

        int tmp;
        int changes = 1;

        while(changes != 0) {
            changes = 0;
            for(int i = 0; i < input.length-1; i++) {
                if(input[i] > input[i+1]) {
                    tmp = input[i];
                    input[i] =  input[i+1];
                    input[i+1] = tmp;
                    changes++;
                }
            }
        }
        return input;
    }

    /**
     * Hilfsfunktion zur Ausgabe eines Arrays in der Konsole
     * @param input Ein beliebiges Array mit Integer-Zahlen
     */
    private static void showArray(int[] input) {
        for(int item : input) {
            System.out.print(item + " ");
        }
    }

    /**
     * Eine spezielle Form der showArray-Funktion, die auf einem anderen Aufgabenzettel gefordert wurde.
     * Diese Funktion zeigt die ersten 5 und die letzten 5 Elemente des Arrays.
     * @param input Ein beliebiges Array mit Integer-Zahlen
     */
    private static void showArrayFiveFive(int[] input) {
        if(input.length<10) {
            for(int item : input) {
                System.out.print(item + " ");
            }
        } else {
            System.out.print(input[0] + " ");
            System.out.print(input[1] + " ");
            System.out.print(input[2] + " ");
            System.out.print(input[3] + " ");
            System.out.print(input[4] + " ");
            System.out.print("... ");
            System.out.print(input[input.length-5] + " ");
            System.out.print(input[input.length-4] + " ");
            System.out.print(input[input.length-3] + " ");
            System.out.print(input[input.length-2] + " ");
            System.out.print(input[input.length-1] + " ");
        }

    }

    /**
     * Erzeugt einen Array der Länge n und füllt ihn mit Zufallszahlen von 0 bis n. Misst dabei die Zeit.
     * @param n Länge des zu erzeugenden Arrays und zugleich maximalgrenze für den Zufallsgenerator
     * @return Zeit für das Sortieren
     */
    private static int speedtest(int n) {
        int[] array = new int[n];
        for(int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(n);
        }
        long start = System.nanoTime();
        int[] result = selectionSort(array);
        long ende = System.nanoTime();

        showArrayFiveFive(result);
        System.out.println();

        return (int) (ende-start);
    }

    public static void main(String[] args) {
        // showArray(bubbleSort(a5));
        System.out.println(speedtest(17));
    }

}
