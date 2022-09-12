package prodavnica;

import artikli.Artikal;
import prodavnica.Prodavnica;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Racun {
    private int id;
    HashMap<Artikal, Integer> artikliRacun;
    LocalDate trenutniDatum = LocalDate.now();
    int dan;
    int mesec;
    int godina;

    public Racun(){
        artikliRacun = new HashMap<>();
        this.dan = trenutniDatum.getDayOfMonth();
        this.mesec = trenutniDatum.getMonthValue();
        this.godina = trenutniDatum.getYear();
        Random random = new Random();
        this.id = random.nextInt(100000);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getDan() {
        return dan;
    }

    public int getMesec() {
        return mesec;
    }

    public int getGodina() {
        return godina;
    }

    public void dodajArtikal(Artikal artikal, int kolicina) {
        artikliRacun.put(artikal, kolicina);
    }

    public int ukupnaCena() {
        int ukupnaCena = 0;
        for (Artikal artikal: artikliRacun.keySet()) {
            ukupnaCena += artikal.cenaZaKolicinu(artikliRacun.get(artikal));
        }
        return ukupnaCena;
    }

    @Override
    public String toString() {
        String datum = this.trenutniDatum.format(DateTimeFormatter.ofPattern("dd.MM.yyy."));
        String racun =  "\nRacun br. " + this.id + " (" + datum + ")";
        for (Artikal artikal: artikliRacun.keySet()) {
            racun += "\n - " + artikal + "\t\t" + artikliRacun.get(artikal) + "\t\t"
                    + artikal.cenaZaKolicinu(artikliRacun.get(artikal));
        };
        return racun + "\n Ukupna cena: " + ukupnaCena() + " dinara\n";
    }
}
