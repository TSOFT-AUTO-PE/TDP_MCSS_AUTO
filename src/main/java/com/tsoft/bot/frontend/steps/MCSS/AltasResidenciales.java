package com.tsoft.bot.frontend.steps.MCSS;

import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.pages.pages.Altas_Residenciales;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class AltasResidenciales {
    public WebDriver driver;
    Altas_Residenciales Altas = new Altas_Residenciales();
    public AltasResidenciales() {
        this.driver = Hook.getDriver();
    }

    @Given("^INGRESAMOS A LA URL MCSS \"([^\"]*)\"$")
    public void ingresamosALAURLMCSS(String casoDePrueba) throws Throwable {
        Altas.ingresamosALAURLMCSS(casoDePrueba);
    }

    @When("^INGRESAMOS USUARIO A MCSS\"([^\"]*)\"$")
    public void ingresamosUSUARIOAMCSS(String casoDePrueba) throws Throwable {
        Altas.IngresamosUsuario(casoDePrueba);
    }

    @And("^INGRESAMOS CONTRASEÑA A MCSS\"([^\"]*)\"$")
    public void ingresamosCONTRASEÑAAMCSS(String casoDePrueba) throws Throwable {
        Altas.IngresamosContraseña(casoDePrueba);
    }

    @Then("^INGRESO CORRECTO A LA PAGINA$")
    public void ingresoCORRECTOALAPAGINA() throws Throwable{
        Altas.IngresoCorrectoalaPag();
    }

    @Given("^SELECCIONAMOS EL TIPO DE ALTA \"([^\"]*)\"$")
    public void seleccionamosELTIPODEALTA(String arg0) throws Throwable {

    }
}
