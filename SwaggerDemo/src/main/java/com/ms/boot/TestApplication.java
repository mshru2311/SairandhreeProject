package com.ms.boot;

public class TestApplication {

	@GetMapping
	public String testdata() {
		return "HelloWorld";
	}

}
