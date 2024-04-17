package boundary;
import adt.ArrayList;
import adt.ArrayQueueInterface;
import adt.CustomArrayQueue;
import adt.ListInterface;
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
    
   public final static void clscr(){
       System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
   }
    public int getMenuChoice() {
        clscr();
        System.out.println("Assignment Team Management System");
        System.out.println("---------------------------");
        System.out.println("Choose Tutorial Group: ");
        for(int i=0; i< tg.getTutorialGroupQueue().size(); i++){
            System.out.println(i+1 + ". " + tg.getTutorialGroupQueue().peekMiddle(i).getGroup());
        }
        System.out.println((tg.getTutorialGroupQueue().size()+1) +". Tutorial Group Summary Report");
        System.out.println((tg.getTutorialGroupQueue().size()+2) +". Team Summary Report");

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
        for(int i=0; i< team.getTeamQueue().size(); i++){
            if(team.getTeamQueue().peekMiddle(i).getTg().equals(search)){
                System.out.println(num + ". " + team.getTeamQueue().peekMiddle(i).getTeamName());              
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
        for(int i=0; i< team.getTeamQueue().size(); i++){
            if(team.getTeamQueue().peekMiddle(i).getTg().equals(search)){
                System.out.println(num + ". " + team.getTeamQueue().peekMiddle(i).getTeamName());              
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
        for(int i=0; i< team.getTeamQueue().size(); i++){
            if(team.getTeamQueue().peekMiddle(i).getTg().equals(search)){
                System.out.println(num + ". " + team.getTeamQueue().peekMiddle(i).getTeamName());              
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
    
    public ArrayQueueInterface<Integer> mergeTeam(TutorialGroup search){
        clscr();
        ArrayQueueInterface<Integer> choices = new CustomArrayQueue<>();
        System.out.println("Merge Assignment Team");        
        System.out.println("[Select 2 team to merge together]");
        System.out.println("[Team name and subject will follow first team]");
        System.out.println("[maximum 5 students in one team]");
        System.out.println("---------------------------");
        int num=1;
        for(int i=0; i< team.getTeamQueue().size(); i++){
            if(team.getTeamQueue().peekMiddle(i).getTg().equals(search)){
                System.out.println(num + ". " + team.getTeamQueue().peekMiddle(i).getTeamName());              
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
        choices.enqueue(choice1);
        choices.enqueue(choice2);
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

        ArrayQueueInterface<TutorialGroup> tgList = new CustomArrayQueue<>();
        ArrayQueueInterface<Team> teamQueue = new CustomArrayQueue<>();
        
        tgList = tg.getTutorialGroupQueue();
        teamQueue = team.getTeamQueue();
        int num=1;
        for(int i=0; i< tgList.size(); i++){
            int teamNum =0;
            for(int j=0; j< teamQueue.size(); j++){
                if(teamQueue.peekMiddle(i).getTg().getGroup().equals(tgList.peekMiddle(i).getGroup())){
                    teamNum++;
                }
            }
             System.out.println("|\t" + tgList.peekMiddle(i).getGroup() +"\t|\t"+ tgList.peekMiddle(i).getProgramme()
            + "\t|\t\t" + tgList.peekMiddle(i).getQty() + "\t\t|\t\t"+ teamNum + "\t\t|");
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
        
        ArrayQueueInterface<Team> teamQueue = new CustomArrayQueue<>();
        ArrayQueueInterface<Student> studQueue = new CustomArrayQueue<>();
        
        teamQueue = team.getTeamQueue();
        studQueue = student.getStudentQueue();
        for(int j=0; j< teamQueue.size(); j++){
            int studNum = 0;
            ArrayQueueInterface<String> tempName = new CustomArrayQueue<>();
            for(int i=0; i< studQueue.size(); i++){
                if(studQueue.peekMiddle(i).getTeam()!= null){
                    if(studQueue.peekMiddle(i).getTeam().getTeamName().equals(teamQueue.peekMiddle(j).getTeamName())){
                        studNum ++;
                        tempName.enqueue(studQueue.peekMiddle(i).getName());
                    } 
                }
                
            }
//             System.out.println("|\t" + teamList.getEntry(j).getTeamName() + "\t|\t" + teamList.getEntry(j).getSubject()
//             + "\t|\t\t" + studNum + "\t\t|\t" + tempName.toString2() + "\t|");
             System.out.printf("|%22s|%26s|%32s|%22d|%40s|", teamQueue.peekMiddle(j).getTg().getGroup(),teamQueue.peekMiddle(j).getTeamName(), teamQueue.peekMiddle(j).getSubject(),studNum, tempName.toString2() );
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
        for(int i=0; i< student.getStudentQueue().size(); i++){
            if(student.getStudentQueue().peekMiddle(i).getTeam() != null){
                if(student.getStudentQueue().peekMiddle(i).getTutorialGroup().equals(search) &&
                        student.getStudentQueue().peekMiddle(i).getTeam().equals(search2)){
                    System.out.println(num + ". " + student.getStudentQueue().peekMiddle(i).getName());              
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
        ArrayQueueInterface<Student> tempQueue = new CustomArrayQueue<>();
        for(int i=0; i<student.getStudentQueue().size(); i++){
            Student currentStudent = student.getStudentQueue().peekMiddle(i);
            if(currentStudent.getTeam() == null){
                tempQueue.enqueue(student.getStudentQueue().peekMiddle(i));
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
                return tempQueue.peekMiddle(choice-1);
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
        ArrayQueueInterface<Student> tempQueue = new CustomArrayQueue<>();
        clscr();
        int num =0;
        System.out.println("\nRemove student:");
        System.out.println("---------------------------");
        for(int i=0; i< student.getStudentQueue().size(); i++){
            if(student.getStudentQueue().peekMiddle(i).getTeam() != null){
                if(student.getStudentQueue().peekMiddle(i).getTutorialGroup().equals(search) &&
                        student.getStudentQueue().peekMiddle(i).getTeam().equals(search2)){
                   tempQueue.enqueue(student.getStudentQueue().peekMiddle(i));
                   System.out.println((num+1) + ". "+ student.getStudentQueue().peekMiddle(i).getName());
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
            return tempQueue.peekMiddle(choice-1);

        }
        else{
            return null;
        }
    } 
    
    public void error(){
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
