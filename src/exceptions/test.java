package exceptions;

import java.net.MalformedURLException;
import java.net.URL;

public class test {
    static void numberFormat() {
        try {
            Integer.parseInt( "19%" );
        } catch (NumberFormatException e) {
            System.out.println("Kann String nicht in Nummber konvertieren");
        }
    }

    static void urlFormat() throws MalformedURLException {
        String urlstring = "telefon://21234";
        URL url = new URL(urlstring);
    }

    public static void main(String[] args) {
        numberFormat();
        try {
            urlFormat();
        } catch (MalformedURLException e) {
            System.out.println("URL nicht gültig");
        }
    }
}
