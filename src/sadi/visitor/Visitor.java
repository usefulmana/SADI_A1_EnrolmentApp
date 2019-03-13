package sadi.visitor;

import sadi.enrollment.StudentEnrolment;

public interface Visitor {
    public void visit(StudentEnrolment studentEnrolment);
}
