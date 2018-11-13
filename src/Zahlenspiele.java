class Zahlenspiele {
    
    // Wandelt eine Zahl in eine String Zahl um mit führenden Nullen
    private static String toThree(int zahl) {
        if(zahl < 10) {
            return "00"+Integer.toString(zahl);
        } else if(zahl <= 99) {
            return "0"+Integer.toString(zahl);
        }
        return Integer.toString(zahl);
    }
    
    // Gibt false zurück wenn die Nummer ungültig ist
    private static boolean validNumber(String nummer) {

        return nummer.charAt(0) != nummer.charAt(1) &&
                nummer.charAt(0) != nummer.charAt(2) &&
                nummer.charAt(1) != nummer.charAt(2);
    }
    
    private static void nummernschloss() {
        // Anzahl an Kombinationen, standartmäßig = 10
        int anzahl = 10;
        int gefunden =0;
        
        int zahl = 0;    
        int i = 0;
        String convertedZahl;
        
        while(gefunden<anzahl) {
            //System.out.print(anzahl);
            convertedZahl = toThree(zahl);
            if(validNumber(convertedZahl)) {
                System.out.print(convertedZahl + " ");
                gefunden++;
            }
            zahl++;
            i++;
        }
    }
    
    private static String sternchen(int ziffer, int zahl) {
        
        if(Integer.toString(zahl).contains(Integer.toString(ziffer)) || zahl%ziffer == 0) {
            return " *";
        }
        
        // Formatierung für einstellige Zahlen
        if(zahl < 10) {
            return " " + Integer.toString(zahl);
        }
                
        return Integer.toString(zahl);
    }
    
    @SuppressWarnings("unused")
    public static void zahlentafel(int ziffer) {
        
        if(ziffer <2 || ziffer >9) {
            System.out.println("Die Ziffer muss zwischen 2 und 9 liegen.");
        }
        
        int i = 0;
        int k = 1;
        
        while(i < 100) {
            System.out.print(sternchen(ziffer, i) + " ");
            if(k == 10) {
                System.out.println(" ");
                k = 0;
            }
            k++;
            i++;
        }
        
    } 
    
    public static void main (String[] args) {
        //zahlentafel(7);
        nummernschloss();
    }
}
