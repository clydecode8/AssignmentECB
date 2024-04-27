package boundary;
import adt.SortedLinkedListInterface;
import adt.SortedLinkedList;
import control.Driver;
import entity.Tutor;
import entity.TutorialGroup;
import entity.Course;
import java.util.Scanner;
import control.TeachingAssignment;
import static control.TeachingAssignment.tutorList;
import entity.CourseTutorCombine;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import utility.Clear;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author deede
 */
public class TeachingAssignmentUI {

    Scanner scanner = new Scanner(System.in);
    private Tutor tutor = new Tutor();
    private TutorialGroup tg = new TutorialGroup();
    private Course course = new Course();
    private CourseTutorCombine ctcombine = new CourseTutorCombine();
    private SortedLinkedListInterface<CourseTutorCombine> combineList = TeachingAssignment.courseTutorCombineList;
    private SortedLinkedListInterface<Tutor> tutorList;
    private SortedLinkedListInterface<Course> courseList;

    public int getMenuChoice() {
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

        System.out.print("Enter Your Choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return choice;

    }

    
    public void assignTutorToCourse() {
        System.out.println("--------------------------------Assign Tutor To Course-----------------------------");
        System.out.println("    Course ID                  Course Name               Course Details");

    }
    public void assignTutorialTutor(){
            System.out.println("----------------------------Assign tutorial groups to a tutor----------------------------");
    }
    public void displayTitleTutorial(){
        System.out.println("---------Tutorial Grouop---------");
    }
    public void displayDetailsTutorialGroup(){
        System.out.println("    Group Name      Qty");
    }
    
    public int inputCourse(){
        System.out.println("---------------------------------------------------------------------------------");
        System.out.print("Enter Your Number Selection: ");
        int select = scanner.nextInt();
        System.out.println();
        return select;
    }

    public int tutortype() {
        System.out.println(" Tutor Type");
        System.out.println("1. T(Tutorial) ");
        System.out.println("2. P(Practical) ");
        System.out.println("3. L(Lecturer) ");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.print("Enter Your Type: ");
        int select = scanner.nextInt();
        return select;
        
    }

    public int chooseTutorialGroup() {
        System.out.println("---------------------------------------------------------------------------------");
        System.out.print("Enter Tutorial Group:");
        int result = scanner.nextInt();
        return result;

    }

    public void getTutorCourse() {
        System.out.println("--------------------Add Tutors to Tutorial Group for a Course--------------------");
//        //section1 : select course
//        SortedLinkedListInterface<CourseTutorCombine> tutorCourse = new SortedLinkedList<>();
//        
//        Tutor selectedTutor = displayAllTutor();//get tutor name
//        System.out.println(selectedTutor.getTutorName() + " and the course");
//
//        //filter to add into tutorCourse
//        for (int i = 1; i <= TeachingAssignment.courseTutorCombineList.getNumberOfEntries(); i++) {
//
//            //check isNull
//            if (TeachingAssignment.courseTutorCombineList.getEntry(i) != null) {
//                //check selectedtutor
//                if (TeachingAssignment.courseTutorCombineList.getEntry(i).getTutor().equals(selectedTutor)) {
//                    //filter to get tutor x course
//                    if (TeachingAssignment.courseTutorCombineList.getEntry(i).getCourse() != null
//                            && !"".equals(TeachingAssignment.courseTutorCombineList.getEntry(i).getCourse().getCourseName())) {
//                        tutorCourse.add(TeachingAssignment.courseTutorCombineList.getEntry(i));
//
//                    }
//
//                }
//
//            }
//        }
//
//        //display filtered result
//        for (int i = 1; i <= tutorCourse.getNumberOfEntries(); i++) {
//
//            System.out.print(i + ")");
//            System.out.print(TeachingAssignment.courseTutorCombineList.getEntry(i).getTutor().getTutorId() + "  ");
//            System.out.print(TeachingAssignment.courseTutorCombineList.getEntry(i).getTutor().getTutorName() + " ");
//            System.out.println(TeachingAssignment.courseTutorCombineList.getEntry(i).getCourse().getCourseName());
//        }
//
//        System.out.println("---------------------------------------------------------------------------------");
//        System.out.print("Enter a course:");
//        int result = scanner.nextInt();
//        System.out.println();
//        // target selected ctb in ctbList
//        CourseTutorCombine selectedTutorCourse = tutorCourse.getEntry(result);
//
//        return selectedTutorCourse;
    }

    public void searchCourseUnderTutor() {
        System.out.println("---------------------------Search Courses Under a Tutor---------------------------");
        
       

    }

    public void searchTutorsForCourse() {
        System.out.println("---------------------------Search Tutor For a Course---------------------------");
        System.out.println("   Course ID         Course Name                  ");
       

    }

    public void listTutorsAndTutorialGroupsForCourse() {
        System.out.println("--------------------List Tutors and Tutorial Group For Course--------------------");
        System.out.println("   Course ID         Course Name   ");
    }

    public void listCoursesForTutors() {
        System.out.println("---------------------------List Courses For Tutor---------------------------");

    }

    public int filterTutorsBasedOnType() {
        System.out.println("---------------------------Filter Tutors Based On Type---------------------------");
        System.out.println("1. T");
        System.out.println("2. P");
        System.out.println("3. L");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.print("Enter Your Selection(1/2/3): ");
        int result = scanner.nextInt();
        System.out.println();
        System.out.println("   Tutor ID           Tutor Name        Tutor Type                          Course Name");
        return result;


    }

    public void report1() {
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();
        // Define a format for the date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        // Format the current date and time using the defined format
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.printf("*".repeat(120));
        System.out.println("\n");
        System.out.println(" ".repeat(25)+"TUNKU ABDUL RAHMAN UNIVERSITY OF MANAGEMENT AND TECHNOLOGY      ");
        System.out.printf(" ".repeat(35) + "Teaching Assignment Subsystem Summary Report");
        System.out.println("\n");
        System.out.printf("*".repeat(120) + "\n");
        System.out.printf("Report generated on: " + formattedDateTime);
        System.out.println("\n");
        System.out.println("         TUTOR ID                TUTOR NAME                  NO OF COURSE            NO OF GROUP         ");
        System.out.println("        -----------             ---------------            -----------------        --------------");
        
        

    }
    
    public void report2() {
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();
        // Define a format for the date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        // Format the current date and time using the defined format
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.printf("*".repeat(120));
        System.out.println("\n");
        System.out.println(" ".repeat(25)+"TUNKU ABDUL RAHMAN UNIVERSITY OF MANAGEMENT AND TECHNOLOGY      ");
        System.out.printf(" ".repeat(35) + "Teaching Assignment Subsystem Summary Report");
        System.out.println("\n");
        System.out.printf("*".repeat(120) + "\n");
        System.out.printf("Report generated on: " + formattedDateTime);
        System.out.println("\n");
        System.out.println("         COURSE ID               COURSE NAME                NO TUTOR             NO TUTORIAL GROUP          ");
        System.out.println("        -----------            ---------------            --------------        --------------------        ");
        
        //loop 
        System.out.println();
 
    }
     
    public static void pressToContinue() {
        System.out.print("Press <Enter> to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // Wait for the user to press Enter
    }
    
    public static void clrscreen(){
        try {
            Clear.clrscreen();
        } catch(InterruptedException ex){
            Logger.getLogger(TeachingAssignmentUI.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public int generateSummaryReports() {

        System.out.println("1.Report Tutor Course Tutorial Group");
        System.out.println("2.Report Course Tutor Tutorial Group");
        System.out.print("Enter your selection :");
        int select = scanner.nextInt();
        return select;


    }

}
//    public CourseTutorCombine getTutorGroup(CourseTutorCombine selectedTutorCourse) {
//        Tutor selectedTutor = selectedTutorCourse.getTutor();
//        //section2 : select group
//        SortedLinkedListInterface<CourseTutorCombine> tutorGroup = new SortedLinkedList<>();
//        //filter out ctbList to get tutor x group
//        for (int i = 1; i <= TeachingAssignment.courseTutorCombineList.getNumberOfEntries(); i++) {
//            //check isNull
//            if (TeachingAssignment.courseTutorCombineList.getEntry(i) != null) {
//                //check tutor
//                if (TeachingAssignment.courseTutorCombineList.getEntry(i).getTutor().equals(selectedTutor)) {
//                    //check has group
//                    if (TeachingAssignment.courseTutorCombineList.getEntry(i).getTutorialgroup() != null) {
//                        tutorGroup.add(TeachingAssignment.courseTutorCombineList.getEntry(i));
//                    }
//                }
//            }
//        }
//
//        //display filtered result
//        for (int i = 1; i <= tutorGroup.getNumberOfEntries(); i++) {
//            System.out.print((i) + ")");
//            System.out.print(tutorGroup.getEntry(i).getTutorialgroup().getGroup() + " ");
//            System.out.println(tutorGroup.getEntry(i).getTutorialgroup().getQty());
//        }
//
//        System.out.println("---------------------------------------------------------------------------------");
//        System.out.print("Select Number Tutotrial Group Want to assign:");
//        int tgresult = scanner.nextInt();
//        System.out.println();
//
//        CourseTutorCombine selectedGroup = tutorGroup.getEntry(tgresult);
//
//        return selectedGroup;
//    }

