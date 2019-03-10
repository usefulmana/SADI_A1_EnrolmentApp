package SADI.Enrollment;

import SADI.Courses.Course;
import SADI.Iterator.CourseIterator;

import java.util.ArrayList;
import java.util.List;

public class SemesterAEnrolment implements StudentEnrolmentManager, CourseIterator {
    private static List<Course> semesterACourseList = new ArrayList<>();
    private List<Course> courseList = new ArrayList<>();
    private static SemesterAEnrolment instance = new SemesterAEnrolment();
    private int currentItem = 0;
    
    private SemesterAEnrolment(){}

    public static SemesterAEnrolment getInstance() {
        return instance;
    }

    public void addCourse(Course course)
    {
        semesterACourseList.add(course);
    }

    public void deleteCourse(Course course){
        for (int i = 0; i < semesterACourseList.size(); i++) {
            if(semesterACourseList.get(i).equals(course))
            {
                semesterACourseList.remove(course);
            }
        }
    }

    public void viewCourseList()
    {
        for (int i = 0; i < semesterACourseList.size(); i++) {
            System.out.println(semesterACourseList.get(i));
        }
    }

    @Override
    public boolean hasNext() {
        if(currentItem >= courseList.size())
        {
            currentItem = 0;
            return false;
        }
        return true;
    }

    @Override
    public Object next() {
        return courseList.get(currentItem++);
    }

    @Override
    public void enrol(Course course) {
        courseList.add(course);
    }

    @Override
    public Course getCourse(Course course) {
        for (int i = 0; i < courseList.size(); i++) {
            if(course.equals(courseList.get(i)))
            {
                return course;
            }
        }
        return null;
    }

    @Override
    public void updateEnrolment(Course old_course, Course new_course) {
            dropCourse(old_course);
            enrol(new_course);

    }

    @Override
    public void dropCourse(Course course) {
        if(course.equals(getCourse(course)))
        {
            courseList.remove(course);
        }
    }

    @Override
    public List<Course> getAllCourses(String id) {
        return courseList;
    }
}
