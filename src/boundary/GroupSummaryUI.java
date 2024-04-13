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
public class GroupSummaryUI {
    
    Scanner scanner = new Scanner(System.in);
    
    public int summaryReport(){
        
        
        int choice = 0;
        do {
            
            System.out.println("Choose a Summary Report.");
            System.out.println("");
            System.out.println("------------------------------------");
            System.out.println("1. Summary of Tutorial Group Intakes.");
            System.out.println("2. Summary of Students per Tutorial Group.");
            System.out.println("3. Summary of Students per Programme.");
            System.out.println("4. Exit.");
            System.out.println("------------------------------------");
            System.out.print(">:    ");
            choice = scanner.nextInt();
    
        }while(choice > 0 && choice > 4);

        return choice; 
        
        
    }
    
    public int chooseSort(){
        
        int choice = 0;
        do {
            
            System.out.println("Sort Tutorial Group by.");
            System.out.println("");
            System.out.println("------------------------------------");
            System.out.println("1. Ascending.");
            System.out.println("2. Descending.");
            System.out.println("------------------------------------");
            System.out.print(">:    ");
            choice = scanner.nextInt();
    
        }while(choice > 0 && choice > 2);

        return choice; 
    }
}
