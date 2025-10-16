package Laborator3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Parabola {
    private int a, b, c;

    public Parabola(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Punct GetVarf() {
        double xv = -b / (2.0 * a);
        double yv = -(b * b) + (4 * a * c) / (4 * a);
        return new Punct(xv, yv);

    }

    public String toString() {
        return a + "x^2" + b + "x" + c;
    }

    public Punct mijloc(Parabola p) {
        Punct v1 = this.GetVarf();
        Punct v2 = p.GetVarf();
        double xm = (v1.getX() + v2.getX()) / 2.0;
        double ym = (v1.getY() + v2.getY()) / 2.0;
        return new Punct(xm, ym);
    }

    public static Punct mijloc_Static(Parabola p1, Parabola p2) {
        Punct v1 = p1.GetVarf();
        Punct v2 = p2.GetVarf();
        double xm = (v1.getX() + v2.getX()) / 2.0;
        double ym = (v1.getY() + v2.getY()) / 2.0;
        return new Punct(xm, ym);
    }

    public double lungime(Parabola p) {
        Punct v1 = this.GetVarf();
        Punct v2 = p.GetVarf();
        return Math.hypot(v1.getX() - v2.getX(), v1.getY() - v2.getY());
    }

    public static double lungime_Static(Parabola p1, Parabola p2) {
        Punct v1 = p1.GetVarf();
        Punct v2 = p2.GetVarf();
        return Math.hypot(v1.getX() - v2.getX(), v1.getY() - v2.getY());
    }

}
public class pb1 {
    public static void main(String[] args) {
        List<Parabola> parabole = new ArrayList<>();
        String nume_fisier="src/Laborator3/in.txt";

        try (Scanner sc = new Scanner(new File(nume_fisier))) {
            while (sc.hasNextLine()) {
                String linie = sc.nextLine().trim();
                if (linie.isEmpty()) continue;

                String[] parti = linie.split("\\s+");
                if (parti.length == 3) {
                    int a = Integer.parseInt(parti[0]);
                    int b = Integer.parseInt(parti[1]);
                    int c = Integer.parseInt(parti[2]);
                    Parabola p = new Parabola(a, b, c);
                    parabole.add(p);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fișierul in.txt nu a fost găsit!");
            return;
        }
        if (parabole.size() >= 2) {
            Parabola p1 = parabole.get(0);
            Parabola p2 = parabole.get(1);

            Punct mijloc = Parabola.mijloc_Static(p1, p2);
            double lungime = Parabola.lungime_Static(p1, p2);

            System.out.println("Mijlocul segmentului dintre vârfuri: " + mijloc);
            System.out.println("Lungimea segmentului dintre vârfuri: " + lungime);
        } else {
            System.out.println("\nNu există suficiente parabole pentru calcule suplimentare.");
        }

    }
}
