package com.kingdee.eas.WSInterface.common;

import com.google.gson.*;
import com.kingdee.bos.util.BOSUuid;
import java.lang.reflect.Type;

public class BOSUuidTypeAdapter
    implements JsonSerializer, JsonDeserializer
{

    public BOSUuidTypeAdapter()
    {
    }

    public BOSUuid deserialize(JsonElement json, Type type, JsonDeserializationContext context)
        throws JsonParseException
    {
        return BOSUuid.create(json.getAsString());
    }

    public JsonElement serialize(BOSUuid uuid, Type type, JsonSerializationContext context)
    {
        return new JsonPrimitive(uuid.toString());
    }

    public  Object deserialize1(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
        throws JsonParseException
    {
        return deserialize(jsonelement, type, jsondeserializationcontext);
    }

    public JsonElement serialize(Object obj, Type type, JsonSerializationContext jsonserializationcontext)
    {
        return serialize((BOSUuid)obj, type, jsonserializationcontext);
    }
}