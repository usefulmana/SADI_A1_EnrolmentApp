package SADI.Courses;

import java.util.List;

public interface CourseList {
    public void addCourse(List<Course> courses);
    public void removeCourse(List<Course> courses,String courseID);
}
