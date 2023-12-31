package com.home.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import com.home.factory.DriverFactory;
import com.home.pages.LoginPage;

public class LoginSteps {
    LoginPage loginPage = new LoginPage(DriverFactory.getPage());

    @Given("user navigates to {string}")
    public void navigateToUrl(String url) {
        loginPage.navigateToUrl(url);
    }

    @When("^user clicks on \"([^\"]*)\" icon in main page")
    public void clickOnIcon(String iconName) {
        loginPage.clickOnIcon(iconName);
    }
}
