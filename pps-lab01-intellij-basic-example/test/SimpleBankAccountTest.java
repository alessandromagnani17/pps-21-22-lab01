import lab01.example.model.AccountHolder;
import lab01.example.model.SimpleBankAccount;
import org.junit.jupiter.api.BeforeEach;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest extends BasicSimpleBankAccountTest {
    private static final int FEE = 0;

    @BeforeEach
    public void beforeEach() {
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccount(this.accountHolder, 0);
    }

    protected int getFee() {
        return FEE;
    }
}
