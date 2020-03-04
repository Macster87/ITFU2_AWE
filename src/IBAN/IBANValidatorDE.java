package IBAN;

import java.math.BigInteger;

public class IBANValidatorDE {

    static boolean isValid(String iban) {

        // Entferne Leerzeichen
        String output = iban.replaceAll("\\s", "");
        output = output.toUpperCase();

        System.out.println(output);

        // Länge prüfen
        if(output.length() != 22) {
            System.out.println("Falsche Länge: " + output.length());
            return false;
        }

        // Prüfen ob der Anfang "DE" ist
        if (!output.substring(0, 2).equals("DE")) {
            System.out.println("Falsches Land: " + output.substring(0,2));
            return false;
        }

        if(Integer.parseInt(output.substring(2,4)) > 96) {
            System.out.println("Prüfsumme zu hoch: " + output.substring(2,4));
            return false;
        }

        // Konvertierbar
        String regex = "\\d+";
        if(!output.substring(2).matches(regex)) {
            System.out.println("Nicht konvertierbar");
            return false;
        }

        BigInteger number = new BigInteger(output.substring(4) + "1314" + output.substring(2,4));
        BigInteger modulo = new BigInteger("97");

        System.out.println(number);

        int result = number.mod(modulo).intValue();
        System.out.println(result);
        return result == 1;
    }
}
