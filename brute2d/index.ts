// const spots = {
//   home: [
//     //{ name: "home", distance: 0},
//     { name: "aldo", distance: 6 },
//     { name: "butch", distance: 12 },
//     { name: "cassidy", distance: 5 },
//   ],
//   aldo: [
//     { name: "home", distance: 6 },
//     //{ name: "aldo", distance: 0},
//     { name: "butch", distance: 8 },
//     { name: "cassidy", distance: 9 },
//   ],
//   butch: [
//     { name: "home", distance: 12 },
//     { name: "aldo", distance: 8 },
//     //{ name: "butch", distance: 0},
//     { name: "cassidy", distance: 13 },
//   ],
//   cassidy: [
//     { name: "home", distance: 5 },
//     { name: "aldo", distance: 9 },
//     { name: "butch", distance: 13 },
//     //{ name: "cassidy", distance: 0},
//   ],
// };

const spots = [
  [0, 6, 12, 5],
  [6, 0, 8, 9],
  [12, 8, 0, 13],
  [5, 9, 13, 0],
];

const brute2d = (spots: number[][]) => {
  // start from home(0)
  // loop through all possible paths from home
  for (let i = 0; i < spots.length; i++) {
    // make sure we don't go back to home
    if (i === 0) continue;
    // loop through all possible paths from second house
    for (let j = 0; j < spots.length; j++) {
      // loop through all possible paths from third house
      if (j === 0 || j === i) continue;
      for (let k = 0; k < spots.length; k++) {
        // loop through all possible paths from fourth house
        if (k === 0 || k === i || k === j) continue;
        // if we get here, we have a valid path
        let pathLength = spots[0][i] + spots[i][j] + spots[j][k] + spots[k][0];
        console.log(`home -> ${i} -> ${j} -> ${k} -> home = ${pathLength}`);
      }
    }
  }
};

brute2d(spots);
