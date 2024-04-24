package control;
import adt.SortedLinkedList;
import adt.SortedLinkedListInterface;
import boundary.TeachingAssignmentUI;
import entity.Course;
import entity.CourseTutorCombine;
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
    private CourseTutorCombine coursetutorcombine = new CourseTutorCombine();
    
    public static SortedLinkedListInterface<Course> courseList= new SortedLinkedList<>();
    public static SortedLinkedListInterface<Tutor> tutorList =new SortedLinkedList<>();
    private static SortedLinkedListInterface<CourseTutorCombine> courseTutorCombineList = new SortedLinkedList<>();
    public static SortedLinkedListInterface<TutorialGroup> tutorGrpList =new SortedLinkedList<>();
    Programme p1 = new Programme("", "");

    
   
    
    public void TeachingAssignment() {
        
        //sample tutorial groups
//        generateCourseList();
//        generateTutorList();
//        generateTutorialGrp();
//        TeachingAssignment();
//ignore 
        
        
        int choice = 0;
        do {
            choice = teachingUI.getMenuChoice();
            switch (choice) {
                case 1:
                   task1();
                   break;
                case 2:
                   task2();
                   break;
                case 3:
                   
                break;
                case 4:
                    task4();
                break;
                case 5:
                    task5();
                break;
                
               
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
        main.generateTutorialGrp();
        main.TeachingAssignment();
        
    }

   
    public void task1(){
        
        Course selectcourse = teachingUI.assignTutorToCourse();
        Tutor displayTutor = teachingUI.displayAllTutor();
        char tutorType = teachingUI.tutortype();
        TutorialGroup emptygroup = new TutorialGroup("", 0, new Programme("", ""));
        
//        System.out.println(displayTutor.getTutorName());
//        System.out.println(selectcourse.getCourseDetails());
        CourseTutorCombine ctc = new CourseTutorCombine(displayTutor, selectcourse, emptygroup, tutorType);
        coursetutorcombine.addTutorCombine(ctc);
        for (int i = 0; i <  coursetutorcombine.getCourseTutorCombineList().getNumberOfEntries(); i++) {
            
            if(coursetutorcombine.getCourseTutorCombineList().getEntry(i+1) != null){
                    System.out.println(coursetutorcombine.getCourseTutorCombineList().getEntry(i+1).getTutor().getTutorId());
                    System.out.println(coursetutorcombine.getCourseTutorCombineList().getEntry(i+1).getTutor().getTutorName());
                    System.out.println(coursetutorcombine.getCourseTutorCombineList().getEntry(i+1).getTutor().getAge());
                    System.out.println(coursetutorcombine.getCourseTutorCombineList().getEntry(i+1).getTutor().getGender());
                    System.out.println(coursetutorcombine.getCourseTutorCombineList().getEntry(i+1).getType());
 
            }
   
        }
        System.out.println("Add Successfull !");
        
        
        
    }
    public void task2(){
        Tutor resultTutor = teachingUI.displayAllTutor();
        TutorialGroup resultTutorialGroup = teachingUI.chooseTutorialGroup();
        Course emptygroup = new Course("","","");
        
        CourseTutorCombine ctc = new CourseTutorCombine(resultTutor,emptygroup,resultTutorialGroup,'N');
        coursetutorcombine.addTutorCombine(ctc);
        
         for (int i = 0; i <  coursetutorcombine.getCourseTutorCombineList().getNumberOfEntries(); i++) {
            
            if(coursetutorcombine.getCourseTutorCombineList().getEntry(i+1) != null){
                System.out.println(coursetutorcombine.getCourseTutorCombineList().getEntry(1).getCourse().getCourseName());
                System.out.println(coursetutorcombine.getCourseTutorCombineList().getEntry(1).getCourse().getCourseID());
                
                
            }
            
        }
        
        
        
    }
    public void task3(){
        Course selectcourse = teachingUI.assignTutorToCourse();
        
        
        
        
        
    }
    public void task4(){
        Tutor displayTutor = teachingUI.searchCourseUnderTutor();
        
        for (int i = 0; i <  coursetutorcombine.getCourseTutorCombineList().getNumberOfEntries(); i++) {
            
            if(coursetutorcombine.getCourseTutorCombineList().getEntry(i+1) != null){
                if(displayTutor.getTutorId() == coursetutorcombine.getCourseTutorCombineList().getEntry(i+1).getTutor().getTutorId()){
                    System.out.println(coursetutorcombine.getCourseTutorCombineList().getEntry(i+1).getCourse().getCourseName());
                    System.out.println(coursetutorcombine.getCourseTutorCombineList().getEntry(i+1).getCourse().getCourseID());
                    
                }
                
 
            }
   
        }
        //CourseTutorCombine ctc = teachingUI.searchTutorsForCourse();
  
    }
    public void task5(){
        Course selectcourse = teachingUI.searchTutorsForCourse();
        
        for (int i = 0; i <  coursetutorcombine.getCourseTutorCombineList().getNumberOfEntries(); i++) {
            
            if(coursetutorcombine.getCourseTutorCombineList().getEntry(i+1) != null){
                if(selectcourse.getCourseID() == coursetutorcombine.getCourseTutorCombineList().getEntry(i+1).getCourse().getCourseID()){
                    System.out.println(coursetutorcombine.getCourseTutorCombineList().getEntry(i+1).getTutor().getTutorName());
                    System.out.println(coursetutorcombine.getCourseTutorCombineList().getEntry(i+1).getTutor().getGender());
                    System.out.println(coursetutorcombine.getCourseTutorCombineList().getEntry(i+1).getTutor().getAge());
                    System.out.println(coursetutorcombine.getCourseTutorCombineList().getEntry(i+1).getType());
                    
                }
                
 
            }
   
        }
        
    }
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

    
        
    public SortedLinkedListInterface<TutorialGroup> generateTutorialGrp() {
        TutorialGroup g1 = new TutorialGroup("Group 1", 25, p1);
        TutorialGroup g2 = new TutorialGroup("Group 2", 25, p1);
        TutorialGroup g3 = new TutorialGroup("Group 3", 25, p1);
        TutorialGroup g4 = new TutorialGroup("Group 4", 25, p1);
        tutorGrpList.add(g1);
        tutorGrpList.add(g2);
        tutorGrpList.add(g3);
        tutorGrpList.add(g4);

        return tutorGrpList;

//    Programme p1 = new Programme("Programme Name", "Programme Code");
//    
//    // Create CourseTutorCombine instances
//    CourseTutorCombine sg1 = new CourseTutorCombine(new Tutor(), new Course(), new TutorialGroup("Group 1", 24, p1), 'L');
//    CourseTutorCombine sg2 = new CourseTutorCombine(new Tutor(), new Course(), new TutorialGroup("Group 2", 24, p1), 'L');
//    CourseTutorCombine sg3 = new CourseTutorCombine(new Tutor(), new Course(), new TutorialGroup("Group 3", 24, p1), 'L');
//    CourseTutorCombine sg4 = new CourseTutorCombine(new Tutor(), new Course(), new TutorialGroup("Group 4", 24, p1), 'L');
//    
//    // Add CourseTutorCombine instances to the list
//    courseTutorCombineList.add(sg1);
//    courseTutorCombineList.add(sg2);
//    courseTutorCombineList.add(sg3);
//    courseTutorCombineList.add(sg4);
    }

        
        
    public void tutorialEngGrp() {

        //sample tutorial groups

        TutorialGroup dg1 = new TutorialGroup("Group 1", 25, p1);
        TutorialGroup dg2 = new TutorialGroup("Group 2", 25, p1);
        TutorialGroup dg3 = new TutorialGroup("Group 3", 25, p1);
        TutorialGroup dg4 = new TutorialGroup("Group 4", 25, p1);
        System.out.println("1" + dg1);
        System.out.println("2" + dg2);
        System.out.println("3" + dg3);
        System.out.println("4" + dg4);
    }
    public void tutorialGrp2(){

        //sample tutorial groups
        TutorialGroup dg1 = new TutorialGroup("Group 1", 25, p1) ;
        TutorialGroup dg2 = new TutorialGroup("Group 2", 25, p1);
        TutorialGroup dg3 = new TutorialGroup("Group 3", 25, p1);
        TutorialGroup dg4 = new TutorialGroup("Group 4", 25, p1);
        System.out.println("1" + dg1);
        System.out.println("2" + dg2);
        System.out.println("3" + dg3);
        System.out.println("4" + dg4);

        }
}
    
    
    
    

