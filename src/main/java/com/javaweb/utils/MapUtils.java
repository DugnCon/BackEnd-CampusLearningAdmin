package com.javaweb.utils;

import java.util.Map;

public class MapUtils {
	public static <T> T getObject(Map<String, Object> maps, String key, Class<T> tClass) {
		Object obj = maps.getOrDefault(key,null);
		if(obj != null) {
			if(tClass.getTypeName().equals("java.lang.String")) {
				obj = obj != null ? obj.toString() : null;
			} else if (tClass.getTypeName().equals("java.lang.Long")) {
				obj = obj != null ? Long.valueOf(obj.toString()) : null;
			} else if (tClass.getTypeName().equals("java.lang.Double")) {
				obj = obj != null ? Double.valueOf(obj.toString()) : null;
			} else {
				obj = obj != null ? Integer.valueOf(obj.toString()) : null;
			}
			return tClass.cast(obj);
		}
		return null;
	}
}
