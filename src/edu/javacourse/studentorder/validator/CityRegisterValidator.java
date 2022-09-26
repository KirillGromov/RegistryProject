package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.Child;
import edu.javacourse.studentorder.domain.register.AnswerCityRegister;
import edu.javacourse.studentorder.domain.register.CityRegisterCheckerResponse;
import edu.javacourse.studentorder.domain.StudentOrder;
import edu.javacourse.studentorder.exception.CityRegisterException;
import edu.javacourse.studentorder.validator.register.CityRegisterChecker;
import edu.javacourse.studentorder.validator.register.FakeCityRegisterChecker;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.List;

public class CityRegisterValidator
{
    public String hostName;
    protected int port;
    private String login;
    String password;

    private CityRegisterChecker personChecker;

    public CityRegisterValidator() {
        personChecker = new FakeCityRegisterChecker();
    }

    public AnswerCityRegister checkCityRegister(StudentOrder so){

        try {
            CityRegisterCheckerResponse hans = personChecker.checkerPerson(so.getHasband());
            CityRegisterCheckerResponse wans = personChecker.checkerPerson(so.getWife());

            List<Child> children = so.getChildren();
            for(int i = 0; i<so.getChildren().size(); i++){
                CityRegisterCheckerResponse cans = personChecker.checkerPerson(so.getChildren().get(i));
            }

            for(Iterator<Child> it = children.iterator(); it.hasNext();){
                Child child = it.next();
                CityRegisterCheckerResponse cans = personChecker.checkerPerson(child);
            }

            for(Child child : children){
                CityRegisterCheckerResponse cans = personChecker.checkerPerson(child);
            }


        } catch (CityRegisterException ex){
            ex.printStackTrace(System.out);
        }

        AnswerCityRegister ans =  new AnswerCityRegister();
        return ans;
    }
}
