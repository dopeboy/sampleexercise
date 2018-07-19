class ATM {
    public static void main(String[] args) {
        Account a = new Account(AccountType.CHECKING, 300);

        // This should print out the initial balance (200)
        System.out.println(a.getBalance());

        // Let's make a deposit of $100.54
        a.deposit(100.54);

        // Let's print the balance. Should see $300.54
        System.out.println(a.getBalance());

        // Let's withdraw more money than we have, $400
        // This should fail
        boolean withdrawStatus = a.withdraw(400);
        if (withdrawStatus) {
            System.out.println("Withdraw was successful");
            System.out.println("New balance: " + a.getBalance());
        }

        else {
            System.out.println("Withdraw failed");
            System.out.println("Existing balance: " + a.getBalance());
        }

        // Let's withdraw less money than we have, $200
        // This should work
        boolean withdrawStatusTwo = a.withdraw(200);
        if (withdrawStatusTwo) {
            System.out.println("Withdraw was successful");
            System.out.println("New balance: " + a.getBalance());
        }

        else {
            System.out.println("Withdraw failed");
            System.out.println("Existing balance: " + a.getBalance());
        }
    }
}

enum AccountType
{
    CHECKING, SAVING
}

class Account {
    private double balance;
    private AccountType type;

    public Account(AccountType at, double initialBalance) {
        balance = initialBalance;
        type = at;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        balance += amount;
        return true;
    }

    public boolean withdraw(int amount) {
        if (amount > balance) {
            return false;
        }

        else {
            balance -= amount;
            return true;
        }
    }
}
