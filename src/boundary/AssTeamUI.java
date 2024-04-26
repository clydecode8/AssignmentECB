package boundary;

import adt.SortedArrayList;
import adt.SortedListInterface;
import entity.Student;
import entity.Team;
import entity.TutorialGroup;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Liew Yee Jie
 */
public class AssTeamUI {
    Scanner scanner = new Scanner(System.in);
    private TutorialGroup tg = new TutorialGroup();
    private Team team = new Team();
    private Student student = new Student();
    
   public final static void clscr(){
       System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
   }
    public int getMenuChoice() {
        clscr();
        System.out.println("Assignment Team Management System");
        System.out.println("---------------------------");
        System.out.println("Choose Tutorial Group: ");
        for(int i=0; i< tg.getSortedTutorialGroup().size(); i++){
            System.out.println(i+1 + ". " + tg.getSortedTutorialGroup().getEntry(i).getGroup());
        }
        System.out.println((tg.getSortedTutorialGroup().size()+1) +". Tutorial Group Summary Report");
        System.out.println((tg.getSortedTutorialGroup().size()+2) +". Team Summary Report");

        System.out.println("0. Quit");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return choice;
        
    }
    public int getAssTeamChoice(TutorialGroup search){
        clscr();
        System.out.println("Assignment Team Management System");
        System.out.println("---------------------------");
        System.out.println("Choose Team: ");
        int num=1;
        for(int i=team.getSortedTeam().size()-1; i>= 0; i--){
            if(team.getSortedTeam().getEntry(i).getTg().equals(search)){
                System.out.println(num + ". " + team.getSortedTeam().getEntry(i).getTeamName());              
                num++;
            }           
        }
        if(num ==1){                  
            System.out.println("There is no assignment team in this tutorial group");
            
        }
//        else{
//            System.out.println((num)+". Team Summary Report");
//        }
        System.out.println("---------------------------");
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
        clscr();
        System.out.println("Create Assignment Team");
        System.out.println("---------------------------");
        System.out.print("Enter team name: ");
        String name = scanner.nextLine();
        System.out.print("Enter course: ");
        String subject = scanner.nextLine();
        Team tempTeam = new Team(name, subject, tut);
        System.out.println("\nAssignment team created successfully");
        System.out.println("Press any key to continue ...");

        scanner.nextLine();
        return tempTeam;
    }
    
    public int removeTeam(TutorialGroup search){
        clscr();
        System.out.println("Remove Assignment Team");
        System.out.println("---------------------------");
        int num=1;
        for(int i=team.getSortedTeam().size()-1; i>= 0; i--){
            if(team.getSortedTeam().getEntry(i).getTg().equals(search)){
                System.out.println(num + ". " + team.getSortedTeam().getEntry(i).getTeamName());    
        
                num++;
            }           
        }
        if(num ==1){                  
            System.out.println("There is no assignment team in this tutorial group");
            
        }
        System.out.print("Enter team number (0 to exit): ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if(choice != 0){
            System.out.println("\nAssignment team removed successfully");
            System.out.println("Press any key to continue ...");
            scanner.nextLine();
        }

        return choice;
    }
    
    public int amendTeam(TutorialGroup search){
        clscr();
        System.out.println("Amend Assignment Team");
        System.out.println("---------------------------");
        int num=1;
        for(int i=team.getSortedTeam().size()-1; i>= 0; i--){
            if(team.getSortedTeam().getEntry(i).getTg().equals(search)){
                System.out.println(num + ". " + team.getSortedTeam().getEntry(i).getTeamName());              
                num++;
            }           
        }
        if(num ==1){                  
            System.out.println("There is no assignment team in this tutorial group");
            
        }
        System.out.print("Enter team number (0 to quit): ");
        int choice = scanner.nextInt();
        return choice;
    }
    
    public int amendTeamChoice(Team team){
        clscr();
        System.out.println("---------------------------");
        System.out.println("Team Name: "+ team.getTeamName());
        System.out.println("Course: "+ team.getSubject());
        System.out.println("---------------------------");
        System.out.println("1. Change Team Name");
        System.out.println("2. Change Course");
        System.out.print("Enter your choice (0 to quit): ");
        int choice = scanner.nextInt();
        return choice;

    }
    
