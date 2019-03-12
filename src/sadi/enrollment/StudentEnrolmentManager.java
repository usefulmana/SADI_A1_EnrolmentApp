package sadi.enrollment;

import sadi.course.Course;

import java.util.List;

public interface StudentEnrolmentManager {
        public void enrol(Course course, String semester);
        public void drop(Course course, String semester);
        public void update(Course oldcourse, Course newCourse, String semester);
        public List<Course> getCourses(String semester);
        public List<Course> getAll();
}
