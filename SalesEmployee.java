public class SalesEmployee extends Employee {
    public SalesEmployee(String employeeId, String employeeName, String employeeStatus, String password) {
        // Initialize attributes using the constructor of the parent class
        super(employeeId, employeeName, employeeStatus, password);
    }

    public void viewOwnCustomerData() {
        ViewInfo.displayOwnCustomerData(getEmployeeId());
    }

    public void viewOwnSalesRecords() {
        ViewInfo.displayOwnSalesRecords(getEmployeeId());
    }

    public void viewAllVehicleData() {
        ViewInfo.displayAllVehicleData();
    }
}