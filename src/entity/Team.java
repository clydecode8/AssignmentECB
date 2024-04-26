package entity;

import adt.ArrayList;
//import adt.ArrayQueueInterface;
//import adt.CustomArrayQueue;
import adt.ListInterface;
import adt.SortedArrayList;
import adt.SortedListInterface;
import entity.Student;
/**
 *
 * @author jie
 */
public class Team implements Comparable<Team>{
    private String teamName;
    private String subject;
    private TutorialGroup tg;
    private final static ListInterface<Team> teamList = new ArrayList<>();
    private final static SortedListInterface<Team> sortedTeam = new SortedArrayList<>();
    
    public Team(){
        this.teamName ="";
        this.subject = "";
        this.tg = null;
    }
    
    public Team(String teamName, String subject,TutorialGroup tg ){
        this.teamName = teamName;
        this.subject = subject;
        this.tg = tg;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public TutorialGroup getTg() {
        return tg;
    }

    public void setTg(TutorialGroup tg) {
        this.tg = tg;
    }

    public static ListInterface<Team> getTeamList() {
        return teamList;
    }

    public static void setTeamList(Team team) {
        teamList.add(team);
        sortedTeam.add(team);
    }
    
    public static SortedListInterface<Team> getSortedTeam() {
        return sortedTeam;
    }
    
    public static void removeTeam(int entry){
        teamList.remove(entry);
        sortedTeam.remove(entry);
    }

    @Override
    public int compareTo(Team other) {
        return this.teamName.compareTo(other.teamName);
    }

    
    
}
