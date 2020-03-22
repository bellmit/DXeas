package com.kingdee.eas.WSInterface;

import com.kingdee.bos.Context;
import com.kingdee.eas.util.EASCommonResource;

public class WSResource
{

    public WSResource()
    {
    }

    public static String getResource(Context ctx, String key)
    {
        return EASCommonResource.getString("com.kingdee.eas.custom.WSInterface.WSResource", key, ctx.getLocale());
    }

    public static final String NOT_SUPPORT_SUBMIT = "NOT_SUPPORT_SUBMIT";
    public static final String NOT_SUPPORT_AUDIT = "NOT_SUPPORT_AUDIT";
    public static final String NOT_SUPPORT_AUDITNOT_SUPPORT_BILLTYPE = "NOT_SUPPORT_AUDITNOT_SUPPORT_BILLTYPE";
    public static final String NOT_SUPPORT_STATUS = "NOT_SUPPORT_STATUS";
    public static final String NUMBER_NOTEXISTED = "NUMBER_NOTEXISTED";
    private static final String resName = "com.kingdee.eas.wmWs.app.WSResource";
}