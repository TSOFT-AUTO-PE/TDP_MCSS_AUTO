package com.tsoft.bot.frontend.pages.pages;

import com.tsoft.bot.frontend.Base.BaseClass;
import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.pages.objects.Excel_MCSS;
import com.tsoft.bot.frontend.pages.objects.Objects_MCSS;
import com.tsoft.bot.frontend.utility.ExcelReader;
import com.tsoft.bot.frontend.utility.ExtentReportUtil;
import com.tsoft.bot.frontend.utility.GenerateWord;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;

import java.util.HashMap;
import java.util.List;

public class Altas_Residenciales extends BaseClass {

    public WebDriver driver;
    static GenerateWord generateWord = new GenerateWord();

    private List<HashMap<String, String>> getData() throws Throwable {
        return ExcelReader.data(Excel_MCSS.EXCEL_WEB, Excel_MCSS.POSTPAGO);
    }
    public Altas_Residenciales (WebDriver driver){
        super(driver);
        this.driver = Hook.getDriver();

    }
    public void IngresamosURL(String casoDePrueba) throws Throwable {
        try {
            int URL = Integer.parseInt(casoDePrueba) - 1;
            String url = getData().get(URL).get(Excel_MCSS.COLUMNA_URL);
            driver.get(url);
            waitUntil(driver,60, Objects_MCSS.RBTN_DEALER_USER);
            if (isDisplayed(driver, Objects_MCSS.RBTN_DEALER_USER)) {
                click(driver,Objects_MCSS.RBTN_DEALER_USER);
                ExtentReportUtil.INSTANCE.stepPass(driver, "Seleccionamos User dealer");
                generateWord.sendText("Seleccionamos User dealer");
                generateWord.addImageToWord(driver);
                System.out.println("Seleccionamos Dealer User");
                click(driver,Objects_MCSS.LNK_DEALER_LOGIN);
                waitUntil(driver,60, Objects_MCSS.TXT_USUARIO);
            }
        } catch (Exception e) {
            ExcelReader.writeCellValue(Excel_MCSS.EXCEL_WEB, Excel_MCSS.POSTPAGO, 1, 19, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }
    public void IngresamosUsuario(String casoDePrueba) throws Throwable {
        try {
            int usuario = Integer.parseInt(casoDePrueba) - 1;
            driver.findElement(Objects_MCSS.TXT_USUARIO).clear();
            Thread.sleep(4000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Login");
            generateWord.sendText("Login");
            generateWord.addImageToWord(driver);
            String user = getData().get(usuario).get(Excel_MCSS.COLUMNA_USUARIO);
            driver.findElement(Objects_MCSS.TXT_USUARIO).sendKeys(user);
            Thread.sleep(2000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Ingresamos Usuario");
            generateWord.sendText("Ingresamos el usuario");
            generateWord.addImageToWord(driver);
            System.out.println("Ingresamos usuario");
        }catch (Exception e){
            ExcelReader.writeCellValue(Excel_MCSS.EXCEL_WEB, Excel_MCSS.POSTPAGO, 1, 19, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }
    public void IngresamosContraseña(String casoDePrueba) throws Throwable {

        try {
            int contrasenia = Integer.parseInt(casoDePrueba) - 1;
            driver.findElement(Objects_MCSS.TXT_PASSWORD).clear();
            String contra = getData().get(contrasenia).get(Excel_MCSS.COLUMNA_CONTRASENIA);
            driver.findElement(Objects_MCSS.TXT_PASSWORD).sendKeys(contra);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Ingresamos contraseña");
            generateWord.sendText("Ingresamos contraseña");
            generateWord.addImageToWord(driver);
        }catch (Exception e){
            ExcelReader.writeCellValue(Excel_MCSS.EXCEL_WEB, Excel_MCSS.POSTPAGO, 1, 19, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }
    public void IngresoCorrectoalaPag() throws Throwable {
        try {
            driver.findElement(Objects_MCSS.BTN_INGRESAR).click();

            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.visibilityOfElementLocated(Objects_MCSS.TXT_DOCUMENTO));
            Thread.sleep(2000);
            generateWord.sendText("Ingresamos a MCSS");
            generateWord.addImageToWord(driver);

        }catch (Exception e){
            ExcelReader.writeCellValue(Excel_MCSS.EXCEL_WEB, Excel_MCSS.POSTPAGO, 1, 19, "FAIL");
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }
    public void seleccionamosTipoDeAlta(String casoDePrueba) throws Throwable {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 180);
            wait.until(ExpectedConditions.visibilityOfElementLocated(Objects_MCSS.BTN_COMBO_POSTPAGO));
            int sim = Integer.parseInt(casoDePrueba) - 1;
            String TIPO_SERVICIOs = getData().get(sim).get(Excel_MCSS.TIPO_SERVICIO);
            switch (TIPO_SERVICIOs.toUpperCase()){
                case "POSTPAGO":
                    driver.findElement(Objects_MCSS.BTN_COMBO_POSTPAGO).click();
                    break;
                case "PREPAGO":
                    driver.findElement(Objects_MCSS.BTN_COMBO_PREPAGO).click();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + TIPO_SERVICIOs);
            }
            Screen screen = new Screen();
            //screen.wait(ObjectsMCSS.BTN_SGT);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Combo "+TIPO_SERVICIOs);
            generateWord.sendText("Combo "+TIPO_SERVICIOs);
            generateWord.addImageToWord(driver);

        }catch (Exception e){
            ExcelReader.writeCellValue(Excel_MCSS.EXCEL_WEB, Excel_MCSS.POSTPAGO, 1, 19, "FAIL");
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }


    }


}