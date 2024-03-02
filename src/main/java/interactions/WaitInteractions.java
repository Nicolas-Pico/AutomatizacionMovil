package interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitInteractions implements Interaction {

    private final Target target;
    private final String state;

    public WaitInteractions(Target target, String state) {
        this.target = target;
        this.state = state;
    }

    @Override
    @Step("{0} waits the #target until be #state")
    public <T extends Actor> void performAs(T actor) {
        switch (state){
            case "Visible":
                waitAs(actor).until(ExpectedConditions.visibilityOf(target.resolveFor(actor)));
                break;
            case "Invisible":
                waitAs(actor).until(ExpectedConditions.invisibilityOf(target.resolveFor(actor)));
                break;
            case "Enabled":
                waitAs(actor).until(ExpectedConditions.elementToBeClickable(target.resolveFor(actor)));

        }

    }

    private WebDriverWait waitAs(Actor actor)
    { return new WebDriverWait(BrowseTheWeb.as(actor).getDriver(), Duration.ofSeconds(180));}
    public static WaitInteractions untilAppears(Target target){
        return Tasks.instrumented(WaitInteractions.class,target,"Visible");
    }

    public static WaitInteractions untilDisappears(Target target){
        return Tasks.instrumented(WaitInteractions.class,target,"Invisible");
    }

    public static WaitInteractions untilBeEnable(Target target){
        return Tasks.instrumented(WaitInteractions.class,target,"Enabled");
    }
}