package fractionsClass;

public class Fraction implements Comparable<Fraction>
{
    private final long top;
    private final long bottom;

    public Fraction(long numerator, long denominator) {
    	long[] reduced = reduce(numerator, denominator);
        top = reduced[0];
        bottom = reduced[1];
    }
    
    @Override
    public int hashCode() { return 17 * Long.hashCode(top) + Long.hashCode(bottom); }    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Fraction)) return false;
        Fraction f2 = (Fraction) o;
        return this.compareTo(f2) == 0;
    }
    @Override
    public int compareTo(Fraction f2){ return Long.compare(top * f2.bottom, f2.top * bottom); }
    @Override
    public String toString() { return this.top + "/" + this.bottom;    }
    
    // Your work here!
    private long[] reduce(long numer, long denom){
    	if (denom==0) {
    		throw new ArithmeticException("Denominator cannot be zero");
    	}
      long a = numer;
      long b = denom;
      long reducedTop = a;
      long reducedBottom = b;
      while (b != 0){
        long temp = b;
        b = a % b;
        a = temp;
      }
      a = Math.abs(a);
      reducedTop /= a;
      reducedBottom /= a;
      long result[] = new long[] {reducedTop, reducedBottom};
      return result;
    }

    //Add two fractions
    public Fraction add(Fraction f2) {    
      long numer = (this.top * f2.bottom) + (f2.top * this.bottom);
      long denom = this.bottom * f2.bottom;
      return new Fraction(numer, denom);
    }
    
    //...and make this class string representable
}