/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import entity.Programme;
import entity.TutorialGroup;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class ProgrammeTutorialUI {
    
    Scanner scanner = new Scanner(System.in);
    
    public int getMenuChoice() {
        
        System.out.println("===============================================");
        System.out.println("       Tutorial Group Management System");
        System.out.println("===============================================");
        System.out.println("1. Add Tutorial Group to Programme ");
        System.out.println("2. Remove Tutorial Group from Programme");
        System.out.println("3. List Tutorial Group for a programme");
        System.out.println("===============================================");
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
            System.out.println("1. Choose from existing programme.");
            System.out.println("2. Exit.");
            System.out.println("------------------------------------");
            System.out.print(">:    ");
            choice = scanner.nextInt();
    
        }while(choice > 0 && choice > 2);

        return choice;
    }
    
    public int chooseWhichRemove(){
        
        int choice = 0;
        do {
            
            System.out.println("");
            System.out.println("");
            System.out.println("------------------------------------");
            System.out.println("1. Choose from existing programme.");
            System.out.println("2. Exit.");
            System.out.println("------------------------------------");
            System.out.print(">:    ");
            choice = scanner.nextInt();
    
        }while(choice > 0 && choice > 2);

        return choice;   
    
    }
    
    public int chooseTG(){
        
   
        System.out.print("Choose a number: > ");
        int tg = scanner.nextInt();
        
        return tg;
    }
    
    public int chooseWhichShow(){
        
        int choice = 0;
        do {
            
            System.out.println("");
            System.out.println("");
            System.out.println("------------------------------------");
            System.out.println("1. List all.");
            System.out.println("2. List from specific Programme.");
            System.out.println("3. Exit.");
            System.out.println("------------------------------------");
            System.out.print(">:    ");
            choice = scanner.nextInt();
    
        }while(choice > 0 && choice > 3);

        return choice;   
    
    }
    
    public int chooseWhichProgramme(){
        
        System.out.print("Choose which programme to display: ");
        int chosen = scanner.nextInt();
        return chosen-1;
    }

    
    public int inputAddIterator(){
        
        System.out.print("Choose which programme to add: ");
        int chosen = scanner.nextInt();
        return chosen-1;
    }
    
    public int inputRemoveIterator(){
        
        System.out.print("Choose which programme to remove: ");
        int chosen = scanner.nextInt();
        return chosen-1;
    }
    
    public TutorialGroup inputProgrammeTutorial(){
        
        String name = inputProgrammeName();
        String date = inputProgrammeDate();
        
        String tg = inputTutorialGroup();
        
        
        
        return new TutorialGroup(tg, 0, new Programme(name, date));

    } 
    
    public String inputProgrammeName(){
        
        System.out.print("Input Programme Name: ");
        String inputProgramme = scanner.nextLine();
        return inputProgramme;
    }
    
    public String inputProgrammeDate(){
        
        System.out.print("Input Programme Intake (Year/Month) (2023/09): ");
        String inputProgrammeDate = scanner.nextLine();
        return inputProgrammeDate;
    }
    
    public String inputTutorialGroup(){
        
        System.out.print("Input Tutorial Group (CodeNumb) (ACC03): ");
        String tutorialgroup = scanner.next();
        return tutorialgroup;
    }
    
//    public int inputNoStudents(){
//        
//        
//        System.out.print("Input number of students: ");
//        int numb = scanner.nextInt();
//        return numb;
//    }
//    
    

}
