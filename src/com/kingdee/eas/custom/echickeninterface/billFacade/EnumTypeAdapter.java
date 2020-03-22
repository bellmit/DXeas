package com.kingdee.eas.custom.echickeninterface.billFacade;

import com.google.gson.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.query.BizEnumValueDTO;
import com.kingdee.util.LocaleUtils;
import java.lang.reflect.Type;
import java.util.Locale;

public class EnumTypeAdapter
    implements JsonSerializer
{

    public EnumTypeAdapter(Context ctx)
    {
        this.ctx = ctx;
    }

    public JsonElement serialize(BizEnumValueDTO object, Type type, JsonSerializationContext context)
    {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("isenum", Boolean.valueOf(true));
        String strAlias = null;
        if(ctx.getLocale().equals(LocaleUtils.locale_l1))
            strAlias = object.getName();
        else
            strAlias = object.getAlias(ctx.getLocale());
        jsonObject.addProperty("alias", strAlias);
        Object value = object.get("value");
        if(isNumberValue(value.toString()))
            jsonObject.addProperty("value", Double.valueOf(Double.parseDouble(value.toString())));
        else
            jsonObject.addProperty("value", value.toString());
        return new JsonPrimitive(value.toString());
    }

    private boolean isNumberValue(String value)
    {
        boolean blnResult = true;
        try
        {
            Integer.parseInt(value);
        }
        catch(NumberFormatException ex)
        {
            return false;
        }
        try
        {
            Float.parseFloat(value);
        }
        catch(NumberFormatException ex)
        {
            return false;
        }
        try
        {
            Double.parseDouble(value);
        }
        catch(NumberFormatException ex)
        {
            return false;
        }
        return blnResult;
    }

    public JsonElement serialize(Object obj, Type type, JsonSerializationContext jsonserializationcontext)
    {
        return serialize((BizEnumValueDTO)obj, type, jsonserializationcontext);
    }

    public static final String WAF_ENUM_VALUE_KEY = "isenum";
    private Context ctx;
}