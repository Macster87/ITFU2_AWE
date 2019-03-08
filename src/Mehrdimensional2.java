public class Mehrdimensional2 {


    static int [][] o = {  { 1,2,3,4  },
            { 5,6,7,8  },
            { 9,10,11,12  } };

    static void showArray(int[][] a) {
        for (int[] ints : a) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(String.format("%3d ", ints[j]) + " ");
            }
            System.out.println(); // Neue Zeile
        }
    }

    public static void main (String[] args) {
        showArray(o);
    }
}
