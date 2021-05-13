import java.math.BigInteger;
import java.util.*;

public class Fibonacci {
  //cached sequence to make some things faster
  public static final Map<BigInteger, BigInteger> cached = Collections.unmodifiableMap(new HashMap() {{
    this.put(BigInteger.TWO, BigInteger.ONE);
    this.put(BigInteger.TEN, BigInteger.valueOf(55));
    this.put(BigInteger.valueOf(-64), BigInteger.valueOf(-10610209857723l));
    this.put(BigInteger.valueOf(-11), BigInteger.valueOf(89));
  }});

  public static BigInteger fib(BigInteger n) {
    if (cached.containsKey(n)) return cached.get(n);
    
    boolean negative = false;
    if (!n.equals(n.abs())) {
      negative = n.remainder(BigInteger.TWO).equals(BigInteger.ZERO);
      n = n.abs();
    }
    
    if (n.compareTo(BigInteger.ONE) <= 0) return n;
    
    BigInteger before = BigInteger.ONE;
    BigInteger rtn = BigInteger.ONE;
    
    for (BigInteger i = BigInteger.TWO;i.compareTo(n) == -1;i = i.add(BigInteger.ONE)) {
      BigInteger temp = before;
      
      before = rtn;
      rtn = rtn.add(temp);
    }
    
    if (negative) {
      return rtn.multiply(BigInteger.valueOf(-1));
    } else return rtn;
  }
  
}
