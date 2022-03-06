import lab01.example.model.AccountHolder;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;

public class SimpleBankAccountWithAtmTest extends BasicSimpleBankAccountTest {
    private static final int FEE = 1;

    @BeforeEach
    public void beforeEach() {
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccountWithAtm(this.accountHolder, 0);
    }

    @Override
    protected int getFee() {
        return FEE;
    }
}
