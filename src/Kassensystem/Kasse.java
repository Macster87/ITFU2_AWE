package Kassensystem;

import java.util.Scanner;

public class Kasse {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws EANException {
        System.out.println(validChecksum(scannerInput()));
    }

    static long scannerInput() throws EANException {
        System.out.print("Zahl eingeben:");
        return zahlEingeben(scanner.next());
    }

    static long zahlEingeben(String scannerInput) throws EANException {
        long ean;
        try {
            ean = Long.parseLong(scannerInput);
        } catch(NumberFormatException e) {
            throw new EANWrongDigitException();
        }

        if(!validLength(ean)) {
            throw new EANWrongLengthException();
        }
        if(!validChecksum(ean)) {
            throw new EANWrongChecksumException();
        }

        return ean;
    }

    static boolean validLength(long ean) {
        return Long.toString(ean).length() == 8 || Long.toString(ean).length() == 13;
    }

    static boolean validChecksum(long input) {
        int checksum = 0;
        String ean = Long.toString(input);
        boolean drei = Long.toString(input).length() == 8;

        for (char digit:ean.toCharArray()
             ) {
            int zahl = Integer.parseInt(Character.toString(digit));

            if(drei) {
                checksum = checksum + 3*zahl;
            } else {
                checksum = checksum + zahl;
            }
            drei=!drei;
        }
        return checksum % 10 == 0;
    }
}
