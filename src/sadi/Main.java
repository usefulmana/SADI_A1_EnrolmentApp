/*
 * Author: Nguyen Le Bao Anh
 * Created on: 27/02/2019
 * Last updated on: 27/02/2019
 * This is the submission file for assignment I of COSC2440- sadi.
 * This is a console application written in Java 11. This application will allow staffs to enroll students in courses
 * available in the corresponding semesters. It also allows staffs to update, delete, and show enrollments of all
 * students. Additionally, 11 Java design patterns were used. For more details, please refer to the README.md file. */

package sadi;

import sadi.builder.CourseBuilder;
import sadi.command.Command;
import sadi.cor.Chain;
import sadi.course.*;
import sadi.enrollment.StudentEnrolment;
import sadi.person.Student;
import sadi.person.StudentList;
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
        Chain courseListA = CourseListA.getINSTANCE();
        Chain courseListB = CourseListB.getINSTANCE();
        Chain courseListC = CourseListC.getINSTANCE();
        courseListA.setNextChain(courseListB);
        courseListB.setNextChain(courseListC);
        courseListA.addCourse(Course.getCourseList());


        /* Creating students */
        Student student1 = new Student("s1234567","Emily Nguyen");
        student1.setBirthday("18-04-1999");
        student1.subscribe();
        Student student2 = new Student("s6549871", "Bob Le");
        student2.setBirthday("23-11-2000");
        student2.subscribe();
        Student student3 = new Student("s9876541", "Hannah Tran");
        student3.setBirthday("11-07-1996");
        student3.subscribe();
        Student student4 = new Student("s9845673","Vincent Tran");
        student4.setBirthday("07-12-1999");
        student4.subscribe();
        Student student5 = new Student("s6784563","Alexandra Smith");
        student5.setBirthday("12-12-1997");
        student5.subscribe();

        /* Creating student enrolment objects*/
       viewMainMenu();
    }
    public static void viewMainMenu() {
        try {

            /* Creating StudentEnrolment objects for every students*/
            List<Command> studentEnrolmentList = new ArrayList<>();
            StudentList studentList = StudentList.getINSTANCE();
            /* Iterating through the StudentList object*/
            while (studentList.hasNext())
            {
                studentEnrolmentList.add(new StudentEnrolment(studentList.next()));
            }
            while (true) {
                StudentList.printStudentInfo();
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter student ID: ");
                String studentID = scanner.nextLine();
                Student student = StudentList.searchStudent(studentID);

                if (student != null) {
                    StudentEnrolment studentEnrolment = StudentEnrolment.getStudentEnrolment(studentID);
                    System.out.print("**************************************\n"
                            +
                            "1. Enrol in a course\n" +
                            "2. Drop a course\n" +
                            "3. Update enrolments\n" +
                            "4. View all current enrolments of the current student\n" +
                            "5. View enrolments of all students in a particular semester\n" +
                            "6. Quit\n" +
                            "Your choice: ");
                    Scanner scanner1 = new Scanner(System.in);
                    int choice = scanner1.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("Please choose a semester");
                            System.out.print("1. A\n" + "2. B\n" + "3. C\n" + "4. Return\n" + "5. Quit program\n" + "Your choice: ");
                            Scanner scanner2 = new Scanner(System.in);
                            int choiceEnrolA = scanner2.nextInt();
                            switch (choiceEnrolA) {
                                case 1:
                                    while(true){
                                    CourseListA.printCourseList();
                                    System.out.print("Enter course ID: ");
                                    Scanner scanner3 = new Scanner(System.in);
                                    String courseID = scanner3.nextLine();
                                    Course course3 = CourseListA.courseSearch(courseID.toUpperCase());
                                    if (course3 != null) {
                                        studentEnrolment.executeEnrol(course3, "A");
                                        if(StudentEnrolment.continuePrompt("Undo previous action (Y/n)?: "))
                                        {
                                            studentEnrolment.undoEnrol(course3,"A");
                                        }
                                        if(!StudentEnrolment.continuePrompt("Enrolling in another course (Y/n)?: "))
                                        {
                                            break;
                                        }
                                    }
                                    else {
                                        System.out.println("Wrong Course ID.");
                                       }
                                    }
                                    break;
                                case 2:
                                    while(true)
                                    {
                                    CourseListB.printCourseList();
                                    System.out.print("Enter course ID: ");
                                    Scanner scanner4 = new Scanner(System.in);
                                    String courseID1 = scanner4.nextLine();
                                    Course course4 = CourseListB.courseSearch(courseID1.toUpperCase());
                                    if (course4 != null) {
                                        studentEnrolment.executeEnrol(course4, "B");
                                        if(StudentEnrolment.continuePrompt("Undo previous action (Y/n)?: "))
                                        {
                                            studentEnrolment.undoEnrol(course4,"B");
                                        }
                                        if(!StudentEnrolment.continuePrompt("Enrolling in another course (Y/n)?: "))
                                        {
                                            break;
                                        }
                                    } else {
                                        System.out.println("Wrong Course ID.");
                                    }

                                    }
                                    break;
                                case 3:
                                    while(true){
                                    CourseListC.printCourseList();
                                    System.out.print("Enter course ID: ");
                                    Scanner scanner5 = new Scanner(System.in);
                                    String courseID5 = scanner5.nextLine();
                                    Course course5 = CourseListC.courseSearch(courseID5.toUpperCase());
                                    if (course5 != null) {
                                        studentEnrolment.executeEnrol(course5, "C");

                                        if(StudentEnrolment.continuePrompt("Undo previous action (Y/n)?: "))
                                        {
                                            studentEnrolment.undoEnrol(course5,"C");
                                        }
                                        if(!StudentEnrolment.continuePrompt("Enrolling in another course (Y/n)?: "))
                                        {
                                            break;
                                        }
                                    } else {
                                        System.out.println("Wrong Course ID.");
                                    }
                                    }
                                    break;
                                case 4:
                                    break;
                                case 5:
                                    System.out.println("Program exits. Have a good day!");
                                    System.exit(0);
                                    break;
                                default:
                                    System.out.println("No such choice available. Please try again!");
                            }
                            break;
                        case 2:
                            System.out.println("Please choose a semester");
                            System.out.print("1. A\n" + "2. B\n" + "3. C\n" + "4. Return\n" + "5. Quit program\n" + "Your choice: ");
                            Scanner scanner6 = new Scanner(System.in);
                            int choiceDropA = scanner6.nextInt();
                            switch (choiceDropA) {
                                case 1:
                                    while(true){
                                        if(studentEnrolment.viewASemesterCourses("A"))
                                        {
                                        System.out.print("Enter course ID: ");
                                        Scanner scanner7 = new Scanner(System.in);
                                        String courseID = scanner7.nextLine();
                                        Course course7 = CourseListA.courseSearch(courseID.toUpperCase());
                                        if (course7 != null) {
                                            studentEnrolment.executeDrop(course7, "A");
                                            if(StudentEnrolment.continuePrompt("Undo previous action (Y/n)?: "))
                                            {
                                                studentEnrolment.undoDrop(course7,"A");
                                            }
                                            if(!StudentEnrolment.continuePrompt("Dropping another course (Y/n)?: "))
                                            {
                                                break;
                                            }
                                        } else {
                                            System.out.println("Wrong Course ID.");
                                        }

                                    }
                                        else
                                        {
                                            System.out.println("Student is not currently enroled in any course this semester");
                                            System.out.println("Returning to main menu");
                                            break;
                                        }
                                    }
                                    break;
                                case 2:
                                    while(true)
                                    {
                                        if(studentEnrolment.viewASemesterCourses("B")){
                                        System.out.print("Enter course ID: ");
                                        Scanner scanner8 = new Scanner(System.in);
                                        String courseID8 = scanner8.nextLine();
                                        Course course8 = CourseListB.courseSearch(courseID8.toUpperCase());
                                        if (course8 != null) {
                                            studentEnrolment.executeDrop(course8, "B");
                                            if(StudentEnrolment.continuePrompt("Undo previous action (Y/n)?: "))
                                            {
                                                studentEnrolment.undoEnrol(course8,"B");
                                            }
                                            if(!StudentEnrolment.continuePrompt("Dropping another course (Y/n)?: "))
                                            {
                                                break;
                                            }
                                        } else {
                                            System.out.println("Wrong Course ID.");
                                        }

                                    }
                                        else{
                                            System.out.println("Student is not currently enroled in any course this semester");
                                            System.out.println("Returning to main menu");
                                            break;
                                        }
                                    }
                                    break;
                                case 3:
                                    while(true){
                                        if(studentEnrolment.viewASemesterCourses("C")){
                                        System.out.print("Enter course ID: ");
                                        Scanner scanner5 = new Scanner(System.in);
                                        String courseID5 = scanner5.nextLine();
                                        Course course5 = CourseListC.courseSearch(courseID5.toUpperCase());
                                        if (course5 != null) {
                                            studentEnrolment.executeDrop(course5, "C");
                                            if(StudentEnrolment.continuePrompt("Undo previous action (Y/n)?: "))
                                            {
                                                studentEnrolment.undoEnrol(course5,"C");
                                            }
                                            if(!StudentEnrolment.continuePrompt("Enrolling in another course (Y/n)?: "))
                                            {
                                                break;
                                            }
                                        } else {
                                            System.out.println("Wrong Course ID.");
                                        }

                                        }
                                        else{
                                            System.out.println("Student is not currently enroled in any course this semester");
                                            System.out.println("Returning to main menu");
                                            break;
                                        }
                                    }
                                    break;
                                case 4:
                                    break;
                                case 5:
                                    System.out.println("Program exits. Have a good day!");
                                    System.exit(0);
                                    break;
                                default:
                                    System.out.println("No such choice available. Please try again!");
                            }
                            break;
                        case 3:
                            break;
                        case 4:
                            while(true)
                            {
                                studentEnrolment.viewAllCourses();
                                if(StudentEnrolment.continuePrompt("Return to main menu (Y/n)?: "))
                                {
                                    break;
                                }
                            }
                            break;
                        case 5:
                            while(true){
                            System.out.println("Please choose a semester");
                            System.out.print("1. A\n" + "2. B\n" + "3. C\n" + "4. Return\n" + "5. Quit program\n" + "Your choice: ");
                            Scanner scanner3 = new Scanner(System.in);
                            int choiceViewAll = scanner3.nextInt();
                            switch (choiceViewAll)
                            {
                                case 1:
                                    studentEnrolment.printAllEnrolments("A");
                                    break;
                                case 2:
                                    studentEnrolment.printAllEnrolments("B");
                                    break;
                                case 3:
                                    studentEnrolment.printAllEnrolments("C");
                                    break;
                                case 4:
                                    break;
                                case 5:
                                    System.out.println("Program exits. Have a good day!");
                                    System.exit(0);
                                    break;
                                default:
                                    System.out.println("No such choice available. Please try again");
                                    break;

                            }
                                if(!StudentEnrolment.continuePrompt("View another semester (Y/n)?: "))
                                {
                                    break;
                                }
                            }
                            break;
                        case 6:
                            System.out.println("Program exits. Have a good day!");
                            System.exit(0);
                        default:
                            System.out.println("No such choice available. Please try again");
                    }
                } else {
                    System.out.println("Invalid student ID. Please try again!");
                }
            }
        }
                catch(Exception e){
            }
        }
}

