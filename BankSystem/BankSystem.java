import java.util.Scanner;

public class BankSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankSystem bank = new BankSystem();

        System.out.println("Welcome to the Bank System");

        while (true) {
            System.out.println("\n1. Admin Login\n2. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bank.adminLogin();
                    break;
                case 2:
                    System.out.println("Exiting the system.");
                    System.exit(0);
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // Admin login method
    public void adminLogin() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Admin ID: ");
        String id = scanner.nextLine().trim();  // Remove any extra spaces
        System.out.print("Enter Admin Password: ");
        String password = scanner.nextLine().trim();

        if (Admin.verifyAdmin(id, password)) {
            System.out.println("Admin logged in successfully.");
            Admin.adminMenu();  // Go to admin menu
        } else {
            System.out.println("Invalid admin credentials.");
        }
    }
}
