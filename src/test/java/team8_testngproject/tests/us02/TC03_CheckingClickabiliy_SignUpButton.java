package team8_testngproject.tests.us02;

import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P02_RegisterPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;

import static team8_testngproject.utilities.ReusableMethods.waitFor;

public class TC03_CheckingClickabiliy_SignUpButton { ExtentTest extentTest = RaporlamaUtil.extentTest;
    private final String testName = "US02 || TC03- SIGN UP Butonuna Tıklanmalı ";
    private final String description = "SIGN UP butonuna tıklanilabilir olmali";
    private final String raporMesaji = "Kullanıcı başarılı bir şekilde kayıt olabilmeli";

    @Test (testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void SignUpWithAClick(){
        ExtentTest extentTest = RaporlamaUtil.extentTest;
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        Faker faker = new Faker();

        P01_HomePage homePage=new P01_HomePage();
        homePage.userRegisterButton.click();
        extentTest.info("Home page'den Register sayfasina gidildi.");

        P02_RegisterPage registerPage = new P02_RegisterPage();
        registerPage.userNameBox.sendKeys(faker.name().username());
        registerPage.e_mailBox.sendKeys(faker.internet().emailAddress());
        registerPage.userPasswordBox.sendKeys(faker.internet().password());
        registerPage.policyAgreementBox.click();
        registerPage.userSignUpButton.click();
        extentTest.info("SignUp butonun'un tiklanabilir olmasi test edilmistir.");

        Assert.assertTrue(homePage.homePageLogo.isDisplayed());

        waitFor(3);
        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:red; font-weight:bold; font-size: 16px'>BUG BULUNDU: &#x1F41E</span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
    }


}
