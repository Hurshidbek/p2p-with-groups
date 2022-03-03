package uz.pdp.model.history;

import java.math.BigDecimal;

public class P2PHistory extends BaseHistory{

    private String fromCardNumber;
    private String toCardNumber;
    private BigDecimal amount;

    private P2PType p2PType;

    public P2PHistory(String fromCardNumber, String toCardNumber, BigDecimal amount, P2PType p2PType) {
        this.fromCardNumber = fromCardNumber;
        this.toCardNumber = toCardNumber;
        this.amount = amount;
        this.p2PType = p2PType;
    }

    public P2PHistory() {

    }

    public String getFromCardNumber() {
        return fromCardNumber;
    }

    public void setFromCardNumber(String fromCardNumber) {
        this.fromCardNumber = fromCardNumber;
    }

    public String getToCardNumber() {
        return toCardNumber;
    }

    public void setToCardNumber(String toCardNumber) {
        this.toCardNumber = toCardNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public P2PType getP2PType() {
        return p2PType;
    }

    public void setP2PType(P2PType p2PType) {
        this.p2PType = p2PType;
    }

    @Override
    protected String list() {
        return "" +
                "" +
                "";
    }
}
