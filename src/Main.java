/**
 * Created by MariusDK on 19.08.2017.
 */
public class Main {

    public static void main(String[] args)
    {
        Algoritm algoritm=new Algoritm();
        CitireFisier citireFisier=new CitireFisier();
        //algoritm.level1(citireFisier.readFile());
        System.out.println(citireFisier.readFile());
        algoritm.level2(citireFisier.readFile());
    }
}
