//-------------------------------Developed By Khadim Ali--------------------------------------
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User[] users = {
                new User("Khadim", 3306),
                new User("Ali", 2222),
                new User("Aasim", 3333)
        };

        ATM atm = new ATM("Meezan Bank", 9830, "Shikarpur", 1000000);

        boolean isLoggedIn = false;
        User currentUser = null;

        while (true) {
            if (!isLoggedIn) {
                System.out.print("Enter User ID: ");
                String inputUserId = scanner.next();

                System.out.print("Enter PIN: ");
                int inputPin = scanner.nextInt();

                boolean isValidUser = false;
                for (User user : users) {
                    if (inputUserId.equals(user.getUserId()) && inputPin == user.getPin()) {
                        System.out.println("Authentication successful!");
                        isLoggedIn = true;
                        currentUser = user;
                        isValidUser = true;
                        break;
                    }
                }

                if (!isValidUser) {
                    System.out.println("Authentication failed. Please try again.");
                    continue;
                }
            }
            System.out.println("----------Developed By Khadim Ali---------");
            System.out.println("\n" + " Welcome to ATM" + currentUser.getUserId());
            System.out.println("1. Deposit Cash");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Balance Inquiry");
            System.out.println("4. Change PIN");
            System.out.println("5. Statement");
            System.out.println("6. Log Out");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
                      
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter the amount to deposit: ");
                    int depositAmount = scanner.nextInt();
                    if (atm.isAboveLimit(depositAmount)) {
                        System.out.println("Amount is greater than your Limit.");
                    } else {
                        atm.depositCash(depositAmount);
                        System.out.println("Deposit Successful: " + depositAmount + " PKR");
                    }
                }
                case 2 -> {
                    System.out.print("Enter the amount to withdraw: ");
                    int withdrawAmount = scanner.nextInt();
                    if (atm.withdrawMoney(withdrawAmount)) {
                        System.out.println("Withdrawal Transaction Successful: " + withdrawAmount + " PKR");
                    } else {
                        System.out.println("Insufficient balance!");
                    }
                }  // Khadim Ali
                case 3 -> {
                    int availableCash = atm.getAvailableCash();
                    System.out.println("Available Balance: " + availableCash + " PKR");
                }
                case 4 -> {
                    System.out.print("Enter new PIN: ");
                    int newPin = scanner.nextInt();
                    for (User user : users) {
                        if (currentUser.getUserId().equals(user.getUserId())) {
                            user.setPin(newPin);
                            System.out.println("PIN changed successfully!");
                            break;
                        }
                    }
                }
                case 5 -> {
                    System.out.println("Transaction History:");
                    for (String transaction : atm.getTransactionList()) {
                        System.out.println(transaction);
                    }
                }
                case 6 -> {
                    System.out.println("Logging out...");
                    isLoggedIn = false;
                    currentUser = null;
                }
                case 7 -> {
                    System.out.println("Exiting ATM Menu.");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
  // Khadim Ali