import java.time.LocalDate;

public class Nakup {
    private LocalDate datum;
    private double cena;

    public Nakup(LocalDate datum, double cena) {
        this.datum = datum;
        this.cena = cena;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }
}
