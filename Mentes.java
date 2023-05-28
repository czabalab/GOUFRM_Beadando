import java.io.FileWriter;
import java.io.IOException;

public class Mentes
{
    public static void mentesEredmenyek(String eredmenyek)
    {
        try
        {
            FileWriter writer = new FileWriter("eredmenyek.txt");
            writer.write(eredmenyek);
            writer.close();
            System.out.println("Az eredmények sikeresen mentve lettek az eredmenyek.txt fájlba.");
        } 
        catch (IOException e)
        {
            System.out.println("Hiba történt a fájl mentése során: " + e.getMessage());
        }
    }
}