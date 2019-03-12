package SADI.Courses;

import java.util.ArrayList;
import java.util.List;

public class CourseListA implements CourseList{
    private String semester = "A";
    private static List<Course> courseList = new ArrayList<>();
    private static CourseListA INSTANCE = new CourseListA();

    private CourseListA(){}

    public static CourseListA getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public void addCourse(List<Course> courses) {
        for (int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getAvailability().contains(this.semester))
            {
                courseList.add(courses.get(i));
            }
        }
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public static void printCourseList() {
        for (int i = 0; i < courseList.size(); i++) {
            System.out.println(courseList.get(i).getCourseId() + " - " + courseList.get(i).getCourseName());
        }
    }

    public static Course courseSearch (String courseID){
        for (int i = 0; i < courseList.size(); i++) {
            if(courseList.get(i).getCourseId().equals(courseID))
            {
                return courseList.get(i);
            }
        }
        return null;
    }

    @Override
    public void removeCourse(List<Course> courses, String courseID) {
        for (int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getAvailability().contains(this.semester) && courses.get(i).getAvailability().equals(courseID))
            {
                courseList.remove(courses.get(i));
            }
        }
    }

    @Override
    public String toString() {
        return "CourseListA{" +
                "courseList=" + courseList +
                '}';
    }
}
