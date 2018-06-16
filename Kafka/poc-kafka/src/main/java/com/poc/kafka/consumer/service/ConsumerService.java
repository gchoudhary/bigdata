package com.poc.kafka.consumer.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.poc.kafka.common.model.EventData;
import com.poc.kafka.consumer.config.IsConsumerRequired;

@Service
@Conditional(IsConsumerRequired.class)
public class ConsumerService {
	
	@Autowired
	private TopicUtil topicUtil;

	@KafkaListener(topics = "toipcs", group = "groupName")
	public void processMessage(@Payload EventData eventdata,
			@Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partitionId,
			@Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key) {
		System.out.println("Received event" + eventdata + "On partition " + partitionId + "with Key:" + key);
	}
	
	@PostConstruct
	private void init(){
		System.out.println("#{topicUtil.suffixTopics()}");
	}
	@PreDestroy
	private void shutdown(){
		//Add shut down hook part here...
	}

}
