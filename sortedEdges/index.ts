const dists: number[][] = [
  [0, 6, 12, 5],
  [6, 0, 8, 9],
  [12, 8, 0, 13],
  [5, 9, 13, 0],
];

interface point {
  distance: number;
  one: number;
  two: number;
}

const sorted: point[] = [];

for (let i = 0; i < dists.length; i++) {
  for (let j = 0; j < dists[i].length; j++) {
    if (dists[i][j] == 0) continue;
    if (!sorted.some((point) => point.one == j && point.two == i)) {
      sorted.push({
        distance: dists[i][j],
        one: i,
        two: j,
      });
    }
  }
}

sorted.sort((a, b) => a.distance - b.distance);

// console.table(sorted);

// sorted edges traveling salesman problem
const path: number[] = [];
const visited: number[] = [];
const visitedEdges: point[] = [];

for (let i = 0; i < sorted.length; i++) {
  // check if the edge would make a loop that doesn't include all nodes or hits a node twice(other than 0 which can be hit twice)
  if (visited.filter((v) => v == 0).length > 2) continue;
  const one = visited.filter((v) => v == sorted[i].one).length;
  const two = visited.filter((v) => v == sorted[i].two).length;
  if (one >= 2 || two >= 2) {
    if (sorted[i].one != 0 && sorted[i].two != 0) continue;
    continue;
  }

  visited.push(sorted[i].one);
  visited.push(sorted[i].two);

  visitedEdges.push(sorted[i]);

  path.push(sorted[i].distance);
}

console.log(path);
console.log(path.reduce((a, b) => a + b, 0));
// console.log(visited);
