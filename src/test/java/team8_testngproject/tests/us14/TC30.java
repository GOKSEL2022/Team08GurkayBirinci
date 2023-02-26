package team8_testngproject.tests.us14;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.*;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;
import team8_testngproject.utilities.ReusableMethods;

public class TC30 { // Catalog visibility; Hidden olarak seçilediğinde ürüne arama motorundan ulaşılamamalı (FAIL)
    private final String testName = "US14 || TC30-Catalog Visibility";
    private final String description = "Catalog visibility; Hidden olarak seçilediğinde ürüne arama motorundan ulaşılamamalı";
    private final String raporMesaji = "Hidden seçeneği seçildiğinde, ürüne arama motorundan ulaşılabilmektedir. " +
            "Halbuki ürüne hiçbir şekilde ulaşılamaması gerekir.";
    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
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
        RaporlamaUtil.extentTestInfo("Login işlemi yapıldı.");

        homePage.signOutGur.click();
        myAccountPage.storeManagerGur.click();
        ReusableMethods.hover(vendorStoreManagerPage.productButtonGur);
        vendorStoreManagerPage.productAddNewButtonGur.click();
        RaporlamaUtil.extentTestInfo("Product Manager sayfasına girildi.");

        vendorProductManagerPage.productTitleGur.sendKeys("Steteskop");
        vendorProductManagerPage.galleryImgGur.click();
        vendorProductManagerPage.mediaLibraryGur.click();
        vendorProductManagerPage.image1Gur.click();
        vendorProductManagerPage.addGalleryButtonGur.click();
        vendorProductManagerPage.featuredImgGur.click();
        vendorProductManagerPage.image2Gur.click();
        vendorProductManagerPage.selectButtonGur.click();
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", vendorProductManagerPage.categoryAccessoriesGur);
        Select select = new Select(vendorProductManagerPage.catalogSelectGur);
        select.selectByIndex(3);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", vendorProductManagerPage.submitButtonGur);
        vendorProductManagerPage.searchBoxGur.sendKeys("Steteskop");
        RaporlamaUtil.extentTestInfo("Catalog visibility; Hidden olarak seçilediğinde ürüne arama motorundan ulaşılıp ulaşılamadığı kontrol edilmiştir.");

        try{
            Assert.assertFalse(vendorProductManagerPage.liveSearchAreaGur.isDisplayed());
        }catch (AssertionError e){
            throw e;
        } finally {
            RaporlamaUtil.message = "<span style='color:red; font-weight:bold; font-size: 16px'>BUG BULUNDU: &#x1F41E</span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
        }
    }
}
