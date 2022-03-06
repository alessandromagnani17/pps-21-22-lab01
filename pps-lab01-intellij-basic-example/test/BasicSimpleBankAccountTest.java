import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class BasicSimpleBankAccountTest {

    protected AccountHolder accountHolder;
    protected BankAccount bankAccount;

    @Test
    void testInitialBalance() {
        assertEquals(0, this.bankAccount.getBalance());
    }

    @Test
    void testNegativeDeposit() {
        this.bankAccount.deposit(this.accountHolder.getId(), -100);
        assertEquals(0, this.bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        this.bankAccount.deposit(this.accountHolder.getId(), 100);
        assertEquals(100 - getFee(), this.bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        this.bankAccount.deposit(this.accountHolder.getId(), 100);
        this.bankAccount.deposit(2, 100);
        assertEquals(100 - getFee(), this.bankAccount.getBalance());
    }

    @Test
    void testNegativeWithdraw() {
        this.bankAccount.withdraw(this.accountHolder.getId(), -100);
        assertEquals(0, this.bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        this.bankAccount.deposit(this.accountHolder.getId(), 100);
        this.bankAccount.withdraw(this.accountHolder.getId(), 50);
        assertEquals(50 - getFee() * 2, this.bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        this.bankAccount.deposit(this.accountHolder.getId(), 50);
        this.bankAccount.withdraw(this.accountHolder.getId(), 100);
        assertEquals(50 - getFee(), this.bankAccount.getBalance());
    }

    protected abstract int getFee();
}
