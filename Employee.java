public class Employee {
    private String employeeId;
    private String employeeName;
    private String employeeStatus; // 0 for sales employee, 1 for management employee
    private String password;
    public static int record=0;
    
    public Employee(String employeeId, String employeeName, String employeeStatus, String password) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeStatus = employeeStatus;
        this.password = password;
        record++;
    }

    // Getter for employeeId
    public String getEmployeeId() {
        return employeeId;
    }

    // Setter for employeeId
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    // Getter for employeeName
    public String getEmployeeName() {
        return employeeName;
    }

    // Setter for employeeName
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    // Getter for employeeStatus
    public String getEmployeeStatus() {
        return employeeStatus;
    }

    // Setter for employeeStatus
    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }
}