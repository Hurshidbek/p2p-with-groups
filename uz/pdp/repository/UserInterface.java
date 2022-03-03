package uz.pdp.repository;

import uz.pdp.model.User;

import java.util.List;

public abstract class UserInterface implements BaseService<User, String, List<User>> {

    public abstract User login(String phoneNumber, String password);


}
