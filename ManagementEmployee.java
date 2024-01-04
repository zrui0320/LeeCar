public class ManagementEmployee extends Employee {
    public ManagementEmployee(String employeeId, String employeeName, String employeeStatus, String password) {
        // Initialize attributes using the constructor of the parent class
        super(employeeId, employeeName, employeeStatus, password);
    }

    public void viewAllCustomerData() {
        ViewInfo.displayAllCustomerData();
    }

    public void viewAllSalesRecords() {
        ViewInfo.displayAllSalesRecords();
    }

    public void viewAllVehicleData() {
        ViewInfo.displayAllVehicleData();
    }

    public void viewAllEmployeeData() {
        ViewInfo.displayAllEmployeeData();
    }
}