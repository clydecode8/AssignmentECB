/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.ArrayList;
import adt.ListInterface;
import boundary.GroupManagementUI;
import boundary.GroupSummaryUI;
import boundary.ProgrammeTutorialUI;
import entity.Programme;
import entity.Student;
import entity.TutorialGroup;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class GroupSummary {

    private GroupSummaryUI gsUI = new GroupSummaryUI();
    
    public void generateReport(Programme[] pg, TutorialGroup[] tg){
        
        int choice = gsUI.summaryReport();
        
        if(choice == 1){
            
            int leastAmount[] = new int[3];
            String leastGroup[] = new String[3];
            String leastIntake[] = new String[3];
            
            int group1[] = new int[20];
            String leastGroup1[] = new String[20];
            String leastGroup2[] = new String[20];
            String leastGroup3[] = new String[20];
            int group2[] = new int[20];
            int group3[] = new int[20];
   
            
            //Only have 3 programmes
            int j = 0;
            
            int chooseSort = gsUI.chooseSort();
            GroupManagementUI.clearScreen();
            System.out.println("=====================================================================================================");
            System.out.printf("%75s%n", "TUNKU ABDUL RAHMAN UNIVERSITY OF MANAGEMENT AND TECHNOLOGY");
            System.out.printf("%55s%n", "TUTORIAL GROUP SUBSYSTEM");
            System.out.println("");
            System.out.printf("%61s%n", "[----------------------------------]");
            System.out.printf("%54s%n", "TUTORIAL GROUP REPORT");
            System.out.printf("%61s%n", "[----------------------------------]");

            System.out.println("=====================================================================================================");
            System.out.printf("%-4s | %-13s | %-10s | %-20s | %-12s%n", "No.", "Intake Year", "Group", "Number of Students", "Programme");
            System.out.println("=====================================================================================================");
            
            for(int i = 0; i < 3; i++){
                
                int k = 0;
                pg[i].getTutorialGroupList().sort(chooseSort-1);
                leastAmount[i] = 999;
                Iterator<TutorialGroup> iterator = pg[i].getTutorialGroupList().iterator();
                    while (iterator.hasNext()) {
                        TutorialGroup tgLoop = iterator.next();

                        System.out.printf("%-4d | %-13s | %-10s | %-20d | %-12s%n", 
                                j+1, 
                                tgLoop.getProgramme().getYearIntake(),
                                tgLoop.getGroup(), 
                                tgLoop.getQty(), 
                                tgLoop.getProgramme().getName()
                                );
                        j++;

                        if(tgLoop.getQty() < leastAmount[i]){
                            
                            leastAmount[i] = tgLoop.getQty();
                            leastGroup[i] = tgLoop.getGroup();
                            leastIntake[i] = tgLoop.getProgramme().getYearIntake();
                        
                            if(i+1 == 1 && leastGroup1[0] != null){
                               
                               
                                if(leastAmount[i] <= tgLoop.getQty()){
                                    
                                    for (int l = 0; l < leastGroup1.length; l++) {

                                        if(leastGroup1[l] != null){

                                            group1[l] = 0;
                                            leastGroup1[l] = null;
                                        }

                                    } 
                                    
                                }
 
                            }else if(i+1 == 2 && leastGroup2[0] != null){
                                
                                if(leastAmount[i] <= tgLoop.getQty()){
                                    
                                    for (int l = 0; l < leastGroup2.length; l++) {

                                        if(leastGroup2[l] != null){

                                            group2[l] = 0;
                                            leastGroup2[l] = null;
                                        }

                                    } 
                                    
                                }

                            }else if(i+1 == 3 && leastGroup3[0] != null){
                                
                                if(leastAmount[i] <= tgLoop.getQty()){
                                    
                                    for (int l = 0; l < leastGroup3.length; l++) {

                                        if(leastGroup3[l] != null){

                                            group3[l] = 0;
                                            leastGroup3[l] = null;
                                        }

                                    } 
                                    
                                }

                            }
                            
                        }else if(tgLoop.getQty() == leastAmount[i]){
                            
                            
                            if(i+1 == 1){
                               
                                group1[k] = tgLoop.getQty();
                                leastGroup1[k] = tgLoop.getGroup();
                                k++;
 
                            }else if(i+1 == 2){
                                
                                group2[k] = tgLoop.getQty();
                                leastGroup2[k] = tgLoop.getGroup();
                                k++;
                                                    
                            }else if(i+1 == 3){
                                
                                group3[k] = tgLoop.getQty();
                                leastGroup3[k] = tgLoop.getGroup();
                                k++;
                            }
                        }
                    }
                    
                
                
            }
            
            
            System.out.println("=====================================================================================================");
            System.out.println("|<Least Amount of Students>|");
            System.out.println("=====================================================================================================");
            for (int i = 0; i < 3; i++) {
                
                boolean status = false;
                switch(i+1){
                    
                    case 1:
                       if(leastGroup1[0] == null){
                           
                           status = true;
                       } 
                       
                    case 2:
                        
                       if(leastGroup2[0] == null){
                           
                           status = true;
                       } 
                       
                    case 3:
                       if(leastGroup3[0] == null){
                           
                           status = true;
                       } 
                }
                
                if(status == false){
                    
                    System.out.printf("-> [Intake: (%3s)] = [Students: %d]%n", leastIntake[i], leastAmount[i]);
                    
                }else{
                    
                    System.out.printf("-> [Group: %5s (%3s)] = [Students: %d]%n", leastGroup[i], leastIntake[i], leastAmount[i]);
                    
                }
                
                System.out.println("Info: ");
                
                switch(i+1){
                    
                    case 1:
                        pg[i].getTutorialGroupList().twoCondSearch(leastGroup[0], String.valueOf(group1[i]), 2);
                       
                    case 2:
                        pg[i].getTutorialGroupList().twoCondSearch(leastGroup[1], String.valueOf(group2[i]), 2);
                        
                    case 3:
                        pg[i].getTutorialGroupList().twoCondSearch(leastGroup[2], String.valueOf(group3[i]), 2);
                        
                        
                }
                
                
                //Duplicates
                if(i+1 == 1 && leastGroup1[0] != null){
                    
                    for (int k = 0; k < leastGroup1.length; k++) {
                    
                        if(leastGroup1[k] != null){
                            
                            pg[i].getTutorialGroupList().twoCondSearch(leastGroup1[k], String.valueOf(group1[k]), 2);
                        }
                    
                    }
                    
                }else if(i+1 == 2 && leastGroup2[0] != null){
                    
                    for (int k = 0; k < leastGroup2.length; k++) {
                    
                        if(leastGroup2[k] != null){
                            
                            
                            pg[i].getTutorialGroupList().twoCondSearch(leastGroup2[k], String.valueOf(group2[k]), 2);
                        }
                    
                    }
                    
                }else if(i+1 == 3 && leastGroup3[0] != null){
                    
                    for (int k = 0; k < leastGroup3.length; k++) {
                    
                        if(leastGroup3[k] != null){
                            
                            pg[i].getTutorialGroupList().twoCondSearch(leastGroup3[k], String.valueOf(group3[k]), 2);
                        }
                    
                    }                   
                    
                }
                
                

                
                System.out.println("-----------------------------------------------------------------------------------------------------");
            }
            
            System.out.println("");
            System.out.printf("%54s%n", "END OF TUTORIAL GROUP REPORT");
            System.out.println("=====================================================================================================");
            System.out.println("");
            GroupManagementUI.enterCont();
            
        }else if (choice == 2){
            
            
            int chooseSort = gsUI.chooseSort();
            
            GroupManagementUI.clearScreen();
            System.out.println("=====================================================================================================");
            System.out.printf("%75s%n", "TUNKU ABDUL RAHMAN UNIVERSITY OF MANAGEMENT AND TECHNOLOGY");
            System.out.printf("%55s%n", "TUTORIAL GROUP SUBSYSTEM");
            System.out.println("");
            System.out.printf("%61s%n", "[----------------------------------]");
            System.out.printf("%54s%n", "TUTORIAL GROUP REPORT");
            System.out.printf("%61s%n", "[----------------------------------]");

            for(int i = 0; i < 3; i++){
                
                
                pg[i].getTutorialGroupList().sort(chooseSort-1);
                Iterator<TutorialGroup> iterator = pg[i].getTutorialGroupList().iterator(); 
                
                System.out.println("");
                System.out.println("=====================================================================================================");
                System.out.printf("Programme: %-40s  Year Intake: %-15s%n", 
                                   pg[i].getName(), 
                                   pg[i].getYearIntake());
                System.out.println("=====================================================================================================");
                System.out.printf("%-20s | %-15s | %-10s |%n", 
                                   "Group",
                                    "Student Name", 
                                   "ID"
                                   );
                System.out.println("=====================================================================================================");

                
                while (iterator.hasNext()) {
                    TutorialGroup tgLoop = iterator.next();



                    Iterator<Student> iterator2 = tgLoop.getStudentList().iterator();
                    

                    while(iterator2.hasNext()){

                        Student std = iterator2.next();



                        System.out.printf("%-20s | %-15s | %-10s |%n", 
                                std.getTutorialGroup().getGroup(),           
                                std.getName(), 
                                           std.getID()
                                           );



                    }
                    
                    if(tgLoop.getStudentList().isEmpty()){

                        System.out.println("[--------------------------------------EMPTY----------------------------]");
                        break;
                    }

                }
                



            }
            
            System.out.println("");
            System.out.println("=====================================================================================================");
            System.out.println("");    
            System.out.println("Empty Tutorial Groups: ");
            
            int empty = 0;
            for (int i = 0; i < 3; i++) {
                
                Iterator<TutorialGroup> iterator = pg[i].getTutorialGroupList().iterator(); 
                while (iterator.hasNext()) {
                    TutorialGroup tgLoop = iterator.next();

                    if(tgLoop.getStudentList().isEmpty()){

                        System.out.println(tgLoop.getGroup() + " -----------> " + tgLoop.getProgramme().getYearIntake());
                        empty++;
                    }

                }
                
            }
            System.out.println("Total Empty: " + empty);
            System.out.println("");
            System.out.printf("%54s%n", "END OF TUTORIAL GROUP REPORT");
            System.out.println("=====================================================================================================");
            System.out.println("");
            GroupManagementUI.enterCont();
            /*
            
            for (int i = 0; i < pg.length; i++) {

                if(pg[i] != null){


                    for (int j = 0; j < pg[i].getTutorialGroupList().size(); j++) {
                        TutorialGroup tutorialGroup = tg[j];
                        System.out.println(pg[i].getTutorialGroupList());
                        TutorialGroup tgs = pg[i].getTutorialGroupList().getEntry(j);
                        Iterator<Student> iterator = tgs.getStudentList().iterator();
                        int k = 0;
                        while (iterator.hasNext()) {
                            Comparable tl = iterator.next();

                            System.out.println(k+1 + ". " + tl.toString());
                            k++;
                        }

                    }



                }




            }

            for (int i = 0; i < tg.length; i++) {

                if(tg[i] != null){

                    System.out.println(tg[i].getStudentList());
                }


            }
*/
        }else if (choice == 3){
            
            
            int[] totalStudents = new int[3];
            int[] totalGroups = new int[3];
            String leastGroup[] = new String[3];
            String leastIntake[] = new String[3];
            
            GroupManagementUI.clearScreen();
            System.out.println("=====================================================================================================");
            System.out.printf("%75s%n", "TUNKU ABDUL RAHMAN UNIVERSITY OF MANAGEMENT AND TECHNOLOGY");
            System.out.printf("%55s%n", "TUTORIAL GROUP SUBSYSTEM");
            System.out.println("");
            System.out.printf("%61s%n", "[----------------------------------]");
            System.out.printf("%54s%n", "TUTORIAL GROUP REPORT");
            System.out.printf("%61s%n", "[----------------------------------]");
            
            for(int i = 0; i < 3; i++){
                
                
                Iterator<TutorialGroup> iterator = pg[i].getTutorialGroupList().iterator(); 
                
                System.out.println("");
                System.out.println("=====================================================================================================");
                System.out.printf("Programme: %-40s  Year Intake: %-15s%n", 
                                   pg[i].getName(), 
                                   pg[i].getYearIntake());
                System.out.println("");
                while (iterator.hasNext()) {
                    TutorialGroup tgLoop = iterator.next();



                    totalGroups[i]++;
                    Iterator<Student> iterator2 = tgLoop.getStudentList().iterator();
                    

                    while(iterator2.hasNext()){
                        totalStudents[i]++;
                        Student std = iterator2.next();

                    }
                    

                }
                


                System.out.printf("Total Students: %-10d | Total Groups: %-10d%n", totalStudents[i], totalGroups[i]);
                System.out.printf("%s%n", "=====================================================================================================");
                
            }
            
            System.out.println("");
            System.out.printf("%54s%n", "END OF TUTORIAL GROUP REPORT");
            System.out.println("=====================================================================================================");
            System.out.println("");
            GroupManagementUI.enterCont();
        }


        for (int i = 0; i < 3; i++) {
            
            pg[i].getTutorialGroupList().sort(0);
            
        }
        
        
    }
}
