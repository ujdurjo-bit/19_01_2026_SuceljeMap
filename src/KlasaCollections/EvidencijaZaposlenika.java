package KlasaCollections;
/*Napiši program za evidenciju polaznika na tečaju koji osigurava jedinstvenost e-mail adresa polaznika
te nasumično mijenja redoslijed polaznika prije ispisa.
Program treba omogućiti unos polaznika i njihovih podataka, provjeriti jesu li e-mail adrese jedinstvene
te ispisati polaznike u nasumičnom redoslijedu.
        Koristi klasu Polaznik s atributima: ime, prezime i e-mail.
        Koristi HashMap<String, Polaznik> za pohranu polaznika, gdje je ključ e-mail adresa, a vrijednost objekt klase Polaznik.
        Napravi glavnu klasu EvidencijaPolaznika koja sadrži main metodu.
        Omogući korisniku unos novih polaznika (ime, prezime, e-mail).
        Pri dodavanju novog polaznika, provjeri je li e-mail adresa već prisutna u evidenciji. Ako je, ispiši odgovarajuću poruku i ne dopusti
        unos polaznika s istom e-mail adresom.
        Nakon unosa svih polaznika, nasumično izmiješaj redoslijed polaznika prije ispisa.
        Ispiši sve polaznike na tečaju u nasumičnom redoslijedu.*/

import modules.Polaznik;

import java.util.*;

public class EvidencijaZaposlenika {
    public static void main(String[] args) {

        HashMap<String, modules.Polaznik> map = new HashMap<>();
        //ako želimo da bude sortirano po emailu uzlazno
        //TreeMap<String, Polaznik> map = new TreeMap<>();

        Scanner sc = new Scanner(System.in);

        map.put("ana@gmail.com", new Polaznik("Ana", "Anić", "ana@gmail.com"));
        map.put("pero@gmail.com", new Polaznik("Pero", "Perić", "pero@gmail.com"));
        map.put("ivan@gmail.com", new Polaznik("Ivan", "Horvat", "ivan@gmail.com"));
        map.put("jure@gmail.com", new Polaznik("Jure", "Jurić", "jure@gmail.com"));
        map.put("brane@gmail.com", new Polaznik("Brane", "Branić", "brane@gmail.com"));


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
                        System.err.println("Polaznik s emailom :" + email + " već postoji!");
                    } else {
                        Polaznik noviPolaznik = new Polaznik(ime, prezime, email);
                        map.put(email, noviPolaznik);

                        System.out.println("Polaznik uspješno dodan!");
                    }
                    break;


                case 2:
                    // Ispis svih polaznika

                    ArrayList<Polaznik> listaPolaznika = new ArrayList<>(map.values());
                    Collections.shuffle(listaPolaznika);

                    System.out.println("\nNasumični redoslijed: ");
                    for (Polaznik p : listaPolaznika) {
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

