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
    private TutorialGroup[] tg = new TutorialGroup[4];
    private Student[] std = new Student[6];
    private Student stdInput;
    
     public void initialiser(){
        
        pg[0] = new Programme("Software Engineering", "2023/09");

        tg[0] = new TutorialGroup("RSW01", 25, pg[0]);
        tg[1] = new TutorialGroup("RSW02", 18, pg[0]);
        tg[2] = new TutorialGroup("RSW03", 16, pg[0]);
        
        
        Team t1 = new Team("Robot team1", "Robot Development", tg[0]);
        Team t2 = new Team("Robot team2", "Robot Development", tg[0]);
        Team t3 = new Team("Robot team3", "Robot Development", tg[1]);
        Team t4 = new Team("Gundam team1", "Robot Development", tg[2]);
        Team t5 = new Team("Gundam team2", "Robot Development", tg[2]);
        
        String name[] = new String[]{"Han", "Jack", "Bob", "Clyde", "Robert", "Janice"};
        String id[] = new String[]{"2213577", "2214577", "2215577", "2216177", "2216577", "2211577"};
        
        for (int i = 0; i < id.length; i++) {
        
            std[0] = new Student(name[i], id[i], tg[0], t1);
            std[1] = new Student(name[i], id[i], tg[0], t2);
            std[2] = new Student(name[i], id[i], tg[1], t3);
            std[3] = new Student(name[i], id[i], tg[1], t4);
            std[4] = new Student(name[i], id[i], tg[2], t5);
            std[5] = new Student(name[i], id[i], tg[2], t5);


        }
  
        pg[0].getTutorialGroupList().clear();
        for (int i = 0; i < tg.length; i++) {
            
            
            if(tg[i] != null){
                
                pg[0].addTutorialGroupList(tg[i]);
                tutorialList.add(tg[i]); 
                
            }

        }
        
        for (int i = 0; i < 2; i++) {
            
            tg[0].addStudentList(std[i]);
            tg[1].addStudentList(std[i+2]);
            tg[2].addStudentList(std[i+4]);

        }
  
        for (int i = 0; i < std.length; i++) {
            
            if(std[i] != null){
                
                 std[i].setName(name[i]);
                 std[i].setID(id[i]);
                
            }
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
            
            String name = stdUI.inputName();
            String id = stdUI.inputID();
            Team emptyTeam = new Team("", "Robot Development", tg[choice2]);
            
            
            stdInput = new Student(name, id, tg[choice2], emptyTeam);
            stdInput.setName(name);
            tg[choice2].getStudentList().add(stdInput);
    
        }else if(choice == 2){
            
            
            
            
        }
        
        
    }
    
    public void removeStudentTutorial(){
        
        int cond = stdUI.chooseWhichRemove();
        
        
        if(cond == 1){
        
            Iterator<TutorialGroup> iterator = pg[0].getTutorialGroupList().iterator();
            int i = 0;
            while (iterator.hasNext()) {
                Comparable tg = iterator.next();
               
                System.out.println(i+1 + ". " + tg.toString());
                i++;
            }            


            int choice = stdUI.inputRemoveIterator();

            int j = 0;
            Iterator<Student> iterator2 = tg[choice].getStudentList().iterator();
            while (iterator2.hasNext()) {
                Comparable tg = iterator2.next();
               
                System.out.println(j+1 + ". " + tg.toString());
                j++;
            }    
            
            int removal = stdUI.inputChooseName();
            tg[choice].getStudentList().remove(removal);

        }else if(cond == 2){

            
            
            
        }
        
    }
    
    public void changeStudentTutorial(){
        
        int cond = stdUI.chooseWhichChange();
        if(cond == 1){
            
            Iterator<TutorialGroup> iterator = pg[0].getTutorialGroupList().iterator();
            int i = 0;
            while (iterator.hasNext()) {
                Comparable tg = iterator.next();
               
                System.out.println(i+1 + ". " + tg.toString());
                i++;
            }
            
            int choice = stdUI.inputChangeIterator();

            Iterator<Student> iterator2 = tg[choice].getStudentList().iterator();
            int j = 0;
            while (iterator2.hasNext()) {

                Comparable tg = iterator2.next();
               
                System.out.println(j+1 + ". " + tg.toString());
                j++;
            }
            
            int chg = stdUI.chooseStudent();
            
            Iterator<TutorialGroup> iterator3 = pg[0].getTutorialGroupList().iterator();
            int k = 0;
            while (iterator3.hasNext()) {
                
                    
                Comparable tg = iterator3.next();
                
                if(k == choice){
                    
                    
                    System.out.println(k+1 + ". " + tg.toString() + "(same)");
                    
                }else{
                    
                    System.out.println(k+1 + ". " + tg.toString());
                    
                }

                k++;
      
                
            }
            
            int ans = stdUI.inputChangeIteratorFindTG();
            
            Student stdAns = tg[choice].getStudentList().getEntry(chg);
            String name = stdAns.getName();
            String id = stdAns.getID();
            TutorialGroup tgAns = tg[ans];
            Team team = stdAns.getTeam();
            
            tg[ans].getStudentList().add(new Student(name, id, tgAns, team));
            tg[choice].getStudentList().remove(chg);
           
            
        
            
        }else if(cond == 2){
            
            
        }
        
    }
    
    public void mergeStudentTutorial(){
        
        Iterator<TutorialGroup> iterator = pg[0].getTutorialGroupList().iterator();
            int i = 0;
            while (iterator.hasNext()) {
                Comparable tg = iterator.next();
               
                System.out.println(i+1 + ". " + tg.toString());
                i++;
            }
            
        int choice = stdUI.inputChangeIterator();
        
    }
    
    public void listStudentTutorial(){
        
        int choice = stdUI.chooseWhichShow();
        
        if(choice == 1){
            
            int i = 0;
            for(int j=0; j < tg.length; j++){
                
                if(tg[j] != null){
                    
                    Iterator<Student> iterator = tg[j].getStudentList().iterator();
                
                    while (iterator.hasNext()) {
                        Comparable std = iterator.next();

                        System.out.println(i+1 + ". " + std.toString());
                        i++;
                    }
                }
    
            }
  
            
        }else if(choice == 2){
            
            int i = 0;
            Iterator<TutorialGroup> iterator = pg[0].getTutorialGroupList().iterator();

            while (iterator.hasNext()) {
                Comparable tgList = iterator.next();

                System.out.println(i+1 + ". " + tgList.toString());
                i++;
            }
                
    
            
            
            int choice2 = stdUI.inputChooseIterator();

            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println(tg[choice2].getStudentList().toString());

            
        }
        
    }
    
}
