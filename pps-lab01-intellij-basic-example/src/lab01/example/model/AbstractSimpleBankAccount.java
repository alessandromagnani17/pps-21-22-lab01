package lab01.example.model;

public abstract class AbstractSimpleBankAccount implements BankAccount {
    protected final AccountHolder holder;
    protected double balance;

    public AbstractSimpleBankAccount(final double balance, final AccountHolder holder) {
        this.balance = balance;
        this.holder = holder;
    }

    @Override
    public AccountHolder getHolder() {
        return this.holder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(int userID, double amount) {
        if (this.holder.getId() == userID && amount > 0) this.balance = this.balance + amount - getFee();
    }

    @Override
    public void withdraw(int userID, double amount) {
        if (this.holder.getId() == userID && amount > 0 && this.balance > amount)
            this.balance = this.balance - amount - getFee();
    }

    protected abstract int getFee();
}
