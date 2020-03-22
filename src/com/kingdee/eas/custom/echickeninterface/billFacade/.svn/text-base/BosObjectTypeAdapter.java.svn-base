package com.kingdee.eas.custom.echickeninterface.billFacade;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.access.MetaDataAccessFactory;
import com.kingdee.bos.metadata.access.entity.EntitySelect;
import com.kingdee.bos.metadata.access.entity.SimpleEntity;
import com.kingdee.bos.metadata.access.entity.SimpleProperty;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemCollection;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.orm.ORMCoreException;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.custom.echickeninterface.common.JSONUtils;
import com.kingdee.eas.custom.echickeninterface.common.WsCommonImportUtil;
import com.kingdee.eas.custom.echickeninterface.common.WsCommonUtil;
import com.kingdee.eas.custom.echickeninterface.common.WsConstant;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.ICoreBase;
import com.kingdee.util.LocaleUtils;
import com.kingdee.util.enums.DoubleEnum;
import com.kingdee.util.enums.Enum;
import com.kingdee.util.enums.FloatEnum;
import com.kingdee.util.enums.IntEnum;
import com.kingdee.util.enums.StringEnum;

// Referenced classes of package com.kingdee.eas.wmWs.app.json:
//            MultiLangUtils, JSONUtils

public class BosObjectTypeAdapter implements JsonSerializer, JsonDeserializer {

	public BosObjectTypeAdapter(Context ctx) {
		this.ctx = ctx;
	}

