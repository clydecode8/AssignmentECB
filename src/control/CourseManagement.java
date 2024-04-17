
package control;
import adt.CircularArrayList;
import boundary.CourseManagementUI;
import entity.Course;
import entity.Programme;
import entity.Semester;
import utility.MessageUI;
import java.util.Scanner;

/**
 *
 * @author limws
 */
public class CourseManagement {
    private CourseManagementUI cmUI =new CourseManagementUI();
    private Course course =new Course();
    private Programme programme = new Programme();
    private Semester semester =new Semester();
    
    

    public void CourseManagement(){
        Scanner scanner = new Scanner(System.in);
        
        Course oop =new Course("Object Oriented Programming","BACS1000","(OOP) is a computer programming model that organizes software design around data, or objects,rather than functions and logic.");
        Course dsa =new Course("Data Structure Algorithm","BACS1220","Data Structures is about how data can be stored in different structures.Algorithms is about how to solve different problems");
        Course gp =new Course("Graphic Programming","BAGP1100","Graphic Programming is a way to create programs by using pictures or symbols instead of text.");
        Course rm =new Course("Research Method","BBRM1120","Research methods are strategies, processes, or techniques used to collect data or evidence for analysis.");
        Course adm =new Course("Advanced Discrete Mathematics","BACS2000","Advanced discrete mathematics covers combinatorics and graph theory, with an emphasis on applications");
        Course hci =new Course("Human Computer Interaction","BACS2032","(HCI) is a multidisciplinary field that studies how people and computers interact.");
        Course ae =new Course("Academic English","BDSS1336","(AE) is a formal style of English used in academia for reading, writing, and studying about academic subjects");
        Course eh=new Course("Ethical Hacking","BASC2039","Ethical hacking is a process of detecting vulnerabilities in an application, system, or organization's infrastructure that an attacker can use to exploit an individual or organization.");
        
        Programme se =new Programme("Bachelor Degree in SoftwareEngineering","2024");
        Programme ds =new Programme("Bachelor Degree in DataScience","2024");
        Programme cs =new Programme("Bachelor Degree in CyberSecurity","2023");
        
        course.setCourseList(oop);
        course.setCourseList(dsa);
        course.setCourseList(gp);
        course.setCourseList(rm);
        course.setCourseList(adm);
        course.setCourseList(hci);
        course.setCourseList(ae);
        course.setCourseList(eh);
        
        programme.setProgrammeList(se);
        programme.setProgrammeList(ds);
        programme.setProgrammeList(cs);
        
        int choice =0;
        do{
            choice=cmUI.getMenuChoice();
            if(choice ==0){
                MessageUI.displayExitMessage();
                break;
            }
            else if(choice ==1){
                displayCourse();
                System.out.print("Enter choice: ");
                int courseChoice = scanner.nextInt();
                scanner.nextLine();
                displayProgramme();
                System.out.print("\nEnter choice: ");
                int programmeChoice = scanner.nextInt();
                scanner.nextLine();
                addCoursetoProgramme(courseChoice,programmeChoice);
            }
            
        }while (choice !=0);
    }
    
    
    public void displayCourse(){
        System.out.println("Choose 1 course to be added into programme");
        System.out.println("---------------------------------------------");
        int num=1;
        for(int i =0;i<course.getCourseList().size();i++){
            System.out.println(num+": " + course.getCourseList().getEntry(i).toString());
            num++;
        }
        
    }
    
    public void displayProgramme(){
        System.out.println("Choose which programme to be added in ");
        System.out.println("---------------------------------------------");
        int num=1;
        for(int i =0;i<programme.getProgrammeList().size();i++){
            System.out.println(num+" " + programme.getProgrammeList().getEntry(i).toString());
            num++;
        }
        
    }
    

    public void addCoursetoProgramme(int courseChoice,int programmeChoice){
        programme.getProgrammeList().getEntry(programmeChoice-1).getCourseList().add(course.getCourseList().getEntry(courseChoice-1));
        //System.out.println(programme.getProgrammeList().getEntry(programmeChoice-1).getCourseList().getEntry(courseChoice-1).toString() + programme.getProgrammeList().getEntry(programmeChoice-1).toString());
    }
    
    public static void main(String[] args) {
        CourseManagement courseManagement = new CourseManagement();
        courseManagement.CourseManagement();
    }
    
    
    
    
}
