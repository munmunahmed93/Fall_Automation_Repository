package Review_100422;

import java.util.ArrayList;

public class Review_1004 {
    public static void main(String[] args) {
        // create a linear array of car brands (5)
        //Print it out to the console using while loop

        String[] carBrands;
        carBrands = new String[]{"toyota", "BMW", "Mercedes", "Honda", "Lambo"};

        int i = 0;
        while (i < carBrands.length){

            System.out.println("My Dream car is a " + carBrands[i]);
            i++;
        }//end of while loop


        //lets create an array list of phone numbers (5)
        //Print it to console using for loop

        ArrayList<String> phoneNumber = new ArrayList<>();
        phoneNumber.add("5163627490");
        phoneNumber.add("8976110234");
        phoneNumber.add("5678902334");
        phoneNumber.add("5612347684");
        phoneNumber.add("6753428902");

        for (int b = 0; b < phoneNumber.size(); b++){
            System.out.println("My phone number is " + phoneNumber.get(b));
        }//end of for loop
    }//end of main
}//end of class
