package com.paras.configurations.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyConfigurations {

	@Value("${author.name}")
	private String authorName;

	@GetMapping("author")
	public String author() {
		return authorName;
	}
}
