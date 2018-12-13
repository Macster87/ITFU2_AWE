public class Pascalschedreieck {

    private static void pascal(int n) {
        int[][] mainarray = new int[n][];

        for(int i = 1; i < n; i++) {
            int[] subarray = new int[i];
            subarray[i] = 1;
            mainarray[i] = subarray;
        }

        showPascal(mainarray);
    }

    private static void showPascal(int[][] d) {
        for(int i = 0; i < d.length; i++) {
            for(int j = 0; j < d[i].length; j++) {
                System.out.print(String.format("%3d ",d[i][j]) + " ");
            }
            System.out.println(); // Neue Zeile
        }
    }

    public static void main(String[] args) {
        pascal(3);
    }
}
