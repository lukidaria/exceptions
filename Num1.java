package exceptions;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Num1 {


    static void calc()  {
        File file = new File("input.txt");
        String a = "";
        String znak = "";
        String b = "";
        double num1 = 0;
        double num2 = 0;
        try {

            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                a = sc.next();
                znak = sc.next();
                b = sc.next();
                try {
                    num1 = Double.parseDouble(a);
                    num2 = Double.parseDouble(b);

                } catch (NumberFormatException e) {
                    throw new NumberFormatException("Error! Not number");
                }

                if ((!znak.equals("+")) && (!znak.equals("-")) && (!znak.equals("*"))
                        && (!znak.equals("/"))) {
                    throw new IllegalArgumentException("Operation Error!");
                }
                if (num2 == 0 && znak.equals("/")) {
                    throw new ArithmeticException("Error! Division by zero");
                }


                if (znak.equals("+")) {
                    System.out.println(num1 + num2);
                } else if (znak.equals("-")) {
                    System.out.println(num1 - num2);
                } else if (znak.equals("*")) {
                    System.out.println(num1 * num2);
                } else if (znak.equals("/")) {
                    System.out.println(num1 / num2);
                }

            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }


    public static void main(String[] args) {

        calc();

    }

}
//class ZnakException extends Exception {
//    ZnakException(String message) {
//        super(message);
//    }
//}
//
//class DelenieNaNolException extends Exception {
//    DelenieNaNolException(String message) {
//        super(message);
//    }
//}