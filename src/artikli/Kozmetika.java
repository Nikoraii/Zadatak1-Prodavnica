package artikli;

public class Kozmetika extends Artikal {

    public Kozmetika(String naziv, int cena) {
        super(naziv, cena);
    }

    @Override
    public String toString() {
        return super.naziv + " [" + super.cena + "]";
    }
}
