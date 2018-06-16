package com.poc.kafka.producer.service;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Conditional;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.poc.kafka.common.model.EventData;
import com.poc.kafka.producer.config.IsProducerRequired;

@Service
@Conditional(IsProducerRequired.class)
public class PublisherService {
	
	@Value("${kafka.producer.topic.name}")
	private String topicName;
	
	@Autowired
	private KafkaTemplate<String, EventData> kafkaTemplate;
	 
	public void sendMessage(EventData data) {
	    kafkaTemplate.send(topicName, data);
	}
	
	@PreDestroy
	private void shutdown(){
		//Add shut down hook part here...
	}

}
