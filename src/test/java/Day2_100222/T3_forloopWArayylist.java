package Day2_100222;

import java.util.ArrayList;

public class T3_forloopWArayylist {

    public static void main(String[] args) {

        //declare and define the arraylist for zip code
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("132345");
        zipCode.add("105345");
        zipCode.add("102745");
        zipCode.add("102395");

        //call for loop to print out all zip code values from the array list
        //if you want to control the end point by number, then put actual number instead of zipcode.size()
        //for array list it uses .size() to get the count of the list but linear array it uses .length() to get the count of the list
        for (int i = 0; i < zipCode.size(); i++) {
            //print out each zip code automatically
            System.out.println("Zip code: " + zipCode.get(i));
        }//end of for loop
    }//end of main

}//end of java class
