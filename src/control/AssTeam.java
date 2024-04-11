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

        int reportNum = tg.getTutorialGroupList().size()+1;
        int reportNum2 = team.getTeamList().size()+1;

        int choice =0;
        do{
            choice = assTeamUI.getMenuChoice();
            
            if(choice == 0){
                MessageUI.displayExitMessage();
                break;
            }
            else if (choice == reportNum){
                assTeamUI.Report();               
            }
            else if (choice < reportNum){
                int choice2 = 0;
                do{
                    ArrayList<Team> filteredTeam = new ArrayList<>();
                    TutorialGroup search = tg.getTutorialGroupList().getEntry(choice-1);
                    for(int i=0; i< team.getTeamList().size(); i++){
                        if(team.getTeamList().getEntry(i).getTg().equals(search)){
                            filteredTeam.add(team.getTeamList().getEntry(i));
                        }           
                    }
                    choice2 = assTeamUI.getAssTeamChoice(search);
                    if(choice2 == 0){
                        break;
                    }
                    else if(choice2 == reportNum2){
                        assTeamUI.Report();
                    }
                    else if (choice2 < reportNum2){
                        Team search2 = filteredTeam.getEntry(choice2-1);
                        assTeamUI.displayStudent(search, search2);
                    }
                    
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
