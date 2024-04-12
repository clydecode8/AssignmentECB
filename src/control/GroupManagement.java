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
    
    
    public void runGroupManagement(){
        
        programmeT.initialiser();
        stdT.initialiser();
        int choice = 0;
        do {
          choice = groupUI.getMenuChoice();
          switch(choice) {
            case 0:
                MessageUI.displayExitMessage();
                break;

            case 1:
                int menuChoice = 0;
                
                do {
                    
                    menuChoice = programmeUI.getMenuChoice();
                    switch(menuChoice){
                        
                        case 0:
                            break;
                            
                        case 1:
                            
                            programmeT.addProgrammeTutorial();
                            break;
                            
                        case 2:
                            programmeT.removeProgrammeTutorial();
                            break;
                            
                        case 3:
                            programmeT.listProgrammeTutorial();
                            break;
                            
                        default:
                            MessageUI.displayInvalidChoiceMessage();
                            
                    }
                    
                }while (menuChoice != 0);
                
                break;
                
            case 2:
                
                int menuChoice2 = 0;
                
                do {
                    
                    menuChoice2 = studentUI.getMenuChoice();
                    switch(menuChoice2){
                        
                        case 0:
                            break;
                            
                        case 1:
                            
                            stdT.addStudentTutorial();
                            break;
                            
                        case 2:
                            stdT.removeStudentTutorial();
                            break;
                            
                        case 3:
                            stdT.changeStudentTutorial();
                            break;
                            
                        case 4:
                            stdT.mergeStudentTutorial();
                            break;
                            
                        case 5:
                            stdT.listStudentTutorial();
                            break;
                            
                            
                        default:
                            MessageUI.displayInvalidChoiceMessage();
                            
                    }
                    
                }while (menuChoice2 != 0);
                
                break;
                
            case 3:
                groupUI.summaryReport();
                break;
            default:
                MessageUI.displayInvalidChoiceMessage();
            } 
        
        }while (choice != 0);
    }
    
    public static void main(String[] args){
        
        GroupManagement gm = new GroupManagement();
        gm.runGroupManagement();
    }
}
