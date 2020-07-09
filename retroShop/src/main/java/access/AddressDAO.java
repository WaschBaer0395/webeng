package access;

import transferobjects.Address;

import java.util.List;

public interface AddressDAO {
    void add(Address a);
    Address getAddress(long userId);
    void update(Address a);
}
