/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.*;
import boundary.*;
import entity.*;

/**
 *
 * @author User
 */
public class ProgrammeTutorial {
    
    private ProgrammeTutorialUI programmeUI = new ProgrammeTutorialUI();
    private ListInterface<Student> studentList = new ArrayList<>();
    private ListInterface<Programme> programmeList = new ArrayList<>();
    private ListInterface<TutorialGroup> tutorialList = new ArrayList<>();
    
    private TutorialGroup tg = new TutorialGroup("Han", "12", 25, new Programme("FCP", "TEST"));
    
    public void addProgrammeTutorial(){
        

        
      
    
    }
    
    public void removeProgrammeTutorial(){
        
        String name = "han";
        

    }
    
    public void listProgrammeTutorial(){
        
        String name = "Han";
        
        
        
        tutorialList.add(tg);
        tutorialList.add(new TutorialGroup(name, "12", 23, new Programme("FCP", "TEST")));
        tutorialList.add(new TutorialGroup("sd", "12", 23, new Programme("FCP", "TEST")));
        tutorialList.add(new TutorialGroup("test", "12", 24,  new Programme("FCP", "TEST")));
        tutorialList.add(new TutorialGroup("ab", "12", 23, new Programme("FCP", "test")));
 
    
        tutorialList.customIntegerContains(23);
       
    }
}
