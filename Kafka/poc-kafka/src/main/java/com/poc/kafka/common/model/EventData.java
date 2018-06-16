package com.poc.kafka.common.model;

import java.util.Map;

import com.poc.kafka.common.enums.EntityType;

public class EventData {
	
	private String key;
	private Map<EntityType, Entity> value;
	private String receivedAt;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Map<EntityType, Entity> getValue() {
		return value;
	}
	public void setValue(Map<EntityType, Entity> value) {
		this.value = value;
	}
	public String getReceivedAt() {
		return receivedAt;
	}
	public void setReceivedAt(String receivedAt) {
		this.receivedAt = receivedAt;
	}

	
	
}
