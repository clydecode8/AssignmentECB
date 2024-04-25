/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import adt.*;
import DAO.*;
import entity.*;


/**
 *
 * @author deede
 */
public class CourseTutorCombineInitializer {
    private TutorInitializer tutorinitial = new TutorInitializer();
    private CourseInitializer courseinitial =new CourseInitializer();
    private TutorialGroupInitializer tutorgrpinitial =new TutorialGroupInitializer();


    public SortedLinkedListInterface<CourseTutorCombine> initializeCourseTutorCombine(){
        SortedLinkedListInterface<CourseTutorCombine> ctcList = new SortedLinkedList<>();
        SortedLinkedListInterface<Tutor> tList = new SortedLinkedList<>();
        SortedLinkedListInterface<TutorialGroup> tgList = new SortedLinkedList<>();
        SortedLinkedListInterface<Course> cList = new SortedLinkedList<>();

        tList = tutorinitial.initializeTutor();
        cList = courseinitial.initializeCourse();
        tgList = tutorgrpinitial.initializeTutorialGroup();


        for (int i = 1; i <= tList.getNumberOfEntries(); i++) {
            Tutor tutor = tList.getEntry(i);
            Course course = cList.getEntry(i);
            TutorialGroup tgroup = tgList.getEntry(i);
            ctcList.add(new CourseTutorCombine(tutor, course, tgroup, 'L'));
        }
        
  
        return ctcList;
    }
}
        




