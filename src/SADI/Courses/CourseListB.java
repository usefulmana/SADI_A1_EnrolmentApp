package SADI.Courses;

import SADI.Iterator.MyIterator;

import java.util.ArrayList;
import java.util.List;

public class CourseListB implements CourseList, MyIterator {
    private String semester = "B";
    private static List<Course> courseList = new ArrayList<>();
    private static CourseListB INSTANCE = new CourseListB();

    private CourseListB(){}

    public static CourseListB getINSTANCE() {
        return INSTANCE;
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
    public void addCourse(List<Course> courses) {
        for (int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getAvailability().contains(this.semester))
            {
                courseList.add(courses.get(i));
            }
        }
    }

    @Override
    public String toString() {
        return "CourseListB{" +
                "courseList=" + courseList +
                '}';
    }


    public static void printCourseList() {
        for (int i = 0; i < courseList.size(); i++) {
            System.out.println(courseList.get(i).getCourseId() + " - " + courseList.get(i).getCourseName());
        }
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
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }

    public List<Course> getCourseList() {
        return courseList;
    }
}
