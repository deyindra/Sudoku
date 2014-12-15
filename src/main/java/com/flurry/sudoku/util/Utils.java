package com.flurry.sudoku.util;

/**
 * @author idey
 * A utility class provides various Utility method used for this Sudoku project
 */
public class Utils {

    private Utils(){
        throw new AssertionError("Invalid constructor Call....");
    }

    /**
     * Given a 32 bit integer check if the number is prefect square or not.
     * @param number number should be 32 bit integer and 0<=number<={@link java.lang.Integer#MAX_VALUE}
     * @return true or false
     */
   public static boolean isPrefectSquare(int number){
       if(number<=0){
           throw new IllegalArgumentException("Invalid Number..."+number);
       }
       int result = (int)Math.sqrt(number);
       return ((result*result) == number);
   }

}
