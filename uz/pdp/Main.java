package uz.pdp;

import uz.pdp.model.User;
import uz.pdp.model.response.BaseResponse;
import uz.pdp.service.CardService;
import uz.pdp.service.UserService;

import java.net.ResponseCache;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        UserService userService = new UserService();
        CardService cardService = new CardService();
        looop : while(true){
            System.out.println(BaseResponse.MAIN_MENU);
            int answer = new Scanner(System.in).nextInt();
            switch (answer){
                case 0:{
                    break looop;
                }
                case 1:{
                    System.out.print(BaseResponse.INSERT_NAME);
                    User user = new User();
                    user.setName(new Scanner(System.in).nextLine());
                    System.out.print(BaseResponse.INSERT_PHONE_NUMBER);
                    user.setPhoneNumber(new Scanner(System.in).nextLine());
                    System.out.print(BaseResponse.INSERT_PASSWORD);
                    user.setPassword(new Scanner(System.in).nextLine());
                    System.out.println(userService.add(user));
                    break;
                }
                case 2:{
                    System.out.print(BaseResponse.INSERT_PHONE_NUMBER);
                    String phoneNumber = new Scanner(System.in).nextLine();
                    System.out.print(BaseResponse.INSERT_PASSWORD);
                    String pass = new Scanner(System.in).nextLine();
                    User user = userService.login(phoneNumber, pass);
                    if(user == null){
                        System.out.println(BaseResponse.ERROR_USER_NOT_FOUND);
                    }else {
                        loop:
                        while (true) {
                            System.out.println(BaseResponse.INNER_MENU);
                            int res = new Scanner(System.in).nextInt();
                            switch (res) {
                                case 0: {
                                    break loop;
                                }
                                case 1: {
                                    loop1:
                                    while (true) {
                                        System.out.println(userService.showUser(user));
                                        System.out.println(BaseResponse.INNER_FIRST_MENU);
                                        int response = new Scanner(System.in).nextInt();
                                        if (response == 0) {
                                            break loop1;
                                        } else if (response == 1) {
                                            System.out.print(BaseResponse.INSERT_ID);
                                            UUID id = UUID.fromString(new Scanner(System.in).nextLine());
                                            System.out.print(BaseResponse.INSERT_NAME);
                                            user.setName(new Scanner(System.in).nextLine());
                                            System.out.print(BaseResponse.INSERT_PASSWORD);
                                            user.setPassword(new Scanner(System.in).nextLine());
                                            System.out.print(BaseResponse.INSERT_PHONE_NUMBER);
                                            user.setPhoneNumber(new Scanner(System.in).nextLine());
                                            System.out.println(userService.editById(id, user));
                                            break;
                                        }
                                    }
                                    break;
                                }
                                case 2: {
                                    cardLoop:
                                    while (true) {
                                        System.out.println(BaseResponse.CARDS_MENU);
                                        int cardAns = new Scanner(System.in).nextInt();
                                        switch (cardAns) {
                                            case 0: {
                                                break cardLoop;
                                            }
                                            case 1: {
                                                System.out.println(cardService.showMyCards(user));
                                                break;
                                            }
                                            case 2: {
                                                System.out.println(cardService.addNewCard(user));
                                                break;
                                            }
                                            case 3: {
                                                System.out.print(BaseResponse.CHANGE_BALANCE);
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                }
                case 3:{
                    System.out.println(userService.showUsers());
                    break;
                }
                case 4:{
                    System.out.print(BaseResponse.INSERT_ID);
                    UUID id = UUID.fromString(new Scanner(System.in).nextLine());
                    System.out.println(userService.deleteById(id));
                    break;
                }
            }
        }
    }
}
