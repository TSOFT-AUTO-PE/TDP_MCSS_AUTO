package com.tsoft.bot.frontend.pages.pages;

import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.pages.objects.Excel_MCSS;
import com.tsoft.bot.frontend.pages.objects.Objects_MCSS;
import com.tsoft.bot.frontend.utility.ExcelReader;
import com.tsoft.bot.frontend.utility.ExtentReportUtil;
import com.tsoft.bot.frontend.utility.GenerateWord;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Screen;

import java.util.HashMap;
import java.util.List;

public class Altas_Residenciales {

    Excel_MCSS excelMCSS = new Excel_MCSS();
    Objects_MCSS ObjectsMCSS = new Objects_MCSS();
    public WebDriver driver;
    static GenerateWord generateWord = new GenerateWord();

    private List<HashMap<String, String>> getData() throws Throwable {
        return ExcelReader.data(Excel_MCSS.EXCEL_WEB, Excel_MCSS.POSTPAGO);
    }

    public Altas_Residenciales() {
        this.driver = Hook.getDriver();
    }

    public void ingresamosALAURLMCSS(String casoDePrueba) throws Throwable {
        try {
            int URL = Integer.parseInt(casoDePrueba) - 1;
            String url = getData().get(URL).get(excelMCSS.COLUMNA_URL);
            driver.get(url);
            System.out.println(ImagePath.getBundlePath());
            System.out.println(ImagePath.getBundlePath());
            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.visibilityOfElementLocated(ObjectsMCSS.RBTN_DEALER_USER));
            if (driver.findElement(ObjectsMCSS.RBTN_DEALER_USER).isDisplayed()) {
                driver.findElement(ObjectsMCSS.RBTN_DEALER_USER).click();
                generateWord.sendText("Seleccionamos User dealer");
                generateWord.addImageToWord(driver);
                driver.findElement(ObjectsMCSS.LNK_DEALER_LOGIN).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(ObjectsMCSS.TXT_USUARIO));
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
            driver.findElement(ObjectsMCSS.TXT_USUARIO).clear();
            Thread.sleep(4000);
            generateWord.sendText("Login");
            generateWord.addImageToWord(driver);
            String user = getData().get(usuario).get(excelMCSS.COLUMNA_USUARIO);
            driver.findElement(ObjectsMCSS.TXT_USUARIO).sendKeys(user);
            Thread.sleep(2000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Ingresamos Usuario");
            generateWord.sendText("Ingresamos el usuario");
            generateWord.addImageToWord(driver);
        }catch (Exception e){
            ExcelReader.writeCellValue(Excel_MCSS.EXCEL_WEB, Excel_MCSS.POSTPAGO, 1, 19, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }
    public void IngresamosContraseña(String casoDePrueba) throws Throwable {

        try {
            int contraseña = Integer.parseInt(casoDePrueba) - 1;
            driver.findElement(ObjectsMCSS.TXT_PASSWORD).clear();
            String contra = getData().get(contraseña).get(excelMCSS.COLUMNA_CONTRASENIA);
            driver.findElement(ObjectsMCSS.TXT_PASSWORD).sendKeys(contra);
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
            driver.findElement(ObjectsMCSS.BTN_INGRESAR).click();
            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.visibilityOfElementLocated(ObjectsMCSS.TXT_DOCUMENTO));
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
            wait.until(ExpectedConditions.visibilityOfElementLocated(ObjectsMCSS.BTN_COMBO_POSTPAGO));
            int sim = Integer.parseInt(casoDePrueba) - 1;
            String TIPO_SERVICIOs = getData().get(sim).get(excelMCSS.TIPO_SERVICIO);
            switch (TIPO_SERVICIOs.toUpperCase()){
                case "POSTPAGO":
                    driver.findElement(ObjectsMCSS.BTN_COMBO_POSTPAGO).click();
                    break;
                case "PREPAGO":
                    driver.findElement(ObjectsMCSS.BTN_COMBO_PREPAGO).click();
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