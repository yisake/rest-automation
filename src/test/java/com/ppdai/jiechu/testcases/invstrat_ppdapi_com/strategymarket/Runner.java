package com.ppdai.jiechu.testcases.invstrat_ppdapi_com.strategymarket;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import org.testng.annotations.Test;
import com.ppdai.jiechu.utils.BaseTestCase;
import io.restassured.http.ContentType;

@Test(groups="strategymarket")
public class Runner extends BaseTestCase {
	public static String url= "http://172.17.4.75:83";
	
	@Test(groups="strategymarket")
	public void test_POST_financialplanner_getFinancialPlanner () {
		given().
			config(this.getRestAssuredLogConfig()).
			contentType(ContentType.JSON).
			log().all().
		when().
			post(url+"/financialplanner/getFinancialPlanner").
		then().
			log().all().
			assertThat().statusCode(200).
			assertThat().body("result", equalTo(-1)). 
			assertThat().body("resultMessage", equalTo("非法请求"));		
	}
	
	@Test(groups="strategymarket")
	public void test_POST_strategyList_getStrategyList时() {
		given().
			config(this.getRestAssuredLogConfig()).
			contentType(ContentType.JSON).
			log().all().
		when().
			post(url+"/strategyList/getStrategyList").
		then().
			log().all().
			assertThat().statusCode(200).
			assertThat().body("result", equalTo(-1)).
			assertThat().body("resultMessage", equalTo("非法请求"));		
	}
	
	@Test(groups="strategymarket")
	public void test_POST_user_getUserLoginInf( ) {
		given().
			config(this.getRestAssuredLogConfig()).
			contentType(ContentType.JSON).
			log().all().
		when().
			post(url+"/user/getUserLoginInf").
		then().
			log().all().
			assertThat().statusCode(200).
			assertThat().body("result", equalTo(-2));		
	}
	
	@Test(groups="strategymarket")
	public void test_POST_user_getUserMessageCount() {
		given().
			config(this.getRestAssuredLogConfig()).
			contentType(ContentType.JSON).
			log().all().
		when().
			post(url+"/user/getUserMessageCount").
		then().
			log().all().
			assertThat().statusCode(200).
			assertThat().body("result", equalTo(-1));		
	}
	
	@Test(groups="strategymarket")
	public void test_POST_home_getBannerList () {
		given().
			config(this.getRestAssuredLogConfig()).
			contentType(ContentType.JSON).
			log().all().
		when().
			post(url+"/home/getBannerList").
		then().
			log().all().
			assertThat().statusCode(200).
			assertThat().body(matchesJsonSchema(new File(this.schemaDir+"common_response.json")));
	}
	
	@Test(groups="strategymarket")
	public void test_GET_home_getBannerList( ) {
		given().
			config(this.getRestAssuredLogConfig()).
			log().all().
		when().
			get(url+"/home/getBannerList").
		then().log().all().and().
			assertThat().statusCode(200).
			assertThat().body(matchesJsonSchema(new File(this.schemaDir+"common_response.json")));
	}
	
	@Test
	public void testPOST_home_getSelectionStrategyList () {
		given().
			config(this.getRestAssuredLogConfig()).
			log().all().
		when().
			post(url+"/home/getSelectionStrategyList").
		then().log().all().and().
			assertThat().statusCode(200).
			assertThat().body(matchesJsonSchema(new File(this.schemaDir+"common_response.json")));
	}
	
	@Test
	public void test_POST_home_getStatisticsUser ( ) {
		given().
			config(this.getRestAssuredLogConfig()).
			log().all().
		when().
			post(url+"/home/getStatisticsUser").
		then().log().all().and().
			assertThat().statusCode(200).
			assertThat().body(matchesJsonSchema(new File(this.schemaDir+"common_response.json")));
	}
}

