import java.util.Random;


public class RandomWalk {

	private int walkDistance;
	private Real[] realX;
	private Real[] realY;
	private float[] floatX;
	private float[] floatY;
	private final int MIN = -1000000;
	private final int MAX = 1000000;
	private double dx, dy;
	
	public RandomWalk(int walk) {
		this.walkDistance = walk;
	}
	
	public double[][] execute() {
		initMaps();
		double[][] errors = null;
		
		for(int i = 0; i < this.walkDistance; i++) {
			this.floatX[i] = getRandFloat();
			this.floatY[i] = getRandFloat();
			
			dx = getRandDouble();
			dy = getRandDouble();
			
			//Need to figure out how to get the different value and scale numbers in here
			//posibably use a get value or scale method?
			this.realX[i] = new Real(1,1, dx);
			this.realY[i] = new Real(1,1, dy);
			
			//System.out.println("Real value: " + this.realX[i].getValue());	//for testing
		}
		errors = getError();
		
		return errors;
	} //end of execute
	
	private double[][] getError() {
		double[][] temp = new double[2][this.walkDistance];
		for(int i = 0; i < this.walkDistance; i++) {
			temp[0][i] = Math.abs(this.realX[i].getValue() - this.floatX[i]);
			temp[1][i] = Math.abs(this.realY[i].getValue() - this.floatY[i]);
		}
		
		return temp;
	} //end getError
	
	private float getRandFloat() {
		Random rand = new Random();
		return MIN + (rand.nextFloat() * ((1 + MAX) - MIN));
	} //end getRandFloat
	
	private double getRandDouble() {
		Random rand = new Random();
		return MIN + (rand.nextDouble() * ((1 + MAX) - MIN));
	} //end getRandDouble
	
	private void initMaps() {
		this.floatX = new float[this.walkDistance];
		this.floatY = new float[this.walkDistance];
		this.realX = new Real[this.walkDistance];
		this.realY = new Real[this.walkDistance];
	} //end initMaps
}
