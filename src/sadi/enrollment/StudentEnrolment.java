package sadi.enrollment;

import sadi.command.Command;
import sadi.course.Course;
import sadi.course.CourseListA;
import sadi.course.CourseListB;
import sadi.course.CourseListC;
import sadi.person.Student;
import sadi.person.StudentList;

import java.util.*;


public class StudentEnrolment extends StudentEnrolmentManager implements Command {
    private Student student;
    private static List<Student> studentSubscribers = new ArrayList<>();
    private CourseListA courseListA = CourseListA.getINSTANCE();
    private CourseListB courseListB = CourseListB.getINSTANCE();
    private CourseListC courseListC = CourseListC.getINSTANCE();
    private List<Course> studentCourseA = new ArrayList<>();
    private List<Course> studentCourseB = new ArrayList<>();
    private List<Course> studentCourseC = new ArrayList<>();
    private static Map<String,StudentEnrolment> cache = new HashMap<>();
    private int creditLimit = 48;
    public StudentEnrolment() {
    }

    public StudentEnrolment(Student student) {
        this.student = student;
        cache.put(student.getId(),this);
    }

    // Flyweight Pattern
    public static StudentEnrolment getStudentEnrolment(String studentID)
    {
        StudentEnrolment studentEnrolment = cache.get(studentID);
        if (studentEnrolment != null)
        {
            return studentEnrolment;
        }
        return null;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    private boolean creditLimit(List<Course> courseList)
    {
        int credits = 0;
        for (int i = 0; i < courseList.size(); i++) {
            credits += courseList.get(i).getCredits();
        }
        if(credits <= this.creditLimit)
        {
            return true;
        }
        return false;
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public void enrol(Course course, String semester) {
        if (courseListA.getCourseList().contains(course) && semester.equals("A") && !studentCourseA.contains(course) && creditLimit(studentCourseA))
        {
            studentCourseA.add(course);
            for (Student student: studentSubscribers
                 ) {
               if(student == this.getStudent())
               {
                   System.out.println("Now enrolled in " + course.getCourseId() + " - " + course.getCourseName() +
                           " during semester " + semester);
               }
            }
        }
        else if(studentCourseA.contains(course))
        {
            System.out.println("The student is already enrolled in this course");
        }
        else if(!creditLimit(studentCourseA))
        {
            System.out.println("Students are not allowed to take more than 48 credits per semester");
        }
        if(courseListB.getCourseList().contains(course) && semester.equals("B") && !studentCourseB.contains(course) && creditLimit(studentCourseB))
        {
            studentCourseB.add(course);
            for (Student student: studentSubscribers
            ) {
                if(student == this.getStudent())
                {
                    System.out.println("Now enrolled in " + course.getCourseId() + " - " + course.getCourseName() +
                            " during semester " + semester);
                }
            }
        }
        else if(studentCourseB.contains(course))
        {
            System.out.println("The student is already enrolled in this course");
        }
        else if(!creditLimit(studentCourseB))
        {
            System.out.println("Students are not allowed to take more than 48 credits per semester");
        }
        if(courseListC.getCourseList().contains(course) && semester.equals("C") && !studentCourseC.contains(course) && creditLimit(studentCourseC))
        {
            studentCourseC.add(course);
            for (Student student: studentSubscribers
            ) {
                if(student == this.getStudent())
                {
                    System.out.println("Now enrolled in " + course.getCourseId() + " - " + course.getCourseName() +
                            " during semester " + semester);
                }
            }
        }
        else if(studentCourseC.contains(course))
        {
            System.out.println("The student is already enrolled in this course");
        }
        else if(!creditLimit(studentCourseC))
        {
            System.out.println("Students are not allowed to take more than 48 credits per semester");
        }
    }

    public static List<Student> getStudentSubscribers() {
        return studentSubscribers;
    }

    public static void setStudentSubscribers(List<Student> studentSubscribers) {
        StudentEnrolment.studentSubscribers = studentSubscribers;
    }

    @Override
    public void drop(Course course, String semester) {
        if (semester.equals("A") && studentCourseA.contains(course))
        {
            studentCourseA.remove(course);
            for (Student student: studentSubscribers
            ) {
                if(student == this.getStudent())
                {
                    System.out.println("Successfully dropped " + course.getCourseId() + " - " + course.getCourseName() +
                            " during semester " + semester);
                }
            }
        }
        if(semester.equals("B") && studentCourseB.contains(course))
        {
            studentCourseB.remove(course);
            for (Student student: studentSubscribers
            ) {
                if(student == this.getStudent())
                {
                    System.out.println("Successfully dropped " + course.getCourseId() + " - " + course.getCourseName() +
                            " during semester " + semester);
                }
            }
        }
        if(semester.equals("C") && studentCourseC.contains(course))
        {
            studentCourseC.remove(course);
            for (Student student: studentSubscribers
            ) {
                if(student == this.getStudent())
                {
                    System.out.println("Successfully dropped " + course.getCourseId() + " - " + course.getCourseName() +
                            " during semester " + semester);
                }
            }
        }
    }

    @Override
    public List<Course> getCourses(String semester) {
        return null;
    }

    @Override
    public List<Course> getAll() {
        return null;
    }

    @Override
    public String toString() {
        return "StudentEnrolment{" +
                "studentCourseA=" + studentCourseA +
                ", studentCourseB=" + studentCourseB +
                ", studentCourseC=" + studentCourseC +
                '}';
    }

    public boolean viewASemesterCourses(String semester)
    {
        if(semester.equals("A"))
        {
            if(studentCourseA.size() > 0)
            {
                for (int i = 0; i < studentCourseA.size(); i++) {
                    System.out.println(studentCourseA.get(i).getCourseId() + " - " + studentCourseA.get(i).getCourseName() + " - " +
                            studentCourseA.get(i).getCredits());
                }
                return true;
            }
            return false;
        }
        else if(semester.equals("B"))
        {
            if(studentCourseB.size()>0){
                for (int i = 0; i < studentCourseB.size(); i++) {
                    System.out.println(studentCourseB.get(i).getCourseId() + " - " + studentCourseB.get(i).getCourseName()+ " - " +
                            studentCourseB.get(i).getCredits());
                }
                return true;
            }
            return false;
        }
        else if(semester.equals("C"))
        {
            if(studentCourseC.size()>0){
                for (int i = 0; i < studentCourseC.size(); i++) {
                    System.out.println(studentCourseC.get(i).getCourseId() + " - " + studentCourseC.get(i).getCourseName()+ " - " +
                            studentCourseC.get(i).getCredits());
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void viewAllCourses()
    {
        System.out.println("Semester A");
        viewASemesterCourses("A");
        System.out.println("Semester B");
        viewASemesterCourses("B");
        System.out.println("Semester C");
        viewASemesterCourses("C");
    }

    public static boolean continuePrompt(String message)
    {
        System.out.print(message);
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine().toUpperCase();
        if(choice.equals("Y"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void printAllEnrolments(String semester)
    {
        for (String key: cache.keySet()
             ) {
            System.out.println(StudentList.searchStudent(key).getId() + " - " + StudentList.searchStudent(key).getName());
            cache.get(key).viewASemesterCourses(semester);
            System.out.println("---------------------------------------------");
        }
    }

    @Override
    public void executeEnrol(Course course, String semester) {
        enrol(course, semester);
    }

    @Override
    public void undoEnrol(Course course, String semester) {
        drop(course,semester);
    }

    @Override
    public void executeDrop(Course course, String semester) {
        drop(course,semester);
    }

    @Override
    public void undoDrop(Course course, String semester) {
        enrol(course,semester);
    }
}
