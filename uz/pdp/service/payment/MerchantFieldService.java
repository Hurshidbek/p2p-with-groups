package uz.pdp.service.payment;

import uz.pdp.model.payment.MerchantField;
import uz.pdp.model.response.BaseResponse;
import uz.pdp.repository.BaseService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MerchantFieldService implements BaseService<MerchantField, String, List<MerchantField>>, BaseResponse {
    @Override
    public String add(MerchantField merchantField) {
        merchantFieldList.add(merchantField);
        return SUCCESS;
    }

    @Override
    public List<MerchantField> get() {
        return merchantFieldList;
    }

    @Override
    public List<MerchantField> getByID(UUID merchantId) {
        List<MerchantField> list = new ArrayList<>();
        for (MerchantField merchantField : merchantFieldList) {
            if (merchantField.getMerchantId().equals(merchantId))
                list.add(merchantField);
        }
        return list;
    }

    @Override
    public String editById(UUID id, MerchantField merchantField) {
        return null;
    }

    @Override
    public String deleteById(UUID id) {
        return null;
    }
}
