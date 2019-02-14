import java.util.Random;


public class Sorticus {
    // Vorgegebene Arrays
    private static final int[] a1 = {10, 20, 1, 8, 9};
    private static final int[] a2 = {1, 2, 17, 3, 8};
    private static final int[] a3 = {5, 6, 22, 80, 2};
    private static final int[] a4 = {6, 7, 8, 42,12 , 11, 2, 2, 4711};
    private static final int[] a5 = {80, 8086, 6502, 68000, -753};
    private static final int[] a6 = {9,8,7,6,5,4,3,2,1};
    private static final int[] a7 = {1,5,17,23,43};
    private static final int[] a8 = {1,4,6,7,8,22,160,161,162};

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

    private static int partition(int[] arr, int left, int right)
    {
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];

        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }

        return i;
    }

    private static void quickSort(int[] arr, int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1)
            quickSort(arr, left, index - 1);
        if (index < right)
            quickSort(arr, index, right);
    }

    private static int initiative(int arrayLength) {
        int i = 1;
        while(i < arrayLength) i = i*2;
        return i-1;
    }

    private static int[] preSort(int[] input, int width, int offset) {
        int temp;
        int vergleich;
        for(int i = 1 + offset; i < input.length; i = i + width) {
            temp = input[i];
            vergleich = i-(1+width);
            while (vergleich >= 0 && temp < input[vergleich]) {
                input[vergleich + 1 + width] = input[vergleich];
                vergleich--;
            }
            input[vergleich + 1 + width] = temp;
        }
        return input;
    }

    /**
     * Insertion-Sort Algorithmus
     * Mit Dank von Andrea
     * @param input Ein beliebiges Array mit Integer-Zahlen
     * @return Jenes Array aufsteigend sortiert
     */
    private static int[] insertionSort(int[] input) {
        int temp;
        int vergleich;
        for(int i = 1; i < input.length; i++) {
            temp = input[i];
            vergleich = i-1;
            while (vergleich >= 0 && temp < input[vergleich]) {
                input[vergleich + 1] = input[vergleich];
                vergleich--;
            }
            input[vergleich + 1] = temp;
        }
        return input;
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

    private static int[] bogoSort(int[] input) {

        while (!isSorted(input)) { // Prüfen, ob sortiert
            int a = rnd.nextInt(input.length);
            int b = rnd.nextInt(input.length);

            int tmp = input[a];
            input[a] = input[b];
            input[b] = tmp;
        }

        return input;
    }

    private static boolean isSorted(int[] input) {
        for(int i = 0; i < input.length-1; i++) {
            if(input[i] >= input[i+1]) return false;
        }
        return true;
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
        int[] result = bogoSort(array);
        long ende = System.nanoTime();

        showArrayFiveFive(result);
        System.out.println();

        return (int) (ende-start);
    }

    /**
     * Implementierung von ShellSort
     * @param input Array
     * @return Zeit für das Sortieren
     */
    private static int[] shellSort(int[] input) {

        int abstand = input.length;

        // Start with a big gap, then reduce the gap
        for (int gap = abstand/2; gap > 0; gap /= 2)
        {
            // Do a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already
            // in gapped order keep adding one more element
            // until the entire array is gap sorted
            for (int i = gap; i < abstand; i += 1)
            {
                // add a[i] to the elements that have been gap
                // sorted save a[i] in temp and make a hole at
                // position i
                int temp = input[i];

                // shift earlier gap-sorted elements up until
                // the correct location for a[i] is found
                int j;
                for (j = i; j >= gap && input[j - gap] > temp; j -= gap)
                    input[j] = input[j - gap];

                // put temp (the original a[i]) in its correct
                // location
                input[j] = temp;
            }
        }
        return input;
    }

    /**
     * Verschmilzt zwei (auch unterschiedlich lange) Arrays zu einem und gibt ihn zurück.
     * Die Länge des neuen Arrays ist immer die kombinierte Länge der beiden Inputs
     * @param input1 Array Nummer 1
     * @param input2 Array Nummer 2
     * @return Zeit für das Sortieren
     */
    private static int[] melt(int[] input1, int[] input2) {
        int i = 0;
        int pos1 = 0;
        int pos2 = 0;

        // Die Größe des neuen Arrays ist die kombinierte Länge der beiden input-Arrays
        int[] merge = new int[input1.length+input2.length];

        // Es wird entschieden welche Zahl aus welchem Array gerade an der Reihe ist an den großen Array angehängt
        // zu werden. Der Positions-Integer werden danach für den jeweiligen Array um 1 erhöht.
        while (i<input1.length && pos1 <input2.length)
        {
            if (input1[i] < input2[pos1])
                merge[pos2++] = input1[i++];
            else
                merge[pos2++] = input2[pos1++];
        }

        // Wenn die Arrays nicht gleichlang sind, wird hier der Rest des längeren Arrays angehängt.
        while (i < input1.length)
            merge[pos2++] = input1[i++];
        while (pos1 < input2.length)
            merge[pos2++] = input2[pos1++];

        return merge;
    }

    private static int[] mergeSort(int[] input) {
        // Abbruchbedingung
        if(input.length <= 1) return input;

        // Arrays erstellen und Länge bestimmen
        int[] links;
        int[] rechts = new int[input.length/2];

        if(input.length%2 == 0) {
            links = new int[input.length/2];
        } else {
            links = new int[(input.length/2)+1];
        }

        // Arrays in Links und Rechts kopieren
        System.arraycopy(input, 0, links, 0, links.length);
        System.arraycopy(input, links.length, rechts, 0, input.length / 2);
        // Ohne Java.System Funktion:
        // for(int i = 0; i < arraysize_links; i++) links[i] = input[i];
        // for(int i = 0; i < input.length/2; i++) rechts[i] = input[i+arraysize_links];

        // Rekursiver Aufruf und Rückgabe
        return melt(mergeSort(links), mergeSort(rechts));
    }

    public static void main(String[] args) {
        // showArray(bubbleSort(a5));
        // System.out.println(speedtest(4));

        //int i = 0;
        //int sum = 0;

        //showArray(preSort(a6, 3, 3));

        //Test für Melt()
        //showArray(melt(a7,a8));

        //Test für Shellsort()
        //showArray(shellSort(a5));

        //Test für MergeSort()
        showArray(mergeSort(a7));

        //while(i < 30) {
        //    sum = sum + speedtest(129);
        //    i++;
        //}
        //System.out.println(sum/i);
    }

}
