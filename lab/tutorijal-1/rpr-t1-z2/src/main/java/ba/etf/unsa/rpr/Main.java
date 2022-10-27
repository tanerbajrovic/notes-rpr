package ba.etf.unsa.rpr;

// Importujemo klasu Scanner
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Kreiramo instancu klase Scanner tipa System.in
        Scanner scan = new Scanner(System.in);

        // Unos broja n i ispis savrsenih brojeva
        System.out.print("Unesite broj n: ");
        int n = scan.nextInt();
        System.out.println("Brojevi koji su djeljivi sa svojom sumom cifara su:");
        for (int i = 1; i <= n; i++) {
            if (i % sumaCifara(i) == 0)
                System.out.print(i + " ");
        }
    }
    public static int sumaCifara(int broj) {
        int sumaCifara = 0;
        while (broj != 0) {
            sumaCifara = sumaCifara + (broj % 10);
            broj = broj / 10;
        }
        return sumaCifara;
    }
}
