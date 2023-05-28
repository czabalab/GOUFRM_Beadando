import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Új játék");
        System.out.println("2. Betöltés");
        System.out.println("Válassz egy menüpontot: ");

        int valasztas = scanner.nextInt();

        switch (valasztas) {
            case 1:
                System.out.println("Új játék indítása...");
                Jatek.main(args);
                break;
            case 2:
                System.out.println("Betöltés...");
                Betoltes.main(args);
                break;
            default:
                System.out.println("Hibás választás.");
                break;
        }
    }
}
