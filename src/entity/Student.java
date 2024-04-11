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

    @Override
    public int compareTo(Student o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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





}
