package uz.pdp.model.history;

import uz.pdp.model.payment.Merchant;
import uz.pdp.model.payment.MerchantField;

import java.util.List;
import java.util.UUID;

public class PaymentHistory extends BaseHistory{
    private String merchantName;
    List<MerchantField> merchantFieldList;

    public PaymentHistory(String merchantName, List<MerchantField> merchantFieldList) {
        this.merchantName = merchantName;
        this.merchantFieldList = merchantFieldList;
    }

    public PaymentHistory() {

    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public List<MerchantField> getMerchantFieldList() {
        return merchantFieldList;
    }

    public void setMerchantFieldList(List<MerchantField> merchantFieldList) {
        this.merchantFieldList = merchantFieldList;
    }

    @Override
    protected String list() {
        return "merchant_name: " + this.merchantName +
                this.getFieldsToString();

    }

    private String getFieldsToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (MerchantField merchantField : merchantFieldList) {
            stringBuilder.append(merchantField.getName() + " : " +  merchantField.getValue() + "\n");
        }
        return stringBuilder.toString();
    }
}
