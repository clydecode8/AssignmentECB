package boundary;
import adt.ArrayList;
import adt.ListInterface;
import entity.Student;
import entity.Team;
import entity.TutorialGroup;
import java.util.LinkedList;
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
    
   public final static void clscr(){
       System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
   }
    public int getMenuChoice() {
        clscr();
        System.out.println("Assignment Team Management System");
        System.out.println("---------------------------");
        System.out.println("Choose Tutorial Group: ");
        for(int i=0; i< tg.getTutorialGroupList().size(); i++){
            System.out.println(i+1 + ". " + tg.getTutorialGroupList().getEntry(i).getGroup());
        }
        System.out.println((tg.getTutorialGroupList().size()+1) +". Tutorial Group Summary Report");
        System.out.println((tg.getTutorialGroupList().size()+2) +". Team Summary Report");

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
        for(int i=0; i< team.getTeamList().size(); i++){
            if(team.getTeamList().getEntry(i).getTg().equals(search)){
                System.out.println(num + ". " + team.getTeamList().getEntry(i).getTeamName());              
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
    
    public int removeTeam(TutorialGroup search){
        clscr();
        System.out.println("Remove Assignment Team");
        System.out.println("---------------------------");
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
        System.out.print("Enter group number (0 to exit): ");
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
        for(int i=0; i< team.getTeamList().size(); i++){
            if(team.getTeamList().getEntry(i).getTg().equals(search)){
                System.out.println(num + ". " + team.getTeamList().getEntry(i).getTeamName());              
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
        System.out.println("Subject: "+ team.getSubject());
        System.out.println("---------------------------");
        System.out.println("1. Change Team Name");
        System.out.println("2. Change Subject");
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
            System.out.print("Enter New Subject: ");
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
    
    public ArrayList<Integer> mergeTeam(TutorialGroup search){
        clscr();
        ArrayList<Integer> choices = new ArrayList<>();
        System.out.println("Merge Assignment Team");        
        System.out.println("[Select 2 team to merge together]");
        System.out.println("[Team name and subject will follow first team]");
        System.out.println("[maximum 5 students in one team]");
        System.out.println("---------------------------");
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
        System.out.println("---------------------------");
        System.out.print("\nEnter first team number: ");
        int choice1 = scanner.nextInt();
        System.out.print("Enter first team number: ");
        int choice2 = scanner.nextInt();
        choices.add(choice1);
        choices.add(choice2);
        return choices;
    }
    
     public int mergeTeamChoice(Team team){
        System.out.println("---------------------------");
        System.out.println("Team Name: "+ team.getTeamName());
        System.out.println("Subject: "+ team.getSubject());
        System.out.println("\n---------------------------");
        System.out.println("1. Change Team Name");
        System.out.println("2. Change Subject");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        return choice;

    }
    
    public void GroupReport(){
        clscr();
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\t\t\t    Tutorial Group Summary Report    \t\t\t\t\t\t|");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|\tGroup\t|\t\t      Programme     \t\t|\tNumber of students\t|\tNumber of teams\t\t|");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");

        ListInterface<TutorialGroup> tgList = new ArrayList<>();
        ListInterface<Team> teamList = new ArrayList<>();
        
        tgList = tg.getTutorialGroupList();
        teamList = team.getTeamList();
        int num=1;
        for(int i=0; i< tgList.size(); i++){
            int teamNum =0;
            for(int j=0; j< teamList.size(); j++){
                if(teamList.getEntry(i).getTg().getGroup().equals(tgList.getEntry(i).getGroup())){
                    teamNum++;
                }
            }
             System.out.println("|\t" + tgList.getEntry(i).getGroup() +"\t|\t"+ tgList.getEntry(i).getProgramme()
            + "\t|\t\t" + tgList.getEntry(i).getQty() + "\t\t|\t\t"+ teamNum + "\t\t|");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
            num++;
        }
        System.out.println("\nPress any key to continue ...");
        scanner.nextLine();

    }
    
    public void TeamReport(){
        clscr();
        System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                                          Team Summary Report                                                                     |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|    Tutorial Group    |\t\tTeam\t\t|\t\tSubject\t\t|  Number of students  |              Student List              |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        
        ListInterface<Team> teamList = new ArrayList<>();
        ListInterface<Student> studList = new ArrayList<>();
        
        teamList = team.getTeamList();
        studList = student.getStudentList();
        for(int j=0; j< teamList.size(); j++){
            int studNum = 0;
            ListInterface<String> tempName = new ArrayList<>();
            for(int i=0; i< studList.size(); i++){
                if(studList.getEntry(i).getTeam()!= null){
                    if(studList.getEntry(i).getTeam().getTeamName().equals(teamList.getEntry(j).getTeamName())){
                        studNum ++;
                        tempName.add(studList.getEntry(i).getName());
                    } 
                }
                
            }
//             System.out.println("|\t" + teamList.getEntry(j).getTeamName() + "\t|\t" + teamList.getEntry(j).getSubject()
//             + "\t|\t\t" + studNum + "\t\t|\t" + tempName.toString2() + "\t|");
             System.out.printf("|%22s|%26s|%32s|%22d|%40s|", teamList.getEntry(j).getTg().getGroup(),teamList.getEntry(j).getTeamName(), teamList.getEntry(j).getSubject(),studNum, tempName.toString2() );
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
            System.out.print("Enter choice: ");
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
    
    public void success(){
        
        scanner.nextLine();
        System.out.println("\nMerge Two Team Successfully");
        System.out.println("Press any key to continue ...");

        scanner.nextLine();
    }
    
    public Student removeStudent(TutorialGroup search,Team search2){
        ArrayList<Student> tempList = new ArrayList<>();
        clscr();
        int num =0;
        System.out.println("\nRemove student:");
        System.out.println("---------------------------");
        for(int i=0; i< student.getStudentList().size(); i++){
            if(student.getStudentList().getEntry(i).getTeam() != null){
                if(student.getStudentList().getEntry(i).getTutorialGroup().equals(search) &&
                        student.getStudentList().getEntry(i).getTeam().equals(search2)){
                   tempList.add(student.getStudentList().getEntry(i));
                   System.out.println((num+1) + ". "+ student.getStudentList().getEntry(i).getName());
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
