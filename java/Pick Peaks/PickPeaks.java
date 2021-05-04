import java.util.*;

public class PickPeaks {
    public static Map<String,List<Integer>> getPeaks(int[] arr) { 
      if (arr.length == 0) {
        Map<String, List<Integer>> rtn = new HashMap<>();
        rtn.put("pos", Arrays.<Integer>asList(new Integer[0]));
        rtn.put("peaks", Arrays.<Integer>asList(new Integer[0]));
          
        return rtn;
      }
      
      Map<String, List<Integer>> rtn = new HashMap<>();
      List<Integer> pos = new ArrayList<Integer>();
      List<Integer> peaks = new ArrayList<Integer>();
      
      int pos_temp = -1; 
      for(int i = 1; i < arr.length; i++ ) {
        if(arr[i] > arr[i-1]) {
          pos_temp = i;
        } else if((arr[i] < arr[i-1]) && (pos_temp > 0)) {
          pos.add(pos_temp);
          peaks.add(arr[pos_temp]);
          pos_temp = -1;
        }
      }
      
      rtn.put("pos", pos);
      rtn.put("peaks", peaks);
      return rtn;
    }
  
  
  //worse before code
    public static Map<String,List<Integer>> getPeaks2(int[] arr) {
      System.out.println(Arrays.toString(arr));
      
      if (arr.length == 0) {
        Map<String, List<Integer>> rtn = new HashMap<>();
        rtn.put("pos", Arrays.<Integer>asList(new Integer[0]));
        rtn.put("peaks", Arrays.<Integer>asList(new Integer[0]));
          
        return rtn;
      }
      
      Map<String, List<Integer>> rtn = new HashMap<>();
      List<Integer> pos = new ArrayList<Integer>();
      List<Integer> peaks = new ArrayList<Integer>();
      
      rtn.put("pos", pos);
      rtn.put("peaks", peaks);
      
      for (int i = 1;i < arr.length - 1;i++) {
        int at = arr[i];
        int before = arr[i-1];
        int after = arr[i+1];
        
        if (at > before) {
          
          if (at == after) {
            if (arr.length > i + 2) {
              for (int i1 = i;i1 < arr.length;i1++) {
                int a = arr[i1];
                if (a > at) break;
                
                if (a < at) {
                  peaks.add(at);
                  pos.add(i);
                  break;
                }
              }
            }
          } else if (at > after) {
            peaks.add(at);
            pos.add(i);
          }
        }
      }
      
      return rtn;
    }
}
