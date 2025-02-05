package hexClass;

public class Hex{

	private String hexValue;
	
	  public Hex(int value){
		  hexValue = Integer.toHexString(value);
	  }
	  
	  public int valueOf(){
		  return Integer.parseInt(hexValue);
	  }
	  
	  public String toJSON(){
		  return "0x" + hexValue;
	   }
	  
	  public String toString(){
		  return "0x" + hexValue;
	  }
	  
	  public Hex plus(Hex other){
		  return new Hex (Integer.parseInt(hexValue) + Integer.parseInt(other.toString()));
	  }
	  
	  public Hex minus(Hex other){
		  return new Hex (Integer.parseInt(hexValue) - Integer.parseInt(other.toString()));
	  }
	  
	  public Hex plus(int number){
		  return new Hex (Integer.parseInt(hexValue) + number);
	  }
	  
	  public Hex minus(int number ){
		  return new Hex (Integer.parseInt(hexValue) + number);
	  }
	  
	  public static int parse(String string){
		  if (string.startsWith("0x") || string.startsWith("0X")) {
			  return Integer.parseInt(string.substring(2));
		  } else return Integer.parseInt(string);
	  }
	  
	  public boolean equals(Object other){
		  if (this.toString() == other.toString()) {
			  return true;
		  } else return false;
	  }
	}