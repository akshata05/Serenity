package com.country.junit;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.user.model.UserClass;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
@RunWith(SerenityRunner.class)
public class ThirdAssignment {
	@Steps
	TestBase test;
	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI="https://reqres.in/api/users";
	}
	@Title("This is to add user name and job")
	@Test
	public void CreateUser() {
		UserClass user =new UserClass();
		user.setName("John");
		user.setJob("Software Engineer");
		
		SerenityRest.given()
		.contentType(ContentType.JSON)
		.log()
		.all()
		.when()
		.body(user)
		.post()
		.then()
		.log()
		.all()
		.statusCode(201);
	}

}
