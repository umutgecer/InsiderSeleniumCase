package insiderCase.page;

import insiderCase.base.BaseStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CareerPage extends BaseStep {

    public static final By PAGE_TOP_TITLE = By.cssSelector(".big-title.big-title-media.mt-4.mt-lg-0");
    public static final By OUR_STORY_TEXT = By.xpath("//div[@data-id='9917b32']//p");
    public static final By OUR_STORY_DIV = By.xpath("(//div[@class='elementor-widget-wrap elementor-element-populated'])[2]");
    public static final By TEAM_TITLE_DIV = By.cssSelector("section[id='career-find-our-calling']");
    public static final By TEAM_TITLE = By.xpath("(//h3[@class='category-title-media'])[1]");
    public static final By TEAM_SEE_ALL_BUTTON = By.xpath("//a[normalize-space()='See all teams']");
    public static final By LOCATIONS_DIV = By.xpath("//div[@class='col-12 d-flex flex-wrap']");
    public static final By LOCATIONS_TITLE = By.cssSelector(".category-title-media.ml-0");
    public static final By LOCATIONS_TEXT = By.cssSelector(".mt-5.mb-0.mt-lg-0.mx-auto.pl-0");
    public static final By LIFE_INSIDER_DIV = By.xpath("//section[@data-id='a8e7b90']");
    public static final By LIFE_INSIDER_TITLE = By.xpath("//h2[normalize-space()='Life at Insider']");
    public static final By LIFE_INSIDER_TEXT = By.xpath("//div[@data-id='fe38935']//p");
    public static final By CAREER_PAGE_SEE_ALL_QA_JOBS_BUTTON = By.xpath("//a[normalize-space()='See all QA jobs']");
    public static final By ISTANBUL_LOCATION_OPTION = By.xpath("//ul[@id='select2-filter-by-location-results']//li[2]");
    public static final By COOKIES_ACEPPT_BUTTON = By.xpath("//a[@id='wt-cli-accept-all-btn']");
    public static final By LOCATION_DROPDOWN_ARROW = By.xpath("(//span[@class='select2-selection__arrow'])[1]");
    public static final By DEPARTMENT_DROPDOWN_ARROW = By.xpath("(//span[@class='select2-selection__arrow'])[2]");
    public static final By OPEN_POSITIONS_PAGE_TITLE = By.cssSelector(".mb-2");
    public static final By OPEN_POSITIONS_PAGE_TEXT = By.cssSelector(".text-dark");
    public static final By RESULT_CONTAINER = By.xpath("//p[@id='resultCounter']");
    public static final By QA_DEPARTMENT_OPTION = By.xpath("//ul[@id='select2-filter-by-department-results']//li[14]");
    public static final By POSITION_DEPARTMENT = By.xpath("//div[@id='jobs-list']//span");
    public static final By POSITION_LOCATION = By.xpath("//div[@class='position-location text-large']");
    public static final By POSITION_TITLE = By.xpath("//div[@id='jobs-list']//p");
    public static final By VIEW_ROLE_BUTTON = By.xpath("(//div[@id='jobs-list']//a)[2]");
    public static final By LEVER_JOB_TITLE = By.cssSelector("div[class='posting-headline'] h2");
    public static final By JOB_FRAME_DIV = By.xpath("(//div[@class='position-list-item-wrapper bg-light'])[2]");
    public static final By PAGINATION_DIV = By.cssSelector("#pagination");
    //--//
    public static final String URL = "https://useinsider.com/careers/";
    public static final String PAGE_TITLE = "Ready to disrupt? | Insider Careers";
    public static final String TOP_TITLE_DESC = "Ready to disrupt?";
    public static final String OUR_STORY_TEXT_DESC = "We empower storytellers to build deeper connections and bring brands and people closer together through experiences. From six desks to 800+ team members across 41 nationalities — we’re making more than a splash in the tech industry—we’re creating a new wave of experience disruption and a community of doers, thinkers, and makers who go where others only dream. Become one of us.";
    public static final String TEAM_TEXT_DESC = "Find your calling";
    public static final String OUR_TEAM_TITLE_TEXT = "Our Locations";
    public static final String OUR_TEAM_TITLE_TEXT_DESC = "25 offices across 5 continents, home to 600+ Insiders";
    public static final String LIFE_INSIDER_TITLE_DESC = "Life at Insider";
    public static final String LIFE_INSIDER_TEXT_DESC = "We’re here to grow and drive growth—as none of us did before. Together, we’re building a culture that inspires us to create our life’s work—and creates a bold(er) impact. We know that we’re smarter as a group than we are alone. Become one of us if you dare to play bigger.";
    public static final String CAREER_QA_URL = "https://useinsider.com/careers/quality-assurance/";
    public static final String OPEN_POSITIONS_PAGE_TITLE_TEXT = "All open positions";
    public static final String OPEN_POSITIONS_PAGE_TEXT_DESC = "Ready to disrupt? Explore career opportunities at Insider.";
    public static final String QA_TEXT = "Quality Assurance";
    public static final String LOCATION_INFO_TEXT = "Istanbul, Turkey";
    public static final String QA_DEPAMRTENT_TEXT = "Software QA";
    public static final String JOB_TTTLE_TEXT = "Software Quality Assurance";
    public static final String JOB_TTTLE_TEXT2 = "Software QA Tester";
    public static final String APPLICATION_PAGE = "https://jobs.lever.co/useinsider";

    public CareerPage(WebDriver driver) {
        super(driver);
    }

    public void checkIfTheCareerPageIsOpened() {
        checkPageUrl(URL);

        clickElement(COOKIES_ACEPPT_BUTTON);

        checkPageTitle(PAGE_TITLE);
        checkElementText(PAGE_TOP_TITLE, TOP_TITLE_DESC);

        checkElementVisibility(OUR_STORY_DIV);
        checkElementText(OUR_STORY_TEXT, OUR_STORY_TEXT_DESC);
    }

    public void checkTeamsBlock() {
        checkElementVisibility(TEAM_TITLE_DIV);
        checkElementText(TEAM_TITLE, TEAM_TEXT_DESC);
        checkElementVisibility(TEAM_SEE_ALL_BUTTON);
    }

    public void checkLocaitonBlock() {
        checkElementVisibility(LOCATIONS_DIV);
        checkElementText(LOCATIONS_TITLE, OUR_TEAM_TITLE_TEXT);
        checkElementText(LOCATIONS_TEXT, OUR_TEAM_TITLE_TEXT_DESC);
    }

    public void checkLifeInInsider() {
        checkElementVisibility(LIFE_INSIDER_DIV);
        checkElementText(LIFE_INSIDER_TITLE, LIFE_INSIDER_TITLE_DESC);
        checkElementText(LIFE_INSIDER_TEXT, LIFE_INSIDER_TEXT_DESC);
    }

    public void goToOpenPositionPages() {
        goToUrl(CAREER_QA_URL);
        clickElement(CAREER_PAGE_SEE_ALL_QA_JOBS_BUTTON);
        checkElementVisibility(OPEN_POSITIONS_PAGE_TITLE);
    }

    public void filterPositionAndLocation() {
        findAndClickItem(DEPARTMENT_DROPDOWN_ARROW, QA_DEPARTMENT_OPTION, 20);
        findAndClickItem(LOCATION_DROPDOWN_ARROW, ISTANBUL_LOCATION_OPTION, 20);

        checkElementText(OPEN_POSITIONS_PAGE_TITLE, OPEN_POSITIONS_PAGE_TITLE_TEXT);
        checkElementText(OPEN_POSITIONS_PAGE_TEXT, OPEN_POSITIONS_PAGE_TEXT_DESC);

        checkElementVisibility(RESULT_CONTAINER);
    }

    public void checkJobsDetail() {
        checkElementVisibility(POSITION_DEPARTMENT);
        hoverOverElement(PAGINATION_DIV);
        checkElementText(POSITION_DEPARTMENT, QA_TEXT);
        checkElementText(POSITION_LOCATION, LOCATION_INFO_TEXT);
        checkMultipleElementsText(POSITION_TITLE, QA_DEPAMRTENT_TEXT, QA_TEXT);
    }

    public void clickViewButtonAndCheckApplicationPage() {
        hoverOverElement(JOB_FRAME_DIV);
        clickElement(VIEW_ROLE_BUTTON);
        checkNewRedirectedPage(APPLICATION_PAGE);
        checkMultipleElementsText(LEVER_JOB_TITLE, JOB_TTTLE_TEXT, JOB_TTTLE_TEXT2);
    }
}