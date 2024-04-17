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
import java.util.Scanner;
import utility.MessageUI;

/**
 *
 * @author User
 */
public class StudentTutorial {
    
    private StudentTutorialUI stdUI = new StudentTutorialUI();
    private ProgrammeTutorialUI programmeUI = new ProgrammeTutorialUI();

    public void addStudentTutorial(TutorialGroup[] tg, Programme[] pg, ListInterface<TutorialGroup> tutorialList, ListInterface<Programme> programmeList){
        
        int choice = stdUI.chooseWhichAdd();
        
        if(choice == 1){

            Iterator<Programme> iterator = programmeList.iterator();
            int i = 0;
            while (iterator.hasNext()) {
                Comparable programme = iterator.next();

                System.out.println(i+1 + ". " + programme.toString());
                i++;
            }
            
            int chosen = stdUI.chooseProgramme();
                //loop later
            Iterator<TutorialGroup> iterator2 = pg[chosen].getTutorialGroupList().iterator();
            int k = 0;
            while (iterator2.hasNext()) {
                Comparable tl = iterator2.next();
               
                System.out.println(k+1 + ". " + tl.toString());
                k++;
            }
            
            int choice2 = stdUI.inputAddIterator();
            
            String name = stdUI.inputName();
            String id = stdUI.inputID();
            
            //Empty team
            Team emptyTeam = new Team("", "", tg[choice2]);
            
            //Get chosen tutorial group
            TutorialGroup tgs = pg[chosen].getTutorialGroupList().getEntry(choice2);
            
            Student stdInput = new Student(name, id, tgs, emptyTeam);
            stdInput.setName(name);
            stdInput.setID(id);
            stdInput.setTutorialGroup(tgs);
            stdInput.setTeam(emptyTeam);
            
            boolean status = tgs.getStudentList().add(stdInput);
            
            if(status == true){
                
                System.out.println("Entry successfully added.");
            }else{
                
                System.out.println("Entry adding is unsuccessful.");
            }
        }  
            
        
    }
    
    public void removeStudentTutorial(TutorialGroup[] tg, Programme[] pg, ListInterface<TutorialGroup> tutorialList, ListInterface<Programme> programmeList){
        
        int cond = stdUI.chooseWhichRemove();
        
        
        if(cond == 1){
            
            Iterator<Programme> iterator = programmeList.iterator();
            int i = 0;
            while (iterator.hasNext()) {
                Comparable programme = iterator.next();

                System.out.println(i+1 + ". " + programme.toString());
                i++;
            }
            
            int chosen = stdUI.chooseProgramme();
        
            Iterator<TutorialGroup> iterator2 = pg[chosen].getTutorialGroupList().iterator();
            int k = 0;
            while (iterator2.hasNext()) {
                Comparable tl = iterator2.next();
               
                System.out.println(k+1 + ". " + tl.toString());
                k++;
            }           


            int choice = stdUI.inputRemoveIterator();
            TutorialGroup tgs = pg[chosen].getTutorialGroupList().getEntry(choice);
            int j = 0;
            
            Iterator<Student> iterator3 = tgs.getStudentList().iterator();
            while (iterator3.hasNext()) {
                Comparable tutorg = iterator3.next();
               
                System.out.println(j+1 + ". " + tutorg.toString());
                j++;
            }    
            
            int removal = stdUI.inputChooseName();
            Student test = tgs.getStudentList().remove(removal);

            if(test == null){
                
                System.out.println("Entry removal unsuccessful.");
            }else{
                
                System.out.println("Entry removal successful.");
            }
            
        }
        
    }
    
