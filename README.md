# TestNG Maven Example with Testomatio Reporter

This project demonstrates the integration of [Testomatio Reporter](https://github.com/testomatio/java-reporter) with TestNG tests.

## Project Description

This project is an example of test automation for a TODO List web application using the following technologies:

- Java 11
- Maven
- TestNG
- Selenium WebDriver
- WebDriverManager

## Project Structure

```
testng-maven-example/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── example/
│   │               └── demo/
│   │                   └── TodoPage.java
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── example/
│       │           └── demo/
│       │               ├── BaseTest.java
│       │               └── TodoPageTest.java
│       └── resources/
│           └── testng.xml
└── pom.xml
```

## Functionality

The project demonstrates test automation for the following TODO application features:

1. Adding a new task
2. Marking a task as completed
3. Deleting a task
4. Working with multiple tasks

## Prerequisites

- Java 11 or higher
- Maven
- Chrome browser
- Testomatio account and API key

## Setup

1. Clone this repository
2. Update the API key in `run_tests.sh` or `run_tests.bat` with your Testomatio API key
3. Update the `testomatio.properties` file in `src/test/resources` with your project details

## Running Tests

### On Linux/Mac:

```bash
chmod +x run_tests.sh
./run_tests.sh
```

### On Windows:

```bash
run_tests.bat
```

## Testomatio Integration

This project uses the following Testomatio features:

1. **Test Reporting**: All test results are reported to Testomatio platform
2. **Test Case Mapping**: Tests are mapped to Testomatio test cases using `@TID` annotations
3. **Step Reporting**: Test steps are reported using `@Step` annotations

## Configuration

The Testomatio configuration is stored in `src/test/resources/testomatio.properties`:

```properties
testomatio.host=https://beta.testomat.io
testomatio.project=testng-maven-example
testomatio.reporter.interval=2000
```

## Adding New Tests

When adding new tests:

1. Add the `@TID` annotation with a unique test ID
2. Break down the test into steps using the `@Step` annotation
3. Run the tests to see the results in Testomatio dashboard

## Troubleshooting

If you encounter issues with the Testomatio integration:

1. Verify your API key is correct
2. Check the `testomatio.properties` file for correct configuration
3. Ensure the TestListener is properly registered in the testng.xml file

## Requirements

- Java 11 or higher
- Maven 3.6.0 or higher
- Internet connection (for downloading browser drivers)

## Additional Information

Tests run in Chrome headless mode. To change browser settings, edit the `BaseTest.java` class.

## Future Development

Possible directions for expanding the project:

- Adding Allure reports
- Parallel test execution
- Adding support for other browsers
- Implementing the Page Object Model pattern for more complex applications
- Integration with CI/CD systems 