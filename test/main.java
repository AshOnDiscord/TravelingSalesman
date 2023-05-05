import java.util.ArrayList;
import java.util.List;

public class main {
    public final int[][] spots = {
            { 0, 6, 12, 5 },
            { 6, 0, 8, 9 },
            { 12, 8, 0, 13 },
            { 5, 9, 13, 0 }
    };
    public static final String START = "home";

    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();
        final main program = new main();
        List<Integer> past = new ArrayList<Integer>();
        System.out.println("e");
        past.add(0);
        program.recursiveAdd(0, 0, past);

        final long endTime = System.currentTimeMillis();

        System.out.println("Total execution time: " + (endTime - startTime));
    }

    public void recursiveAdd(int house, int sum, List<Integer> past) {
        List<Integer> remaining = new ArrayList<Integer>();

        for (int i = 0; i < spots[0].length; i++) {
            if (i == house || past.contains(i)) {
                continue;
            }
            remaining.add(i);
        }

        if (remaining.size() == 0) {
            List<Integer> newPast = new ArrayList<>(past);
            System.out.println(newPast + " " + (sum + spots[house][0]));
            return;
        }

        for (int i = 0; i < remaining.size(); i++) {
            ArrayList<Integer> newPast = new ArrayList<Integer>(past);
            newPast.add(remaining.get(i));
            recursiveAdd(remaining.get(i), sum + spots[house][remaining.get(i)], newPast);
        }
    }

}