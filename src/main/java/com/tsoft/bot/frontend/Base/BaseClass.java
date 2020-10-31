package com.tsoft.bot.frontend.Base;

import com.tsoft.bot.frontend.exceptions.FrontEndException;
import com.tsoft.bot.frontend.utility.ExtentReportUtil;
import com.tsoft.bot.frontend.utility.GenerateWord;
import com.tsoft.bot.frontend.utility.Sleeper;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.NoSuchElementException;


public class BaseClass {

    private static GenerateWord generateWord = new GenerateWord();
    private WebDriver driver;

    public BaseClass(WebDriver driver){
        this.driver = driver;
    }

    protected void click(WebDriver driver, By locator) {
        try {
            driver.findElement(locator).click();
        }catch (Throwable we){
            errorNoElementFound(driver, locator);
            throw we;
        }
    }

    protected void clear(WebDriver driver, By locator) {
        try {
            driver.findElement(locator).clear();
        }catch (Throwable we){
            errorNoElementFound(driver, locator);
            throw we;
        }
    }

    protected void typeText(WebDriver driver, By locator, String inputText){
        try {
            driver.findElement(locator).sendKeys(inputText);
        }catch (Throwable we){
            errorNoElementFound(driver, locator);
            throw we;
        }
    }

    protected Boolean isDisplayed(WebDriver driver, By locator){
        try {
            return driver.findElement(locator).isDisplayed();
        }catch (NoSuchElementException we){
            driver.close();
            return false;
        }
    }

    protected void selectByVisibleText(WebDriver driver, By locator, String text){
        try {
            Select typeSelect = new Select(driver.findElement(locator));
            typeSelect.selectByVisibleText(text);
        }catch (Throwable we){
            errorNoElementFound(driver, locator);
            throw we;
        }
    }

    public static Exception handleError(WebDriver driver, String codigo, String msg) throws Throwable {
        stepWarning(driver, msg);
        return new FrontEndException(StringUtils.trimToEmpty(codigo), msg);
    }

    protected static void sleep(int milisegundos) {
        Sleeper.Sleep(milisegundos);
    }

    protected static void stepPass(WebDriver driver, String descripcion) throws Throwable {
        try {
            ExtentReportUtil.INSTANCE.stepPass(driver, descripcion);
        } catch (Throwable t) {
            System.out.println(Arrays.toString(t.getStackTrace()));
            throw t;
        }
    }

    private static void stepWarning(WebDriver driver, String descripcion) throws Throwable {
        try {
            ExtentReportUtil.INSTANCE.stepWarning(driver, descripcion);
        } catch (Throwable t) {
            System.out.println(Arrays.toString(t.getStackTrace()));
            throw t;
        }
    }

    protected void stepFail(WebDriver driver, String descripcion) throws Throwable {
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

    public static void scroll(WebDriver driver, int x, int y) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(" + x + "," + y + ")", "");
        } catch (Throwable t) {
            System.out.println(Arrays.toString(t.getStackTrace()));
            throw t;
        }
    }

    public static void zoom(WebDriver driver, int size) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("document.body.style.zoom = '" + size + "%'");
        } catch (Throwable t) {
            System.out.println(Arrays.toString(t.getStackTrace()));
            throw t;
        }
    }

    private void errorNoElementFound(WebDriver driver, By locator){
        generateWord.sendText("Error : No se encontró el elemento : " + locator);
        generateWord.addImageToWord(driver);
        driver.close();
    }
    private void stepFailNoShoot(WebDriver driver,String descripcion) throws Throwable {
        try {
            ExtentReportUtil.INSTANCE.stepFailNoShoot(descripcion);
        } catch (Throwable t) {
            System.out.println(Arrays.toString(t.getStackTrace()));
            throw t;
        }
    }
    protected void waitUntil(WebDriver driver, int time, By locator){
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


}