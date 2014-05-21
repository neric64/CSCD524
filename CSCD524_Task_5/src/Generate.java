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
	   Real test = new Real(4, 2, 8.0);
	   Real test2 = new Real(3, 1, 3.2);
	   
	   test.add(test2);
	   
	   
	   /*
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
      */
   }
}
