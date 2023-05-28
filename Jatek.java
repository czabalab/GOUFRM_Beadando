import java.util.Random;
import java.util.Scanner;

public class Jatek {
    public static void main(String[] args) {
        Varazslo varazslo = new Varazslo();
        Harcos harcos = new Harcos();
        int jatekterMeret = 3;

        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        // Kezdetben random helyre állítjuk a karaktereket a játéktéren
        int varazsloPozicio = rand.nextInt(jatekterMeret) + 1;
        int harcosPozicio = rand.nextInt(jatekterMeret) + 1;

        // Játékmenet eredményeinek tárolásához használt StringBuilder
        StringBuilder eredmenyek = new StringBuilder();

        // Játék ciklus
        while (varazslo.getEletero() > 0 && harcos.getEletero() > 0) {
            // Kirajzoljuk a játéktért
            rajzolJatekter(jatekterMeret, varazsloPozicio, harcosPozicio);

            // Kiírjuk a karakterek pozícióját és életerejét
            String varazsloAdat = "Varazslo pozicio: " + varazsloPozicio + ", Eletero: " + varazslo.getEletero();
            String harcosAdat = "Harcos pozicio: " + harcosPozicio + ", Eletero: " + harcos.getEletero();
            System.out.println(varazsloAdat);
            System.out.println(harcosAdat);

            // Hozzáadjuk az adatokat az eredményekhez
            eredmenyek.append(varazsloAdat).append("\n");
            eredmenyek.append(harcosAdat).append("\n");

            // Ha a karakterek egymás mellett vannak, harcolnak
            if (Math.abs(varazsloPozicio - harcosPozicio) == 1) {
                int varazsloSebzes = rand.nextInt(6) + 1;  // dobókockával dobott szám: 1-6
                int harcosSebzes = rand.nextInt(6) + 1;  // dobókockával dobott szám: 1-6

                varazslo.sebez(harcosSebzes);
                harcos.sebez(varazsloSebzes);

                String varazsloSebzesAdat = "Varazslo sebzese: " + varazsloSebzes;
                String harcosSebzesAdat = "Harcos sebzese: " + harcosSebzes;
                System.out.println(varazsloSebzesAdat);
                System.out.println(harcosSebzesAdat);

                // Hozzáadjuk az adatokat az eredményekhez
                eredmenyek.append(varazsloSebzesAdat).append("\n");
                eredmenyek.append(harcosSebzesAdat).append("\n");
            }

            // Pozíció váltás
            varazsloPozicio = pozicioValtas(varazsloPozicio, harcosPozicio, jatekterMeret);
            harcosPozicio = pozicioValtas(harcosPozicio, varazsloPozicio, jatekterMeret);
        }

        // Kirajzoljuk a játéktért a végeredményhez
        rajzolJatekter(jatekterMeret, varazsloPozicio, harcosPozicio);

        // Kiírjuk a győztes nevét
        String gyoztesNev = varazslo.getEletero() > 0 ? "Varazslo" : "Harcos";
        System.out.println("A gyoztes: " + gyoztesNev);

        // Opcionális eredmények mentése
        scanner = new Scanner(System.in);
        System.out.println("Szeretnéd menteni az eredményeket? (igen/nem)");
        String valasz = scanner.nextLine();

        if (valasz.equalsIgnoreCase("igen")) {
            // Opcionális eredmények mentése
            String fajlNev = "eredmenyek_" + System.currentTimeMillis() + ".txt";
            Mentes.mentesEredmenyek(eredmenyek.toString(), fajlNev);
            Mentes.mentesGyoztes(gyoztesNev, fajlNev);
        } else {
            System.out.println("Az eredmények nem lettek mentve.");
        }
    }

    // Játéktér kirajzolása
    private static void rajzolJatekter(int meret, int varazsloPozicio, int harcosPozicio) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= meret; i++) {
            if (i == varazsloPozicio && i == harcosPozicio) {
                sb.append("X");
            } else if (i == varazsloPozicio) {
                sb.append("V");
            } else if (i == harcosPozicio) {
                sb.append("H");
            } else {
                sb.append("_");
            }
        }
        System.out.println(sb.toString());
    }

    // Pozíció váltás
    private static int pozicioValtas(int aktualisPozicio, int masikPozicio, int jatekterMeret) {
        Random rand = new Random();
        int ujPozicio;

        do {
            ujPozicio = rand.nextInt(jatekterMeret) + 1;
        } while (ujPozicio == aktualisPozicio || ujPozicio == masikPozicio);

        return ujPozicio;
    }
}
