package com.poc.kafka.producer.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class IsProducerRequired implements Condition{
	
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata annotatedTypeMetadata) {
		String producerRequired = context.getEnvironment().getProperty("kafka.producer.required");
		return producerRequired.equalsIgnoreCase("true");
	}

}

