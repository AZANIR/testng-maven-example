@echo off
REM Script for running tests with Testomatio Reporter in Windows

REM Setting up Testomatio API key (optional)
REM If you have a real Testomatio API key, uncomment the following line and replace YOUR_API_KEY with your key
REM set TESTOMATIO_API_KEY=YOUR_API_KEY

REM Running tests with Maven
call mvn clean test

REM Output completion message
echo Tests completed. Results reported to console. 