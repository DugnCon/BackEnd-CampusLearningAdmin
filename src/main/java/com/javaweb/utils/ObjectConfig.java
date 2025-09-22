package com.javaweb.utils;

import org.springframework.stereotype.Component;

@Component
public class ObjectConfig {
	public String StringConfig(Object object) {
		return object != null ? object.toString() : null;
	}
	public Long LongConfig(Object object) {
	    if (object == null) {
	        return null;
	    }
	    if (object instanceof Number) {
	        return ((Number) object).longValue();
	    }
	    try {
	        return Long.valueOf(object.toString());
	    } catch (NumberFormatException e) {
	        throw new IllegalArgumentException("Cannot convert to Long: " + object, e);
	    }
	}
}
