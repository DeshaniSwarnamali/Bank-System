import java.util.HashMap;
import java.util.Scanner;

public class Customer {
    private static HashMap<String, Customer> customers = new HashMap<>();
    private String id;
    private String name;
    private String password;
    private double balance;

    public Customer(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.balance = 0.0;
    }

    public static boolean verifyCustomer(String id, String password) {
        if (customers.containsKey(id)) {
            return customers.get(id).password.equals(password);
        }
        return false;
    }

    public static void createCustomerAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Create an ID: ");
        String id = scanner.next();
        System.out.print("Create a password: ");
        String password = scanner.next();

        Customer newCustomer = new Customer(id, name, password);
        customers.put(id, newCustomer);

        System.out.println("Account created successfully. You can now log in.");
    }

    public static void customerMenu(String id) {
        Scanner scanner = new Scanner(System.in);
        Customer customer = customers.get(id);

        while (true) {
            System.out.println("\n1. View Account Details\n2. Deposit Money\n3. Withdraw Money\n4. Transfer Money\n5. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    customer.viewAccountDetails();
                    break;
                case 2:
                    customer.depositMoney();
                    break;
                case 3:
                    customer.withdrawMoney();
                    break;
                case 4:
                    System.out.print("Enter recipient ID: ");
                    String recipientId = scanner.next();
                    customer.transferMoney(recipientId);
                    break;
                case 5:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public void viewAccountDetails() {
        System.out.println("Account ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Balance: $" + balance);
    }

    public void depositMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        balance += amount;
        System.out.println("Deposited $" + amount + ". New balance: $" + balance);
    }

    public void withdrawMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void transferMoney(String recipientId) {
        Scanner scanner = new Scanner(System.in);
        if (customers.containsKey(recipientId)) {
            System.out.print("Enter amount to transfer: ");
            double amount = scanner.nextDouble();
            if (amount <= balance) {
                balance -= amount;
                customers.get(recipientId).balance += amount;
                System.out.println("Transferred $" + amount + " to " + recipientId + ". New balance: $" + balance);
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Recipient ID not found.");
        }
    }
}
