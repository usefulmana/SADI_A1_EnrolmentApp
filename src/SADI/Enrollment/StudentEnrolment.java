package SADI.Enrollment;

import SADI.Courses.Course;
import SADI.Courses.CourseListA;
import SADI.Courses.CourseListB;
import SADI.Courses.CourseListC;
import SADI.Person.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentEnrolment implements StudentEnrolmentManager{
    private Student student;
    private CourseListA courseListA = CourseListA.getINSTANCE();
    private CourseListB courseListB = CourseListB.getINSTANCE();
    private CourseListC courseListC = CourseListC.getINSTANCE();
    private List<Course> studentCourseA = new ArrayList<>();
    private List<Course> studentCourseB = new ArrayList<>();
    private List<Course> studentCourseC = new ArrayList<>();

    public StudentEnrolment(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public void enrol(Course course, String semester) {
        if (courseListA.getCourseList().contains(course) && semester.equals("A") && !studentCourseA.contains(course))
        {
            studentCourseA.add(course);
        }
        else
        {
            System.out.println("The student is already enrolled in this course");
        }
        if(courseListB.getCourseList().contains(course) && semester.equals("B") && !studentCourseB.contains(course))
        {
            studentCourseB.add(course);
        }
        else
        {
            System.out.println("The student is already enrolled in this course");
        }
        if(courseListC.getCourseList().contains(course) && semester.equals("C") && !studentCourseC.contains(course))
        {
            studentCourseC.add(course);
        }
        else
        {
            System.out.println("The student is already enrolled in this course");
        }

    }

    @Override
    public void drop(Course course, String semester) {

    }

    @Override
    public void update(Course course, String semester) {

    }

    @Override
    public String toString() {
        return "StudentEnrolment{" +
                "studentCourseA=" + studentCourseA +
                ", studentCourseB=" + studentCourseB +
                '}';
    }

    @Override
    public List<Course> getCourses(String semester) {
        return null;
    }

    @Override
    public List<Course> getAll() {
        return null;
    }
}
