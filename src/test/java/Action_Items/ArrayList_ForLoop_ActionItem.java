package Action_Items;

import java.util.ArrayList;

public class ArrayList_ForLoop_ActionItem {
    public static void main(String[] args) {

       //Using String country & int countryCode with for loop and Arraylist
        //create at least 4 data for each variable and iterate through each to print out the i for both variables...
        //For instance, System.out.printin("My country is " + country.get(i) + " and my country code is " + countryCode.get(i)):
        ArrayList<String> countries = new ArrayList<>();
        countries.add("Bangladesh");
        countries.add("Pakistan");
        countries.add("India");
        countries.add("Japan");

        ArrayList<Integer> countryCode = new ArrayList<>();
        countryCode.add(243);
        countryCode.add(123);
        countryCode.add(453);
        countryCode.add(678);

        for (int i = 0; i < countries.size(); i++) {
            System.out.println("My country is " + countries.get(i) + " and my country code is " + countryCode.get(i));

        }//end of for loop

    }//end of main
}//end of class
