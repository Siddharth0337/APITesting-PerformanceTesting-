package com.simplilearn.Restassureddemo;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import  static io.restassured.matcher.RestAssuredMatchers.*;
import  static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import io.restassured.response.Response;

public class AppTest 
{
	@Test
	public void  test1() {
		
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200);
	}
	
	@Test
	public void test2() {
		baseURI ="https://reqres.in/api";
		given().get("users?page=2").then().statusCode(200).body("data.first_name", hasItems("Lindsay","Byron")).log().all();
	}
	
	@Test
	public void test3() {
		baseURI ="https://reqres.in/api/";
		given().get("users?page=2").then().statusCode(200).body("data[1].id", equalTo(8)).log().all();
	}
	
	@Test
	public void test4() {
		/*Map<String, Object> map = new HashMap<String, Object>();
		map.put("\"name\"", "\"Siddharth\"");
		map.put("\"job\"","\"Tester\"");
		System.out.println(map);
		
		baseURI ="https://reqres.in/api/";
		given().get("users?page=2").then()
		.statusCode(200).
		body("data[1].id", equalTo(8)).log().all();
		*/
		
		JSONObject request = new JSONObject();
		request.put("nmae", "Siddharth");
		request.put("job", "Tester");
		
		baseURI ="https://reqres.in/api/";
			given().
			body(request.toString()).
		when().
			post("users").
		then().
			statusCode(201).
			log().all();
		
		
	}
	@Test
	public void test5() {
		JSONObject request = new JSONObject();
		request.put("nmae", "Siddharth");
		request.put("job", "Design Engineer");
		
		baseURI ="https://reqres.in/api/";
			given().
			body(request.toString()).
		when().
			put("users/2").
		then().
			statusCode(200).
			log().all();
		
	}
	
	@Test
	
	public void test6() {
		JSONObject request = new JSONObject();
		request.put("name", "Siddharth");
		request.put("job", "Engineer");
		
		baseURI ="https://reqres.in/api/";
			given().
			body(request.toString()).
		when().
			patch("users/2").
		then().
			statusCode(200).
			log().all();
		
	}
	
	@Test
	public void test7() {
		JSONObject request = new JSONObject();
		/*
		request.put("name", "Siddharth");
		request.put("salary", "15600");
		request.put("age", "26");
		*/
		baseURI ="https://dummy.restapiexample.com/api/";
			given().
			body(request.toString()).
		when().
			get("v1/employee/2").
		then().
			statusCode(200).
			log().all();
		
	}
	
	@Test
	public void test8() {
		baseURI ="https://reqres.in/api/";
		when().delete("users/2").then().
		statusCode(204).
		log().all();;
		
	
	}
	
	
	
	
	
	
}
