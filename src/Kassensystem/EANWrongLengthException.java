package Kassensystem;

public class EANWrongLengthException extends EANException {
    public EANWrongLengthException() {
        super("EAN Code has the wrong length. Must be 8 or 13.");
    }
}
