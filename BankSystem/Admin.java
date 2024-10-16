import java.util.Scanner;

public class Admin {
    // Hardcoded admin credentials
    private static final String adminId = "admin";
    private static final String adminPassword = "admin123";

    // Method to verify admin credentials
    public static boolean verifyAdmin(String id, String password) {
        return adminId.equalsIgnoreCase(id) && adminPassword.equals(password);
    }

    // Admin menu with basic options
    public static void adminMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nAdmin Menu");
            System.out.println("1. Update Account Details\n2. Manage Transactions\n3. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    updateAccountDetails();
                    break;
                case 2:
                    manageTransactions();
                    break;
                case 3:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // Stub methods for Admin actions
    public static void updateAccountDetails() {
        System.out.println("Account details updated.");
    }

    public static void manageTransactions() {
        System.out.println("Managing transactions...");
    }
}
