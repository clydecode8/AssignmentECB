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
        
        String name = "han";
        
        tutorialList.add(new TutorialGroup(name, "12", new Programme("FCP", "TEST")));
        tutorialList.add(new TutorialGroup("test", "12", new Programme("FCP", "TEST")));
 
        System.out.println(tutorialList.getEntry(1));
        System.out.println("this is " + tutorialList.contains(new TutorialGroup("test", "12", new Programme("FCP", "TEST"))));
        
        System.out.println(tutorialList.getNumberOfEntries());
        tutorialList.replace(0, new TutorialGroup("newlyadded", "12", new Programme("FCP", "TEST")));
        System.out.println(tutorialList.getIndexOf(new TutorialGroup("newlyadded", "12", new Programme("FCP", "TEST"))));
        System.out.println(tutorialList.toString());
        System.out.println(tutorialList.getEntry(2));
    
        
       
    }
}
