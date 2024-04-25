package control;

import DAO.CourseInitializer;
import DAO.CourseTutorCombineInitializer;
import DAO.TutorInitializer;
import DAO.TutorialGroupInitializer;
import adt.SortedLinkedList;
import adt.SortedLinkedListInterface;
import boundary.TeachingAssignmentUI;
import static boundary.TeachingAssignmentUI.clrscreen;
import static boundary.TeachingAssignmentUI.pressToContinue;
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

    public static SortedLinkedListInterface<Tutor> tutorList = new SortedLinkedList<>();
    public static SortedLinkedListInterface<Course> courseList = new SortedLinkedList<>();
    public static SortedLinkedListInterface<TutorialGroup> tutorGrpList = new SortedLinkedList<>();
    public static SortedLinkedListInterface<CourseTutorCombine> courseTutorCombineList = new SortedLinkedList<>();

    private Tutor tutor = new Tutor();
    private TutorialGroup tg = new TutorialGroup();
    private TeachingAssignmentUI teachingUI = new TeachingAssignmentUI();
    private Course course = new Course();

    private TutorInitializer tutorinitial = new TutorInitializer();
    private CourseInitializer courseinitial = new CourseInitializer();
    private TutorialGroupInitializer tutorgrpinitial = new TutorialGroupInitializer();
    private CourseTutorCombineInitializer ctcinitial = new CourseTutorCombineInitializer();

    Programme p1 = new Programme("", "");

    public void TeachingAssignment() {

        tutorList = tutorinitial.initializeTutor();
        courseList = courseinitial.initializeCourse();
        tutorGrpList = tutorgrpinitial.initializeTutorialGroup();
        courseTutorCombineList = ctcinitial.initializeCourseTutorCombine();

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
                    task3();
                    break;
                case 4:
                    task4();
                    break;
                case 5:
                    task5();
                    break;
                case 6:
                    task6();
                    break;
                case 7:
                    task7();
                    break;
                case 8:
                    task8();
                    break;
                case 9:
                    task9();
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
        main.TeachingAssignment();

    }

    public void test() {
        for (int i = 1; i <= courseTutorCombineList.getNumberOfEntries(); i++) {
            CourseTutorCombine current = courseTutorCombineList.getEntry(i);
            System.out.print(current.getTutor().getTutorName());
            System.out.print("  ");
            if (current.getCourse() != null) {
                System.out.print(current.getCourse().getCourseName());
            } else {
                System.out.print("nullCourse");
            }

            System.out.print("  ");
            if (current.getTutorialgroup() != null) {
                System.out.println(current.getTutorialgroup().getGroup());
            } else {
                System.out.println("nullGroup");
            }
        }

        if (courseTutorCombineList.getEntry(11) != null) {
            CourseTutorCombine current = courseTutorCombineList.getEntry(11);
            System.out.println(current.getTutor().getTutorName());
            System.out.println(current.getCourse().getCourseName());
            for (int i = 1; i <= current.getCourseTutorCombineList().getNumberOfEntries(); i++) {
                System.out.println(current.getCourseTutorCombineList().getEntry(i).getTutorialgroup().getGroup());
            }
        } else {
            System.out.println("not yet");
        }
    }

    public void displayAllTutor(){
        for (int i = 1; i <= tutorList.getNumberOfEntries(); i++) {
               System.out.printf("%3d %-15s %-40s %-5s %5d\n", i, tutorList.getEntry(i).getTutorId(),
                    tutorList.getEntry(i).getTutorName(), tutorList.getEntry(i).getGender(), 
                    tutorList.getEntry(i).getAge());
        }
    }
    
    public void displayAllCourse() {
        for (int i = 1; i <= courseList.getNumberOfEntries(); i++) {
               System.out.printf("%3d %-15s %-40s \n", i, courseList.getEntry(i).getCourseID(),
                    courseList.getEntry(i).getCourseName());
        }
//        System.out.println("---------------------------------------------------------------------------------");
//        System.out.print("Enter Your Number Selection:");
//        int select = scanner.nextInt();
//        Course courseresult = courseList.getEntry(select);
//        return courseresult;
    }

    public CourseTutorCombine getTutorCourse(){
        //section1 : select course
        SortedLinkedListInterface<CourseTutorCombine> tutorCourse = new SortedLinkedList<>();
        
        
        //show tutor details and select tutor
        displayAllTutor();
        int resulttutor = teachingUI.inputCourse();
        Tutor selectedTutor = tutorList.getEntry(resulttutor);
        System.out.println(selectedTutor.getTutorName() + " and the course");

        //filter to add into tutorCourse
        for (int i = 1; i <= TeachingAssignment.courseTutorCombineList.getNumberOfEntries(); i++) {

            //check isNull
            if (TeachingAssignment.courseTutorCombineList.getEntry(i) != null) {
                //check selectedtutor
                if (TeachingAssignment.courseTutorCombineList.getEntry(i).getTutor().equals(selectedTutor)) {
                    //filter to get tutor x course
                    if (TeachingAssignment.courseTutorCombineList.getEntry(i).getCourse() != null
                            && !"".equals(TeachingAssignment.courseTutorCombineList.getEntry(i).getCourse().getCourseName())) {
                        tutorCourse.add(TeachingAssignment.courseTutorCombineList.getEntry(i));

                    }

                }

            }
        }

        //display filtered result
        for (int i = 1; i <= tutorCourse.getNumberOfEntries(); i++) {

            System.out.print(i + ")");
            System.out.print(TeachingAssignment.courseTutorCombineList.getEntry(i).getTutor().getTutorId() + "  ");
            System.out.print(TeachingAssignment.courseTutorCombineList.getEntry(i).getTutor().getTutorName() + " ");
            System.out.println(TeachingAssignment.courseTutorCombineList.getEntry(i).getCourse().getCourseName());
        }

        System.out.println("---------------------------------------------------------------------------------");
        System.out.print("Enter a course:");
        int result = scanner.nextInt();
        System.out.println();
        // target selected ctb in ctbList
        CourseTutorCombine selectedTutorCourse = tutorCourse.getEntry(result);

        return selectedTutorCourse;
    }
    
    public CourseTutorCombine getTutorGroup(CourseTutorCombine selectedTutorCourse) {
        Tutor selectedTutor = selectedTutorCourse.getTutor();
        //section2 : select group
        SortedLinkedListInterface<CourseTutorCombine> tutorGroup = new SortedLinkedList<>();
        //filter out ctbList to get tutor x group
        for (int i = 1; i <= TeachingAssignment.courseTutorCombineList.getNumberOfEntries(); i++) {
            //check isNull
            if (TeachingAssignment.courseTutorCombineList.getEntry(i) != null) {
                //check tutor
                if (TeachingAssignment.courseTutorCombineList.getEntry(i).getTutor().equals(selectedTutor)) {
                    //check has group
                    if (TeachingAssignment.courseTutorCombineList.getEntry(i).getTutorialgroup() != null) {
                        tutorGroup.add(TeachingAssignment.courseTutorCombineList.getEntry(i));
                    }
                }
            }
        }

        //display filtered result
        for (int i = 1; i <= tutorGroup.getNumberOfEntries(); i++) {
            System.out.print((i) + ")");
            System.out.print(tutorGroup.getEntry(i).getTutorialgroup().getGroup() + " ");
            System.out.println(tutorGroup.getEntry(i).getTutorialgroup().getQty());
        }
        
        System.out.println("---------------------------------------------------------------------------------");
        System.out.print("Select Number Tutotrial Group Want to assign:");
        int tgresult = scanner.nextInt();
        System.out.println();

        CourseTutorCombine selectedGroup = tutorGroup.getEntry(tgresult);

        return selectedGroup;
        
        
        

    }
    
    public void functionReport1(){
        for(int i = 1; i <= TeachingAssignment.tutorList.getNumberOfEntries(); i++){
            Tutor currentTutor = TeachingAssignment.tutorList.getEntry(i);
             
            int count = 0;
            for (int j = 1; j <= TeachingAssignment.courseTutorCombineList.getNumberOfEntries(); j++) {
                if(TeachingAssignment.courseTutorCombineList.getEntry(j).getTutor() != null){
                    //check course 
                    if (TeachingAssignment.courseTutorCombineList.getEntry(j).getTutor().equals(currentTutor)) {
                        if (TeachingAssignment.courseTutorCombineList.getEntry(j).getCourse() != null) {
                            count++;
                        }
                    }
                }                
            }
            
            int count2 = 0;
            for (int k = 1; k <= TeachingAssignment.courseTutorCombineList.getNumberOfEntries(); k++) {
                if(TeachingAssignment.courseTutorCombineList.getEntry(k) != null){
                    //check course 
                    if (TeachingAssignment.courseTutorCombineList.getEntry(k).getTutor().equals(currentTutor)) {
                        if (TeachingAssignment.courseTutorCombineList.getEntry(k).getTutorialgroup() != null) {
                            count2++;
                        }
                    }
                }                
            }
            
            System.out.printf("%-2d.       %-25s%-31s%-25d%-4d\n",i,currentTutor.getTutorId(),currentTutor.getTutorName(),count, count2);
        }
    
        System.out.println();
        System.out.printf(" ".repeat(35) + "END OF THE SUMMARY REPORT");
        System.out.println();
        System.out.println("=".repeat(120));
        System.out.println("\n");
    }
    
    public void functionReport2(){
        for (int i = 1 ; i<= TeachingAssignment.courseList.getNumberOfEntries();i++){
            Course currentCourse = TeachingAssignment.courseList.getEntry(i);
            
            int count = 0;
            for (int j = 1; j <= TeachingAssignment.courseTutorCombineList.getNumberOfEntries(); j++) {
                if(TeachingAssignment.courseTutorCombineList.getEntry(j) != null){
                    //check 
                    if(TeachingAssignment.courseTutorCombineList.getEntry(j).getCourse() !=null){
                         if (TeachingAssignment.courseTutorCombineList.getEntry(j).getCourse().equals(currentCourse)) {
                            if (TeachingAssignment.courseTutorCombineList.getEntry(j).getTutor() != null) {
                                count++;
                            }
                        }
                    }
                       
                }
                
            }
            
            int count2 =0;
            for (int k = 1; k <= TeachingAssignment.courseTutorCombineList.getNumberOfEntries(); k++) {
                if(TeachingAssignment.courseTutorCombineList.getEntry(k) != null){
                    //check 
                    if(TeachingAssignment.courseTutorCombineList.getEntry(k).getCourse() !=null){
                         if (TeachingAssignment.courseTutorCombineList.getEntry(k).getCourse().equals(currentCourse)) {
                            if (TeachingAssignment.courseTutorCombineList.getEntry(k).getTutorialgroup()!= null) {
                                count++;
                            }
                        }
                    }
                }
                
            }
             System.out.printf("%-2d.       %-25s%-31s%-25d%-4d\n",i,currentCourse.getCourseID(),currentCourse.getCourseName(),count, count2);
        }
    }
    
    public void task1() {
        teachingUI.assignTutorToCourse();
        //show course and select course
        for (int i = 0; i < courseList.getNumberOfEntries(); i++) {
            System.out.print((i + 1) + ")");
            System.out.println(courseList.getEntry(i + 1));
        }
        System.out.println("---------------------------------------------------------------------------------");
        

        int courseResult = teachingUI.inputCourse();
        Course sCourse = courseList.getEntry(courseResult);
 
        
        //show tutor details and select tutor
        displayAllTutor();
        int selectedresult = teachingUI.inputCourse();
        Tutor tutorresult = tutorList.getEntry(selectedresult);

        
        //show type and assign tutor type
        int select3 = teachingUI.tutortype();
        char tutortype = 'L';
        switch (select3) {
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

        CourseTutorCombine ctc = new CourseTutorCombine(tutorresult, sCourse, tutortype);
        courseTutorCombineList.add(ctc);


        System.out.println("Add Successfull !!!\n");

    }

    public void task2() {
        
        //show tutor details and select tutor
        displayAllTutor();
        int selectedresult = teachingUI.inputCourse();
        Tutor tutorresult = tutorList.getEntry(selectedresult);


        //show grp and choose grp
        for (int i = 0; i < tutorGrpList.getNumberOfEntries(); i++) {
            System.out.print((i + 1) + ")");
            System.out.print(tutorGrpList.getEntry(i + 1).getGroup() + "     ");
            System.out.println("Qty:" + tutorGrpList.getEntry(i + 1).getQty());

        }
        int selectTutorialGroup = teachingUI.chooseTutorialGroup();
        TutorialGroup resultTutorialGroup= tutorGrpList.getEntry(selectTutorialGroup);

        // combine
        CourseTutorCombine ctc = new CourseTutorCombine(tutorresult, resultTutorialGroup);
        courseTutorCombineList.add(ctc);

        System.out.println("Add Successfull !!!\n");


    }
    
    public void task3() {
        teachingUI.getTutorCourse();
        
        CourseTutorCombine selectedTutorCourse = getTutorCourse();
        
        CourseTutorCombine selectedTutorGroup = getTutorGroup(selectedTutorCourse);

        selectedTutorCourse.addTutorCombine(selectedTutorGroup);

        System.out.println("Add Successfull !!!");
        System.out.println();
    }

    public void task4() {
        SortedLinkedList<CourseTutorCombine> tutorCourse = new SortedLinkedList<>();
        
        
        //show tutor details and select tutor
        displayAllTutor();
        int tutorresult = teachingUI.inputCourse();
        Tutor selectedTutor = tutorList.getEntry(tutorresult);


        for (int i = 1; i <= TeachingAssignment.courseTutorCombineList.getNumberOfEntries(); i++) {
            if (TeachingAssignment.courseTutorCombineList.getEntry(i) != null) {
                //check selectedtutor
                if (TeachingAssignment.courseTutorCombineList.getEntry(i).getTutor().equals(selectedTutor)) {
                    //filter to get tutor x course
                    if (TeachingAssignment.courseTutorCombineList.getEntry(i).getCourse() != null
                            && !"".equals(TeachingAssignment.courseTutorCombineList.getEntry(i).getCourse().getCourseName())) {
                        tutorCourse.add(TeachingAssignment.courseTutorCombineList.getEntry(i));

                    }

                }

            }

        }
        //display filtered result
        for (int i = 1; i <= tutorCourse.getNumberOfEntries(); i++) {

            System.out.print(i + ")");
            System.out.print(TeachingAssignment.courseTutorCombineList.getEntry(i).getCourse().getCourseID() + "  ");
            System.out.println(TeachingAssignment.courseTutorCombineList.getEntry(i).getCourse().getCourseName() + " ");
        }

    }

    public void task5() {
        teachingUI.searchTutorsForCourse();
        
        SortedLinkedList<CourseTutorCombine> tutorCourse = new SortedLinkedList<>();
        
        //show course details and select course
        displayAllCourse();
        int selectedresult = teachingUI.inputCourse();
        Course selectedCourse = courseList.getEntry(selectedresult);

        for (int i = 1; i <= TeachingAssignment.courseTutorCombineList.getNumberOfEntries(); i++) {
            if (TeachingAssignment.courseTutorCombineList.getEntry(i) != null) {

                //filter to get course x tutor
                if (TeachingAssignment.courseTutorCombineList.getEntry(i).getCourse() != null
                        && !"".equals(TeachingAssignment.courseTutorCombineList.getEntry(i).getCourse().getCourseName())) {
                    //check selectedcourse
                    if (TeachingAssignment.courseTutorCombineList.getEntry(i).getCourse().equals(selectedCourse)) {
                        tutorCourse.add(TeachingAssignment.courseTutorCombineList.getEntry(i));

                    }

                }
            }

        }
        //display filtered result
        for (int i = 1; i <= tutorCourse.getNumberOfEntries(); i++) {

            System.out.print(i + ")");
            System.out.print(TeachingAssignment.courseTutorCombineList.getEntry(i).getTutor().getTutorId() + "  ");
            System.out.println(TeachingAssignment.courseTutorCombineList.getEntry(i).getTutor().getTutorName() + " ");
        }

    }

    public void task6() {
        teachingUI.listTutorsAndTutorialGroupsForCourse();
        
        //show course details and select course
        displayAllCourse();
        int selectedresult = teachingUI.inputCourse();
        Course courseResult = courseList.getEntry(selectedresult);
        
        
        SortedLinkedListInterface<CourseTutorCombine> tutorCourse = new SortedLinkedList<>();

        for (int i = 1; i <= TeachingAssignment.courseTutorCombineList.getNumberOfEntries(); i++) {
            //check course
            if (TeachingAssignment.courseTutorCombineList.getEntry(i).getCourse() != null
                    && !"".equals(TeachingAssignment.courseTutorCombineList.getEntry(i).getCourse().getCourseName())) {

                if (TeachingAssignment.courseTutorCombineList.getEntry(i).getCourse().equals(courseResult)) {
                    tutorCourse.add(TeachingAssignment.courseTutorCombineList.getEntry(i));

                }

            }
        }

        for (int i = 1; i <= tutorCourse.getNumberOfEntries(); i++) {
            System.out.print(i + ")");
            System.out.print(TeachingAssignment.courseTutorCombineList.getEntry(i).getTutor().getTutorId() + "  ");
            System.out.print(TeachingAssignment.courseTutorCombineList.getEntry(i).getTutor().getTutorName() + " ");
            System.out.println(TeachingAssignment.courseTutorCombineList.getEntry(i).getTutorialgroup().getGroup());
        }


    }

    public void task7() {
        teachingUI.listCoursesForTutors();
        
        SortedLinkedList<CourseTutorCombine> tutorCourse = new SortedLinkedList<>();
        
         //show tutor details and select tutor
        displayAllTutor();
        int tutorresult = teachingUI.inputCourse();
        Tutor selectedTutor = tutorList.getEntry(tutorresult);
       

        for (int i = 1; i <= TeachingAssignment.courseTutorCombineList.getNumberOfEntries(); i++) {
            if (TeachingAssignment.courseTutorCombineList.getEntry(i) != null) {
                //check selectedtutor
                if (TeachingAssignment.courseTutorCombineList.getEntry(i).getTutor().equals(selectedTutor)) {
                    //filter to get tutor x course
                    if (TeachingAssignment.courseTutorCombineList.getEntry(i).getCourse() != null
                            && !"".equals(TeachingAssignment.courseTutorCombineList.getEntry(i).getCourse().getCourseName())) {
                        tutorCourse.add(TeachingAssignment.courseTutorCombineList.getEntry(i));

                    }

                }

            }

        }
        //display filtered result
        for (int i = 1; i <= tutorCourse.getNumberOfEntries(); i++) {

            System.out.print(i + ")");
            System.out.print(TeachingAssignment.courseTutorCombineList.getEntry(i).getCourse().getCourseID() + "  ");
            System.out.println(TeachingAssignment.courseTutorCombineList.getEntry(i).getCourse().getCourseName() + " ");
        }

    }

    public void task8() {
        
        int result = teachingUI.filterTutorsBasedOnType();
        char tutortype = 'T';
        int num = 0;
        switch (result) {
            case 1:
                tutortype = 'T';
                for (int i = 1; i <= TeachingAssignment.courseTutorCombineList.getNumberOfEntries(); i++) {
                    if (TeachingAssignment.courseTutorCombineList.getEntry(i).getTutor() != null) {
                        if (tutortype == TeachingAssignment.courseTutorCombineList.getEntry(i).getType()) {
                            System.out.print((num + 1) + ". " + TeachingAssignment.courseTutorCombineList.getEntry(i).getTutor().getTutorId() + " ");
                            System.out.print(TeachingAssignment.courseTutorCombineList.getEntry(i).getTutor().getTutorName() + " ");
                            System.out.println(TeachingAssignment.courseTutorCombineList.getEntry(i).getType());
                            num++;
                        }

                    }

                }

                break;
            case 2:
                tutortype = 'P';
                for (int i = 1; i <= TeachingAssignment.courseTutorCombineList.getNumberOfEntries(); i++) {
                    if (TeachingAssignment.courseTutorCombineList.getEntry(i).getTutor() != null) {
                        if (tutortype == TeachingAssignment.courseTutorCombineList.getEntry(i).getType()) {
                            System.out.print((num + 1) + ". " + TeachingAssignment.courseTutorCombineList.getEntry(i).getTutor().getTutorId() + " ");
                            System.out.print(TeachingAssignment.courseTutorCombineList.getEntry(i).getTutor().getTutorName() + " ");
                            System.out.println(TeachingAssignment.courseTutorCombineList.getEntry(i).getType());
                            num++;
                        }

                    }

                }
                break;
            case 3:
                tutortype = 'L';
                for (int i = 1; i <= TeachingAssignment.courseTutorCombineList.getNumberOfEntries(); i++) {
                    if (TeachingAssignment.courseTutorCombineList.getEntry(i).getTutor() != null) {
                        if (tutortype == TeachingAssignment.courseTutorCombineList.getEntry(i).getType()) {
                            System.out.print((num + 1) + ". " + TeachingAssignment.courseTutorCombineList.getEntry(i).getTutor().getTutorId() + " ");
                            System.out.print(TeachingAssignment.courseTutorCombineList.getEntry(i).getTutor().getTutorName() + " ");
                            System.out.println(TeachingAssignment.courseTutorCombineList.getEntry(i).getType());
                            num++;
                        }

                    }

                }
                break;
        }
        
    }

    public void task9() {
        int select = teachingUI.generateSummaryReports();
        if (select == 1) {
            teachingUI.report1();
            functionReport1();
            teachingUI.pressToContinue();
            teachingUI.clrscreen();
            
        } else if (select == 2) {
            teachingUI.report2();
            functionReport2();
            teachingUI.pressToContinue();
            teachingUI.clrscreen();
        }


        
        
    }

}
