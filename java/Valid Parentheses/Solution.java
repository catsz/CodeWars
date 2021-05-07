public class Solution{
  
  public static boolean validParentheses(String parens) {
    char[] chars = parens.toCharArray();
    for (int i = 0;i < chars.length;i++) {
      char c = chars[i];
      
      if (c == '(') {
        
        boolean has = false;
        for (int i1 = i + 1;i1 < chars.length;i1++) {
          
          if (chars[i1] == ')') {
            has = true;
            //remove the checked parentheses
            chars[i1] = 'a';
            chars[i] = 'a';
            break;
          }
        }
        if (!has) return false;
      } else if (c == ')') {
        return false;
      }
    }
    
    return true;
  }
}
