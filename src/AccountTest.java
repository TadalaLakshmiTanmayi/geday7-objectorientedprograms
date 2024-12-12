import java.util.Scanner;

class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public void debit(double amount) {
        if (amount > balance) {
            System.out.println("Debit amount exceeded account balance.");
        } else {
            balance -= amount;
            System.out.println("Debit of $" + amount + " successful. New balance: $" + balance);
        }
    }
}

public class AccountTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the initial balance
        System.out.print("Enter the initial balance: ");
        double initialBalance = scanner.nextDouble();

        // Create an Account object with the user-provided initial balance
        Account account = new Account(initialBalance);

        System.out.println("Initial balance: $" + initialBalance);

        // Ask the user for the amount to debit
        System.out.print("Enter the amount to debit: ");
        double amount = scanner.nextDouble();

        // Perform the debit operation
        account.debit(amount);

        scanner.close();
    }
}
