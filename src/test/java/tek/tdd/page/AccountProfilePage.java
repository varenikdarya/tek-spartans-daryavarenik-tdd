package tek.tdd.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utility.SeleniumUtility;

public class AccountProfilePage extends SeleniumUtility {

    public AccountProfilePage() {
            PageFactory.initElements(getDriver(), this);
        }

        @FindBy(className = "account__information-email")
        public WebElement accountEmailInfo;

    @FindBy(id = "nameInput")
    public WebElement nameInput;

    @FindBy(id = "personalPhoneInput")
    public WebElement personalPhoneInput;

    @FindBy(id = "personalUpdateBtn")
    public WebElement personalUpdateBtn;

    @FindBy(className = "account__information-username")
    public WebElement accountUserNameText;

    public void updateNameAndPhone(String name, String phone) {
        sendText(nameInput, name);
        sendText(personalPhoneInput, phone);

        clickOnElement(personalUpdateBtn);
    }
}
