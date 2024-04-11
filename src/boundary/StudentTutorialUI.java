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
public class StudentTutorialUI {
    
    Scanner scanner = new Scanner(System.in);
    
    public int getMenuChoice() {
        
        System.out.println("Tutorial Group Management System");
        System.out.println("\n---------------------------");
        System.out.println("1. Add Student to Tutorial Group");
        System.out.println("2. Remove Student from Tutorial Group");
        System.out.println("3. Change Tutorial Group for a Student");
        System.out.println("4. List all Tutorial Groups");
        System.out.println("0. Quit");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return choice;
        
    }
    
    public int chooseWhichAdd(){
        
        int choice = 0;
        do{
            
            System.out.println("");
            System.out.println("");
            System.out.println("------------------------------------");
            System.out.println("1. Choose from existing Tutorial Group.");
            System.out.println("2. Input Programme Manually.");
            System.out.println("3. Exit.");
            System.out.println("------------------------------------");
            System.out.print(">:    ");
            choice = scanner.nextInt();
    
        }while(choice > 0 && choice > 3);

        return choice;
    }
    
    public int inputAddIterator(){
        
        System.out.println("Choose which Tutorial Group to add: ");
        int chosen = scanner.nextInt();
        return chosen-1;
    }
    
    
}
