package com.example.webapp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GreeterTest {

	Greeter greeter;
	
	@Before
	public void init(){
		greeter = new Greeter();
	}
	
	@Test
	public void itReturnsAGretingMessage(){

		//When
		String greeting = greeter.getGreeting(); 
		//Then
		assertEquals("Welcome to the DevOps Training", greeting);
	}
}
