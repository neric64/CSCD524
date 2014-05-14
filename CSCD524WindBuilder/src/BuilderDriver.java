import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class BuilderDriver {

	private static final int AREASIZE = 11;
	private static String[][] zero = new String[AREASIZE][AREASIZE];
	private static String[][] three = new String[AREASIZE][AREASIZE];
	private static String[][] six = new String[AREASIZE][AREASIZE];
	private static String[][] nine = new String[AREASIZE][AREASIZE];
	private static String[][] twelve = new String[AREASIZE][AREASIZE];
	private static String[][] fifteen = new String[AREASIZE][AREASIZE];
	private static List<String[][]> windData = new ArrayList<String[][]>();
	private static List<String> fromParser = new ArrayList<String>();
	

	public static void main(String[] args) {
		
		if(args.length != 2) {
			throw new RuntimeException("need an input and output file name.");
		}

		try {
			WindParser parser = new WindParser(args[0], args[1]);

			initArea();

			parser.parse();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		//TODO make wind file
		findHeight();
		
		printData();

	} //end main
	
	public static void giveList(List<String> arg) {
		fromParser = arg;
	}
	
	private static void findHeight() {
		if(fromParser.get(0).equals("3000")) {
			
		}
		else if(fromParser.get(0).equals("6000")) {
			makeBox();
		}
		else if(fromParser.get(0).equals("9000")) {
			
		}
		else if(fromParser.get(0).equals("12000")) {
			
		}
		else {
			
		}
	}
	
	private static void makeBox() {
		
		six[1] = makeStraightLeft();
		
		for(int y = 0; y < AREASIZE; y++) {
			if(y >= 2 && y <= AREASIZE - 2) {
				six[y][1] = "b";
			}
		}
		
		six[AREASIZE - 2] = makeStraightRight();
		
		for(int y = 0; y < AREASIZE; y++) {
			if(y >= 2 && y <= AREASIZE - 3) {
				six[y][AREASIZE - 2] = "v";
			}
		}
		
	} //end makeBox
	
	private static String[] makeStraightLeft() {
		String[] temp = new String[AREASIZE];
		
		for(int x = 0; x < AREASIZE; x++) {
			if(x == 0) {
				temp[x] = ".";
			}
			else if(x == AREASIZE - 1) {
				temp[x] = ".";
			}
			else {
				temp[x] = "l";
			}
		}
		
		return temp;
	}
	
	private static String[] makeStraightRight() {
		String[] temp = new String[AREASIZE];
		
		for(int x = 0; x < AREASIZE; x++) {
			if(x == 0) {
				temp[x] = ".";
			}
			else if(x == AREASIZE - 1) {
				temp[x] = ".";
			}
			else {
				temp[x] = "F";
			}
		}
		
		return temp;
	}

	private static void initArea() {

		for(int x = 0; x < AREASIZE; x++) {
			for(int y = 0; y < AREASIZE; y++) {
				zero[x][y] = ".";
				three[x][y] = ".";
				six[x][y] = ".";
				nine[x][y] = ".";
				twelve[x][y] = ".";
				fifteen[x][y] = ".";
			} //end y for loop
		} //end x for loop
	} //end initArea
	
	private static void printData() {
		PrintWriter pw = null;
		
		try {
			pw = new PrintWriter(new File("output.txt"));
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("135,15");
		pw.println("135,15");
		
		for(int x = 0; x < AREASIZE; x++) {
			for(int y = 0; y < AREASIZE; y++) {
				System.out.print(zero[x][y]);
				pw.print(three[x][y]);
			}
			System.out.print(" ");
			pw.print(" ");
			
			for(int y = 0; y < AREASIZE; y++) {
				System.out.print(three[x][y]);
				pw.print(three[x][y]);
			}
			System.out.print(" ");
			pw.print(" ");
			
			for(int y = 0; y < AREASIZE; y++) {
				System.out.print(six[x][y]);
				pw.print(six[x][y]);
			}
			System.out.print(" ");
			pw.print(" ");
			
			for(int y = 0; y < AREASIZE; y++) {
				System.out.print(nine[x][y]);
				pw.print(nine[x][y]);
			}
			System.out.print(" ");
			pw.print(" ");
			
			for(int y = 0; y < AREASIZE; y++) {
				System.out.print(twelve[x][y]);
				pw.print(twelve[x][y]);
			}
			System.out.print(" ");
			pw.print(" ");
			
			for(int y = 0; y < AREASIZE; y++) {
				System.out.print(fifteen[x][y]);
				pw.print(fifteen[x][y]);
			}
			System.out.println();
			pw.println();
		}
		pw.close();
	} //end printData

} //end BuilderDriver
