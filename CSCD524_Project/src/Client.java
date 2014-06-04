import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Client {
	
	private File cList = null;
	private AP[] activeList;
	private boolean firstTime = true;
	private Scanner reader = null;
	private String currentAP;
	private int count =0;
	
	public Client() {
		
	}
	
	public void setCurrentAP(String s) {
		this.currentAP = s;
	} //end setCurrentAP
	
	public void setActiveList(AP[] list) {
		this.activeList = list;
	} //end setActiveList
	
	public void roamWithoutList() {
		if(this.firstTime) {
			this.cList = this.activeList[0].giveCList();
			this.firstTime = false;
		}
		try {
			TimeUnit.SECONDS.sleep(10);	//might need to play with the time it sleeps
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		connect();
	} //end roam
	
	public void roamWithList() {
			connectCList();	//After connecting the first time the client has the list
	} //end roam

	
	private void connectCList() {	//was passing in AP[] list to check the CList against
		String s;
		int index = 0;
		boolean gotOne = false;
		
		try {
			this.reader = new Scanner(this.cList);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
			s = this.reader.nextLine();
			/*
			 * TODO
			 * I keep getting indexoutofboundexceptions here need to re-think
			 * it can loop more times than there are AP thus the out of bounds error
			 */
			
			for(int i = 0; i < this.count; i++) {
				s = this.reader.nextLine();
			}
//=======================================================================================			
			do {
				if(s.equals(this.activeList[this.count].getMacA())) {
					//if(this.activeList[this.count].getSig() > 0 && !this.activeList[this.count].isFull()) {
						//if(this.activeList[this.count].getMacA().equals(this.currentAP)) {
							//Do nothing
						//}
						//else {
							gotOne = true;
							index = this.count;
						//}
					//}
				}
				this.count++;
			} while(!gotOne && this.reader.hasNext());
//=======================================================================================			
			connectTo(this.activeList[index]);
		
	} //end connectCList
	
	private void connect() {
		AP ap = null;
		
		for(int i = (this.activeList.length - 1); i > 0; i--) {
			if(this.activeList[i].getSig() > 30 && this.activeList[i].isFull() == false) {
				ap = this.activeList[i];
			}
		}
		connectTo(ap);
		
	} //end connect
	
	private void connectTo(AP ap) {
		System.out.println("Connected to Access Point: " + ap.getMacA());	//for testing
		this.currentAP = ap.getMacA();
	} //end connectTo

}
