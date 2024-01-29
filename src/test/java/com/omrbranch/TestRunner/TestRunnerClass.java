package com.omrbranch.TestRunner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.omrbranch.report.JVMReport;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\Features", glue = "com\\omrbranch\\stepdefinition",dryRun = false,stepNotifications = true,
tags ="@Login or @State or @City or @AddAddress or @SearchProduct or @ChangeProfilePic", plugin = {"pretty","json:target\\jsonReport.json"} )
public class TestRunnerClass {	

//	"@Login","@State","@City",@AddAddress,@SearchProduct"

	@AfterClass
	public static void generateReport() {
	JVMReport.jvmRep("target\\jsonReport.json");
	}
	}

 