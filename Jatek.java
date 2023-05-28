import java.util.Random;

public class Jatek
{
    public static void main(String[] args)
    {
        Varazslo varazslo = new Varazslo();
        Harcos harcos = new Harcos();
        int jatekterMeret = 3;

        Random rand = new Random();

        // Kezdetben random helyre állítjuk a karaktereket a játéktéren
        int varazsloPozicio = rand.nextInt(jatekterMeret) + 1;
        int harcosPozicio = rand.nextInt(jatekterMeret) + 1;

        // Játék ciklus
        while (varazslo.getEletero() > 0 && harcos.getEletero() > 0)
        {
            // Kirajzoljuk a játéktért
            rajzolJatekter(jatekterMeret, varazsloPozicio, harcosPozicio);

            // Kiírjuk a karakterek pozícióját és életerejét
            System.out.println("Varazslo pozicio: " + varazsloPozicio + ", Eletero: " + varazslo.getEletero());
            System.out.println("Harcos pozicio: " + harcosPozicio + ", Eletero: " + harcos.getEletero());

            // Ha a karakterek egymás mellett vannak, harcolnak
            if (Math.abs(varazsloPozicio - harcosPozicio) == 1)
            {
                int varazsloSebzes = rand.nextInt(6) + 1;
                int harcosSebzes = rand.nextInt(6) + 1;

                varazslo.sebez(harcosSebzes);
                harcos.sebez(varazsloSebzes);

                System.out.println("Varazslo sebzese: " + varazsloSebzes);
                System.out.println("Harcos sebzese: " + harcosSebzes);
            }

            // Pozíció váltás
            varazsloPozicio = pozicioValtas(varazsloPozicio, harcosPozicio, jatekterMeret);
            harcosPozicio = pozicioValtas(harcosPozicio, varazsloPozicio, jatekterMeret);

            System.out.println("----------------------------------");
        }

        // Kiírjuk a győztes nevét
        if (varazslo.getEletero() > 0)
        {
            System.out.println("A gyoztes: Varazslo");
        } else {
            System.out.println("A gyoztes: Harcos");
        }
    }

    // Játéktér kirajzolása
    private static void rajzolJatekter(int meret, int varazsloPozicio, int harcosPozicio)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= meret; i++)
        {
            if (i == varazsloPozicio && i == harcosPozicio)
            {
                sb.append("X");
            } else if (i == varazsloPozicio)
            {
                sb.append("V");
            } else if (i == harcosPozicio)
            {
                sb.append("H");
            } else
            {
                sb.append("_");
            }
        }
        System.out.println(sb.toString());
    }

    // Pozíció váltás
    private static int pozicioValtas(int aktualisPozicio, int masikPozicio, int jatekterMeret)
    {
        Random rand = new Random();
        int ujPozicio;

        do
        {
            ujPozicio = rand.nextInt(jatekterMeret) + 1;
        } while (ujPozicio == aktualisPozicio || ujPozicio == masikPozicio);

        return ujPozicio;
    }
}