package control;

import adt.ArrayList;
import boundary.AssTeamUI;
import entity.Programme;
import entity.Student;
import entity.Team;
import entity.TutorialGroup;
import utility.MessageUI;

/**
 *
 * @author jie
 */
public class AssTeam {


    private Student student = new Student();
    private TutorialGroup tg = new TutorialGroup();
    private Team team = new Team();
    private AssTeamUI assTeamUI = new AssTeamUI();
    public void AssTeam(){
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
        Student stud6 = new Student("Jeremy", "WPF532323", g1, null);



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


        int reportNum = tg.getTutorialGroupList().size();
        int teamNum = 0;
        int memberNum = 0;

        int choice =0;
        // tut group start
        do{
            choice = assTeamUI.getMenuChoice();
            
            if(choice == 0){
                MessageUI.displayExitMessage();
                break;
            }
            else if (choice == reportNum){
                assTeamUI.Report();               
            }
            
            // ass team start
            else if (choice < reportNum){
                int choice2 = 0;
                do{
                    ArrayList<Team> filteredTeam = new ArrayList<>();
                    TutorialGroup search = tg.getTutorialGroupList().getEntry(choice-1);
                    choice2=0;
                    teamNum=0;
                    for(int i=0; i< team.getTeamList().size(); i++){
                        
                        if(team.getTeamList().getEntry(i).getTg().equals(search)){
                            filteredTeam.add(team.getTeamList().getEntry(i));
                            teamNum++;
                        }    
                        
                               
                    }
                    choice2 = assTeamUI.getAssTeamChoice(search);
        
                    if(choice2 == 0){
                        break;
                    }
                    else if(choice2 == teamNum+1){
                        assTeamUI.Report();
                    }
                    // create assignment team
                    else if(choice2 == teamNum +2){
                        Team newTeam = assTeamUI.createTeam(search);
                        Team.getTeamList().add(newTeam);
                    }
                    
                    //remove assignment team
                    else if(choice2 == teamNum +3){
                        int removeNum = assTeamUI.removeTeam();
                        Team removedTeam = filteredTeam.getEntry(removeNum-1);
                        System.out.println(removedTeam);
                        for(int i=0; i< Team.getTeamList().size(); i++){
                            if(Team.getTeamList().getEntry(i).equals(removedTeam)){
                                System.out.println("remove: "+ Team.getTeamList().getEntry(i));
                                Team.getTeamList().remove(i);
                                break;
                            }
                        }
                        for(int i=0; i<Team.getTeamList().size(); i++){
                            System.out.println(Team.getTeamList().getEntry(i));
                        }
                        
                    }
                    
                    // team member start
                    else if (choice2 < (teamNum+1)){
                        int choice3 = 0;
                        do{
                            Team search2 = filteredTeam.getEntry(choice2-1);
                            choice3 = assTeamUI.displayStudent(search, search2);              
                            memberNum=0;
                            for(int i=0; i< student.getStudentList().size(); i++){
                                if(student.getStudentList().getEntry(i).getTeam() != null){
                                    if(student.getStudentList().getEntry(i).getTutorialGroup().equals(search) &&
                                            student.getStudentList().getEntry(i).getTeam().equals(search2) ){                                       
                                        memberNum++;
                                    }  
                                }
                                         
                            }
                        
                            if(choice3 ==0){
                                break;
                            }
                            else if(choice3 == memberNum+1){
                                assTeamUI.Report();
                            }
                            
                            // add new student
                            else if(choice3 == 7){
                                // num of member >5
                                if(memberNum == 5){
                                    assTeamUI.error();
                                }
                                else{
                                    Student addStudent = assTeamUI.addNewStudentPage();
                                    if(addStudent != null){
                                        addStudent.setTeam(search2);
 
                                    }
                             
                                }
                            }
                            // remove student
                            else if (choice3 == 8){
                                // no member
                                if(memberNum == 0){
                                    assTeamUI.error2();
                                }
                                else{
                                    Student removeStudent = assTeamUI.removeStudent(search, search2);
                                    if(removeStudent != null){
                                        removeStudent.setTeam(null);
                                    }
                                    
                                }
                            }
                        }
                        while(choice3!=0);
   
                    } 
                    
                    //  team member end
                    
                }
                while(choice2 !=0);
            }
            
        }
        while (choice != 0);
                    
    }
    public static void main(String[] args) {
        AssTeam assTeam = new AssTeam();
        assTeam.AssTeam();
    }
    
}
