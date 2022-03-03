package uz.pdp.model.history;

import java.math.BigDecimal;
import java.util.UUID;

public abstract class BaseHistory {
    protected final UUID id;
    protected UUID userId;

    {
        this.id = UUID.randomUUID();
    }



    public UUID getId() {
        return id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    protected abstract String list();
}
