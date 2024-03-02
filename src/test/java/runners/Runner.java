package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith (CucumberWithSerenity.class)
@CucumberOptions (
        features = "src/test/resources/features/",
        glue = "stepsDefinition",
        snippets = CucumberOptions.SnippetType.UNDERSCORE,
        plugin = {"pretty"},
        monochrome = true,
        tags = "@calculator"
)

public class Runner {
}