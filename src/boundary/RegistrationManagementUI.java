/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import java.util.Scanner;

public class RegistrationManagementUI {
    Scanner scanner = new Scanner(System.in);
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
        System.out.println("0. Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return choice;
    }
    
    public void addnewStudentUI(){
        System.out.println("ADD NEW STUDENT");
        System.out.println("Enter new student name");
        String name = scanner.nextLine();
        System.out.println("Enter new student ID");
        String ID = scanner.nextLine();
    }
    
    public int getSelection(String hint){
        //System.out.println("ADD Student to Course");
        System.out.println(hint);
        int addtocourse = scanner.nextInt();
        scanner.nextLine();
        return addtocourse;
    }

}
