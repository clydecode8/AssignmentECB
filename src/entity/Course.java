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
public class Course implements Comparable<Course> {
    private String courseName;
    private String courseID;
    private String courseDetails;
    private double courseprice;
    private String semester;
    private final static LinkedListInterface<String> courseType = new LinkedList<>();
    private static ListInterface<Programme> programmeList =new CircularArrayList<>();
    private static ListInterface<Course> courseList = new CircularArrayList<>();
    private final static LinkedListInterface<Course> courseListlinked = new LinkedList<>();
    private LinkedListInterface<Student> studentList = new LinkedList<>();
    private SortedLinkedListInterface<Tutor> tutorList = new SortedLinkedList<>();


    
    public Course(){
        
    }
    
    public Course(String courseName, String courseID, String courseDetails,String semester) {
        this.courseName = courseName;
        this.courseID = courseID;
        this.courseDetails = courseDetails;
        this.semester=semester;
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

    public SortedLinkedListInterface<Tutor> getTutorList() {
        return tutorList;
    }

    public void setTutorList(SortedLinkedListInterface<Tutor> tutorList) {
        this.tutorList = tutorList;
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
    
        public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public static ListInterface<Programme> getProgrammeList() {
        return programmeList;
    }

    public static void setProgrammeList(ListInterface<Programme> programmeList) {
        Course.programmeList = programmeList;
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
        return String.format("Course Name: %-30s Course ID: %-15s Course Details: %-15s " ,courseName,courseID,courseDetails);
    }
    
    public String toStringSem() {
        return String.format("Course Name: %-30s Course ID: %-15s Sem offered: %-15s " ,courseName,courseID,semester);
    }
    
    public String toString2() {
        return String.format("Course Name: %-15s Course ID: %-15s Course price: RM %.2f " ,courseName,courseID,courseprice);
    }
    
    @Override
    public int compareTo(Course other) {
        
        return 1;
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
