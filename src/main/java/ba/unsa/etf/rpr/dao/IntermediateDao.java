package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.IntermediateTable;
import ba.unsa.etf.rpr.domain.Medicine;
import ba.unsa.etf.rpr.exceptions.MedicineException;

import java.util.List;

public interface IntermediateDao extends Dao<IntermediateTable> {
    List<IntermediateTable> getByUser(int idUser) throws MedicineException;

}