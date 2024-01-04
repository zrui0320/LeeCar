
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("1. Register\n2. Login\n3. Exit");
            System.out.print("Enter your choice: ");
            String choice = sc.nextLine();
            System.out.println("");
            String name, username,password, secretKey;
            
            switch (choice) {
                case "1":
                    System.out.print("Enter secret key: ");
                    secretKey = sc.nextLine();
                    if (company.validateSecretKey(secretKey)) {
                        System.out.println("Employee ID or username given: " + Company.employeeIDGenerator());
                        System.out.print("Enter your name: ");
                        name = sc.nextLine();
                        System.out.print("Enter password: ");
                        password = sc.nextLine();
                        company.registerEmployee(name, Company.employeeIDGenerator(), password);
                        System.out.println("");
                    }
                    else {
                        System.out.println("Invalid secret key. Teminating program.");
                        sc.close();
                        System.exit(0);
                    }
                    break;

                case "2":
                    System.out.print("Enter Employee ID: ");
                    username = sc.nextLine();
                    System.out.print("Enter password: ");
                    password = sc.nextLine();
                    company.login(username, password);
                    System.out.println("");
                    break;

                case "3":
                    System.out.println("Exiting program. Goodbye!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
