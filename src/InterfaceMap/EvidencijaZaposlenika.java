package InterfaceMap;/*Napiši program za evidenciju polaznika na tečaju koji osigurava jedinstvenost e-mail adresa polaznika.
Program treba omogućiti unos polaznika i njihovih podataka te provjeriti jesu li e-mail adrese jedinstvene.

Koristi klasu modules.Polaznik s atributima: ime, prezime i e-mail
Koristi HashMap<String, modules.Polaznik> za pohranu polaznika, gdje će ključ biti e-mail adresa, a vrijednost objekt klase modules.Polaznik.
Napravi glavnu klasu EvidencijaPolaznika koja sadrži main metodu.
Omogući korisniku unos novih polaznika (ime, prezime, e-mail).
Pri dodavanju novog polaznika, provjeri je li e-mail adresa već prisutna u evidenciji polaznika.
Ako je e-mail adresa već prisutna, ispiši odgovarajuću poruku i ne dopusti unos polaznika s istom e-mail adresom.
Omogući ispis svih polaznika na tečaju nakon unosa.

Što bi trebalo izmijeniti u rješenju ako dodamo novi zahtjev?
Svi polaznici moraju biti cijelo vrijeme sortirani po emailu uzlazno*/

import modules.Polaznik;

import java.util.TreeMap;
import java.util.Scanner;

public class EvidencijaZaposlenika {
    public static void main(String[] args) {

        //HashMap<String, modules.Polaznik> map = new HashMap<>();
        //ako želimo da bude sortirano po emailu uzlazno
        TreeMap<String, Polaznik> map = new TreeMap<>();

        Scanner sc = new Scanner(System.in);

        map.put("ana@gmail.com", new Polaznik("Ana", "Anić", "ana@gmail.com"));
        map.put("pero@gmail.com", new Polaznik("Pero", "Perić", "pero@gmail.com"));
        map.put("ivan@gmail.com", new Polaznik("Ivan", "Horvat", "ivan@gmail.com"));


        while (true) {
            System.out.println("\n1. Unos polaznika");
            System.out.println("2. Ispis svih polaznika");
            System.out.println("3. Pretraga po emailu");
            System.out.println("4. Kraj");
            System.out.print("Izbor: ");


            int izbor = sc.nextInt();
            sc.nextLine();

            switch (izbor) {
                case 1:
                    // Unos polaznika
                    System.out.print("Unesite Ime: ");
                    String ime = sc.nextLine();
                    System.out.print("Unesite Prezime: ");
                    String prezime = sc.nextLine();
                    System.out.print("Unesite email: ");
                    String email = sc.nextLine().toLowerCase();


                    if (map.containsKey(email)) {
                        System.err.println("modules.Polaznik s emailom :" + email + " već postoji!");
                    } else {
                        Polaznik noviPolaznik = new Polaznik(ime, prezime, email);
                        map.put(email, noviPolaznik);

                        System.out.println("modules.Polaznik uspješno dodan!");
                    }
                    break;


                case 2:
                    // Ispis svih polaznika
                    for (Polaznik p : map.values()) {
                        System.out.println(p.ime + " " + p.prezime + " - " + p.email);
                    }
                    break;

                case 3:
                    // Pretraga po emailu
                    System.out.print("Unesi email: ");
                    String trazeniEmail = sc.nextLine();


                    Polaznik pronadjeni = map.get(trazeniEmail);
                    if (pronadjeni != null) {
                        System.out.println("Pronađen: " + pronadjeni.ime + " " + pronadjeni.prezime);
                    } else {
                        System.out.println("Nema polaznika s tim emailom.");
                    }

                    break;

                case 4:
                    System.out.println("Program završen.");
                    sc.close();
                    return;

                default:
                    System.err.println("Neispravan izbor!");
            }
        }
    }
}
