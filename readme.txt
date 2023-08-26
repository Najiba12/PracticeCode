
Pre Req Steps
1: Make sure you have Maven and Selenium WebDriver installed on your system.
2: Create a new Maven project and add the relevant dependencies to the pom.xml file:



Command to run the Test Cases
1: Run the feature via tags
   mvn test -Dcucumber.filter.tags="@AccMenu" -Dheadless=false

2: Run The feature via tags with Headless mode
   mvn test -Dcucumber.filter.tags="@AccMenu" -Dheadless=true

3: Run The feature via tags with Headless mode
   mvn test -Dheadless=true


How resolve the jdk environment Error

1: Download and install the latest version of JDK from the Oracle website or another source.

2: Set the JAVA_HOME environment variable by running the command set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_281 in a command prompt or shell.

3: Run the command set PATH=%PATH%;C:\Program Files\Java\jdk-version\bin in a command prompt or shell.

4: Verify that the JDK is properly installed by running the command java -version.