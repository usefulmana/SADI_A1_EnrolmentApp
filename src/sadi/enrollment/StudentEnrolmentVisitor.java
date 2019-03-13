package sadi.enrollment;

import sadi.visitor.Visitor;

public class StudentEnrolmentVisitor implements Visitor {

    private String studentID;

    public StudentEnrolmentVisitor(String studentID) {
        this.studentID = studentID;
    }

    @Override
    public void visit(StudentEnrolment studentEnrolment) {
        studentEnrolment = StudentEnrolment.getStudentEnrolment(this.studentID);
        studentEnrolment.getStudentCourseA().clear();
        studentEnrolment.getStudentCourseB().clear();
        studentEnrolment.getStudentCourseC().clear();
    }
}
