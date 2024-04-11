/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import adt.ArrayList;
import java.util.Objects;

/**
 *
 * @author User
 */

public class Student implements Comparable<Student> {

  private String name;
  private String id;
  private TutorialGroup tutorialGroup;
  private Team team;
  private final static ArrayList<Student> studentList = new ArrayList<>();

  public Student() {
      
      name = "";
      id = "";
      tutorialGroup = null;
      team = null;
  }

  public Student(String name, String id, TutorialGroup tutorialGroup, Team team) {

    this.name = name;
    this.id = id;
    this.tutorialGroup = tutorialGroup;
    this.team = team;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getID() {
    return name;
  }

  public void setID(String id) {
    this.id = id;
  }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TutorialGroup getTutorialGroup() {
        return tutorialGroup;
    }

    public void setTutorialGroup(TutorialGroup tutorialGroup) {
        this.tutorialGroup = tutorialGroup;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(Student student) {
        studentList.add(student);
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-20s %-20s", group, qty, programme.toString());
    }
   

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Student other = (Student) obj;
        return Objects.equals(name, other.name) &&
                Objects.equals(id, other.id) &&
               Objects.equals(tutorialGroup, other.tutorialGroup);
    }
    
    

    @Override
    public int hashCode() {
        return Objects.hash(name, id, tutorialGroup);
    }

    @Override
    public int compareTo(Student other) {
        
        String thisName = this.getName();
        String otherName = other.getName();

        // Handle null values
        if (thisName == null && otherName == null) {
            
            return 0; // Both names are null, consider them equal
        
        }else if (thisName == null) {
            
            return -1; // This name is null, consider it less than the other name
        
        } else if (otherName == null) {
            
            return 1; // Other name is null, consider it greater than this name
        }

        // Compare based on the names
        return thisName.compareTo(otherName); 
    }



}
