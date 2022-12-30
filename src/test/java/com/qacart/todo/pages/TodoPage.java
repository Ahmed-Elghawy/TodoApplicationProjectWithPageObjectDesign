package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodoPage extends BasePage {

    public TodoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-testid=\"welcome\"]")
    private WebElement welcomeMessage;

    @FindBy(css = "[data-testid=\"add\"]")
    private WebElement addButton;

    @FindBy(css = "[data-testid=\"todo-item\"]")
    private WebElement todoItem;

    @FindBy(xpath = ("//*[@data-testid = 'delete']"))
    private WebElement deleteButton;

    @FindBy(css = "[data-testid=\"no-todos\"]")
    private WebElement noTodosMessage;


    @Step("Load the login page")
    public TodoPage load (){
        driver.get(ConfigUtils.getInstance().getBaseUrl() + EndPoint.TODO_PAGE_ENDPOINT);
        return this;
    }

    @Step("Check the welcome Message")
    public boolean isWelcomeMessageDisplayed() {
        return welcomeMessage.isDisplayed();
    }


    @Step("Add new todo with click on plus Button")
    public NewTodoPage clickOnPlusButton() {
        addButton.click();
        return new NewTodoPage(driver);
    }

    @Step("Get todo Text")
    public String getTodoText() {
        return todoItem.getText();
    }

    @Step("Delete a todo with click on delete Button")
    public TodoPage ClickOnDeleteButton() {
        deleteButton.click();
        return this;
    }

    @Step("Check if is not todos Message Displayed")
    public boolean isNoTodosMessageDisplayed() {
        return noTodosMessage.isDisplayed();
    }
}