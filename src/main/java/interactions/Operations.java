package interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;

public class Operations implements Interaction {

    private final Target idNumericKeyboard;
    private final String numericKeyboard;

    public Operations(Target idNumericKeyboard, String numericKeyboard) {
        this.idNumericKeyboard = idNumericKeyboard;
        this.numericKeyboard = numericKeyboard;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        keyboard(numericKeyboard, actor);
    }

    public void keyboard(String numericKeyboard, Actor actor) {
        List<WebElementFacade> value = idNumericKeyboard.resolveAllFor(actor);
        int startIndex = 0;
        int endIndex = numericKeyboard.length();
        char[] valueDigits = numericKeyboard.substring(startIndex, endIndex).toCharArray();
        for (char valueDigit : valueDigits) {
            for (WebElementFacade webElementFacade : value) {
                if (webElementFacade.getText().equals(String.valueOf(valueDigit))) {
                    webElementFacade.click();
                    break;
                }
            }
        }
    }

    public static Operations inSmartPos(Target idNumericKeyboard, String numericKeyboard) {
        return new Operations(idNumericKeyboard, numericKeyboard);
    }
}