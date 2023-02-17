package ba.unsa.etf.rpr.domain;

import java.util.Objects;

/**
 * Class that gives me information about medicines
 * @author Semina Muratović
 **/
public class Medicine implements Idable {
    private int id;
    private String name;
    private int price;
    private int quantity;
    private String description;
    private Category category;

    /**
     * Getter for Id
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for id
     * @param id int
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for Name
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for id
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for Price
     * @return int
     */
    public int getPrice() {return price;}

    /**
     * Setter for price
     * @param price int
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Getter for Quantity
     * @return int
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Setter for quantity
     * @param quantity int
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Getter for Description
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter for description
     * @param description string
     */
    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * Getter for Category
     * @return category
     */
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    @Override
    public String toString() {
        return "Medicine - " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", description=" + description +
                ", category=" + category +
                '.';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return id == medicine.id;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, quantity, description,category);
    }



}
