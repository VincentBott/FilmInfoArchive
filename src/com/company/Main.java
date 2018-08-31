package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Figuur[] figuren = new Figuur[4];
        for (int i = 0; i < 2; i++) {
            System.out.print("Geef zijde van vierkant: ");
            int zijde = Integer.parseInt(scanner.nextLine());
            figuren[i] = new VierKant(zijde);
        }
        for (int i = 2; i < figuren.length; i++) {
            System.out.print("Geef straal van cirkel: ");
            int straal = Integer.parseInt(scanner.nextLine());
            figuren[i] = new Cirkel(straal);
        }
        Arrays.sort(figuren);
        for (Figuur f : figuren) {
            System.out.printf("Een %s met oppervlakte %.2f%n", f, f.getOppervlakte());
        }
    }

}

