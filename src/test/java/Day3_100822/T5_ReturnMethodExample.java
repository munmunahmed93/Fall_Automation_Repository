package Day3_100822;

public class T5_ReturnMethodExample {
    public static void main(String[] args) {

        int value = ReuasableClass.returnTwoAddNumbers(5,2);
        System.out.println("new value is " + (value+3));

        ReuasableClass.multiply(13, 2, 4);

        int a = 13;
        int b = 2;
        int c = 4;

        System.out.println(a*b*c);
    }
}
