package com.country.junit;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
@RunWith(SerenityRunner.class)
public class FirstAssignment {

	@Steps
	TestBase test;
	
	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI="http://restcountries.eu/rest/v1/name";
	}
	
	
@Title("This is first test")
	@Test
	public void VerifyResponse() {
	Response response = SerenityRest.given()
				.when()
				.get("/INDIA");
	System.out.println(response.asString());
				
			JsonPath json=response.jsonPath();
			List<String> list = json.get("altSpellings[1]");
			test.DataIsPresent(list, "Republic of India");
		
				
				
	}

@Title("This is second test")
@Test
public void VerifyCaptial() {
	Response response=SerenityRest.given()
			.when()
			.get("/norway");
			System.out.println(response.asString());
			JsonPath json=response.jsonPath();
			List<String> list = json.getList("capital");
			System.out.println(list);
			test.DataIsPresent(list, "Oslo");
			

}

}
