package Bankkonten;

import java.security.InvalidParameterException;

public class Kontonummer {
    private long prefix;
    private long kontonummer;

    private static long[] counter = new long[10];

    Kontonummer(long prefix) {
        if(prefix <= 0 || prefix >= 10) {
            throw new InvalidParameterException("Prefix invalid");
        } else if(counter[(int) prefix] == 999999999) {
            throw new ArrayIndexOutOfBoundsException("Keine Kontonummer mehr übrig für diese Kontoart");
        } else {
            this.prefix = prefix;
            counter[(int) prefix]++;
            this.kontonummer = counter[(int) prefix];
        }
    }

    long getKontonummer() {
        return (prefix*1000000000) + this.kontonummer;
    }

    public String getKontonummerString() {
        return getKontonummer() + "";
    }

    public long getPrefix() {
        return prefix;
    }
}