	public CoreBaseInfo deserialize(JsonElement json, Type type,
			JsonDeserializationContext context) throws JsonParseException {
		JsonObject jsonObject;
		Iterator iterator;
		java.util.Map.Entry entry;
		String typeStr;
		jsonObject = json.getAsJsonObject();
		iterator = jsonObject.entrySet().iterator();
		entry = null;
		JsonElement element = null;
		Type returnType = null;
		typeStr = null;
		CoreBaseInfo objectInfo = null;
		Class clazz = null;
		try {
			clazz = Class.forName(type.toString().substring(
					type.toString().indexOf(" ") + 1));
			objectInfo = (CoreBaseInfo) clazz.newInstance();
		} catch (Exception e) {
			throw new JsonParseException(e.getMessage());
		}
		while (iterator.hasNext()) {
			entry = (java.util.Map.Entry) iterator.next();
			element = jsonObject.get((String) entry.getKey());
			if (element.toString().equals("")
					|| element.toString().equals("\"\"")
					|| element.toString().equals("\"null\"")
					|| element.toString().equals("\"undefined\"")) {
				objectInfo.put(((String) entry.getKey()).toString(), null);
			} else {
				returnType = getValueType(clazz, (String) entry.getKey());
				if (returnType == null) {
					typeStr = getCustomizedValueType(ctx, objectInfo
							.getBOSType(), (String) entry.getKey());
					if (typeStr == null)
						;
				} else {
					typeStr = returnType.toString().substring(
							returnType.toString().indexOf(" ") + 1);
					Class dataType = null;
					if (typeStr.equals("int"))
						typeStr = "java.lang.Integer";
					else if (typeStr.equals("float"))
						typeStr = "java.lang.Float";
					else if (typeStr.equals("double"))
						typeStr = "java.lang.Double";
					else if (typeStr.equals("boolean"))
						typeStr = "java.lang.Boolean";
					try {
						dataType = Class.forName(typeStr);
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
					if (returnType == null)
						returnType = dataType;
					if (!element.isJsonNull())
						if (asSubClass(dataType, java.lang.String.class)) {
							if (MultiLangUtils.isMultiLangEntityProperty(ctx,
									objectInfo.getBOSType(), (String) entry
											.getKey())) {
								JsonObject jsonValue = null;
								if (element.isJsonObject()) {
									jsonValue = element.getAsJsonObject();
									Object value;
									Locale locale;
									for (Iterator langIterator = jsonValue
											.entrySet().iterator(); langIterator
											.hasNext(); objectInfo.put(
											(String) entry.getKey(), value,
											locale)) {
										java.util.Map.Entry entity = (java.util.Map.Entry) langIterator
												.next();
										String key = (String) entity.getKey();
										value = entity.getValue();
										if (!(value instanceof JsonNull))
											value = ((JsonPrimitive) value)
													.getAsString();
										else
											value = null;
										locale = LocaleUtils.getLocale(key);
										if (ctx.getLocale().equals(locale))
											objectInfo.put((String) entry
													.getKey(), value);
									}

								} else {
									String strMultiLangValue = element
											.getAsString();
									if (MultiLangUtils
											.isMultiLangValueFormat(strMultiLangValue)) {
										Map multiLangPartValue = null;
										try {
											multiLangPartValue = JSONUtils
													.convertJsonToObject(ctx,
															strMultiLangValue);
											for (Iterator keysIterator = multiLangPartValue
													.keySet().iterator(); keysIterator
													.hasNext();) {
												String key = (String) keysIterator
														.next();
												Object value = multiLangPartValue
														.get(key);
												if (value != null)
													objectInfo
															.put(
																	(String) entry
																			.getKey(),
																	value,
																	LocaleUtils
																			.getLocale(key));
												else
													objectInfo
															.put(
																	(String) entry
																			.getKey(),
																	null,
																	LocaleUtils
																			.getLocale(key));
											}
										} catch (BOSException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}

									} else {
										objectInfo.put((String) entry.getKey(),
												strMultiLangValue);
									}
								}
							} else {
								objectInfo.put((String) entry.getKey(), element
										.getAsString());
							}
						} else if (asSubClass(dataType, java.lang.Boolean.class))
							try {
								if (element.getAsInt() != 0)
									objectInfo.put((String) entry.getKey(),
											Boolean.valueOf(true));
								else
									objectInfo.put((String) entry.getKey(),
											Boolean.valueOf(false));
							} catch (NumberFormatException exception) {
								objectInfo.put((String) entry.getKey(), Boolean
										.valueOf(element.getAsBoolean()));
							}
						else if (asSubClass(dataType, java.lang.Integer.class)) {
							String num = element.getAsString();
							if (num.indexOf(".") >= 0)
								num = num.substring(0, num.indexOf("."));
							objectInfo.put((String) entry.getKey(), num);
						} else if (asSubClass(dataType, java.lang.Long.class)) {
							String num = element.getAsString();
							if (num.indexOf(".") >= 0)
								num = num.substring(0, num.indexOf("."));
							objectInfo.put((String) entry.getKey(), num);
						} else if (asSubClass(dataType, java.lang.Float.class))
							objectInfo.put((String) entry.getKey(), Float
									.valueOf(element.getAsFloat()));
						else if (asSubClass(dataType, java.lang.Double.class))
							objectInfo.put((String) entry.getKey(), Double
									.valueOf(element.getAsDouble()));
						else if (asSubClass(dataType,
								java.math.BigDecimal.class))
							objectInfo.put((String) entry.getKey(), element
									.getAsBigDecimal());
						else if (asSubClass(dataType, java.util.Date.class)) {
							SimpleDateFormat format = new SimpleDateFormat(
									"yyyy-MM-dd HH:mm:ss");
							try {
								objectInfo.put((String) entry.getKey(), format
										.parse(element.getAsString()));
							} catch (ORMCoreException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else if (asSubClass(dataType,
								java.sql.Timestamp.class)) {
							SimpleDateFormat format = new SimpleDateFormat(
									"yyyy-MM-dd HH:mm:ss");
							Date date = null;
							try {
								date = format.parse(element.getAsString());
								objectInfo.put((String) entry.getKey(), Long
										.valueOf(date.getTime()));
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else if (asSubClass(dataType,
								com.kingdee.bos.util.BOSUuid.class)) {
							if (element.getAsString() != null
									&& !element.getAsString().equals(""))
								objectInfo.put((String) entry.getKey(), BOSUuid
										.read(element.getAsString()));
						} else if (asSubClass(dataType,
								com.kingdee.bos.dao.IObjectCollection.class)) {
							IObjectCollection objectCollection = (IObjectCollection) objectInfo
									.get((String) entry.getKey());
							if (element.isJsonArray()) {
								JsonArray jsonArray = element.getAsJsonArray();
								for (int nIndex = 0; nIndex < jsonArray.size(); nIndex++)
									objectCollection
											.addObject(deserialize(
													jsonArray.get(nIndex),
													getEntryValueType(objectCollection),
													context));

							}
						} else if (asSubClass(dataType,
								com.kingdee.eas.framework.CoreBaseInfo.class))
							objectInfo.put((String) entry.getKey(),
									deserialize(element, returnType, context));
						else
							try {
								if (asSubClass(dataType,
										com.kingdee.util.enums.IntEnum.class)) {
									Method method = dataType.getMethod(
											"getEnum",
											new Class[] { Integer.TYPE });
									Object result = null;
									String num = null;
									if (element.isJsonObject()) {
										num = element.getAsJsonObject().get(
												"value").toString();
										if (num.indexOf(".") >= 0)
											num = num.substring(0, num
													.indexOf("."));
										result = method
												.invoke(
														dataType,
														new Object[] { Integer
																.valueOf(Integer
																		.parseInt(num)) });
									} else {
										num = element.getAsString();
										if (num.indexOf(".") >= 0)
											num = num.substring(0, num
													.indexOf("."));
										result = method
												.invoke(
														dataType,
														new Object[] { Integer
																.valueOf(Integer
																		.parseInt(num)) });
									}
									objectInfo.put((String) entry.getKey(),
											result);
								} else if (asSubClass(dataType,
										com.kingdee.util.enums.StringEnum.class)) {
									Method method = dataType
											.getMethod(
													"getEnum",
													new Class[] { java.lang.String.class });
									Object result = null;
									if (element.isJsonObject())
										result = method.invoke(dataType,
												new Object[] { element
														.getAsJsonObject().get(
																"value")
														.getAsString() });
									else
										result = method.invoke(dataType,
												new Object[] { element
														.getAsString() });
									objectInfo.put((String) entry.getKey(),
											result);
								} else if (asSubClass(dataType,
										com.kingdee.util.enums.FloatEnum.class)) {
									Method method = dataType.getMethod(
											"getEnum",
											new Class[] { Float.TYPE });
									Object result = null;
									if (element.isJsonObject())
										result = method
												.invoke(
														dataType,
														new Object[] { Float
																.valueOf(element
																		.getAsJsonObject()
																		.get(
																				"value")
																		.getAsFloat()) });
									else
										result = method
												.invoke(
														dataType,
														new Object[] { Float
																.valueOf(element
																		.getAsFloat()) });
									objectInfo.put((String) entry.getKey(),
											result);
								} else if (asSubClass(dataType,
										com.kingdee.util.enums.DoubleEnum.class)) {
									Method method = dataType.getMethod(
											"getEnum",
											new Class[] { Double.TYPE });
									Object result = null;
									if (element.isJsonObject())
										result = method
												.invoke(
														dataType,
														new Object[] { Float
																.valueOf(element
																		.getAsJsonObject()
																		.get(
																				"value")
																		.getAsFloat()) });
									else
										result = method
												.invoke(
														dataType,
														new Object[] { Double
																.valueOf(element
																		.getAsDouble()) });
									objectInfo.put((String) entry.getKey(),
											result);
								}
							} catch (Exception uoe) {
								if (!(uoe instanceof JsonParseException)) {
									String err = "JSON\u89E3\u6790\u9519\u8BEF,";
									if (entry != null)
										err = (new StringBuilder(String
												.valueOf(err))).append(
												"\u5C5E\u6027").append(
												(String) entry.getKey())
												.append("\u7684JSON\u503C")
												.append(entry.getValue())
												.toString();
									if (typeStr != null)
										err = (new StringBuilder(String
												.valueOf(err)))
												.append(
														"\uFF0C\u4E0D\u662F\u671F\u671B\u7684\u6570\u636E\u7C7B\u578B")
												.append(typeStr).toString();
									throw new JsonParseException(err);
								} else {
									throw (JsonParseException) uoe;
								}
							}
				}
			}
		}
		return objectInfo;
		/**
		 * Exception uoe; //uoe; if(!(uoe instanceof JsonParseException)) {
		 * String err = "JSON\u89E3\u6790\u9519\u8BEF,"; if(entry != null) err =
		 * (new
		 * StringBuilder(String.valueOf(err))).append("\u5C5E\u6027").append
		 * ((String
		 * )entry.getKey()).append("\u7684JSON\u503C").append(entry.getValue
		 * ()).toString(); if(typeStr != null) err = (new
		 * StringBuilder(String.valueOf(err))).append(
		 * "\uFF0C\u4E0D\u662F\u671F\u671B\u7684\u6570\u636E\u7C7B\u578B"
		 * ).append(typeStr).toString(); throw new JsonParseException(err); }
		 * else { throw (JsonParseException)uoe; }
		 */
	}

	private boolean asSubClass(Class source, Class desc) {
		try {
			Class result = source.asSubclass(desc);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	private Type getValueType(Class clazz, String property) {

		if (clazz == null)
			return null;
		try {
			String strMethod;
			String strMethodByBoolean;
			int i;
			int j;
			Method amethod[];
			strMethod = (new StringBuilder("get")).append(
					property.substring(0, 1).toUpperCase()).append(
					property.substring(1)).toString();
			strMethodByBoolean = (new StringBuilder("is")).append(
					property.substring(0, 1).toUpperCase()).append(
					property.substring(1)).toString();
			j = (amethod = clazz.getMethods()).length;
			i = 0;
			for (i = 0; i <= j; i++) {
				if (i < j) {
					Method method = amethod[i];
					if (method.getName().equalsIgnoreCase(strMethod)
							|| method.getName().equalsIgnoreCase(
									strMethodByBoolean))
						return method.getGenericReturnType();
				} else {
					return getValueType(clazz.getSuperclass(), property);
				}
			}
			/*
			 * goto _L1; _L3: Method method = amethod[i];
			 * if(method.getName().equalsIgnoreCase(strMethod)||
			 * method.getName().equalsIgnoreCase(strMethodByBoolean)) return
			 * method.getGenericReturnType(); i++; _L1: if(i < j) goto _L3; else
			 * goto _L2; _L2: return getValueType(clazz.getSuperclass(),
			 * property);
			 */
		} catch (Exception e) {

			// SecurityException securityexception;
			// securityexception;
			throw new SecurityException(e.getMessage());
		}

		return null;
	}

	private String getCustomizedValueType(Context ctx,
			BOSObjectType bosObjectType, String property) {
		SimpleProperty propertyObject;
		EntitySelect select = new EntitySelect(bosObjectType);
		select.propertySelect().select(property, "dataType");
		try {
			SimpleEntity entity = MetaDataAccessFactory.getLocalInstance(ctx)
					.select(select);
			propertyObject = entity.property(property);
			if (propertyObject == null)
				;// break MISSING_BLOCK_LABEL_79;
			if (propertyObject.isOwnProperty())
				return propertyObject.getDataType().getJavaTypeName();
			return propertyObject.getRefTypeInfo();
		} catch (Exception e) {
			return null;
		}
	}

	private Type getEntryValueType(IObjectCollection collection) {
		Type returnType = null;
		String collectionClassName = collection.getClass().getName();
		String entryInfoClassName = collectionClassName.substring(0,
				collectionClassName.indexOf("Collection"));
		entryInfoClassName = (new StringBuilder(String
				.valueOf(entryInfoClassName))).append("Info").toString();
		try {
			returnType = Class.forName(entryInfoClassName);
		} catch (ClassNotFoundException exception) {
			exception.printStackTrace();
		}
		return returnType;
	}

	private Object getObjectValue(Object object, Class objectClass,
			String property) {
		if (object == null)
			return null;
		try {
			String strMethod;
			String strMethodByBoolean;
			int i;
			int j;
			Method amethod[];
			strMethod = (new StringBuilder("get")).append(
					property.substring(0, 1).toUpperCase()).append(
					property.substring(1)).toString();
			strMethodByBoolean = (new StringBuilder("is")).append(
					property.substring(0, 1).toUpperCase()).append(
					property.substring(1)).toString();
			j = (amethod = objectClass.getMethods()).length;
			i = 0;
			for (i = 0; i <= j; i++) {
				if (i < j) {
					Method method = amethod[i];
					if (method.getName().equalsIgnoreCase(strMethod)
							|| method.getName().equalsIgnoreCase(
									strMethodByBoolean))
						return method.invoke(object, null);
				} else {
					return getObjectValue(object, objectClass.getSuperclass(),
							property);
				}
			}
		} catch (Exception e) {
			return null;
		}
		/**
		 * goto _L1 _L3: Method method = amethod[i];
		 * if(method.getName().equalsIgnoreCase(strMethod) ||
		 * method.getName().equalsIgnoreCase(strMethodByBoolean)) return
		 * method.invoke(object, null); i++; _L1: if(i < j) goto _L3; else goto
		 * _L2 _L2: return getObjectValue(object, objectClass.getSuperclass(),
		 * property); Exception exception; exception; return null;
		 */
		return null;
	}

	public JsonElement serialize(CoreBaseInfo objectValue, Type type,
			JsonSerializationContext context) {
		JsonElement jsonElement = null;
		if (objectValue == null)
			return null;
		try {
			jsonElement = new JsonPrimitive(convertInfoToJson(objectValue));
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return jsonElement;
	}

	private String convertInfoToJson(CoreBaseInfo objectValue)
			throws BOSException {
		String jsonBuffer = "";
		Class objectClazz = objectValue.getClass();
		CoreBaseInfo tempObjectInfo = null;
		try {
			tempObjectInfo = (CoreBaseInfo) objectClazz.newInstance();
			jsonBuffer = (new StringBuilder()).append(jsonBuffer).append(
					"${leftbracket_2312415321232}").toString();
			Enumeration enumeration = objectValue.keys();
			do {
				if (!enumeration.hasMoreElements())
					break;
				String key = (String) enumeration.nextElement();
				String realKey = getRealByEntity(objectValue.getClass(), key);
				if (realKey == null)
					continue;
				realKey = (new StringBuilder())
						.append("${quote_2312415321232}").append(realKey)
						.append("${quote_2312415321232}").toString();
				Object value = objectValue.get(key);
				if (value == null)
					continue;
				Type returnType = getValueType(objectValue.getClass(), key);
				if (returnType == null)
					continue;
				String typeStr = returnType.toString().substring(
						returnType.toString().indexOf(" ") + 1);
				if (typeStr.equals("int"))
					typeStr = "java.lang.Integer";
				else if (typeStr.equals("float"))
					typeStr = "java.lang.Float";
				else if (typeStr.equals("double"))
					typeStr = "java.lang.Double";
				else if (typeStr.equals("boolean"))
					typeStr = "java.lang.Boolean";
				Class dataType = Class.forName(typeStr);
				if (asSubClass(dataType, java.lang.String.class)) {
					if (MultiLangUtils.isMultiLangEntityProperty(ctx,
							objectValue.getBOSType(), key))
						jsonBuffer = (new StringBuilder()).append(jsonBuffer)
								.append(realKey).append(":").append(
										"${quote_2312415321232}").append(
										objectValue.get(key,
												LocaleUtils.locale_l2)).append(
										"${quote_2312415321232}").toString();
					else
						jsonBuffer = (new StringBuilder()).append(jsonBuffer)
								.append(realKey).append(":").append(
										"${quote_2312415321232}").append(
										value.toString()).append(
										"${quote_2312415321232}").toString();
				} else if (asSubClass(dataType, java.lang.Number.class))
					jsonBuffer = (new StringBuilder()).append(jsonBuffer)
							.append(realKey).append(":").append(
									value.toString()).toString();
				else if (asSubClass(dataType,
						com.kingdee.eas.framework.CoreBaseInfo.class))
					jsonBuffer = (new StringBuilder())
							.append(jsonBuffer)
							.append(realKey)
							.append(":")
							.append(
									convertEntryInfoToJson((CoreBaseInfo) value))
							.toString();
				else if (asSubClass(dataType, java.lang.Boolean.class))
					jsonBuffer = (new StringBuilder()).append(jsonBuffer)
							.append(realKey).append(":").append(value)
							.toString();
				else if (asSubClass(dataType,
						com.kingdee.bos.dao.IObjectCollection.class)) {
					IObjectCollection objectCollection = (IObjectCollection) value;
					jsonBuffer = (new StringBuilder()).append(jsonBuffer)
							.append(realKey).append(":[").toString();
					for (int nIndex = 0; nIndex < objectCollection.size(); nIndex++) {
						IObjectValue entryObject = objectCollection
								.getObject(nIndex);
						if (entryObject instanceof CoreBaseInfo)
							jsonBuffer = (new StringBuilder())
									.append(jsonBuffer)
									.append(
											convertEntryInfoToJson((CoreBaseInfo) entryObject))
									.toString();
						else
							jsonBuffer = (new StringBuilder()).append(
									jsonBuffer).append(
									convertInfoToJson(entryObject)).toString();
						if (nIndex < objectCollection.size() - 1)
							jsonBuffer = (new StringBuilder()).append(
									jsonBuffer).append(",").toString();
					}

					jsonBuffer = (new StringBuilder()).append(jsonBuffer)
							.append("]").toString();
				} else if (asSubClass(dataType,
						com.kingdee.util.enums.Enum.class)) {
					Enum result = (Enum) getObjectValue(objectValue,
							objectValue.getClass(), key);
					if (result == null)
						continue;
					jsonBuffer = (new StringBuilder()).append(jsonBuffer)
							.append(realKey).append(":").toString();
					jsonBuffer = (new StringBuilder()).append(jsonBuffer)
							.append("{").toString();
					jsonBuffer = (new StringBuilder())
							.append(jsonBuffer)
							.append(
									"${quote_2312415321232}isenum${quote_2312415321232}:true,")
							.toString();
					if (asSubClass(dataType,
							com.kingdee.util.enums.IntEnum.class)) {
						String strAlias = null;
						if (ctx.getLocale().equals(LocaleUtils.locale_l1))
							strAlias = ((IntEnum) result).getName();
						else
							strAlias = ((IntEnum) result).getAlias(ctx
									.getLocale());
						jsonBuffer = (new StringBuilder())
								.append(jsonBuffer)
								.append(
										"${quote_2312415321232}alias${quote_2312415321232}:${quote_2312415321232}")
								.append(strAlias).append(
										"${quote_2312415321232}").append(",")
								.toString();
						jsonBuffer = (new StringBuilder())
								.append(jsonBuffer)
								.append(
										"${quote_2312415321232}value${quote_2312415321232}:")
								.append(((IntEnum) result).getValue())
								.toString();
					} else if (asSubClass(dataType,
							com.kingdee.util.enums.FloatEnum.class)) {
						String strAlias = null;
						if (ctx.getLocale().equals(LocaleUtils.locale_l1))
							strAlias = ((FloatEnum) result).getName();
						else
							strAlias = ((FloatEnum) result).getAlias(ctx
									.getLocale());
						jsonBuffer = (new StringBuilder())
								.append(jsonBuffer)
								.append(
										"${quote_2312415321232}alias${quote_2312415321232}:${quote_2312415321232}")
								.append(strAlias).append(
										"${quote_2312415321232}").append(",")
								.toString();
						jsonBuffer = (new StringBuilder())
								.append(jsonBuffer)
								.append(
										"${quote_2312415321232}value${quote_2312415321232}:")
								.append(((FloatEnum) result).getValue())
								.toString();
					} else if (asSubClass(dataType,
							com.kingdee.util.enums.DoubleEnum.class)) {
						String strAlias = null;
						if (ctx.getLocale().equals(LocaleUtils.locale_l1))
							strAlias = ((DoubleEnum) result).getName();
						else
							strAlias = ((DoubleEnum) result).getAlias(ctx
									.getLocale());
						jsonBuffer = (new StringBuilder())
								.append(jsonBuffer)
								.append(
										"${quote_2312415321232}alias${quote_2312415321232}:${quote_2312415321232}")
								.append(strAlias).append(
										"${quote_2312415321232}").append(",")
								.toString();
						jsonBuffer = (new StringBuilder())
								.append(jsonBuffer)
								.append(
										"${quote_2312415321232}value${quote_2312415321232}:")
								.append(((DoubleEnum) result).getValue())
								.toString();
					} else if (asSubClass(dataType,
							com.kingdee.util.enums.StringEnum.class)) {
						String strAlias = null;
						if (ctx.getLocale().equals(LocaleUtils.locale_l1))
							strAlias = ((StringEnum) result).getName();
						else
							strAlias = ((StringEnum) result).getAlias(ctx
									.getLocale());
						jsonBuffer = (new StringBuilder())
								.append(jsonBuffer)
								.append(
										"${quote_2312415321232}alias${quote_2312415321232}:${quote_2312415321232}")
								.append(strAlias).append(
										"${quote_2312415321232}").append(",")
								.toString();
						jsonBuffer = (new StringBuilder())
								.append(jsonBuffer)
								.append(
										"${quote_2312415321232}value${quote_2312415321232}:${quote_2312415321232}")
								.append(((StringEnum) result).getValue())
								.append("${quote_2312415321232}").toString();
					}
					jsonBuffer = (new StringBuilder()).append(jsonBuffer)
							.append("}").toString();
				} else if (asSubClass(dataType,
						com.kingdee.bos.util.BOSUuid.class))
					jsonBuffer = (new StringBuilder()).append(jsonBuffer)
							.append(realKey).append(":").append(
									"${quote_2312415321232}").append(
									value.toString()).append(
									"${quote_2312415321232}").toString();
				else if (asSubClass(dataType, java.sql.Timestamp.class)) {
					SimpleDateFormat format = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss");
					if (value instanceof String)
						jsonBuffer = (new StringBuilder()).append(jsonBuffer)
								.append(realKey).append(":").append(
										"${quote_2312415321232}").append(value)
								.append("${quote_2312415321232}").toString();
					else
						jsonBuffer = (new StringBuilder()).append(jsonBuffer)
								.append(realKey).append(":").append(
										"${quote_2312415321232}").append(
										format.format((Date) value)).append(
										"${quote_2312415321232}").toString();
				} else if (asSubClass(dataType, java.util.Date.class)) {
					SimpleDateFormat format = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss");
					if (value instanceof String)
						jsonBuffer = (new StringBuilder()).append(jsonBuffer)
								.append(realKey).append(":").append(
										"${quote_2312415321232}").append(value)
								.append("${quote_2312415321232}").toString();
					else
						jsonBuffer = (new StringBuilder()).append(jsonBuffer)
								.append(realKey).append(":").append(
										"${quote_2312415321232}").append(
										format.format((Date) value)).append(
										"${quote_2312415321232}").toString();
				} else {
					jsonBuffer = (new StringBuilder()).append(jsonBuffer)
							.append(realKey).append(":").append(
									"${quote_2312415321232}").append(
									value.toString()).append(
									"${quote_2312415321232}").toString();
				}
				if (enumeration.hasMoreElements())
					jsonBuffer = (new StringBuilder()).append(jsonBuffer)
							.append(",").toString();
			} while (true);
			if (jsonBuffer.trim().endsWith(","))
				jsonBuffer = jsonBuffer.substring(0, jsonBuffer.length() - 1);
			jsonBuffer = (new StringBuilder()).append(jsonBuffer).append(
					"${rightbracket_2312415321232}").toString();
		} catch (Exception exception) {
			throw new BOSException(exception);
		}
		return jsonBuffer.toString();
	}

	private String convertInfoToJson(IObjectValue objectValue)
			throws BOSException {
		String jsonBuffer = "";
		Class objectClazz = objectValue.getClass();
		try {
			jsonBuffer = (new StringBuilder()).append(jsonBuffer).append(
					"${leftbracket_2312415321232}").toString();
			Enumeration enumeration = objectValue.keys();
			do {
				if (!enumeration.hasMoreElements())
					break;
				String key = (String) enumeration.nextElement();
				String realKey = getRealByEntity(objectValue.getClass(), key);
				if (realKey == null)
					continue;
				realKey = (new StringBuilder())
						.append("${quote_2312415321232}").append(realKey)
						.append("${quote_2312415321232}").toString();
				Object value = objectValue.get(key);
				if (value == null)
					continue;
				Type returnType = getValueType(objectValue.getClass(), key);
				if (returnType == null)
					continue;
				String typeStr = returnType.toString().substring(
						returnType.toString().indexOf(" ") + 1);
				if (typeStr.equals("int"))
					typeStr = "java.lang.Integer";
				else if (typeStr.equals("float"))
					typeStr = "java.lang.Float";
				else if (typeStr.equals("double"))
					typeStr = "java.lang.Double";
				else if (typeStr.equals("boolean"))
					typeStr = "java.lang.Boolean";
				Class dataType = Class.forName(typeStr);
				if (asSubClass(dataType, java.lang.String.class)) {
					if (MultiLangUtils.isMultiLangEntityProperty(ctx,
							objectValue.getBOSType(), key))
						jsonBuffer = (new StringBuilder()).append(jsonBuffer)
								.append(realKey).append(":").append(
										"${quote_2312415321232}").append(
										objectValue.get(key,
												LocaleUtils.locale_l2)).append(
										"${quote_2312415321232}").toString();
					else
						jsonBuffer = (new StringBuilder()).append(jsonBuffer)
								.append(realKey).append(":").append(
										"${quote_2312415321232}").append(
										value.toString()).append(
										"${quote_2312415321232}").toString();
				} else if (asSubClass(dataType, java.lang.Number.class))
					jsonBuffer = (new StringBuilder()).append(jsonBuffer)
							.append(realKey).append(":").append(
									value.toString()).toString();
				else if (asSubClass(dataType,
						com.kingdee.eas.framework.CoreBaseInfo.class))
					jsonBuffer = (new StringBuilder()).append(jsonBuffer)
							.append(realKey).append(":").append(
									convertInfoToJson((CoreBaseInfo) value))
							.toString();
				else if (asSubClass(dataType, java.lang.Boolean.class))
					jsonBuffer = (new StringBuilder()).append(jsonBuffer)
							.append(realKey).append(":").append(value)
							.toString();
				else if (asSubClass(dataType,
						com.kingdee.bos.dao.IObjectCollection.class)) {
					IObjectCollection objectCollection = (IObjectCollection) value;
					jsonBuffer = (new StringBuilder()).append(jsonBuffer)
							.append(realKey).append(":[").toString();
					for (int nIndex = 0; nIndex < objectCollection.size(); nIndex++) {
						IObjectValue entryObject = objectCollection
								.getObject(nIndex);
						if (entryObject instanceof CoreBaseInfo)
							jsonBuffer = (new StringBuilder())
									.append(jsonBuffer)
									.append(
											convertInfoToJson((CoreBaseInfo) entryObject))
									.toString();
						else
							jsonBuffer = (new StringBuilder()).append(
									jsonBuffer).append(
									convertInfoToJson(entryObject)).toString();
						if (nIndex < objectCollection.size() - 1)
							jsonBuffer = (new StringBuilder()).append(
									jsonBuffer).append(",").toString();
					}

					jsonBuffer = (new StringBuilder()).append(jsonBuffer)
							.append("]").toString();
				} else if (asSubClass(dataType,
						com.kingdee.util.enums.Enum.class)) {
					Enum result = (Enum) getObjectValue(objectValue,
							objectValue.getClass(), key);
					if (result == null)
						continue;
					jsonBuffer = (new StringBuilder()).append(jsonBuffer)
							.append(realKey).append(":").toString();
					jsonBuffer = (new StringBuilder()).append(jsonBuffer)
							.append("{").toString();
					jsonBuffer = (new StringBuilder())
							.append(jsonBuffer)
							.append(
									"${quote_2312415321232}isenum${quote_2312415321232}:true,")
							.toString();
					if (asSubClass(dataType,
							com.kingdee.util.enums.IntEnum.class)) {
						String strAlias = null;
						if (ctx.getLocale().equals(LocaleUtils.locale_l1))
							strAlias = ((IntEnum) result).getName();
						else
							strAlias = ((IntEnum) result).getAlias(ctx
									.getLocale());
						jsonBuffer = (new StringBuilder())
								.append(jsonBuffer)
								.append(
										"${quote_2312415321232}alias${quote_2312415321232}:${quote_2312415321232}")
								.append(strAlias).append(
										"${quote_2312415321232}").append(",")
								.toString();
						jsonBuffer = (new StringBuilder())
								.append(jsonBuffer)
								.append(
										"${quote_2312415321232}value${quote_2312415321232}:")
								.append(((IntEnum) result).getValue())
								.toString();
					} else if (asSubClass(dataType,
							com.kingdee.util.enums.FloatEnum.class)) {
						String strAlias = null;
						if (ctx.getLocale().equals(LocaleUtils.locale_l1))
							strAlias = ((FloatEnum) result).getName();
						else
							strAlias = ((FloatEnum) result).getAlias(ctx
									.getLocale());
						jsonBuffer = (new StringBuilder())
								.append(jsonBuffer)
								.append(
										"${quote_2312415321232}alias${quote_2312415321232}:${quote_2312415321232}")
								.append(strAlias).append(
										"${quote_2312415321232}").append(",")
								.toString();
						jsonBuffer = (new StringBuilder())
								.append(jsonBuffer)
								.append(
										"${quote_2312415321232}value${quote_2312415321232}:")
								.append(((FloatEnum) result).getValue())
								.toString();
					} else if (asSubClass(dataType,
							com.kingdee.util.enums.DoubleEnum.class)) {
						String strAlias = null;
						if (ctx.getLocale().equals(LocaleUtils.locale_l1))
							strAlias = ((DoubleEnum) result).getName();
						else
							strAlias = ((DoubleEnum) result).getAlias(ctx
									.getLocale());
						jsonBuffer = (new StringBuilder())
								.append(jsonBuffer)
								.append(
										"${quote_2312415321232}alias${quote_2312415321232}:${quote_2312415321232}")
								.append(strAlias).append(
										"${quote_2312415321232}").append(",")
								.toString();
						jsonBuffer = (new StringBuilder())
								.append(jsonBuffer)
								.append(
										"${quote_2312415321232}value${quote_2312415321232}:")
								.append(((DoubleEnum) result).getValue())
								.toString();
					} else if (asSubClass(dataType,
							com.kingdee.util.enums.StringEnum.class)) {
						String strAlias = null;
						if (ctx.getLocale().equals(LocaleUtils.locale_l1))
							strAlias = ((StringEnum) result).getName();
						else
							strAlias = ((StringEnum) result).getAlias(ctx
									.getLocale());
						jsonBuffer = (new StringBuilder())
								.append(jsonBuffer)
								.append(
										"${quote_2312415321232}alias${quote_2312415321232}:${quote_2312415321232}")
								.append(strAlias).append(
										"${quote_2312415321232}").append(",")
								.toString();
						jsonBuffer = (new StringBuilder())
								.append(jsonBuffer)
								.append(
										"${quote_2312415321232}value${quote_2312415321232}:${quote_2312415321232}")
								.append(((StringEnum) result).getValue())
								.append("${quote_2312415321232}").toString();
					}
					jsonBuffer = (new StringBuilder()).append(jsonBuffer)
							.append("}").toString();
				} else if (asSubClass(dataType,
						com.kingdee.bos.util.BOSUuid.class))
					jsonBuffer = (new StringBuilder()).append(jsonBuffer)
							.append(realKey).append(":").append(
									"${quote_2312415321232}").append(
									value.toString()).append(
									"${quote_2312415321232}").toString();
				else if (asSubClass(dataType, java.sql.Timestamp.class)) {
					SimpleDateFormat format = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss");
					if (value instanceof String)
						jsonBuffer = (new StringBuilder()).append(jsonBuffer)
								.append(realKey).append(":").append(
										"${quote_2312415321232}").append(value)
								.append("${quote_2312415321232}").toString();
					else
						jsonBuffer = (new StringBuilder()).append(jsonBuffer)
								.append(realKey).append(":").append(
										"${quote_2312415321232}").append(
										format.format((Date) value)).append(
										"${quote_2312415321232}").toString();
				} else if (asSubClass(dataType, java.util.Date.class)) {
					SimpleDateFormat format = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss");
					if (value instanceof String)
						jsonBuffer = (new StringBuilder()).append(jsonBuffer)
								.append(realKey).append(":").append(
										"${quote_2312415321232}").append(value)
								.append("${quote_2312415321232}").toString();
					else
						jsonBuffer = (new StringBuilder()).append(jsonBuffer)
								.append(realKey).append(":").append(
										"${quote_2312415321232}").append(
										format.format((Date) value)).append(
										"${quote_2312415321232}").toString();
				} else {
					jsonBuffer = (new StringBuilder()).append(jsonBuffer)
							.append(realKey).append(":").append(
									"${quote_2312415321232}").append(
									value.toString()).append(
									"${quote_2312415321232}").toString();
				}
				if (enumeration.hasMoreElements())
					jsonBuffer = (new StringBuilder()).append(jsonBuffer)
							.append(",").toString();
			} while (true);
			if (jsonBuffer.trim().endsWith(","))
				jsonBuffer = jsonBuffer.substring(0, jsonBuffer.length() - 1);
			jsonBuffer = (new StringBuilder()).append(jsonBuffer).append(
					"${rightbracket_2312415321232}").toString();
		} catch (Exception exception) {
			throw new BOSException(exception);
		}
		return jsonBuffer;
	}

	private String getRealByEntity(Class clazz, String property) {
		if (clazz == null || property == null || property.equals(""))
			return null;
		Method methods[] = clazz.getDeclaredMethods();
		String strOldKey = (new StringBuilder("get")).append(property)
				.toString();
		String strOldKeyByBoolean = (new StringBuilder("is")).append(property)
				.toString();
		Method amethod[];
		int j = (amethod = methods).length;
		for (int i = 0; i < j; i++) {
			Method method = amethod[i];
			if (method.getName().equalsIgnoreCase(strOldKey)) {
				String fieldName = method.getName().substring(3);
				return (new StringBuilder(String.valueOf(fieldName.substring(0,
						1).toLowerCase()))).append(fieldName.substring(1))
						.toString();
			}
			if (method.getName().equalsIgnoreCase(strOldKeyByBoolean)) {
				String fieldName = method.getName().substring(2);
				return (new StringBuilder(String.valueOf(fieldName.substring(0,
						1).toLowerCase()))).append(fieldName.substring(1))
						.toString();
			}
		}

		return getRealByEntity(clazz.getSuperclass(), property);
	}

	private String convertEntryInfoToJson(CoreBaseInfo objectValue)
			throws BOSException {
		String jsonBuffer = "";
		Class objectClazz = objectValue.getClass();
		CoreBaseInfo tempObjectInfo = null;
		try {
			tempObjectInfo = (CoreBaseInfo) objectClazz.newInstance();
			jsonBuffer = (new StringBuilder()).append(jsonBuffer).append(
					"${leftbracket_2312415321232}").toString();
			Enumeration enumeration = objectValue.keys();
			do {
				if (!enumeration.hasMoreElements())
					break;
				String key = (String) enumeration.nextElement();
				String realKey = getRealByEntity(objectValue.getClass(), key);
				if (realKey == null)
					continue;
				realKey = (new StringBuilder())
						.append("${quote_2312415321232}").append(realKey)
						.append("${quote_2312415321232}").toString();
				Object value = objectValue.get(key);
				if (value == null)
					continue;
				Type returnType = getValueType(objectValue.getClass(), key);
				if (returnType == null)
					continue;
				String typeStr = returnType.toString().substring(
						returnType.toString().indexOf(" ") + 1);
				if (typeStr.equals("int"))
					typeStr = "java.lang.Integer";
				else if (typeStr.equals("float"))
					typeStr = "java.lang.Float";
				else if (typeStr.equals("double"))
					typeStr = "java.lang.Double";
				else if (typeStr.equals("boolean"))
					typeStr = "java.lang.Boolean";
				Class dataType = Class.forName(typeStr);
				if (asSubClass(dataType,
						com.kingdee.bos.dao.IObjectCollection.class)
						&& value.toString().equals("[]"))
					continue;
				if (asSubClass(dataType, java.lang.String.class)) {
					if (MultiLangUtils.isMultiLangEntityProperty(ctx,
							objectValue.getBOSType(), key))
						jsonBuffer = (new StringBuilder()).append(jsonBuffer)
								.append(realKey).append(":").append(
										"${quote_2312415321232}").append(
										objectValue.get(key,
												LocaleUtils.locale_l2)).append(
										"${quote_2312415321232}").toString();
					else
						jsonBuffer = (new StringBuilder()).append(jsonBuffer)
								.append(realKey).append(":").append(
										"${quote_2312415321232}").append(
										value.toString()).append(
										"${quote_2312415321232}").toString();
				} else if (asSubClass(dataType, java.lang.Number.class))
					jsonBuffer = (new StringBuilder()).append(jsonBuffer)
							.append(realKey).append(":").append(
									value.toString()).toString();
				else if (asSubClass(dataType,
						com.kingdee.eas.framework.CoreBaseInfo.class))
					jsonBuffer = (new StringBuilder()).append(jsonBuffer)
							.append(realKey).append(":").append(
									convertInfoToJson((CoreBaseInfo) value))
							.toString();
				else if (asSubClass(dataType, java.lang.Boolean.class))
					jsonBuffer = (new StringBuilder()).append(jsonBuffer)
							.append(realKey).append(":").append(value)
							.toString();
				else if (asSubClass(dataType,
						com.kingdee.bos.dao.IObjectCollection.class)) {
					IObjectCollection objectCollection = (IObjectCollection) value;
					jsonBuffer = (new StringBuilder()).append(jsonBuffer)
							.append(realKey).append(":[").toString();
					for (int nIndex = 0; nIndex < objectCollection.size(); nIndex++) {
						IObjectValue entryObject = objectCollection
								.getObject(nIndex);
						if (entryObject instanceof CoreBaseInfo) {
							if (entryObject.getBOSType() != null
									&& entryObject.get("id") != null
									&& WsConstant.getEntryItem()
											.containsKey(
													entryObject.getBOSType()
															.toString())) {
								com.kingdee.bos.metadata.entity.EntityObjectInfo eo = WsCommonUtil
										.getEntityObjectInfo(ctx, entryObject
												.getBOSType().toString());
								if (eo != null) {
									Map itemMap = WsCommonImportUtil
											.getBillHeadProperties(eo);
									ICoreBase iLinkCoreBase = null;
									iLinkCoreBase = WsCommonUtil
											.getLocalInstance(ctx, eo);
									EntityViewInfo view = new EntityViewInfo();
									FilterInfo filter = new FilterInfo();
									FilterItemCollection fic = filter
											.getFilterItems();
									fic.add(new FilterItemInfo("id",
											entryObject.get("id").toString()));
									com.kingdee.bos.metadata.entity.SelectorItemCollection sic = view
											.getSelector();
									WsCommonUtil.setHeadSelectorItem(sic,
											itemMap);
									CoreBaseInfo itemEntryInfo = iLinkCoreBase
											.getValue(new ObjectUuidPK(
													entryObject.get("id")
															.toString()), sic);
									if (itemEntryInfo != null)
										entryObject = itemEntryInfo;
								}
							}
							jsonBuffer = (new StringBuilder())
									.append(jsonBuffer)
									.append(
											convertEntryInfoToJson((CoreBaseInfo) entryObject))
									.toString();
						} else {
							jsonBuffer = (new StringBuilder()).append(
									jsonBuffer).append(
									convertInfoToJson(entryObject)).toString();
						}
						if (nIndex < objectCollection.size() - 1)
							jsonBuffer = (new StringBuilder()).append(
									jsonBuffer).append(",").toString();
					}

					jsonBuffer = (new StringBuilder()).append(jsonBuffer)
							.append("]").toString();
				} else if (asSubClass(dataType,
						com.kingdee.util.enums.Enum.class)) {
					Enum result = (Enum) getObjectValue(objectValue,
							objectValue.getClass(), key);
					if (result == null)
						continue;
					jsonBuffer = (new StringBuilder()).append(jsonBuffer)
							.append(realKey).append(":").toString();
					jsonBuffer = (new StringBuilder()).append(jsonBuffer)
							.append("{").toString();
					jsonBuffer = (new StringBuilder())
							.append(jsonBuffer)
							.append(
									"${quote_2312415321232}isenum${quote_2312415321232}:true,")
							.toString();
					if (asSubClass(dataType,
							com.kingdee.util.enums.IntEnum.class)) {
						String strAlias = null;
						if (ctx.getLocale().equals(LocaleUtils.locale_l1))
							strAlias = ((IntEnum) result).getName();
						else
							strAlias = ((IntEnum) result).getAlias(ctx
									.getLocale());
						jsonBuffer = (new StringBuilder())
								.append(jsonBuffer)
								.append(
										"${quote_2312415321232}alias${quote_2312415321232}:${quote_2312415321232}")
								.append(strAlias).append(
										"${quote_2312415321232}").append(",")
								.toString();
						jsonBuffer = (new StringBuilder())
								.append(jsonBuffer)
								.append(
										"${quote_2312415321232}value${quote_2312415321232}:")
								.append(((IntEnum) result).getValue())
								.toString();
					} else if (asSubClass(dataType,
							com.kingdee.util.enums.FloatEnum.class)) {
						String strAlias = null;
						if (ctx.getLocale().equals(LocaleUtils.locale_l1))
							strAlias = ((FloatEnum) result).getName();
						else
							strAlias = ((FloatEnum) result).getAlias(ctx
									.getLocale());
						jsonBuffer = (new StringBuilder())
								.append(jsonBuffer)
								.append(
										"${quote_2312415321232}alias${quote_2312415321232}:${quote_2312415321232}")
								.append(strAlias).append(
										"${quote_2312415321232}").append(",")
								.toString();
						jsonBuffer = (new StringBuilder())
								.append(jsonBuffer)
								.append(
										"${quote_2312415321232}value${quote_2312415321232}:")
								.append(((FloatEnum) result).getValue())
								.toString();
					} else if (asSubClass(dataType,
							com.kingdee.util.enums.DoubleEnum.class)) {
						String strAlias = null;
						if (ctx.getLocale().equals(LocaleUtils.locale_l1))
							strAlias = ((DoubleEnum) result).getName();
						else
							strAlias = ((DoubleEnum) result).getAlias(ctx
									.getLocale());
						jsonBuffer = (new StringBuilder())
								.append(jsonBuffer)
								.append(
										"${quote_2312415321232}alias${quote_2312415321232}:${quote_2312415321232}")
								.append(strAlias).append(
										"${quote_2312415321232}").append(",")
								.toString();
						jsonBuffer = (new StringBuilder())
								.append(jsonBuffer)
								.append(
										"${quote_2312415321232}value${quote_2312415321232}:")
								.append(((DoubleEnum) result).getValue())
								.toString();
					} else if (asSubClass(dataType,
							com.kingdee.util.enums.StringEnum.class)) {
						String strAlias = null;
						if (ctx.getLocale().equals(LocaleUtils.locale_l1))
							strAlias = ((StringEnum) result).getName();
						else
							strAlias = ((StringEnum) result).getAlias(ctx
									.getLocale());
						jsonBuffer = (new StringBuilder())
								.append(jsonBuffer)
								.append(
										"${quote_2312415321232}alias${quote_2312415321232}:${quote_2312415321232}")
								.append(strAlias).append(
										"${quote_2312415321232}").append(",")
								.toString();
						jsonBuffer = (new StringBuilder())
								.append(jsonBuffer)
								.append(
										"${quote_2312415321232}value${quote_2312415321232}:${quote_2312415321232}")
								.append(((StringEnum) result).getValue())
								.append("${quote_2312415321232}").toString();
					}
					jsonBuffer = (new StringBuilder()).append(jsonBuffer)
							.append("}").toString();
				} else if (asSubClass(dataType,
						com.kingdee.bos.util.BOSUuid.class))
					jsonBuffer = (new StringBuilder()).append(jsonBuffer)
							.append(realKey).append(":").append(
									"${quote_2312415321232}").append(
									value.toString()).append(
									"${quote_2312415321232}").toString();
				else if (asSubClass(dataType, java.sql.Timestamp.class)) {
					SimpleDateFormat format = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss");
					if (value instanceof String)
						jsonBuffer = (new StringBuilder()).append(jsonBuffer)
								.append(realKey).append(":").append(
										"${quote_2312415321232}").append(value)
								.append("${quote_2312415321232}").toString();
					else
						jsonBuffer = (new StringBuilder()).append(jsonBuffer)
								.append(realKey).append(":").append(
										"${quote_2312415321232}").append(
										format.format((Date) value)).append(
										"${quote_2312415321232}").toString();
				} else if (asSubClass(dataType, java.util.Date.class)) {
					SimpleDateFormat format = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss");
					if (value instanceof String)
						jsonBuffer = (new StringBuilder()).append(jsonBuffer)
								.append(realKey).append(":").append(
										"${quote_2312415321232}").append(value)
								.append("${quote_2312415321232}").toString();
					else
						jsonBuffer = (new StringBuilder()).append(jsonBuffer)
								.append(realKey).append(":").append(
										"${quote_2312415321232}").append(
										format.format((Date) value)).append(
										"${quote_2312415321232}").toString();
				} else {
					jsonBuffer = (new StringBuilder()).append(jsonBuffer)
							.append(realKey).append(":").append(
									"${quote_2312415321232}").append(
									value.toString()).append(
									"${quote_2312415321232}").toString();
				}
				if (enumeration.hasMoreElements())
					jsonBuffer = (new StringBuilder()).append(jsonBuffer)
							.append(",").toString();
			} while (true);
			if (jsonBuffer.trim().endsWith(","))
				jsonBuffer = jsonBuffer.substring(0, jsonBuffer.length() - 1);
			jsonBuffer = (new StringBuilder()).append(jsonBuffer).append(
					"${rightbracket_2312415321232}").toString();
		} catch (Exception exception) {
			throw new BOSException(exception);
		}
		return jsonBuffer;
	}

	public Object deserialize1(JsonElement jsonelement, Type type,
			JsonDeserializationContext jsondeserializationcontext)
			throws JsonParseException {
		return deserialize(jsonelement, type, jsondeserializationcontext);
	}

	public JsonElement serialize(Object obj, Type type,
			JsonSerializationContext jsonserializationcontext) {
		return serialize((CoreBaseInfo) obj, type, jsonserializationcontext);
	}

	public static final String DATEFORMAT = "yyyy-MM-dd HH:mm:ss";
	private Context ctx;

}