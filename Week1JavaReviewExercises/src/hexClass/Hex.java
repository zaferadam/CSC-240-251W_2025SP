package hexClass;

public class Hex{

	private final String hexValue;
	
	  public Hex(int value){
		  hexValue = Integer.toHexString(value).toUpperCase();
	  }
	  
	  public int valueOf(){
		  return Integer.parseInt(hexValue, 16);
	  }
	  
	  public String toJSON(){
		  return "0x" + hexValue;
	   }
	  
	  public String toString(){
		  return "0x" + hexValue;
	  }
	  
	  public Hex plus(Hex other){
		  return new Hex (parse(hexValue) + parse(other.toJSON()));
	  }
	  
	  public Hex minus(Hex other){
		  return new Hex (parse(hexValue) - parse(other.toJSON()));
	  }
	  
	  public Hex plus(int number){
		  return new Hex (parse(hexValue) + number);
	  }
	  
	  public Hex minus(int number ){
		  return new Hex (parse(hexValue) - number);
	  }
	  
	  public static int parse(String string){
		  if (string.startsWith("0x") || string.startsWith("0X")) {
			  return Integer.parseInt(string.substring(2), 16);
		  } else return Integer.parseInt(string, 16);
	  }
	  
	  public boolean equals(Object other){
		  if (this.toString().equals(other.toString())) {
			  return true;
		  } else return false;
	  }
	}