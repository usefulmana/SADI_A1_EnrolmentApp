package SADI.Builder;

import SADI.Courses.Course;

public final class CoursesBuilder {
    private String courseId;
    private String courseName;
    private int credits;

    public CoursesBuilder(String courseId, String courseName, int credits) {
        this.courseId = courseId;
        this.courseName =  courseName;
        this.credits = credits;
    }

    public CoursesBuilder setCourseId(String courseId) {
        this.courseId = courseId;
        return this;
    }

    public CoursesBuilder setCourseName(String courseName) {
        this.courseName = courseName;
        return this;
    }

    public CoursesBuilder setCredits(int credits) {
        this.credits = credits;
        return this;
    }

    public Course build() {
        return new Course(courseId, courseName, credits);
    }
}
