import java.util.Random;

public class Harcos
{
    private int eletero;

    public Harcos()
    {
        Random rand = new Random();
        eletero = rand.nextInt(6) + 4;  // dobókockával dobott szám: 1-6, +3
    }

    public int getEletero()
    {
        return eletero;
    }

    public void sebez(int sebzes)
    {
        eletero -= sebzes;
    }
}