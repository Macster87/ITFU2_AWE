public class DateTime {

    private int tag;
    private int monat;
    private int jahr;

    public DateTime(int tag, int monat, int jahr) {
        if(tag <= 0 || tag > 31 || monat < 1 || monat > 12) {
            // Throw Exception
        }
        this.tag = tag;
        this.monat = monat;
        this.jahr = jahr;
    }

    public String monatsname() {
        if(monat == 1) {
            return "Januar";
        } else if(monat == 2) {
            return "Februar";
        } else if(monat == 3) {
            return "März";
        }
        return "Dezember";
    }

    public static void main(String[] args) {
        DateTime datum = new DateTime(15,12,2019);

    }

}
