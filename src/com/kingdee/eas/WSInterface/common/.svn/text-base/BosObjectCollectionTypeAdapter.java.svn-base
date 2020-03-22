package com.kingdee.eas.WSInterface.common;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.IObjectValue;

// Referenced classes of package com.kingdee.eas.wmWs.app.json:
//            JSONUtils

public class BosObjectCollectionTypeAdapter implements JsonSerializer, JsonDeserializer {

	public BosObjectCollectionTypeAdapter(Context ctx) {
		this.ctx = ctx;
	}

	public JsonElement serialize(IObjectCollection coll, Type type, JsonSerializationContext context) {
		StringBuffer jsonBuffer = new StringBuffer();
		jsonBuffer.append("[");
		try {
			for (int nIndex = 0; nIndex < coll.size(); nIndex++) {
				IObjectValue objectValue = coll.getObject(nIndex);
				String objectValueJson = JSONUtils.convertObjectToJson(ctx, objectValue);
				jsonBuffer.append(objectValueJson);
				if (nIndex < coll.size() - 1)
					jsonBuffer.append(",");
			}

		} catch (Exception exception) {
		}
		jsonBuffer.append("]");
		return new JsonPrimitive(jsonBuffer.toString());
	}

	public IObjectCollection deserialize(JsonElement element, Type type, JsonDeserializationContext context)
			throws JsonParseException {
		Class clazz = null;
		IObjectCollection objectCollection = null;
		try {
			clazz = Class.forName(type.toString().substring(type.toString().indexOf(" ") + 1));
			objectCollection = (IObjectCollection) clazz.newInstance();
			if (element.isJsonArray()) {
				JsonArray jsonArray = element.getAsJsonArray();
				Class infoClass = getValueClass(objectCollection);
				for (int nIndex = 0; nIndex < jsonArray.size(); nIndex++) {
					Object obj = JSONUtils.convertJsonToObject(ctx, jsonArray.get(nIndex).toString(), infoClass);
					objectCollection.addObject((IObjectValue) obj);
				}

			}
		} catch (Exception e) {
			throw new JsonParseException(e);
		}
		return objectCollection;
	}

	private Class getValueClass(IObjectCollection collection) {
		Class clazz = null;
		String collectionClassName = collection.getClass().getName();
		String entryInfoClassName = collectionClassName.substring(0, collectionClassName.indexOf("Collection"));
		entryInfoClassName = (new StringBuilder(String.valueOf(entryInfoClassName))).append("Info").toString();
		try {
			clazz = Class.forName(entryInfoClassName);
		} catch (ClassNotFoundException exception) {
			exception.printStackTrace();
		}
		return clazz;
	}

	public Object deserialize1(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
			throws JsonParseException {
		return deserialize(jsonelement, type, jsondeserializationcontext);
	}

	public JsonElement serialize(Object obj, Type type, JsonSerializationContext jsonserializationcontext) {
		return serialize((IObjectCollection) obj, type, jsonserializationcontext);
	}

	private Context ctx;
}