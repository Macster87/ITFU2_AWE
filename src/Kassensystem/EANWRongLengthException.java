package Kassensystem;

public class EANWRongLengthException extends EANException {
    public EANWRongLengthException() {
        super("EAN Code has the wrong length. Must be 8 or 13.");
    }
}
