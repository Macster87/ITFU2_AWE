public class Methode {

    // Vorgegebene Arrays
    private static int[] a1 = {10, 20, 1, 8, 9};
    private static int[] a2 = {1, 2, 17, 3, 8};
    private static int[] a3 = {5, 6, 22, 80, 2};
    private static int[] a4 = {7, 8, 42, 2, 2, 4711};
    private static int[] a5 = {80, 8086, 6502, 68000, -753};


    /**
     * Eine Methode um in einem gegebenen Array die Position(!) der kleinsten Zahl
     * zurückzugeben. Wenn in einem Array 2 oder mehr Zahlen die Kleinste sind (siehe a4),
     * dann soll die Erste, die weiter links steht als Position zurückgegeben werden.
     *
     * Dazu gehen wir das Array mit einer ForEach-Schleife durch und merken uns die Aktuelle Position, sowie
     * die bisher kleinste. Das Problem mit den 2 gleichen kleinsten Zahlen umgehen wir, indem wir im if-Block ein
     * Kleiner (<) statt einem Kleiner-Gleich (<=) verwenden.
     *
     * @param input Ein beliebiges Array mit Integer-Zahlen
     * @return Die Positions-Nummer im Array der kleinsten Zahl.
     */
    private static int getSmallestNumber(int[] input) {

        int smallestPosition = 0;
        int currentPosition = 0;

        for(int element : input) {
            if(element < input[smallestPosition]) {
                smallestPosition = currentPosition;
            }
            currentPosition++;
        }

        return smallestPosition;
    }

    public static void main(String[] args) {
        System.out.println("A1 -> " + getSmallestNumber(a1));
        System.out.println("A2 -> " + getSmallestNumber(a2));
        System.out.println("A3 -> " + getSmallestNumber(a3));
        System.out.println("A4 -> " + getSmallestNumber(a4));
        System.out.println("A5 -> " + getSmallestNumber(a5));
    }
}
