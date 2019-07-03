public class Labyrinth {

    private static String[][] labyrinth;

    private static String strFeld[] =
            {
                    "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",
                    "XXXXXXXXXXXXXXXXXXXXXXX        XXXXXXX XX          Z",
                    "XS                 XXXX XXXXXXXXXX     XX XXXXXXX XX",
                    "XXXXXXXXXXXXXXXXXX XXXX XXX    XXX XXXXXX XXXXXXX XX",
                    "XXXXXX   XXXXXXXXX XXXX XXX XX XXX XXXXXX XXXXXXX XX",
                    "XXXXXX XXXX        XXXX XXX XX XXX XXXXXX XXXXXXX XX",
                    "XXXXXX XXXX XXXXXX XXXX XXX XX     XX XXX XXXXXXX XX",
                    "XXXXXX XXXX XXXXXX XXXX XXX XXXXXXXXX XXX XXXXXXX XX",
                    "XXXXXX XXXX XXXXXX XXXX XXX XXXXXXXXX XXX X       XX",
                    "XXXXXX      XXXXXX                        XXXXXXXXXX",
                    "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" };

    private static boolean validMatrix(String[] inputFeld) {
        boolean valid = true;

        // Alle Strings im Array müssen gleich lang sein.
        for (String element: inputFeld
             ) {
            if (element.length() != inputFeld[0].length()) {
                valid = false;
            }
        }

        // Das String Array muss mindestens 3 Zeilen haben.
        if (inputFeld.length < 3) {
            valid = false;
        }

        return valid;
    }

    private static void createMatrix(String[] inputFeld) {
        if (validMatrix(inputFeld)) {
            labyrinth = new String[inputFeld.length][inputFeld[0].length()];
        }
    }

    public static void main(String[] args) {
        createMatrix(strFeld);

        System.out.println(strFeld.length);
        System.out.println(strFeld[0].length());
    }
}
