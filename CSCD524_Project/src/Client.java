import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Client {
	
	private File cList = null;
	private boolean firstTime = true;
	
	public Client() {
		
	}
	
	public void roam(AP[] list) {
		if(this.firstTime == false) {
			connectCList(list);
		}
		else {
			ArrayList<AP> temp = new ArrayList<AP>();
			for(int i = 0; i < list.length; i++) {
				if(list[i].getSig() > 0) {
					temp.add(list[i]);
				}
			}
			
			try {
				TimeUnit.SECONDS.sleep(1);	//might need to play with the time it sleeps
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}

			connect(temp);
		}
	} //end roam
	
	private void connectCList(AP[] list) {
		Scanner reader = null;
		String s;
		int index = 0, count =0;
		boolean gotOne = false;
		
		try {
			reader = new Scanner(this.cList);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
			s = reader.nextLine();
			
			do {
				if(s.equals(list[count].getMacA()) && list[count].getSig() > 0) {
					gotOne = true;
					index = count;
				}
				count++;
			} while(!gotOne && reader.hasNext());
			
			connectTo(list[index]);
			
			//System.out.println("No Access Points within range.");	//not in the right spot
		
	} //end connectCList
	
	private void connect(ArrayList<AP> list) {
		StringBuilder string = new StringBuilder();
		int index;
		
		string.append("Which Access Point would you like to connect to\n");
		
		for(int i = 0; i < list.size(); i++) {
			string.append((i + 1));
			string.append(" mac Address: ");
			string.append(list.get(i).getMacA());
			string.append(", Signal strength: ");
			string.append(list.get(i).getSig());
			string.append("\n");
		}
		
		System.out.println(string);
		
		do {
			index = getUserInput(list.size());
		} while(index == -1);
		
		connectTo(list.get(index));
		
	} //end connect
	
	private void connectTo(AP ap) {
		if(this.firstTime) {
			this.cList = ap.giveCList();
			this.firstTime = false;
			System.out.println("Connected to Access Point: " + ap.getMacA());	//for testing
		}
		else
			System.out.println("Connected to Access Point: " + ap.getMacA());	//for testing
	} //end connectTo
	
	private int getUserInput(int size) {
		Scanner kb = new Scanner(System.in);
		int in, index = -1;
		
		in = kb.nextInt();
		kb.nextLine();
		
		for(int i = 0; i < size; i++) {
			if((in - 1) == i) {
				index = (i);
			}
		}
		
		if(index == -1) {
			System.out.println("Choose a number between 1 and " + size);
		}
		return index;
	} //end getUserInput

}