    public void changeStudentTutorial(TutorialGroup[] tg, Programme[] pg, ListInterface<TutorialGroup> tutorialList, ListInterface<Programme> programmeList){
        
        int cond = stdUI.chooseWhichChange();
        if(cond == 1){
            
            Iterator<Programme> iterator = programmeList.iterator();
            int i = 0;
            while (iterator.hasNext()) {
                Comparable programme = iterator.next();

                System.out.println(i+1 + ". " + programme.toString());
                i++;
            }
            
            int chosen = stdUI.chooseProgramme();
            
            //Loop first
            Iterator<TutorialGroup> iterator2 = pg[chosen].getTutorialGroupList().iterator();
            int k = 0;
            while (iterator2.hasNext()) {
                Comparable tl = iterator2.next();
               
                System.out.println(k+1 + ". " + tl.toString());
                k++;
            }    
            int choice = stdUI.inputChangeIterator();


            //Loop through the specific tutorialgroup
            TutorialGroup tgs = pg[chosen].getTutorialGroupList().getEntry(choice);
            int j = 0;
            
            
            Iterator<Student> iterator3 = tgs.getStudentList().iterator();
            while (iterator3.hasNext()) {
                Comparable tutorg = iterator3.next();
               
                System.out.println(j+1 + ". " + tutorg.toString());
                j++;
            }   
            
            int chg = stdUI.chooseStudent();
            
            //Loop second
            Iterator<TutorialGroup> iterator4 = pg[chosen].getTutorialGroupList().iterator();
            int l = 0;
            while (iterator4.hasNext()) {
                
                    
                Comparable tutorg = iterator4.next();
                
                if(k == choice){
                    
                    
                    System.out.println(l+1 + ". " + tutorg.toString() + "(same)");
                    
                }else{
                    
                    System.out.println(l+1 + ". " + tutorg.toString());
                    
                }

                l++;
      
                
            }
            
            int ans = stdUI.inputChangeIteratorFindTG();
            
            //Get new tutorial group
            TutorialGroup tgsNew = pg[chosen].getTutorialGroupList().getEntry(ans);
            
            //Get the old specific tutorial group
            TutorialGroup tgsOld = pg[chosen].getTutorialGroupList().getEntry(choice);
            
            //Old tutorial group declaration for stduent
            Student stdAns = tgsOld.getStudentList().getEntry(chg);
            String name = stdAns.getName();
            String id = stdAns.getID();
            TutorialGroup tgAns = tgsNew;
            Team team = stdAns.getTeam();
            
            //Add to new tutorialgroup
            tgsNew.getStudentList().add(new Student(name, id, tgAns, team));
            
            //Remove from old via .remove()
            Student changed = tgsOld.getStudentList().remove(chg);
           
            if(changed == null){
                
                System.out.println("Entry changed unsuccessful.");
            }else{
                
                System.out.println("Entry changed successful.");
            }
        
            
        }
        
    }
    
    public void mergeStudentTutorial(TutorialGroup[] tg, Programme[] pg, ListInterface<TutorialGroup> tutorialList, ListInterface<Programme> programmeList){
        
        Iterator<Programme> iterator = programmeList.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Comparable programme = iterator.next();

            System.out.println(i+1 + ". " + programme.toString());
            i++;
        }

        int chosen = stdUI.chooseProgramme();


        Iterator<TutorialGroup> iterator2 = pg[chosen].getTutorialGroupList().iterator();
        int j = 0;
        while (iterator2.hasNext()) {
            Comparable tutorg = iterator2.next();

            System.out.println(j+1 + ". " + tutorg.toString());
            j++;
        }
            
        int choice = stdUI.inputMergeIterator();
        

        
        Iterator<TutorialGroup> iterator3 = pg[chosen].getTutorialGroupList().iterator();
            int k = 0;
            while (iterator3.hasNext()) {
                Comparable tutorg = iterator3.next();
               
                System.out.println(k+1 + ". " + tutorg.toString());
                k++;
            }
            
        int choice2 = stdUI.inputMergeIterator2();
        
