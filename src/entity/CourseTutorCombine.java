/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import adt.SortedLinkedList;
import adt.SortedLinkedListInterface;
import java.util.Objects;

/**
 *
 * @author deede
 */
public class CourseTutorCombine implements Comparable<CourseTutorCombine>{
    private Tutor tutor;
    private Course course;
    private TutorialGroup tutorialgroup;
    private char type;
    private static SortedLinkedListInterface<CourseTutorCombine> courseTutorCombineList = new SortedLinkedList<>();

    public CourseTutorCombine() {
        
        this.tutor = null;
        this.course = null;
        this.tutorialgroup = null;
    
    }
    public CourseTutorCombine(Tutor tutor, Course course,char type) {
        this.tutor = tutor;
        this.course = course;
        this.type = type;
    }
    public CourseTutorCombine(Tutor tutor, Course course) {
        this.tutor = tutor;
        this.course = course;
    }
    
    public CourseTutorCombine( TutorialGroup tutorialgroup) {
        this.tutorialgroup = tutorialgroup;
    }
    
    public CourseTutorCombine(Tutor tutor, Course course, TutorialGroup tutorialgroup) {
        this.tutor = tutor;
        this.course = course;
        this.tutorialgroup = tutorialgroup;
    }
    public CourseTutorCombine(Tutor tutor, Course course, TutorialGroup tutorialgroup,char type) {
        this.tutor = tutor;
        this.course = course;
        this.tutorialgroup = tutorialgroup;
        this.type = type;
    }

    public CourseTutorCombine(Tutor tutor, TutorialGroup tutorialgroup) {
        this.tutor = tutor;
        this.tutorialgroup = tutorialgroup;
        this.course = null;
    }
    
    

    public TutorialGroup getTutorialgroup() {
        return tutorialgroup;
    }

    public void setTutorialgroup(TutorialGroup tutorialgroup) {
        this.tutorialgroup = tutorialgroup;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public SortedLinkedListInterface<CourseTutorCombine> getCourseTutorCombineList() {
        return courseTutorCombineList;
    }

    public void setCourseTutorCombineList(CourseTutorCombine coursetutor) {
        courseTutorCombineList.add(coursetutor);
    }
    
    public void removeCourseTutorCombineList(CourseTutorCombine coursetutor){
        courseTutorCombineList.removeItem(coursetutor);
    }
    
    public void addTutorCombine(CourseTutorCombine newEntry){
        courseTutorCombineList.add(newEntry);
    }
    @Override
    public int compareTo(CourseTutorCombine other) {
        // Compare by course name
//        String thisCourseName = this.course.getCourseName();
//        String otherCourseName = other.course.getCourseName();
//
//        // Using String's compareTo method for natural string ordering
//        int compareByCourseName = thisCourseName.compareTo(otherCourseName);
//
//        if (compareByCourseName != 0) {
//            // If course names are different, return the comparison result
//            return compareByCourseName;
//        } else {
//            // If course names are the same, compare by tutor name
//            String thisTutorName = this.tutor.getTutorName();
//            String otherTutorName = other.tutor.getTutorName();
//            return thisTutorName.compareTo(otherTutorName);
//        }
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CourseTutorCombine that = (CourseTutorCombine) obj;
        return type == that.type &&
               Objects.equals(tutor, that.tutor) &&
               Objects.equals(course, that.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tutor, course, type);
    }

    


    
}

