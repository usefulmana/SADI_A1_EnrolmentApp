package SADI.CoR;

import SADI.Courses.Course;

public interface Chain {
    public void setNextChain(Chain nextChain);
    public void addCourse(Course course);
}
