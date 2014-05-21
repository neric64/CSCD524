
public class Real {

	private int value, scale;
	private double dValue;
	
	public Real(int value, int scale, double dValue) {
		this.value = value;
		this.scale = scale;
		this.dValue = dValue;
	}
	
	//None of the following are correct they are just place holders for now.
	//TODO
	//Need to pull the scale of the end of value to find the proper decimal place the add the decimal numbers
	//together using ints
	public Real add(Real num) {
		
		int tValue, tScale, numValue, numScale;
		
		
		
		
		tValue = toBinary(this.value);
		tScale = toBinary(this.scale);
		numValue = toBinary(num.value);
		numScale = toBinary(num.scale);
		
		System.out.println(tValue);
		System.out.println(tScale);
		System.out.println(numValue);
		System.out.println(numScale);
		
		
		
		return null;
	}
	
	private int toBinary(int num) {
		String temp;
		
		temp = Integer.toBinaryString(num);
		
		return Integer.valueOf(temp);
	}
	
	public Real sub(Real num) {
		return new Real((this.value - num.value), (this.scale - num.scale), (this.dValue - num.dValue));
	}
	
	public int compareTo(Real num) {
		return 0;
	}
}
