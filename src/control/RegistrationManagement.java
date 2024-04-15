/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package control;

import boundary.RegistrationManagementUI;
import adt.LinkedList;
import entity.Course;
import entity.Programme;
import entity.Student;
import entity.Team;
import entity.TutorialGroup;
import java.util.Scanner;
import utility.MessageUI;
/**
 *
 * @author yuanf
 */
public class RegistrationManagement {
    Scanner scanner = new Scanner(System.in);
    private RegistrationManagementUI rmUI = new RegistrationManagementUI();
    private Student student = new Student();
    private TutorialGroup tg = new TutorialGroup();
    private Course course = new Course();
    private Team team = new Team();
    
    public void RegistrationManagement(){
        Programme p1 = new Programme("Software Engineering", "FOCS");
        TutorialGroup g1 = new TutorialGroup("Group 1", 24, p1);
        TutorialGroup g2 = new TutorialGroup("Group 2", 24, p1);
        TutorialGroup g3 = new TutorialGroup("Group 3", 24, p1);
        TutorialGroup g4 = new TutorialGroup("Group 4", 24, p1);

        Team t1 = new Team("Robot team1", "Robot Development", g1);
        Team t2 = new Team("Robot team2", "Robot Development", g1);
        Team t3 = new Team("Robot team3", "Robot Development", g1);
        Team t4 = new Team("Gundam team1", "Robot Development", g2);

        
        Student stud1 = new Student("John", "WPF33232", g1, t1);
        Student stud2 = new Student("Alex", "WPF12344", g1, t1);
        Student stud3 = new Student("Lex", "WPF22534", g1, t1);
        Student stud4 = new Student("Pearl", "WPF54565", g1, t1);
        Student stud5 = new Student("Max", "WPF532432", g1, t1);                
        Student stud6 = new Student("Jeremy", "WPF532323", g1, t1);
        
        Course course1 = new Course("ACCOUNT","12345","ACCOUNT",null);
        Course course2 = new Course("Math","12345","FOR ENGINNER STUDENT",null);

        tg.setTutorialGroupList(g1);
        tg.setTutorialGroupList(g2);
        tg.setTutorialGroupList(g3);
        tg.setTutorialGroupList(g4);

        team.setTeamList(t1);
        team.setTeamList(t2);
        team.setTeamList(t3);
        team.setTeamList(t4);

        student.setStudentList(stud1);
        student.setStudentList(stud2);
        student.setStudentList(stud3);
        student.setStudentList(stud4);
        student.setStudentList(stud5);
        student.setStudentList(stud6);
        
        course.setCourseList2(course1);
        course.setCourseList2(course2);

        int choice = 0;
        do{
            choice = rmUI.Menu();
            switch(choice){
                case 0:
                     MessageUI.displayExitMessage();
                    break;
                case 1:
                    displaystudent();
                    addnewStudent();
                    break;
                case 2:
                    displaystudent();
                    removeStudent();
                    break;
                case 3:
                    displaystudent();
                    int amendstudentIndex = rmUI.amendstudent();
                    amendStudent(amendstudentIndex);
                    break;
                case 4:
                    displaystudent();
                    searchStudentCourse();
                    break;
                case 5:
                    displaystudent();
                    int stuIndex = rmUI.getSelection("Enter number to choose student: ");
                    displayCourse();
                    int courseIndex = rmUI.getSelection("Enter number to choose course: ");
                    addToCourse(stuIndex,courseIndex);
                    break;
            }
        }while(choice !=0);
    }
    
    private void displaystudent(){
        int num = 1;
        for(int i=0; i<student.getStudentListlinked().size();i++){
        System.out.println(num+"."+student.getStudentListlinked().get(i).getNameId());
        num++;
        }
    }
    private void displayCourse(){
        int num = 1;
        for(int i=0; i<course.getCourseList2().size();i++){
        System.out.println(num+"."+course.getCourseList2().get(i).toString());
        num++;
        }
    }
    public void addnewStudent(){
        Student addnewstudent = rmUI.addnewStudentUI();
        student.getStudentListlinked().add(addnewstudent);
        System.out.println("ADD SUCCESSFULLY");
    }
    
    public void removeStudent(){
        int removestudent = rmUI.removestudent();
        student.getStudentListlinked().remove(removestudent);
    }
    
    public void amendStudent(int amendstudentIndex){
        System.out.println("Enter new name: ");
        String name = scanner.nextLine();
        System.out.println("Enter new ID: ");
        String id = scanner.nextLine();
        student.getStudentListlinked().get(amendstudentIndex).setName(name);
        student.getStudentListlinked().get(amendstudentIndex).setID(id);
    }
    
    public void addToCourse(int stuIndex,int courseIndex){
        course.getCourseList2().get(courseIndex-1).getStudentList().add(student.getStudentListlinked().get(stuIndex-1));
        student.getStudentListlinked().get(stuIndex-1).getCourseList2().add(course.getCourseList2().get(courseIndex-1));
        System.out.println("Enter course type (main,elective,resit,repeat): ");
        String courseType = scanner.nextLine();
        course.getCourseList2().get(courseIndex-1).setCourseType(courseType);
        System.out.println("Student "+student.getStudentListlinked().get(stuIndex-1).getName()+" Already add to the course " +course.getCourseList2().get(courseIndex-1).getCourseName());
        /*for(int i =0;i < course.getCourseList2().get(courseIndex-1).getStudentList().size();i++){
        System.out.println(course.getCourseList2().get(courseIndex-1).toString() +"\t" +course.getCourseList2().get(courseIndex-1).getStudentList().get(i).getNameId());
        }*/
    }
    
    public void searchStudentCourse(){
        int search = rmUI.searchstudentCourse();
        for(int i= 0; i< student.getStudentListlinked().get(search).getCourseList2().size();i++){
        System.out.println(student.getStudentListlinked().get(search).getNameId()+"\t"+student.getStudentListlinked().get(search).getCourseList2().get(i).toString2());
        }
    }
    
    
    public static void main(String[] args) {
        RegistrationManagement registration = new RegistrationManagement();
        registration.RegistrationManagement();
    }
    
}
