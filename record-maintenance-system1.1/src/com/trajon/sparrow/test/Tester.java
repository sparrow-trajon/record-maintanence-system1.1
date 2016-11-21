package com.trajon.sparrow.test;

import com.trajon.sparrow.controller.Controller;

public class Tester {

	private static final String sourceFile="Source.CSV";
	private static final String destinationFile="Destination.CSV";

	public static void main(String[] args)
	{
		Controller controller= new Controller();
		controller.saveRawData(sourceFile);
		controller.saveNonDuplocateData(sourceFile, destinationFile);	
	}	

}
