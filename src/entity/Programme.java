/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import adt.ArrayList;
import adt.ListInterface;
import java.util.Objects;

/**
 *
 * @author User
 */

public class Programme implements Comparable<Programme>{
 
    private String name;
    private String yearIntake;
    private ListInterface<TutorialGroup> tgList = new ArrayList<>();
    
    public Programme(){
        
        name = "";
        yearIntake = "";
    }
    
    public Programme(String name, String yearIntake) {
        this.name = name;
        this.yearIntake = yearIntake;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearIntake() {
        return yearIntake;
    }

    public void setYearIntake(String yearIntake) {
        this.yearIntake = yearIntake;
    }

   public ListInterface<TutorialGroup> getTutorialGroupList() {
        return tgList;
    }

    public void addTutorialGroupList(TutorialGroup tg) {
        tgList.add(tg);
    }
    
    
    @Override
    public String toString() {
        return String.format("%-25s %-15s", name, yearIntake);
    }
   
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Programme other = (Programme) obj;
        return Objects.equals(name, other.name) &&
               Objects.equals(yearIntake, other.yearIntake);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, yearIntake);
    }

    @Override
    public int compareTo(Programme o) {
       // Compare based on the name of the Programme
       return this.getName().compareTo(o.getName());
    }
}
