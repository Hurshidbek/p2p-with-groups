package uz.pdp.repository;

import uz.pdp.model.Card;

import java.util.List;
import java.util.UUID;

public abstract class CardInterface implements BaseService<Card, String, List<Card>> {

    public static float commission = 1;
    public static float cashback = 0.5f;

    protected abstract String p2p(String fromCardNumber, String toCardNumber, double amount, UUID userId);
}
