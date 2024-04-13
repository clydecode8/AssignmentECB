/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.ArrayList;
import adt.ListInterface;
import boundary.ProgrammeTutorialUI;
import entity.Programme;
import entity.Student;
import entity.TutorialGroup;

/**
 *
 * @author User
 */
public class GroupSummary {
    
    private ProgrammeTutorialUI programmeUI = new ProgrammeTutorialUI();
    private ListInterface<Student> studentList = new ArrayList<>();
    private ListInterface<Programme> programmeList = new ArrayList<>();
    private ListInterface<TutorialGroup> tutorialList = new ArrayList<>();
    
    private Programme[] pg = new Programme[5];
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
    

        
        for (int i = 0; i < 3; i++) {
            
            pg[0].addTutorialGroupList(tg[i]);
            pg[1].addTutorialGroupList(tg[i+3]);
            pg[2].addTutorialGroupList(tg[i+6]);
        }
          
                
        for (int i = 0; i < pg.length; i++) {
            
            if(pg[i] != null){
                
                programmeList.add(pg[i]);  
                
            }
        }  
            
            
            
    }
    
    
    
    public void generateReport(Programme[] pg, TutorialGroup[] tg){
        

        for (int i = 0; i < pg.length; i++) {
            
            if(pg[i] != null){
                
                
                System.out.println(pg[i].getTutorialGroupList());
                
            }
            

            
            
        }
        
        for (int i = 0; i < tg.length; i++) {
            
            if(tg[i] != null){
                
                System.out.println(tg[i].getStudentList());
            }
            
            
        }
    }
}
