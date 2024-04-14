package entity;

import adt.ArrayList;
import adt.CircularArrayList;
import adt.LinkedList;
import adt.LinkedListInterface;
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
    private final static CircularArrayList<Course> courseList = new CircularArrayList<>();
    private LinkedList<Course> CourseList = new LinkedList<>();
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
    
    public static ListInterface<Course> getCourseList() {
            return courseList;
        }

    public LinkedListInterface<Course> getCourseList2() {
            return CourseList;
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

    public void setCourseList2(Course course){
        CourseList.add(course);
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
    
    public void setCourseList(Course course) {
        courseList.add(course);
        
    }
    
    public void getCourseType(String courseType) {
        this.courseType = courseType;
    }

    public void setStudentList(LinkedList<Student> studentList) {
        this.studentList = studentList;
    }
    
    @Override
    public String toString() {
        return String.format("Course Name: %-30s Course ID: %-15s " ,courseName,courseID);
    }

    //@Override
    //public String toString() {
    //    return String.format("Course Name: %-30s Course ID: %-15s Course Details: %-1000s" ,courseName,courseID,courseDetails);
   // }
    
}
