package Problema;

public class Copiator extends Echipamente{
    public int pTon;
    public FormatCopiere formatCopiere;

    public Copiator(String denumire, String nr_Inv, double pret, String zonaMagazin, Stare stare, int pTon, FormatCopiere formatCopiere) {
        super(denumire, nr_Inv, pret, zonaMagazin, stare);
        this.pTon = pTon;
        this.formatCopiere = formatCopiere;
    }

    public void setFormatCopiere(FormatCopiere formCop) {
         this.formatCopiere=formCop;
    }
    public void afisare(){
        System.out.println(this);
    }

    public String toString(){
        return "[Copiator] " + super.toString() + ", pTon: " + pTon + ", format: " + formatCopiere;
    }
}
