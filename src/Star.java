import java.util.ArrayList;

/**
 * Created by MariusDK on 19.08.2017.
 */
public class Star {
    private String starName;
    private int n;
    private ArrayList<Integer> L;

    public Star(String starName, int n, ArrayList<Integer> l) {
        this.starName = starName;
        this.n = n;
        L = l;
    }

    public Star() {
    }

    public String getStarName() {
        return starName;
    }

    public void setStarName(String starName) {
        this.starName = starName;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public ArrayList<Integer> getL() {
        return L;
    }

    public void setL(ArrayList<Integer> l) {
        L = l;
    }
}
