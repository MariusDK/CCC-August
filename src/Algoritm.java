import java.util.ArrayList;

/**
 * Created by MariusDK on 19.08.2017.
 */
public class Algoritm {

    public ArrayList<Star> IdentificareDate(String date)
    {
        String[] Date=date.split(" ");
        int nrStele=convertStringToInt(Date[0]);
        ArrayList<Star> sList=new ArrayList<>();
        int i=1;
        while (i<Date.length)
        {
            Star s=new Star();
            s.setStarName(Date[i]);
            i++;
            int n=convertStringToInt(Date[i]);
            s.setN(n);
            i++;
            ArrayList<Integer> list=new ArrayList<>();
            for (int j=0;j<n;j++)
            {
                int elem=convertStringToInt(Date[i]);
                list.add(elem);
                i++;
            }
            s.setL(list);
            sList.add(s);
        }
        return sList;

    }
    public void level1(String date)
    {
        ArrayList<Star> sList=new ArrayList<>();
        sList=IdentificareDate(date);
        String output="";
        for (int i=0;i<sList.size();i++)
        {
            output=output+" "+formatStar(sList.get(i));
        }
        System.out.println(output);
    }
    public void level2(String date)
    {
        ArrayList<Star> sList=new ArrayList<>();
        sList=IdentificareDate(date);
        String output="";
        for (int i=0;i<sList.size();i++)
        {
            output=output+" "+detectEvent(sList.get(i));
        }
        System.out.println(output);
    }
    public String detectEvent(Star s)
    {
        String fStar;
        fStar=""+s.getStarName();
        int solarFlareCount=0;
        int transitFeatureCount=0;
        int randomEvent=0;
        int number=0;
        int distance=0;
        boolean ultim=false;
        for (int i=0;i<s.getL().size();i++)
        {
            if (s.getL().get(0).equals(s.getL().get(i)))
            {
                distance++;
            }
            else{
                if (distance>=5) {
                    if (ultim!=true)
                    {
                        if ((s.getL().get(i).equals(s.getL().get(i + 1)))) {
                            number++;
                            if (s.getL().size()==i+2) {
                                ultim = true;
                            }
                        }else {
                            if ((1 <= number) && (number <= 15)) {
                                if ((s.getL().get(i).compareTo(s.getL().get(0))) > 0) {
                                    solarFlareCount++;
                                    distance=0;
                                } else {
                                    if (verificareCondTransit(s.getL().get(0), s.getL().get(i))) {
                                        if (number >= 5) {
                                            transitFeatureCount++;
                                            distance=0;
                                        }
                                    }
                                }
                            }else {randomEvent++;}
                            number = 1;
                        }

                        if ((s.getL().get(0).equals(s.getL().get(i + 1)))) {
                            distance = 0;
                        }
                    }
                    else
                    {
                        if ((1 <= number) && (number <= 15)) {
                            if ((s.getL().get(i).compareTo(s.getL().get(0))) > 0) {
                                solarFlareCount++;
                            } else {
                                if (verificareCondTransit(s.getL().get(0), s.getL().get(i))) {
                                    if (number >= 5) {
                                        transitFeatureCount++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if ((transitFeatureCount+solarFlareCount+randomEvent)==5)
            {
                break;
            }
        }
            fStar=fStar+" "+solarFlareCount+" "+transitFeatureCount;
        return fStar;
    }
    public boolean verificareCondTransit(int nivel,int a)
    {
        double nr=(double)a;
        double lv=(double)nivel;
        double s=lv-lv*(0.5/100);
        if (nr<=s)
        {
            return true;
        }
        return false;
    }
    public String formatStar(Star s)
    {
        String fStar;
        fStar=""+s.getStarName();
        int number=1;
        for (int i=0;i<s.getL().size();i++)
        {
            if (i+1==s.getL().size()) {
                fStar = fStar + " " + s.getL().get(i) + " " + number;
            }
            else {
                if (s.getL().get(i).equals(s.getL().get(i + 1))) {
                    number++;
                } else {
                    fStar = fStar + " " + s.getL().get(i) + " " + number;
                    number = 1;
                }
            }
        }
        return fStar;
    }
    public int convertStringToInt(String s)
    {
        int nr=Integer.parseInt(s);
        return nr;
    }

}
