package Ex3;

import java.io.*;
import java.util.*;

public class Ex3
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);


        System.out.print("Introduceti sirul initial: ");
        String sir = sc.nextLine();
        StringBuilder sb = new StringBuilder(sir);


        System.out.print("Introduceti sirul care va fi inserat: ");
        String Sir_Inserat = sc.nextLine();

        System.out.print("Introduceti pozitia unde doriti sa inserati (0 - " + sb.length() + "): ");
        int pozitieInsert = sc.nextInt();
        sc.nextLine();

        if (pozitieInsert >= 0 && pozitieInsert <= sb.length()) {
            sb.insert(pozitieInsert, Sir_Inserat);
            System.out.println("Dupa inserare: " + sb.toString());
        } else {
            System.out.println("Pozitie invalida!");
        }

        System.out.print("Introduceti pozitia de inceput a stergerii: ");
        int startStergere = sc.nextInt();

        System.out.print("Introduceti numarul de caractere de sters: ");
        int nrCaractere = sc.nextInt();

        int finalStergere = startStergere + nrCaractere;
        if (startStergere >= 0 && finalStergere <= sb.length()) {
            sb.delete(startStergere, finalStergere);
            System.out.println("Dupa stergere: " + sb.toString());
        } else {
            System.out.println("Parametri invalizi pentru stergere!");
        }

        sc.close();
    }
}

