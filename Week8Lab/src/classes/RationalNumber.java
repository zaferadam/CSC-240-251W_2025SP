package classes;

public class RationalNumber {
	private int numerator, denominator, greatestCommonDivisor;
	
	public RationalNumber(int numerator, int denominator) {
		this.setNumerator(numerator);
		this.setDenominator(denominator);
		greatestCommonDivisor = gcd(numerator, denominator);
	}
	
	public RationalNumber() {
		this(0, 1);
	}
	
	@Override
	public String toString() {
		return numerator + "/" + denominator;
		
	}
	
	public static int gcd(int a, int b) {
		a = Math.abs(a);
		b = Math.abs(b);
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a%b);
		}
	}

	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}
	public int getGCD() {
		greatestCommonDivisor = gcd(numerator, denominator);
		return greatestCommonDivisor;
	}

}
