package prodavnica;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Prodavnica {
    private String naziv;
    private String adresa;
    List<Racun> racuni;

    public Prodavnica(String naziv, String adresa) {
        this.naziv = naziv;
        this.adresa = adresa;
        racuni = new ArrayList<>();
    }

    public void dodajRacun(Racun racun) {
        Random random = new Random();
        for (Racun racunLista : racuni) {
            while (racun.getId() == racunLista.getId()) {
                racun.setId(random.nextInt(100000));
            }
        }
        racuni.add(racun);
    }

    public String najskupljiRacun() {
        if (racuni.size() > 0) {
            int i = 0;
            for (Racun racun: racuni) {
                if (racun.ukupnaCena() > racuni.get(i).ukupnaCena()) {
                    i = racuni.indexOf(racun);
                }
            }
            return racuni.get(i).toString();
        }
        return "\n\tGreska! Nema racuna u prodavnici.";
    }

    public String najjeftinijiRacun() {
        if (racuni.size() > 0) {
            int i = 0;
            for (Racun racun: racuni) {
                if (racun.ukupnaCena() < racuni.get(i).ukupnaCena()) {
                    i = racuni.indexOf(racun);
                }
            }
            return racuni.get(i).toString();
        }
        return "\n\tGreska! Nema racuna u prodavnici.";
    }

    public String prosecanRacun() {
        if (racuni.size() > 0) {
            DecimalFormat df = new DecimalFormat("#.###");
            int brojac = 0;
            int cenaSvihRacuna = 0;
            for (Racun racun: racuni) {
                brojac++;
                cenaSvihRacuna += racun.ukupnaCena();
            }
            double resenje = (double) cenaSvihRacuna / brojac;
            return df.format(resenje) + " dinara";
        }
        return "\n\tGreska! Nema racuna u prodavnici.";
    }

    public String racunZaDatum(int dan, int mesec, int godina) {
        for (Racun racun: racuni) {
            if (racun.getDan() == dan && racun.getMesec() == mesec && racun.getGodina() == godina) {
                return "\n" + racun.toString();
            }
        }
        return "\n\tGreska! Ne postoji racun za zadat datum.";
    }

    @Override
    public String toString() {
        String listaRacuna = "";
        for (Racun racun: racuni) {
            listaRacuna += racun + "\n ================================ \n";
        }
        return "Prodavnica: " + this.naziv + ", " + this.adresa
                + "\n ================================"
                + "\nNajskuplji racun: " + najskupljiRacun()
                + "\nNajjeftiniji racun: " + najjeftinijiRacun()
                + "\nProsecna cena racuna: " + prosecanRacun()
                + "\n ================================ \n"
                + listaRacuna;
    }
}
