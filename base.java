import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class base{

    ArrayList<String> sellerSaleId = new ArrayList<String>();
    ArrayList<String> managerSaleId = new ArrayList<String>();

    //accesor
    public ArrayList<String> getSellerSaleId(){
        getID();
        return this.sellerSaleId;
    }

    public ArrayList<String> getManagerSaleId(){
        getID();
        return this.managerSaleId;
    }


    
    private void getID(){
        String line = "";
        try {
            Scanner in = new Scanner(new FileInputStream("/Users/zirui/Desktop/JavaProject/Project/src/employee.csv"));
            while(in.hasNextLine()){
                line = in.nextLine();
                String[] arr = line.split(",");
                if(arr[2].equals("0")){
                    sellerSaleId.add(arr[0]);
                }else if(arr[2].equals("1")){
                    managerSaleId.add(arr[0]);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
            
    }

    private ArrayList<String> getCarPlate(String saleID){
        ArrayList<String> carPlate = new ArrayList<String>();

        String line = "";
        try {
            Scanner in = new Scanner(new FileInputStream("/Users/zirui/Desktop/JavaProject/Project/src/sales.csv"));
            while(in.hasNextLine()){
                line = in.nextLine();
                String[] arr = line.split(",");
                if(arr[4].equals(saleID)){
                    carPlate.add(arr[2]);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
      

        return carPlate;
    }

    public ArrayList<Double> getSaleRecord(String saleID){
        ArrayList<String> hold = getCarPlate(saleID);
        ArrayList<Double> saleRecord = new ArrayList<Double>();

        for(int i=0; i<hold.size(); i++){
            String line = "";
            try {
                Scanner in = new Scanner(new FileInputStream("/Users/zirui/Desktop/JavaProject/Project/src/vehicle-2.csv"));
                while(in.hasNextLine()){
                    line = in.nextLine();
                    String[] arr = line.split(",");
                    if(arr[0].equalsIgnoreCase(hold.get(i))){
                        double price = Double.parseDouble(arr[4]);
                        saleRecord.add(price);
                    }
                }
                
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
        }
        

        return saleRecord;
       
    }

    public int checkStatus(String id){
        getID();
        int num = -1;
        for(String i : sellerSaleId){
            if(i.equalsIgnoreCase(id)){
                num = 0;
            }
        }
        for(String j : managerSaleId){
            if(j.equalsIgnoreCase(id)){
                num = 1;
            }
        }

        return num;
    }

    public double getTotalSalary(){
        seller s = new seller();
        manager m = new manager();

        double total = 0;

        for(String i : sellerSaleId){
            total += s.getSalary(i);
        }

        for(String j : managerSaleId){
            total += m.getSalary(j);
        }

        return total;
    }

    

    
     
}