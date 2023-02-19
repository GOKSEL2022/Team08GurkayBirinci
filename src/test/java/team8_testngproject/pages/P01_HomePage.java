package team8_testngproject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team8_testngproject.utilities.Driver;

public class P01_HomePage {
    public P01_HomePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }








    // 20.Satır --> Ali





























    // 50.Satır --> Esra





























    // 80.Satır --> Gonca





























    // 110.Satır --> Gürkay
    @FindBy(xpath = "//*[text()='Sign In']") public WebElement signInGur;
    @FindBy(xpath = "//*[text()='Sign Out']") public WebElement signOutGur;



























    // 140.Satır --> Hüseyin





























    // 170.Satır --> Mehmet





























    // 200.Satır --> Meryem
@FindBy(css = "a[class='register inline-type'")
    public WebElement userRegisterButton;
@FindBy(xpath = "(//a[@class='logo'])[1]")
public WebElement homePageLogo;

















    
    






    // 230.Satır --> Zeliha
    @FindBy(xpath = "//*[text()='Register']")
    public WebElement registerButonZb;



























    // 260.Satır --> Nurullah





























    // 290.Satır --> Ramazan





























    // 320.Satır --> Sevda





























    // 350.Satır --> Mustafa





























}
