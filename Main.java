package Problema;

import java.util.*;
import java.io.*;
public class Main {
    private static List<Echipamente> Echipament=new ArrayList<>();

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            try {
                citireDinFisier("src/Problema/echipamente.txt");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            int opt;
            do {
                System.out.println("\n=== MENIU ===");
                System.out.println("1. Afișare toate echipamentele");
                System.out.println("2. Afișare imprimante");
                System.out.println("3. Afișare copiatoare");
                System.out.println("4. Afișare sisteme de calcul");
                System.out.println("5. Modificare stare echipament");
                System.out.println("6. Setare mod tipărire imprimantă");
                System.out.println("7. Setare format copiere copiator");
                System.out.println("8. Instalare sistem de operare");
                System.out.println("9. Afișare echipamente vândute");
                System.out.println("10. Salvare colecție în echip.bin");
                System.out.println("11. Citire colecție din echip.bin");
                System.out.println("0. Ieșire");
                System.out.print("Alege opțiunea: ");
                opt = sc.nextInt();
                sc.nextLine(); // consumă linia

                switch (opt) {
                    case 1 -> Echipament.forEach(Echipamente::afisare);
                    case 2 -> Echipament.stream().filter(e -> e instanceof Imprimanta).forEach(Echipamente::afisare);
                    case 3 -> Echipament.stream().filter(e -> e instanceof Copiator).forEach(Echipamente::afisare);
                    case 4 -> Echipament.stream().filter(e -> e instanceof SistemDeCalcul).forEach(Echipamente::afisare);
                    case 5 -> modificaStare(sc);
                    case 6 -> setareModTiparire(sc);
                    case 7 -> setareFormatCopiere(sc);
                    case 8 -> instalareSO(sc);
                    case 9 -> Echipament.stream().filter(e -> e.getStare() == Stare.VANDUT).forEach(Echipamente::afisare);
                    case 10 -> serializare("echip.bin");
                    case 11 -> Echipament = deserializare("echip.bin");
                    case 0 -> System.out.println("Program finalizat.");
                    default -> System.out.println("Opțiune invalida!");
                }
            } while (opt != 0);
        }



    String nume_fisier="src/Problema/echipamente.txt";
    private static void citireDinFisier(String nume_fisier) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(nume_fisier))) {
            String line;
            while((line=br.readLine())!=null){
                String[] str=line.split(";");
                String denumire =str[0];
                String nrInv=str[1];
                double pret=Double.parseDouble(str[2]);
                String zona=str[3];
                Stare stare= Stare.valueOf(str[4].toUpperCase());
                String tip= str[5];
                switch (tip){
                    case "imprimanta"-> {
                        int ppm = Integer.parseInt(str[6]);
                        String dpi = str[7];
                        int pCar = Integer.parseInt(str[8]);
                        ModTiparire modTiparire = str[9].equalsIgnoreCase("color") ? ModTiparire.COLOR : ModTiparire.ALB_NEGRU;
                        Echipament.add(new Imprimanta(denumire, nrInv, pret, zona, stare, ppm, dpi, pCar, modTiparire));
                    }
                    case "copiator" -> {
                        int pton = Integer.parseInt(str[6]);
                        FormatCopiere formatCopiere = FormatCopiere.valueOf(str[7].toUpperCase());
                        Echipament.add(new Copiator(denumire, nrInv, pret, zona, stare, pton, formatCopiere));
                    }
                    case "sistem de calcul" ->{
                        String monitor=str[6];
                        Double vitproc=Double.parseDouble(str[7]);
                        int chdd=Integer.parseInt(str[8]);
                        SistemOperare sistemOperare= SistemOperare.valueOf(str[9].toUpperCase());
                        Echipament.add(new SistemDeCalcul(denumire,nrInv,pret,zona,stare,monitor,vitproc,chdd,sistemOperare));
                    }
                }
            }
        }
    }
    private static void modificaStare(Scanner sc) {
        System.out.print("Introdu numărul de inventar: ");
        String nr = sc.nextLine();
        for (Echipamente e : Echipament) {
            if (e.getNr_Inv().equals(nr)) {
                System.out.print("Noua stare (ACHIZITIONAT/EXPUS/VANDUT): ");
                e.setStare(Stare.valueOf(sc.nextLine().toUpperCase()));
                System.out.println("Starea a fost modificata!");
                return;
            }
        }
        System.out.println("Echipamentul nu exista!");
    }
    private static void setareModTiparire(Scanner sc) {
        System.out.print("Nr inventar imprimantă: ");
        String nr = sc.nextLine();
        for (Echipamente e : Echipament) {
            if (e instanceof Imprimanta && e.getNr_Inv().equals(nr)) {
                System.out.print("Mod tipărire (COLOR/ALB_NEGRU): ");
                ((Imprimanta) e).setModTiparire(ModTiparire.valueOf(sc.nextLine().toUpperCase()));
                System.out.println("Modul de tipărire a fost setat!");
                return;
            }
        }
        System.out.println("Imprimanta nu a fost găsita!");
    }
    private static void setareFormatCopiere(Scanner sc) {
        System.out.print("Nr inventar copiator: ");
        String nr = sc.nextLine();
        for (Echipamente e : Echipament) {
            if (e instanceof Copiator && e.getNr_Inv().equals(nr)) {
                System.out.print("Format (A3/A4): ");
                ((Copiator) e).setFormatCopiere(FormatCopiere.valueOf(sc.nextLine().toUpperCase()));
                System.out.println("Formatul a fost setat!");
                return;
            }
        }
        System.out.println("Copiatorul nu a fost găsit!");
    }

    private static void instalareSO(Scanner sc) {
        System.out.print("Nr inventar sistem: ");
        String nr = sc.nextLine();
        for (Echipamente e : Echipament) {
            if (e instanceof SistemDeCalcul && e.getNr_Inv().equals(nr)) {
                System.out.print("Sistem operare (WINDOWS/LINUX): ");
                ((SistemDeCalcul) e).setSistemOperare(SistemOperare.valueOf(sc.nextLine().toUpperCase()));
                System.out.println("Sistemul de operare a fost instalat!");
                return;
            }
        }
        System.out.println("Sistemul nu a fost găsit!");
    }
    String fisier_serializare="src/Problema/ echip.bin";
    public static void serializare(String fisier_serializare) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fisier_serializare))) {
            oos.writeObject(Echipament);
            System.out.println("Colecția a fost salvată în " + fisier_serializare);
        } catch (IOException e) {
            System.out.println("Eroare la serializare: " + e.getMessage());
        }
    }

    public static <Echipament> List<Echipament> deserializare(String fisier_serializare) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fisier_serializare))) {
            System.out.println("Colecția a fost încărcată din " + fisier_serializare);
            return (List<Echipament>) ois.readObject();
        } catch (Exception e) {
            System.out.println("Eroare la deserializare: " + e.getMessage());
            return new ArrayList<>();
        }
    }

}