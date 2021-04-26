public class Solution
{
    public static int[] twoSum(int[] numbers, int target) {
      int[] rtn = new int[2];
      
      numberLoop: for (int i = 0;i < numbers.length;i++) {
        int n = numbers[i];
        
        for (int i1 = 0;i1 < numbers.length;i1++) {
          int x = numbers[i1];
          
          if ((n + x) == target) {
            rtn[0] = i;
            rtn[1] = i1;
            
            break numberLoop;
          }
        }
      }
      
      return rtn;
    }
}
