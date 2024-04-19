package boundary;
import adt.SortedLinkedListInterface;
import adt.SortedLinkedList;
import entity.Tutor;
import entity.TutorialGroup;
import entity.Course;
import java.util.Scanner;
import control.TeachingAssignment;
/**
 *
 * @author deede
 */
public class TeachingAssignmentUI {
    Scanner scanner = new Scanner(System.in);
    private Tutor tutor = new Tutor();
    private TutorialGroup tg = new TutorialGroup();
    private Course course = new Course();
    
    
    public int getMenuChoice(){
        System.out.println("Teaching Assignment System");
        System.out.println("---------------------------");
        System.out.println("1. Assign Tutor to Course");
        System.out.println("2. Add Tutors to Tutorial Group for a Course");
        System.out.println("3. Search Courses Under a Tutor");
        System.out.println("4. Search Tutors for a Course (Tutorial/Lecture/Practical)");
        System.out.println("5. List Tutors and Tutorial Groups for a Course");
        System.out.println("6. List Courses for Each Tutor");
        System.out.println("7. Filter Tutors Based on Criteria");
        System.out.println("8. Generate Summary Reports");
        System.out.println("0. Quit");
        
        System.out.print("Enter your choice: ");
        int choice =scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return choice;
        
    }
    
    public final static void clscr(){
       System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
    public Course assignTutorToCourse(){
        System.out.println("Assign Tutor To Course");
        SortedLinkedListInterface<Course> courseList = TeachingAssignment.courseList;
        for (int i = 0 ; i< courseList.getNumberOfEntries();i++){
            System.out.println((i+1)+")");
            System.out.println(courseList.getEntry(i+1));
             
        }
        System.out.println();
        System.out.println("---------------------------");
        System.out.println();
        System.out.print("Enter Your Selection: ");
        int select = scanner.nextInt();
        Course course = courseList.getEntry(select-1);
        return course;
    }
    public Tutor displayAllTutor(){
        SortedLinkedListInterface<Tutor> tutorList = tutor.getTutorList();
        for(int i = 0 ; i < tutorList.getNumberOfEntries();i++){
            System.out.println((i+1)+")");
            System.out.println(tutorList.getEntry(i+1).getTutorId());
            System.out.println(tutorList.getEntry(i+1).getTutorName());
            
        }
        System.out.println("Enter Your Selection2");
        int select = scanner.nextInt();
        Tutor tutorresult = tutor.getTutorList().getEntry(select-1);
        return tutorresult;
        
    }
    
    
    
   
          
    
    
    
//    }
//    public String searchTutorsForCourse(){
//        
//    }
//    public String listTutorsAndTutorialGroups(){
//        
//    }
//    public String listCoursesForTutors(){
//        
//    }
//    public String filterTutors(){
//        
//    }
//    public String generateSummaryReports(){
//        
//    }

    
}
