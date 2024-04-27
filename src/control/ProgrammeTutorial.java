/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import DAO.StudentInitializer;
import adt.*;
import boundary.*;
import entity.*;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Kok Ming Han
 */
public class ProgrammeTutorial  {
    
    private ProgrammeTutorialUI programmeUI = new ProgrammeTutorialUI();

    public void addProgrammeTutorial(Programme[] pg, TutorialGroup[] tg, ListInterface<Programme> programmeList){
        
        
        int cond = programmeUI.chooseWhichAdd();
 
        if(cond == 1){

            GroupManagementUI.clearScreen();
            System.out.println("====================================================================");
            Iterator<Programme> iterator = programmeList.iterator();
            int i = 0;
            System.out.printf("%-5s %-25s %-15s%n", "No", "Programme Name", "Year of Intake");
            while (iterator.hasNext()) {
                Programme programme = iterator.next();
               
                System.out.printf("%-5d %-25s %-25s%n", i+1, programme.getName(), programme.getYearIntake());
                i++;
            }

            System.out.println("====================================================================");
            int choice = programmeUI.inputAddIterator();
            
            String tgroup = programmeUI.inputTutorialGroup();
            
            TutorialGroup inputTG = new TutorialGroup(tgroup, 0, pg[choice]);
            boolean status = pg[choice].getTutorialGroupList().add(inputTG);
           
            
            if(status == true){
                
                System.out.println("Entry is successfully added");
                GroupManagementUI.enterCont();
                GroupManagementUI.clearScreen();
            
            }else{
                
                System.out.println("Entry not successfully added");
            }
            
        }
        
        
    
    }
    
    public void removeProgrammeTutorial(Programme[] pg, ListInterface<Programme> programmeList){
        
        int cond = programmeUI.chooseWhichRemove();
        
        
        if(cond == 1){
        
            GroupManagementUI.clearScreen();
            System.out.println("====================================================================");
            Iterator<Programme> iterator = programmeList.iterator();
            int i = 0;
            System.out.printf("%-5s %-25s %-15s%n", "No", "Programme Name", "Year of Intake");
            while (iterator.hasNext()) {
                Programme programme = iterator.next();
               
                System.out.printf("%-5d %-25s %-25s%n", i+1, programme.getName(), programme.getYearIntake());
                i++;
            }

            System.out.println("====================================================================");
            int choice = programmeUI.inputRemoveIterator();

            GroupManagementUI.clearScreen();
            
            Iterator<TutorialGroup> iterator2 = pg[choice].getTutorialGroupList().iterator();
            int j = 0;
            System.out.println("====================================================================");
            System.out.printf("%-5s %-12s %-15s%n", "No", "Group", "Total Students");
            while (iterator2.hasNext()) {
                TutorialGroup tg = iterator2.next();
               
                System.out.printf("%-5d %-12s %-15d%n", j+1, tg.getGroup(), tg.getQty());

                j++;
            }            
            System.out.println("====================================================================");

            
            int removal = programmeUI.chooseTG();
            TutorialGroup test = pg[choice].getTutorialGroupList().remove(removal-1);
             
            if(test != null){
                
                System.out.println("Entry successfully removed.");
                GroupManagementUI.enterCont();
                GroupManagementUI.clearScreen();
                
            }else{
                
                
                System.out.println("Entry removal unsuccessful.");
            }
    
            
        }
        

    }
    
    public void listProgrammeTutorial(Programme[] pg, ListInterface<Programme> programmeList){

        int choice = programmeUI.chooseWhichShow();
        
        
        if(choice == 1){
            
            GroupManagementUI.clearScreen();
            System.out.printf("%-5s %-25s %-25s%n", "No", "Programme Name", "Intake Year");
            for(int i = 0; i < 3; i++){
                
                System.out.println("===============================================================");
                System.out.printf("%-5s %-25s %-25s%n", i+1, pg[i].getName(), pg[i].getYearIntake());
                System.out.println("===============================================================");
                System.out.printf("%-5s %-25s %-25s%n", "No", "Tutorial Group", "No of Students");
                Iterator<TutorialGroup> iterator = pg[i].getTutorialGroupList().iterator();
                int j = 0;
                while (iterator.hasNext()) {
                    TutorialGroup tg = iterator.next();

                    System.out.printf("%-5s %-25s %-25s%n", j+1, tg.getGroup(), tg.getQty());
                    j++;
                }
                
            }
            
            GroupManagementUI.enterCont();
            
        }else if(choice == 2){
            
            GroupManagementUI.clearScreen();
            System.out.println("===============================================================================");
            System.out.printf("%-5s %-25s %-25s%n", "No", "Programme Name", "Intake Year");
            Iterator<Programme> iterator = programmeList.iterator();
            int i = 0;
            while (iterator.hasNext()) {
                Programme programme = iterator.next();
               
                System.out.printf("%-5s %-25s %-25s%n", i+1, programme.getName(), programme.getYearIntake());
                i++;
            }
            System.out.println("===============================================================================");
            
            int choice2 = programmeUI.chooseWhichProgramme();
            
            //Display the specific programme
            GroupManagementUI.clearScreen();
            Iterator<TutorialGroup> iterator2 = pg[choice2].getTutorialGroupList().iterator();
            System.out.println("===============================================================================");
            System.out.printf("%-5s %-25s %-25s%n", "No", "Tutorial Group", "Number of Students");
            System.out.println("===============================================================================");
            int j =0;
            while (iterator2.hasNext()){
                
                TutorialGroup tg = iterator2.next();
                System.out.printf("%-5s %-25s %-25s%n", j+1, tg.getGroup(), tg.getQty());
                j++;
            }
            System.out.println("===============================================================================");

            GroupManagementUI.enterCont();
        }
        
        
        

    }
}
