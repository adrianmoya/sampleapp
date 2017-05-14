package com.example.webapp;

import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.util.EntityUtils;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static spark.Spark.stop;

public class WebAppIT {

	@BeforeClass
	public static void startServer(){
		WebApp.main();
	}
	
	@Test
	public void itShowsTheGreetingMessage() throws Exception{
		//When
		Response response = Request.Get("http://localhost:4567").execute();
		HttpResponse httpResponse = response.returnResponse();
		String content = EntityUtils.toString(httpResponse.getEntity());
		//Then
		assertTrue(httpResponse.getStatusLine().getStatusCode()==200);
		assertTrue(content.contains("Welcome to the DevOps Training"));
	}
	
	//A failing test
	@Test @Ignore
	public void itHasAFailingTest(){
		fail("What the hell happened in the Integration Test?");
	}
	
	@After
	public void stopServer(){
		stop();
	}
	
}
