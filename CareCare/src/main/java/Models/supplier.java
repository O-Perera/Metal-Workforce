package Models;

public class supplier {
      public int supplierID;
      public String name;
      public String address;
      public String email;
      public int phone_number;

    public supplier(int supplierID, String name, String address, String email, int phone_number) {
        this.supplierID = supplierID;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone_number = phone_number;
    }
//to add supplier
    public String toString(){
        return "supplier {" + "SupplierID= "+supplierID+"/"+"SupplierID= "+supplierID+"/"+"Name= "+name+"/"+"Address= "+address+"/"+"Email= "+email+"/"+"Phone Number= "+phone_number+"/";

    }


}
