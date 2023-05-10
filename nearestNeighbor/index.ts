const dists: number[][] = [
  [0,6,12,5],
  [6,0,8,9],
  [12,8,0,13],
  [5,9,13,0],
]

const names: string[] = [
  "Home", "Aldo", "Butch", "Cassidy"
]

interface general {
  distance: number,
  path: number
}

interface params {
  house: number,
  sum: number,
  count: number,
  history: number[]
}

const HOUSES = dists.length

const min = (data: params): params => {
  let {house, sum, count, history} = data
  count++
  let least: general = {
    distance: dists[house][1],
    path: 1
  };
  if (count == HOUSES) {
    history.push(0)
    return {
      house,
      sum: sum + dists[house][0],
      count,
      history
    }
  }
  while (history.includes(least.path) || least.path == house) {
    least = {
      distance: dists[house][least.path + 1],
      path: least.path + 1
    }
  }

  for (let path = 0; path < HOUSES; path++) {
    if (path == 0 || dists[house][path] == 0 || history.includes(path)) {
      continue
    }
    if (dists[house][path] < least.distance) {
      least = {
        distance: dists[house][path], 
        path
      };
    }
  }
  sum += least.distance
  history.push(least.path)
  return {
    house: least.path, 
    sum,
    count,
    history
  }
}

let final = ({
  house: 0, 
  sum: 0,
  count: 0,
  history: [0]
});

for (let i = 0; i < HOUSES; i++) {
  final = min(final)
}

console.log(`${final.history.map(i => names[i]).join(" -> ")}: ${final.sum}`)