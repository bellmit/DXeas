package com.kingdee.eas.custom.tocloud.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class CloudKeyValue {

	private String Key;
	
	
	private String Value;

	@JSONField(name = "Key")
	public String getKey() {
		return Key;
	}

	@JSONField(name = "Value")
	public String getValue() {
		return Value;
	}

	public void setKey(String key) {
		Key = key;
	}

	public void setValue(String value) {
		Value = value;
	}
	
	
	
}
