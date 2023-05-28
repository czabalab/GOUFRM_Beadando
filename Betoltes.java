import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Betoltes {
    public static void main(String[] args) {
        File folder = new File(".");
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));

        if (files != null && files.length > 0) {
            System.out.println("Elérhető fájlok:");
            for (int i = 0; i < files.length; i++) {
                System.out.println(i + 1 + ". " + files[i].getName());
            }

            Scanner scanner = new Scanner(System.in);
            System.out.println("Kérem válasszon egy sorszámot a betöltendő fájlhoz: ");
            int valasztas = scanner.nextInt();

            if (valasztas > 0 && valasztas <= files.length) {
                String fajlNev = files[valasztas - 1].getName();
                System.out.println("A kiválasztott fájl betöltése: " + fajlNev);

                try {
                    Scanner fileScanner = new Scanner(new File(fajlNev));
                    while (fileScanner.hasNextLine()) {
                        String sor = fileScanner.nextLine();
                        System.out.println(sor);
                    }
                    fileScanner.close();
                } catch (FileNotFoundException e) {
                    System.out.println("Hiba történt a fájl betöltése során: " + e.getMessage());
                }
            } else {
                System.out.println("Hibás sorszám. A program kilép.");
            }
        } else {
            System.out.println("Nincsenek elérhető txt fájlok a mappában.");
        }
    }
}
