package uz.pdp.service;

import uz.pdp.model.Card;
import uz.pdp.model.User;
import uz.pdp.model.response.BaseResponse;
import uz.pdp.repository.CardInterface;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.*;

public class CardService extends CardInterface implements BaseResponse {
    @Override
    public String add(Card card) {
        if (this.checkCard(card.getCardNumber()) != null) {
            return ERROR_CARD_IS_USED;
        }
        cardList.add(card);
        return SUCCESS;
    }

    public String addNewCard(User user){
        Card card = new Card();
        System.out.print(BaseResponse.INSERT_NAME);
        card.setName(new Scanner(System.in).nextLine());
        System.out.print(BaseResponse.INSERT_PHONE_NUMBER);
        card.setCardNumber(new Scanner(System.in).nextLine());
        System.out.print(BaseResponse.INSERT_EXPIRY_DATE);
        card.setExpiryDate(new Scanner(System.in).nextLine());
        card.setUserId(user.getId());
        System.out.print(BaseResponse.INSERT_BALANCE);
        card.setBalance(new Scanner(System.in).nextBigDecimal());
        return add(card);
    }

    @Override
    public List<Card> get() {
        return cardList;
    }

    @Override
    public List<Card> getByID(UUID userId) {
        List<Card> myCardList = new ArrayList<>();
        for (Card card : cardList) {
            if (card.getUserId().equals(userId)) {
                myCardList.add(card);
            }
        }
        return myCardList;
    }

    public String showMyCards(User user){
        String result = "";
        List<Card> list = getByID(user.getId());
        for (Card c: list) {
            result += "Name: " + c.getName() + "\n";
            result += "Phone Number: " + c.getPhoneNumber() + "\n";
            result += "Card Number: " + c.getCardNumber() + "\n";
            result += "Expiry Date: " + c.getExpiryDate() + "\n";
            result += "Balence: " + c.getBalance() + "\n\n";
        }
        if(list.size() < 1){
            result = "No cards found!";
        }
        return result;
    }

    @Override
    public String editById(UUID id, Card editCard) {
        int ind = 0;
        for (Card card : cardList) {
            if (card.getId().equals(id)) {
                card.setCardNumber(editCard.getCardNumber());
                card.setName(editCard.getName());
                card.setBalance(editCard.getBalance());
                card.setPhoneNumber(editCard.getPhoneNumber());
                card.setExpiryDate(editCard.getExpiryDate());
                card.setUserId(editCard.getUserId());
                cardList.set(ind, card);
                return SUCCESS;
            }
            ind++;
        }
        return ERROR_UNKNOWN;
    }

    public boolean editCardBalance(Card editCard) {
        int ind = 0;
        for (Card card : cardList) {
            if (card.getId().equals(editCard.getId())) {
                card.setBalance(editCard.getBalance());
                cardList.set(ind, card);
                return true;
            }
            ind++;
        }
        return false;
    }

    @Override
    public String deleteById(UUID id) {
        return null;
    }

    @Override
    protected String p2p(String fromCardNumber, String toCardNumber, double amount, UUID userId) {
        Card fromCard = checkCard(fromCardNumber, userId);
        Card toCard = checkCard(toCardNumber);
        if (fromCard == null || toCard == null) {
            return ERROR_UNKNOWN;
        }
        BigDecimal amountWithCommission = this.getBalanceWithCommission(amount);
        if (fromCard.getBalance().compareTo(amountWithCommission) < 0) {
            return ERROR_CARD_NO_ENOUGH_MONEY;
        }

        fromCard.setBalance(fromCard.getBalance().subtract(amountWithCommission));
        toCard.setBalance(toCard.getBalance().add(BigDecimal.valueOf(amount)));

        boolean ans = true;
        ans = ans && this.editCardBalance(fromCard);
        ans = ans && this.editCardBalance(toCard);
        if (ans) return SUCCESS;
        return ERROR_UNKNOWN;
    }



    private Card checkCard(String cardNumber){
        for (Card card : cardList) {
            if (card.getCardNumber().equals(cardNumber))
                return card;
        }
        return null;
    }

    private Card checkCard(String cardNumber, UUID userId){
        for (Card card : cardList) {
            if (card.getCardNumber().equals(cardNumber) && card.getUserId().equals(userId))
                return card;
        }
        return null;
    }

    private BigDecimal getBalanceWithCommission(double amount) {
        BigDecimal helper = BigDecimal.valueOf(amount);
        return helper.add(helper.multiply(BigDecimal.valueOf(commission / 100)));
    }
}
