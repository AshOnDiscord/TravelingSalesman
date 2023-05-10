import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class main {
  public final HashMap<String, HashMap<String, Integer>> spots = new HashMap<String, HashMap<String, Integer>>();
  public static final String START = "home";

  public static void main(String[] args) {
    final long startTime = System.currentTimeMillis();
    //#region fill hashmap
    final main program = new main();

    HashMap<String, Integer> home = new HashMap<String, Integer>();
    home.put("aldo", 6);
    home.put("butch", 12);
    home.put("cassidy", 5);
    program.spots.put("home", home);

    HashMap<String, Integer> aldo = new HashMap<String, Integer>();
    aldo.put("home", 6);
    aldo.put("butch", 8);
    aldo.put("cassidy", 9);
    program.spots.put("aldo", aldo);

    HashMap<String, Integer> butch = new HashMap<String, Integer>();
    butch.put("home", 12);
    butch.put("aldo", 8);
    butch.put("cassidy", 13);
    program.spots.put("butch", butch);

    HashMap<String, Integer> cassidy = new HashMap<String, Integer>();
    cassidy.put("home", 5);
    cassidy.put("aldo", 9);
    cassidy.put("butch", 13);
    program.spots.put("cassidy", cassidy);
    // #endregion

    program.spots.get(START).forEach((key, value) -> {
      List<String> past = new ArrayList<String>();
      past.add(START);
      program.recursiveAdd(key, value, past);
    });
    final long endTime = System.currentTimeMillis();

    System.out.println("Total execution time: " + (endTime - startTime));
  }

  public void recursiveAdd(String current, Integer sum, List<String> past) {
    HashMap<String, Integer> remaining = new HashMap<String, Integer>();

    spots.get(current).forEach((key, value) -> {
      if (!past.contains(key)) {
        remaining.put(key, value);
      }
    });

    if (remaining.size() == 0) {
      past.add(START);
      int sum2 = sum + spots.get(current).get(START);
      System.out.println(past + " " + sum2);
      return;
    }

    remaining.forEach((key, value) -> {
      List<String> newPast = new ArrayList<String>(past);
      newPast.add(current);
      recursiveAdd(key, sum + value, newPast);
    });
  }
}
