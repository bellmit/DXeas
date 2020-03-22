package com.kingdee.eas.custom.tocloud.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class CloudCommonFSTOCKF7Bean {
	private String FSTOCKLOCID__FOPCODE;

	@JSONField(name = "FSTOCKLOCID__FOPCODE")
	public String getFSTOCKLOCID__FOPCODE() {
		return FSTOCKLOCID__FOPCODE;
	}

	public void setFSTOCKLOCID__FOPCODE(String fstocklocid__fopcode) {
		FSTOCKLOCID__FOPCODE = fstocklocid__fopcode;
	}
}
