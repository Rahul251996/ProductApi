package com.netset.bean;

import java.util.concurrent.ConcurrentHashMap;

public class ProductSearchCriteriaHelper {

	private ConcurrentHashMap<String, Object> hash = new ConcurrentHashMap<String, Object>();

	public void addCriteria(String key, Object value) {
		hash.put(key, value);
	}

	public Object getCriteria(String key) {
		return hash.get(key);
	}

}
