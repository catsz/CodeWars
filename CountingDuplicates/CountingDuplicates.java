import java.util.HashMap;

public class CountingDuplicates {
  public static int duplicateCount(String text) {
    //save number of duplicates
    int duplicates = 0;
    //save stuff using hashcodes meaning fast .contains
    HashMap<Character, Integer> characters = new HashMap<Character, Integer>();
    
    char[] cA = text.toCharArray();
    for (char c : cA) {
      c = Character.toLowerCase(c);
      
      if (characters.containsKey(c)) {
        if (characters.get(c) > 0) continue;
        duplicates++;
        
        characters.put(c, characters.getOrDefault(c, 0) + 1);
      } else characters.put(c, 0);
    }
    
    return duplicates;
  }
}
