Entrata Application
Automation TestScripts to Validate Functional test Cases

Overview
This project is designed for web application automation testing using Selenium WebDriver with Java for Website Entrata.com. It includes test cases for various functionalities, such as navigation, form interaction, and validation of dynamic content, End To End TestCase. The tests are structured using Hybrid Automation Framework (Java, Selenium, TestNG, Maven & Page Object Model facilitating efficient and organized test execution.
 
Pre-Requisites --
1. Java Development Kit (JDK): Make sure JDK 17 installed, the Compiler Version is 17. Eclipse Editor Version -- eclipse-java-2023-12-R-win32-x86_64
Eclipse Version 2023-12
2. Maven: This project uses Maven for dependency management and build automation.
3. The project requires a compatible WebDriver for the target browser (e.g., ChromeDriver for Chrome, FireFox).

Development of Hybrid Driven Framework   ---- 
1) Test case: Account Registration

1.1:  Create Page Object Classes for HomePage, CarrierPage, SignIn Page, Utilities Page under pageObjects package Which Includes Local WebDriver Instance, Constructor, WebElements and   Action Methods of Web Elements .
1.2: Create TestCases under "testCases Package"
1.3: Create BaseClass under testBase package which includes setup() Method, teardown() Method and re-usable methods.
1.4: Create re-usable methods to generate random numbers and strings in BaseClass. 

2) Adding logs to test case (log4j2)
2.1: Add log4j2.xml file under src/test/resourses.
2.2: Update BaseClass.
2.3: Add log statements to TestCases. 

3) Run Tests on Desired Browser/Cross Browser/Parallel 

3.1: Create testng.xml file to Run Test Cases and parameterize browser to BaseClass →setup() method. 
3.2: Update BaseClass →setup() method, launch browser based on conditions. 
3.3: Maintain separate xml to run tests multiple browsers parallelly.
 
4) Read Common values from config.properties file.
4.1: Add config.properties file under src/test/resoures.
4.2: Update BaseClass →setup() method, add script to load config.properties file. 
4.3: Replace hard coded values in Test Cases like url, username, password etc... 

5) Test Case 
5.1: Create and update page object classes. HomePage, CarrierPage, SignInPage, UtilitiesPage – – update by adding login link element 
5.2: Create TestCases for those PageObject Classes in TestCases Package  
5.3: Add entry testng.xml 

6) Add Extent Reports to Project 
6.1: Create ExtentReportUtility utility class under utilities package. 
6.2: Add captureScreen() method in BaseClass 
6.3: Add ExtentReportUtility (Listener class) entry in testng.xml file. 
6.4: Make sure WebDriver is static in BaseClass, we refer same driver instance in ExtentReportUtility. 

7) Run Tests using Maven pom.xml . 
