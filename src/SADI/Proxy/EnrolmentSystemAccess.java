package SADI.Proxy;

import SADI.Courses.Course;

import java.util.List;

public interface EnrolmentSystemAccess {
    public List<Course> getStudentCourseA();
    public List<Course> getStudentCourseB();
    public List<Course> getStudentCourseC();
    public List<Course> getAllEnrolment();
}
