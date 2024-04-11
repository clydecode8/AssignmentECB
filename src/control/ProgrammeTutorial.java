/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.*;
import boundary.*;
import entity.*;
import java.util.Iterator;

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
        

        
      
    
    }
    
    public void removeProgrammeTutorial(){
        
        String name = "han";
        

    }
    
    public void listProgrammeTutorial(){
        
        String name = "han";
        
        
        
        //tutorialList.add(tg);
        tutorialList.add(new TutorialGroup(name, "12", 23, new Programme("FCP", "TEST")));
        tutorialList.add(new TutorialGroup("sd", "12", 23, new Programme("SD", "TEST")));
        tutorialList.add(new TutorialGroup("test", "12", 23,  new Programme("FCP", "TEST")));
        tutorialList.add(new TutorialGroup("ab", "12", 23, new Programme("FCP", "test")));
 
        //System.out.println("Index: " + tutorialList.getIndexOf(tg));
        
        tutorialList.replaceAll("ab", "RSW");
        tutorialList.sort(0);
        //System.out.println(tutorialList.getEntry(1));
        //tutorialList.twoCondSearch("12", "RSW", 1);
        //tutorialList.threeCondSearch("RSW", "12", "23", 3);

 
        
        //tutorialList.customRemove("RSW");
        //System.out.println(tutorialList.size());
        
        System.out.println(tutorialList.toString());
        // Iterate over the list
        Iterator<TutorialGroup> iterator = tutorialList.iterator();
        while (iterator.hasNext()) {
            Comparable tutorialGroup = iterator.next();
            // Do something with tutorialGroup...
            System.out.println(tutorialGroup.toString());
        }

    }
}
