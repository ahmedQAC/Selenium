package com.qa.cucomberDemonstration;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\com\\qa\\cucomberDemonstration\\TeaTesting.feature")
public class TestRunner {

}
