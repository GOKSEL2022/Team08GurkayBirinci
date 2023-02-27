package team8_testngproject.tests.us11;

import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P03_LoginPage;
import team8_testngproject.pages.P04_MyAccountPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;

public class TC04 {
        private final String testName = "US11 || TC04 adresses seçeneğini gör.";
        private final String description = "My Account Sayfasında adresses seçeneği görülmeli";
        private final String raporMesaji = "My Account sayfasında adresses değil, ADDRESSES şeklinde görülmektedir";
        @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
        public void test04() {
            ExtentTest extentTest = RaporlamaUtil.extentTest;
            Driver.getDriver().get(ConfigReader.getProperty("URL"));


            P01_HomePage p01_homePage = new P01_HomePage();
            p01_homePage.signIn_Es.click();

            P03_LoginPage p03_loginPage = new P03_LoginPage();
            p03_loginPage.userName_Es.sendKeys(ConfigReader.getProperty("vendorUserNameEs"));
            p03_loginPage.password_Es.sendKeys(ConfigReader.getProperty("vendorPasswordEs"));
            p03_loginPage.signInButon_Es.click();
            RaporlamaUtil.extentTestInfo("Login işlemi vendor olarak yapıldı.");
            p01_homePage.signOut_Es.click();


            P04_MyAccountPage p04_myAccountPage = new P04_MyAccountPage();


            Assert.assertEquals(p04_myAccountPage.adressesVendor_Es.getText(), "addresses");
            Driver.closeDriver();

            RaporlamaUtil.message = "<span style='color:red; font-weight:bold; font-size: 16px'>BUG BULUNDU: &#x1F41E</span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";


        }
    }

