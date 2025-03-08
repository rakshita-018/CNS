import java.math.BigInteger;
import java.util.Scanner;
public class TW4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Prime Number P: ");
        BigInteger P = sc.nextBigInteger();
        System.out.println("Enter the value of G (a primitive root modulo P):");
        BigInteger G = sc.nextBigInteger();

        System.out.println("Enter private key of A: ");
        BigInteger a = sc.nextBigInteger();
        System.out.println("Enter private key of B: ");
        BigInteger b = sc.nextBigInteger();

            // Public keys
        BigInteger PA = G.modPow(a,P);
        BigInteger PB = G.modPow(b,P);

            // shared keys
        BigInteger SharedKeyA = PB.modPow(a, P);
        BigInteger SharedKeyB = PA.modPow(b,P);

        System.out.println("Public Key of A: "+ PA);
        System.out.println("Public Key of B: "+ PB);
        System.out.println("Shared Key of A: "+ SharedKeyA);
        System.out.println("Shared Key of B: "+ sharedKeyB);
        sc.close();
    }
}
