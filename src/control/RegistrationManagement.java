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
        
        Course course1 = new Course("ACCOUNT","12345","ACCOUNT",700);
        Course course2 = new Course("Math","12345","FOR ENGINNER STUDENT",1000);
        Course course3 = new Course("Graphics programming","12345","FOR ENGINNER STUDENT",666);

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
        course.setCourseList2(course3);

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
                    System.out.println("------------------------------------------------------------------------------------------------");           
                    System.out.println("ADD STUDENT TO COURSE");
                    System.out.println("------------------------------------------------------------------------------------------------");  
                    int stuIndex = rmUI.getSelection("Enter number to choose student: ");
                    displayCourse();
                    int courseIndex = rmUI.getSelection("Enter number to choose course: ");
                    addToCourse(stuIndex,courseIndex);
                    break;
                case 6:
                    displayCourse();
                    removeStuFromCourse();
                    break;
                case 7:
                    displaystudent();
                    calculatedfee();
                    break;
                case 8:
                    displayCourse();
                    int filtercourse = rmUI.filter();
                    int displaycourse = rmUI.displaycoursetype();
                    filtercoursetype(filtercourse,displaycourse);
                    break;
                case 9:
                    report1();
                    
            }
        }while(choice !=0);
    }
    
    private void displaystudent(){
        System.out.println("------------------------------------------------------------------------------------------------");          
        System.out.println("STUDENT LIST");
        System.out.println("------------------------------------------------------------------------------------------------"); 
        int num = 1;
        for(int i=0; i<student.getStudentListlinked().size();i++){
        System.out.println(num+"."+student.getStudentListlinked().get(i).getNameId());
        num++;
        }
    }
    private void displayCourse(){
        System.out.println("------------------------------------------------------------------------------------------------");         
        System.out.println("COURSE LIST");
        System.out.println("------------------------------------------------------------------------------------------------");  
        int num = 1;
        for(int i=0; i<course.getCourseList2().size();i++){
        System.out.println(num+"."+course.getCourseList2().get(i).toString());
        num++;
        }
    }
    
    //Function 1 add new students
    public void addnewStudent(){
        Student addnewstudent = rmUI.addnewStudentUI();
        student.getStudentListlinked().add(addnewstudent);
    }
    
    //Function 2 remove a student
    public void removeStudent(){
        int removestudent = rmUI.removestudent();
        student.getStudentListlinked().remove(removestudent);
    }
    
    //Function 3 Amend student details
    public void amendStudent(int amendstudentIndex){
        System.out.println("Enter new name: ");
        String name = scanner.nextLine();
        System.out.println("Enter new ID: ");
        String id = scanner.nextLine();
        System.out.println("--Amend successfully!-- ");
        student.getStudentListlinked().get(amendstudentIndex).setName(name);
        student.getStudentListlinked().get(amendstudentIndex).setID(id);
    }
    
    //Function 4 Search students for registered course
    public void searchStudentCourse(){
        int search = rmUI.searchstudentCourse();
        for(int i= 0; i< student.getStudentListlinked().get(search).getCourseList2().size();i++){
        System.out.println(student.getStudentListlinked().get(search).getNameId()+"\t"+student.getStudentListlinked().get(search).getCourseList2().get(i).toString2()+"\tCourse Type:"+course.getCourseList2().get(i).getcourseTypes().get(i));
        }
    }
    
    //Function 5 Add students to a few course(main,elective,resit,repeat)
    public void addToCourse(int stuIndex,int courseIndex){
        course.getCourseList2().get(courseIndex-1).getStudentList().add(student.getStudentListlinked().get(stuIndex-1));
        student.getStudentListlinked().get(stuIndex-1).getCourseList2().add(course.getCourseList2().get(courseIndex-1));
        System.out.println("Course Type (main,elective,resit,repeat): ");
        System.out.println("1. Main");
        System.out.println("2. Elective");
        System.out.println("3. Resit");
        System.out.println("4. Repeat");
        System.out.println("Choose the courseType: ");
        int courseType = scanner.nextInt();
        scanner.nextLine();
        String coursetype1="";
        if(courseType == 1){
            coursetype1 = "Main";
        }else if(courseType == 2){
            coursetype1 = "Elective";
        }else if(courseType == 3){
            coursetype1 = "Resit";
        }else if(courseType == 4){
            coursetype1 = "Repeat";
        }
        course.getCourseList2().get(courseIndex-1).setCourseType(coursetype1);
        System.out.println("Student "+student.getStudentListlinked().get(stuIndex-1).getName()+" Already add to the course " +course.getCourseList2().get(courseIndex-1).getCourseName());
        /*for(int i =0;i < course.getCourseList2().get(courseIndex-1).getStudentList().size();i++){
        System.out.println(course.getCourseList2().get(courseIndex-1).toString() +"\t" +course.getCourseList2().get(courseIndex-1).getStudentList().get(i).getNameId());
        }*/
    }    
    
    //Function 6 Remove a student from a course registration
    public void removeStuFromCourse(){
        int choosecourse = rmUI.chooseCourse();
        int num = 1;
        for(int i =0;i < course.getCourseList2().get(choosecourse).getStudentList().size();i++){
        System.out.println(num+". "+course.getCourseList2().get(choosecourse).toString() +"\t" +course.getCourseList2().get(choosecourse).getStudentList().get(i).getNameId());
        num++;
        }
        int removestufromCourse = rmUI.removeStuFromCourse();
        course.getCourseList2().get(choosecourse).getStudentList().remove(student.getStudentListlinked().get(removestufromCourse));
        student.getStudentListlinked().get(removestufromCourse).getCourseList2().remove(course.getCourseList2().get(choosecourse));
        System.out.println("--Remove successfully!--");
    }
    
    //Functino 7 Calculate fee paid for registered courses
    public void calculatedfee(){
        int choosestu = rmUI.calculatefee();
        double total = 0;
        for(int i = 0;i<student.getStudentListlinked().get(choosestu).getCourseList2().size();i++){
            System.out.println(course.getCourseList2().get(i).toString()+"RM "+ course.getCourseList2().get(i).getcourseprice());
            total += course.getCourseList2().get(i).getcourseprice();
        }
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.printf("The student total fee is RM %.2f \n" , total);
    }
    
    //Function 8 Filters students for courses based on criteria
    public void filtercoursetype(int filtercourse, int displaycourse){
        for(int i = 0; i<course.getCourseList2().get(displaycourse).getcourseTypes().size();i++){
        System.out.println(course.getCourseList2().get(filtercourse).getStudentList().get(i).getNameId()+course.getCourseList2().get(filtercourse)+"Course: "+course.getCourseList2().get(i).getcourseTypes().get(i));
        }
    }
    
    //Function 9 Geneate Summary reports (>=2)
    public void displayreport1(){
        System.out.println("------------------------------------------------------------------------------------------------");           
        System.out.println("Enter a number to calculate the fee of student: ");
        int choosestu = scanner.nextInt();
        scanner.nextLine();
        double total = 0;
        System.out.println("================================================================================================"); 
        System.out.println("\t\t\t\tReport:Student Bill");
        System.out.println("Name :"+student.getStudentListlinked().get(choosestu-1).getName()+"\t\t\t\t\t\t\t\t\tID :"+student.getStudentListlinked().get(choosestu-1).getID());
        System.out.println("================================================================================================"); 
        for(int i = 0;i<student.getStudentListlinked().get(choosestu-1).getCourseList2().size();i++){
            System.out.println(course.getCourseList2().get(i).toString()+"RM "+ course.getCourseList2().get(i).getcourseprice());
            total += course.getCourseList2().get(i).getcourseprice();
        }
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.printf("The student total fee:\t\t\t\t\t\t\t   RM %.2f \n" , total);
    }
    
    public void displayreport2(){
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("Enter a number to calculate the student for a course: ");
        int choosecourse = scanner.nextInt();
        scanner.nextLine();
        System.out.println("================================================================================================"); 
        System.out.println("\t\t\t\tReport: Number of student for course");
        System.out.println("Course :"+ course.getCourseList2().get(choosecourse-1).getCourseName()+"\t\t\t\t\t\t\t\t\tID :"+course.getCourseList2().get(choosecourse).getCourseID());
        System.out.println("================================================================================================"); 
        int num =0;
        for(int i =0;i < course.getCourseList2().get(choosecourse-1).getStudentList().size();i++){
            System.out.println(course.getCourseList2().get(choosecourse-1).toString() +"\t" +course.getCourseList2().get(choosecourse-1).getStudentList().get(i).getNameId());
            num++;
        }
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("The Total student for course "+course.getCourseList2().get(choosecourse-1).getCourseName().toUpperCase()+" :\t\t\t\t\t\t"+num+ " Students");
    }
    
    public void report1(){
        int choosereport = rmUI.reportchoose();
        if (choosereport == 1){
            displaystudent();
            displayreport1();
        }else if(choosereport ==2){
            displayCourse();
            displayreport2();
        }
    }
    
    
    public static void main(String[] args) {
        RegistrationManagement registration = new RegistrationManagement();
        registration.RegistrationManagement();
    }
    
}
