public class MorseCodeDecoder {
  public static String decodeBits(String bits) {
    /*
    having this method does technically slow the decoding down because you calculate things like
    start twice but it makes the code slightly more readable
    */
    int rate = getRate(bits);
    int start = 0;
    while (start < bits.length() && bits.charAt(start) == '0') start++;
    if (start == bits.length()) return null;
    
    //using string buffers because strinbuilder didn't work for some reason
    StringBuffer rtn = new StringBuffer();
    StringBuffer codeBuf = new StringBuffer();
    char before = '0';
    
    //loop all of the bits skipping unneeded bits due to the rate
    for (;start < bits.length() + rate;start += rate) {
      if (start < bits.length() && bits.charAt(start) == before) {
        codeBuf.append(before);
      } else {
        codeBuf.append(before);
        String code = codeBuf.toString();
        
        if (code.equals("1")) {
          rtn.append(".");
        } else if (code.equals("000")) {
          rtn.append(" ");
        } else if (code.equals("111")) {
          rtn.append("-");
        } else if (code.equals("0000000")) {
          rtn.append("   ");
        }
        //reset before
        if (start < bits.length()) before = bits.charAt(start);
        
        //reset the buf
        codeBuf.setLength(0);
      }
    }
    
    return rtn.toString();
  }
  private static int getRate(String bits) {
    if (bits.length() <= 1) return 1;
    
    //ignore trailing zeros or ones
    int start = 0, end = bits.length() - 1;
    while(start < bits.length() && bits.charAt(start) == '0') start++;
    while(end >= 0 && bits.charAt(end) == '0') end--;
    
    //minimum number of zeros and ones
    int zeroLength = Integer.MAX_VALUE;
    int oneLength = Integer.MAX_VALUE;
    
    //find minimum number of zeros or ones
    char before = bits.charAt(start);
    int count = 1;
    for (int i = start + 1;i <= end;i++) {
      if (bits.charAt(i) == before) {
        count++;
      } else {
        switch (before) {
            case '0':
              if (count < zeroLength) zeroLength = count;
              break;
            case '1':
              if (count < oneLength) oneLength = count;
              break;
        }
        count = 1;
        before = bits.charAt(i);
      }
    }
    
    if (oneLength == Integer.MAX_VALUE && zeroLength == Integer.MAX_VALUE) return bits.length();
    return Math.min(oneLength, zeroLength);
		}
  
  public static String decodeMorse(String morseCode) {
    StringBuffer rtn = new StringBuffer();
    String[] split = morseCode.split("\\s{3}");
    
    for (String n : split) {
      for (String code : n.split("\\s{1}")) {
        rtn.append(MorseCode.get(code));
      }
      rtn.append(" ");
    }
    
    return rtn.toString().trim();
  }
}
