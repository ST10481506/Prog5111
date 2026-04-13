import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Login login = new Login();

        
        // ===== REGISTER =====
        System.out.println("=== Registration ===");

        System.out.print("Enter first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter last name: ");
        String lastName = input.nextLine();

        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        System.out.print("Enter cell number: ");
        String cell = input.nextLine();

        String registerMessage = login.registerUser(username, password, cell, firstName, lastName);
        System.out.println(registerMessage);

        // ===== LOGIN =====
        System.out.println("\n=== Login ===");

        System.out.print("Enter username: ");
        String loginUser = input.nextLine();

        System.out.print("Enter password: ");
        String loginPass = input.nextLine();

        boolean isLoggedIn = login.loginUser(loginUser, loginPass);

        String loginMessage = login.returnLoginStatus(isLoggedIn);
        System.out.println(loginMessage);
    }
}