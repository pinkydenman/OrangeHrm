# OrangeHrm Test Automation
The project is for automation of UI tests for the OrangeHrm application.

## Tech Stack
- Java 21
- Gradle
- Cucumber
- JUnit 5
- Microsoft Playwright
- PicoContainer for dependency injection

## Project Structure
- `src/test/java`: Contains the test code.
- `features`: Contains the Cucumber feature files.

## Test framework
### Page Object Model
- `src/test/java/pages`: Contains the page object classes.
- `src/test/java/stepdefs`: Contains the step definition classes.
### Context and Hook
Shared test setup is handled in:
- `Hooks.java` manages Playwright setup and teardown.
- `TestContext.java` stores scenario-specific objects such as the Playwright `Page`.

## Setup
- Install Java 21.
- Install Gradle.
- Clone the repository from Github: `git clone https://github.com/pinkydenman/OrangeHrm.git`.


## Run the tests
- Navigate to the project directory.
- Run `gradlew test`.

## Test report
- The test report is generated in the `build/reports/cucumber-html-reports` directory.

