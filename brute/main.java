import java.util.ArrayList;
import java.util.HashMap;

public class main {
  public HashMap<String, HashMap<String, Float>> spots = new HashMap<String, HashMap<String, Float>>();
  public static final String START = "home";

  public static void main(String[] args) {
    //#region fill hashmap
    main program = new main();

    HashMap<String, Float> home = new HashMap<String, Float>();
    home.put("aldo", 6f);
    home.put("butch", 12f);
    home.put("cassidy", 5f);
    program.spots.put("home", home);

    HashMap<String, Float> aldo = new HashMap<String, Float>();
    aldo.put("home", 6f);
    aldo.put("butch", 8f);
    aldo.put("cassidy", 9f);
    program.spots.put("aldo", aldo);

    HashMap<String, Float> butch = new HashMap<String, Float>();
    butch.put("home", 12f);
    butch.put("aldo", 8f);
    butch.put("cassidy", 13f);
    program.spots.put("butch", butch);

    HashMap<String, Float> cassidy = new HashMap<String, Float>();
    cassidy.put("home", 5f);
    cassidy.put("aldo", 9f);
    cassidy.put("butch", 13f);
    program.spots.put("cassidy", cassidy);
    // #endregion

    program.spots.get(START).forEach((key, value) -> {
      ArrayList<String> past = new ArrayList<String>();
      past.add(START);
      program.recursiveAdd(key, value, past);
    });
  }

  public void recursiveAdd(String current, Float sum, ArrayList<String> past) {
    HashMap<String, Float> remaining = new HashMap<String, Float>();

    spots.get(current).forEach((key, value) -> {
      if (!past.contains(key)) {
        remaining.put(key, value);
      }
    });

    if (remaining.size() == 0) {
      past.add(current);
      float sum2 = sum + spots.get(current).get(START);
      System.out.println(past + " " + sum2);
      return;
    }

    remaining.forEach((key, value) -> {
      ArrayList<String> newPast = new ArrayList<String>(past);
      newPast.add(current);
      recursiveAdd(key, sum + value, newPast);
    });
  }
}