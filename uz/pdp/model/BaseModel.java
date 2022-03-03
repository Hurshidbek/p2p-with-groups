package uz.pdp.model;

import java.util.UUID;

public abstract class BaseModel {
    protected final UUID id;
    protected String name;
    protected String phoneNumber;
    protected boolean isActive = true;

    {
        this.id = UUID.randomUUID();
    }

    public BaseModel() {

    }

    public BaseModel(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    protected abstract boolean checkName();
}
