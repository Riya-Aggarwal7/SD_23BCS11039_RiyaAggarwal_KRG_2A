class Account {
    private String accountHolder;
    private double balance;

    public Account(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited successfully.");
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}


class AccountService {
    public void transfer(Account from, Account to, double amount) {
        if (amount <= from.getBalance()) {
            from.withdraw(amount);
            to.deposit(amount);
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Transfer failed.");
        }
    }
}

class AccountPrinter {
    public void printDetails(Account account) {
        System.out.println("Account Holder: " + account.getAccountHolder());
        System.out.println("Balance: " + account.getBalance());
    }
}

public class BankingApp {
    public static void main(String[] args) {
        Account acc1 = new Account("Riya", 5000);
        Account acc2 = new Account("Aman", 3000);

        AccountPrinter printer = new AccountPrinter();
        AccountService service = new AccountService();

        System.out.println("Before Transfer:");
        printer.printDetails(acc1);
        printer.printDetails(acc2);

        service.transfer(acc1, acc2, 2000);

        System.out.println("\nAfter Transfer:");
        printer.printDetails(acc1);
        printer.printDetails(acc2);
    }
}
