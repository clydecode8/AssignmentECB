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
                        }
                    }
                    
                
                
            }
            
            
            System.out.println("=====================================================================================================");
            System.out.println("|<Least Amount of Students>|");
            System.out.println("=====================================================================================================");
            for (int i = 0; i < leastAmount.length; i++) {
 
                System.out.printf("-> [Group: %5s (%3s)] = [Students: %d]%n", leastGroup[i], leastIntake[i], leastAmount[i]);
                System.out.println("Info: ");
                pg[i].getTutorialGroupList().twoCondSearch(leastGroup[i], String.valueOf(leastAmount[i]), 2);
                System.out.println("-----------------------------------------------------------------------------------------------------");
            }
            System.out.println("");
            System.out.printf("%54s%n", "END OF TUTORIAL GROUP REPORT");
            System.out.println("=====================================================================================================");
            System.out.println("");
            
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
                System.out.printf("%-20s | %-10s | %-10s |%n", 
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



                        System.out.printf("%-20s | %-10s | %-10s |%n", 
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
            
            int chooseSort = gsUI.chooseSort();
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
                
                
                pg[i].getTutorialGroupList().sort(chooseSort-1);
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
        }


        System.out.println("Press Enter to continue...");

        // Wait for user to press Enter
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
