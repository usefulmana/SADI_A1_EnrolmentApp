package SADI.Enrollment;

import SADI.Courses.Course;

import java.util.List;

public interface StudentEnrolmentManager {
        public void enrol(Course course, String semester);
        public void drop(Course course, String semester);
        public void update(Course course, String semester);
        public List<Course> getCourses(String semester);
        public List<Course> getAll();
}
