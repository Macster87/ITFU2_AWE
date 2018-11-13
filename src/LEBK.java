

/*
 *
 * @author Mapster
 */
class LEBK {
    
    //1
    private static void eins() {
        int a = 100_000;
        int b = a * a / a;
        System.out.printf("%d * %d / %d = %d\n",a,a,a,b);
        // Overflow, weil 100k*100k übersteigt Integer
    }
    
    //2
    private static void zwei() {
        int c = 0b0111_1111_1111_1111_1111_1111_1111_1111;
        int d = c+1;
        System.out.printf("%d + 1 = %d\n",c,d);
        //Overflow weil Integer zuende
    }
    
    //3
    private static void drei() {
        int e = 3;
        int f = 6;
        int g = 8;
        System.out.printf("%d / %d * %d = %d\n",e,f,g,e/f*g);
        //Komma-Zahl passt nicht in Integer
    }
    
    //4
    private static void vier() {
        float flo = 123456789F;
        System.out.printf("%.0f + 1 = %.0f \n",flo,(flo + 1));
        // Breaking News: Fließkomma ist ungenau !
    }
    
    //5
    private static void fuenf() {
        float w = 0.0F;
        int cnt = 0;
        while (w < 100) {
        w += 0.1;
        cnt ++;
        }
        System.out.printf("%d Schritte\n", cnt);
        // Breaking News: Fließkomma ist ungenau !
    }
    
    //6
    private static void sechs() {
        double xd = 1;
        double yd = 0;
        int xi = 1;
        //int yi = 0;
        System.out.println(xd/yd);
        System.out.println(xi/yd);
        //System.out.println(xd/yi); // ERROR: Durch 0 geteilt
        System.out.println(yd/yd);
        //System.out.println(xi/yi); // ERROR: Durch 0 geteilt
    }
    
    //7
    private static void sieben() {
        int a = 3;
        int b = 4;
        String s1 = " String ";
        String s2 = a + s1;
        String s3 = s1 + a;
        String s4 = a + b + s1;
        String s5 = s1 + a + b;
        System.out.printf("%s|%s|%s|%s|%s\n",s1,s2,s3,s4,s5);
        // Java rechnet stur von links nach rechts
    }
    
    //8
    private static void acht() {
        String s1 = "Brat";
        String s2 = "wurst";
        String s3 = "Bratwurst";
        String s4 = s1+s2;
        System.out.println(s3.equals(s4));
        // Überprüft auf Identität und nicht auf Gleichheit
    }
    
    public static void main(String[] args) {
        eins();
        zwei();
        drei();
        vier();
        fuenf();
        sechs();
        sieben();
        acht();
    }
    
}
