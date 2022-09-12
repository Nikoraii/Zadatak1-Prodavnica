package artikli;

public class Voce extends Artikal {
    private String tip;
    private String jedinicaMere;

    public Voce(String naziv, int cena, String tip, String jedinicaMere) {
        super(naziv, cena);
        this.tip = tip;
        this.jedinicaMere = jedinicaMere;
    }

    public String getJedinicaMere() {
        return jedinicaMere;
    }

    @Override
    public String toString() {
        return super.naziv + "-" + this.tip + " [" + super.cena + "/" + this.jedinicaMere + "]";
    }
}
