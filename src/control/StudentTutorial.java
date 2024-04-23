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
            int chosen = stdUI.chooseProgramme();
                
            //Choose a tutorial group
            GroupManagementUI.clearScreen();
            System.out.println("====================================================================");
            Iterator<TutorialGroup> iterator2 = pg[chosen].getTutorialGroupList().iterator();
            int k = 0;
            int max = 0;
            System.out.printf("%-5s %-12s %-15s%n", "No", "Group", "Total Students");
            while (iterator2.hasNext()) {
                
                TutorialGroup tl = iterator2.next();
                System.out.printf("%-5d %-12s %-15d%n", k+1, tl.getGroup(), tl.getQty());
                k++;
                max++;
            }
            System.out.println("====================================================================");
            int choice2 = stdUI.inputAddIterator(max);
            
            
            
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
                
                tgs.setQty(tgs.getQty() + 1);
                System.out.println("Entry successfully added.");
                GroupManagementUI.enterCont();
                GroupManagementUI.clearScreen();
            
            }else{
                
                System.out.println("Entry adding is unsuccessful.");
            }
        }  
            
        
    }
    
    public void removeStudentTutorial(TutorialGroup[] tg, Programme[] pg, ListInterface<TutorialGroup> tutorialList, ListInterface<Programme> programmeList){
        
        int cond = stdUI.chooseWhichRemove();
        
        
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
            int chosen = stdUI.chooseProgramme();
            
            
            //Choose which tutorial group to remove
            GroupManagementUI.clearScreen();
            Iterator<TutorialGroup> iterator2 = pg[chosen].getTutorialGroupList().iterator();
            int k = 0;
            System.out.println("====================================================================");
            System.out.printf("%-5s %-12s %-15s%n", "No", "Group", "Total Students");
            while (iterator2.hasNext()) {
                
                TutorialGroup tl = iterator2.next();
                System.out.printf("%-5d %-12s %-15d%n", k+1, tl.getGroup(), tl.getQty());
                k++;
                
            }
            System.out.println("====================================================================");
            int choice = stdUI.inputRemoveIterator();
            
            
            if(!pg[chosen].getTutorialGroupList().getEntry(choice).getStudentList().isEmpty()){
            
            
                TutorialGroup tgs = pg[chosen].getTutorialGroupList().getEntry(choice);
                int j = 0;

                //Choose student
                GroupManagementUI.clearScreen();
                System.out.println("====================================================================");
                System.out.printf("%-5s %-20s %-20s%n", "No", "Name", "ID");
                Iterator<Student> iterator3 = tgs.getStudentList().iterator();
                while (iterator3.hasNext()) {
                    Student studentOutput = iterator3.next();

                    System.out.printf("%-5d %-20s %-20s%n", j+1, studentOutput.getName(), studentOutput.getID());
                    j++;
                }    
                System.out.println("====================================================================");
                int removal = stdUI.inputChooseName();

                Student test = tgs.getStudentList().remove(removal);

                if(test == null){

                    System.out.println("Entry removal unsuccessful.");
                }else{

                    int qty = tgs.getQty() - 1;
                    tgs.setQty(qty);
                    System.out.println("Entry removal successful.");
                    GroupManagementUI.enterCont();
                    GroupManagementUI.clearScreen();
                }
                
            }else{
                
                GroupManagementUI.clearScreen();
                System.out.print("There are currently no students in this tutorial group.");
                GroupManagementUI.enterCont();
            }
           
            
        }
        
    }
    
    public void changeStudentTutorial(TutorialGroup[] tg, Programme[] pg, ListInterface<TutorialGroup> tutorialList, ListInterface<Programme> programmeList){
        
        int cond = stdUI.chooseWhichChange();
        if(cond == 1){
            
            //Choose Programme
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
            int chosen = stdUI.chooseProgramme();
            
            //Loop through the first specific tutorialgroup
            GroupManagementUI.clearScreen();
            Iterator<TutorialGroup> iterator2 = pg[chosen].getTutorialGroupList().iterator();
            int k = 0;
            System.out.println("====================================================================");
            System.out.printf("%-5s %-12s %-15s%n", "No", "Group", "Total Students");
            while (iterator2.hasNext()) {
                
                TutorialGroup tl = iterator2.next();
                System.out.printf("%-5d %-12s %-15d%n", k+1, tl.getGroup(), tl.getQty());
                k++;
                
            }
            System.out.println("====================================================================");
            int choice = stdUI.inputChangeIterator();
            
            if(!pg[chosen].getTutorialGroupList().getEntry(choice).getStudentList().isEmpty()){
                
                TutorialGroup tgs = pg[chosen].getTutorialGroupList().getEntry(choice);
            
                //Choose student
                GroupManagementUI.clearScreen();
                System.out.println("====================================================================");
                System.out.printf("%-5s %-20s %-20s%n", "No", "Name", "ID");
                int j = 0;
                Iterator<Student> iterator3 = tgs.getStudentList().iterator();
                while (iterator3.hasNext()) {
                    Student studentOutput = iterator3.next();

                    System.out.printf("%-5d %-20s %-20s%n", j+1, studentOutput.getName(), studentOutput.getID());
                    j++;
                }    
                System.out.println("====================================================================");
                int chg = stdUI.chooseStudent();

                //Loop second tutorialgroup
                GroupManagementUI.clearScreen();
                Iterator<TutorialGroup> iterator4 = pg[chosen].getTutorialGroupList().iterator();
                int l = 0;
                int max = 0;
                System.out.println("====================================================================");
                System.out.printf("%-5s %-12s %-15s%n", "No", "Group", "Total Students");
                while (iterator4.hasNext()) {

                    TutorialGroup tl = iterator4.next();


                    System.out.printf("%-5d %-12s %-15d%n", l+1, tl.getGroup(), tl.getQty());
                    l++;
                    max++;
                }
                System.out.println("====================================================================");
                int ans = stdUI.inputChangeIteratorFindTG(max, choice);

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

                    tgsNew.setQty(tgsNew.getQty() + 1);
                    tgsOld.setQty(tgsOld.getQty() - 1);
                    System.out.println("Entry changed successful.");
                    GroupManagementUI.enterCont();
                    GroupManagementUI.clearScreen();
                }
                
            }else{
                
                GroupManagementUI.clearScreen();
                System.out.println("There are currently no students.");
                GroupManagementUI.enterCont();
            
            }
        
            
        }
        
    }
    
    public void mergeStudentTutorial(TutorialGroup[] tg, Programme[] pg, ListInterface<TutorialGroup> tutorialList, ListInterface<Programme> programmeList){
        
        int mergechoose = stdUI.chooseWhichMerge();
        
        if(mergechoose == 1){
            
            
            //Choose programme
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
            int chosen = stdUI.chooseProgramme();

            //Choose tutorialgroup
            GroupManagementUI.clearScreen();
            Iterator<TutorialGroup> iterator2 = pg[chosen].getTutorialGroupList().iterator();
            int j = 0;
            System.out.println("====================================================================");
            System.out.printf("%-5s %-12s %-15s%n", "No", "Group", "Total Students");
            while (iterator2.hasNext()) {
                
                TutorialGroup tl = iterator2.next();
                System.out.printf("%-5d %-12s %-15d%n", j+1, tl.getGroup(), tl.getQty());
                j++;
                
            }
            System.out.println("====================================================================");
            int choice = stdUI.inputMergeIterator();

            if(!pg[chosen].getTutorialGroupList().getEntry(choice).getStudentList().isEmpty()){
                
                //Choose tutorialgroup
                GroupManagementUI.clearScreen();
                Iterator<TutorialGroup> iterator3 = pg[chosen].getTutorialGroupList().iterator();
                int k = 0;
                System.out.println("====================================================================");
                System.out.printf("%-5s %-12s %-15s%n", "No", "Group", "Total Students");
                while (iterator3.hasNext()) {

                    TutorialGroup tl = iterator3.next();
                    System.out.printf("%-5d %-12s %-15d%n", k+1, tl.getGroup(), tl.getQty());
                    k++;

                }
                System.out.println("====================================================================");
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
                
                Student test = null;
                for(int l=0; l<removedEntry; l++){

                    test = tgsOld.getStudentList().remove(0);

                }
                
                if(test != null){
                    
                    tgsNew.setQty(tgsNew.getQty() + removedEntry);
                    tgsOld.setQty(tgsOld.getQty() - removedEntry);
                    System.out.println("Change successful!");
                    GroupManagementUI.enterCont();
                    GroupManagementUI.clearScreen();
                }else{
                    
                    System.out.println("Change is unsuccessful.");
                }

                
                
                
            }else{
                
                
                GroupManagementUI.clearScreen();
                System.out.print("There are no students in the tutorial group.");
                GroupManagementUI.enterCont();
            }
            

        }    

    }
    
    public void listStudentTutorial(TutorialGroup[] tg, Programme[] pg, ListInterface<TutorialGroup> tutorialList, ListInterface<Programme> programmeList){
        
        int choice = stdUI.chooseWhichShow();
        
        if(choice == 1){
            
            int k = 0;
            int i = 0;
            
            Iterator<Programme> iterator = programmeList.iterator();
            
            GroupManagementUI.clearScreen();
            System.out.println("==================================================================");
            System.out.printf("%-5s %-30s %-20s%n", "No", "Programme Name", "Year of Intake");
            System.out.println("==================================================================");
            while (iterator.hasNext()) {
                Programme programme = iterator.next();

                System.out.printf("%-5s %-30s %-20s%n", i+1, programme.getName(), programme.getYearIntake());
                
                i++;
            }
            
            System.out.println("==================================================================");
            int chosen = stdUI.chooseProgramme();
            
            GroupManagementUI.clearScreen();
            System.out.println("==================================================================");
            System.out.println("==================================================================");
            System.out.printf("%-5s %-15s %-20s %-15s%n", "No", "Group", "Name", "ID");
            System.out.println("==================================================================");
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
            System.out.println("==================================================================");
            GroupManagementUI.enterCont();
            
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

            GroupManagementUI.enterCont();
        }

    }
    
}