    public String amendTeamInput(int choice){
        if(choice == 1){
            scanner.nextLine();
            System.out.print("Enter New Team Name: ");
            String name = scanner.nextLine();
            System.out.println("\nAssignment team amendded successfully");
            System.out.println("Press any key to continue ...");

            scanner.nextLine();
            return name;
        }
        else if (choice ==2){
            scanner.nextLine();
            System.out.print("Enter New Course: ");
            String subject = scanner.nextLine();
            System.out.println("\nAssignment team amendded successfully");
            System.out.println("Press any key to continue ...");

            scanner.nextLine();
            return subject;
        }
        else{
            return null;
        }
    }
    
    public SortedListInterface<Integer> mergeTeam(TutorialGroup search){
        clscr();
        SortedListInterface<Integer> choices = new SortedArrayList<>();
        System.out.println("Merge Assignment Team");  
        System.out.println("---------------------------");
        System.out.println("[Select 2 team to merge together]");
        System.out.println("[Team name and course will follow first team]");
        System.out.println("[maximum 5 students in one team]");
        System.out.println("---------------------------");
        int num=1;
        for(int i=team.getSortedTeam().size()-1; i>= 0; i--){
            if(team.getSortedTeam().getEntry(i).getTg().equals(search)){
                System.out.println(num + ". " + team.getSortedTeam().getEntry(i).getTeamName()); 
                 

                num++;
            }           
        }
        if(num ==1){                  
            System.out.println("There is no assignment team in this tutorial group");
            
        }
        System.out.println("---------------------------");
        System.out.print("\nEnter first team number: ");
        int choice1 = scanner.nextInt();
        System.out.print("Enter second team number: ");
        int choice2 = scanner.nextInt();
        choices.add(choice1);
        choices.add(choice2);
        return choices;
    }
    
     public int mergeTeamChoice(Team team){
        System.out.println("---------------------------");
        System.out.println("Team Name: "+ team.getTeamName());
        System.out.println("Course: "+ team.getSubject());
        System.out.println("\n---------------------------");
        System.out.println("1. Change Team Name");
        System.out.println("2. Change Course");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        return choice;

    }
    
    public void GroupReport(){
        clscr();
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");

        String formattedDateTime = now.format(formatter);
        
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\t\t\t    Tutorial Group Summary Report    \t\t\t\t\t\t|");
        System.out.println("|  Created at: "+ formattedDateTime + "                                                                                                     |");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|\tGroup\t|\t\t      Programme     \t\t|\tNumber of students\t|\tNumber of teams\t\t|");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");

        SortedListInterface<TutorialGroup> tgList = new SortedArrayList<>();
        SortedListInterface<Team> sortedTeam = new SortedArrayList<>();
        
        tgList = tg.getSortedTutorialGroup();
        sortedTeam = team.getSortedTeam();
        // Sort the sortedTeam list by teamName in ascending order
        ((SortedArrayList<Team>) sortedTeam).bubbleSort();
        
