import java.util.Scanner;

public class Driver {
	
	/*
	 * TODO
	 * For initial connection connect automatically
	 * 
	 * Give one option for connecting instead of a list of all as you would roam from one AP in
	 * a network and not cross networks.
	 * 
	 * Then print of a menu of things like
	 * roaming without candidacy list
	 * roaming with candidacy list
	 * print candidacy list
	 * 
	 * 
	 * have multiple AP after getting mac address while trying to connect need to make sure client is getting
	 * a signal from that AP
	 */

	public static void main(String[] args) {
		int size = 5;
		AP[] list = new AP[size];
		APFactory factory = new APFactory();
		Client client = new Client();
		
		for(int i = 0; i < size; i++) {
			list[i] = factory.makeAP();
		}
		
		factory.closeScanner();
		
		initAP(list);
		
		client.setActiveList(list);
		
		System.out.println("Connecting to the network for the first time.");
		
		client.roamWithoutList();
		
		menu(list, client);
		
		
	} //end main
	
	private static void initAP(AP[] list) {
		list[0].buildCList(list);
		
		for(int i = 1; i < list.length; i++) {
			list[i].setCList(list[0].giveCList());
		}
	}
	
	private static void menu(AP[] list, Client client) {
		int input = 0;
		Scanner kb = new Scanner(System.in);
		StringBuilder builder = new StringBuilder();
		
		builder.append("1. Roam without using Candidacy List.\n");
		builder.append("2. Roam using Candidacy List.\n");
		//builder.append("3. Print visible access points.\n");	//not sure if I want to use
		builder.append("3. Print Candidacy List\n");	//need to change back to 4 or delete above
		builder.append("5. quit\n");
		
		while(input != 5) {
			System.out.println(builder);
			
			input = kb.nextInt();
			kb.nextLine();
			
			options(list, client, input);
		}
		kb.close();
	} //end menu
	
	private static void options(AP[] list, Client client, int input) {
		if(input == 1) {
			client.roamWithoutList();
		}
		else if(input == 2) {
			client.roamWithList();
		}
		else if(input == 3) {
			list[0].readCList();
		}
	} //end options

}
