package uz.pdp.model.payment;

import java.math.BigDecimal;
import java.util.UUID;

public class Merchant extends BasePaymentModel{
    private UUID merchantCategoryId;
    private BigDecimal balance;

    public Merchant() {

    }

    public Merchant(String name, UUID merchantCategoryId, BigDecimal balance) {
        super(name);
        this.merchantCategoryId = merchantCategoryId;
        this.balance = balance;
    }

    public Merchant(UUID merchantCategoryId, BigDecimal balance) {
        this.merchantCategoryId = merchantCategoryId;
        this.balance = balance;
    }

    public UUID getMerchantCategoryId() {
        return merchantCategoryId;
    }

    public void setMerchantCategoryId(UUID merchantCategoryId) {
        this.merchantCategoryId = merchantCategoryId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
