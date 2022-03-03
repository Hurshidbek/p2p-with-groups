package uz.pdp.model.payment;

import java.util.UUID;

public abstract class BasePaymentModel {
    protected final UUID id;
    protected String name;

    {
        this.id = UUID.randomUUID();
    }

    public BasePaymentModel(String name) {
        this.name = name;
    }

    public BasePaymentModel() {

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
}
