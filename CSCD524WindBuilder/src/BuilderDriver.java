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
		
		printData();

	} //end main
	
	public static void giveList(List<String> arg) {
		fromParser = arg;
		
		findHeight();
	} //end giveList
	
	private static void findHeight() {
		if(fromParser.get(0).equals("0")) {
			if(fromParser.get(1).equals("box")) {
				makeBox(zero);
			}
			else if(fromParser.get(1).equals("circle")) {
				//make circle
				makeCircle(zero);
			}
			else if(fromParser.get(1).equals("straight")) {
				//make straight
				zero[5] = makeStraightLeft();
				zero[5][0] = zero[5][2];
				zero[5][AREASIZE -1] = zero[5][2]; 
			}
			else {
				//make point
			}
		}
		else if(fromParser.get(0).equals("3000")) {
			makeBox(three);
		}
		else if(fromParser.get(0).equals("6000")) {
			makeBox(six);
		}
		else if(fromParser.get(0).equals("9000")) {
			makeBox(nine);
		}
		else if(fromParser.get(0).equals("12000")) {
			makeBox(twelve);
		}
		else {
			makeBox(fifteen);
		}
	} //end findHeight
	
	private static void makeCircle(String[][] ara) {
		//TODO
		//thinking about using radius to find points for circle
		//radius can't be bigger than 5
	}
	
	private static void makeBox(String[][] ara) {
		
		//Top wall of box
		ara[1] = makeStraightLeft();
		
		//Left wall of box
		for(int y = 0; y < AREASIZE; y++) {
			if(y >= 2 && y <= AREASIZE - 2) {
				char temp = 'a';
				
				if(fromParser.get(2).equals("20")) {
					temp++;
					String string = String.valueOf(temp);
					ara[y][1] = string;
				}
				else if(fromParser.get(2).equals("30")) {
					temp = (char) (temp + 2);
					String string = String.valueOf(temp);
					ara[y][1] = string;
				}
				else if(fromParser.get(2).equals("40")) {
					temp = (char) (temp + 3);
					String string = String.valueOf(temp);
					ara[y][1] = string;
				}
				else if(fromParser.get(2).equals("50")) {
					temp = (char) (temp + 4);
					String string = String.valueOf(temp);
					ara[y][1] = string;
				}
				else {
					ara[y][1] = "a";
				}
			}
		}
		
		//Bottom wall of box
		ara[AREASIZE - 2] = makeStraightRight();
		
		//Right wall of box
		for(int y = 0; y < AREASIZE; y++) {
			if(y >= 2 && y <= AREASIZE - 3) {
				char temp = 'u';
				
				if(fromParser.get(2).equals("20")) {
					temp++;
					String string = String.valueOf(temp);
					ara[y][AREASIZE - 2] = string;
				}
				else if(fromParser.get(2).equals("30")) {
					temp = (char) (temp + 2);
					String string = String.valueOf(temp);
					ara[y][AREASIZE - 2] = string;
				}
				else if(fromParser.get(2).equals("40")) {
					temp = (char) (temp + 3);
					String string = String.valueOf(temp);
					ara[y][AREASIZE - 2] = string;
				}
				else if(fromParser.get(2).equals("50")) {
					temp = (char) (temp + 4);
					String string = String.valueOf(temp);
					ara[y][AREASIZE - 2] = string;
				}
				else {
					ara[y][AREASIZE - 2] = "u";
				}
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
				char letter = 'k';
				
				if(fromParser.get(2).equals("20")) {
					letter++;
					String string = String.valueOf(letter);
					temp[x] = string;
				}
				else if(fromParser.get(2).equals("30")) {
					letter = (char) (letter + 2);
					String string = String.valueOf(letter);
					temp[x] = string;
				}
				else if(fromParser.get(2).equals("40")) {
					letter = (char) (letter + 3);
					String string = String.valueOf(letter);
					temp[x] = string;
				}
				else if(fromParser.get(2).equals("50")) {
					letter = (char) (letter + 4);
					String string = String.valueOf(letter);
					temp[x] = string;
				}
				else {
					temp[x] = "l";
				}
			}
		}
		return temp;
	} //end makeStraightLeft
	
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
				char letter = 'E';
				
				if(fromParser.get(2).equals("20")) {
					letter++;
					String string = String.valueOf(letter);
					temp[x] = string;
				}
				else if(fromParser.get(2).equals("30")) {
					letter = (char) (letter + 2);
					String string = String.valueOf(letter);
					temp[x] = string;
				}
				else if(fromParser.get(2).equals("40")) {
					letter = (char) (letter + 3);
					String string = String.valueOf(letter);
					temp[x] = string;
				}
				else if(fromParser.get(2).equals("50")) {
					letter = (char) (letter + 4);
					String string = String.valueOf(letter);
					temp[x] = string;
				}
				else {
					temp[x] = "E";
				}
			}
		}
		
		return temp;
	} //end makeStraightRight

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
				pw.print(zero[x][y]);
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
