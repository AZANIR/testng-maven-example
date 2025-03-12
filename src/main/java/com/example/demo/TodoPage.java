package com.example.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TodoPage {
    
    private final WebDriver driver;
    private final WebDriverWait wait;
    
    // Локаторы
    private final By newTodoInput = By.cssSelector(".new-todo");
    private final By todoItems = By.cssSelector(".todo-list li");
    private final By todoItemLabel = By.cssSelector("label");
    private final By todoItemToggle = By.cssSelector(".toggle");
    private final By todoItemDeleteButton = By.cssSelector(".destroy");
    private final By clearCompletedButton = By.cssSelector(".clear-completed");
    private final By todoCount = By.cssSelector(".todo-count");
    
    public TodoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    public void navigateTo(String url) {
        driver.get(url);
    }
    
    public void addTodo(String todoText) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(newTodoInput));
        input.sendKeys(todoText + "\n");
    }
    
    public List<WebElement> getTodoItems() {
        return driver.findElements(todoItems);
    }
    
    public String getTodoText(WebElement todoItem) {
        return todoItem.findElement(todoItemLabel).getText();
    }
    
    public void toggleTodo(int index) {
        List<WebElement> items = getTodoItems();
        if (index < items.size()) {
            items.get(index).findElement(todoItemToggle).click();
        }
    }
    
    public void deleteTodo(int index) {
        List<WebElement> items = getTodoItems();
        if (index < items.size()) {
            WebElement item = items.get(index);
            // Наведение мыши для отображения кнопки удаления
            item.findElement(todoItemDeleteButton).click();
        }
    }
    
    public void clearCompleted() {
        WebElement clearButton = wait.until(ExpectedConditions.visibilityOfElementLocated(clearCompletedButton));
        clearButton.click();
    }
    
    public int getRemainingCount() {
        String countText = driver.findElement(todoCount).getText();
        return Integer.parseInt(countText.replaceAll("[^0-9]", ""));
    }
    
    public boolean isTodoCompleted(int index) {
        List<WebElement> items = getTodoItems();
        if (index < items.size()) {
            return items.get(index).getAttribute("class").contains("completed");
        }
        return false;
    }
} 