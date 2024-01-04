import java.io.*;
import java.util.*;


public class InputCustomerData {

    public static void InputCustomerData() {
        String file = "/Users/zirui/Desktop/JavaProject/Project/src/cust.csv";
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
        System.out.print("Customer Id: "+"C");
        System.out.printf("%04d",linesRead);
        System.out.println("");
        System.out.print("Customer Name: ");
        String customerName = s.nextLine();
        System.out.print("Customer phone number: ");
        String phoneNumber = s.nextLine();
        System.out.print("Postcode: ");
        String postcode = s.nextLine();
        
        
        String numberAsString = Integer.toString(linesRead);

        
        if (numberAsString.length() < 5) {
            int zerosToAdd = 5 - numberAsString.length();
            String zeros = "0".repeat(zerosToAdd);
            numberAsString = zeros + numberAsString;
        }
        String[] CustId = new String[5];
        for (int i = 0; i < 5; i++) {
            CustId[i] = Character.toString(numberAsString.charAt(i));
        }
        CustId[0]="C";
        String custId = CustId[0]+CustId[1]+CustId[2]+CustId[3]+CustId[4];
        
        saveCustomerToCSV( file,  custId,  customerName,  phoneNumber,  postcode);
                     
    }

    public static void saveCustomerToCSV(String file, String custId, String customerName, String phoneNumber, String postcode) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file, true)); 

        
            String newCustomerData = custId + "," + customerName + "," + phoneNumber + "," + postcode;

        
            writer.write(newCustomerData);
            writer.newLine(); 
            System.out.println("New customer data saved to CSV file successfully!");
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