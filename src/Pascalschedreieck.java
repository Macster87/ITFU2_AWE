public class Pascalschedreieck {

    private static void pascal(int n) {

        int[][] mainarray = new int[n][];
        int pascalStart = 1;

        for(int i = 0; i < n; i++) {
            mainarray[i] = new int[i+1];
        }

        showPascal(mainarray);
    }

    private static void showPascal(int[][] d) {
        for(int i = 0; i < d.length; i++) {
            for(int j = 0; j < d[i].length; j++) {
                System.out.print(d[i][j] + " ");
            }
            System.out.println(); // Neue Zeile
        }
    }

    public static void main(String[] args) {
        pascal(5);
    }
}
