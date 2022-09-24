package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.register.AnswerCityRegister;
import edu.javacourse.studentorder.domain.register.CityRegisterCheckerResponse;
import edu.javacourse.studentorder.domain.StudentOrder;
import edu.javacourse.studentorder.exception.CityRegisterException;
import edu.javacourse.studentorder.validator.register.CityRegisterChecker;
import edu.javacourse.studentorder.validator.register.FakeCityRegisterChecker;

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
            CityRegisterCheckerResponse cans = personChecker.checkerPerson(so.getChild());
        } catch (CityRegisterException ex){
            ex.printStackTrace(System.out);
        }

        AnswerCityRegister ans =  new AnswerCityRegister();
        return ans;
    }
}
