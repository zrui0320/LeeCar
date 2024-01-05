import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Company {
    private String username;
    ProfitMargin profitMargin = new ProfitMargin();
    public static Customer [] c;
    public static Employee [] e;
    public static Sales [] s;
    public static Vehicle []v;  

    public Company() {
    }
    
    public boolean validateSecretKey(String enteredKey) {
        String secretKey = "leeCars";
        return secretKey.equals(enteredKey);
    }
    
    public static String employeeIDGenerator() {
        int i = 0;
        String line = "", ID = "";
        String[] num = null;
        String[] id = new String[4];
        int cnt = id.length - 1;
        
        try {
            BufferedReader inputStream = new BufferedReader(new FileReader("/Users/zirui/Desktop/JavaProject/Project/src/employee.csv"));
            while ((line = inputStream.readLine()) != null){
                i++;
            }
            num = String.valueOf(i).split("");
            
            // To put last digit of num to last digit of id
            for (int j = num.length - 1; j >= 0; j--, cnt--) {
                id[cnt] = num[j];
            }
            
            //assign null array with zero
            for (int j = 0; j < id.length; j++) {
                if (id[j] == null) {
                    id[j] = "0";
                }
            }
            
            for (String j: id) {
                ID += j;
            }
            inputStream.close();
        }catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return "E" + ID;
    }
    
    public void registerEmployee(String name, String username, String password) {
        try {
            PrintWriter outputStream = new PrintWriter(new FileOutputStream("/Users/zirui/Desktop/JavaProject/Project/src/employee.csv", true));
            outputStream.printf("%s,%s,%s,%s\n", username, name, "0", password);
            outputStream.close();
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
        System.out.println("\nEmployee " + name + " registered successfully");
    }

    public void login(String username, String password) {
        this.username=username;
        String line = "";
        String[] row = null;
        try {
            BufferedReader inputStream = new BufferedReader(new FileReader("/Users/zirui/Desktop/JavaProject/Project/src/employee.csv"));
            while ((line = inputStream.readLine()) != null){
                row = line.split(",");
                if (row[0].equals(username) && row[3].equals(password)) {
                    System.out.printf("\nWelcome, %s!!!\nAccess Level: %s\n", row[1], row[2].equals("0") ? "Sales" : "Management");
                    inputStream.close();
                    if (row[2].equals("0")) {
                        performLoggedInActions0();
                    }
                    else {
                        performLoggedInActions1();
                    }
                    return;
                }
            }
            System.out.println("Invalid username or password. Please try again");
            inputStream.close();
        }catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
    private void performLoggedInActions0() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nLogged In Actions:");
            System.out.println("1. View All Vehicle Data\n"+
                                "2. View Sales Record\n"+
                                "3. View Customer Data\n"+
                                "4. Enter Customer Data\n"+
                                "5. Enter Sales Data\n"+
                                "6. Enter Vehicle Data\n"+
                                "7. Search By Keyword\n"+
                                "8. Log Out\n"
                                );
            System.out.print("Enter your choice: ");
            String choice = scanner.next();

            switch (choice) {
                case "1":
                    System.out.println("\nPerforming action...");
                    ViewInfo.displayAllVehicleData();
                    break;
                case "2":
                    System.out.println("\nPerforming action...");
                    ViewInfo.displayOwnSalesRecords(username);
                    break;
                case "3":
                    System.out.println("\nPerforming action...");
                    ViewInfo.displayOwnCustomerData(username);
                    break;

                case "4":
                    System.out.println("\nPerforming action...");
                    InputCustomerData.InputCustomerData();
                    break;

                case "5":
                    System.out.println("\nPerforming action...");
                    InputSalesData.InputSalesData();
                    break;

                case "6":
                    System.out.println("\nPerforming action...");
                    InputVehicleData.InputVehicleData();
                    break;
                
                case "7":
                    System.out.println("\nPerforming action...");
                    Filter f=new Filter();
                    f.filterForSalesLevel(username);
                    break;
                
                case "8":
                    System.out.println("Logging out.");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    private void performLoggedInActions1() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String[] selection = {"0","0","0","0"};
            System.out.println("\nLogged In Actions:");
            System.out.println("1. Profit Margin\n"+
                                "2. Import Data\n"+
                                "3. Add Management Level Employee\n"+
                                "4. View Customer Data\n"+
                                "5. View Employee Data\n"+
                                "6. View Vehicle Data\n"+
                                "7. View Sales Record\n"+
                                "8. Enter Customer Data\n"+
                                "9. Enter Sales Data\n"+
                                "10. Enter Vehicle Data\n"+
                                "11. Search By Keyword\n"+
                                "12. Get Salary\n"+
                                "13. Log Out\n"
                                );
            System.out.print("Enter your choice: ");
            String choice = scanner.next();

            switch (choice) {
                case "1":
                    System.out.println("\nPerforming action...");
                    System.out.print("Year of profit margin: ");
                    String year = scanner.next();
                    profitMargin.calculator(year);
                    break;

                case "2":
                    System.out.println("\nPerforming action...");
                    System.out.println("\nEnter 1 for importing data [customer/employee/sales/vehicle],four rounds required : ");
                    for(int i=0;i<4;i++)
                        selection[i]=scanner.next();
                    c=ImportData.importCustomer(selection[0]);
                    e=ImportData.importEmployee(selection[1],1);
                    s=ImportData.importSales(selection[2]);
                    v=ImportData.importVehicle(selection[3]);
                    System.out.println("Import done.");
                    break;

                case "3":
                    System.out.println("\nPerforming action...");
                    if(!selection[1].equals("1")){
                    e=ImportData.importEmployee("1",0);
                    }
                    ImportData.addManagement();
                    // scanner.close();
                    break;

                case "4":
                    System.out.println("\nPerforming action...");
                    ViewInfo.displayAllCustomerData();
                    break;

                case "5":
                    System.out.println("\nPerforming action...");
                    ViewInfo.displayAllEmployeeData();
                    break;

                case "6":
                    System.out.println("\nPerforming action...");
                    ViewInfo.displayAllVehicleData();
                    break;

                case "7":
                    System.out.println("\nPerforming action...");
                    ViewInfo.displayAllSalesRecords();
                    break;
               
                case "8":
                    System.out.println("\nPerforming action...");
                    InputCustomerData.InputCustomerData();
                    break;

                case "9":
                    System.out.println("\nPerforming action...");
                    InputSalesData.InputSalesData();
                    break;

                case "10":
                    System.out.println("\nPerforming action...");
                    InputVehicleData.InputVehicleData();
                    break;

                case "11":
                    System.out.println("\nPerforming action...");
                    Filter f=new Filter();
                    f.filterForManagementLevel();
                    break;

                case "12":
                    MainSystem m = new MainSystem();
                    m.getCalculation();
                    break;
                
                case "13":
                    System.out.println("Logging Out...");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
