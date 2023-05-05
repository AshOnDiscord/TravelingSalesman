class main {
  public static void main(String[] args) {
      final long startTime = System.currentTimeMillis();
      int[][] spots = {
      {0, 6, 12, 5},
      {6, 0, 8, 9},
      {12, 8, 0, 13},
      {5, 9, 13, 0},
    };
    brute2d(spots);

    final long endTime = System.currentTimeMillis();

    System.out.println("Total execution time: " + (endTime - startTime));
  }
  public static void brute2d(int[][] spots) {
    for (int i = 0; i < spots.length; i++) {
      if (i == 0) continue;
      for (int j = 0; j < spots.length; j++) {
        if (j == 0 || j == i) continue;
        for (int k = 0; k < spots.length; k++) {
          if (k == 0 || k == i || k == j) continue;
          int pathLength = spots[0][i] + spots[i][j] + spots[j][k] + spots[k][0];
          System.out.println("home -> " + i + " -> " + j + " -> " + k + " -> home = " + pathLength);
        }
      }
    }
  }
}
