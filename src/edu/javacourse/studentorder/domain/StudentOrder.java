package edu.javacourse.studentorder.domain;

import edu.javacourse.studentorder.domain.other.Adult;

public class StudentOrder
{
    private long studentOrderId;
    private Adult hasband;
    private Adult wife;
    private Child child;

    public long getStudentOrderId() {
        return studentOrderId;
    }

    public void setStudentOrderId(long studentOrderId) {
        this.studentOrderId = studentOrderId;
    }

    public Adult getHasband() {
        return hasband;
    }

    public void setHasband(Adult hasband) {
        this.hasband = hasband;
    }

    public Adult getWife() {
        return wife;
    }

    public void setWife(Adult wife) {
        this.wife = wife;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }
}
