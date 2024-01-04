
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Filter {
    public void filterEmployee(String search){
        try{
            Scanner sc=new Scanner(new FileInputStream("/Users/zirui/Desktop/JavaProject/Project/src/employee.csv"));
            while(sc.hasNextLine()){
                String [] emp=sc.nextLine().split(",");
                if(emp[0].equals(search)||emp[1].equals(search)||emp[2].equals(search)||emp[3].equals(search))
                    System.out.printf("\n%-20s%-20s%20s%20s",emp[0],emp[1],emp[2],emp[3]);
            }
            sc.close();          
        }
        catch(FileNotFoundException e){
            System.out.printf("ERROR - A %s occurred:\n%s\n",e.getClass().toString(),e.getMessage());
        }    
    }
    public void filterSales(String search){
        try{
            Scanner sc=new Scanner(new FileInputStream("/Users/zirui/Desktop/JavaProject/Project/src/sales.csv"));
            while(sc.hasNextLine()){
                String [] sales=sc.nextLine().split(",");
                if(sales[0].equals(search)||sales[1].equals(search)||sales[2].equals(search)||sales[3].equals(search)||sales[4].equals(search))
                    System.out.printf("\n%-20s%-30s%-20s%-20s%-20s",sales[0],sales[1],sales[2],sales[3],sales[4]);
            }
            sc.close();          
        }
        catch(FileNotFoundException e){
            System.out.printf("ERROR - A %s occurred:\n%s\n",e.getClass().toString(),e.getMessage());
        }    
    }
    public void filterSalesWithEId(String eid,String search){
        try{
            Scanner sc=new Scanner(new FileInputStream("/Users/zirui/Desktop/JavaProject/Project/src/sales.csv"));
            while(sc.hasNextLine()){
                String [] sales=sc.nextLine().split(",");
                if(sales[4].equals(eid)&&(sales[0].equals(search)||sales[1].equals(search)||sales[2].equals(search)||sales[3].equals(search)||sales[4].equals(search)))
                    System.out.printf("\n%-20s%-30s%-20s%-20s%-20s",sales[0],sales[1],sales[2],sales[3],sales[4]);
            }
            sc.close();          
        }
        catch(FileNotFoundException e){
            System.out.printf("ERROR - A %s occurred:\n%s\n",e.getClass().toString(),e.getMessage());
        }    
    }
    public void filterSalesForDateTime(String search,String search2){
        try{
            Scanner sc=new Scanner(new FileInputStream("/Users/zirui/Desktop/JavaProject/Project/src/sales.csv"));
            while(sc.hasNextLine()){
                String [] sales=sc.nextLine().split(",");
                if((sales[1].compareTo(search)>=0&&sales[1].compareTo(search2)<=0))
                    System.out.printf("\n%-20s%-30s%-20s%-20s%-20s",sales[0],sales[1],sales[2],sales[3],sales[4]);
            }
            sc.close();          
        }
        catch(FileNotFoundException e){
            System.out.printf("ERROR - A %s occurred:\n%s\n",e.getClass().toString(),e.getMessage());
        }     
    }
    public void filterSalesForDateTimeWithEId(String eid,String search,String search2){
        try{
            Scanner sc=new Scanner(new FileInputStream("/Users/zirui/Desktop/JavaProject/Project/src/sales.csv"));
            while(sc.hasNextLine()){
                String [] sales=sc.nextLine().split(",");
                if(sales[4].equals(eid)&&(sales[1].compareTo(search)>=0&&sales[1].compareTo(search2)<=0))
                    System.out.printf("\n%-20s%-30s%-20s%-20s%-20s",sales[0],sales[1],sales[2],sales[3],sales[4]);
            }
            sc.close();          
        }
        catch(FileNotFoundException e){
            System.out.printf("ERROR - A %s occurred:\n%s\n",e.getClass().toString(),e.getMessage());
        }     
    }
    public void filterVehicle(String search){
        try{
            Scanner sc=new Scanner(new FileInputStream("/Users/zirui/Desktop/JavaProject/Project/src/CSV_File/vehicle-2.csv"));
            while(sc.hasNextLine()){
                String [] vechi=sc.nextLine().split(",");
                String []vech=new String[5];
                if(vechi[3].equals("1")){
                    vech[0]=vechi[0];
                    vech[1]=vechi[1];
                    vech[2]=vechi[2];
                    vech[3]=vechi[3];
                    vech[4]="";
                }
                else{
                    vech[0]=vechi[0];
                    vech[1]=vechi[1];
                    vech[2]=vechi[2];
                    vech[3]=vechi[3];
                    vech[4]=vechi[4];
                }
                if(vech[0].equals(search)||vech[1].equals(search)||vech[2].equals(search)||vech[3].equals(search)||vech[4].equals(search))
                    System.out.printf("\n%-20s%-20s%-20s%5s%20s",vech[0],vech[1],vech[2],vech[3],vech[4]);
            }
            sc.close();          
        }
        catch(FileNotFoundException e){
            System.out.printf("ERROR - A %s occurred:\n%s\n",e.getClass().toString(),e.getMessage());
        }    
    }
    public void filterVehicleForLarger(String search,String search2){
        try{
            Scanner sc=new Scanner(new FileInputStream("/Users/zirui/Desktop/JavaProject/Project/src/vehicle-2.csv"));
            String [] vechi=sc.nextLine().split(",");
            while(sc.hasNextLine()){
                vechi=sc.nextLine().split(",");
                String []vech=new String[5];
                if(vechi[3].equals("1")){
                    vech[0]=vechi[0];
                    vech[1]=vechi[1];
                    vech[2]=vechi[2];
                    vech[3]=vechi[3];
                    vech[4]="0";
                }
                else{
                    vech[0]=vechi[0];
                    vech[1]=vechi[1];
                    vech[2]=vechi[2];
                    vech[3]=vechi[3];
                    vech[4]=vechi[4];
                }
                if((Integer.parseInt(vech[2])>=Integer.parseInt(search)&&Integer.parseInt(vech[2])<=Integer.parseInt(search2))||
                (Integer.parseInt(vech[4])>=Integer.parseInt(search)&&Integer.parseInt(vech[4])<=Integer.parseInt(search2)))
                    System.out.printf("\n%-20s%-20s%-20s%5s%20s",vech[0],vech[1],vech[2],vech[3],vech[4]);
            }
            sc.close();          
        }
        catch(FileNotFoundException e){
            System.out.printf("ERROR - A %s occurred:\n%s\n",e.getClass().toString(),e.getMessage());
        }    
    }
    public void filterVehicleForLess(String search,String search2){
        try{
            Scanner sc=new Scanner(new FileInputStream("/Users/zirui/Desktop/JavaProject/Project/src/vehicle-2.csv"));
            String [] vechi=sc.nextLine().split(",");
            while(sc.hasNextLine()){
                vechi=sc.nextLine().split(",");
                String []vech=new String[5];
                if(vechi[3].equals("1")){
                    vech[0]=vechi[0];
                    vech[1]=vechi[1];
                    vech[2]=vechi[2];
                    vech[3]=vechi[3];
                    vech[4]="0";
                }
                else{
                    vech[0]=vechi[0];
                    vech[1]=vechi[1];
                    vech[2]=vechi[2];
                    vech[3]=vechi[3];
                    vech[4]=vechi[4];
                }
                if((Integer.parseInt(vech[2])<=Integer.parseInt(search)&&Integer.parseInt(vech[2])>=Integer.parseInt(search2))||
                (Integer.parseInt(vech[4])<=Integer.parseInt(search)&&Integer.parseInt(vech[4])>=Integer.parseInt(search2)))
                    System.out.printf("\n%-20s%-20s%-20s%5s%20s",vech[0],vech[1],vech[2],vech[3],vech[4]);
            }
            sc.close();          
        }
        catch(FileNotFoundException e){
            System.out.printf("ERROR - A %s occurred:\n%s\n",e.getClass().toString(),e.getMessage());
        }    
    }
    public void filterCustomer(String search){
        try{
            Scanner sc=new Scanner(new FileInputStream("/Users/zirui/Desktop/JavaProject/Project/src/cust.csv"));
            while(sc.hasNextLine()){
                String [] cust=sc.nextLine().split(",");
                if(cust[0].equals(search)||cust[1].equals(search)||cust[2].equals(search)||cust[3].equals(search))
                    System.out.printf("\n%-20s%-20s%-20s%-20s",cust[0],cust[1],cust[2],cust[3]);
            }
            sc.close();          
        }
        catch(FileNotFoundException e){
            System.out.printf("ERROR - A %s occurred:\n%s\n",e.getClass().toString(),e.getMessage());
        }    
    }
    public void filterCustomerWithEId(String eid,String search){
       try{
            Scanner sc=new Scanner(new FileInputStream("/Users/zirui/Desktop/JavaProject/Project/src/sales.csv"));
            while(sc.hasNextLine()){
                String [] sales=sc.nextLine().split(",");
                if(sales[4].equals(eid)){
                    Scanner sc2=new Scanner(new FileInputStream("/Users/zirui/Desktop/JavaProject/Project/src/cust.csv"));
                    while(sc2.hasNextLine()){
                        String cust[]=sc2.nextLine().split(",");
                        if((sales[3].equals(cust[0]))&&(cust[0].equals(search)||cust[1].equals(search)||cust[2].equals(search)||cust[3].equals(search))){
                        System.out.printf("\n%-20s%-20s%-20s%-20s",cust[0],cust[1],cust[2],cust[3]);
                        break;
                        }
                    }  
                    sc2.close();
                }
            }
            sc.close();          
        }
        catch(FileNotFoundException e){
            System.out.printf("ERROR - A %s occurred:\n%s\n",e.getClass().toString(),e.getMessage());
        }    
    }
    public void filterForManagementLevel(){
        Scanner scanner=new Scanner(System.in);
        String search="";
        String search2="";
        int pin=0;
        System.out.println("\n--   Searching...   --");
        System.out.println("**Use >=,<= to find amount in range**");
        System.out.print("Search : ");
        search=scanner.nextLine();
        if(search.charAt(0)=='>'||search.charAt(0)=='<'){
                System.out.print("amount to (enter same amount if amount range are not needed) : ");
                search2=scanner.nextLine();
                pin++;
        }
        else if(search.charAt(4)=='-'){
                System.out.print("date until (enter same date if date range are not needed) : ");
                search2=scanner.nextLine();
                if(!search2.equals(search))
                    pin++;
        }
        if(pin>0){
            if(search.charAt(0)=='>'||search.charAt(0)=='<'){
                if(search.charAt(0)=='>'){
                    search=search.replaceAll("[><=]","");
                    filterVehicleForLarger(search, search2);          
                }
                else if(search.charAt(0)=='<'){
                    search=search.replaceAll("[><=]","");
                    filterVehicleForLess(search, search2);        
                }
            }
            else if(search.charAt(4)=='-'){
                filterSalesForDateTime(search, search2);
            }
        }
        else {
            filterVehicle(search);
            filterSales(search);
            filterCustomer(search); 
            filterEmployee(search);
        }
        System.out.println("\n\n-- End of searching --");
    }
        
    public void filterForSalesLevel (String eid){
        Scanner scanner=new Scanner(System.in);
        String search="";
        String search2="";
        int pin=0;
        System.out.println("\n--   Searching...   --");
        System.out.print("Search : ");
        search=scanner.nextLine();
        if(search.charAt(4)=='-'){
                System.out.print("date until : (enter same date if date range are not needed) ");
                search2=scanner.nextLine();
                if(!search2.equals(search))
                    pin++;
        }
        if(pin>0){
            if(search.charAt(4)=='-')
            filterSalesForDateTimeWithEId(eid,search, search2);
        }
        else{
        filterSalesWithEId(eid,search);
        filterCustomerWithEId(eid,search);
        }
        System.out.println("\n\n-- End of searching --");
    }
    
    
        
}