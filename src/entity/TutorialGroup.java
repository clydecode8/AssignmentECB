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
public class TutorialGroup {
    
    private String name;
    private String id;
    private Programme programme;
    
    public TutorialGroup() {
        
        this.name = "";
        this.id = "";
        this.programme = null;
    }

    public TutorialGroup(String name, String id, Programme programme) {

      this.name = name;
      this.id = id;
      this.programme = programme;
    }


    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getID() {
      return name;
    }

    public void setID(String id) {
      this.id = id;
    }
    
    
    @Override
    public String toString() {
        return String.format("%-10s %-40s %-40s", name, id, programme.toString());
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
    
}

