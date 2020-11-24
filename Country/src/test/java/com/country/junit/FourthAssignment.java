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
import net.thucydides.core.annotations.Title;
@RunWith(SerenityRunner.class)
public class FourthAssignment {

	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI="http://postman-echo.com/basic-auth";
	}
	@Title("This is to authenticate user")
	@Test
	public void LoginUser() {
		SerenityRest.given()
		.auth()
		.basic("postman","password")
		.log()
		.all()
		.get()
		.then()
		.assertThat()
		.statusCode(200)
		.log()
		.all();
		
	}
	@Title("This is to validate inavlid login")
	@Test
	public void LoginInvalidUser() {
		SerenityRest.given()
		.auth()
		.basic("postman","pass")
		.log()
		.all()
		.get()
		.then()
		.assertThat()
		.statusCode(200)
		.log()
		.all();
		
	}

}
