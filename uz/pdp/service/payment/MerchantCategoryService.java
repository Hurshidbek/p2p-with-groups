package uz.pdp.service.payment;

import uz.pdp.model.payment.MerchantCategory;
import uz.pdp.model.response.BaseResponse;
import uz.pdp.repository.BaseService;

import java.util.List;
import java.util.UUID;

public class MerchantCategoryService implements BaseService<MerchantCategory, String, List<MerchantCategory>>, BaseResponse {
    @Override
    public String add(MerchantCategory merchantCategory) {
        merchantCategoryList.add(merchantCategory);
        return SUCCESS;
    }

    @Override
    public List<MerchantCategory> get() {
        return merchantCategoryList;
    }

    @Override
    public List<MerchantCategory> getByID(UUID id) {
        return null;
    }

    @Override
    public String editById(UUID id, MerchantCategory merchantCategory) {
        return null;
    }

    @Override
    public String deleteById(UUID id) {
        return null;
    }
}
