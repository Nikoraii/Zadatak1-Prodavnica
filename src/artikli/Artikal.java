package artikli;

public abstract class Artikal {
    protected String naziv;
    protected int cena;

    public Artikal(String naziv, int cena) {
        this.naziv = naziv;
        this.cena = cena;
    }

    public String getNaziv() {
        return naziv;
    }

    public int cenaZaKolicinu(int kolicina) {
        return kolicina * this.cena;
    }
}

