/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import adt.ArrayList;
import adt.CircularArrayList;
import adt.ListInterface;
import java.util.Objects;

/**
 *
 * @author User
 */

public class Programme implements Comparable<Programme>{
 
    private String name;
    private String yearIntake;
    private String faculty;
    private ListInterface<TutorialGroup> tgList = new ArrayList<>();
    private ListInterface<Course> courseList =new CircularArrayList<>();
    private  ListInterface<Programme> programmeList =new CircularArrayList<>();

    
    public ListInterface<Course> getCourseList() {
        return courseList;
    }
    
    public ListInterface<Programme> getProgrammeList() {
        return programmeList;
    }
    
    public Programme(){
        
        name = "";
        yearIntake = "";
    }
    
    public Programme(String name, String yearIntake,String faculty) {
        this.name = name;
        this.yearIntake = yearIntake;
        this.faculty=faculty;
    }
    
    public Programme(String name, String yearIntake) {
        this.name = name;
        this.yearIntake = yearIntake;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public ListInterface<TutorialGroup> getTgList() {
        return tgList;
    }

    public void setTgList(ListInterface<TutorialGroup> tgList) {
        this.tgList = tgList;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearIntake() {
        return yearIntake;
    }

    public void setYearIntake(String yearIntake) {
        this.yearIntake = yearIntake;
    }

   public ListInterface<TutorialGroup> getTutorialGroupList() {
        return tgList;
    }

    public void addTutorialGroupList(TutorialGroup tg) {
        tgList.add(tg);
    }
    
    public void setProgrammeList(Programme programme) {
        programmeList.add(programme);
    }
    
    @Override
    public String toString() {
        return String.format("Programme Name: %-25s Year of Intake: %-15s", name, yearIntake);
    }
   
    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Programme other = (Programme) obj;
        return Objects.equals(name, other.name) &&
               Objects.equals(yearIntake, other.yearIntake);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, yearIntake);
    }

    @Override
    public int compareTo(Programme o) {
       // Compare based on the name of the Programme
       return this.getYearIntake().compareTo(o.getYearIntake());
    }
}
