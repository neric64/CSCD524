import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;


public class APFactory {
	
	private Random rand = new Random();
	private final int MAX = 100;
	private int count = 0;
	private Scanner reader = null;
	
	public APFactory() {
		
	}
	
	public AP makeAP() {
		return new AP(makeMac(), rand.nextInt(MAX), rand.nextBoolean());
	} //end makeAP
	
	private String makeMac() {
		String s = "";
		int index = 0;
		
		if(count >= 20) {
			System.err.println("Out of mac addresses.");	//Shouldn't happen
			System.exit(0);
		}
		
		try {
			this.reader = new Scanner(new File("macAP.txt"));
		} 
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(index <= count) {
			s = this.reader.nextLine();
			index++;
		}
		
		this.count++;
		return s;
	} //end makeMac

	public void closeScanner() {
		this.reader.close();
	}
}
