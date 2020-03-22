package com.kingdee.eas.custom.tocloud.bean;

//import net.sf.json.JSONObject;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;

/**
 * @author MC
 *
 */
@JSONType(orders = {"Creator","NeedUpDateFields","Model"})
public class CloudCommonDataBean {
	
	//创建者名字（非必填）
	@JSONField(ordinal=1,name = "Creator")
	private String Creator;
	//需要保存的字段,格式["fieldkey1","fieldkey2","entitykey1",...]，数组类型(非必填)
	@JSONField(ordinal=2,name = "NeedUpDateFields")
	private String[] NeedUpDateFields;
	// 表单实体数据（必填）
	@JSONField(ordinal=3,name = "Model")
	private JSONObject Model;
	
	@JSONField(name = "Creator")
	public String getCreator() {
		return Creator;
	}
	
	public void setCreator(String creator) {
		Creator = creator;
	}
	@JSONField(name = "NeedUpDateFields")
	public String[] getNeedUpDateFields() {
		return NeedUpDateFields;
	}
	
	public void setNeedUpDateFields(String[] needUpDateFields) {
		NeedUpDateFields = needUpDateFields;
	}
	@JSONField(name = "Model")
	public JSONObject getModel() {
		return Model;
	}
	
	public void setModel(JSONObject model) {
		Model = model;
	}
	
}
