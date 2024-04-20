package boundary;
import adt.SortedLinkedListInterface;
import adt.SortedLinkedList;
import entity.Tutor;
import entity.TutorialGroup;
import entity.Course;
import java.util.Scanner;
import control.TeachingAssignment;
import entity.CourseTutorCombine;
/**
 *
 * @author deede
 */
public class TeachingAssignmentUI {
    Scanner scanner = new Scanner(System.in);
    private Tutor tutor = new Tutor();
    private TutorialGroup tg = new TutorialGroup();
    private Course course = new Course();
    private CourseTutorCombine ctcombine= new CourseTutorCombine();
    
    
    public int getMenuChoice(){
        System.out.println("Teaching Assignment System");
        System.out.println("---------------------------");
        System.out.println("1. Assign Tutor to Course");
        System.out.println("2. Assign tutorial groups to a tutor");
        System.out.println("3. Add Tutors to Tutorial Group for a Course");
        System.out.println("4. Search Courses Under a Tutor");
        System.out.println("5. Search Tutors for a Course (Tutorial/Lecture/Practical)");
        System.out.println("6. List Tutors and Tutorial Groups for a Course");
        System.out.println("7. List Courses for Each Tutor");
        System.out.println("8. Filter Tutors Based on Criteria");
        System.out.println("9. Generate Summary Reports");
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
            System.out.print((i+1)+")");
            System.out.println(courseList.getEntry(i+1));    
        }
        System.out.println("---------------------------");
        System.out.println();
        System.out.print("Enter Your Selection: ");
        int select = scanner.nextInt();
        Course course = courseList.getEntry(select);
        return course;
    }
    public char tutortype(){
        System.out.print("Enter Your Type: ");
        System.out.print("1. T(Tutorial) ");
        System.out.print("2. P(Practical) ");
        System.out.print("3. L(Lecturer) ");
        int select2 = scanner.nextInt();
        char tutortype = 'L';
        switch(select2){
            case 1: 
                tutortype = 'T';
                break;
            case 2: 
                tutortype = 'P';
                break;  
            case 3: 
                tutortype = 'L';
                break;
        }
        System.out.println(tutortype);
        return tutortype;
        
    }
    public Tutor displayAllTutor(){
        SortedLinkedListInterface<Tutor> tutorList = tutor.getTutorList();
        for(int i = 0 ; i < tutorList.getNumberOfEntries();i++){
            System.out.print((i+1)+")");
            System.out.print(tutorList.getEntry(i+1).getTutorId()+ " ");
            System.out.print(tutorList.getEntry(i+1).getTutorName()+ " ");
            System.out.print(tutorList.getEntry(i+1).getGender()+ " ");
            System.out.println(tutorList.getEntry(i+1).getAge()+ " ");
            
        }
        System.out.println("Enter your selection:");
        int select = scanner.nextInt();
        Tutor tutorresult = tutor.getTutorList().getEntry(select);
        return tutorresult;
        
    }
    
   
    public TutorialGroup chooseTutorialGroup(){
        SortedLinkedListInterface<TutorialGroup> tutorGrpList =  new SortedLinkedList<>();
        tutorGrpList =  TeachingAssignment.tutorGrpList;
        
        for(int i = 0 ; i < tutorGrpList.getNumberOfEntries();i++){
            System.out.print((i+1)+")");
            System.out.print( tutorGrpList.getEntry(i+1).getGroup()+"\n");
            System.out.println("Qty:" + tutorGrpList.getEntry(i+1).getQty());
           
            
        }
        System.out.println("Enter Tutorial Group:");
        int result = scanner.nextInt();
        TutorialGroup tgresult = tutorGrpList.getEntry(result);
        return tgresult;
    }
    
    public void addTutorToTutorialGroupToCourse(){
        System.out.println("Add Tutors to Tutorial Group for a Course");
        
    }
    

    public Tutor searchCourseUnderTutor(){
        SortedLinkedListInterface<Tutor> tutorList = tutor.getTutorList();
        System.out.println("Search Courses Under a Tutor");
        for(int i = 0 ; i < tutorList.getNumberOfEntries();i++){
            System.out.print((i+1)+")");
            System.out.print(tutorList.getEntry(i+1).getTutorId()+ " ");
            System.out.print(tutorList.getEntry(i+1).getTutorName()+ " ");
            System.out.print(tutorList.getEntry(i+1).getGender()+ " ");
            System.out.println(tutorList.getEntry(i+1).getAge()+ " ");
            
        }
        System.out.println("Enter a Tutor:");
        int result = scanner.nextInt();
        Tutor tutorresult = tutor.getTutorList().getEntry(result);
        return tutorresult;
        
    }
    public Course searchTutorsForCourse(){
        SortedLinkedListInterface<Course> courseList = TeachingAssignment.courseList;
        System.out.println("Search Tutors For Course");
        for(int i = 0 ; i < courseList.getNumberOfEntries();i++){
            System.out.print((i+1)+")");
            System.out.println(courseList.getEntry(i+1).getCourseID());
            System.out.println(courseList.getEntry(i+1).getCourseName());
            
            
        }
        System.out.print("Enter a Course:");
        int result = scanner.nextInt();
        Course courseresult = courseList.getEntry(result);
        return courseresult;
    }
         
         
        
           
//        SortedLinkedListInterface<CourseTutorCombine> ctc = ctcombine.getCourseTutorCombineList();
//        for(int i = 0 ; i < ctc.getNumberOfEntries();i++){
//            System.out.print((i+1)+")");
//            System.out.print( ctc.getEntry(i+1).getCourse());
//
//        }
//        System.out.println("Enter a Course:");
//        int result = scanner.nextInt();
//        CourseTutorCombine tgresult = ctcombine.getCourseTutorCombineList().getEntry(result);
//        return tgresult;

    
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

    

