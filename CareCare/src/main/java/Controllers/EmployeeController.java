package Controllers;

import Models.ManageEmployee;

import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;

public class EmployeeController {


    public ManageEmployee employeeAdd(int employeeID, String name, String address, String email,  String position){
        ManageEmployee addObj =new ManageEmployee(employeeID,name,address,email,position);
            addObj.setEmployeeID(employeeID);
            addObj.setName(name);
            addObj.setEmail(email);
            addObj.setAddress(address);
            return addObj;
        }

    public ManageEmployee employeeupdate(int employeeID, String name, String address, String email,  String position){
        ManageEmployee updateObj =new ManageEmployee(employeeID,name,address,email,position);
        updateObj.setEmployeeID(employeeID);
        updateObj.setName(name);
        updateObj.setEmail(email);
        updateObj.setAddress(address);
        return updateObj;
    }

        public ManageEmployee employeeDelete(int employeeID){
            ManageEmployee deleteObj = new ManageEmployee();
            deleteObj.setEmployeeID(employeeID);
            return deleteObj;
        }



    }


