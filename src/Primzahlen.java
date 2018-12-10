class Primzahlen {
    private static boolean isPrime(long number) {

        int i = 2;

        while( i < number) {

            if(number%i==0) return false;
            i++;

        }

        return true;
    }

    private static void listOfPrimes(int max) {
        int[] liste = new int[max+1];

        for(int i = 0; i <= max; i++) {
            liste[i] = i;
        }

        liste[1] = 0;

        for(int item:liste) {
            if(item >= 2) {
                for(int k = 2; k*item <= max; k++) {
                    liste[k*item] = 0;
                }
            }
        }

        for(int item:liste) {
            if(item != 0) {
                System.out.print(item + " ");
            }

        }
    }



    public static void main(String[] args) {
        System.out.println("Primzahl ?: " + isPrime(7));
        listOfPrimes(112);
    }
}
