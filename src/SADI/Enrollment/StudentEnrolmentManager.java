package SADI.Enrollment;

import SADI.Courses.Course;

import java.util.List;

public interface StudentEnrolmentManager {
    public void enrol(Course course);
    public Course getCourse(Course course);
    public void updateEnrolment(Course old_course, Course new_course);
    public void dropCourse(Course course);
    public List<Course> getAllCourses(String id);
}
