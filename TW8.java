import java.math.BigInteger;
import java.util.Scanner;

public class TW8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Prime Number p: ");
        BigInteger p = sc.nextBigInteger();

        System.out.println("Enter Prime Number q: ");
        BigInteger q = sc.nextBigInteger();

        BigInteger n = p.multiply(q);
        BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));

        System.out.println("phi: "+phi);
        System.out.println("Enter public exponent: ");
        BigInteger e = sc.nextBigInteger();

        if(e.compareTo(BigInteger.ONE)<=0 || e.compareTo(phi) >=0 || !e.gcd(phi).equals(BigInteger.ONE)){
            System.out.println("Invalid value");
            return ;
        }

        BigInteger d = e.modInverse(phi);
        System.out.println("Enter the message in integer: ");
        BigInteger m = sc.nextBigInteger();

        if(m.compareTo(BigInteger.ZERO)<0 || m.compareTo(n)>=0){
            System.out.println("Invalid Message");
            return;
        }

        BigInteger c = m.modPow(e, n);
        System.out.println("Private key d: " + d);
        System.out.println("Cipher text c :" + c);
        System.out.println("decrypt: " + c.modPow(d,n));

        sc.close();
        
    }
}
