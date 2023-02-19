package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.domain.*;

public class Model {
    /**
     * A private static instance of the Model class.
     */
    private static Model instance;
    /**
     * The current medicine data.
     */
    private Medicine medicine;
    /**
     * The current user data.
     */
    private User user;
    /**
     * The current order data.
     */
    private OnlineOrder onlineOrder;
    private Category category;


    private IntermediateTable intermediateTable;

    /**
     * A private constructor for the Model class.
     */
    private Model() {}

    /**
     * A public static method for getting the instance of the Model class.
     * @return the instance of the Model class
     */
    public static Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }

    /**
     * A getter method for the current medicine data.
     * @return the current medicine data
     */
    public Medicine getMedicine() {
        return medicine;
    }

    /**
     * A setter method for the current medicine data.
     * @param medicine the medicine data to set
     */
    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    /**
     * A getter method for the current user data.
     * @return the current user data
     */
    public User getUser() {
        return user;
    }

    /**
     * A setter method for the current user data.
     * @param user the user data to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * A getter method for the current order data.
     * @return the current order data
     */
    public OnlineOrder getOnlineOrder() {
        return onlineOrder;
    }

    /**
     * A setter method for the current order data.
     * @param onlineOrder the order data to set
     */
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