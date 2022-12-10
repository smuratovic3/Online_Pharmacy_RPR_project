package ba.unsa.etf.rpr.dao;

import java.util.List;

/**
 * Root interface for all DAO classes
 * @author Semina Muratovic
 */

public interface Dao<T> {


    T getById(int id);


    T add(T item);


    T update(T item);


    void delete(int id);


    List<T> getAll();
}