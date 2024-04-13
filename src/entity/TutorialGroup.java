/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import adt.ArrayList;
import adt.ArrayQueueInterface;
import adt.CustomArrayQueue;
import adt.ListInterface;
import java.util.Objects;

/**
 *
 * @author User
 */

public class TutorialGroup implements Comparable<TutorialGroup>{
    
    private String group;
    private int qty;
    private Programme programme;
    private int numb;
    private final static ListInterface<TutorialGroup> tutorialGroupList = new ArrayList<>();   
    private final static ArrayQueueInterface<TutorialGroup> tutorialGroupQueue = new CustomArrayQueue<>();    

    private ListInterface<Student> stdList = new ArrayList<>();
    private ArrayQueueInterface<Student> stdQueue = new CustomArrayQueue<>();

    
    public TutorialGroup() {
        
        this.group = "";
        this.qty = 0;
        this.programme = null;
  
    }

    public TutorialGroup(String group, int qty, Programme programme) {

      this.group = group;
      this.qty = qty;
      this.programme = programme;
      
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Programme getProgramme() {
        return programme;
    }

    public void setProgramme(Programme programme) {
        this.programme = programme;
    }

    public int getNumb() {
        return numb;
    }

    public void setNumb(int numb) {
        this.numb = numb;
    }    
    
   public static ListInterface<TutorialGroup> getTutorialGroupList() {
        return tutorialGroupList;
    }
   
   public static ArrayQueueInterface<TutorialGroup> getTutorialGroupQueue() {
        return tutorialGroupQueue;
    }

    public static void setTutorialGroupList(TutorialGroup tg) {
        tutorialGroupList.add(tg);
        tutorialGroupQueue.enqueue(tg);
    }
    
    public ListInterface<Student> getStudentList() {
        return stdList;
    }

    public ArrayQueueInterface<Student> getStudentQueue() {
        return stdQueue;
    }

    public void addStudentList(Student std) {
        stdList.add(std);
        stdQueue.enqueue(std);
    }

    @Override
    public String toString() {
        return String.format("%-10s %-15s %-40s", group, qty, programme.toString());
    }
   

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TutorialGroup other = (TutorialGroup) obj;
        return Objects.equals(group, other.group) &&
                Objects.equals(qty, other.qty) &&
               Objects.equals(programme, other.programme);
    }
    
    

    @Override
    public int hashCode() {
        return Objects.hash(group, qty, programme);
    }

    @Override
    public int compareTo(TutorialGroup other) {
        
        String thisName = this.getGroup();
        String otherName = other.getGroup();

        // Handle null values
        if (thisName == null && otherName == null) {
            
            return 0; // Both names are null, consider them equal
        
        }else if (thisName == null) {
            
            return -1; // This name is null, consider it less than the other name
        
        } else if (otherName == null) {
            
            return 1; // Other name is null, consider it greater than this name
        }

        // Compare based on the names
        return thisName.compareTo(otherName); 
    }


    
}

