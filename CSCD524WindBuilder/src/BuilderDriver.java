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
				makeCircle(zero);
			}
			else if(fromParser.get(1).equals("straight")) {
				zero[5] = makeStraightLeft();
				zero[5][0] = zero[5][2];
				zero[5][AREASIZE -1] = zero[5][2]; 
			}
			else if(fromParser.get(1).equals("tornado")) {
				makeTornado();
			}
			else if(fromParser.get(1).equals("snake")) {
				makeSnake(zero);
			}
			else {
				makePoint(zero);
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
		//if multiple speeds could do
		//if(fromParser.size > 3) then do varying circle
		//else one speed circle
		//radius can't be bigger than 4
		int radius = 4, x = 5, y = 5;

		//If variable speeds within the circle then do the if
		//If no variable speeds the the else
		if(fromParser.size() > 3) {
			//Right of circle
			char temp = 'u';

			if(fromParser.get(2).equals("20")) {
				temp++;
				String string = String.valueOf(temp);
				ara[x][y + radius] = string;
			}
			else if(fromParser.get(2).equals("30")) {
				temp = (char) (temp + 2);
				String string = String.valueOf(temp);
				ara[x][y + radius] = string;
			}
			else if(fromParser.get(2).equals("40")) {
				temp = (char) (temp + 3);
				String string = String.valueOf(temp);
				ara[x][y + radius] = string;
			}
			else if(fromParser.get(2).equals("50")) {
				temp = (char) (temp + 4);
				String string = String.valueOf(temp);
				ara[x][y + radius] = string;
			}
			else {
				ara[x][y + radius] = String.valueOf(temp);
			}

			//Bottom of circle
			temp = 'E';

			if(fromParser.get(3).equals("20")) {
				temp++;
				String string = String.valueOf(temp);
				ara[x + radius][y] = string;
			}
			else if(fromParser.get(3).equals("30")) {
				temp = (char) (temp + 2);
				String string = String.valueOf(temp);
				ara[x + radius][y] = string;
			}
			else if(fromParser.get(3).equals("40")) {
				temp = (char) (temp + 3);
				String string = String.valueOf(temp);
				ara[x + radius][y] = string;
			}
			else if(fromParser.get(3).equals("50")) {
				temp = (char) (temp + 4);
				String string = String.valueOf(temp);
				ara[x + radius][y] = string;
			}
			else {
				ara[x + radius][y] = String.valueOf(temp);
			}

			//Left of circle
			temp = 'a';

			if(fromParser.get(4).equals("20")) {
				temp++;
				String string = String.valueOf(temp);
				ara[x][y - radius] = string;
			}
			else if(fromParser.get(4).equals("30")) {
				temp = (char) (temp + 2);
				String string = String.valueOf(temp);
				ara[x][y - radius] = string;
			}
			else if(fromParser.get(4).equals("40")) {
				temp = (char) (temp + 3);
				String string = String.valueOf(temp);
				ara[x][y - radius] = string;
			}
			else if(fromParser.get(4).equals("50")) {
				temp = (char) (temp + 4);
				String string = String.valueOf(temp);
				ara[x][y - radius] = string;
			}
			else {
				ara[x][y - radius] = String.valueOf(temp);
			}

			//Top of circle or close
			temp = 'k';

			if(fromParser.get(5).equals("20")) {
				temp++;
				String string = String.valueOf(temp);
				ara[x - radius][y] = string;
			}
			else if(fromParser.get(5).equals("30")) {
				temp = (char) (temp + 2);
				String string = String.valueOf(temp);
				ara[x - radius][y] = string;
			}
			else if(fromParser.get(5).equals("40")) {
				temp = (char) (temp + 3);
				String string = String.valueOf(temp);
				ara[x - radius][y] = string;
			}
			else if(fromParser.get(5).equals("50")) {
				temp = (char) (temp + 4);
				String string = String.valueOf(temp);
				ara[x - radius][y] = string;
			}
			else {
				ara[x - radius][y] = String.valueOf(temp);
			}
		}
		else {
			//Right of circle
			ara[x][y + radius] = "u";
			char temp = 'u';
			
			if(fromParser.get(2).equals("20")) {
				temp++;
				String string = String.valueOf(temp);
				ara[x][y + radius] = string;
			}
			else if(fromParser.get(2).equals("30")) {
				temp = (char) (temp + 2);
				String string = String.valueOf(temp);
				ara[x][y + radius] = string;
			}
			else if(fromParser.get(2).equals("40")) {
				temp = (char) (temp + 3);
				String string = String.valueOf(temp);
				ara[x][y + radius] = string;
			}
			else if(fromParser.get(2).equals("50")) {
				temp = (char) (temp + 4);
				String string = String.valueOf(temp);
				ara[x][y + radius] = string;
			}
			else {
				ara[x][y + radius] = String.valueOf(temp);
			}

			//Bottom of circle
			temp = 'E';
			
			if(fromParser.get(2).equals("20")) {
				temp++;
				String string = String.valueOf(temp);
				ara[x + radius][y] = string;
			}
			else if(fromParser.get(2).equals("30")) {
				temp = (char) (temp + 2);
				String string = String.valueOf(temp);
				ara[x + radius][y] = string;
			}
			else if(fromParser.get(2).equals("40")) {
				temp = (char) (temp + 3);
				String string = String.valueOf(temp);
				ara[x + radius][y] = string;
			}
			else if(fromParser.get(2).equals("50")) {
				temp = (char) (temp + 4);
				String string = String.valueOf(temp);
				ara[x + radius][y] = string;
			}
			else {
				ara[x + radius][y] = String.valueOf(temp);
			}

			//Left of circle
			temp = 'a';
			
			if(fromParser.get(2).equals("20")) {
				temp++;
				String string = String.valueOf(temp);
				ara[x][y - radius] = string;
			}
			else if(fromParser.get(2).equals("30")) {
				temp = (char) (temp + 2);
				String string = String.valueOf(temp);
				ara[x][y - radius] = string;
			}
			else if(fromParser.get(2).equals("40")) {
				temp = (char) (temp + 3);
				String string = String.valueOf(temp);
				ara[x][y - radius] = string;
			}
			else if(fromParser.get(2).equals("50")) {
				temp = (char) (temp + 4);
				String string = String.valueOf(temp);
				ara[x][y - radius] = string;
			}
			else {
				ara[x][y - radius] = String.valueOf(temp);
			}

			//Top of circle or close
			temp = 'k';
			
			if(fromParser.get(2).equals("20")) {
				temp++;
				String string = String.valueOf(temp);
				ara[x - radius][y] = string;
			}
			else if(fromParser.get(2).equals("30")) {
				temp = (char) (temp + 2);
				String string = String.valueOf(temp);
				ara[x - radius][y] = string;
			}
			else if(fromParser.get(2).equals("40")) {
				temp = (char) (temp + 3);
				String string = String.valueOf(temp);
				ara[x - radius][y] = string;
			}
			else if(fromParser.get(2).equals("50")) {
				temp = (char) (temp + 4);
				String string = String.valueOf(temp);
				ara[x - radius][y] = string;
			}
			else {
				ara[x - radius][y] = String.valueOf(temp);
			}
		}
	} //end makeCircle
	
	private static void makeSnake(String[][] ara) {
		//TODO
	} //end makeSnake
	
	private static void makeTornado() {
		//radius can't be bigger than 4
		int radius = 5, x = 5, y = 5;

		//fifteen
		//Right of circle
		fifteen[x][y + radius] = "y";

		//Bottom of circle
		fifteen[x + radius][y] = "I";

		//Left of circle
		fifteen[x][y - radius] = "e";

		//Top of circle or close
		fifteen[x - radius][y] = "o";

		//twelve
		radius += -1;
		
		//Right of circle
		twelve[x][y + radius] = "x";

		//Bottom of circle
		twelve[x + radius][y] = "H";

		//Left of circle
		twelve[x][y - radius] = "d";

		//Top of circle or close
		twelve[x - radius][y] = "n";

		//nine
		radius += -1;
		
		//Right of circle
		nine[x][y + radius] = "w";

		//Bottom of circle
		nine[x + radius][y] = "G";

		//Left of circle
		nine[x][y - radius] = "c";

		//Top of circle or close
		nine[x - radius][y] = "m";

		//six
		radius += -1;
		
		//Right of circle
		six[x][y + radius] = "v";

		//Bottom of circle
		six[x + radius][y] = "F";

		//Left of circle
		six[x][y - radius] = "b";

		//Top of circle or close
		six[x - radius][y] = "l";

		//three
		radius += -1;
		
		//Right of circle
		three[x][y + radius] = "u";

		//Bottom of circle
		three[x + radius][y] = "E";

		//Left of circle
		three[x][y - radius] = "a";

		//Top of circle or close
		three[x - radius][y] = "k";


	} //end makeTornado
	
	private static void makePoint(String[][] ara) {
		char temp = 'a';
		
		if(fromParser.get(2).equals("20")) {
			temp++;
			String string = String.valueOf(temp);
			ara[5][5] = string;
		}
		else if(fromParser.get(2).equals("30")) {
			temp = (char) (temp + 2);
			String string = String.valueOf(temp);
			ara[5][5] = string;
		}
		else if(fromParser.get(2).equals("40")) {
			temp = (char) (temp + 3);
			String string = String.valueOf(temp);
			ara[5][5] = string;
		}
		else if(fromParser.get(2).equals("50")) {
			temp = (char) (temp + 4);
			String string = String.valueOf(temp);
			ara[5][5] = string;
		}
		else {
			ara[5][5] = String.valueOf(temp);
		}
	} //end makePoint
	
	
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
					ara[y][1] = String.valueOf(temp);
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
					temp[x] = String.valueOf(letter);
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
					temp[x] = String.valueOf(letter);
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
