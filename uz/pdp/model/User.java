package uz.pdp.model;

public class User extends BaseModel{

    private String password;

    public User() {

    }

    public User(String name, String phoneNumber, String password) {
        super(name, phoneNumber);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    protected boolean checkName() {
        return super.getName() != null;
    }
}
