package SADI.Builder;

import SADI.Courses.Course;

public final class CourseBuilder {
    private String courseId;
    private String courseName;
    private int credits;

    public CourseBuilder(String courseId, String courseName, int credits) {
        this.courseId = courseId;
        this.courseName =  courseName;
        this.credits = credits;
    }

    public CourseBuilder setCourseId(String courseId) {
        this.courseId = courseId;
        return this;
    }

    public CourseBuilder setCourseName(String courseName) {
        this.courseName = courseName;
        return this;
    }

    public CourseBuilder setCredits(int credits) {
        this.credits = credits;
        return this;
    }

    public Course build() {
        return new Course(courseId, courseName, credits);
    }
}
