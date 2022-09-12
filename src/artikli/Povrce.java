package artikli;

public class Povrce extends Artikal {
    private String jedinicaMere;

    public Povrce(String naziv, int cena, String jedinicaMere) {
        super(naziv, cena);
        this.jedinicaMere = jedinicaMere;
    }

    public String getJedinicaMere() {
        return jedinicaMere;
    }

    @Override
    public String toString() {
        return super.naziv + " [" + super.cena + "/" + this.jedinicaMere + "]";
    }
}
