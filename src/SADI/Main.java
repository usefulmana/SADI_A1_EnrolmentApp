/*
 * Author: Nguyen Le Bao Anh
 * Created on: 27/02/2019
 * Last updated on: 27/02/2019
 * This is the submission file for assignment I of COSC2440- SADI.
 * This is a console application written in Java 11. This application will allow staffs to enroll students in courses
 * available in the corresponding semesters. It also allows staffs to update, delete, and show enrollments of all
 * students. Additionally, 11 Java design patterns were used. For more details, please refer to the README.md file. */

package SADI;

import SADI.Builder.CoursesBuilder;
import SADI.Courses.Course;
import SADI.Person.Student;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*Building courses*/
        Course webProgramming = new CoursesBuilder("COSC2430","Web Programming",12).build();
        Course softwareArchitecture = new CoursesBuilder("COSC2440","Software Architecture: Design &" +
                "Implementation",12).build();
        Course cppProgramming = new CoursesBuilder("COSC2131","Programming Using C++",12).build();
        Course database = new CoursesBuilder("ISYS2077","Database Concepts",12).build();
        Course softEnProcess = new CoursesBuilder("COSC2101","Software Engineering: Process &" +
                " Tools",12).build();
        Course buildingITSys = new CoursesBuilder("COSC2634","Building IT Systems", 12).build();
        Course security = new CoursesBuilder("COSC2539","Security in Computing and Information Technology",
                12).build();
        Course softENFundamental = new CoursesBuilder("ISYS2089","Software Engineering Fundamentals",
                12).build();
        Course professionalComp = new CoursesBuilder("COSC2130","Professional Computing Practice",
                12).build();

        /*Creating students*/
        Student student1 = new Student("s1234567","Emily Nguyen");
        student1.setBirthday("18-04-1999");
        Student student2 = new Student("s6549871", "Bob Le");
        student2.setBirthday("23-11-2000");
        Student student3 = new Student("s9876541", "Hannah Tran");
        student3.setBirthday("11-07-1996");
        Student student4 = new Student("s9845673","Vincent Tran");
        student4.setBirthday("07-12-1999");
        Student student5 = new Student("s6784563","Alexandra Smith");
        student5.setBirthday("12-12-1997");

        System.out.println(webProgramming.toString());
        System.out.println(student1);

        /* Menu */
        student1.printStudentList();
    }
    public static void viewMainMenu(){
        while(true)
        {
            System.out.print("**************************************\n"
                    + "RMIT University Student Management System\n" +
                    "1. Add/Update/Delete Student Enrolment\n" +
                    "2. View Current Student List\n" +
                    "3. View Students' Current Enrolment\n" +
                    "4. View course list\n" +
                    "5. Quit\n"
                    + "Your choice: ");
            Scanner scanner = new Scanner(System.in);
            int menuChoice = scanner.nextInt();
            switch (menuChoice){
                case 1:
                    studentEnrolmentMenu();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Program exits. Have a good day!");
                    System.exit(0);
                default:
                    System.out.println("No such choice available. Please try again!");
            }
        }
    }

    public static void studentEnrolmentMenu()
    {
        System.out.println("Students List");
        Scanner scanner = new Scanner(System.in);

        System.out.print("**************************************\n"
                + "Student Enrollment\n" +
                "1. Add/Update/Delete Student Enrolment\n" +
                "2. View Current Student List\n" +
                "3. View Students' Current Enrolment\n" +
                "4. View course list\n" +
                "5. Quit\n"
                + "Your choice: ");
    }
}
