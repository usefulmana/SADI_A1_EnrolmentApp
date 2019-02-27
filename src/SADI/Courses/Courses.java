package SADI.Courses;

import java.util.List;

public abstract class Courses {
    private String courseId;
    private String courseName;
    private int credits;
    private List<String> availability;

    public abstract String getCourseId();
    public abstract String getCourseName();
    public abstract int getCredits();
    public abstract List<String> getAvailability();
    public abstract List<String> addAvailability(String str);
    public abstract List<String> deleteAvailability(String str);
}
