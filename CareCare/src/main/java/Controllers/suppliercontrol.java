package Controllers;
import Models.supplier;
import Views.SupplierView.supplierview;
import java.util.ArrayList;
public class suppliercontrol {
    public supplier addsupplier(int supplierID, String name, String address, String email, int phone_number)
    {
        supplier supplierobj = new supplier( supplierID, name,  address,  email, phone_number);
        return supplierobj;
        
    }
    public supplier updateSupplier(int supplierID, String newName, String newAddress,  String newEmail,int newPhoneNumber){
        supplier supplierobjU = new supplier( supplierID, newName,  newAddress,  newEmail, newPhoneNumber);
        for (supplier i : supplierList ) {
            if (i.getSupplierID() == supplierID) {
                i.setName(newName);
                i.setAddress(newAddress);
                i.setEmail(newEmail);
                i.setPhone_number(newPhoneNumber);
                return i;
            }
        }

    }

}
