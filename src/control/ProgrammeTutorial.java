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
 * @author User
 */
public class ProgrammeTutorial  {
    
    private ProgrammeTutorialUI programmeUI = new ProgrammeTutorialUI();

    public void addProgrammeTutorial(Programme[] pg, TutorialGroup[] tg, ListInterface<Programme> programmeList){
        
        int cond = programmeUI.chooseWhichAdd();
 
        if(cond == 1){
            
            
            
        
            Iterator<Programme> iterator = programmeList.iterator();
            int i = 0;
            while (iterator.hasNext()) {
                Comparable programme = iterator.next();
               
                System.out.println(i+1 + ". " + programme.toString());
                i++;
            }
            
            int choice = programmeUI.inputAddIterator();
            
            String tgroup = programmeUI.inputTutorialGroup();
            int tgroupStudents = programmeUI.inputNoStudents();
            
            TutorialGroup inputTG = new TutorialGroup(tgroup, tgroupStudents, pg[choice]);
            pg[choice].getTutorialGroupList().add(inputTG);
           
            
        }
        
        
    
    }
    
    public void removeProgrammeTutorial(Programme[] pg, ListInterface<Programme> programmeList){
        
        int cond = programmeUI.chooseWhichRemove();
        
        
        if(cond == 1){
        
            Iterator<Programme> iterator = programmeList.iterator();
            int i = 0;
            while (iterator.hasNext()) {
                Comparable programme = iterator.next();
               
                System.out.println(i+1 + ". " + programme.toString());
                i++;
            }
            
            int choice = programmeUI.inputRemoveIterator();

            System.out.println("");
            System.out.println("");
            System.out.println("");
            
            Iterator<TutorialGroup> iterator2 = pg[choice].getTutorialGroupList().iterator();
            int j = 0;
            System.out.printf("%-5s %-12s %-15s%n", "No", "Group", "Total Students");
            while (iterator2.hasNext()) {
                TutorialGroup tg = iterator2.next();
               
                System.out.printf("%-5d %-12s %-15d%n", j+1, tg.getGroup(), tg.getQty());

                j++;
            }            

            
            int removal = programmeUI.chooseTG();
            TutorialGroup test = pg[choice].getTutorialGroupList().remove(removal-1);
             
            if(test != null){
                
                System.out.println("Entry successfully removed.");
            
            }else{
                
                
                System.out.println("Entry removal unsuccessful.");
            }
            
            GroupManagementUI.enterCont();
            
            
            
        }
        

    }
    
    public void listProgrammeTutorial(Programme[] pg, ListInterface<Programme> programmeList){

        int choice = programmeUI.chooseWhichShow();
        
        
        if(choice == 1){
            
            
            for(int i = 0; i < 3; i++){
                
                Iterator<TutorialGroup> iterator = pg[i].getTutorialGroupList().iterator();
                    int j = 0;
                    while (iterator.hasNext()) {
                        Comparable tg = iterator.next();

                        System.out.println(i+1 + ". " + tg.toString());
                        j++;
                }
                
            }
            
            GroupManagementUI.enterCont();
            
        }else if(choice == 2){
            
            Iterator<Programme> iterator = programmeList.iterator();
            int i = 0;
            while (iterator.hasNext()) {
                Comparable programme = iterator.next();
               
                System.out.println(i+1 + ". " + programme.toString());
                i++;
            }
            
            int choice2 = programmeUI.chooseWhichProgramme();

            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println(pg[choice2].getTutorialGroupList().toString());

            GroupManagementUI.enterCont();
        }
        
        
        

    }
}
