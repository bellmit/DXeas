package com.kingdee.eas.WSInterface.common;

import com.google.gson.*;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTypeAdapter implements JsonSerializer, JsonDeserializer {

	public DateTypeAdapter() {
	}

	public JsonElement serialize(Date object, Type type, JsonSerializationContext context) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = format.format(object);
		return new JsonPrimitive(dateStr);
	}

	public Date deserialize(JsonElement object, Type type, JsonDeserializationContext context)
			throws JsonParseException {
		String dateStr;
		SimpleDateFormat format;
		dateStr = object.getAsString();
		format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return format.parse(dateStr);
		} catch (ParseException e) {
			return null;
		}
	}

	public Object deserialize1(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
			throws JsonParseException {
		return deserialize(jsonelement, type, jsondeserializationcontext);
	}

	public JsonElement serialize(Object obj, Type type, JsonSerializationContext jsonserializationcontext) {
		return serialize((Date) obj, type, jsonserializationcontext);
	}

	public static final String DATEFORMAT = "yyyy-MM-dd HH:mm:ss";
}
