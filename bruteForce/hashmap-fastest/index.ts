// Traveling Salesman

const spots = {
  home: [
    //{ name: "home", distance: 0},
    { name: "aldo", distance: 6 },
    { name: "butch", distance: 12 },
    { name: "cassidy", distance: 5 },
  ],
  aldo: [
    { name: "home", distance: 6 },
    //{ name: "aldo", distance: 0},
    { name: "butch", distance: 8 },
    { name: "cassidy", distance: 9 },
  ],
  butch: [
    { name: "home", distance: 12 },
    { name: "aldo", distance: 8 },
    //{ name: "butch", distance: 0},
    { name: "cassidy", distance: 13 },
  ],
  cassidy: [
    { name: "home", distance: 5 },
    { name: "aldo", distance: 9 },
    { name: "butch", distance: 13 },
    //{ name: "cassidy", distance: 0},
  ],
};

// console.log(JSON.stringify(spots, null, 2));

const point = "home";
const pointObj = spots[point];

const recurse = (current: string, sum: number, past: string[]) => {
  //console.log(past);
  const remaining = spots[current].filter((e) => !past.includes(e.name));

  if (remaining.length === 0) {
    past.push(point);
    sum += spots[current].find((e) => e.name == point).distance;
    return console.log(past, sum);
  }

  remaining.forEach((spot) => {
    recurse(spot.name, sum + spot.distance, [...past, spot.name]);
  });
};

pointObj.forEach((spot) => {
  recurse(spot.name, spot.distance, [point, spot.name]);
});
