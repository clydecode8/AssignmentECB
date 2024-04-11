package boundary;
import adt.ArrayList;
import entity.Student;
import entity.Team;
import entity.TutorialGroup;
import java.util.Scanner;
/**
 *
 * @author jie
 */
public class AssTeamUI {
    Scanner scanner = new Scanner(System.in);
    private TutorialGroup tg = new TutorialGroup();
    private Team team = new Team();
    private Student student = new Student();
    public int getMenuChoice() {
        
        System.out.println("Assignment Team Management System");
        System.out.println("\n---------------------------");
        System.out.println("Choose Tutorial Group: ");
        for(int i=0; i< tg.getTutorialGroupList().size(); i++){
            System.out.println(i+1 + ". " + tg.getTutorialGroupList().getEntry(i).getGroup());
        }
        System.out.println((tg.getTutorialGroupList().size()+1) +". Summary Report");
        System.out.println("0. Quit");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return choice;
        
    }
    public int getAssTeamChoice(TutorialGroup search){
        System.out.println("Assignment Team Management System");
        System.out.println("\n---------------------------");
        System.out.println("Choose Team: ");
        int num=1;
        for(int i=0; i< team.getTeamList().size(); i++){
            if(team.getTeamList().getEntry(i).getTg().equals(search)){
                System.out.println(num + ". " + team.getTeamList().getEntry(i).getTeamName());              
                num++;
            }           
        }
        if(num ==1){                  
            System.out.println("There is no assignment team in this tutorial group");
            
        }
        else{
            System.out.println((num)+". Summary Report");
        }
        System.out.println("\n---------------------------");
        System.out.println((num+1)+ ". Create assignment team");
        System.out.println((num+2)+ ". Remove assignment team");
        System.out.println((num+3)+ ". Amend assignment team details");
        System.out.println((num+4)+ ". Merge assignment team");


        System.out.println("0. Quit");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return choice;
    }
    
    public Team createTeam(TutorialGroup tut){
        System.out.println("Create Assignment Team");
        System.out.println("\n---------------------------");
        System.out.print("Enter group name: ");
        String name = scanner.nextLine();
        System.out.print("Enter subject: ");
        String subject = scanner.nextLine();
        Team tempTeam = new Team(name, subject, tut);
        System.out.println("\nAssignment team created successfully");
        System.out.println("Press any key to continue ...");

        scanner.nextLine();
        return tempTeam;
    }
    
    public int removeTeam(){
        System.out.println("Remove Assigment Team");
        System.out.println("\n---------------------------");
        System.out.print("Enter group number: ");
        int choice = scanner.nextInt();
        System.out.println("\nAssignment team removed successfully");
        System.out.println("Press any key to continue ...");

        scanner.nextLine();
        return choice;
    }
    
    public void Report(){
        System.out.println("Hi");
        scanner.nextLine();

    }
    public int displayStudent(TutorialGroup search,Team search2){
        System.out.println("Assignment Team Management System");
        System.out.println("\n---------------------------");
        System.out.println("Team member: ");
        int num=1;
        for(int i=0; i< student.getStudentList().size(); i++){
            if(student.getStudentList().getEntry(i).getTeam() != null){
                if(student.getStudentList().getEntry(i).getTutorialGroup().equals(search) &&
                        student.getStudentList().getEntry(i).getTeam().equals(search2)){
                    System.out.println(num + ". " + student.getStudentList().getEntry(i).getName());              
                    num++;
                }    
            }
                   
        }
        if(num ==1){                  
            System.out.println("There is no team member in this team");
            
        }
        else{
            System.out.println((num)+". Summary Report");
        }
        System.out.println("\n---------------------------");
        System.out.println("7. Add new student (max 5 person per team)");
        System.out.println("8. Remove student");

        System.out.println("0. Quit");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return choice;
    }
    
    public Student addNewStudentPage(){
        System.out.println("\nList of students that have no team:");
        System.out.println("\n---------------------------");

        int num=1;
        ArrayList<Student> tempList = new ArrayList<>();
        for(int i=0; i<student.getStudentList().size(); i++){
            Student currentStudent = student.getStudentList().getEntry(i);
            if(currentStudent.getTeam() == null){
                tempList.add(student.getStudentList().getEntry(i));
                System.out.println(num + ". "+ currentStudent.getName());
                num++;
            }
        }
        if(num != 1){
            System.out.println("0. Exit");
            System.out.println("Enter choice: ");
            int choice = scanner.nextInt();
            if(choice == 0){
                return null;
            }
            else{
                System.out.println("Student added successfully");
                System.out.println("Press any key to continue ...");

                scanner.nextLine();
                return tempList.getEntry(choice-1);
            }
        }
        else{
            System.out.println("There is no student that havc no team");
            System.out.println("Press any key to continue ...");

            String temp = scanner.nextLine();
            return null;
        }
        
    }
    
    public Student removeStudent(TutorialGroup search,Team search2){
        ArrayList<Student> tempList = new ArrayList<>();
        for(int i=0; i< student.getStudentList().size(); i++){
            if(student.getStudentList().getEntry(i).getTeam() != null){
                if(student.getStudentList().getEntry(i).getTutorialGroup().equals(search) &&
                        student.getStudentList().getEntry(i).getTeam().equals(search2)){
                   tempList.add(student.getStudentList().getEntry(i));
                }    
            }          
        }
        System.out.println("\nRemove student:");
        System.out.println("\n---------------------------");
        System.out.print("Enter the number of student (0 to quit): ");
        int choice = scanner.nextInt();
        if(choice != 0){
            System.out.println("\nStudent removed successfully");
            System.out.println("Press any key to continue ...");

            scanner.nextLine();
            return tempList.getEntry(choice-1);

        }
        else{
            return null;
        }
    } 
    
    public void error(){
        System.out.println("This team already full");
    }
    
    public void error2(){
        System.out.println("There is no student in this team");
    }
}
