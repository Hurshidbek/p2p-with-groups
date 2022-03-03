package uz.pdp.repository;

import uz.pdp.model.Wallet;

import java.util.List;

public abstract class WalletInterface implements BaseService<Wallet, String, List<Wallet>> {

    protected abstract String fillBalance();
}
