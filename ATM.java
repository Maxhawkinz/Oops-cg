import java.util.Scanner;
import java.util.InputMismatchException;

public class ATM {
    double balance;

    ATM(double initialization) {
        this.balance = initialization;
    }

    double checkBalance() {
        return balance;
    }

    void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount should be positive");
        }
        if (amount > balance) {
            throw new ArithmeticException("Insufficient balance");
        }
        if (amount > 51000) {
            throw new ArithmeticException("Withdrawal limit exceeded");
        }
        balance = balance - amount;
        System.out.println("Withdrawal successful. You have withdrawn: $" + amount);
        System.out.printf("Your current balance is: $%.2f%n", balance);
    }

    void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount should be positive");
        }
        balance = balance + amount;
        System.out.println("Deposit successful. You have deposited: $" + amount);
        System.out.printf("Your current balance is: $%.2f%n", balance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM a1 = new ATM(10000);  // Set the initial balance to 10000
        boolean exit = false;

        while (!exit) {
            System.out.println("----ATM MENU----");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Amount");
            System.out.println("3. Deposit Amount");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.printf("Your current balance is: $%.2f%n", a1.checkBalance());
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        a1.withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        a1.deposit(depositAmount);
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid option. Please select between 1-4.");
                        break;
                }

            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Invalid input type. Please enter numeric values.");
                scanner.nextLine();  // Clear the buffer
            } finally {
                System.out.println("Transaction complete.\n");
            }
        }

        // scanner.close();  // Avoid closing scanner here, keeping it open for future inputs
    }
}
