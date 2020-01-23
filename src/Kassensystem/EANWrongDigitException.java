package Kassensystem;

public class EANWrongDigitException extends EANException {
    public EANWrongDigitException() {
        super("Not a valid Number");
    }
}

