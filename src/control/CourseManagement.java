
package control;
import adt.CircularArrayList;
import adt.LinkedList;
import adt.ListInterface;
import boundary.CourseManagementUI;
import entity.Course;
import entity.CourseProgramme;
import static entity.CourseProgramme.removeCourseProgrammeList;
import entity.Programme;
import entity.Semester;
import entity.Student;
import utility.MessageUI;
import java.util.Scanner;


/**
 *
 * @author limws
 */
public class CourseManagement {
    private CourseManagementUI cmUI =new CourseManagementUI();
    private Course course = new Course();
    private Programme programme = new Programme();
    private Semester semester =new Semester();
    private CourseProgramme courseprogramme = new CourseProgramme();
    

    public void CourseManagement(){
        
        Scanner scanner = new Scanner(System.in);
        
        Course oop =new Course("Object Oriented Programming","BACS1000","4credits hour","Y2S1");
        Course dsa =new Course("Data Structure Algorithm","BACS1220","4credits hour","Y2S2");
        Course gp =new Course("Graphic Programming","BAGP1100","4credits hour","Y2S3");
        Course rm =new Course("Research Method","BBRM1120","4credits hour","Y1S1");
        Course adm =new Course("Advanced Discrete Mathematics","BACS2000","4credits hour","Y1S1");
        Course hci =new Course("Human Computer Interaction","BACS2032","4credits hour","Y2S1");
        Course ae =new Course("Academic English","BDSS1336","4credits hour","Y2S2");
        Course eh=new Course("Ethical Hacking","BASC2039","4credits hour","Y2S3");
        Course fr =new Course("Financial Reporting","BAFB2019","4credits hour","Y1S3");
        Course law =new Course("Corporate Law","BAFB1012","4credits hour","Y1S3");
        Course tax =new Course("Malaysian Taxation","BAFB3781","4credits hour","Y1S2");

                
        Programme se =new Programme("Bachelor Degree in SoftwareEngineering","2024","FOCS");
        Programme ds =new Programme("Bachelor Degree in DataScience","2024","FOCS");
        Programme cs =new Programme("Bachelor Degree in CyberSecurity","2024","FOIT");
        Programme is = new Programme("Bachelor Degree in InformationSecurity","2024","FOIT");
        Programme ba =new Programme("Bachelor Degree in Business Administration","2024","FAFB");
        Programme log =new Programme("Bachelor Degree in Logistic","2024","FAFB");
        
        course.setCourseList(oop);
        course.setCourseList(dsa);
        course.setCourseList(gp);
        course.setCourseList(rm);
        course.setCourseList(adm);
        course.setCourseList(hci);
        course.setCourseList(ae);
        course.setCourseList(eh);
        course.setCourseList(fr);
        course.setCourseList(law);
        course.setCourseList(tax);
        
        programme.setProgrammeList(se);
        programme.setProgrammeList(ds);
        programme.setProgrammeList(cs);
        programme.setProgrammeList(is);
        programme.setProgrammeList(ba);
        programme.setProgrammeList(log);
        
        int choice =0;
        do{
            choice=cmUI.getMenuChoice();
            if(choice ==0){
                MessageUI.displayExitMessage();
                break;
            }
            else if(choice==1){
                //display course
                System.out.println("Choose a course that need to add programme");
                System.out.println("---------------------------------------------");
                displayCourse();
                System.out.print("Enter choice: ");
                int courseChoice = scanner.nextInt();
                scanner.nextLine();
                //display programme
                System.out.println("Choose which programme to be added ");
                System.out.println("---------------------------------------------");
                displayProgramme();
                System.out.print("\nEnter choice: ");
                int programmeChoice = scanner.nextInt();
                scanner.nextLine();
                addProgrammetoCourse(courseChoice,programmeChoice);
                displayProgrammeinCourse(courseChoice);
            }
            else if(choice==2){
                //display course
                System.out.println("Choose a course that need to remove programme");
                System.out.println("---------------------------------------------");
                displayCourse();
                System.out.print("Enter choice: ");
                int courseChoice = scanner.nextInt();
                scanner.nextLine();
                //display programme
                System.out.println("Choose which programme to be remove ");
                System.out.println("---------------------------------------------");
                CourseProgramme cp = removeProginCourse(courseChoice);
         
                removeCourseProgrammeList(cp);
                displayProgrammeinCourse(courseChoice);
            }
            else if(choice ==3){
                //display programme
                System.out.println("Choose a programme that need to add new course");
                System.out.println("-----------------------------------------------");
                displayProgramme();
                System.out.print("\nEnter choice: ");
                int programmeChoice = scanner.nextInt();
                addNewCoursetoProgramme(programmeChoice);
                displayCourseinProgramme(programmeChoice);
            }
            else if(choice==4){
                System.out.println("Choose a programme that need to remove course");
                System.out.println("-----------------------------------------------");
                displayProgramme();
                System.out.print("\nEnter choice: ");
                int programmeChoice = scanner.nextInt();
                CourseProgramme cp = removeCourseinProgramme(programmeChoice);     
                removeCourseProgrammeList(cp);
                displayCourseinProgramme(programmeChoice);
            }
            else if(choice ==5){
                System.out.println("Choose a sem to list available course in it");
                System.out.println("-----------------------------------------------");
                displayCourseinSem();
            }
            else if(choice==6){
                System.out.println("Choose a programme to edit details of courses in it");
                System.out.println("-----------------------------------------------");
                displayProgramme();
                editCourseDetails();
                
            }
            else if(choice==7){
                System.out.println("Choose a faculty to list course taken");
                System.out.println("-----------------------------------------------");
                displayCoursesByFaculty();
            }
            else if(choice==8){
               System.out.println("Choose a programme to view course available in it");
               System.out.println("-----------------------------------------------");
               displayProgramme();
               System.out.print("\nEnter choice: ");
               int programmeChoice = scanner.nextInt();
              
               displayCourseinProgramme(programmeChoice);
            }
            else if(choice==9){
               reportChoose();
               System.out.println("Choose a number to view report: ");
               int reportChoice = scanner.nextInt();
               scanner.nextLine();
               report(reportChoice);
               
            }
            
        }while (choice !=0);
    }
    
    
    public void displayCourse(){
        int num=1;
        for(int i =0;i<course.getCourseList().size();i++){
            System.out.println(num+"  " + course.getCourseList().getEntry(i).toString());
            num++;
        }
        
    }
    
