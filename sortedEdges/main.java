// CONVERT THIS TO JAVA
// const dists: number[][] = [
//   [0, 6, 12, 5],
//   [6, 0, 8, 9],
//   [12, 8, 0, 13],
//   [5, 9, 13, 0],
// ];

// interface point {
//   distance: number;
//   one: number;
//   two: number;
// }

// const sorted: point[] = [];

// for (let i = 0; i < dists.length; i++) {
//   for (let j = 0; j < dists[i].length; j++) {
//     if (dists[i][j] == 0) continue;
//     if (!sorted.some((point) => point.one == j && point.two == i)) {
//       sorted.push({
//         distance: dists[i][j],
//         one: i,
//         two: j,
//       });
//     }
//   }
// }

// sorted.sort((a, b) => a.distance - b.distance);

// // console.table(sorted);

// // sorted edges traveling salesman problem
// const path: number[] = [];
// const visited: number[] = [];
// const visitedEdges: point[] = [];

// for (let i = 0; i < sorted.length; i++) {
//   // check if the edge would make a loop that doesn't include all nodes or hits a node twice(other than 0 which can be hit twice)
//   if (visited.filter((v) => v == 0).length > 2) continue;
//   const one = visited.filter((v) => v == sorted[i].one).length;
//   const two = visited.filter((v) => v == sorted[i].two).length;
//   if (one >= 2 || two >= 2) {
//     if (sorted[i].one != 0 && sorted[i].two != 0) continue;
//     continue;
//   }

//   visited.push(sorted[i].one);
//   visited.push(sorted[i].two);

//   visitedEdges.push(sorted[i]);

//   path.push(sorted[i].distance);
// }

// console.log(path);
// console.log(path.reduce((a, b) => a + b, 0));
// // console.log(visited);

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class main {
  public static int[][] dists = new int[][] {
      {
          0,
          6,
          12,
          5
      },
      {
          6,
          0,
          8,
          9
      },
      {
          12,
          8,
          0,
          13
      },
      {
          5,
          9,
          13,
          0
      },
  };
  public static ArrayList<point> sorted = new ArrayList<point>();
  public static ArrayList<Integer> path = new ArrayList<Integer>();
  public static ArrayList<Integer> visited = new ArrayList<Integer>();
  public static ArrayList<point> visitedEdges = new ArrayList<point>();

  public static void main(String[] args) {
    long start = System.currentTimeMillis();

    for (int i = 0; i < dists.length; i++) {
      for (int j = 0; j < dists[i].length; j++) {
        if (dists[i][j] == 0)
          continue;
        boolean has = false;
        for (int k = 0; k < sorted.size(); k++) {
          if (sorted.get(k).one == j && sorted.get(k).two == i) {
            has = true;
            break;
          }
        }
        if (!has) {
          sorted.add(new point(dists[i][j], i, j));
        }
      }
    }
    sorted.sort((a, b) -> a.distance - b.distance);

    for (int i = 0; i < sorted.size(); i++) {
      if (visited.stream().filter((v) -> v == 0).count() > 2)
        continue;

      final int iCopy = i;
      int one = (int) visited.stream().filter((v) -> v == sorted.get(iCopy).one).count();
      int two = (int) visited.stream().filter((v) -> v == sorted.get(iCopy).two).count();
      if (one >= 2 || two >= 2) {
        if (sorted.get(i).one != 0 && sorted.get(i).two != 0)
          continue;
        continue;
      }

      visited.add(sorted.get(i).one);
      visited.add(sorted.get(i).two);

      visitedEdges.add(sorted.get(i));

      path.add(sorted.get(i).distance);
    }

    // System.out.println(path);
    // System.out.println(path.stream().reduce((a, b) -> a + b).get());
  
    long end = System.currentTimeMillis();

    System.out.println("Runtime: " + (end - start) + "ms");
  }
}

class point {
  public int distance;
  public int one;
  public int two;

  public point(int distance, int one, int two) {
    this.distance = distance;
    this.one = one;
    this.two = two;
  }
}