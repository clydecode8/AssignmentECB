/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import adt.ArrayList;
import adt.ArrayQueueInterface;
import adt.CustomArrayQueue;
import adt.LinkedList;
import adt.LinkedListInterface;
import adt.ListInterface;
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
    private final static ListInterface<Student> studentList = new ArrayList<>();
    private final static ArrayQueueInterface<Student> studentQueue = new CustomArrayQueue<>();
    private final static LinkedList<Student> studentListlinked = new LinkedList<>();
    private LinkedList<Course> courseListlinked = new LinkedList<>();

  public Student() {
      
      name = "";
      id = "";
      tutorialGroup = null;
      team = null;
  }
public Student(String name, String id) {

    this.name = name;
    this.id = id;
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
    return id;
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

    public ListInterface<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(Student student) {
        studentList.add(student);
        studentQueue.enqueue(student);
        studentListlinked.add(student);
    }
    
    public static ArrayQueueInterface<Student> getStudentQueue() {
        return studentQueue;
    }
    public LinkedList<Student> getStudentListlinked() {
        return studentListlinked;
    }
    
    public LinkedList<Course> getCourseList2() {
        return courseListlinked;
    }
    public void setCourseList2(LinkedList<Course> course){
        this.courseListlinked = course;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getNameId(){
        return String.format("%-10s %-20s", name, id);
    }
    
    @Override
    public String toString() {
        return String.format("%-10s %-20s %-20s %-20s", name, id, tutorialGroup.toString(), team.toString());
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
