package uz.pdp.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Card extends BaseModel{
    private String cardNumber;
    private String expiryDate;
    private UUID userId;
    private BigDecimal balance;

    public Card() {

    }

    public Card(String name, String phoneNumber, String cardNumber, String expiryDate, UUID userId, BigDecimal balance) {
        super(name, phoneNumber);
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.userId = userId;
        this.balance = balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
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
        return true;
    }
}
