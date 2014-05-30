import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		int size = 5;
		AP[] list = new AP[size];
		APFactory factory = new APFactory();
		Client client = new Client();
		StringBuilder builder = new StringBuilder();
		Scanner kb = new Scanner(System.in);
		String input;
		
		for(int i = 0; i < size; i++) {
			list[i] = factory.makeAP();
		}
		
		initAP(list);
		
		System.out.println("Would you like to connect an Access Point for the first time?");
		input = kb.nextLine();
		
		if(input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")) {
			client.roam(list);
		}
		else {
			System.out.println("OK goodbye then.");
			System.exit(0);
		}
		
		menu(list, builder, kb, client);
		
		
	} //end main
	
	//TODO I haven't test this to see if it works yet or not
	private static void initAP(AP[] list) {
		list[0].buildCList(list);
		
		for(int i = 1; i < list.length; i++) {
			list[i].setCList(list[0].giveCList());
		}
	}
	
	private static void menu(AP[] list, StringBuilder builder, Scanner kb, Client client) {
		int input = 0;
		
		builder.append("1. Connect to another Access Point\n");
		builder.append("2. Print Candidacy List\n");
		builder.append("3. quit\n");
		
		while(input != 3) {
			System.out.println(builder);
			
			input = kb.nextInt();
			kb.nextLine();
			
			options(list, client, input);
		}
	} //end menu
	
	private static void options(AP[] list, Client client, int input) {
		if(input == 1) {
			client.roam(list);
		}
		else if(input == 2) {
			list[0].readCList();
		}
	}

}
