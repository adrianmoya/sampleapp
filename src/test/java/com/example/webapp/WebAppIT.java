package com.example.webapp;

import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class WebAppIT {

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
	
}
