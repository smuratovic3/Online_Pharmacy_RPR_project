package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.domain.*;

public class Model {
    private static Model instance;
    private Medicine medicine;
    private User user;
    private OnlineOrder onlineOrder;
    private Category category;
    private IntermediateTable intermediateTable;

    private Model() {}

    public static Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OnlineOrder getOnlineOrder() {
        return onlineOrder;
    }

    public void setOnlineOrder(OnlineOrder onlineOrder) {
        this.onlineOrder = onlineOrder;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }
    public IntermediateTable getIntermediateTable() {
        return intermediateTable;
    }

    public void setIntermediateTable(IntermediateTable intermediateTable) {
        this.intermediateTable = intermediateTable;
    }

}