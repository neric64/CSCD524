import java.util.ArrayList;
import java.util.Random;


public class APFactory {
	
	private Random rand = new Random();
	private final int MAX = 100;
	
	public APFactory() {
		
	}
	
	public AP makeAP() {
		return new AP("macaddress" + rand.nextInt(2000), rand.nextInt(MAX), rand.nextBoolean());
	} //end makeAP

}
