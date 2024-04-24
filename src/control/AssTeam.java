package control;

//import adt.ArrayQueueInterface;
//import adt.CustomArrayQueue;
//import adt.SortedArrayList;
//import adt.SortedListInterface;
import adt.SortedArrayList;
import adt.SortedListInterface;
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
    public void runAssTeam(){
        
        int reportNum = tg.getSortedTutorialGroup().size();
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
                    SortedListInterface<Team> filteredTeam = new SortedArrayList<>();
                    TutorialGroup search = tg.getSortedTutorialGroup().getEntry(choice-1);
                    choice2=0;
                    teamNum=0;
                    for(int i=0; i< team.getSortedTeam().size(); i++){
                        
                        if(team.getSortedTeam().getEntry(i).getTg().equals(search)){
                            filteredTeam.add(team.getSortedTeam().getEntry(i));
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
                            Team removedTeam = filteredTeam.getEntry(removeNum-1);
                    
                            System.out.println("removedteam: "+removedTeam);
                            for(int i=0; i< Team.getSortedTeam().size(); i++){
                                if(Team.getSortedTeam().getEntry(i).equals(removedTeam)){
                                    for(int j=0; j<Student.getSortedStudentList().size(); j++){
                                        
                                        if(Student.getSortedStudentList().getEntry(j).getTeam() != null){
                                            System.out.println("gg: "+Student.getSortedStudentList().getEntry(j).getTeam().getTeamName());
                                            if(Student.getSortedStudentList().getEntry(j).getTeam().equals(removedTeam)){
                                                Student.getSortedStudentList().getEntry(j).setTeam(null);
                                            }
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
                            Team amendTeam = filteredTeam.getEntry(amendChoice-1);
                            int teamNo = 0;
                            for(int i=0; i< Team.getSortedTeam().size(); i++){
                                if(Team.getSortedTeam().getEntry(i).equals(amendTeam)){                         
                                   teamNo = i;
                                   break;
                                }
                            }
                            int amendChoice2 = assTeamUI.amendTeamChoice(amendTeam);
                            if(amendChoice2 != 0){
                                String newData = assTeamUI.amendTeamInput(amendChoice2);
                                if (newData != null){
                                    if(amendChoice2 == 1){
                                        Team.getSortedTeam().getEntry(teamNo).setTeamName(newData);
                                    }
                                    else if(amendChoice2 == 2){
                                        Team.getSortedTeam().getEntry(teamNo).setSubject(newData);
                                    }

                                }
                            }
                           
                        }
                        
                        
                    }
                    // merge assignment group
                    else if (choice2 == teamNum + 5){
                        SortedListInterface<Integer> mergeChoice = assTeamUI.mergeTeam(search);                   

                        Team mergeTeam1 = filteredTeam.getEntry((mergeChoice.getEntry(0))-1);
                        Team mergeTeam2 = filteredTeam.getEntry((mergeChoice.getEntry(1))-1);          

                        // check whether total num of student > 5 or not
                        int numOfStudent =0;
                        SortedListInterface<Student> studentList = student.getSortedStudentList();
                        for(int i=0; i<studentList.size(); i++){
                            if(studentList.getEntry(i).getTeam() != null){
                                 if(studentList.getEntry(i).getTeam().equals(mergeTeam2) ||
                                  studentList.getEntry(i).getTeam().equals(mergeTeam1)  ){
                                    numOfStudent ++;
                                }
                            }
                           
                        }
                        if(numOfStudent > 5){
                            assTeamUI.error();
                        }
                        else{
                            for(int j=0; j<studentList.size(); j++){
                                if(studentList.getEntry(j).getTeam() != null){
                                    if(studentList.getEntry(j).getTeam().equals(mergeTeam1)){
                                        studentList.getEntry(j).setTeam(mergeTeam2);
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
                            Team search2 = filteredTeam.getEntry(choice2-1);
                            choice3 = assTeamUI.displayStudent(search, search2);              
                            memberNum=0;
                            for(int i=0; i< student.getSortedStudentList().size(); i++){
                                if(student.getSortedStudentList().getEntry(i).getTeam() != null){
                                    if(student.getSortedStudentList().getEntry(i).getTutorialGroup().equals(search) &&
                                            student.getSortedStudentList().getEntry(i).getTeam().equals(search2) ){                                       
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
        assTeam.runAssTeam();
    }
    
}
