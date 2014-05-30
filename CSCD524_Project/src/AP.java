import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AP {
	
	private File cList;
	private String macA;
	private int sig;
	private boolean full;
	private boolean isAP = true;
	//private String closestAP;	//Don't know if I need this or not
	
	public AP(String macA, int sig, boolean full) {
		this.macA = macA;
		this.sig = sig;
		this.full = full;
	}
	
	/*
	 * Building the candidacy list
	 * Should only need one AP to build the list and then hand it off to other APs
	 * 
	 * Not sure if list should be built here or else where.
	 * Depends on if it is a self discovering network or static network and list
	 * is created outside AP and then given to each one.
	 */
	public void buildCList(AP[] list) {
		PrintWriter pw = null;
		try {
			this.cList = new File("list.txt");
			pw = new PrintWriter(this.cList);
		}
		catch(FileNotFoundException e) {
			System.out.println("Could not open file.");
			e.printStackTrace();
		}
		
		for(int i = 0; i < list.length; i++) {
			pw.append(list[i].getMacA() + "\n");
		}
		
		pw.close();
		
	} //end buildCList
	
	//Might be just for testing
	public void readCList() {
		Scanner reader = null;
		
		try {
			reader = new Scanner(this.cList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		while(reader.hasNext()) {
			System.out.println(reader.nextLine());
		}
		
	} //end readCList
	
	public File giveCList() {
		return this.cList;
	} //end giveCList
	
	public boolean APMatch(AP ap) {
		if(this.macA.equals(ap.getMacA())) {
			return true;
		}
		else {
			return false;
		}
	} //end APMatch
	
	public void setMacA(String mac) {
		this.macA = mac;
	} //end setMacA
	
	public void setSig(int sig) {
		this.sig = sig;
	} //end setSig
	
	public String getMacA() {
		return this.macA;
	} //end getMacA
	
	public int getSig() {
		return this.sig;
	} //end getSig
	
	public boolean getIsAP() {
		return this.isAP;
	} //end getIsAP
	
	public boolean isFull() {
		return this.full;
	} //end isFull
	
	public void setCList(File list) {
		this.cList = list;
	} //end setCList

}
