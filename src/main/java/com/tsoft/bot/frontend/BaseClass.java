package com.tsoft.bot.frontend;


import com.tigervnc.rfb.Screen;
import com.tsoft.bot.frontend.exceptions.FrontEndException;
import com.tsoft.bot.frontend.utility.ExtentReportUtil;
import com.tsoft.bot.frontend.utility.GenerateWord;
import com.tsoft.bot.frontend.utility.Sleeper;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.Arrays;


public class BaseClass {

    static GenerateWord generateWord = new GenerateWord();

    public static void click(WebDriver driver, String key, String locator) throws Throwable {
        try {

            switch (key.toLowerCase()) {

                case "id":
                    new WebDriverWait(driver, 20, 40).until(ExpectedConditions.presenceOfElementLocated(By.id(locator))).click();
                    break;

                case "name":
                    new WebDriverWait(driver, 20, 40).until(ExpectedConditions.presenceOfElementLocated(By.name(locator))).click();
                    break;

                case "css":
                    new WebDriverWait(driver, 20, 40).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator))).click();
                    break;

                case "linktext":
                    new WebDriverWait(driver, 20, 40).until(ExpectedConditions.presenceOfElementLocated(By.linkText(locator))).click();
                    break;

                case "xpath":
                    new WebDriverWait(driver, 20, 40).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).click();
                    break;
            }

        } catch (Throwable t) {

            generateWord.sendText("Error : No se encontró el elemento : " + locator);

            generateWord.addImageToWord(driver);

            handleError(driver, "", "No se encontro el elemento : " + locator);

            driver.close();

            throw t;
        }
    }

    public static Exception handleError(WebDriver driver, String codigo, String msg) throws Throwable {
        stepWarning(driver, msg);
        return new FrontEndException(StringUtils.trimToEmpty(codigo), msg);
    }

    public static void sleep(int milisegundos) {
        Sleeper.Sleep(milisegundos);
    }

    public static void stepPass(WebDriver driver, String descripcion) throws Throwable {
        try {
            ExtentReportUtil.INSTANCE.stepPass(driver, descripcion);
        } catch (Throwable t) {
            System.out.println(Arrays.toString(t.getStackTrace()));
            throw t;
        }
    }

    public static void stepPass(Screen screen, String descripcion) throws Throwable {
        try {
            ExtentReportUtil.INSTANCE.stepPass(screen, descripcion);
        } catch (Throwable t) {
            System.out.println(Arrays.toString(t.getStackTrace()));
            throw t;
        }
    }

    public static void stepWarning(WebDriver driver, String descripcion) throws Throwable {
        try {
            ExtentReportUtil.INSTANCE.stepWarning(driver, descripcion);
        } catch (Throwable t) {
            System.out.println(Arrays.toString(t.getStackTrace()));
            throw t;
        }
    }

    public static void stepFail(WebDriver driver, String descripcion) throws Throwable {
        try {
            ExtentReportUtil.INSTANCE.stepFail(driver, descripcion);
        } catch (Throwable t) {
            System.out.println(Arrays.toString(t.getStackTrace()));
            throw t;
        }
    }

    public static void stepFailNoShoot(String descripcion) throws Throwable {
        try {
            ExtentReportUtil.INSTANCE.stepFailNoShoot(descripcion);
        } catch (Throwable t) {
            System.out.println(Arrays.toString(t.getStackTrace()));
            throw t;
        }
    }

    public static void highLighterWebElement(WebDriver driver, WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('style', 'border: 3px solid blue;');", element);
        } catch (Throwable t) {
            System.out.println(Arrays.toString(t.getStackTrace()));
            throw t;
        }
    }

    public static void scroll(WebDriver driver, int x, int y) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(" + x + "," + y + ")", "");
        } catch (Throwable t) {
            System.out.println(Arrays.toString(t.getStackTrace()));
            throw t;
        }
    }



}

