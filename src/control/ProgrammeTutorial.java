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
           
            
        }else if(cond == 2){
        
            //TutorialGroup userInput = programmeUI.inputProgrammeTutorial();
            
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
            while (iterator2.hasNext()) {
                Comparable tg = iterator2.next();
               
                System.out.println(j+1 + ". " + tg.toString());
                j++;
            }            

            
            int removal = programmeUI.chooseTG();
            pg[choice].getTutorialGroupList().remove(removal-1);
             
        }else if(cond == 2){

            
            
            
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

            
        }
        

    }
}
