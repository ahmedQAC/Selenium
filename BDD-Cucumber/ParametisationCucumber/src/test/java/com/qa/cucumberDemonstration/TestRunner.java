package com.qa.cucumberDemonstration;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\com\\qa\\cucumberDemonstration\\Parametisation.feature")
public class TestRunner {

}