        //Get new tutorial group
        TutorialGroup tgsNew = pg[chosen].getTutorialGroupList().getEntry(choice);
        //Get old tutorial group   
        TutorialGroup tgsOld = pg[chosen].getTutorialGroupList().getEntry(choice2);
            
        
        //(old, new) = merge(b, a) = replaceAll(b, a) = replace All B to A
        //replaceAll(RSWG4, RSWG2) replace rswg4 to rswg2
        int initialSize = tgsOld.getStudentList().size();
        int removedEntry = 0;
        for (int l = 0; l < initialSize; l++) {
            
            
            if(tgsOld.getStudentList().getEntry(l) != null){
                System.out.println(tgsOld.getStudentList());
                Student tempStd = tgsOld.getStudentList().getEntry(l);
                String name = tempStd.getName();
                String id = tempStd.getID();
                TutorialGroup tutorialgroup = tgsNew;
                Team team = tempStd.getTeam();


                tgsNew.addStudentList(new Student(name, id, tutorialgroup, team));
                removedEntry++;
            }

            
        }
        
        for(int l=0; l<removedEntry; l++){
            
            tgsOld.getStudentList().remove(0);
            
        }



    }
    
    public void listStudentTutorial(TutorialGroup[] tg, Programme[] pg, ListInterface<TutorialGroup> tutorialList, ListInterface<Programme> programmeList){
        
        int choice = stdUI.chooseWhichShow();
        
        if(choice == 1){
            
            int k = 0;
            int i = 0;
            
            Iterator<Programme> iterator = programmeList.iterator();
            
            while (iterator.hasNext()) {
                Comparable programme = iterator.next();

                System.out.println(i+1 + ". " + programme.toString());
                i++;
            }
            
            int chosen = stdUI.chooseProgramme();
            
            GroupManagementUI.clearScreen();
            System.out.println("==================================================================");
            System.out.printf("%-5s %-15s %-20s %-15s%n", "No", "Group", "Name", "ID");
            for (int j = 0; j < pg[chosen].getTutorialGroupList().size(); j++) {

                TutorialGroup tgs = pg[chosen].getTutorialGroupList().getEntry(j);
                
                    if(tgs != null){

                        Iterator<Student> iterator2 = tgs.getStudentList().iterator();

                        while (iterator2.hasNext()) {
                            
                            Student std = iterator2.next();
                            if(std != null){
                                
                                System.out.printf("%-5d %-15s %-20s %-15s%n", k+1, std.getTutorialGroup().getGroup(), std.getName(), std.getID());
                                k++;
                                
                            }

                        }
                        
                        if(tgs.getStudentList().isEmpty() && k > 0){
                            
                            System.out.println("==================================================================");
                            System.out.println(tgs.getGroup() + " is empty.");
                        
                        }else if(tgs.getStudentList().isEmpty() && k == 0){
                            
                            GroupManagementUI.clearScreen();
                            System.out.println("All groups are empty.");
                        
                        }
                    }
                    
                    

                
            }
            
  
            
        }else if(choice == 2){
            
            int i = 0;
            int j = 0;
            
            Iterator<Programme> iterator = programmeList.iterator();
            
            GroupManagementUI.clearScreen();
            while (iterator.hasNext()) {
                Comparable programme = iterator.next();

                System.out.println(i+1 + ". " + programme.toString());
                i++;
            }
            
            int chosen = stdUI.chooseProgramme();
            
            
            Iterator<TutorialGroup> iterator2 = pg[chosen].getTutorialGroupList().iterator();

            while (iterator2.hasNext()) {
                TutorialGroup tgList = iterator2.next();

                System.out.println(j+1 + ". " + tgList.toString());
                j++;
            }
                
    
            
            
            int choice2 = stdUI.inputChooseIterator();
            TutorialGroup chosenTG = pg[chosen].getTutorialGroupList().getEntry(choice2);

            if(chosenTG.getStudentList().isEmpty()){
                
                System.out.println("There are currently no students.");
            
            }else{

                System.out.println(chosenTG.getStudentList().toString());
            }

            
        }
        
        GroupManagementUI.enterCont();
        

        
    }
    
}