    public void displayCourseandSem(){
        int num=1;
        for(int i =0;i<course.getCourseList().size();i++){
            System.out.println(num+" "+ course.getCourseList().getEntry(i).toStringSem());
            num++;
        }
        
    }
  
    
    public void displayProgramme(){
        
        int num=1;
        for(int i =0;i<programme.getProgrammeList().size();i++){
            System.out.println(num+" " + programme.getProgrammeList().getEntry(i).toString());
            num++;
            
        }    
    }
    
    

    public void displayCourseinSem() {
        Scanner scanner = new Scanner(System.in);
        String[] uniqueSemesters = new String[course.getCourseList().size()]; // Array to store unique semesters
        int num = 1;
        int count = 0; // Counter to keep track of unique semesters
    
    // Iterate through the course list
        for (int i = 0; i < course.getCourseList().size(); i++) {
            String semester = course.getCourseList().getEntry(i).getSemester();
        
        // Check if the semester is unique
            boolean isUnique = true;
            for (int j = 0; j < count; j++) {
                if (uniqueSemesters[j].equals(semester)) {
                    isUnique = false;
                    break;
                }
            }
        
            if (isUnique) {
                uniqueSemesters[count] = semester; // Add the semester to the array
                System.out.println(num + " " + semester);
                num++;
                count++;
            }
        }
    
        System.out.print("\nEnter choice: ");
        int semChoice = scanner.nextInt();
        scanner.nextLine();
    
    
        String selectedSemester = uniqueSemesters[semChoice - 1];
    
    // Display courses that match the selected semester
        System.out.println("Courses available in " + selectedSemester + ":");
        num = 1;
        for (int i = 0; i < course.getCourseList().size(); i++) {
            Course c = course.getCourseList().getEntry(i);
            if (c.getSemester().equals(selectedSemester)) {
                System.out.println(num + ". " + c.toStringSem());
                num++;
            }
        }
    }

        
    public void displayProgrammeinCourse(int courseChoice){

        ListInterface<CourseProgramme> courseProgrammeList= new CircularArrayList<>();
        courseProgrammeList = courseprogramme.getCourseProgrammeList();
        Course C =course.getCourseList().getEntry(courseChoice-1);
        System.out.println("List of programme in "+ C.getCourseName());
        int num=1;
        for (int i = 0; i < courseProgrammeList.size(); i++) {
            if(courseProgrammeList.getEntry(i).getCourse().equals(C)){
               System.out.println(num+ " " +courseProgrammeList.getEntry(i).getProgramme()); 
                num++;
            }
            
        }
    }
    
