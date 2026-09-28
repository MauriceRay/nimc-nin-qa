package com.seamfix.nimc;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Representative Appium automation for the citizen NIN retrieval flow.
   * Sandbox only — stubbed OTP, test NIN.
   */
public class NinRetrievalTest {

    private AndroidDriver driver;
      private WebDriverWait wait;

    @BeforeEach
      void setUp() throws MalformedURLException {
                UiAutomator2Options options = new UiAutomator2Options()
                                  .setPlatformName("Android")
                                  .setDeviceName("emulator-5554")
                                  .setAppPackage("gov.ng.nimc.mws")
                                  .setAppActivity("gov.ng.nimc.ui.SplashActivity");
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
                wait = new WebDriverWait(driver, Duration.ofSeconds(20));
      }

    @Test
      void retrieveNin_withRegisteredPhone_shows11DigitNin() {
                driver.findElement(By.id("gov.ng.nimc.mws:id/retrieve_nin")).click();
                driver.findElement(By.id("gov.ng.nimc.mws:id/phone"))
                                  .sendKeys("08012345678");
                driver.findElement(By.id("gov.ng.nimc.mws:id/get_otp")).click();

          String otp = wait.until(ExpectedConditions.visibilityOfElementLocated(
                            By.id("gov.ng.nimc.mws:id/otp_box"))).getText();
                assertEquals(6, otp.length());

          String nin = wait.until(ExpectedConditions.visibilityOfElementLocated(
                            By.id("gov.ng.nimc.mws:id/nin_display"))).getText();
                assertTrue(nin.matches("\\d{11}"), "Retrieved NIN must be exactly 11 digits");
      }

    @Test
      void unregisteredPhone_showsNoRecordError() {
                driver.findElement(By.id("gov.ng.nimc.mws:id/retrieve_nin")).click();
                driver.findElement(By.id("gov.ng.nimc.mws:id/phone"))
                                  .sendKeys("09000000000");
                driver.findElement(By.id("gov.ng.nimc.mws:id/get_otp")).click();

          assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(
                            By.id("gov.ng.nimc.mws:id/no_record"))).isDisplayed());
      }

    @AfterEach
      void tearDown() {
                if (driver != null) driver.quit();
      }
}
