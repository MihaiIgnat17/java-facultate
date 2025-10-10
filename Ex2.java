package Ex2;

import java.io.*;
import java.util.*;

class Vers {
    private String text;

    public Vers(String text){
        this.text=text;
    }

    public int GetNumarCuvinte(){
        if(text.trim().isEmpty())
            return 0;
        return text.trim().split(" ").length;

    }

    public int GetNumarVocale(){
        int count=0;
        if(text.trim().isEmpty())
            return 0;
        for(char c:text.toLowerCase().toCharArray()){
            if("aeiou".indexOf(c)!=-1){
                count++;
            }
        }
        return count;
    }
    public boolean seTerminaCu(String grupare) {
        return text.toLowerCase().endsWith(grupare.toLowerCase());
    }

    public String GetText(){
        return text;
    }

    public String CuMajuscule(){
        return text.toUpperCase();
    }
}

public class Ex2
{
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        List<Vers> versuri=new ArrayList<Vers>();

        System.out.print("Introduceti gruparea pentru marcarea cu *: ");
        String grupare = sc.nextLine().trim();

        String nume_fisier_in="src/Ex2/cantec_in.txt";
        try(BufferedReader br=new BufferedReader(new FileReader(nume_fisier_in))) {
            String linie;
            while ((linie = br.readLine()) != null) {
                versuri.add(new Vers(linie));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String nume_fisier_out="src/Ex2/cantec_out.txt";
        try(PrintWriter pw = new PrintWriter(new FileWriter(nume_fisier_out))) {
            Random rand=new Random();

            for(Vers v:versuri){
                double nr= rand.nextDouble();
                String textFinal=v.GetText();

                if(nr<0.1) {
                    textFinal=v.CuMajuscule();
                }

                StringBuilder linieNoua = new StringBuilder();
                linieNoua.append(textFinal);
                if(v.seTerminaCu(grupare)){
                    linieNoua.append(" *");
                }
                linieNoua.append("   ").append(v.GetNumarCuvinte());
                linieNoua.append("   ").append(v.GetNumarVocale());

                pw.println(linieNoua);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

