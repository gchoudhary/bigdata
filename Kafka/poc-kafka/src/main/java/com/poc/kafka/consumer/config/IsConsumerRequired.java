package com.poc.kafka.consumer.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

@Component
public class IsConsumerRequired implements Condition{
	
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata annotatedTypeMetadata) {
		String consumerRequired = context.getEnvironment().getProperty("kafka.consumer.required");
		return consumerRequired.equalsIgnoreCase("true");
	}

}
