package insiderCase.page;

import insiderCase.base.BaseStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseStep {

    public static final By COMPANY_LIST = By.xpath("(//a[@id='navbarDropdownMenuLink'])[5]");
    public static final By CAREER_BUTTON = By.cssSelector("a.dropdown-sub[href='https://useinsider.com/careers/']");
    public static final By HOMEPAGE_TITLE_TEXT = By.xpath("//div[@id='desktop_hero_24']//h1");
    public static final By HOMEPAGE_PARAGRAPH_TEXT = By.cssSelector("div[class='col-9'] p");
    public static final By HOMEPAGE_DEMO_BUTTON = By.xpath("(//a[@class='btn btn-outline-main btn-navy rounded align-self-center mt-3'])[1]");
    public static final By HOMEPAGE_PLATFORM_BUTTON = By.xpath("div[class='col-9'] a[class='btn btn-navy btn-teal rounded align-self-center mt-3']");
    //--//
    public static final String HOMEPAGE_TITLE = "#1 Leader in Individualized, Cross-Channel CX — Insider";
    public static final String URL = "https://useinsider.com/";
    public static final String HOMEPAGE_TITLE_TEXT_DESC = "#1 AI-native Omnichannel Experience and Customer Engagement Platform";
    public static final String HOMEPAGE_PARAGRAPH_TEXT_DESC = "The end-to-end platform with an integrated CDP to fuel journey orchestration across the widest set of channels to deliver experiences as unique as each customer – with the fastest ROI, higher efficiency, and better results.";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void checkIfTheHomePageIsOpened() {
        checkPageUrl(URL);
        checkPageTitle(HOMEPAGE_TITLE);
        checkElementText(HOMEPAGE_TITLE_TEXT, HOMEPAGE_TITLE_TEXT_DESC);
        checkElementText(HOMEPAGE_PARAGRAPH_TEXT, HOMEPAGE_PARAGRAPH_TEXT_DESC);
        checkElementVisibility(HOMEPAGE_DEMO_BUTTON);
        checkElementVisibility(HOMEPAGE_PLATFORM_BUTTON);
    }

    public void clickCompanyAndCareer() {
        clickElement(COMPANY_LIST);
        clickElement(CAREER_BUTTON);

    }
}