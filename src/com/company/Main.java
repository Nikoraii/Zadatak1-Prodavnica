package com.company;

import artikli.Artikal;
import artikli.Kozmetika;
import artikli.Povrce;
import artikli.Voce;
import prodavnica.Prodavnica;
import prodavnica.Racun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        // KREIRANJE PRODAVNICE
        Prodavnica prodavnica = new Prodavnica("Prodavnica", "Adresa 123B");

        // ARTIKAL LISTA
        List<Artikal> artikli = new ArrayList<>();
        Artikal a1 = new Povrce("Krastavac", 150, "kg");
        Artikal a2 = new Povrce("Paradajz", 200, "kg");
        Artikal a3 = new Voce("Jagode", 300, "Sveze", "kg");
        Artikal a4 = new Voce("Borovnice", 550, "Smrznuto", "g");
        Artikal a5 = new Kozmetika("Krema za lice", 370);
        Artikal a6 = new Kozmetika("Sampon", 450);
        Collections.addAll(artikli, a1, a2, a3, a4, a5, a6);
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== PRIKAZ SVAKOG ARTIKLA ====");
        for (Artikal artikal: artikli) {
            System.out.println(artikal);
        }
        System.out.println();

        // KREIRANJE RACUNA
        Racun r1 = new Racun();
        r1.dodajArtikal(a1, 5);
        r1.dodajArtikal(a3, 4);

        Racun r2 = new Racun();
        r2.dodajArtikal(a4, 2);
        r2.dodajArtikal(a1, 1);
        r2.dodajArtikal(a6, 2);

        Racun r3 = new Racun();
        r3.dodajArtikal(a5, 6);
        r3.dodajArtikal(a3, 3);

        Racun r4 = new Racun();
        r4.dodajArtikal(a2, 2);
        r4.dodajArtikal(a5, 3);

        System.out.println("==== PRIKAZ SVAKOG RACUNA ====");
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(r4);

        // DODAVANJE RACUNA
        prodavnica.dodajRacun(r1);
        prodavnica.dodajRacun(r2);
        prodavnica.dodajRacun(r3);
        prodavnica.dodajRacun(r4);

        // PRIKAZ RACUNA ZA ZADATI DATUM
        System.out.println("===== RACUN ZA DATUM =====");
        System.out.println("Unesite dan: ");
        int dan = Integer.parseInt(scanner.nextLine());
        System.out.println("Unesite mesec: ");
        int mesec = Integer.parseInt(scanner.nextLine());
        System.out.println("Unesite godinu: ");
        int godina = Integer.parseInt(scanner.nextLine());
        System.out.println("Racun za zadat datum: " + prodavnica.racunZaDatum(dan, mesec, godina));
        System.out.println(prodavnica);
        System.out.println(a5.getNaziv().length());
    }
}