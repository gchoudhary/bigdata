package com.poc.kafka.common.enums;

import com.poc.kafka.common.model.EmailEntity;
import com.poc.kafka.common.model.Entity;

public enum EntityType {
	
	EMAIL("email") {
		@Override
		public boolean validate(Entity entity) {
			EmailEntity emailEntity = (EmailEntity)entity;
			// validation
			return true;
		}
	},
	MOBLE("mobile") {
		@Override
		public boolean validate(Entity entity) {
			
			return false;
		}
	};
	
	private final String entityType;
	
	EntityType(String type) {
		this.entityType = type;
	}
	
	public EntityType getEntityType(String type){
		for(EntityType et: EntityType.values()){
			if(et.entityType.equalsIgnoreCase(type))
				return et;
		}
		return null;
	}
	
	public abstract boolean validate(Entity entity);

}
