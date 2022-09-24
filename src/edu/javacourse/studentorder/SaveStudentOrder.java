package edu.javacourse.studentorder;

import edu.javacourse.studentorder.domain.Address;
import edu.javacourse.studentorder.domain.Child;
import edu.javacourse.studentorder.domain.Adult;
import edu.javacourse.studentorder.domain.StudentOrder;

import java.time.LocalDate;

public class SaveStudentOrder {


    public static void main(String[] args) {
        StudentOrder s = buildStudentOrder(10);


//        StudentOrder so = new StudentOrder();
//        long ans = saveStudentOrder(so);
//        System.out.println(ans);


    }

    static long saveStudentOrder(StudentOrder studentOrder){
        long answer = 199;
        System.out.println("saveStudentOrder:");
        return answer;
    }

     public static StudentOrder buildStudentOrder(long id){
        StudentOrder so = new StudentOrder();
        so.setStudentOrderId(id);
        so.setMarriageCertificateId("" + (123456000 + id));
        so.setMarriageDate(LocalDate.of(2016, 7, 4));
        so.setMarriageOffice("Отдел ЗАГС");


        Address address = new Address("195000", "Заневский пр.", "12", "", "142");

        Adult husband = new Adult("Петров", "Виктор", "Сергеевич", LocalDate.of(1997, 8, 24));
        husband.setPassportSeria("" + (1000 + id));
        husband.setPassportNumber("" + (100000 + id));
        husband.setIssueDate(LocalDate.of(2017, 9,15));
        husband.setIssueDepartment("Отдел полиции №" + id);
        husband.setStudentId("" + (100000 + id));
        husband.setAddress(address);

        Adult wife = new Adult("Петров", "Виктор", "Сергеевич", LocalDate.of(1997, 8, 24));
        wife.setPassportSeria("" + (2000 + id));
        wife.setPassportNumber("" + (200000 + id));
        wife.setIssueDate(LocalDate.of(2018, 4,10));
        wife.setIssueDepartment("Отдел полиции №" + id);
        wife.setStudentId("" + (200000 + id));
        wife.setAddress(address);

        Child child = new Child("Петрова", "Ирина", "Викторовна", LocalDate.of(2018, 6, 29));
        child.setCertificateNumber("" + (300000 + id));
        child.setIssueDate(LocalDate.of(2018, 7, 19));
        child.setIssueDepartment("Отдел ЗАГС №" + id);
        child.setAddress(address);

        so.setHasband(husband);
        so.setWife(wife);
        so.setChild(child);

        return so;
    }
    static void printStudentOrder(StudentOrder stOR){
        System.out.println(stOR.getStudentOrderId());
    }
}