        int num=1;
        for(int i=0; i< tgList.size(); i++){
            int teamNum =0;
            for(int j=0; j< sortedTeam.size(); j++){
                if(sortedTeam.getEntry(j).getTg().getGroup().equals(tgList.getEntry(i).getGroup())){
                    teamNum++;
                }
            }
             System.out.println("|\t" + tgList.getEntry(i).getGroup() +"\t|\t\t"+ tgList.getEntry(i).getProgramme().getName()
            + "\t\t|\t\t" + tgList.getEntry(i).getQty() + "\t\t|\t\t"+ teamNum + "\t\t|");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
            num++;
        }
        System.out.println("\nPress any key to continue ...");
        scanner.nextLine();

    }
    
    public void TeamReport(){
        clscr();
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");

        String formattedDateTime = now.format(formatter);
        System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                                          Team Summary Report                                                                     |");
        System.out.println("|  Created at: "+ formattedDateTime + "                                                                                                                    |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|    Tutorial Group    |\t\tTeam\t\t|\t\tCourse\t\t|  Number of students  |              Student List              |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        
        SortedListInterface<Team> sortedTeam = new SortedArrayList<>();
        SortedListInterface<Student> sortedStud = new SortedArrayList<>();
        
        sortedTeam = team.getSortedTeam();
        sortedStud = student.getSortedStudentList();
        for(int j=0; j< sortedTeam.size(); j++){
            int studNum = 0;
            SortedListInterface<String> tempName = new SortedArrayList<>();
            for(int i=0; i< sortedStud.size(); i++){
                if(sortedStud.getEntry(i).getTeam()!= null){
                    if(sortedStud.getEntry(i).getTeam().getTeamName().equals(sortedTeam.getEntry(j).getTeamName())){
                        studNum ++;
                        tempName.add(sortedStud.getEntry(i).getName());
                    } 
                }
                
            }
//             System.out.println("|\t" + teamList.getEntry(j).getTeamName() + "\t|\t" + teamList.getEntry(j).getSubject()
//             + "\t|\t\t" + studNum + "\t\t|\t" + tempName.toString2() + "\t|");
        System.out.printf("|%22s|%26s|%32s|%22d|%40s|", sortedTeam.getEntry(j).getTg().getGroup(),sortedTeam.getEntry(j).getTeamName(), sortedTeam.getEntry(j).getSubject(),studNum, tempName.toString2() );
        System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------");

        }
        

        System.out.println("\nPress any key to continue ...");
        scanner.nextLine();
    }
    public int displayStudent(TutorialGroup search,Team search2){
        clscr();
        System.out.println("Assignment Team Management System");
        System.out.println("---------------------------");
        System.out.println("Team member: ");
        int num=1;
        for(int i=0; i< student.getSortedStudentList().size(); i++){
            if(student.getSortedStudentList().getEntry(i).getTeam() != null){
                if(student.getSortedStudentList().getEntry(i).getTutorialGroup().equals(search) &&
                        student.getSortedStudentList().getEntry(i).getTeam().equals(search2)){
                    System.out.println(num + ". " + student.getSortedStudentList().getEntry(i).getName());              
                    num++;
                }    
            }
                   
        }
        if(num ==1){                  
            System.out.println("There is no team member in this team");
            
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
    
    public Student addNewStudentPage(){
        clscr();
        System.out.println("\nList of students that have no team:");
        System.out.println("---------------------------");

        int num=1;
        SortedListInterface<Student> sortedtemp = new SortedArrayList<>();
        for(int i=0; i<student.getSortedStudentList().size(); i++){
            Student currentStudent = student.getSortedStudentList().getEntry(i);
            if(currentStudent.getTeam() == null){
                sortedtemp.add(student.getSortedStudentList().getEntry(i));
                System.out.println(num + ". "+ currentStudent.getName());
                num++;
            }
        }
        if(num != 1){
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            if(choice == 0){
                return null;
            }
            else{
                scanner.nextLine();
                System.out.println("Student added successfully");
                System.out.println("Press any key to continue ...");

                scanner.nextLine();
                return sortedtemp.getEntry(choice-1);
            }
        }
        else{
            System.out.println("There is no student that havc no team");
            System.out.println("Press any key to continue ...");

            String temp = scanner.nextLine();
            return null;
        }
        
    }
    
    public void success(){
        
        scanner.nextLine();
        System.out.println("\nMerge Two Team Successfully");
        System.out.println("Press any key to continue ...");

        scanner.nextLine();
    }
    
    public Student removeStudent(TutorialGroup search,Team search2){
        SortedListInterface<Student> sortedTemp = new SortedArrayList<>();
        clscr();
        int num =0;
        System.out.println("\nRemove student:");
        System.out.println("---------------------------");
        for(int i=0; i< student.getSortedStudentList().size(); i++){
            if(student.getSortedStudentList().getEntry(i).getTeam() != null){
                if(student.getSortedStudentList().getEntry(i).getTutorialGroup().equals(search) &&
                        student.getSortedStudentList().getEntry(i).getTeam().equals(search2)){
                   sortedTemp.add(student.getSortedStudentList().getEntry(i));
                   System.out.println((num+1) + ". "+ student.getSortedStudentList().getEntry(i).getName());
                   num++;
                }    
            }          
        }
       
        System.out.print("Enter the number of student (0 to quit): ");
        int choice = scanner.nextInt();
        if(choice != 0){
            scanner.nextLine();
            System.out.println("\nStudent removed successfully");
            System.out.println("Press any key to continue ...");

            scanner.nextLine();
            return sortedTemp.getEntry(choice-1);

        }
        else{
            return null;
        }
    } 
    
    public void error(){
        scanner.nextLine();
        System.out.println("This team already full");
        System.out.println("Press any key to continue ...");

        scanner.nextLine();
    }
    
    public void error2(){
        System.out.println("There is no student in this team");
        System.out.println("Press any key to continue ...");

        scanner.nextLine();
    }
}
