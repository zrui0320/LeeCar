import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class ViewInfo {
    private static final String SALES_FILE = "/Users/zirui/Desktop/JavaProject/Project/src/sales.csv";
    private static final String CUSTOMER_FILE = "/Users/zirui/Desktop/JavaProject/Project/src/cust.csv";
    private static final String EMPLOYEE_FILE = "/Users/zirui/Desktop/JavaProject/Project/src/employee.csv";
    private static final String VEHICLE_FILE = "/Users/zirui/Desktop/JavaProject/Project/src/vehicle-2.csv";
    
    private static void printHeader(String file) {
        try (BufferedReader Reader = new BufferedReader(new FileReader(file))) {
            String headerLine;
            if ((headerLine = Reader.readLine()) != null) {
                // Print the header line
                String[] headerData = headerLine.split(",");
                for (int i = 0; i < headerData.length; i++) {
                    // Set the width of the second column to be larger
                    int columnWidth = (i == 1) ? 30 : 15; // Adjust the widths as needed
                    System.out.printf("%-" + columnWidth + "s", headerData[i]);
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void displayOwnCustomerData(String employeeId) {
    boolean printedHeader = false;
    Set<String> processedCustomerIds = new HashSet<>(); // To keep track of processed customer IDs

    try (BufferedReader br = new BufferedReader(new FileReader(SALES_FILE))) {
        String line;

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            String salesEmployeeId = data[4];

            // Check if the customer data belongs to the specified sales employee
            if (salesEmployeeId.equals(employeeId)) {
                String custId = data[3]; // Get the customer ID from the sales record

                // Check if the customer ID has already been processed
                if (!processedCustomerIds.contains(custId)) {
                    if (!printedHeader) {
                        printHeader(CUSTOMER_FILE);
                        printedHeader = true; // Set the flag to indicate header has been printed
                    }

                    // Now, retrieve and display the customer data based on custId
                    displayCustomerDataByCustomerId(custId);

                    // Add the customer ID to the set of processed customer IDs
                    processedCustomerIds.add(custId);
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
     }        
    }

    
    public static void displayOwnSalesRecords(String employeeId) {
        boolean printedHeader = false;
        try (BufferedReader br = new BufferedReader(new FileReader(SALES_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String salesEmployeeId = data[4];
                

                // Check if the sales record belongs to the sales employee
                if (salesEmployeeId.equals(employeeId)) {
                    if (!printedHeader) {
                    printHeader(SALES_FILE);
                    printedHeader = true; // Set the flag to indicate header has been printed
                }
                    
                    // Display the sales record in tabular form
                    for (int i = 0; i < data.length; i++) {
                        // Set the width of the second column to be larger
                        int columnWidth = (i == 1) ? 30 : 15; // Adjust the widths as needed
                        System.out.printf("%-" + columnWidth + "s", data[i]);
                    }
                    System.out.println();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void displayAllVehicleData() {
        displayTable(VEHICLE_FILE);
    }

    public static void displayAllCustomerData() {
        displayTable(CUSTOMER_FILE);
    }

    public static void displayAllSalesRecords() {
        displayTable(SALES_FILE);
    }

    public static void displayAllEmployeeData() {
        displayTable(EMPLOYEE_FILE);
    }

    private static void displayTable(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split and display data in tabular form
                String[] data = line.split(",");
                for (int i = 0; i < data.length; i++) {
                    // Set the width of the second column to be larger
                    int columnWidth = (i == 1) ? 30 : 15; // Adjust the widths as needed
                    System.out.printf("%-" + columnWidth + "s", data[i]);
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
