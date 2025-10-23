package Problema;

public class SistemDeCalcul extends Echipamente{
    public String tipMon;
    public double vitProc;
    public int c_HDD;
    public SistemOperare sistemOperare;
    public SistemDeCalcul(String denumire, String nr_Inv, double pret, String zonaMagazin, Stare stare, String tipMon, double vitProc, int c_HDD, SistemOperare sistemOperare) {
        super(denumire, nr_Inv, pret, zonaMagazin, stare);
        this.tipMon = tipMon;
        this.vitProc = vitProc;
        this.c_HDD = c_HDD;
        this.sistemOperare = sistemOperare;
    }

    public void setSistemOperare(SistemOperare sistOp) {
        this.sistemOperare=sistOp;
    }
    public void afisare(){
        System.out.println(this);
    }
    public String toString() {
        return "[SistemCalcul] " + super.toString() + ", monitor: " + tipMon +
                ", vitezaProc: " + vitProc + ", HDD: " + c_HDD + ", SO: " + sistemOperare;
    }
}
