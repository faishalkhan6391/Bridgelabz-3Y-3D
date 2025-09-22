package MixConceptoops;



interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

abstract class BankAccount {
    private final String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public abstract double calculateInterest();

    public void displayAccountDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Holder Name: " + holderName);
            System.out.println("Balance: $" + balance);
            System.out.println("Interest: $" + calculateInterest());
        } else {
            System.out.println("Invalid bank account instance.");
        }
    }
}

class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate;

    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }

    @Override
    public void applyForLoan(double amount) {
        if (calculateLoanEligibility()) {
            System.out.println("Loan of $" + amount + " approved for savings account.");
        } else {
            System.out.println("Loan not eligible for savings account.");
        }
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 1000; // minimum balance for eligibility
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    private double interestRate;

    public CurrentAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }

    @Override
    public void applyForLoan(double amount) {
        if (calculateLoanEligibility()) {
            System.out.println("Loan of $" + amount + " approved for current account.");
        } else {
            System.out.println("Loan not eligible for current account.");
        }
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 500; // lower minimum balance for current account
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount[] accounts = {
            new SavingsAccount("SA101", "Alice", 2000, 5),
            new CurrentAccount("CA202", "Bob", 1000, 3)
        };

        for (BankAccount account : accounts) {
            account.displayAccountDetails();
            System.out.println();
            if (account instanceof Loanable) {
                ((Loanable) account).applyForLoan(500);
            }
            System.out.println();
        }

        // Perform transactions
        accounts[0].deposit(500);
        accounts[1].withdraw(200);
        accounts[0].displayAccountDetails();
        accounts[1].displayAccountDetails();
    }
}
