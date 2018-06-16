package com.poc.kafka.consumer.service;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TopicUtil {
	
	@Value("${kafka.producer.topic.name}")
	private String consumerTopics;
	
	public String[] suffixTopics() {
		final String envSuffix = ",";
		String[] topics = Arrays.asList(consumerTopics.split(",")).stream().map(p -> p + envSuffix).toArray(String[]::new);
        return topics;
    }
	
	@PostConstruct
	private void init(){
		System.out.println(suffixTopics());
	}
	
}
