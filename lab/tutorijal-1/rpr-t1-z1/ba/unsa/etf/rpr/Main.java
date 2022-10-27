import java.util.Scanner;

package ba.unsa.etf.rpr;

class Main {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.print("Unesite prvi broj: ");
        int num1 = scan.nextInt();
        System.out.print("Unesite drugi broj: ");
        int num2 = scan.nextInt();

        System.out.println("Uneseni brojevi su " + num1 + " i " + num2);
    }
}