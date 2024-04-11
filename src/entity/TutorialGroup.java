/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Objects;

/**
 *
 * @author User
 */

public class TutorialGroup implements Comparable<TutorialGroup>{
    
    private String name;
    private String id;
    private Programme programme;
    private int numb;
    
    public TutorialGroup() {
        
        this.name = "";
        this.id = "";
        this.numb = 0;
        this.programme = null;
    }

    public TutorialGroup(String name, String id, int numb, Programme programme) {

      this.name = name;
      this.id = id;
      this.numb = numb;
      this.programme = programme;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    

    
    
    @Override
    public String toString() {
        return String.format("%-10s %-40s %-40s %-40s", name, id, numb, programme.toString());
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
        return Objects.equals(name, other.name) &&
                Objects.equals(id, other.id) &&
               Objects.equals(programme, other.programme);
    }
    
    

    @Override
    public int hashCode() {
        return Objects.hash(name, id, programme);
    }

    @Override
    public int compareTo(TutorialGroup other) {
        
    String thisName = this.getName();
    String otherName = other.getName();

    // Handle null values
    if (thisName == null && otherName == null) {
        return 0; // Both names are null, consider them equal
    } else if (thisName == null) {
        return -1; // This name is null, consider it less than the other name
    } else if (otherName == null) {
        return 1; // Other name is null, consider it greater than this name
    }

    // Compare based on the names
    return thisName.compareTo(otherName); 
    }


    
}
