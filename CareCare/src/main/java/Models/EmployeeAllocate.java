package Models;

public class EmployeeAllocate {
    private String name;
    private String email;
    private String employee;
    private String job;

    // Constructors

    // Constructor for cases with name and email
    public EmployeeAllocate(String name, String email, String employee, String job) {
        this.name = name;
        this.email = email;
        this.employee = employee;
        this.job = job;
    }

    // Constructor for cases without name and email
    public EmployeeAllocate(String employee, String job) {
        this.employee = employee;
        this.job = job;
    }

    // Getter and Setter methods for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter methods for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and Setter methods for employee
    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    // Getter and Setter methods for job
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    // Additional methods or logic can be added based on your requirements
}
