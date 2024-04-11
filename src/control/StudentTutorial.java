/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.ArrayList;
import adt.ListInterface;
import boundary.GroupManagementUI;
import boundary.ProgrammeTutorialUI;
import boundary.StudentTutorialUI;
import entity.Programme;
import entity.Student;
import entity.Team;
import entity.TutorialGroup;
import java.util.Iterator;
import utility.MessageUI;

/**
 *
 * @author User
 */
public class StudentTutorial {
    
    private StudentTutorialUI stdUI = new StudentTutorialUI();
    private ProgrammeTutorialUI programmeUI = new ProgrammeTutorialUI();
    private ListInterface<Student> studentList = new ArrayList<>();
    private ListInterface<Programme> programmeList = new ArrayList<>();
    private ListInterface<TutorialGroup> tutorialList = new ArrayList<>();
    
    private Programme[] pg = new Programme[3];
    private TutorialGroup[] tg = new TutorialGroup[9];
    private Student[] std = new Student[5];
    
     public void initialiser(){
        
        pg[0] = new Programme("Software Engineering", "2023/09");

        tg[0] = new TutorialGroup("RSW01", 25, pg[0]);
        tg[1] = new TutorialGroup("RSW02", 18, pg[0]);
        tg[2] = new TutorialGroup("RSW03", 16, pg[0]);
        tg[3] = new TutorialGroup("RSW04", 16, pg[0]);
        
        
        Team t1 = new Team("Robot team1", "Robot Development", tg[0]);
        Team t2 = new Team("Robot team2", "Robot Development", tg[0]);
        Team t3 = new Team("Robot team3", "Robot Development", tg[1]);
        Team t4 = new Team("Gundam team1", "Robot Development", tg[2]);
        Team t5 = new Team("Gundam team2", "Robot Development", tg[2]);
        
        TutorialGroup g1 = new TutorialGroup("Group 1", 24, pg[0]);
        TutorialGroup g2 = new TutorialGroup("Group 2", 24, pg[0]);
        TutorialGroup g3 = new TutorialGroup("Group 3", 24, pg[0]);
        TutorialGroup g4 = new TutorialGroup("Group 4", 24, pg[0]);
        
        std[0] = new Student("Han", "2213577", tg[0], t1);
        std[1] = new Student("Jack", "2214577", tg[0], t2);
        std[2] = new Student("Bob", "2215577", tg[1], t3);
        std[3] = new Student("Clyde", "2216577", tg[2], t4);
        std[4] = new Student("Robert", "2216577", tg[3], t5);
    

        studentList.clear();
        tutorialList.clear();
        
        for (int i = 0; i < std.length; i++) {
            studentList.add(std[i]);
            
        }
        for (int i = 0; i < tg.length; i++) {
            tutorialList.add(tg[i]);
            
        }
        

    }
    
    
    public void addStudentTutorial(){
        
        int choice = stdUI.chooseWhichAdd();
        
        if(choice == 1){
            
            Iterator<TutorialGroup> iterator = tutorialList.iterator();
            int i = 0;
            while (iterator.hasNext()) {
                Comparable tl = iterator.next();
               
                System.out.println(i+1 + ". " + tl.toString());
                i++;
            }
            
            int choice2 = stdUI.inputAddIterator();
            
            
            
        }else if(choice == 2){
            
            
            
        }
        
        
    }
    
    public void removeStudentTutorial(){
        
        
        
    }
    
    public void changeStudentTutorial(){
        
        
        
    }
    
    public void listStudentTutorial(){
        
        
    }
    
}
