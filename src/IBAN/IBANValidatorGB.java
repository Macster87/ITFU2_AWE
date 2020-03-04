package IBAN;

import java.math.BigInteger;

public class IBANValidatorGB {

    private static String charToNumber(char s) {
        int i = 10;
        char t;
        for(t = 'A'; t <= 'Z'; t++) {
            if(t == s) {
                return Integer.toString(i);
            }
            i++;
        }
        return "";
    }

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

        // Prüfen ob der Anfang "GB" ist
        if (!output.substring(0, 2).equals("GB")) {
            System.out.println("Falsches Land: " + output.substring(0,2));
            return false;
        }

        // Prüfsumme darf nicht über 96 liegen
        if(Integer.parseInt(output.substring(2,4)) > 96) {
            System.out.println("Prüfsumme zu hoch: " + output.substring(2,4));
            return false;
        }

        // Konvertierbar
        String regex = "\\d+";
        if(!output.substring(8).matches(regex)) {
            System.out.println("Nicht konvertierbar");
            return false;
        }

        System.out.println(charToNumber('W') + charToNumber('E') );

        BigInteger number = new BigInteger(charToNumber(output.charAt(4)) +
                                                charToNumber(output.charAt(5)) +
                                                charToNumber(output.charAt(6)) +
                                                charToNumber(output.charAt(7)) +
                                                output.substring(8) + "1611" +
                                                output.substring(2,4)
                                            );
        BigInteger modulo = new BigInteger("97");

        System.out.println(number);

        int result = number.mod(modulo).intValue();
        System.out.println(result);
        return result == 1;
    }
}
