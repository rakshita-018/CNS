import java.util.Scanner;
public class TW2{

    public static boolean isvalidPassword(String password){
        if(password.length()< 8){
            System.out.println("lenght of password should be greater than 8");
            return false;
        }

        if(password.matches("[a-zA-Z]+") || password.matches("[0-9]+") || password.matches("[^a-zA-Z0-9]+")){
            System.out.println("password contains only letters, character and numbers");
            return false;
        }

        if(password.matches(".*[a-zA-Z].*") && password.matches(".*[0-9].*") && password.matches(".*[^a-zA-Z0-9].*")){
            System.out.println("password contains all letters, character and numbers");
            return true;
        }else{
            System.out.println("Moderate password: Contains a combination of numbers and alphabets, or alphabets and special characters, or special characters and numbers");

            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the password");
        String password = sc.nextLine();

        if(isvalidPassword(password)){
            System.out.println("Strong password");
        }

        sc.close();
    }
}