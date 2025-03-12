@echo off
REM Скрипт для запуска тестов с Testomatio Reporter в Windows

REM Установка API ключа Testomatio
REM Замените YOUR_API_KEY на ваш реальный API ключ
set TESTOMATIO_API_KEY=YOUR_API_KEY

REM Запуск тестов с Maven
call mvn clean test

REM Вывод сообщения о завершении
echo Tests completed. Results reported to Testomatio. 