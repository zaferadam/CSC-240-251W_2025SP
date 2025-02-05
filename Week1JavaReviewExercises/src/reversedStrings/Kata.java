package reversedStrings;

public class Kata {

  public static String solution(String str) {
    String reverse = "";
    for (int i=str.length()-1; i>=0; i--){
      char a = str.charAt(i);
      reverse+=a;
    }
    return reverse;
  }
}