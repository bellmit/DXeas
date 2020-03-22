package com.kingdee.eas.custom.tocloud.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class CloudCommonFAUXPROF7Bean {
	private String FAUXPROPID__FOPCODE;

	@JSONField(name = "FAUXPROPID__FOPCODE")
	public String getFAUXPROPID__FOPCODE() {
		return FAUXPROPID__FOPCODE;
	}

	public void setFAUXPROPID__FOPCODE(String fauxpropid__fopcode) {
		FAUXPROPID__FOPCODE = fauxpropid__fopcode;
	}
}
