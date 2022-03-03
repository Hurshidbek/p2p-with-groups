package uz.pdp.service;

import uz.pdp.model.Wallet;
import uz.pdp.model.response.BaseResponse;
import uz.pdp.repository.WalletInterface;

import java.util.List;
import java.util.UUID;

public class WalletService extends WalletInterface implements BaseResponse {
    @Override
    public String add(Wallet wallet) {
        walletList.add(wallet);
        return SUCCESS;
    }

    @Override
    public List<Wallet> get() {
        return null;
    }

    @Override
    public List<Wallet> getByID(UUID id) {
        return null;
    }

    @Override
    public String editById(UUID id, Wallet wallet) {
        return null;
    }

    @Override
    public String deleteById(UUID id) {
        return null;
    }

    @Override
    protected String fillBalance() {
        return null;
    }
}
