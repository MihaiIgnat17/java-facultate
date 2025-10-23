package Problema;

public class Imprimanta extends Echipamente{
    private int ppm;
    private String dpi;
    private int p_car;
    private ModTiparire modTiparire;
    public Imprimanta(String denumire, String nr_Inv, double pret, String zonaMagazin, Stare stare, int ppm, String dpi, int p_car, ModTiparire modTiparire) {
        super(denumire, nr_Inv, pret, zonaMagazin, stare);
        this.ppm = ppm;
        this.dpi = dpi;
        this.p_car = p_car;
        this.modTiparire = modTiparire;
    }

    public void setModTiparire(ModTiparire mod) {
        this.modTiparire=mod;
    }
    public void afisare(){
        System.out.println(this);
    }
    public String toString(){
        return "[Imprimanta] " + super.toString() + ", ppm: " + ppm + ", dpi: " + dpi +
                ", pCar: " + p_car + ", modTiparire: " + modTiparire;
    }
}
