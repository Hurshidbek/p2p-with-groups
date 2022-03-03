package uz.pdp.service;

import uz.pdp.model.User;
import uz.pdp.model.Wallet;
import uz.pdp.model.response.BaseResponse;
import uz.pdp.repository.UserInterface;

import java.util.List;
import java.util.UUID;

public class UserService extends UserInterface implements BaseResponse {
    @Override
    public String add(User user) {
        if (isExistUser(user.getPhoneNumber()))
            return ERROR_USER_IS_EXIST;
        userList.add(user);
        Wallet wallet = new Wallet();
        wallet.setUserId(user.getId());
        new WalletService().add(wallet);
        return SUCCESS;
    }

    @Override
    public List<User> get() {
        return userList;
    }

    public String showUser(User user){
        String result = "";
        result += "Name: " + user.getName() + "\n";
        result += "Phone Number: " + user.getPhoneNumber() + "\n";
        result += "ID: " + user.getId() + "\n";
        return result;
    }

    public String showUsers(){
        String result = "";
        for (User u: userList) {
            result += "Name: " + u.getName() + "\n";
            result += "PhoneNumber: " + u.getPhoneNumber() + "\n";
            result += "ID: " + u.getId() + "\n";
        }
        if(userList.size() == 0)
            result = "No users found!";
        return result;
    }

    @Override
    public List<User> getByID(UUID id) {
        return null;
    }

    @Override
    public String editById(UUID id, User editUser) {
        int ind = 0;
        for (User user: userList) {
            if (user.getId().equals(id)) {
                user.setPassword(editUser.getPassword());
                user.setName(editUser.getName());
                user.setPhoneNumber(editUser.getPhoneNumber());
                userList.set(ind, user);
                return SUCCESS;
            }
            ind++;
        }
        return ERROR_USER_NOT_FOUND;
    }

    @Override
    public String deleteById(UUID id) {
        int ind = 0;
        for (User user: userList) {
            if (user.getId().equals(id)) {
                user.setActive(false);
                userList.set(ind, user);
                return SUCCESS;
            }
            ind++;
        }
        return ERROR_USER_NOT_FOUND;
    }

    @Override
    public User login(String phoneNumber, String password) {
        for (User user: userList) {
            if (user.getPhoneNumber().equals(phoneNumber) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    private boolean isExistUser(String phoneNumber) {
        for (User user : userList) {
            if (user.getPhoneNumber().equals(phoneNumber))
                return true;
        }
        return false;
    }
}
