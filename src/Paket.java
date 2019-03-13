public class Paket {

    private int length;
    private int width;
    private int height;

    private String klasse;
    private double preis;

    public Paket(int l, int w, int h) {
        this.length = l;
        this.width = w;
        this.height = h;

        int sides;
        if(istWuerfel()) {
            sides = height + length;
        } else {
            if(length > width && length > height) {
                if(width > height) {
                    sides = length + height;
                } else {
                    sides = length + width;
                }
            } else if( width > length && width > height) {
                if(length > height) {
                    sides = width + height;
                } else {
                    sides = width + length;
                }
            } else {
                if(length > width) {
                    sides = height + width;
                } else {
                    sides = height + length;
                }
            }
        }

        if(sides <= 50) {
            klasse = "S";
            preis = 6.90;
        } else if(sides > 50 && sides <= 80) {
            klasse = "M";
            preis = 11.90;
        } else if(sides > 80 && sides <= 120) {
            klasse = "L";
            preis = 15.90;
        } else if(sides > 120 && sides <= 150) {
            klasse = "XL";
            preis = 27.90;
        }

    }

    public double getGurtmass() {
        if(istWuerfel()) {
            return 5*height;
        } else {
            if(length > width && length > height) {
                return length+2*width+2*height;
            } else if( width > length && width > height) {
                return width+2*length+2*height;
            } else {
                return height+2*length+2*width;
            }
        }
    }

    public double getPreis() {
        return preis;
    }

    public double getVolumen() {
        return (height*length*width)/1000.0;
    }

    public double getFlaeche() {
        return (2*(height*length)+2*(height*width)+2*(length*width))/10000.0;
    }

    public String getKlasse() {
        return klasse;
    }

    public boolean istWuerfel() {
        return height == width && width == length;
    }

    public static void main(String[] args) {
        Paket p = new Paket(60,45,70);
        //Paket p = new Paket(90,90,90);
        System.out.println("Paketklasse : "+p.getKlasse());
        System.out.println("Preis       : "+p.getPreis() + " €");
        System.out.println("Volumen     : "+p.getVolumen() + " l");
        System.out.println("Fläche      : "+p.getFlaeche() + " m2");
        System.out.println("Gurtmass    : "+p.getGurtmass() + " cm");
        System.out.println("Würfel      : "+p.istWuerfel());
    }

}
