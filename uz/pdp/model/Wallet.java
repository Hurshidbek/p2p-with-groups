package uz.pdp.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Wallet extends BaseModel{

    private BigDecimal balance;
    private UUID userId;

    public Wallet () {

    }

    public Wallet(String name, String phoneNumber, BigDecimal balance) {
        super(name, phoneNumber);
        this.balance = balance;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    protected boolean checkName() {
        return false;
    }
}
