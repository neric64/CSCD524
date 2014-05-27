import java.util.Random;

//============================================================================================================================================================
/**
 * Defines a driver to generate the test combinations in CS 524 Task 5. Modify this however you want, but all 560 combinations must be considered. Since
 * combinations with more scale bits than necessary produce no additional effect, they are culled.
 * 
 * @author Dan Tappan [14.05.14]
 */
public class Generate
{
   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Generates the test combinations.
    * 
    * @param arguments - there are no arguments
    */
   public static void main(final String[] arguments)
   {
	   Random num = new Random();
	   
	   RandomWalkSimulation sim = new RandomWalkSimulation(1000, num.nextInt());
	   
	   sim.setWalkDistance(1);
	   
	   sim.simulate();
	   
	   //sim.setIteration(5);
	   //sim.setSeed(num.nextInt());
	   
	   //sim.simulate();
	   
	   sim.printError();
	   /*
	    * TODO
	    * modify the generate code and put RandomWalkSimulation inside of it to get the bit value and scale bit
	    * but that won't work because it only takes in the number of iterations and the random seed.
	    * Will need to think on this more.
	    */
   }
   
   private void run(int numWalks, int seed) {
	   final int bitsMax = 32;

	   int comboNum = 0;

	   System.out.println("combo, total_bits, value_bits, scale_bits");

	   for (int iBitsValue = 0; iBitsValue <= bitsMax; ++iBitsValue)
	   {
		   double bitsScaleMax = 31;

		   for (int iBitsScale = 0; iBitsScale <= bitsScaleMax; ++iBitsScale)
		   {
			   int bitsTotal = (iBitsValue + iBitsScale);

			   if (bitsTotal <= bitsMax)
			   {
				   ++comboNum;

				   System.out.println(comboNum + ", " + bitsTotal + ", " + iBitsValue + ", " + iBitsScale);
			   }
		   }
	   }
   } //end run
}
