import java.util.Arrays;

public class Smaller {
	
	public static int[] smaller(int[] unsorted) {
    int[] rtn = new int[unsorted.length];
    Node root = null;
    
    for (int i = (unsorted.length - 1);i >= 0;i--) root = insert(root, unsorted[i], rtn, 0, i);
    return rtn;
	}
  
  public static Node insert(Node root, int num, int[] arr, int sum, int i) {
    if (root == null) {
      arr[i] = sum;
      return new Node(num);
    }
    
    if (root.num == num) {
      root.dup++;
      arr[i] = sum + root.amount;
    } else if (root.num < num) {
      root.right = insert(root.right, num, arr, sum + root.amount + root.dup, i);
    } else {
      root.amount++;
      root.left = insert(root.left, num, arr, sum, i);
    }
    
    return root;
  }
  
  public static class Node {
    public int num = 0, amount = 0, dup = 1;
    public Node right = null, left = null;
    
    public Node(int num) {
      this.num = num;
    }
  }
}
