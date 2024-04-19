/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class DriverUI {
    
    Scanner scanner = new Scanner(System.in);
    
    public int getMenuChoice() {
        
        int choice = 0;
        
        do{
            
            System.out.println("====================================================");
            System.out.println("           University Management System");
            System.out.println("====================================================");
            System.out.println("1. Student Registration Management");
            System.out.println("2. Course Management");
            System.out.println("3. Tutorial Group Management");
            System.out.println("4. Teaching Assignment");
            System.out.println("5. Assignment Team Management");
            System.out.println("0. Quit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            
        }while(choice > 0 && choice > 5);

        return choice;
        
    }
    
    
}
