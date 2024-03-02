package question;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static userinterface.CalculatorUi.*;

public class ValidationResult implements Question<Boolean> {

    private final String resultOperation;

    public ValidationResult(String resultOperation) {
        this.resultOperation = resultOperation;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String result = LBL_RESULT.resolveFor(actor).getText();
        return result.equals(resultOperation);
    }

    public static ValidationResult inApp(String resultOperation) {
        return new ValidationResult(resultOperation);
    }
}