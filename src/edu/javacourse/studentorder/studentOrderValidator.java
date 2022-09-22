package edu.javacourse.studentorder;

import edu.javacourse.studentorder.domain.*;
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

        while(true) {
            StudentOrder so = readStudentOrder();

            if(so == null){
                break;
            }


            AnswerCityRegister cityAnswer = checkCityRegister(so);
            if (!cityAnswer.sucess){
                //continue;
                break;
            }

            AnswerWedding wedAnswer = checkWedding(so);
            AnswerStudent studentAnswer = checkStudent(so);
            AnswerChildren childAnswer = checkChildren(so);

            sendMail(so);

        }


    }

    public StudentOrder readStudentOrder(){
        SaveStudentOrder.buildStudentOrder();
        StudentOrder so = new StudentOrder();
        return so;
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
