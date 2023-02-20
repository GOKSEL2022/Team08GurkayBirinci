package team8_testngproject.tests.us14;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.*;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.ReusableMethods;

import java.util.List;

public class TC04 { // Ürüne ait bir tane küçük (Gallery Images) resim eklendiğinde, bu resimden ürün sayfasında bir tane olmalı (FAIL)
    @Test
    public void tc01(){
        P01_HomePage homePage = new P01_HomePage();
        P03_LoginPage loginPage = new P03_LoginPage();
        P04_MyAccountPage myAccountPage = new P04_MyAccountPage();
        P16_VendorStoreManagerPage vendorStoreManagerPage = new P16_VendorStoreManagerPage();
        P18_VendorProductManagerPage vendorProductManagerPage = new P18_VendorProductManagerPage();

        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        homePage.signInGur.click();
        loginPage.userNameGur.sendKeys(ConfigReader.getProperty("usernameGur"));
        loginPage.passwordGur.sendKeys(ConfigReader.getProperty("passwordGur"));
        loginPage.signInButtonGur.click();

        homePage.signOutGur.click();
        myAccountPage.storeManagerGur.click();
        ReusableMethods.hover(vendorStoreManagerPage.productButtonGur);
        vendorStoreManagerPage.addNewButtonGur.click();

        vendorProductManagerPage.productTitleGur.sendKeys("Steteskop");
        vendorProductManagerPage.galleryImgGur.click();
        vendorProductManagerPage.mediaLibraryGur.click();
        vendorProductManagerPage.image1Gur.click();
        vendorProductManagerPage.addGalleryButtonGur.click();
        vendorProductManagerPage.featuredImgGur.click();
        vendorProductManagerPage.image2Gur.click();
        vendorProductManagerPage.selectButtonGur.click();
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", vendorProductManagerPage.categoryAccessoriesGur);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", vendorProductManagerPage.submitButtonGur);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", vendorProductManagerPage.viewButtonGur);

        ReusableMethods.switchToWindow(1);
        List<WebElement> imgElements = vendorProductManagerPage.galleryImgDivGur.findElements(By.tagName("img"));

        try {
            Assert.assertEquals(imgElements.size(), 1);
        } catch (AssertionError e) {
            System.out.println("Test failed: " + e.getMessage());
            throw e;
        } finally {
            Driver.closeDriver();
        }
    }
}