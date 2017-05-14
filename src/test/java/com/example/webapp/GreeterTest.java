package com.example.webapp;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class GreeterTest {

	Greeter greeter;
	
	@Before
	public void init(){
		greeter = new Greeter();
	}
	
	@Test
	public void itReturnsAGreetingMessage(){

		//When
		String greeting = greeter.getGreeting(); 
		//Then
		assertEquals("Welcome to the DevOps Training", greeting);
	}
	
	//A failing test
	@Test @Ignore
	public void itHasAFailingTest(){
		fail("What the hell happened?");
	}
}
