package com.visionit.automation.runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="classpath:features/HealthCheck.feature",
        glue="com.visionit.automation.stepdefs", 
        tags="",
        plugin = {"pretty",
                  "html:target/html/htmlreport.html",
                  "json:target/json/file.json"
                 },
        publish=true,
        //monochrome=true,
        dryRun=false 
        )
public class TestRunner {
	
}
