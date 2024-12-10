package insiderCase.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BaseStep {
    protected WebDriver driver;
    private static final Logger logger = LogManager.getLogger(BaseStep.class);
    private WebDriverWait wait;

    public BaseStep(WebDriver webDriver) {
        this.driver = webDriver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goToUrl(String url) {
        driver.get(url);
        logger.info("Navigated to URL: " + url);
    }

    public void checkPageUrl(String url) {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, url, "Page Url Did Not Match!");
        logger.info("Page URL Verified: " + currentUrl);
    }

    public void checkPageTitle(String title) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, title, "Page Title Did Not Match!");
        logger.info("Page Title Verified: " + actualTitle);
    }

    private WebElement waitForElement(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void scrollToElement(By by) {
        WebElement element = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void hoverOverElement(By by) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(by);
        actions.moveToElement(element).perform();
        logger.info("Mouse moved over element: " + by.toString());
    }

    public void clickElement(By by) {
        checkElementVisibility(by);
        WebElement element = waitForElement(by);
        element.click();
        logger.info("Element Clicked: " + by);
    }

    public boolean checkElementVisibility(By by) {
        try {
            waitForElement(by);
            logger.info("Element is visible: " + by);
            return true;
        } catch (Exception e) {
            logger.warn("Element Is Not Visible: " + by, e);
            return false;
        }
    }

    public void checkElementText(By by, String text) {
        scrollToElement(by);
        List<WebElement> elements = driver.findElements(by);
        Assert.assertTrue(elements.size() > 0, "No Elements Found!");

        for (WebElement element : elements) {
            String actualText = element.getText().replace("\n", " ");
            Assert.assertEquals(actualText, text, "Element text did not match! Found: " + actualText);
            logger.info("Element text: " + actualText);
        }
    }

    public void checkMultipleElementsText(By by, String... expectedTexts) {
        checkElementVisibility(by);
        List<WebElement> elements = driver.findElements(by);
        Assert.assertTrue(elements.size() > 0, "No elements found with selector: " + by);

        for (WebElement element : elements) {
            String actualText = element.getText();
            boolean isTextMatch = false;

            for (String expectedText : expectedTexts) {
                if (actualText.contains(expectedText)) {
                    isTextMatch = true;
                    break;
                }
            }
            Assert.assertTrue(isTextMatch, "Text did not match for element: " + element + " | Found: " + actualText);
            logger.info("Element text verified: " + actualText);
        }
    }

    public void findAndClickItem(By by, By item, int maxTry) {
        scrollToElement(by);
        for (int i = 0; i < maxTry; i++) {
            WebElement element = waitForElement(by);
            element.click();
            logger.info("Filter Clicked: " + by);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            List<WebElement> targets = driver.findElements(item);
            if (!targets.isEmpty()) {
                targets.get(0).click();
                logger.info("Item Clicked " + item);
                return;
            }
            logger.warn("Item Not Found, Retrying......");
        }
        Assert.fail("Item Not Found, (" + item + "), Maximum Number Of Attempts Reached");
    }

    public void checkNewRedirectedPage(String expectedUrl) {
        Set<String> windowHandles = driver.getWindowHandles();
        boolean isTabFound = false;

        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
            logger.info("Switched to window: " + handle);

            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains(expectedUrl)) {
                logger.info("Found the tab with URL: " + expectedUrl);
                isTabFound = true;
                break;
            }
        }
        Assert.assertTrue(isTabFound, "No tab with the URL: " + expectedUrl);
    }
}