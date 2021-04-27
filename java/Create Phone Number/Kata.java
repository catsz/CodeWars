public class Kata {
  public static String createPhoneNumber(int[] numbers) {
    String rtn = "";
    
    for (int i = 0;i < numbers.length;i++) {
      
      if (i == 0) {
        rtn += "(";
      } else if (i == 3) {
        rtn += ") ";
      } else if (i == 6) {
        rtn += "-";
      }
      
      rtn += numbers[i];
    }
    
    return rtn;
  }
}
