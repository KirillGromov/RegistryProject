package edu.javacourse.studentorder.domain.other;

import edu.javacourse.studentorder.domain.Person;

public class Adult extends Person
{
    private String passportSeria;
    private String passportNumber;
    private String issueDate;
    private String issueDepartment;
    private String univesity;
    private String studentId;

    public Adult(){
        System.out.println("Adult is created");
    }

    public String getPersonString(){
        return surName + " " + givenName + " " + passportNumber;
    }



    public String getUnivesity() {
        return univesity;
    }

    public void setUnivesity(String univesity) {
        this.univesity = univesity;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getPassportSeria() {
        return passportSeria;
    }

    public void setPassportSeria(String passportSeria) {
        this.passportSeria = passportSeria;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getIssueDepartment() {
        return issueDepartment;
    }

    public void setIssueDepartment(String issueDepartment) {
        this.issueDepartment = issueDepartment;
    }
}
