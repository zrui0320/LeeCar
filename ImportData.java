import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class ImportData{
    public static Customer []importCustomer(String selc){
            Customer []c=new Customer[10000];
            if(selc.equals("1")){
            try{
            Scanner sc=new Scanner(new FileInputStream("/Users/zirui/Desktop/JavaProject/Project/src/cust.csv"));
            int i=0;
            while(sc.hasNextLine()){
                String [] cust=sc.nextLine().split(",");
                c[i]=new Customer(cust[0],cust[1],cust[2],cust[3]);
                i++;
            }
            sc.close();
            }
            catch(FileNotFoundException e){
            System.out.printf("ERROR - A %s occurred:\n%s\n",e.getClass().toString(),e.getMessage());
            }
            System.out.println("Import cust.csv successfully");
            }
            return c;
    }
    public static Employee[] importEmployee(String selc,int pin){
        Employee [] e=new Employee[10000];
        if(selc.equals("1")){
        try{
            Scanner sc=new Scanner(new FileInputStream("/Users/zirui/Desktop/JavaProject/Project/src/employee.csv"));
            int i=0;
            while(sc.hasNextLine()){
                String [] emp=sc.nextLine().split(",");
                e[i]=new Employee(emp[0],emp[1],emp[2],emp[3]);
                i++;
            }
            sc.close();
        }
        catch(FileNotFoundException fe){
            System.out.printf("ERROR - A %s occurred:\n%s\n",fe.getClass().toString(),fe.getMessage());
        }
        if(pin==1)
        System.out.println("Import employee.csv successfully");    
        }
        return e;
    }
    public static Sales[] importSales(String selc){
        Sales [] s=new Sales[10000];
        if(selc.equals("1")){
        try{
            Scanner sc=new Scanner(new FileInputStream("/Users/zirui/Desktop/JavaProject/Project/src/sales.csv"));
            int i=0;
            while(sc.hasNextLine()){
                String [] sale=sc.nextLine().split(",");
                s[i]=new Sales(sale[0],sale[1],sale[2],sale[3],sale[4]);
                i++;
            }
            sc.close();
        }
        catch(FileNotFoundException e){
            System.out.printf("ERROR - A %s occurred:\n%s\n",e.getClass().toString(),e.getMessage());
        }
        System.out.println("Import sales.csv successfully");    
        }
        return s;
    }
    public static Vehicle[] importVehicle(String selc){
        Vehicle [] v=new Vehicle[10000];
        if(selc.equals("1")){
        try{
            Scanner sc=new Scanner(new FileInputStream("/Users/zirui/Desktop/JavaProject/Project/src/vehicle-2.csv"));
            int i=0;
            while(sc.hasNextLine()){
                String [] vech=sc.nextLine().split(",");
                if(vech[3].equals("0"))
                    v[i]=new Vehicle(vech[0],vech[1],vech[2],vech[3],vech[4]);
                else if(vech[3].equals("1"))
                    v[i]=new Vehicle(vech[0],vech[1],vech[2],vech[3],null);
                i++;
            }
            sc.close();
        }
        catch(FileNotFoundException e){
            System.out.printf("ERROR - A %s occurred:\n%s\n",e.getClass().toString(),e.getMessage());
        }
        System.out.println("Import vehicle.csv successfully");    
        }
        return v;
    }
    public static String passwordGenerator(){
         String upper="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
         String lower="abcdefghijklmnopqrstuvwxyz";
         String specialChars="<>.?/{}[]+-_()-*&^%$#@!";
         String num="0123456789";
         String combination=upper+lower+specialChars+num;
         char [] password=new char [8];
         Random r=new Random();
         for (int i=0;i<8;i++){
            password[i]=combination.charAt(r.nextInt(combination.length()));
         }
         return new String (password);
    }
    public static void addManagement(){
        StringBuilder sb=new StringBuilder();
        String eid=Company.employeeIDGenerator();
        sb.append(eid);
        Scanner in=new Scanner(System.in);
        System.out.println("\n--Adding employee--");
        System.out.println("Please enter name : ");
        String name=in.nextLine();
        int status=1;
        String pass =passwordGenerator();
        sb.append(","+name+","+status+","+pass);
            try{
                PrintWriter pw=new PrintWriter(new FileOutputStream("/Users/zirui/Desktop/JavaProject/Project/src/employee.csv",true));
                pw.println(sb.toString());
                pw.close();
                System.out.println("Employee added.\n");
            }
            catch(IOException ioe){
                System.out.printf("ERROR - A %s occurred:\n%s\n",ioe.getClass().toString(),ioe.getMessage());
            }  
        Company.e=importEmployee("1",0);

        
        }
}
