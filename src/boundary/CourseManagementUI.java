
package boundary;
import java.util.Scanner;
/**
 *
 * @author limws
 */
public class CourseManagementUI {
    Scanner scanner = new Scanner(System.in);

    public int getMenuChoice() {
        clearScreen();
        System.out.println("\n---------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\tUniversity Course Management System\t\t\t\t");
        System.out.println("\n---------------------------------------------------------------------------------------");
        System.out.println("1. Add programme to course");
        System.out.println("2. Remove programme from course");
        System.out.println("3. Add new course to programme");
        System.out.println("4. Remove course from programme");
        System.out.println("5. Search courses offered in a sem"); 
        System.out.println("6. Edit course details for a programme");
        System.out.println("7. View courses taken by different faculty");
        System.out.println("8. View all courses of a programme");
        System.out.println("9. Generate summary report");
        System.out.println("0. Quit");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return choice;
        
    }
    
    public static void clearScreen() {
        
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }  
    }
    
    
}
