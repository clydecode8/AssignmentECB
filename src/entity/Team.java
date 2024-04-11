package entity;

import adt.ArrayList;
import entity.Student;
/**
 *
 * @author jie
 */
public class Team implements Comparable<Team>{
    private String teamName;
    private String subject;
    private TutorialGroup tg;
    private final static ArrayList<Team> teamList = new ArrayList<>();
    
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

        public static ArrayList<Team> getTeamList() {
        return teamList;
    }

    public static void setTeamList(Team team) {
        teamList.add(team);
    }
    
    @Override
    public int compareTo(Team o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
