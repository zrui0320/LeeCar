
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class ProfitMargin {
    
    public static ArrayList carSold(String year){
        String line;
        String[] row = null, date = null;
        ArrayList<String> carPlate = new ArrayList<>();
        
        try {
        BufferedReader inputStream = new BufferedReader(new FileReader("/Users/zirui/Desktop/JavaProject/Project/src/sales.csv"));
            while((line = inputStream.readLine()) != null) {
                row = line.split(",");
                date = row[1].split("-");
                if (year.equals(date[0])) {
                    carPlate.add(row[2]);
                }
            }
            inputStream.close();
        }catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return carPlate;
    }
    
    public int revenue(String year) {
        int revenue = 0;
        String line;
        String[] row = null;
        ArrayList<String> carPlate = carSold(year);
        try {
            BufferedReader inputStream = new BufferedReader(new FileReader("/Users/zirui/Desktop/JavaProject/Project/src/vehicle-2.csv"));
            while ((line = inputStream.readLine()) != null) {
                row = line.split(",");
                if (carPlate.contains(row[0])) {
                    revenue += Integer.valueOf(row[4]);
                }
            }
        }catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return revenue;
    }
    
    public int modal(String year) {
        int modal = 0;
        String line;
        String[] row = null;
        ArrayList<String> carPlate = carSold(year);
        
        try {
            BufferedReader inputStream = new BufferedReader(new FileReader("/Users/zirui/Desktop/JavaProject/Project/src/vehicle-2.csv"));
            while ((line = inputStream.readLine()) != null) {
                row = line.split(",");
                if (carPlate.contains(row[0])) {
                    modal += Integer.valueOf(row[2]);
                }
            }
        }catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return modal;
    }
    
    //left operational expenditure for salary of employee
    public void calculator(String year) {
        seller s = new seller();
            
        double netProfit;
        double percentage;
        int otherExpanses = 43887;
        
        if (modal(year) == 0) {
            netProfit = 0;
            percentage = 0;
        }
        else {
            netProfit = (double)(revenue(year) - modal(year) - otherExpanses-s.getTotalSalary());
            percentage = (netProfit / revenue(year)) * (double)100;
        }
        
        System.out.println("______________________________");
        System.out.printf("|      Year     | %10s |\n", year);
        System.out.println("______________________________");
        System.out.printf("|    Revenue    | %10d |\n", revenue(year));
        System.out.println("______________________________");
        System.out.printf("|     Modal     | %10d |\n", modal(year));
        System.out.println("______________________________");
        System.out.printf("|  Net Profit   | %10d |\n", (int)netProfit);
        System.out.println("______________________________");
        System.out.printf("| Profit Margin | %9.2f%% |\n", percentage);
        System.out.println("______________________________");
    }
}