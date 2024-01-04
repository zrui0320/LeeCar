import java.io.*;
import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


// import static sales.InputCustomerData.saveCustomerToCSV;
public class InputSalesData {

    public static void InputSalesData() {
        String file = "/Users/zirui/Desktop/JavaProject/Project/src/sales.csv";
        BufferedReader reader = null;
        String line = "";
        int linesRead = 0000;
        Scanner s = new Scanner(System.in);
        try{
            reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null){
                String [] row = line.split(",");
                linesRead++;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
            reader.close(); 
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        String n = Integer.toString(linesRead);

        
        if (n.length() < 5) {
            int zerosToAdd = 5 - n.length();
            String zeros = "0".repeat(zerosToAdd);
            n = zeros + n;
        }
        String[] SalesId = new String[5];
        for (int i = 0; i < 5; i++) {
            SalesId[i] = Character.toString(n.charAt(i));
        }
        SalesId[0]="A";
        String salesId = SalesId[0]+SalesId[1]+SalesId[2]+SalesId[3]+SalesId[4];
        
        String date = getdate();
        String time = getTime();
        String dateTime = date + "T" + time + "Z";
        
        System.out.println("Sales ID: "+salesId);
        System.out.println("Date/Time: "+dateTime);
        System.out.print("Enter Car Plate: ");   
        String carPlate = s.nextLine();
        System.out.print("Enter Customer ID: ");
        String custId = s.nextLine();
        System.out.print("Enter Employee ID: ");
        String employeeId = s.nextLine();
        
        saveSalesToCSV( file,  salesId,  dateTime,  carPlate,  custId, employeeId);

        
    }

    public static String getdate() {
        LocalDate date = LocalDate.now();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return date.format(dateFormatter);
    }
    
    public static String getTime(){
       LocalTime time = LocalTime.now();
        
       DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
       
       return time.format(timeFormatter);
    }
    
    public static void saveSalesToCSV(String file, String salesId, String dateTime, String carPlate, String custId, String employeeId) {
    BufferedWriter writer = null;
    try {
        writer = new BufferedWriter(new FileWriter(file, true)); 

        
        String newCustomerData = salesId + "," + dateTime + "," + carPlate + "," + custId + "," + employeeId;

        
        writer.write(newCustomerData);
        writer.newLine(); 
        System.out.println("New sales data saved to CSV file successfully!");
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
    
}