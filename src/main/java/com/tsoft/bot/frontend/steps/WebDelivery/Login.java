package com.tsoft.bot.frontend.steps.WebDelivery;

import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.pages.pages.LoginWDe;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
//import sun.rmi.runtime.Log;

public class Login {
    public WebDriver driver;
   LoginWDe login = new LoginWDe();
    public Login() {
        this.driver = Hook.getDriver();
    }

    @Given("^INGRESAMOS A LA URL DE WEB DELIVERY \"([^\"]*)\"$")
    public void ingresamosALAURLDEWEBDELIVERY(String casoPrueba) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       // throw new PendingException();
        login.ingresoALaUrlDeWEBDELIVERY(casoPrueba);
    }

    @When("^INGRESAMOS USUARIO A WEB DELIVERY\"([^\"]*)\"$")
    public void ingresamosUSUARIOAWEBDELIVERY(String casoPrueba) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        login.ingresoElUsuarioDeWEBDELIVERY(casoPrueba);
    }

    @And("^INGRESAMOS CONTRASEÑA A WEB DELIVER\"([^\"]*)\"$")
    public void ingresamosCONTRASEÑAAWEBDELIVER(String casoPrueba) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       // throw new PendingException();
        login.laContraseñaDeWEBDELIVERY(casoPrueba);
    }

    @Then("^CLICK BOTON LOGIN INGRESANDO CORRECTAMENTE A LA PAGINA$")
    public void clickBOTONLOGININGRESANDOCORRECTAMENTEALAPAGINA () throws Throwable {
        login.seDaClicEnElBotonLoginDeWEBDELIVERYIngresandoCorrectamente();
    }


}
