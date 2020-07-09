package businesslogic;

import access.AddressDAO;
import access.DAOFactory;
import transferobjects.Address;

public class AddressManager {
    AddressDAO adao = DAOFactory.getAddressDAO();

    public void addAddress(Address a){
        adao.add(a);
    }

    public void updateAddress(Address a){
        adao.update(a);
    }

    public Address getAddress(long userId){
        return adao.getAddress(userId);
    }

}
