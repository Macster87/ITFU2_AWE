package Bankkonten;

import java.util.ArrayList;
import java.util.Date;

class Kunde {
    ArrayList<Konto> konten = new ArrayList<Konto>();
    String name;
    String addresse;
    Date geburtsdatum;

    Kunde(String name, String addresse, Date geburtsdatum, Konto konto) {
        this.name = name;
        this.addresse = addresse;
        this.geburtsdatum = geburtsdatum;
        addKonto(konto);
    }

    void addKonto(Konto konto) {
        this.konten.add(konto);
        Bank.konten.add(konto);
    }

    void removeKonto(Konto konto) {
        this.konten.remove(konto);
        Bank.konten.remove(konto);
        if(this.konten.isEmpty()) {
            Bank.kunden.remove(this);
        }
    }

    ArrayList<Konto> getKonten() {
        return this.konten;
    }
}
