/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import entity.Student;
import java.util.Scanner;

public class RegistrationManagementUI {
    Scanner scanner = new Scanner(System.in);
    private Student student = new Student();
    
    public int Menu(){
        System.out.println("Registration Management System");
        System.out.println("1. Add new Students");
        System.out.println("2. Remove a student");
        System.out.println("3. Amend student details");
        System.out.println("4. Search students for registered course");
        System.out.println("5. Add students to a few course(main,elective,resit,repeat)");
        System.out.println("6. Remove a student from a course registration");
        System.out.println("7. Calculate fee paid for registered courses");
        System.out.println("8. Filters students for courses based on criteria");
        System.out.println("9. Geneate Summary reports (>=2)");
        System.out.println("0. Exit");
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return choice;
    }
    
    public Student addnewStudentUI(){
        System.out.println("ADD NEW STUDENT");
        System.out.println("Enter new student name: ");
        String name = scanner.nextLine();
        System.out.println("Enter new student ID: ");
        String ID = scanner.nextLine();
        return new Student(name,ID);
    }
    
    public int removestudent(){
        System.out.println("Choose the number to remove student: ");
        int removenumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Remove successfully...");
        return removenumber-1;
    }
    
    public int amendstudent(){
        System.out.println("Choose the number to amend student: ");
        int amendnumber = scanner.nextInt();
        scanner.nextLine();
        return amendnumber-1;
    }
    
    public int searchstudentCourse(){
        System.out.println("Choose the number to search student registered courses: ");
        int searchnumber = scanner.nextInt();
        scanner.nextLine();
        return searchnumber-1;
    }
    
    public int getSelection(String hint){
        //System.out.println("ADD Student to Course");
        System.out.println(hint);
        int addtocourse = scanner.nextInt();
        scanner.nextLine();
        return addtocourse;
    }
    
    public int chooseCourse(){
        System.out.println("Enter number to choose course: ");
        int choosecourse = scanner.nextInt();
        scanner.nextLine();
        return choosecourse-1;
    }
    
        public int removeStuFromCourse(){
        System.out.println("Enter number to remove the student from course: ");
        int removestufromcourse = scanner.nextInt();
        scanner.nextLine();
        return removestufromcourse-1;
    }
        
    public int calculatefee(){
        System.out.println("Enter a number to calculate: ");
        int calculatefee = scanner.nextInt();
        scanner.nextLine();
        return calculatefee-1;
    }
    
    public int filter(){
        System.out.println("Enter a number to choose course: ");
        int filternumber = scanner.nextInt();
        scanner.nextLine();
        return filternumber-1;
    }   
    
    public int displaycoursetype(){
        System.out.println("Choose CourseType to filter");
        System.out.println("1. Main");
        System.out.println("2. Elective");
        System.out.println("3. Resit");
        System.out.println("4. Repeat");
        System.out.println("Choose the courseType: ");
        int displaycourse = scanner.nextInt();
        scanner.nextLine();
        return displaycourse-1;
    }
}
