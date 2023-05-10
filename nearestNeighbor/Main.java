import java.util.ArrayList;

public class Main {
    public static final int HOUSES = 4;
    public static final int[][] distances = {
            { 0, 6, 12, 5 },
            { 6, 0, 8, 9 },
            { 12, 8, 0, 13 },
            { 5, 9, 13, 0 },
    };
    public static final String[] names = {
            "Home", "Aldo", "Butch", "Cassidy",
    };

    public static void main(String[] args) {
        final long start = System.currentTimeMillis();
        ArrayList<Integer> history = new ArrayList<Integer>();
        history.add(0);
        Params result = new Params(0, 0, 0, history);

        for (int i = 0; i < HOUSES; i++) {
            result = recurse(result);
        }

        for (int i = 0; i < result.history.size(); i++) {
            if (i == result.history.size() - 1) {
                System.out.print(names[result.history.get(i)]);
                break;
            }
            System.out.print(names[result.history.get(i)] + " -> ");
        }

        System.out.println(": " + result.sum);
        final long end = System.currentTimeMillis();

        System.out.println("Runtime: " + (end - start) + "ms");
    }

    public static Params recurse(Params params) {
        params.count++;

        if (params.count == HOUSES) {
            params.history.add(0);
            params.sum += distances[params.house][0];
            return params;
        }

        Selection least = new Selection(distances[params.house][1], 1);

        while (params.history.contains(least.path) || least.path == params.house) {
            least.path++;
            least.distance = distances[params.house][least.path];
        }

        for (int path = 1; path < HOUSES; path++) {
            if (distances[params.house][path] == 0 || params.history.contains(path)) {
                continue;
            }
            if (distances[params.house][path] < least.distance) {
                least.distance = distances[params.house][path];
                least.path = path;
            }
        }

        params.sum += least.distance;
        params.history.add(least.path);
        params.house = least.path;

        return params;
    }
}

class Selection {
    public int distance;
    public int path;

    public Selection(int distance, int path) {
        this.distance = distance;
        this.path = path;
    }
}

class Params {
    public int house;
    public int sum;
    public int count;
    public ArrayList<Integer> history;

    public Params(int house, int sum, int count, ArrayList<Integer> history) {
        this.house = house;
        this.sum = sum;
        this.count = count;
        this.history = history;
    }
}