    public CourseProgramme removeProginCourse(int courseChoice){
        Scanner scanner = new Scanner(System.in);
        ListInterface<CourseProgramme> courseProgrammeList= new CircularArrayList<>();
        courseProgrammeList = courseprogramme.getCourseProgrammeList();
        Course C =course.getCourseList().getEntry(courseChoice-1);
        System.out.println("List of programme in "+ C.getCourseName());
        for (int i = 0; i < courseProgrammeList.size(); i++) {
            if(courseProgrammeList.getEntry(i).getCourse().equals(C)){
               System.out.println(courseProgrammeList.getEntry(i).getProgramme()); 
            }
        }
        System.out.print("\nEnter choice: ");
        int programmeChoice = scanner.nextInt();
        scanner.nextLine();
        int num=1;
        CourseProgramme cp = new CourseProgramme();
        for (int i = 0; i < courseProgrammeList.size(); i++) {
            if(courseProgrammeList.getEntry(i).getCourse().equals(C)){
               if(programmeChoice == num){
                   cp = courseProgrammeList.getEntry(i);
                   break;
               }
               else{
                   num++;
               }
            }
        }
        return cp;
        
    }
    
    public void addProgrammetoCourse(int courseChoice,int programmeChoice){
        CourseProgramme cp1 = new CourseProgramme( course.getCourseList().getEntry(courseChoice-1), programme.getProgrammeList().getEntry(programmeChoice-1));
        courseprogramme.addCourseProgrammeList(cp1);
    }
    

   
    public void addNewCoursetoProgramme(int programmeChoice) {
        Scanner scanner = new Scanner(System.in);
    
        // Prompt user for course details
        System.out.println("Enter the details of the new course:");
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        System.out.print("Enter course ID: ");
        String courseID = scanner.nextLine();
        System.out.print("Enter course details: ");
        String courseDetails = scanner.nextLine();
        System.out.print("Enter course semester: ");
        String semester = scanner.nextLine();
        System.out.print("Enter course type(Main/Elective): ");
        String courseType = scanner.nextLine();
    
        // Create a new Course object
        Course newCourse = new Course(courseName, courseID, courseDetails,semester);
        course.setCourseList(newCourse);
    
        // Add the new course to the selected program
        Programme selectedProgram = programme.getProgrammeList().getEntry(programmeChoice - 1);
        CourseProgramme courseProgramme = new CourseProgramme(newCourse, selectedProgram);
        CourseProgramme.addCourseProgrammeList(courseProgramme);
    
        System.out.println("New course added to the selected program.");
    }
    
    public void displayCourseinProgramme(int programmeChoice){

        ListInterface<CourseProgramme> courseProgrammeList= new CircularArrayList<>();
        courseProgrammeList = courseprogramme.getCourseProgrammeList();
        Programme P =programme.getProgrammeList().getEntry(programmeChoice-1);
        System.out.println("List of course in "+ P.getName());
        int num=1;
        for (int i = 0; i < courseProgrammeList.size(); i++) {
            if(courseProgrammeList.getEntry(i).getProgramme().equals(P)){
               System.out.println(num+ " " +courseProgrammeList.getEntry(i).getCourse()); 
               num++;
            }
        }
    }
    
    

     public CourseProgramme removeCourseinProgramme(int programmeChoice){
        Scanner scanner = new Scanner(System.in);
        ListInterface<CourseProgramme> courseProgrammeList= new CircularArrayList<>();
        courseProgrammeList = courseprogramme.getCourseProgrammeList();
        Programme P =programme.getProgrammeList().getEntry(programmeChoice-1);
        System.out.println("List of course in "+ P.getName());
        int courseNum=1;
        for (int i = 0; i < courseProgrammeList.size(); i++) {
            if(courseProgrammeList.getEntry(i).getProgramme().equals(P)){
               System.out.println(courseNum+" "+courseProgrammeList.getEntry(i).getCourse()); 
               courseNum++;
            }
        }
        System.out.print("\nEnter choice: ");
        int courseChoice = scanner.nextInt();
        scanner.nextLine();
        int num=1;
        CourseProgramme cp = new CourseProgramme();
        for (int i = 0; i < courseProgrammeList.size(); i++) {
            if(courseProgrammeList.getEntry(i).getProgramme().equals(P)){
               if(courseChoice == num){
                   cp = courseProgrammeList.getEntry(i);
                   break;
               }
               else{
                   num++;
               }
            }
        }
        return cp;
        
    }
    
       


