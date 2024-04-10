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
    
    private TutorialGroup tg = new TutorialGroup("Han", "12", new Programme("FCP", "TEST"));
    
    public void addProgrammeTutorial(){
        
        String name = "han";
        
            tutorialList.add(new TutorialGroup(name, "12", new Programme("FCP", "TEST")));
            
            if(!tutorialList.isEmpty()){
                
                System.out.println("worked");
                System.out.println(tutorialList.getEntry(1).toString());
            } 
        
        
        
    
    }
    
    public void removeProgrammeTutorial(){
        
        String name = "han";
        
        
        tutorialList.add(new TutorialGroup(name, "12", new Programme("FCP", "TEST")));
        tutorialList.add(new TutorialGroup("deleted", "12", new Programme("FCP", "TEST")));
        tutorialList.add(1, new TutorialGroup("test", "12", new Programme("FCP", "TEST")));

        if(!tutorialList.isEmpty()){

            System.out.println("Before Removal");
            System.out.println(tutorialList.toString());
            tutorialList.remove(0);
            System.out.println("After Removal");
            System.out.println(tutorialList.isEmpty());
            System.out.println(tutorialList.size());
            tutorialList.remove(0);
            tutorialList.remove(0);
            System.out.println(tutorialList.toString());
            System.out.println(tutorialList.size());

        } 
    }
    
    public void listProgrammeTutorial(){
        
        String name = "Han";
        
        
        
        tutorialList.add(tg);
        tutorialList.add(new TutorialGroup(name, "12", new Programme("FCP", "TEST")));
        tutorialList.add(new TutorialGroup("test", "12", new Programme("FCP", "TEST")));
        tutorialList.add(new TutorialGroup("test", "23", new Programme("FCP", "TEST")));
        tutorialList.add(new TutorialGroup("ab", "12", new Programme("FCP", "test")));
 
        System.out.println(tg.toString());
        tutorialList.customContains("FCP");

       
    }
}
