/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;


import adt.*;
import boundary.*;
import entity.*;
import utility.MessageUI;

/**
 *
 * @author User
 */
public class GroupManagement {
    

    private ListInterface<Student> studentList = new ArrayList<>();

    //private ListInterface<Student> studentList = new ArrayList<>();

    private GroupManagementUI groupUI = new GroupManagementUI();
    private ProgrammeTutorialUI programmeUI = new ProgrammeTutorialUI();
    private StudentTutorialUI studentUI = new StudentTutorialUI();
    private ProgrammeTutorial programmeT = new ProgrammeTutorial();
    private StudentTutorial stdT = new StudentTutorial();
    private GroupSummary groupsummary = new GroupSummary();
    private GroupSummaryUI gsUI = new GroupSummaryUI();
    
    private Programme[] pg;
    private TutorialGroup[] tg;
    private String[] group;
    private Student[] std;
    
    private ListInterface<Programme> programmeList;
    private ListInterface<TutorialGroup> tutorialList;
    
    
    public void runGroupManagement(){
        
        //stdT.initialiser();
        initialiser();
        int choice = 0;
        do {
            GroupManagementUI.clearScreen();
            choice = groupUI.getMenuChoice();
            switch(choice) {
            case 0:
                GroupManagementUI.clearScreen();
                MessageUI.displayExitMessage();
                break;

            case 1:
                int menuChoice = 0;
                
                do {
                    
                    GroupManagementUI.clearScreen();
                    menuChoice = programmeUI.getMenuChoice();
                    switch(menuChoice){
                        
                        case 0:
                            break;
                            
                        case 1:
                            
                            GroupManagementUI.clearScreen();
                            programmeT.addProgrammeTutorial(pg, tg, programmeList);
                            break;
                            
                        case 2:
                            GroupManagementUI.clearScreen();
                            programmeT.removeProgrammeTutorial(pg, programmeList);
                            break;
                            
                        case 3:
                            GroupManagementUI.clearScreen();
                            programmeT.listProgrammeTutorial(pg, programmeList);
                            break;
                            
                        default:
                            MessageUI.displayInvalidChoiceMessage();
                            
                    }
                    
                }while (menuChoice != 0);
                
                break;
                
            case 2:
                
                int menuChoice2 = 0;
                
                do {
                    
                    GroupManagementUI.clearScreen();
                    menuChoice2 = studentUI.getMenuChoice();
                    switch(menuChoice2){
                        
                        case 0:
                            break;
                            
                        case 1:
                            
                            GroupManagementUI.clearScreen();
                            stdT.addStudentTutorial(tg, pg, tutorialList);
                            break;
                            
                        case 2:
                            GroupManagementUI.clearScreen();
                            stdT.removeStudentTutorial(tg, pg, tutorialList);
                            break;
                            
                        case 3:
                            GroupManagementUI.clearScreen();
                            stdT.changeStudentTutorial(tg, pg, tutorialList);
                            break;
                            
                        case 4:
                            GroupManagementUI.clearScreen();
                            stdT.mergeStudentTutorial(tg, pg, tutorialList);
                            break;
                            
                        case 5:
                            GroupManagementUI.clearScreen();
                            stdT.listStudentTutorial(tg, pg, tutorialList);
                            break;
                            
                            
                        default:
                            MessageUI.displayInvalidChoiceMessage();
                            
                    }
                    
                }while (menuChoice2 != 0);
                
                break;
                
            case 3:
                GroupManagementUI.clearScreen();
                groupsummary.generateReport(pg, tg);
                break;
            default:
                MessageUI.displayInvalidChoiceMessage();
            } 
        
        }while (choice != 0);
    }
    
    public Object[] initialiser(){
        
        pg = new Programme[5];
        tg = new TutorialGroup[9];
        group = new String[3];
        std = new Student[6];
        programmeList = new ArrayList<>();
        tutorialList = new ArrayList<>();
        
        
        pg[0] = new Programme("Software Engineering", "2023/05");
        pg[1] = new Programme("Marketing", "2023/09");
        pg[2] = new Programme("Accounting", "2023/09");
    
        //Group for software engineering
        group = new String[]{"RSW01", "RSW02", "RSW03"};
        
        tg[0] = new TutorialGroup(group[0], 25, pg[0]);
        tg[1] = new TutorialGroup(group[1], 18, pg[0]);
        tg[2] = new TutorialGroup(group[2], 16, pg[0]);
       
        tg[3] = new TutorialGroup("MG01", 19, pg[1]);
        tg[4] = new TutorialGroup("MG02", 22, pg[1]);
        tg[5] = new TutorialGroup("MG03", 21, pg[1]);

        tg[6] = new TutorialGroup("ACC01", 23, pg[2]);
        tg[7] = new TutorialGroup("ACC02", 21, pg[2]);
        tg[8] = new TutorialGroup("ACC03", 20, pg[2]);
        

        Team team[] = new Team[6];
        team[0] = new Team("Robot team1", "Robot Development", tg[0]);
        team[1] = new Team("Robot team2", "Robot Development", tg[0]);
        team[2] = new Team("Robot team3", "Robot Development", tg[1]);
        team[3] = new Team("Gundam team1", "Robot Development", tg[1]);
        team[4] = new Team("Gundam team2", "Robot Development", tg[2]);
        team[5] = new Team("Gundam team3", "Robot Development", tg[2]);
        
        String name[] = new String[]{"Han", "Jack", "Bob", "Clyde", "Robert", "Janice"};
        String id[] = new String[]{"2213577", "2214577", "2215577", "2216177", "2216577", "2211577"};
        int j =0;
        for (int i = 0; i < id.length; i++) {
        
            std[i] = new Student(name[i], id[i], tg[j], team[i]);
            
            if(i == 2 || i == 4){
                
                j++;
                
            }

        }
        
        int k = 0;
        for (int i = 0; i < 3; i++) {
            
            
            tg[i].addStudentList(std[0+k]);
            tg[i].addStudentList(std[1+k]);
            
            k = k+2;
            
        }
        
        //0+1 go t0, 2+3 go t1, 4+5 go t2
        
        
        for (int i = 0; i < 3; i++) {
            
            pg[0].addTutorialGroupList(tg[i]);
            pg[1].addTutorialGroupList(tg[i+3]);
            pg[2].addTutorialGroupList(tg[i+6]);
        }
          
        
        for (int i = 0; i < tg.length; i++) {
             
            if(tg[i] != null && i < 3){

                //change this soon tq
                tg[i].setGroup(group[i]);
            }
            tutorialList.add(tg[i]); 
             
         }
        

                
        for (int i = 0; i < pg.length; i++) {
            
            if(pg[i] != null){
                
                programmeList.add(pg[i]);  
                
            }
        }  
        
        for (int i = 0; i < std.length; i++) {
            
            if(std[i] != null){
                
                std[i].setName(name[i]);
                std[i].setID(id[i]);
                std[i].setTeam(team[0]);
                 
                if(i == 0 || i == 1){
                    
                    std[i].setTutorialGroup(tg[0]);
                
                }else if(i == 2 || i == 3){
                    
                    
                    std[i].setTutorialGroup(tg[1]);
                
                }else if(i == 4 || i == 5){
                    
                    std[i].setTutorialGroup(tg[2]);
                } 
                
            }
        }
            
        return new Object[]{pg, tg};
            
    }
    
    
    
    public static void main(String[] args){
        
        GroupManagement gm = new GroupManagement();
        gm.runGroupManagement();
    }
}
