package com.kingdee.eas.custom.mobileRPT;

import com.kingdee.bos.Context;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public interface IDownload {

	JSONArray downloadData(Context ctx,JSONObject queryJSON) throws Exception;
}
