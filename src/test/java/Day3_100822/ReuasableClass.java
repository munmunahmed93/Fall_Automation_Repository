package Day3_100822;

public class ReuasableClass {
    //create a void method that will add two numbers and execute the print statement
    public static void addTwoNumbers(int a, int b){
        int result = a+b;
        System.out.println("the result is " + result);

    }//end of AddTwoNumber


    public static void multiply(int a, int b, int c){

        int result = a*b*c;
        System.out.println("the result is " + result);

    }//End of multiplication

    //create a return method that will add two values and return the result from the print statement
    public static int returnTwoAddNumbers(int a, int b){
        int result = a+b;
        System.out.println("the return result is " + result);
        return result;
    }

}//end of java class
