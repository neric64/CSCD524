import java.util.ArrayList;

public class RandomWalkSimulation {
	private int iteration, seed, divideBy = 0, walk;
	private double xError = 0, yError = 0, sdX, sdY;
	private double[][] error;
	private ArrayList<double[][]> errorHolder = new ArrayList<double[][]>();
	private StringBuilder builder = new StringBuilder();
	
	public RandomWalkSimulation(int iteration, int seed) {
		this.iteration = iteration;
		this.seed = seed;
	}
	
	public void simulate() {
		RandomWalk walk = new RandomWalk(this.walk);
		this.divideBy += this.iteration;
		boolean hasNext = true;
		int index = this.iteration;
		
		do {
			for(int i = 0; i < this.walk; i++) {
				this.error = walk.execute();
				this.errorHolder.add(error);
				this.builder.append("Error for x axis: " + this.error[0][i] + "\n");
				this.builder.append("Error for y axis: " + this.error[1][i] + "\n");

				this.sdX += Math.abs(this.error[0][i] * this.error[0][i]);
				this.sdY += Math.abs(this.error[1][i] * this.error[1][i]);

				this.xError += this.error[0][i];
				this.yError += this.error[1][i];
				
				index--;
				if(index == 0)
					hasNext = false;
			}
		} while(hasNext == true);
	} //end simulate
	
	public void setIteration(int num) {
		this.iteration = num;
	} //end setIteration
	
	public void setSeed(int num) {
		this.seed = num;
	} //end setSeed
	
	public void setWalkDistance(int walk) {
		this.walk = walk;
	}
	
	public void printError() {
		double averageX, averageY;
		System.out.println("The error between the float and Real for each iteration are: ");
		
		System.out.println(builder);
		
		averageX = this.xError / this.divideBy;
		averageY = this.yError / this.divideBy;
		
		//setup for getting standard deviation
//===========================================================================		
		this.sdX = this.sdX / this.divideBy;
		this.sdY =this. sdY / this.divideBy;
		
		this.sdX = Math.abs(this.sdX - (averageX * averageX));
		this.sdY = Math.abs(this.sdY - (averageY * averageY));
//===========================================================================		
		
		System.out.println("The average x aixs error is: " + averageX);
		System.out.println("The average y aixs error is: " + averageY);
		System.out.println("The standard deviation for x aixs is: " + Math.sqrt(this.sdX));
		System.out.println("The standard deviation for y aixs is: " + Math.sqrt(this.sdY));
	} //end printError
	
	//Need to have an ArrayList<double[][]> to receive it on the other side and then get the actual
	// double[][] to get to the values.
	public ArrayList<double[][]> getErrorHolder() {
		return this.errorHolder;
	} //end getErrorHolder
	
	public int getSeed() {
		return this.seed;
	}
}
