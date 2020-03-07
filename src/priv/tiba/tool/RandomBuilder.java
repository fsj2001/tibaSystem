package priv.tiba.tool;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class RandomBuilder {
    public static List<Integer> getRandoms(int number, int portion){
        Random random = new Random();
        List<Double> r = new ArrayList<>();
        for (int i = 0; i < portion - 1; i++) {
            r.add(random.nextDouble());
        }
        r.sort(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return o1 < o2 ? -1 : 1;
            }
        });
        List<Integer> out = new ArrayList<>();
        int last = 0;
        for (int i = 0; i < portion - 1; i++) {
            int c = (int) (r.get(i) * number);
            out.add(c - last);
            last = c;
        }
        out.add(number - last);

        return out;
    }
}
