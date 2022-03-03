package uz.pdp.model.payment;

import java.util.UUID;

public class MerchantField extends BasePaymentModel{
    private UUID merchantId;
    private String title;
    private String value;

    public MerchantField() {

    }

    public MerchantField(String name, UUID merchantId, String title, String value) {
        super(name);
        this.merchantId = merchantId;
        this.title = title;
        this.value = value;
    }

    public MerchantField(UUID merchantId, String title, String value) {
        this.merchantId = merchantId;
        this.title = title;
        this.value = value;
    }

    public UUID getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(UUID merchantId) {
        this.merchantId = merchantId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
