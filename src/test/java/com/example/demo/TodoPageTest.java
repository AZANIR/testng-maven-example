package com.example.demo;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TodoPageTest extends BaseTest {
    
    private TodoPage todoPage;
    private final String TODO_APP_URL = "https://todomvc.com/examples/vanillajs/";
    
    @BeforeMethod
    public void setUpPage() {
        todoPage = new TodoPage(driver);
        todoPage.navigateTo(TODO_APP_URL);
    }
    
    @Test
    public void testAddTodo() {
        // Добавляем задачу
        String todoText = "Купить молоко";
        todoPage.addTodo(todoText);
        
        // Проверяем, что задача добавлена
        List<WebElement> todoItems = todoPage.getTodoItems();
        Assert.assertEquals(todoItems.size(), 1, "Должна быть добавлена одна задача");
        Assert.assertEquals(todoPage.getTodoText(todoItems.get(0)), todoText, "Текст задачи должен совпадать");
    }
    
    @Test
    public void testToggleTodo() {
        // Добавляем задачу
        todoPage.addTodo("Задача для переключения");
        
        // Переключаем статус задачи
        todoPage.toggleTodo(0);
        
        // Проверяем, что задача отмечена как выполненная
        Assert.assertTrue(todoPage.isTodoCompleted(0), "Задача должна быть отмечена как выполненная");
    }
    
    @Test
    public void testDeleteTodo() {
        // Добавляем задачу
        todoPage.addTodo("Задача для удаления");
        
        // Проверяем, что задача добавлена
        Assert.assertEquals(todoPage.getTodoItems().size(), 1, "Должна быть добавлена одна задача");
        
        // Удаляем задачу
        todoPage.deleteTodo(0);
        
        // Проверяем, что задача удалена
        Assert.assertEquals(todoPage.getTodoItems().size(), 0, "Задача должна быть удалена");
    }
    
    @Test
    public void testMultipleTodos() {
        // Добавляем несколько задач
        todoPage.addTodo("Задача 1");
        todoPage.addTodo("Задача 2");
        todoPage.addTodo("Задача 3");
        
        // Проверяем, что все задачи добавлены
        List<WebElement> todoItems = todoPage.getTodoItems();
        Assert.assertEquals(todoItems.size(), 3, "Должно быть добавлено три задачи");
        
        // Отмечаем первую и третью задачи как выполненные
        todoPage.toggleTodo(0);
        todoPage.toggleTodo(2);
        
        // Проверяем статусы задач
        Assert.assertTrue(todoPage.isTodoCompleted(0), "Первая задача должна быть отмечена как выполненная");
        Assert.assertFalse(todoPage.isTodoCompleted(1), "Вторая задача не должна быть отмечена как выполненная");
        Assert.assertTrue(todoPage.isTodoCompleted(2), "Третья задача должна быть отмечена как выполненная");
        
        // Проверяем счетчик оставшихся задач
        Assert.assertEquals(todoPage.getRemainingCount(), 1, "Должна остаться одна невыполненная задача");
    }
} 