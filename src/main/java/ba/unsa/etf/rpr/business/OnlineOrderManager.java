package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Medicine;
import ba.unsa.etf.rpr.domain.OnlineOrder;
import ba.unsa.etf.rpr.exceptions.MedicineException;

import java.util.List;

public class OnlineOrderManager {

    public OnlineOrder add(OnlineOrder q) throws MedicineException
    {
        return DaoFactory.onlineOrderDao().add(q);
    }

    public List<OnlineOrder> getAll() throws MedicineException
    {
        return DaoFactory.onlineOrderDao().getAll();
    }

}
