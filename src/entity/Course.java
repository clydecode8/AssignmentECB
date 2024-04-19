package entity;

import adt.ArrayList;
import adt.CircularArrayList;
import adt.LinkedList;
import adt.LinkedListInterface;
import adt.ListInterface;
import adt.SortedLinkedList;
import adt.SortedLinkedListInterface;

/**
 *
 * @author limws
 */
public class Course implements Comparable<Course>{
    private String courseName;
    private String courseID;
    private String courseDetails;
    private double courseprice;
    private final static LinkedListInterface<String> courseType = new LinkedList<>();
    private final static CircularArrayList<Course> courseList = new CircularArrayList<>();
    private final static LinkedListInterface<Course> courseListlinked = new LinkedList<>();
    private LinkedListInterface<Student> studentList = new LinkedList<>();
    private SortedLinkedListInterface<Tutor> tutorList = new SortedLinkedList<>();

    
    public Course(){
        
    }
    
    public Course(String courseName, String courseID, String courseDetails) {
        this.courseName = courseName;
        this.courseID = courseID;
        this.courseDetails = courseDetails;
    }
    public Course(String courseName, String courseID, String courseDetails,double courseprice) {
        this.courseName = courseName;
        this.courseID = courseID;
        this.courseDetails = courseDetails;
        this.courseprice = courseprice;
    }

    public String getCourseName() {
        return courseName;
    }
    
    public static ListInterface<Course> getCourseList() {
            return courseList;
        }

    public LinkedListInterface<Course> getCourseList2() {
            return courseListlinked;
        }
    
    public String getCourseID() {   
        return courseID;
    }

    public String getCourseDetails() {
        return courseDetails;
    }
    
    public LinkedListInterface<String> getcourseTypes() {
    return courseType; // Returns a reference to the courseType list (be cautious of modifications)
}
    
    public double getcourseprice(){
        return courseprice;
    }

    public LinkedListInterface<Student> getStudentList() {
        return studentList;
    }

    public void setCourseList2(Course course){
        courseListlinked.add(course);
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
    
    public void setCourseType(String coursetype){
        courseType.add(coursetype);
    }
    
    public void setcourseprice(double courseprice){
        this.courseprice = courseprice;
    }

    public void setStudentList(LinkedList<Student> studentList) {
        this.studentList = studentList;
    }
    
    @Override
    public String toString() {
        return String.format("Course Name: %-30s Course ID: %-15s " ,courseName,courseID);
    }
    
    public String toString2() {
        return String.format("Course Name: %-30s Course ID: %-15s Course price: RM %.2f " ,courseName,courseID,courseprice);
    }
    
    @Override
    public int compareTo(Course other) {
        
        String thisName = this.getCourseName();
        String otherName = other.getCourseName();

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

    //@Override
    //public String toString() {
    //    return String.format("Course Name: %-30s Course ID: %-15s Course Details: %-1000s" ,courseName,courseID,courseDetails);
   // }
    public boolean addTutor(Tutor newTutor){
        this.tutorList.add(newTutor);
        
        return true;
    }
    
}
