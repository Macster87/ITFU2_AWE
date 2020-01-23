package Kassensystem;

public class EANWrongChecksumException extends EANException {
    public EANWrongChecksumException() {
        super("Wrong checksum");
    }
}
