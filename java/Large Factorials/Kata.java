public class Kata {
  
  //not the best way to do it but it works
  public static String Factorial(int n) {
    if (n < 0) return null;
    if (n <= 1) return "1";
    int[] number = new int[600];
    number[0] = 1;
    int size = 1;
    String rtn = "";
    
    for (;n >= 2;n--) size = multiply(n, number, size);
    for (int i = size - 1;i >= 0;i--) rtn += number[i];
    
    return rtn;
  }
  
  private static int multiply(int m, int[] arr, int size) {
    int carry = 0;
    
    for (int i = 0;i < size;i++) {
      int multiplied = arr[i] * m + carry;
      arr[i] = multiplied % 10;
      carry = multiplied / 10;
    }
    
    while (carry != 0) {
      arr[size] = carry % 10;
      carry /= 10;
      size++;
    }
    
    return size;
  }
}
