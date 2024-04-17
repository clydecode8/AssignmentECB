
package entity;

import adt.CircularArrayList;

/**
 *
 * @author limws
 */
public class Semester {
    private int year;
    private int sem;
    private CircularArrayList<Course> courseList;
    
    public Semester(){
        
    }

    public Semester(int year, int sem, CircularArrayList<Course> courseList) {
        this.year = year;
        this.sem = sem;
        this.courseList = courseList;
    }

    public int getYear() {
        return year;
    }

    public int getSem() {
        return sem;
    }

    public CircularArrayList<Course> getCourseList() {
        return courseList;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setSem(int sem) {
        this.sem = sem;
    }

    public void setCourseList(CircularArrayList<Course> courseList) {
        this.courseList = courseList;
    }
    
}
