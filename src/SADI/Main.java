/*
 * Author: Nguyen Le Bao Anh
 * Created on: 27/02/2019
 * Last updated on: 27/02/2019
 * This is the submission file for assignment I of COSC2440- SADI.
 * This is a console application written in Java 11. This application will allow staffs to enroll students in courses
 * available in the corresponding semesters. It also allows staffs to update, delete, and show enrollments of all
 * students. Additionally, 11 Java design patterns were used. For more details, please refer to the README.md file. */

package SADI;

import SADI.Builder.CourseBuilder;
import SADI.Courses.*;
import SADI.Enrollment.StudentEnrolment;
import SADI.ErrorHandling.InvalidIDException;
import SADI.Person.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /* Building courses */
        Course webProgramming = new CourseBuilder("COSC2430","Web Programming",12).build();
        webProgramming.setAvailability("AC");
        Course softwareArchitecture = new CourseBuilder("COSC2440","Software Architecture: Design &" +
                " Implementation",12).build();
        softwareArchitecture.setAvailability("A");
        Course cppProgramming = new CourseBuilder("COSC2131","Programming Using C++",12).build();
        cppProgramming.setAvailability("A");
        Course database = new CourseBuilder("ISYS2077","Database Concepts",12).build();
        database.setAvailability("A");
        Course softEnProcess = new CourseBuilder("COSC2101","Software Engineering: Process &" +
                " Tools",12).build();
        softEnProcess.setAvailability("B");
        Course buildingITSys = new CourseBuilder("COSC2634","Building IT Systems", 12).build();
        buildingITSys.setAvailability("C");
        Course security = new CourseBuilder("COSC2539","Security in Computing and Information Technology",
                12).build();
        security.setAvailability("C");
        Course softENFundamental = new CourseBuilder("ISYS2089","Software Engineering Fundamentals",
                12).build();
        softENFundamental.setAvailability("C");
        Course professionalComp = new CourseBuilder("COSC2130","Professional Computing Practice",
                12).build();
        professionalComp.setAvailability("C");

        /* Assigning courses to semesters */
        CourseList courseListA = CourseListA.getINSTANCE();
        CourseList courseListB = CourseListB.getINSTANCE();
        CourseList courseListC = CourseListC.getINSTANCE();
        courseListA.addCourse(Course.getCourseList());
        courseListB.addCourse(Course.getCourseList());
        courseListC.addCourse(Course.getCourseList());

        /* Creating students */
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

        viewMainMenu();


    }
    public static void viewMainMenu(){
        while(true)
        {
            System.out.print("**************************************\n"
                    + "RMIT University Student Management System\n" +
                    "1. Add/Update/Delete Student Enrolment\n" +
                    "2. View all students' enrolment in one semester\n" +
                    "3. Quit\n"
                    + "Your choice: ");
            Scanner scanner = new Scanner(System.in);
            int menuChoice = scanner.nextInt();
            switch (menuChoice){
                case 1:
                    studentEnrolmentMenu();
                    break;
                case 2:
                    System.out.println("Choose a semester ");
                    System.out.print("1. A\n" + "2. B\n" + "3. C\n" + "4. Return\n" + "5. Quit program\n" + "Your choice: ");
                    Scanner scanner1 = new Scanner(System.in);
                    int subMenuChoice = scanner1.nextInt();
                    switch (subMenuChoice)
                    {
                        case 1: break;
                    }
                    break;
                case 3:
                    System.out.println("Program exits. Have a good day!");
                    System.exit(0);
                default:
                    System.out.println("No such choice available. Please try again!");
            }
        }
    }

    public static void studentEnrolmentMenu()
    {
        boolean endLoop = false;
        while(!endLoop)
        {
        try {
            Student.printStudentInfo();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter student ID: ");
            String studentID = scanner.nextLine();
            Student student = Student.searchStudent(studentID);
            if (student != null)
            {
            System.out.print("**************************************\n"
                     +
                    "1. Enrol in a course\n" +
                    "2. Drop a course\n" +
                    "3. Update enrolments\n" +
                    "4. View current enrolments\n" +
                    "5. Return to main menu\n"
                    + "6. Quit\n"
                    + "Your choice: ");
            Scanner scanner1 = new Scanner(System.in);
            int choice = scanner1.nextInt();
            switch (choice) {
                case 1:
                    boolean endLoop1 = false;
                    while(!endLoop1)
                    {
                        System.out.println("Please choose a semester");
                        System.out.print("1. A\n" + "2. B\n" + "3. C\n" + "4. Return\n" + "5. Quit program\n" + "Your choice: ");
                        Scanner scanner2 = new Scanner(System.in);
                        int choiceEnrol = scanner2.nextInt();
                        switch (choiceEnrol)
                        {
                            case 1:
                                CourseListA.printCourseList();
                                System.out.print("Enter course ID: ");
                                Scanner scanner3 = new Scanner(System.in);
                                String courseID = scanner3.nextLine();
                                Course course = CourseListA.courseSearch(courseID);
                                if(course !=null)
                                {
                                    StudentEnrolment studentEnrolment = new StudentEnrolment(student);
                                    studentEnrolment.enrol(course,"A");
                                }
                                else
                                    {
                                        System.out.println("Wrong Course ID.");
                                    }

                                break;
                            case 2:
                                CourseListB.printCourseList();
                                break;
                            case 3:
                                CourseListC.printCourseList();
                                break;
                            case 4:
                                endLoop1 = true;
                                break;
                            case 5:
                                System.out.println("Program exits. Have a good day!");
                                System.exit(0);
                                break;
                            default:
                                System.out.println("No such choice available. Please try again!");
                        }
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    endLoop = true;
                    break;
                case 6:
                    System.out.println("Program exits. Have a good day!");
                    System.exit(0);
                default:
                    System.out.println("No such choice available. Please try again");
                }
            }
            else{
                System.out.println("Invalid student ID. Please try again!");
            }
        }
            catch (Exception e)
            {}
        }
    }

    public static void courseEnrolmentMenu()
    {

    }
}
