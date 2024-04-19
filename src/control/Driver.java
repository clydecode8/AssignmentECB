/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import boundary.DriverUI;
import boundary.GroupManagementUI;
import utility.MessageUI;

/**
 *
 * @author User
 */
public class Driver {
    
    GroupManagement gm = new GroupManagement();
    AssTeam assTeam = new AssTeam();
    RegistrationManagement rm = new RegistrationManagement();
    
    DriverUI driverUI = new DriverUI();
    MessageUI msg = new MessageUI();
    
    public void runSystem(){
        
        boolean loop = true;
        
        while(loop == true){
            
            GroupManagementUI.clearScreen();
            int choice = driverUI.getMenuChoice();
            switch(choice){

                //Student Registration (yuan feng)
                case 1:
                    rm.RegistrationManagement();
                    break;
                    
                //Course Management (wei sheng)
                case 2:

                    break;

                //Tutorial Group Management (ming han)
                case 3:
                    gm.runGroupManagement();
                    break;

                //Teaching Assignment (khai dee)
                case 4:

                    break;

                //Assignment Team (yee jie)
                case 5:

                    assTeam.runAssTeam();
                    break;
                
                //Exit
                case 0:
                    loop = false;
                    break;

            }
            
        }

        
        GroupManagementUI.clearScreen();
        msg.displayExitMessage();
        
    }
    
    
    
    public static void main(String[] args){
        
        Driver dd = new Driver();
        dd.runSystem();
    }
    
    
}
