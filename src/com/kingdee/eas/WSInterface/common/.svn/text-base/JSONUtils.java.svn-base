package com.kingdee.eas.WSInterface.common;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.WSInterface.billFacade.BillResultInfo;
import com.kingdee.eas.WSInterface.billFacade.BillResultInfoPH;
import com.kingdee.eas.WSInterface.billFacade.ResultInfo;

// Referenced classes of package com.kingdee.eas.wmWs.app.json:
//            DateTypeAdapter, BOSUuidTypeAdapter, BosObjectTypeAdapter, BosObjectCollectionTypeAdapter, 
//            EnumTypeAdapter

public abstract class JSONUtils
{

    protected static Logger logger = Logger.getLogger("com.kingdee.eas.custom.WSInterface.common.JSONUtils");
    protected static final String QUOTES_PREFIX = "${quote_2312415321232}";
    protected static final String LEFT_BRACKETS_PREFIX = "${leftbracket_2312415321232}";
    protected static final String RIGHT_BRACKETS_PREFIX = "${rightbracket_2312415321232}";

    public JSONUtils()
    {
    }

    public static String convertObjectToJson(Context ctx, Object object)
        throws BOSException
    {
        if(object == null || object.equals(""))
            return "\"\"";
        
        BillResultInfo brI = null;
        BillResultInfoPH phbri  = null;
        if(object instanceof BillResultInfo){
        	brI= (BillResultInfo) object;
        	phbri = BillResultInfoPH.getPHResult(brI);
        }else if(object instanceof ResultInfo){
        	brI = new BillResultInfo();
        	phbri = new BillResultInfoPH();
        	ResultInfo objRI =  (ResultInfo)object;
        	phbri.setErrorMsgs(objRI.getMsg());
//        	phbri.setNumber(objRI.get)
//        	brI.setId(objRI.get)
        }
        
        
        
//        String[] errMsg = {"消息1","消息2"};
//        ArrayList<String> msg = new ArrayList<String>();
//        msg.add("消息1");
//        msg.add("消息2");
//        brI.setErrorMsgs(msg);
        Gson gson = getGson(ctx);
        String result = "";
        if(phbri!=null){
        	 result = gson.toJson(phbri);
        }else{
        	result = gson.toJson(object);
        }
        if(result == null)
        {
            return "\"\"";
        } else
        {
            result = processJsonResult(result);
            
            result = result.replaceAll(":,", ":\"\",");
            result = result.replaceAll(":null,", ":\"\",");
            return result;
        }
    }

    public static String processJsonResult(String result)
    {
        result = result.replace("${quote_2312415321232}", "\"");
        result = result.replace("\"${leftbracket_2312415321232}", "{");
        result = result.replace("${leftbracket_2312415321232}", "{");
        result = result.replace("${rightbracket_2312415321232}\"", "}");
        result = result.replace("${rightbracket_2312415321232}", "}");
        return result;
    }

    public static Object convertJsonToObject(Context ctx, String json, Class clz)
        throws BOSException
    {
        Gson gson = getGson(ctx);
        return gson.fromJson(json, clz);
    }

    public static HashMap convertJsonToObject(Context ctx, String json)
        throws BOSException
    {
        Gson gson = getGson(ctx);
        return (HashMap)gson.fromJson(json.toString(), java.util.HashMap.class);
    }

    public static String encodeJson(String json)
        throws BOSException
    {
        StringBuilder encodedJson = new StringBuilder();
        for(int i = 0; i < json.length(); i++)
        {
            char c = json.charAt(i);
            if(c > '\177')
                encodedJson.append("\\u").append(Integer.toHexString(c));
            else
                encodedJson.append(c);
        }

        return encodedJson.toString();
    }

    public static Gson getGson(Context ctx)
    {
        GsonBuilder builder = new GsonBuilder();
        builder.serializeNulls();
        builder.serializeSpecialFloatingPointValues();
        builder.registerTypeHierarchyAdapter(java.util.Date.class, new DateTypeAdapter());
        builder.registerTypeHierarchyAdapter(java.sql.Timestamp.class, new DateTypeAdapter());
        builder.registerTypeHierarchyAdapter(com.kingdee.bos.util.BOSUuid.class, new BOSUuidTypeAdapter());
        builder.registerTypeHierarchyAdapter(com.kingdee.eas.framework.CoreBaseInfo.class, new BosObjectTypeAdapter(ctx));
        builder.registerTypeHierarchyAdapter(com.kingdee.bos.dao.IObjectCollection.class, new BosObjectCollectionTypeAdapter(ctx));
        builder.registerTypeHierarchyAdapter(com.kingdee.eas.basedata.org.OrgUnitInfo.class, new BosObjectTypeAdapter(ctx));
        builder.registerTypeHierarchyAdapter(com.kingdee.bos.dao.query.BizEnumValueDTO.class, new EnumTypeAdapter(ctx));
        builder.registerTypeHierarchyAdapter(java.lang.Enum.class, new EnumTypeAdapter(ctx));
        return builder.create();
    }

}