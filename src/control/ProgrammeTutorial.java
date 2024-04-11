/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.*;
import boundary.*;
import entity.*;
import java.util.Iterator;

/**
 *
 * @author User
 */
public class ProgrammeTutorial {
    
    private ProgrammeTutorialUI programmeUI = new ProgrammeTutorialUI();
    private ListInterface<Student> studentList = new ArrayList<>();
    private ListInterface<Programme> programmeList = new ArrayList<>();
    private ListInterface<TutorialGroup> tutorialList = new ArrayList<>();
    
    private Programme[] pg = new Programme[3];
    private TutorialGroup[] tg = new TutorialGroup[9];
    
    public void initialiser(){
        
        pg[0] = new Programme("Accounting", "2023/09");
        pg[1] = new Programme("Marketing", "2023/09");
        pg[2] = new Programme("Software Engineering", "2023/09");
    
        tg[0] = new TutorialGroup("ACC01", 23, pg[0]);
        tg[1] = new TutorialGroup("ACC02", 21, pg[0]);
        tg[2] = new TutorialGroup("ACC03", 20, pg[0]);
        
        tg[3] = new TutorialGroup("MG01", 19, pg[1]);
        tg[4] = new TutorialGroup("MG02", 22, pg[1]);
        tg[5] = new TutorialGroup("MG03", 21, pg[1]);
        
        tg[6] = new TutorialGroup("RSW01", 25, pg[2]);
        tg[7] = new TutorialGroup("RSW02", 18, pg[2]);
        tg[8] = new TutorialGroup("RSW03", 16, pg[2]);
    
        tutorialList.clear();
        for (int i = 0; i < tg.length; i++) {
            tutorialList.add(tg[i]);
            
        }
        
        for (int i = 0; i < pg.length; i++) {
            programmeList.add(pg[i]);
            
        }
    }
    
    

    public void addProgrammeTutorial(){
        
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
            tutorialList.add(inputTG);
            
        }else if(cond == 2){
        
            TutorialGroup userInput = programmeUI.inputProgrammeTutorial();
            tutorialList.add(userInput);
        }
        

        
    
    }
    
    public void removeProgrammeTutorial(){
        
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
            tutorialList.condSearch(programmeList.getEntry(choice).toString());
            
            String removal = programmeUI.chooseTG();
            boolean status = tutorialList.customRemove(removal);
            
            if(status == true){
                
                System.out.println("Tutorial Group successfully removed! ");
            }

            
        }else if(cond == 2){

            
            
            
        }
        

    }
    
    public void listProgrammeTutorial(){

        int choice = programmeUI.chooseWhichShow();
        
        if(choice == 1){
            
            Iterator<TutorialGroup> iterator = tutorialList.iterator();
                int i = 0;
                while (iterator.hasNext()) {
                    Comparable tg = iterator.next();

                    System.out.println(i+1 + ". " + tg.toString());
                    i++;
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
            tutorialList.condSearch(programmeList.getEntry(choice2).toString());

            
        }
        

    }
}
