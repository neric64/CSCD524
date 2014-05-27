public class Real {

	private int value, scale, realNum;
	private double dValue;
	
	/*
	 * Not sure about the double coming in.
	 * is it just the whole number with the scale value on the end
	 * or is it the actual decimal number that we need to convert to int?
	 * 
	 * Also, right now I am not dealing with signed values
	 * what do I do with the sign?
	 * 
	 * I know I am not doing Real right I am adding and subtracting and comparing, but I am doing nothing
	 * with the bit really.  I am not using the scale bit for anything.
	 * Do we need to do the addition and subtraction ourselves or can we use the built in features?
	 */
	public Real(int value, int scale, double dValue) {
		this.value = value;
		this.scale = scale;
		this.dValue = dValue;  
		this.realNum = (int) dValue;
		
		splitDouble(this.dValue);
		
	}
	
	public Real add(Real num) {
		int[] tempBinary;
		double h;
		int x, y;
		
		x = toBinary(this.realNum);	//Old
		y = toBinary(num.realNum);	//Old
		
		int t = x + y;
		
		tempBinary = toBinaryArray(t);
		
		String s = "";
		for(int i = 0; i < tempBinary.length; i++) {
			s += tempBinary[i];
		}
				
		h = Integer.parseInt(s, 2);
		
		return new Real(this.value, this.scale, h);
	} //end add
	
	public Real sub(Real num) {
		int[] tempBinary;
		double h;
		int x, y;
		
		x = toBinary(this.realNum);
		y = toBinary(num.realNum);
		
		int t = x - y;
		
		tempBinary = toBinaryArray(t);
		
		String s = "";
		for(int i = 0; i < tempBinary.length; i++) {
			s += tempBinary[i];
		}
				
		h = Integer.parseInt(s, 2);
		
		System.out.println("Testing in Real add: " + h);
		
		return new Real(this.value, this.scale, h);
	} //end sub
	
	public int compareTo(Real num) {
		int x, y;
		
		x = toBinary(this.realNum);
		y = toBinary(num.realNum);
		
		if((x - y) > 0) {
			return 1;
		}
		else if((x - y) < 0) {
			return -1;
		}
		else
			return 0;
	} //end compareTo
	
	public double getValue() {
		return this.dValue;
	} //end getValue
	
	
	/*
	 * Taking the incoming double and spliting it into a string array
	 * then parsing it out to get the negitive, if there is one, the whole number and the decimal number
	 */
	private void splitDouble(double num) {
		String[] tokens;
		String delim = "[.]";
		String s = Double.toString(num);
		
		tokens = s.split(delim);
		
		String[] temp = null;
		
		if(tokens[0].contains("-")) {
			temp = new String[3];
			int index = tokens[0].indexOf("-");
			temp[0] = tokens[0].substring(index, 1);
			temp[1] = tokens[0].substring(index + 1);
			temp[2] = tokens[1];
		}
		
		for(int i = 0; i < temp.length; i++) {
			if(temp.equals(null)) {
				
			}
			else
				System.out.print(temp[i] + " ");
		}
		System.out.println();
	}
	
	private int toBinary(int num) {
		String temp;
		int binary;
		
		temp = Integer.toBinaryString(num);
		
		binary = Integer.parseInt(temp, 2);
		
		return binary;
	}  //end toBinary
	
	private int[] toBinaryArray(int num) {
		String temp;
		char[] stest;
		int[] binary;
		
		temp = Integer.toBinaryString(num);
		
		stest = temp.toCharArray();
	
		binary = new int[stest.length];
		
		for(int i = 0; i < stest.length; i++) {
			if(i < binary.length) {
				String x = String.valueOf(stest[i]);

				binary[i] = Integer.parseInt(x, 2);
			}
		}
		
		binary = checkSize(binary);
		
		return binary;
	}  //end toBinaryArray
	
	private int[] checkSize(int[] ara) {
		int[] temp = null;
		
		if((this.value + this.scale) > 32) {
			temp = new int[32];
			for(int i = 0; i < 32; i++) {
				temp[i] = ara[i];
			}
			return temp;
		}
		else if(ara.length > (this.value + this.scale)) {
			temp = new int[this.value + this.scale];
			for(int i = 0; i < (this.value + this.scale); i++) {
				temp[i] = ara[i];
			}
			return temp;
		} 
		return ara;
	} //end checkSize
}
