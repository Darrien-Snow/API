package com.omrbranch.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;

public class JVMReport {
	
	public static void jvmRep(String inputJsonReport) {
	
		File outputFile = new File("target"); 
		Configuration configuration = new Configuration(outputFile ,"JVM Report");
		configuration.addClassifications("Browser", "Chrome");		
		configuration.addClassifications("Project", "OMR Branch API Automation");
		configuration.addClassifications("Browser", "Chrome");
		
		List<String> jsonfiles = new ArrayList<>();
		jsonfiles.add(inputJsonReport);

		
		ReportBuilder reportBuilder = new ReportBuilder(jsonfiles, configuration);
		Reportable generateReports = reportBuilder.generateReports();
		System.out.println(generateReports);
		
	}

}
