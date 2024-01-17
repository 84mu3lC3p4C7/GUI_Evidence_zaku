import java.time.LocalDate;
import java.util.ArrayList;

public class Zak {
    private String jmeno;
    private String prijmeni;
    private LocalDate datumNarozeni;
    private boolean odsouhlasilGDPR;
    private int rocnik;
    private ArrayList<Nakup> seznamNakupu;

    public Zak(String jmeno, String prijmeni, LocalDate datumNarozeni, boolean odsouhlasilGDPR, int rocnik, ArrayList<Nakup> seznamNakupu) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.datumNarozeni = datumNarozeni;
        this.odsouhlasilGDPR = odsouhlasilGDPR;
        this.rocnik = rocnik;
        this.seznamNakupu = seznamNakupu;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public LocalDate getDatumNarozeni() {
        return datumNarozeni;
    }

    public void setDatumNarozeni(LocalDate datumNarozeni) {
        this.datumNarozeni = datumNarozeni;
    }

    public boolean isOdsouhlasilGDPR() {
        return odsouhlasilGDPR;
    }

    public void setOdsouhlasilGDPR(boolean odsouhlasilGDPR) {
        this.odsouhlasilGDPR = odsouhlasilGDPR;
    }

    public int getRocnik() {
        return rocnik;
    }

    public void setRocnik(int rocnik) {
        this.rocnik = rocnik;
    }

    public ArrayList<Nakup> getSeznamNakupu() {
        return seznamNakupu;
    }

    public void setSeznamNakupu(ArrayList<Nakup> seznamNakupu) {
        this.seznamNakupu = seznamNakupu;
    }
}
