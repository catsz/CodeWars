public class PigLatin {
    public static String pigIt(String str) {
      String[] words = str.split(" ");
      String rtn = "";
      
      for (int i = 0;i < words.length;i++) {
        String temp = "";
        char[] word = words[i].toCharArray();
        
        if (word.length > 1) {
            for (int i1 = 1;i1 < word.length;i1++) {
            char c = word[i1];
            
            if (Character.isLetter(c)) {
              if (i1 < word.length - 1) {
                temp += c;
                
                continue;
              }
              temp += c;
              temp += word[0];
              temp += i == words.length - 1 ? "ay" : "ay ";
              
              continue;
            }
            
            if (i1 < word.length - 1) {
              temp += c;
              continue;
            }
            
            temp += c;
          }
        } else {
          if (Character.isLetter(word[0])) {
            temp += word[0] + (i == words.length - 1 ? "ay" : "ay ");
          } else {
            temp += word[0];
          }
        }
        
        rtn += temp;
      }
      
      System.out.println(rtn);
      
      return rtn;
    }
}
