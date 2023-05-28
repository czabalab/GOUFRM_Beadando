import java.io.FileWriter;
import java.io.IOException;

public class Mentes {
    public static void mentesEredmenyek(String eredmenyek, String fajlNev) {
        try {
            FileWriter writer = new FileWriter(fajlNev);
            writer.write(eredmenyek + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Hiba történt a fájl mentése során: " + e.getMessage());
        }
    }

    public static void mentesGyoztes(String gyoztesNev, String fajlNev) {
        try {
            FileWriter writer = new FileWriter(fajlNev, true);
            writer.write("A gyoztes: " + gyoztesNev + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Hiba történt a fájl mentése során: " + e.getMessage());
        }
    }
}
