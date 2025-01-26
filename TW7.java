import java.util.Scanner;

class TW7{
    public static String encrypt(String M, int shift){
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < M.length(); i++){
            char c = M.charAt(i);
            if(Character.isAlphabetic(c)){
                char base = Character.isLowerCase(c) ? 'a': 'A';
                result.append((char)((c-base+ shift)%26 + base));
            }
            else{
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String decrypt(String M, int shift){
        return encrypt(M, 26-shift);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string: ");
        String M = sc.nextLine();
        System.out.println("Enter the key: ");
        int key = sc.nextInt();

        String encryptedMsg = encrypt(M,key);
        System.out.println("Encrypted message: " + encryptedMsg );

        String decryptedMsg = decrypt(encryptedMsg,key);
        System.out.println("Encrypted message: " + decryptedMsg);

        sc.close();
    }
}