package tasks;

import interactions.Operations;
import interactions.WaitInteractions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static userinterface.CalculatorUi.*;
import static utils.Constants.*;


public class CalculatorTask implements Task {

    private final String numberOne;
    private final String numberTwo;

    public CalculatorTask(String numberOne, String numberTwo) {
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Operations.inSmartPos(BTN_NUMERIC_KEYBOARD, numberOne)
        );
        if (numberOne.equals(NUM_ONE)) {
            actor.attemptsTo(
                    WaitInteractions.untilAppears(BTN_MULTIPLY),
                    Click.on(BTN_MULTIPLY)
            );
        } else if (numberOne.equals(NUM_TWO)) {
            actor.attemptsTo(
                    WaitInteractions.untilAppears(BTN_SUBSTRACT),
                    Click.on(BTN_SUBSTRACT)
            );
        } else {
            actor.attemptsTo(
                    WaitInteractions.untilAppears(BTN_ADDITION),
                    Click.on(BTN_ADDITION)
            );
        }
        actor.attemptsTo(
                Operations.inSmartPos(BTN_NUMERIC_KEYBOARD, numberTwo)
        );
    }

    public static CalculatorTask inApp(String numberOne, String numberTwo) {
        return Tasks.instrumented(CalculatorTask.class, numberOne, numberTwo);
    }
}