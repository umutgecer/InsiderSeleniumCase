## Insider Selenium Case

The project includes checking the homepage and career pages on https://useinsider.com, searching for a QA job posting,
and going to the application form for the job posting.

### Proje Description

* `Java Version: 11`
* `Test Framework: TestNG`

The main test methods are in the **_BaseStep_** area under the [**Base**](src/main/java/base) package,
and the pages where these methods are called and cases are created are the pages under pages.
The `TestCase` methods in the **_[test/test](src/test/java/TestCases)_** class are called and the tests
are run and reported by TestNG.

### The test scenario run in the project

    1.Go to the website https://useinsider.com and check the homepage opened.
    2.Check the "Company" section, click it, and then click 'Career' from the dropdown list.
    3.Check that the "Career" page has the "Teams," "Location," and "Life In Insider" sections opened.
    4.Go to https://useinsider.com/careers/quality-assurance/ and click on the '“See all QA jobs' button on the opened page.
    5.Check that all jobs’ Position contains “Quality Assurance”, Department contains “Quality Assurance”, and Location contains “Istanbul, Turkey”
    6.Verify the job listings by checking the titles, locations, and departments.
    7.Click the "View" button for a job listing and check if it redirects to the application page, then end the test.