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

    public void addStudentTutorial(TutorialGroup[] tg, Programme[] pg, ListInterface<TutorialGroup> tutorialList){
        
        int choice = stdUI.chooseWhichAdd();
        
        if(choice == 1){
            
            //loop later
            Iterator<TutorialGroup> iterator = pg[0].getTutorialGroupList().iterator();
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
            
            
            Student stdInput = new Student(name, id, tg[choice2], emptyTeam);
            stdInput.setName(name);
            tg[choice2].getStudentList().add(stdInput);
    
        }else if(choice == 2){
            
            
            
            
        }
        
        
    }
    
    public void removeStudentTutorial(TutorialGroup[] tg, Programme[] pg, ListInterface<TutorialGroup> tutorialList){
        
        int cond = stdUI.chooseWhichRemove();
        
        
        if(cond == 1){
        
            Iterator<TutorialGroup> iterator = pg[0].getTutorialGroupList().iterator();
            int i = 0;
            while (iterator.hasNext()) {
                Comparable tutorg = iterator.next();
               
                System.out.println(i+1 + ". " + tutorg.toString());
                i++;
            }            


            int choice = stdUI.inputRemoveIterator();

            int j = 0;
            Iterator<Student> iterator2 = tg[choice].getStudentList().iterator();
            while (iterator2.hasNext()) {
                Comparable tutorg = iterator2.next();
               
                System.out.println(j+1 + ". " + tutorg.toString());
                j++;
            }    
            
            int removal = stdUI.inputChooseName();
            tg[choice].getStudentList().remove(removal);

        }else if(cond == 2){

            
            
            
        }
        
    }
    
    public void changeStudentTutorial(TutorialGroup[] tg, Programme[] pg, ListInterface<TutorialGroup> tutorialList){
        
        int cond = stdUI.chooseWhichChange();
        if(cond == 1){
            
            Iterator<TutorialGroup> iterator = pg[0].getTutorialGroupList().iterator();
            int i = 0;
            while (iterator.hasNext()) {
                Comparable tutorg = iterator.next();
               
                System.out.println(i+1 + ". " + tutorg.toString());
                i++;
            }
            
            int choice = stdUI.inputChangeIterator();

            Iterator<Student> iterator2 = tg[choice].getStudentList().iterator();
            int j = 0;
            while (iterator2.hasNext()) {

                Comparable tutorg = iterator2.next();
               
                System.out.println(j+1 + ". " + tutorg.toString());
                j++;
            }
            
            int chg = stdUI.chooseStudent();
            
            Iterator<TutorialGroup> iterator3 = pg[0].getTutorialGroupList().iterator();
            int k = 0;
            while (iterator3.hasNext()) {
                
                    
                Comparable tutorg = iterator3.next();
                
                if(k == choice){
                    
                    
                    System.out.println(k+1 + ". " + tutorg.toString() + "(same)");
                    
                }else{
                    
                    System.out.println(k+1 + ". " + tutorg.toString());
                    
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
    
    public void mergeStudentTutorial(TutorialGroup[] tg, Programme[] pg, ListInterface<TutorialGroup> tutorialList){
        
        Iterator<TutorialGroup> iterator = pg[0].getTutorialGroupList().iterator();
            int i = 0;
            while (iterator.hasNext()) {
                Comparable tutorg = iterator.next();
               
                System.out.println(i+1 + ". " + tutorg.toString());
                i++;
            }
            
        int choice = stdUI.inputMergeIterator();
        
        
        Iterator<TutorialGroup> iterator2 = pg[0].getTutorialGroupList().iterator();
            int j = 0;
            while (iterator2.hasNext()) {
                Comparable tutorg = iterator2.next();
               
                System.out.println(j+1 + ". " + tutorg.toString());
                j++;
            }
            
        int choice2 = stdUI.inputMergeIterator2();
        
        //(old, new) = merge(b, a) = replaceAll(b, a) = replace All B to A
        //replaceAll(RSWG4, RSWG2) replace rswg4 to rswg2
        int initialSize = tg[choice2].getStudentList().getNumberOfEntries();
        int removedEntry = 0;
        for (int k = 0; k < initialSize; k++) {
            
            if(tg[choice2] != null){

                Student tempStd = tg[choice2].getStudentList().getEntry(k);
                String name = tempStd.getName();
                String id = tempStd.getID();
                TutorialGroup tutorialgroup = tg[choice];
                Team team = tempStd.getTeam();


                tg[choice].addStudentList(new Student(name, id, tutorialgroup, team));
                removedEntry++;
            }

            
        }
        
        for(int l=0; l<removedEntry; l++){
            
            tg[choice2].getStudentList().remove(0);
            
        }



    }
    
    public void listStudentTutorial(TutorialGroup[] tg, Programme[] pg, ListInterface<TutorialGroup> tutorialList){
        
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
