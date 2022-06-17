package exceptions;
import java.io.*;
import java.nio.channels.ScatteringByteChannel;
import java.util.Scanner;

public class Num3 {
    static void calc() throws IOException {
        FileReader fR = new FileReader("input.txt");
        FileWriter fW = new FileWriter("output.txt");
        String a = "";
        String znak = "";
        String b = "";
        double num1 = 0;
        double num2 = 0;
        try {

            Scanner sc = new Scanner(fR);
            while (sc.hasNextLine()) {
                a = sc.next();
                znak = sc.next();
                b = sc.next();

                fW.write(a + " ");
                fW.write(znak + " ");
                fW.write(b + " ");
                try {
                    num1 = Double.parseDouble(a);
                    num2 = Double.parseDouble(b);

                    if (znak.equals("+")) {
                        System.out.println(num1 + num2);
                        fW.write(" = " + String.valueOf(num1 + num2) + "\n");
                    } else if (znak.equals("-")) {
                        System.out.println(num1 - num2);
                        fW.write(" = " + String.valueOf(num1 - num2) + "\n");
                    } else if (znak.equals("*")) {
                        System.out.println(num1 * num2);
                        fW.write(" = " + String.valueOf(num1 * num2) + "\n");
                    } else if (znak.equals("/")) {
                        if (num2 == 0) {
                            throw new ArithmeticException();
                        }
                        System.out.println(num1 / num2);
                        fW.write(" = " + String.valueOf(num1 / num2) + "\n");
                    }

                    if ((!znak.equals("+")) && (!znak.equals("-")) && (!znak.equals("*"))
                            && (!znak.equals("/"))) {
                        throw new IllegalArgumentException();
                    }

                } catch (NumberFormatException e) {
                    fW.write(" = Error! Not number\n");
                    System.out.println("Error! Not number");

                } catch (IllegalArgumentException e1) {
                    fW.write(" = Operation Error!\n");
                    System.out.println("Operation Error!");
                } catch (ArithmeticException e2) {
                    fW.write(" = Error! Division by zero\n");
                    System.out.println("Error! Division by zero");
                }



            }
            fR.close();
            fW.close();
        } catch(
                FileNotFoundException e)

        {
            e.printStackTrace();
        }


    }


    public static void main(String[] args) throws IOException {

        calc();

    }

}

