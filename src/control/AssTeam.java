package control;

import adt.ArrayList;
import adt.ArrayQueueInterface;
import adt.CustomArrayQueue;
import adt.ListInterface;
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


        int reportNum = tg.getTutorialGroupQueue().size();
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
            else if (choice == reportNum+1){
                assTeamUI.GroupReport();               
            }
            else if (choice == reportNum+2){
                assTeamUI.TeamReport();               
            }
            // ass team start
            else if (choice < reportNum){
                int choice2 = 0;
                do{
                    CustomArrayQueue<Team> filteredTeam = new CustomArrayQueue<>();
                    TutorialGroup search = tg.getTutorialGroupQueue().peekMiddle(choice-1);
                    choice2=0;
                    teamNum=0;
                    for(int i=0; i< team.getTeamQueue().size(); i++){
                        
                        if(team.getTeamQueue().peekMiddle(i).getTg().equals(search)){
                            filteredTeam.enqueue(team.getTeamQueue().peekMiddle(i));
                            teamNum++;
                        }    
                        
                               
                    }
               
                    choice2 = assTeamUI.getAssTeamChoice(search);
        
                    if(choice2 == 0){
                        break;
                    }

                    // create assignment team
                    else if(choice2 == teamNum +2){
                        Team newTeam = assTeamUI.createTeam(search);
                        Team.setTeamList(newTeam);
                    }
                    
                    //remove assignment team
                    else if(choice2 == teamNum +3){
                        int removeNum = assTeamUI.removeTeam(search);
                        if(removeNum != 0){
                            Team removedTeam = filteredTeam.peekMiddle(removeNum-1);
                    
                            for(int i=0; i< Team.getTeamQueue().size(); i++){
                                if(Team.getTeamQueue().peekMiddle(i).equals(removedTeam)){
                                    for(int j=0; j<Student.getStudentQueue().size(); j++){
                                        if(Student.getStudentQueue().peekMiddle(j).getTeam().equals(removedTeam)){
                                            Student.getStudentQueue().peekMiddle(j).setTeam(null);
                                        }
                                    }
                                    Team.removeTeam(i);
                                    break;
                                }
                            }
                        }                                                     
                    }
                    // amend assignment team details
                    else if (choice2 == teamNum +4){
                        int amendChoice = assTeamUI.amendTeam(search);
                        if(amendChoice != 0){
                            Team amendTeam = filteredTeam.peekMiddle(amendChoice-1);
                            int teamNo = 0;
                            for(int i=0; i< Team.getTeamQueue().size(); i++){
                                if(Team.getTeamQueue().peekMiddle(i).equals(amendTeam)){                         
                                   teamNo = i;
                                   break;
                                }
                            }
                            int amendChoice2 = assTeamUI.amendTeamChoice(amendTeam);
                            if(amendChoice2 != 0){
                                String newData = assTeamUI.amendTeamInput(amendChoice2);
                                if (newData != null){
                                    if(amendChoice2 == 1){
                                        Team.getTeamQueue().peekMiddle(teamNo).setTeamName(newData);
                                    }
                                    else if(amendChoice2 == 2){
                                        Team.getTeamQueue().peekMiddle(teamNo).setSubject(newData);
                                    }

                                }
                            }
                           
                        }
                        
                        
                    }
                    // merge assignment group
                    else if (choice2 == teamNum + 5){
                        ArrayQueueInterface<Integer> mergeChoice = assTeamUI.mergeTeam(search);                   

                        Team mergeTeam1 = filteredTeam.peekMiddle((mergeChoice.peekMiddle(0))-1);
                        Team mergeTeam2 = filteredTeam.peekMiddle((mergeChoice.peekMiddle(1))-1);

                        // check whether total num of student > 5 or not
                        int numOfStudent =0;
                        ArrayQueueInterface<Student> studentList = student.getStudentQueue();
                        for(int i=0; i<studentList.size(); i++){
                            if(studentList.peekMiddle(i).getTeam() != null){
                                 if(studentList.peekMiddle(i).getTeam().equals(mergeTeam1) ||
                                  studentList.peekMiddle(i).getTeam().equals(mergeTeam2)  ){
                                    numOfStudent ++;
                                }
                            }
                           
                        }
                        if(numOfStudent > 5){
                            assTeamUI.error();
                        }
                        else{
                            for(int j=0; j<studentList.size(); j++){
                                if(studentList.peekMiddle(j).getTeam() != null){
                                    if(studentList.peekMiddle(j).getTeam().equals(mergeTeam2)){
                                        studentList.peekMiddle(j).setTeam(mergeTeam1);
                                    }
                                }
                            }
                            assTeamUI.success();
                        }
                    }
                    
                    // team member start
                    else if (choice2 < (teamNum+1)){
                        int choice3 = 0;
                        do{
                            Team search2 = filteredTeam.peekMiddle(choice2-1);
                            choice3 = assTeamUI.displayStudent(search, search2);              
                            memberNum=0;
                            for(int i=0; i< student.getStudentQueue().size(); i++){
                                if(student.getStudentQueue().peekMiddle(i).getTeam() != null){
                                    if(student.getStudentQueue().peekMiddle(i).getTutorialGroup().equals(search) &&
                                            student.getStudentQueue().peekMiddle(i).getTeam().equals(search2) ){                                       
                                        memberNum++;
                                    }  
                                }
                                         
                            }
                        
                            if(choice3 ==0){
                                break;
                            }
                                                      
                            // add new student
                            else if(choice3 == 6){
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
                            else if (choice3 == 7){
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
