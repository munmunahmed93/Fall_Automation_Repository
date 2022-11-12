package Action_Items;

public class LinearArray_WhileLoop_ActionItem {
    public static void main(String[] args) {
        //Using String[] region & int[] areaCode with while loop and linear array
        //create at least 4 data for each variable and iterate through each to print out the i for both variables...
        //For instance, System.out.printin("My region is " + region[i] + " and my area code is " + areaCode [i]):

        String[] region = new String[]{"Japan", "Maldives", "Bali", "Talum"};

        int[] areaCode = new int[]{523, 789, 346, 748};

        int i = 0;
        while (i < region.length){

            System.out.println("My region is " + region[i] + " and my area code is " + areaCode [i]);

            i++;

        }//end of while loop


    }//end of main
}//end of class
