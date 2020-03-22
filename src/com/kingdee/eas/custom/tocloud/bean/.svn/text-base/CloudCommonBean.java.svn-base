package com.kingdee.eas.custom.tocloud.bean;

//import net.sf.json.JSONObject;
import org.codehaus.jackson.annotate.JsonProperty;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;

/**
 * @author MC
 *
 */
@JSONType(orders = {"formId","data"})
public class CloudCommonBean {
	
	//业务对象表单Id（必填）
	@JSONField(ordinal=1,name = "formId")
	private String formId;
	//Json格式数据（详情参考Json格式数据）（必填）
	@JSONField(ordinal=2,name = "data")
	private CloudCommonDataBean data;
	
	@JSONField(name = "formId")
	public String getFormid() {
		return formId;
	}
	
	public void setFormid(String formid) {
		this.formId = formid;
	}
	@JSONField(name = "data")
	public CloudCommonDataBean getData() {
		return data;
	}

	public void setData(CloudCommonDataBean data) {
		this.data = data;
	}
	
	
}
