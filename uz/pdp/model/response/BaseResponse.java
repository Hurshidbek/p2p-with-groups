package uz.pdp.model.response;

public interface BaseResponse {
    String SUCCESS = "completed successfully";
    String INSERT_NAME = "Name: ";
    String INSERT_PHONE_NUMBER = "Phone number: ";
    String INSERT_PASSWORD = "Password: ";
    String INSERT_ID = "ID: ";
    String INSERT_CARD_NUMBER = "Card number: ";
    String INSERT_EXPIRY_DATE = "Expiry date: ";
    String INSERT_BALANCE = "Initial balance: ";

    String CHANGE_BALANCE = "Current balance: ";

    String INNER_MENU = "0 -> Back\n1 -> My Account\n2 -> My Cards\n3 -> Transfer\n4 -> Payments";
    String INNER_FIRST_MENU = "0 -> Back\n1 -> Edit my account";
    String CARDS_MENU = "0 -> Back\n1 -> Show my cards\n2 -> Add new card\n3 -> Fill my card\n4 -> Delete card\n5 -> Edit card\n6 -> Transfer";


    String MAIN_MENU = "1 -> Sign up\n2 -> Sign in!\n3 -> Show Users\n4 -> Delete User";

    String ERROR_USER_NOT_FOUND = "user not found";
    String ERROR_UNKNOWN = "unknown error";
    String ERROR_USER_IS_EXIST = "user already exist";
    String ERROR_PASSWORD_OR_USERNAME_INCORRECT = "incorrect username or password";

    String ERROR_CARD_IS_USED = "card is not available";
    String ERROR_CARD_NO_ENOUGH_MONEY = "money is not enough";
}
