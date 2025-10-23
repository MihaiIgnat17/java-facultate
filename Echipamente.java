package Problema;

public class Echipamente {
    protected String denumire;
    protected String nr_Inv;
    protected double pret;
    protected String zonaMagazin;
    protected Stare stare;

    public Echipamente(String denumire, String nr_Inv, double pret, String zonaMagazin, Stare stare) {
        this.denumire = denumire;
        this.nr_Inv = nr_Inv;
        this.pret = pret;
        this.zonaMagazin = zonaMagazin;
        this.stare = stare;
    }

    public Stare getStare() {
        return stare;
}
public void setStare(Stare stare) {
        this.stare = stare;
}
public String getNr_Inv() {
        return nr_Inv;
}
public void afisare(){
        System.out.println(this);
}
    @Override
    public String toString() {
        return "Denumire: " + denumire + ", nrInv: " + nr_Inv + ", pret: " + pret + ", zona: " + zonaMagazin + ", stare: " + stare;
    }
}
