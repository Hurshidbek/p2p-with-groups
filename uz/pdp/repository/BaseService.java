package uz.pdp.repository;

import uz.pdp.model.Card;
import uz.pdp.model.User;
import uz.pdp.model.Wallet;
import uz.pdp.model.payment.Merchant;
import uz.pdp.model.payment.MerchantCategory;
import uz.pdp.model.payment.MerchantField;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface BaseService<T, R, R1> {

    List<User> userList = new ArrayList<>();
    List<Card> cardList = new ArrayList<>();
    List<Wallet> walletList = new ArrayList<>();

    List<MerchantCategory> merchantCategoryList = new ArrayList<>();
    List<Merchant> merchantList = new ArrayList<Merchant>();
    List<MerchantField> merchantFieldList = new ArrayList<>();

    R add(T t);
    R1 get();
    R1 getByID(UUID id);
    R editById(UUID id, T t);
    R deleteById(UUID id);
}
