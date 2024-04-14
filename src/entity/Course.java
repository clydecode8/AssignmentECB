package entity;

import adt.ArrayList;
import adt.LinkedList;
import adt.ListInterface;

/**
 *
 * @author limws
 */
public class Course {
    private String courseName;
    private String courseID;
    private String courseDetails;
    private String courseType;
    //private final static ListInterface<Course> courseList = new ArrayList<>();
    private LinkedList<Student> studentList = new LinkedList<>();
    
    public Course(){
        
    }
    
    public Course(String courseName, String courseID, String courseDetails) {
        this.courseName = courseName;
        this.courseID = courseID;
        this.courseDetails = courseDetails;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseID() {   
        return courseID;
    }

    public String getCourseDetails() {
        return courseDetails;
    }
    
    public String getcourseType(){
        return courseType;
    }

    public LinkedList<Student> getStudentList() {
        return studentList;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public void setCourseDetails(String courseDetails) {
        this.courseDetails = courseDetails;
    }
    
    public void getCourseType(String courseType) {
        this.courseType = courseType;
    }

    public void setStudentList(LinkedList<Student> studentList) {
        this.studentList = studentList;
    }
    
}
