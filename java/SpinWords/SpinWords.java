public class SpinWords {

  public String spinWords(String sentence) {
    String[] words = sentence.split(" ");
    char[] temp = new char[sentence.length()];
    int at = 0;
    
    for (String word : words) {
      char[] letters = word.toCharArray();
      
      if (letters.length >= 5) {
        for (int i = letters.length - 1;i >= 0;i--) {
          temp[at++] = letters[i];
        }
        if (at != temp.length) temp[at++] = ' ';
        continue;
      }
      
      for (int i = 0;i < letters.length;i++) {
        temp[at++] = letters[i];
      }
      
      if (at != temp.length) temp[at++] = ' ';
    }
    
    return new String(temp);
  }
}
