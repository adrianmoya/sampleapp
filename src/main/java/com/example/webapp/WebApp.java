package com.example.webapp;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.jtwig.JtwigTemplateEngine;

public class WebApp {
	
	static Greeter greeter =  new Greeter();

	public static void main(String... args) {
		get("/", (req, res) -> {
		    Map<String, Object> model = new HashMap<>();
		    model.put("message", greeter.getGreeting());
		    return new JtwigTemplateEngine().render(
	    		new ModelAndView(model, "index.twig.html")
	    	);
		});
	}
}
