package com.example.demo;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.testomat.testng.annotations.TID;
import io.testomat.testng.annotations.Step;

import java.util.List;

public class TodoPageTest extends BaseTest {
    
    private TodoPage todoPage;
    private final String TODO_APP_URL = "https://todomvc.com/examples/react/dist/";
    
    @BeforeMethod
    public void setUpPage() {
        todoPage = new TodoPage(driver);
        todoPage.navigateTo(TODO_APP_URL);
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    @TID("T1")
    public void testAddTodo() {
        // Add a task
        String todoText = "Buy milk";
        addTodoStep(todoText);
        
        // Check that the task is added
        verifyTodoAdded(todoText);
    }
    
    @Step("Add todo item: {0}")
    private void addTodoStep(String todoText) {
        todoPage.addTodo(todoText);
    }
    
    @Step("Verify todo item was added with text: {0}")
    private void verifyTodoAdded(String todoText) {
        List<WebElement> todoItems = todoPage.getTodoItems();
        Assert.assertEquals(todoItems.size(), 1, "One task should be added");
        Assert.assertEquals(todoPage.getTodoText(todoItems.get(0)), todoText, "Task text should match");
    }
    
    @Test
    @TID("T2")
    public void testToggleTodo() {
        // Add a task
        String todoText = "Task for toggling";
        addTodoStep(todoText);
        
        // Toggle task status
        toggleTodoStep(0);
        
        // Check that the task is marked as completed
        verifyTodoCompleted(0);
    }
    
    @Step("Toggle todo item at index: {0}")
    private void toggleTodoStep(int index) {
        todoPage.toggleTodo(index);
    }
    
    @Step("Verify todo item at index {0} is completed")
    private void verifyTodoCompleted(int index) {
        Assert.assertTrue(todoPage.isTodoCompleted(index), "Task should be marked as completed");
    }
    
    @Test
    @TID("T3")
    public void testDeleteTodo() {
        // Add a task
        String todoText = "Task for deletion";
        addTodoStep(todoText);
        
        // Check that the task is added
        verifyTodoCount(1, "One task should be added");
        
        // Delete the task
        deleteTodoStep(0);
        
        // Check that the task is deleted
        verifyTodoCount(0, "Task should be deleted");
    }
    
    @Step("Delete todo item at index: {0}")
    private void deleteTodoStep(int index) {
        todoPage.deleteTodo(index);
    }
    
    @Step("Verify todo count is {0}: {1}")
    private void verifyTodoCount(int expectedCount, String message) {
        Assert.assertEquals(todoPage.getTodoItems().size(), expectedCount, message);
    }
    
    @Test
    @TID("T4")
    public void testMultipleTodos() {
        // Add multiple tasks
        addMultipleTodosStep();
        
        // Check that all tasks are added
        verifyMultipleTodosAdded();
        
        // Mark first and third tasks as completed
        toggleMultipleTodosStep();
        
        // Check task statuses
        verifyTodoStatuses();
        
        // Check remaining tasks counter
        verifyRemainingCount();
    }
    
    @Step("Add multiple todo items")
    private void addMultipleTodosStep() {
        todoPage.addTodo("Task 1");
        todoPage.addTodo("Task 2");
        todoPage.addTodo("Task 3");
    }
    
    @Step("Verify multiple todo items were added")
    private void verifyMultipleTodosAdded() {
        List<WebElement> todoItems = todoPage.getTodoItems();
        Assert.assertEquals(todoItems.size(), 3, "Three tasks should be added");
    }
    
    @Step("Toggle multiple todo items")
    private void toggleMultipleTodosStep() {
        todoPage.toggleTodo(0);
        todoPage.toggleTodo(2);
    }
    
    @Step("Verify todo item statuses")
    private void verifyTodoStatuses() {
        Assert.assertTrue(todoPage.isTodoCompleted(0), "First task should be marked as completed");
        Assert.assertFalse(todoPage.isTodoCompleted(1), "Second task should not be marked as completed");
        Assert.assertTrue(todoPage.isTodoCompleted(2), "Third task should be marked as completed");
    }
    
    @Step("Verify remaining count of uncompleted tasks")
    private void verifyRemainingCount() {
        Assert.assertEquals(todoPage.getRemainingCount(), 1, "One uncompleted task should remain");
    }
} 