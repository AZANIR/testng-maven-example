#!/bin/bash

# Скрипт для запуска тестов с Testomatio Reporter

# Установка API ключа Testomatio
# Замените YOUR_API_KEY на ваш реальный API ключ
export TESTOMATIO_API_KEY="YOUR_API_KEY"

# Запуск тестов с Maven
mvn clean test

# Вывод сообщения о завершении
echo "Tests completed. Results reported to Testomatio." 