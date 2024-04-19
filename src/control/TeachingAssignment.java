package control;
import adt.SortedLinkedList;
import adt.SortedLinkedListInterface;
import boundary.TeachingAssignmentUI;
import entity.Course;
import entity.Tutor;
import entity.TutorialGroup;
import entity.Programme;
import java.util.Scanner;
import utility.MessageUI;

/**
 *
 * @author deede
 */
public class TeachingAssignment {

    Scanner scanner = new Scanner(System.in);
    private Tutor tutor = new Tutor();
    private TutorialGroup tg = new TutorialGroup();
    private TeachingAssignmentUI teachingUI = new TeachingAssignmentUI();
    private Course course = new Course();
    
    public static SortedLinkedListInterface<Course> courseList= new SortedLinkedList<>();
    public static SortedLinkedListInterface<Tutor> tutorList =new SortedLinkedList<>();

    Programme p1 = new Programme("RSW", "2021");

    
    
   
    
    public void TeachingAssignment() {
        
        //sample tutorial groups
        
        
        
        int choice = 0;
        do {
            choice = teachingUI.getMenuChoice();
            switch (choice) {
                case 1:
                   task1();
                   break;
//                case 2:
//                   task2();
//                   break;
                case 3:
                   
                    
                break;
//               
                case 0:
                    MessageUI.displayExitMessage();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);
    }

    public static void main(String[] args) {

        TeachingAssignment main = new TeachingAssignment();
        main.generateCourseList();
        main.generateTutorList();
        main.TeachingAssignment();
        
    }

    public void tutorialGrpCourse1() {

        //sample tutorial groups
        Programme p1 = new Programme("RSW", "2021");
        TutorialGroup sg1 = new TutorialGroup("Group 1", 24, p1);
        TutorialGroup sg2 = new TutorialGroup("Group 2", 24, p1);
        TutorialGroup sg3 = new TutorialGroup("Group 3", 24, p1);
        TutorialGroup sg4 = new TutorialGroup("Group 4", 24, p1);
        System.out.println("1" + sg1);
        System.out.println("2" + sg2);
        System.out.println("3" + sg3);
        System.out.println("4" + sg4);

    }

    public void tutorialGrpCourse2() {
        
        //sample tutorial groups
        Programme p1 = new Programme("RSW", "2021");
        TutorialGroup dg1 = new TutorialGroup("Group 1", 24, p1);
        TutorialGroup dg2 = new TutorialGroup("Group 2", 24, p1);
        TutorialGroup dg3 = new TutorialGroup("Group 3", 24, p1);
        TutorialGroup dg4 = new TutorialGroup("Group 4", 24, p1);
        System.out.println("1" + dg1);
        System.out.println("2" + dg2);
        System.out.println("3" + dg3);
        System.out.println("4" + dg4);
    }
    public void tutorialGrpCourse3(){
        
        //sample tutorial groups
        Programme p1 = new Programme("RSW", "2021");
        TutorialGroup dg1 = new TutorialGroup("Group 1", 24, p1) ;
        TutorialGroup dg2 = new TutorialGroup("Group 2", 24, p1);
        TutorialGroup dg3 = new TutorialGroup("Group 3", 24, p1);
        TutorialGroup dg4 = new TutorialGroup("Group 4", 24, p1);
        System.out.println("1" + dg1);
        System.out.println("2" + dg2);
        System.out.println("3" + dg3);
        System.out.println("4" + dg4);
    }
    public void task1(){
        Course selectcourse = teachingUI.assignTutorToCourse();
        Tutor displayTutor = teachingUI.displayAllTutor();
    }
//    public void task2(){
//        int choose = teachingUI.assignTutorialGroupToTutor();
//                    switch (choose) {
//                       
//
//                    }
//    }
    public SortedLinkedListInterface<Course> generateCourseList(){
        Course course1 = new Course("English", "C001", "cd1",1000);
        Course course2 = new Course("Discrete Math", "C002", "cd2",1000); 
        Course course3 = new Course("Science","C003","cd3",1000);      
        Course course4 = new Course("Information Security","C004","cd4", 1000);      
        courseList.add(course1);
        courseList.add(course2);
        courseList.add(course3);
        courseList.add(course4);
        courseList.getEntry(1).addTutor(tutorList.getEntry(1));
        courseList.getEntry(2).addTutor(tutorList.getEntry(2));
        courseList.getEntry(3).addTutor(tutorList.getEntry(3));
        courseList.getEntry(4).addTutor(tutorList.getEntry(4));
        
        return courseList;
                
    }
    
    public void generateTutorList(){
        Tutor newTutor1 = new Tutor("TOO1", "Abu","F",30);
        Tutor newTutor2 = new Tutor("TOO2", "Ali","F",40);
        Tutor newTutor3 = new Tutor("TOO3", "Adam","F",50);
        Tutor newTutor4 = new Tutor("TOO4", "Ahman","G",60);
        tutor.setTutorList(newTutor1);
        tutor.setTutorList(newTutor2);
        tutor.setTutorList(newTutor3);
        tutor.setTutorList(newTutor4);

    }
    
    
    
    
    
    
    
}
