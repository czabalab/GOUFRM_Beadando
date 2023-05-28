import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Mentes {
    public static void mentesEredmenyek(String eredmenyek) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Szeretnéd menteni az eredményeket? (igen/nem)");
        String valasz = scanner.nextLine();

        if (valasz.equalsIgnoreCase("igen")) {
            try {
                FileWriter writer = new FileWriter("eredmenyek.txt");
                writer.write(eredmenyek);
                writer.close();
                System.out.println("Az eredmények sikeresen mentve lettek az eredmenyek.txt fájlba.");
            } catch (IOException e) {
                System.out.println("Hiba történt a fájl mentése során: " + e.getMessage());
            }
        } else {
            System.out.println("Az eredmények nem lettek mentve.");
        }
    }
}