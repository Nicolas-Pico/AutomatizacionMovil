package stepsDefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import question.ValidationResult;
import tasks.*;
import utils.DataDrivenExcel;
import utils.Excel;
import utils.CalculatorApp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.actors.OnStage.withCurrentActor;

public class CalculatorStepsDefinition {

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("User");
    }

    Map<String, String> data = new HashMap<>();
    DataDrivenExcel dataDriverExcel = new DataDrivenExcel();

    @Given("i am in the application calculator {int}")
    public void i_am_in_the_application_calculator(int row, DataTable dataExcel) {
        List<Map<String, String>> dataFeature = dataExcel.asMaps(String.class, String.class);
        Excel excel = new Excel(dataFeature.get(0).get("Ruta Excel"), dataFeature.get(0).get("Pestana"), true, row);
        data = dataDriverExcel.leerExcel(excel);
        theActorInTheSpotlight().can(BrowseTheWeb.with(CalculatorApp.onThePhone().getDriver()));
    }

    @When("i enter the operations to be carried out")
    public void i_enter_the_operations_to_be_carried_out() {
        withCurrentActor(CalculatorTask.inApp(data.get("NumeroUno"), data.get("NumeroDos")));
    }

    @Then("it will be validated that the result is correct")
    public void it_will_be_validated_that_the_result_is_correct() {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidationResult.inApp(data.get("Resultado"))));
    }
}