package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.IntermediateTable;
import ba.unsa.etf.rpr.exceptions.MedicineException;

public class IntermediateManager {
    public IntermediateTable add(IntermediateTable q) throws MedicineException
    {
        return DaoFactory.intermediateDao().add(q);
    }



}
