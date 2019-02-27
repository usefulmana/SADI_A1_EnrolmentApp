package SADI.Enrollment;

public interface Enrolment {
    void addCourses(String courseId);
    void deleteCourses(String courseId);
    void updateCourses(String studentId, String courseId);
    void displayCourses(String studentId);
}
