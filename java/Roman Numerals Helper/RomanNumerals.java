import java.util.*;
import java.util.Map.Entry;

public class RomanNumerals {
  public final static TreeMap<Integer, String> numberMap = new TreeMap<>();
  public final static Map<String, Integer> stringMap = new HashMap<>();
  
  static {
    numberMap.put(1000, "M");
    numberMap.put(900, "CM");
    numberMap.put(500, "D");
    numberMap.put(400, "CD");
    numberMap.put(100, "C");
    numberMap.put(90, "XC");
    numberMap.put(50, "L");
    numberMap.put(40, "XL");
    numberMap.put(10, "X");
    numberMap.put(9, "IX");
    numberMap.put(5, "V");
    numberMap.put(4, "IV");
    numberMap.put(1, "I");
    
    for (Entry<Integer, String> e : numberMap.entrySet()) {
      stringMap.put(e.getValue(), e.getKey());
    }
  }
 
  public static String toRoman(int n) {
    String rtn = "";
    
    while (n != 0) {
      int i = numberMap.floorKey(n);
      n -= i;
      rtn += numberMap.get(i);
    }
    
    return rtn;
  }
  
  public static int fromRoman(String romanNumeral) {
    String[] numerals = romanNumeral.split("");
    int rtn = 0;
    
    for (int i = 0;i < numerals.length;i++) {
      String numeral = numerals[i];
      
      if (i == (numerals.length - 1)) {
        if (stringMap.containsKey(numeral)) rtn += stringMap.get(numeral);
        continue;
      }
      if (stringMap.containsKey(numeral + numerals[i+1])) {
        rtn += stringMap.get(numeral + numerals[i+1]);
        i+=1;
        continue;
      }
      if (stringMap.containsKey(numeral)) rtn += stringMap.get(numeral);
      
    }
    return rtn;
  }
}
