public class Rekursion {
    void rek1(int n) {
        if (n > 0) {
            System.out.println(n);
            rek1(n - 1);
        } else {
            System.out.println("Bumm");
        }
    }

    void rek2(int n) {
        if (n > 0) {
            rek2(n - 1);
            System.out.println("Nach:" + n);
        }
    }

    void rek3(int n) {
        if (n > 0) {
            System.out.println("Vor:" + n);
            rek3(n - 1);
            System.out.println("Nach:" + n);
        }
    }

    int sum(int n) {
        return n == 0 ? 0 : n+sum(n - 1);
    }

    int fakultaet(int n) {
        return n == 1 ? 1 : n * fakultaet(n - 1);
    }

    int whatever(int n) {
        return n == 1 || n == 2 ? 1 : whatever(n-1) + whatever(n-2);
    }

    public static void main(String[] args) {
        Rekursion r = new Rekursion();
        /* System.out.println("\nEins:\n====");
        r.rek1(5);
        System.out.println("\nZwei:\n====");
        r.rek2(5);
        System.out.println("\nDrei:\n====");
        r.rek3(5);

        System.out.println("\nSum:\n====");
        System.out.println(r.sum(4)); */
        
        //System.out.println( r.fakultaet(4));
        System.out.println( r.whatever(12));
    }
}
