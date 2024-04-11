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
        System.out.println("0. Quit");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return choice;
    }
    public void Report(){
        
    }
    public int displayStudent(TutorialGroup search,Team search2){
        System.out.println("Assignment Team Management System");
        System.out.println("\n---------------------------");
        System.out.println("Team member: ");
        int num=1;
        for(int i=0; i< student.getStudentList().size(); i++){
            if(student.getStudentList().getEntry(i).getTutorialGroup().equals(search) &&
                    student.getStudentList().getEntry(i).getTeam().equals(search2)){
                System.out.println(num + ". " + student.getStudentList().getEntry(i).getName());              
                num++;
            }           
        }
        if(num ==1){                  
            System.out.println("There is no team member in this team");
            
        }
        else{
            System.out.println((num)+". Summary Report");
        }
        System.out.println("\n---------------------------");
        System.out.println("6. Add new student (max 5 person per team)");
        System.out.println("7. Remove student");

        System.out.println("0. Quit");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return choice;
    }
}
