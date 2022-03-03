package uz.pdp.service.payment;

import uz.pdp.model.payment.Merchant;
import uz.pdp.model.response.BaseResponse;
import uz.pdp.repository.BaseService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MerchantService implements BaseService<Merchant, String, List<Merchant>>, BaseResponse {
    @Override
    public String add(Merchant merchant) {
        merchantList.add(merchant);
        return SUCCESS;
    }

    @Override
    public List<Merchant> get() {
        return merchantList;
    }

    @Override
    public List<Merchant> getByID(UUID merchantCategoryId) {
        List<Merchant> list = new ArrayList<>();
        for (Merchant merchant : merchantList) {
            if (merchant.getMerchantCategoryId().equals(merchantCategoryId)) {
                list.add(merchant);
            }
        }
        return list;
    }

    @Override
    public String editById(UUID id, Merchant merchant) {
        return null;
    }

    @Override
    public String deleteById(UUID id) {
        return null;
    }
}
