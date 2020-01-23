package Kassensystem;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Long.*;

public class Kasse {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws EANException {
        //System.out.println(zahlEingeben());
        System.out.println(validChecksum(zahlEingeben()));

    }

    static long zahlEingeben() throws EANException {
        long ean = 0;

        try {
            System.out.print("Zahl eingeben:");
            ean = scanner.nextLong();
            if(!validLength(ean)) {
                throw new EANWRongLengthException();
            }
            if(!validChecksum(ean)) {
                throw new EANWrongChecksumException();
            }
        }
        catch (InputMismatchException e) {
            throw new EANWrongDigitException();
        }

        return ean;
    }

    private static boolean validLength(long ean) {
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
