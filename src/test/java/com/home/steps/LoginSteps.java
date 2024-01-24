package com.home.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import com.home.factory.DriverFactory;
import com.home.pages.LoginPage;

public class LoginSteps extends BaseStep{
    LoginPage loginPage = new LoginPage(DriverFactory.getPage());
    //StepContext stepContext = getStepContextThreadLocal();

    @Given("user navigates to url")
    public void navigateToUrl() {
        loginPage.navigateToBaseUrl();
    }

    @When("^user clicks on \"([^\"]*)\" icon in main page")
    public void clickOnIcon(String iconName) {
        loginPage.clickOnIcon(iconName);
    }

    @And("I store {string} value for future usage")
    public void iStoreValueForFutureUsage(String keyToStore) {
        getStepContextThreadLocal().storeValue(keyToStore, "12345");
    }

    @And("I want to print first value")
    public void iWantToPrintFirstValue() {
        String a = getStepContextThreadLocal().getStoredValue("olo");
        System.out.println(a);
    }

    @And("I also store {string} value for future usage")
    public void iAlsoStoreValueForFutureUsage(String keyToStore) {
        getStepContextThreadLocal().storeValue(keyToStore, "0987654321");
    }
}
