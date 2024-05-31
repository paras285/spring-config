package com.paras.configurations.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = { "external.properties" })
@ConfigurationProperties
@Configuration
public class ExternalConfiguration {

	private List<String> experience;
	
	public void setExperience(List<String> experience) {
		this.experience = experience;
	}

	public List<String> getExperience() {
		return experience;
	}



	@Override
	public String toString() {
		return "ExternalConfiguration [experience=" + experience + "]";
	}

}
