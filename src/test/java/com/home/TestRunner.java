package com.home;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"steps", "hooks"},
        plugin = {"pretty",
                  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                  "rerun:target/rerun.txt"
        }
)

public class TestRunner {
}
