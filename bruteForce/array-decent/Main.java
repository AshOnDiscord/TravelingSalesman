public class Main {
  private static final int[][] distances = {
    { 0, 6, 12, 5 },
    { 6, 0, 8, 9 },
    { 12, 8, 0, 13 },
    { 5, 9, 13, 0 }
  };
  private static final String[] lookup = {
    "Home", "Aldo", "Butch", "Cassidy"
  };
  public static void main(String[] args) {
    final long start2 = System.nanoTime();
    final long start = System.currentTimeMillis();

    int min = Integer.MAX_VALUE;
    
    for (int i = 1; i < distances.length; i++) {
      // home -> aldo
      for (int j = 1; j < distances.length; j++) {
        if (j == i) continue;
        // aldo -> butch
        for (int k = 1; k < distances.length; k++) {
          if (k == j || k == i) continue;
          // butch -> cassidy
          int distance = distances[0][i] + distances[i][j] + distances[j][k] + distances[k][0];

          if (distance < min) {
            //System.out.println(lookup[i] + " " + lookup[j] + " " + lookup[k] + ": " + distance);
            // System.out.println(lookup[i] + " ");
            min = distance;
          }
        }
      }
    }
    final long end = System.currentTimeMillis();
    final long end2 = System.nanoTime();
    System.out.println("Runtime: " + (end - start));
    System.out.println("Runtime(NS): " + (end2 - start2));
    System.out.println(min);
  }
}
