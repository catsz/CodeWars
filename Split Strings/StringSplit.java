public class StringSplit {
    public static String[] solution(String s) {
      char[] chars = s.toCharArray();
      boolean even = chars.length % 2 == 0;
      String[] rtn = new String[even ? chars.length / 2 : (chars.length / 2) + 1];
      
      String temp = "";
      int max = even ? chars.length : chars.length - 1;
      for (int i = 0;i < max;i += 2) {
        rtn[i / 2] = "" + chars[i] + chars[i + 1];
      }
      
      if (!even) rtn[rtn.length - 1] = chars[chars.length - 1] + "_";
      
      return rtn;
    }
}
