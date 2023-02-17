package ba.unsa.etf.rpr.domain;
import java.util.Objects;

/**
 *  Show a list of possible categories for medicines
 *
 * @author Semina Muratović
 */
public class Category implements Idable{
    private int id;
    private String name;


    /**
     * Getter for id
     * @return int
     */
    public int getId()
    {
        return id;
    }

    /**
     * Setter for id
     * @param id int
     */
    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return name;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id == category.id;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, name);
    }
}
