package userinterface;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

import static org.openqa.selenium.By.*;

public class CalculatorUi extends PageObject {

    public static final Target BTN_NUMERIC_KEYBOARD = Target.the("Button numeric keyboard")
            .located(xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android." +
                    "widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/" +
                    "android.widget.Button"));

    public static final Target BTN_MULTIPLY = Target.the("Button multiply")
            .located(AppiumBy.id("com.google.android.calculator:id/op_mul"));

    public static final Target BTN_ADDITION = Target.the("Button addition")
            .located(AppiumBy.id("com.google.android.calculator:id/op_add"));

    public static final Target BTN_SUBSTRACT = Target.the("Button substract")
            .located(AppiumBy.id("com.google.android.calculator:id/op_sub"));

    public static final Target LBL_RESULT = Target.the("Label result")
            .located(AppiumBy.id("com.google.android.calculator:id/result_final"));
}