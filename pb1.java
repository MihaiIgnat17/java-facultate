package Ex1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
import java.util.*;

public class pb1 {
    public static void main(String[] args)
    {

        List<String> listaJudete = new ArrayList<>();
        String nume_fisier="src/Ex1/judete_in.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(nume_fisier))) {
            String linie;
            while ((linie = br.readLine()) != null) {
                linie = linie.trim();
                if (!linie.isEmpty()) {
                    listaJudete.add(linie);
                }
            }
        } catch (IOException e) {
            System.out.println("Eroare la citirea fisierului: " + e.getMessage());
            return;
        }

        String[] judete = listaJudete.toArray(new String[0]);
        Arrays.sort(judete);

        System.out.println("Lista judetelor:");
        for (String j : judete) {
            System.out.println(j);
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("\nIntroduceti un judet pentru a afla poziția: ");
        String judet_cautat = sc.nextLine().trim();

        int poz = Arrays.binarySearch(judete, judet_cautat);

        if (poz >= 0) {
            System.out.println("Judetul \"" + judet_cautat + "\" se afla pe poziția " + poz);
        } else {
            System.out.println("Judetul \"" + judet_cautat + "\" nu se afla în lista incarcata.");
        }

        sc.close();
    }

    }

