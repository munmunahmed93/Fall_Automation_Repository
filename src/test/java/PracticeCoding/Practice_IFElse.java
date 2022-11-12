package PracticeCoding;

public class Practice_IFElse {
    public static void main(String[] args) {
        //declare three integer variable
        int a, b, c;
        a = 1;
        b = 3;
        c = 4;

        //write multiple conditional statements that cover when a+b < c, a+b > c or a+b = c
        if (a + b < c) {
            System.out.println("a and b is less than c");
        } else if (a + b > c) {
            System.out.println("a and b is greater than c");
        } else if (a + c < b) {
            System.out.println("a and c is less than b");
        } else if (a == b) {
            System.out.println("a is less than b");
        } else {
            System.out.println("the previous statements are LIES");

        }// of conditional statement
    }//end of main
}//end of java class
