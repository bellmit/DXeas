package com.kingdee.eas.WSInterface.common;

import org.apache.log4j.Logger;

import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.access.MetaDataAccessFactory;
import com.kingdee.bos.metadata.access.entity.EntitySelect;
import com.kingdee.bos.metadata.access.entity.SimpleEntity;
import com.kingdee.bos.metadata.access.entity.SimpleProperty;
import com.kingdee.bos.metadata.access.entity.SimplePropertyCollection;
import com.kingdee.bos.util.BOSObjectType;

public class MultiLangUtils {

	public MultiLangUtils() {
	}

	public static boolean isMultiLangEntityProperty(Context ctx, BOSObjectType bosObjectType, String property) {
		SimpleProperty propertyObject;
		EntitySelect select = new EntitySelect(bosObjectType);
		select.propertySelect().selectOwnProperty(new String[] { property }, new String[] { "isMultilingual" });
		try {
			SimpleEntity entity = MetaDataAccessFactory.getLocalInstance(ctx).select(select);
			propertyObject = entity.property(property);
			return propertyObject != null && propertyObject.getBoolean("isMultilingual");
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isMultiLangValueFormat(String text) {
		if (text == null)
			return false;
		return text.startsWith("{") && text.endsWith("}");
	}

	public static SimplePropertyCollection getAllProperties(Context ctx, BOSObjectType bosObjectType) {
		SimpleEntity entity;
		try {
			EntitySelect select = new EntitySelect(bosObjectType);
			select.propertySelect().select("*", "name,alias,description,dataType,relationship");
			entity = MetaDataAccessFactory.getLocalInstance(ctx).select(select);
			return entity.properties();
		} catch (Exception e) {
			return null;
		}
	}

	protected static Logger logger = Logger.getLogger("com.kingdee.eas.custom.WSInterface.common.MultiLangUtils");

}
