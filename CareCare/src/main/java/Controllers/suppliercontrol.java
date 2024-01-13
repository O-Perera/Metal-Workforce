package Controllers;
import Models.supplier;
public class suppliercontrol {
    public supplier addsupplier(int supplierID, String name, String address, String email, int phone_number) {
        supplier supplierobj = new supplier( supplierID, name,  address,  email, phone_number);
        return supplierobj;
        
    }
}
