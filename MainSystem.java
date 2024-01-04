import java.util.ArrayList;
import java.util.Scanner;

public class MainSystem{

    static seller s = new seller();
    static manager m = new manager();

    public void getCalculation(){
        Scanner k = new Scanner(System.in);

        System.out.print("Enter 1 to search employee salary \nEnter 2 to get all employee salary \nEnter your choice:");
        int choice = k.nextInt();
        System.out.println();

        switch (choice) {
            case 1:
                getEmployeeSalary();
                break;
            case 2 :
                getAllSalary();
                break;
            default:
            System.out.println("Enter a valid choice");
                break;
        }
    }

    public static void getEmployeeSalary(){
        Scanner k = new Scanner(System.in);

        System.out.println("Enter the employee ID:");
        String id = k.next();

        int status = s.checkStatus(id);

        if(status == 0){//seller
            System.out.println("------------------------------");
            System.out.println("ID: "+id+"\tSalary: "+s.getSalary(id));
            System.out.println("------------------------------");
        }else if(status == 1){//manager
            System.out.println("------------------------------");
            System.out.println("ID: "+id+"\tSalary: "+m.getSalary(id));
            System.out.println("------------------------------");
        }else if(status == -1){
            System.out.println("The employee does not exist. Please enter a valid id.");
        }

    }

    public static void getAllSalary(){
        ArrayList<String> employee1 = s.getSellerSaleId();
        ArrayList<String> employee2 = m.getManagerSaleId();

        for(String i : employee1){
            System.out.println("ID: "+ i + "\tSalary: " + s.getSalary(i));
        }

        for(String j : employee2){
            System.out.println("ID: "+ j + "\tSalary: " + m.getSalary(j));
        }

        System.out.println("\nThe total salary of all employee : " + s.getTotalSalary());
    }
}