    public void displayCoursesByFaculty() {
        Scanner scanner = new Scanner(System.in);
        ListInterface<CourseProgramme> courseProgrammeList= new CircularArrayList<>();
        courseProgrammeList = courseprogramme.getCourseProgrammeList();
        String[] uniqueFaculty = new String[CourseProgramme.getCourseProgrammeList().size()]; // Array to store unique semesters
        
        for (int i = 0; i < courseProgrammeList.size(); i++) {
            String faculties = CourseProgramme.getCourseProgrammeList().getEntry(i).getProgramme().getFaculty();
        }
        
  
        int num = 0;

    // Iterate through the courseProgramme list
        for (int i = 0; i < courseProgrammeList.size(); i++) {
            String faculty = courseProgrammeList.getEntry(i).getProgramme().getFaculty();
            
            

        // Check if the faculty is already in the array
            boolean alreadyExists = false;
            for (int j = 0; j < num; j++) {
                if (uniqueFaculty[j].equals(faculty)) {
                    
                    alreadyExists = true;
                    break;
                }
            }

        // If not, add it to the array
            if (!alreadyExists) {
                uniqueFaculty[num] = faculty;
                num++;
            }
        }

    // Display unique faculties
        for (int i = 0; i < num; i++) {
            System.out.println((i + 1) + " " + uniqueFaculty[i]);
        }

        System.out.print("\nEnter choice: ");
        int facultyChoice = scanner.nextInt();
        scanner.nextLine();

        String selectedFaculty = uniqueFaculty[facultyChoice - 1];

    
    // Display courses taken by the selected faculty
        System.out.println("\nCourses taken by faculty " + selectedFaculty + ":");
        num = 1;
        for (int i = 0; i < courseProgrammeList.size(); i++) {
            CourseProgramme cp = courseProgrammeList.getEntry(i);
            if (cp.getProgramme().getFaculty().equals(selectedFaculty)) {
                System.out.println(num + ". " + cp.getCourse().toString());
                num++;
            }
        }
    }

    public void editCourseDetails() {
        Scanner scanner = new Scanner(System.in);
        ListInterface<CourseProgramme> courseProgrammeList= new CircularArrayList<>();
        courseProgrammeList = courseprogramme.getCourseProgrammeList();
        System.out.print("Enter programme choice: ");
        int programmeChoice = scanner.nextInt();
        scanner.nextLine();
    
        Programme selectedProgramme = programme.getProgrammeList().getEntry(programmeChoice - 1);

    // Display the courses available in the selected programme
        System.out.println("Courses in " + selectedProgramme.getName() + ":");
        ListInterface<Course> courses = new CircularArrayList<>();
        for (int i = 0; i < courseProgrammeList.size(); i++) {
            CourseProgramme cp = courseProgrammeList.getEntry(i);
            if (cp.getProgramme().equals(selectedProgramme)) {
                courses.add(cp.getCourse());
            }
        }

        int courseNum = 1;
        for (int i = 0; i < courses.size(); i++) {
            System.out.println(courseNum + ". " + courses.getEntry(i).toString());
            courseNum++;
        }

        // Ask the user to choose a course
        System.out.print("Enter course choice: ");
        int courseChoice = scanner.nextInt();
        scanner.nextLine();

        Course selectedCourse = courses.getEntry(courseChoice - 1);

        // Ask the user to enter new course details
        

        System.out.print("Enter new course details: ");
        String newCourseDetails = scanner.nextLine();

        // Update the course details
        selectedCourse.setCourseDetails(newCourseDetails);
        
        }

       public void report1(){
           System.out.println("***********************************************************************************************************\n");
           System.out.println("\t\t\t\tCourse Management Summary Report\t\t\t\t");
           System.out.println("\t\t\t\t\t#PROGRAMME REPORT#\t\t\t\t\t\n");
           System.out.println("***********************************************************************************************************\n");
           System.out.println("Programme Details:");
           System.out.println("------------------\n");
           System.out.println("|No|\t      Programme Name     \t\t|\tFaculty\t|\tNumber of courses handeled\t\t|");
           
           
            Scanner scanner = new Scanner(System.in);
            ListInterface<CourseProgramme> courseProgrammeList= new CircularArrayList<>();
            courseProgrammeList = courseprogramme.getCourseProgrammeList();
            int num=1;
            int totalCourse=0;
            for(int i =0;i<programme.getProgrammeList().size();i++){
                
                System.out.println(" "+num+"\t" +programme.getProgrammeList().getEntry(i).getName()+"\t\t\t"+programme.getProgrammeList().getEntry(i).getFaculty()
                +"\t\t"+totalCourse);
                num++;
            }    
       }
       
       public void report2(){
           System.out.println("diam");
       }
       
       public void reportChoose(){
        System.out.println("-----------------------------------------------------------------------------------------------------");           
        System.out.println("Choose to generate any report");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("1. Programme summary report ");
        System.out.println("2. Course summary report");
     
    } 
       
    public void report(int reportChoice){
        if (reportChoice == 1){
            report1();
        }else if(reportChoice ==2){
            report2();
        }
    }
    
    
    
        public static void main(String[] args) {
        CourseManagement courseManagement = new CourseManagement();
        courseManagement.CourseManagement();
    }
    
    
    
    
}
