package com.paras.configurations.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paras.configurations.config.Configurations;

@RestController
public class MyConfigurations {

	@Value("${author.name}")
	private String authorName;

	private Configurations configurations;

	@Autowired
	public void setConfigurations(Configurations configurations) {
		this.configurations = configurations;
	}

	@GetMapping("author")
	public String author() {
		return authorName;
	}

	@GetMapping("details")
	public String details() {
		return configurations.toString();
	}
}
