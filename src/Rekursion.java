public class Rekursion {
    static void rek1(int n) {
        if (n > 0) {
            System.out.println(n);
            rek1(n - 1);
        } else {
            System.out.println("Bumm");
        }
    }

    static void rek2(int n) {
        if (n > 0) {
            rek2(n - 1);
            System.out.println("Nach:" + n);
        }
    }

    static void rek3(int n) {
        if (n > 0) {
            System.out.println("Vor:" + n);
            rek3(n - 1);
            System.out.println("Nach:" + n);
        }
    }

    static int sum(int n) {
        return n == 0 ? 0 : n + sum(n - 1);
    }

    static int fakultaet(int n) {
        return n == 1 ? 1 : n * fakultaet(n - 1);
    }

    static int quersumme(int n) {
        return n <= 9 ? n : quersumme( quersumme(n/10) + n%10);
    }

    static int fibonacci(int n) {
        return n == 1 || n == 2 ? 1 : fibonacci(n-1) + fibonacci(n-2);
    }

    static int binominalkoeffizient(int n, int k) {
        if(k > n || k < 0) {return 0;}
        if((k == 0) || (n == k)) {return 1;}
        return (n * binominalkoeffizient(n - 1, k - 1) / k);
    }

    public static void main(String[] args) {
        System.out.println("\nEins:\n====");
        rek1(5);
        System.out.println("\nZwei:\n====");
        rek2(5);
        System.out.println("\nDrei:\n====");
        rek3(5);

        System.out.println("\nSum:\n====");
        System.out.println(sum(4));

        System.out.println("\nFakultät:\n====");
        System.out.println( fakultaet(4));
        System.out.println("\nFibonacci:\n====");
        System.out.println( fibonacci(12));
        System.out.println("\nQuersumme:\n====");
        System.out.println(quersumme(321));
        System.out.println("\nBinominalkoeffizient:\n====");
        System.out.println(binominalkoeffizient(49, 6));
    }
}
