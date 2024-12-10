package insiderCase.tests;

import insiderCase.base.BaseTest;
import insiderCase.page.CareerPage;
import insiderCase.page.HomePage;
import org.testng.annotations.*;

public class InsiderTestCase extends BaseTest {
    @BeforeMethod
    public void initializePages() {
        homePage = new HomePage(driver);
        careerPage = new CareerPage(driver);
    }

    @Test
    public void checking_The_Details_Of_Job_Postings_On_Insider() {
        homePage.checkIfTheHomePageIsOpened();
        homePage.clickCompanyAndCareer();
        careerPage.checkIfTheCareerPageIsOpened();
        careerPage.checkTeamsBlock();
        careerPage.checkLocaitonBlock();
        careerPage.checkLifeInInsider();
        careerPage.goToOpenPositionPages();
        careerPage.filterPositionAndLocation();
        careerPage.checkJobsDetail();
        careerPage.clickViewButtonAndCheckApplicationPage();
    }
}