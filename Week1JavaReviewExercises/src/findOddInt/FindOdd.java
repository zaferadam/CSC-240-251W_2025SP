package findOddInt;

import java.util.Arrays;

public class FindOdd {
    public static int findIt(int[] a) {
      Arrays.sort(a);
      System.out.println(Arrays.toString(a));
      int oddCounter = 1;
      for (int i = 0; i < a.length-1; i++){
        if (a[i]==a[i+1]){
          oddCounter++;
        } else if (oddCounter%2 == 1){
          oddCounter = 1;
          return a[i];
        } else {
          oddCounter = 1;
        }
      }
      return a[a.length-1];
    }
}