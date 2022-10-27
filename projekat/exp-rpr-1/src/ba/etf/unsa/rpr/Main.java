package ba.etf.unsa.rpr;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        // Number input
        System.out.print("Enter a number: ");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        // Number output
        System.out.println("You just entered " + num);

        // For loop
        for (int i = 0; i < 10; i++)
        {
            System.out.print((i + 1) + " ");
        }

        // Calling another method
        System.out.println(ReturnInt());

        AnotherClass object = new AnotherClass();
        System.out.println(object.ReturnInt());
    }

    private static int ReturnInt()
    {
        int val = 11;
        return val;
    }
}
