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
public class Programme {
 
    private String name;
    private String id;

    public Programme() {

    }

    public Programme(String name, String id ) {

      this.name = name;
      this.id = id;
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
        return String.format("%-10s %-40s", name, id);
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
               Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}
