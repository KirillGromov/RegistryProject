package edu.javacourse.studentorder;

import edu.javacourse.studentorder.domain.*;
import edu.javacourse.studentorder.domain.children.AnswerChildren;
import edu.javacourse.studentorder.domain.register.AnswerCityRegister;
import edu.javacourse.studentorder.domain.student.AnswerStudent;
import edu.javacourse.studentorder.domain.wedding.AnswerWedding;
import edu.javacourse.studentorder.mail.MailSender;
import edu.javacourse.studentorder.validator.ChildrenValidator;
import edu.javacourse.studentorder.validator.CityRegisterValidator;
import edu.javacourse.studentorder.validator.StudentValidator;
import edu.javacourse.studentorder.validator.WeddingValidator;

public class studentOrderValidator {


    private CityRegisterValidator cityRegisterVal;
    private WeddingValidator weddingVal;
    private ChildrenValidator childrenVal;
    private StudentValidator studentVal;
    private MailSender mailSender;

    public studentOrderValidator(){
        cityRegisterVal = new CityRegisterValidator();
        weddingVal = new WeddingValidator();
        childrenVal = new ChildrenValidator();
        studentVal = new StudentValidator();
        mailSender = new MailSender();

    }

    public static void main(String[] args) {
        studentOrderValidator sov = new studentOrderValidator();
        sov.checkAll();
    }

    public void checkAll(){
        StudentOrder[] soArray = readStudentOrders();

        for(StudentOrder so: soArray){
            checkOneOrder(so);
        }
    }

    public StudentOrder[] readStudentOrders(){
        StudentOrder[] soArray = new StudentOrder[3];

        for(int i = 0; i < soArray.length; i++){
            soArray[i] = SaveStudentOrder.buildStudentOrder(i);
        }

        return soArray;
    }

    public void checkOneOrder(StudentOrder so){
        AnswerCityRegister cityAnswer = checkCityRegister(so);
//        AnswerWedding wedAnswer = checkWedding(so);
//        AnswerStudent studentAnswer = checkStudent(so);
//        AnswerChildren childAnswer = checkChildren(so);

        sendMail(so);
    }



    public AnswerCityRegister checkCityRegister(StudentOrder so){

        return cityRegisterVal.checkCityRegister(so);
    }

    public AnswerWedding checkWedding(StudentOrder so){
        return weddingVal.checkWedding(so);
    }

    public AnswerChildren checkChildren(StudentOrder so){
        return childrenVal.checkChildren(so);
    }

    public AnswerStudent checkStudent(StudentOrder so){
        return studentVal.checkStudent(so);
    }

    public void sendMail(StudentOrder so){

        mailSender.sendMail(so);
    }
}
