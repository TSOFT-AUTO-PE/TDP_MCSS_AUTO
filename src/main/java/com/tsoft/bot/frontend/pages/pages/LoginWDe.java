package com.tsoft.bot.frontend.pages.pages;

import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.pages.objects.ExcelWD;
import com.tsoft.bot.frontend.pages.objects.LoginWD;
import com.tsoft.bot.frontend.steps.WebDelivery.Login;
import com.tsoft.bot.frontend.utility.ExcelReader;
import com.tsoft.bot.frontend.utility.ExtentReportUtil;
import com.tsoft.bot.frontend.utility.GenerateWord;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.ImagePath;

import java.util.HashMap;
import java.util.List;

public class LoginWDe {

    ExcelWD excelWD = new ExcelWD();
    public WebDriver driver;
    String step = "";
    static GenerateWord generateWord = new GenerateWord();

    private List<HashMap<String, String>> getData() throws Throwable {
        return ExcelReader.data(excelWD.EXCEL_WEB, excelWD.LOGIN_WEB);
    }

    public LoginWDe() {
        this.driver = Hook.getDriver();
    }


    public void ingresoALaUrlDeWEBDELIVERY(String casoDePrueba) throws Throwable {
        try {
            String var ="Jenki";

            int LoginWD = Integer.parseInt(casoDePrueba) - 1;
            String url = getData().get(LoginWD).get(excelWD.COLUMNA_URL);
            driver.get(url);
            ExcelReader.writeCellValue(excelWD.EXCEL_WEB,excelWD.LOGIN_WEB,1,15,var);

            ExtentReportUtil.INSTANCE.stepPass(driver, "Se cargó correctamente la página");
            generateWord.sendText("Carga correcta de la página");
            generateWord.addImageToWord(driver);
            generateWord.sendBreak();
            System.out.println(ImagePath.getBundlePath());


        }catch (Exception e){
            ExcelReader.writeCellValue(excelWD.EXCEL_WEB, excelWD.LOGIN_WEB, 1, 19, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    public void ingresoElUsuarioDeWEBDELIVERY(String casoDePrueba) throws Throwable {

        try {
            int user = Integer.parseInt(casoDePrueba) - 1;
            String usuario = getData().get(user).get(excelWD.COLUMNA_USUARIO);
            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.visibilityOfElementLocated(LoginWD.TXT_USER));
            if (driver.findElement(LoginWD.TXT_USER).isDisplayed()){
                driver.findElement(LoginWD.TXT_USER).clear();
                driver.findElement(LoginWD.TXT_USER).sendKeys(usuario);
            }
            ExtentReportUtil.INSTANCE.stepPass(driver, "Ingresamos el usuario");
            generateWord.sendText("Ingresamos el usuario");
            generateWord.addImageToWord(driver);

        }catch (Exception e){
            ExcelReader.writeCellValue(excelWD.EXCEL_WEB, excelWD.LOGIN_WEB, 1, 19, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);

        }
    }


    public void laContraseñaDeWEBDELIVERY(String casoDePrueba) throws Throwable {

        try {
            int PASS = Integer.parseInt(casoDePrueba) - 1;
            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.visibilityOfElementLocated(LoginWD.TXT_PASSWORD));
            driver.findElement(LoginWD.TXT_PASSWORD).clear();
            String contra = getData().get(PASS).get(excelWD.COLUMNA_CONTRASENIA);
            driver.findElement(LoginWD.TXT_PASSWORD).sendKeys(contra);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Ingresamos la contraseña");
            generateWord.sendText("Ingresamos la contraseña");
            generateWord.addImageToWord(driver);

        }catch (Exception e){
            ExcelReader.writeCellValue(excelWD.EXCEL_WEB, excelWD.LOGIN_WEB, 1, 19, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }


    public void seDaClicEnElBotonLoginDeWEBDELIVERYIngresandoCorrectamente() throws Throwable {
        try {
            driver.findElement(LoginWD.BTN_LOGIN).click();
            Thread.sleep(2000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se ingresa correctamente");
            generateWord.sendText("Se ingresa correctamente");
            generateWord.addImageToWord(driver);
        }catch (Exception e){
            ExcelReader.writeCellValue(excelWD.EXCEL_WEB, excelWD.LOGIN_WEB, 1, 19, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }



}
