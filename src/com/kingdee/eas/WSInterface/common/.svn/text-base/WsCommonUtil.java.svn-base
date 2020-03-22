package com.kingdee.eas.WSInterface.common;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.IMetaDataLoader;
import com.kingdee.bos.metadata.MetaDataLoaderFactory;
import com.kingdee.bos.metadata.entity.EntityObjectInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemCollection;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.basedata.assistant.KAClassficationCollection;
import com.kingdee.eas.basedata.assistant.KAClassficationFactory;
import com.kingdee.eas.basedata.assistant.KAClassficationInfo;
import com.kingdee.eas.basedata.master.auxacct.GeneralAsstActTypeFactory;
import com.kingdee.eas.basedata.master.auxacct.GeneralAsstActTypeInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerCollection;
import com.kingdee.eas.basedata.master.cssp.CustomerFactory;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.master.cssp.SupplierCollection;
import com.kingdee.eas.basedata.master.cssp.SupplierFactory;
import com.kingdee.eas.basedata.master.cssp.SupplierInfo;
import com.kingdee.eas.basedata.master.cssp.app.DataImportUtils;
import com.kingdee.eas.basedata.org.AdminOrgUnitCollection;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.CtrlUnitCollection;
import com.kingdee.eas.basedata.org.CtrlUnitFactory;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.PositionInfo;
import com.kingdee.eas.basedata.org.PositionMemberCollection;
import com.kingdee.eas.basedata.org.PositionMemberFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.basedata.ws.common.WsCommonXMLUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.ICoreBase;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.PropertyContainer;

// Referenced classes of package com.kingdee.eas.wmWs.app.common:
//            WsCommonXMLUtil

public class WsCommonUtil {
	static final Logger logger = Logger.getLogger("com.kingdee.eas.custom.WSInterface.common.WSCommonUtil");

	public WsCommonUtil() {
	}

	public static EntityObjectInfo getEntityObjectInfo(Context ctx, String bostype) {
		IMetaDataLoader loader = MetaDataLoaderFactory.getLocalMetaDataLoader(ctx);
		EntityObjectInfo eo = loader.getEntity(BOSObjectType.create(bostype));
		if (eo != null)
			return eo;
		else
			return null;
	}

	public static void validateHeadProperty(String bilHeadProps[], HashMap billHeadMap) throws Exception {
		if (bilHeadProps == null || bilHeadProps.length <= 0)
			return;
		for (int i = 0; i < bilHeadProps.length; i++)
			if (!validateProperty(billHeadMap, bilHeadProps[i]))
				throw new Exception("缺少必填项！"+String.valueOf(bilHeadProps[i]));//(new StringBuilder(String.valueOf(bilHeadProps[i]))).append(
						//EASResource.getString("com.kingdee.eas.yxws.common.WebSericeResource", "MUSTFILL")).toString());

	}

	public static void validateHeadProperty(String bilHeadProps[], CoreBaseInfo coreBaseInfo) throws Exception {
		if (bilHeadProps == null || bilHeadProps.length <= 0)
			return;
		for (int i = 0; i < bilHeadProps.length; i++)
			if (!validateProperty(coreBaseInfo, bilHeadProps[i]))
				throw new Exception("缺少必填项!"+String.valueOf(bilHeadProps[i]));//(new StringBuilder(String.valueOf(bilHeadProps[i]))).append(
						//EASResource.getString("com.kingdee.eas.yxws.common.WebSericeResource", "MUSTFILL")).toString());

	}

	private static boolean validateProperty(CoreBaseInfo coreBaseInfo, String prop) {
		if (coreBaseInfo == null || prop == null)
			return false;
		return coreBaseInfo.get(prop) != null;
	}

	private static boolean validateProperty(HashMap infoMap, String prop) {
		if (infoMap == null || prop == null)
			return false;
		return infoMap.get(prop) != null;
	}

	public static void validateEntiesProperty(String bilEntriesProps[], ArrayList billEntriesList) throws Exception {
		if (bilEntriesProps == null || bilEntriesProps.length <= 0)
			return;
		HashMap entryMap = null;
		for (int i = 0; i < billEntriesList.size(); i++) {
			entryMap = (HashMap) billEntriesList.get(i);
			for (int j = 0; j < bilEntriesProps.length; j++)
				if (!validateProperty(entryMap, bilEntriesProps[j]))
					throw new Exception("缺少必填项!"+String.valueOf(bilEntriesProps[j]));//(new StringBuilder(String.valueOf(bilEntriesProps[j]))).append(
							//EASResource.getString("com.kingdee.eas.yxws.common.WebSericeResource", "MUSTFILL"))
							//.toString());

		}

	}

	public static void setStrProperties(PropertyContainer info, String notBuild[], String porpertyName,
			HashMap billHeadMap) {
		if (isBuildLinkInfo(porpertyName, notBuild))
			info.setString(porpertyName, (String) billHeadMap.get(porpertyName));
	}

	public static Short getShortProperties(PropertyContainer info, String porpertyName) {
		return Short.valueOf(info.getShort(porpertyName));
	}

	public static Float getFloatProperties(PropertyContainer info, String porpertyName) {
		return Float.valueOf(info.getFloat(porpertyName));
	}

	public static Double getDoubleProperties(PropertyContainer info, String porpertyName) {
		return Double.valueOf(info.getDouble(porpertyName));
	}

	public static Long getLongProperties(PropertyContainer info, String porpertyName) {
		return Long.valueOf(info.getLong(porpertyName));
	}

	public static String getStrProperties(PropertyContainer info, String porpertyName) {
		return info.getString(porpertyName);
	}

	public static String getBOSUuidProperties(PropertyContainer info, String porpertyName) {
		BOSUuid id = info.getBOSUuid(porpertyName);
		if (id != null)
			return id.toString();
		else
			return null;
	}

	public static void setBooleanProperties(PropertyContainer info, String notBuild[], String porpertyName,
			HashMap billHeadMap) throws Exception {
		try {
			if (isBuildLinkInfo(porpertyName, notBuild)) {
				boolean boolValue = false;
				String propValue = null;
				propValue = (String) billHeadMap.get(porpertyName);
				if (propValue != null && (propValue.equals("1") || propValue.equals("true")))
					boolValue = true;
				else
					boolValue = false;
				info.setBoolean(porpertyName, boolValue);
			}
		} catch (Exception e) {
			throw new Exception((new StringBuilder(String.valueOf(porpertyName))).append(": ").append("值不正确！").toString());
					//.append(EASResource.getString("com.kingdee.eas.yxws.common.WebSericeResource", "VALUEERROR")).toString());
		}
	}

	public static int getBooleanProperties(PropertyContainer info, String porpertyName) {
		boolean boolvalue = info.getBoolean(porpertyName);
		return !boolvalue ? 0 : 1;
	}

	public static void setIntProperties(PropertyContainer info, String porpertyName, HashMap billHeadMap)
			throws Exception {
		try {
			String value = null;
			if (billHeadMap.get(porpertyName) == null)
				value = "0";
			else
				value = (String) billHeadMap.get(porpertyName);
			info.setInt(porpertyName, Integer.parseInt(value));
		} catch (Exception e) {
			throw new Exception((new StringBuilder(String.valueOf(porpertyName))).append(": ").append("值不正确！").toString());//.append(
					//EASResource.getString("com.kingdee.eas.yxws.common.WebSericeResource", "VALUEERROR")).toString());
		}
	}

	public static int getIntProperties(PropertyContainer info, String porpertyName) {
		return info.getInt(porpertyName);
	}

	public static void setDeciamlProperties(PropertyContainer info, String propertyName, HashMap billHeadMap)
			throws Exception {
		try {
			String value = null;
			if (billHeadMap.get(propertyName) != null) {
				value = (String) billHeadMap.get(propertyName);
				info.setBigDecimal(propertyName, new BigDecimal(value));
			}
		} catch (Exception e) {
			throw new Exception((new StringBuilder()).append(propertyName).append(": ").append("值不正确！").toString());//.append(
					//EASResource.getString("com.kingdee.eas.yxws.common.WebSericeResource", "VALUEERROR")).toString());
		}
	}

	public static BigDecimal getDeciamlProperties(PropertyContainer info, String propertyName) {
		BigDecimal value = info.getBigDecimal(propertyName);
		return value;
	}

	public static void seTimeStampProperties(PropertyContainer info, String propertyName, HashMap billHeadMap)
			throws Exception {
		Timestamp timeStamp = null;
		try {
			timeStamp = getTimeStampFromStr((String) billHeadMap.get(propertyName));
			info.setTimestamp(propertyName, timeStamp);
		} catch (Exception e) {
			throw new Exception((new StringBuilder(String.valueOf(propertyName))).append(": ").append("值不正确！").toString());//.append(
					//EASResource.getString("com.kingdee.eas.yxws.common.WebSericeResource", "VALUEERROR")).toString());
		}
	}

	private static Timestamp getTimeStampFromStr(String timeStr) throws Exception {
		if (timeStr != null)
			return Timestamp.valueOf(timeStr);
		else
			return null;
	}

	public static String getTimeStatmpProperties(PropertyContainer info, String propertyName) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Timestamp timestamp = info.getTimestamp(propertyName);
		if (timestamp != null)
			return dateFormat.format(timestamp);
		else
			return "";
	}

	public static void setDateProperties(PropertyContainer info, String propertyName, HashMap billHeadMap)
			throws Exception {
		Date date = null;
		try {
			date = convertStrToDate((String) billHeadMap.get(propertyName), "yyyy-MM-dd");
			info.setDate(propertyName, date);
		} catch (Exception e) {
			throw new Exception((new StringBuilder(String.valueOf(propertyName))).append(": ").append("值不正确！").toString());
			//.append(EASResource.getString("com.kingdee.eas.yxws.common.WebSericeResource", "VALUEERROR")).toString());
		}
	}

	private static Date convertStrToDate(String strDate, String parttern) throws Exception {
		if (strDate != null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat(parttern);
			return dateFormat.parse(strDate);
		} else {
			return null;
		}
	}

	public static String getDateProperties(PropertyContainer info, String propertyName) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = info.getDate(propertyName);
		if (date != null)
			return dateFormat.format(date);
		else
			return "";
	}

	public static void setLinkProperties(Context ctx, PropertyContainer info, String mustHeadPros[],
			String propertyName, Object linkeo, String notBuild[], HashMap billHeadMap, String cuId) throws Exception {
		CoreBaseInfo linkBaseInfo = null;
		String number;
		EntityObjectInfo eo;
		try {
			number = (String) billHeadMap.get(propertyName);
			if (number == null || "".equals(number))
				return;
		} catch (Exception e) {
			throw new Exception((new StringBuilder(String.valueOf(propertyName))).append(": ").append("值不正确！").toString());//.append(
					//EASResource.getString("com.kingdee.eas.yxws.common.WebSericeResource", "VALUEERROR")).toString());
		}
		if (isBuildLinkInfo(propertyName, notBuild)) {
			eo = (EntityObjectInfo) linkeo;
			linkBaseInfo = getLinkPropCoreBaseInfo(ctx, eo, number, "");
			if (linkBaseInfo == null && isMustValidateProperty(propertyName, mustHeadPros))
				throw new Exception((new StringBuilder(String.valueOf(eo.getAlias()))).append("关系不存在！").toString());//.append(
						//EASResource.getString("com.kingdee.eas.yxws.common.WebSericeResource", "LINKNOTEXSIT"))
						//.toString());
			info.put(propertyName, linkBaseInfo);
		}
	}

	public static String getLinkProperties(Context ctx, PropertyContainer info, String propertyName, EntityObjectInfo eo)
			throws BOSException {
		Object obj = info.get(propertyName);
		String number = "";
		if (obj != null && (obj instanceof PropertyContainer)) {
			PropertyContainer cinfo = (PropertyContainer) obj;
			Object numbers = cinfo.get("number");
			if (cinfo != null && numbers != null)
				number = numbers.toString();
			else if (cinfo != null && numbers == null) {
				String id = cinfo.get("id").toString();
				number = getCoreBaseNumber(ctx, id, eo);
			}
		}
		return number;
	}

	private static boolean isBuildLinkInfo(String proName, String notBuildPros[]) {
		if (notBuildPros == null || notBuildPros.length <= 0)
			return true;
		int i = 0;
		for (int count = notBuildPros.length; i < count; i++)
			if (proName.equals(notBuildPros[i]))
				return false;

		return true;
	}

	public static boolean isMustValidateProperty(String propName, String musValidateProp[]) {
		if (musValidateProp == null || musValidateProp.length <= 0)
			return false;
		for (int i = 0; i < musValidateProp.length; i++)
			if (musValidateProp[i].equals(propName))
				return true;

		return false;
	}

	private static CoreBaseInfo getLinkPropCoreBaseInfo(Context ctx, EntityObjectInfo linkEo, String number, String cuId)
			throws BOSException {
		return getCoreBaseInfo(ctx, linkEo, number, cuId);
	}

	public static void validateNumber(Context ctx, EntityObjectInfo linkEo, String number) throws Exception {
		CoreBaseInfo linkInfo = null;
		linkInfo = getCoreBaseInfo(ctx, linkEo, number, "");
		if (linkInfo != null)
			throw new Exception("基础资料已经存在");//DataImportUtils.getResource("com.kingdee.eas.yxws.common.WebSericeResource",
					//"BASEDATAEXIST", ctx));
		else
			return;
	}

	public static void validateNumber(Context ctx, EntityObjectInfo linkEo, String number, String cuid)
			throws Exception {
		if (linkEo.getTable() != null) {
			String table = linkEo.getTable().getName();
			if (table != null && !"".equals(table)) {
				String sql = (new StringBuilder("select fid,fnumber from ")).append(table).append(" where fnumber='")
						.append(number).append("'").toString();
				if (cuid != null && cuid.trim().length() > 0)
					sql = (new StringBuilder(String.valueOf(sql))).append(" and FControlUnitID='").append(cuid).append(
							"'").toString();
				IRowSet set = DbUtil.executeQuery(ctx, sql);
				if (set != null && set.size() > 0)
					throw new Exception("基础资料已经存在");//DataImportUtils.getResource("com.kingdee.eas.yxws.common.WebSericeResource",
							//"BASEDATAEXIST", ctx));
			}
		}
	}

	public static CoreBaseInfo validateBill(Context ctx, EntityObjectInfo eo, int attributeName, String billNumber,
			String cuid, CoreBaseInfo info) throws Exception {
		if (attributeName == 0 || 1 == attributeName || 2 == attributeName) {
			info = getCoreBaseInfo(ctx, eo, billNumber, "");
			if (info == null)
				throw new Exception("基础资料不存在！");
			if (1 == attributeName)
				info.put("deletedStatus", Integer.valueOf(1));
			else if (2 == attributeName)
				info.put("deletedStatus", Integer.valueOf(2));
		} else {
			validateNumber(ctx, eo, billNumber);
		}
		return info;
	}

	public static CoreBaseInfo validateBills(Context ctx, EntityObjectInfo eo, String attributeName, String billNumber,
			String cuid, CoreBaseInfo info) throws Exception {
		if (attributeName != null && "0".equals(attributeName)) {
			info = getCoreBaseInfo(ctx, eo, billNumber, "");
			if (info == null)
				throw new Exception("基础资料已经存在！");
		} else {
			validateNumber(ctx, eo, billNumber);
		}
		return info;
	}

	public static void operationBill(Context ctx, EntityObjectInfo eo, CoreBaseInfo info, String opAttributeName,
			Map headPro, Map map, String statusName) throws EASBizException, BOSException {
		ICoreBase iCoreBase = null;
		if (eo != null) {
			iCoreBase = getLocalInstance(ctx, eo);
			if (opAttributeName != null)
				if ("0".equals(opAttributeName) || "1".equals(opAttributeName) || "2".equals(opAttributeName)
						|| "5".equals(opAttributeName)) {
					SelectorItemCollection selector = new SelectorItemCollection();
					if (info.get("name") != null && !"".equals(info.get("name"))) {
						String name = info.get("name").toString().replaceAll("(^[ |\u3000]*|[ |\u3000]*$)", "");
						info.put("name", name);
					}
					info.put("name", info.get("name"));
					info.put("name", info.get("name", new Locale("L1", "")), new Locale("L1", ""));
					info.put("name", info.get("name", new Locale("L2", "")), new Locale("L2", ""));
					info.put("name", info.get("name", new Locale("L3", "")), new Locale("L3", ""));
					if ("0".equals(opAttributeName)) {
						iCoreBase.update(new ObjectUuidPK(info.getId()), info);
					} else {
						selector.add(new SelectorItemInfo(statusName));
						iCoreBase.updatePartial(info, selector);
					}
				} else if ("3".equals(opAttributeName))
					iCoreBase.save(info);
				else if ("4".equals(opAttributeName))
					iCoreBase.submit(info);
		}
	}

	public static void operationBills(Context ctx, EntityObjectInfo eo, CoreBaseInfo info, String opAttributeName,
			Map headPro, Map map) throws EASBizException, BOSException {
		ICoreBase iCoreBase = null;
		if (eo != null) {
			iCoreBase = getLocalInstance(ctx, eo);
			if (opAttributeName != null)
				if ("0".equals(opAttributeName)) {
					SelectorItemCollection selector = new SelectorItemCollection();
					setHeadSelectorItem(selector, getSelectorMap(headPro, map));
					if (info.get("name") != null && !"".equals(info.get("name"))) {
						String name = info.get("name").toString().replaceAll("(^[ |\u3000]*|[ |\u3000]*$)", "");
						info.put("name", name);
					}
					info.put("name", info.get("name"));
					info.put("name", info.get("name", new Locale("L1", "")), new Locale("L1", ""));
					info.put("name", info.get("name", new Locale("L2", "")), new Locale("L2", ""));
					info.put("name", info.get("name", new Locale("L3", "")), new Locale("L3", ""));
					iCoreBase.update(new ObjectUuidPK(info.getId()), info);
				} else if ("3".equals(opAttributeName))
					iCoreBase.save(info);
				else if ("4".equals(opAttributeName))
					iCoreBase.submit(info);
		}
	}

	public static CoreBaseInfo getCoreBaseInfo(Context ctx, EntityObjectInfo eo, String cnNumber, String cuId)
			throws BOSException {
		ICoreBase iLinkCoreBase = null;
		CoreBaseInfo corebaseinfo = null;
		if (eo != null && cnNumber != null) {
			iLinkCoreBase = getLocalInstance(ctx, eo);
			if (cuId != null && cuId.trim().length() > 0)
				corebaseinfo = getCoreBaseInfo(iLinkCoreBase, cnNumber, cuId);
			else
				corebaseinfo = getCoreBaseInfo(iLinkCoreBase, cnNumber);
		}
		return corebaseinfo;
	}

	public static CtrlUnitInfo getCuInfo(Context ctx, String cuNumber) throws Exception {
		if (cuNumber == null || "".equals(cuNumber))
			return null;
		CtrlUnitCollection col = CtrlUnitFactory.getLocalInstance(ctx).getCtrlUnitCollection(
				(new StringBuilder("select * where number='")).append(cuNumber).append("'").toString());
		if (col != null && col.size() > 0)
			return col.get(0);
		else
			return null;
	}

	private static CoreBaseInfo getCoreBaseInfo(ICoreBase iDataBase, String number) throws BOSException {
		String fields[] = { "number" };
		String values[] = { number };
		EntityViewInfo view = getEntityViewInfo(fields, values);
		return getCoreBaseInfo(iDataBase, view);
	}

	private static CoreBaseInfo getCoreBaseInfo(ICoreBase iDataBase, String number, String cuId) throws BOSException {
		if (cuId == null || cuId.trim().length() == 0) {
			return getCoreBaseInfo(iDataBase, number);
		} else {
			String fields[] = { "number", "CU" };
			String values[] = { number, cuId };
			EntityViewInfo view = getEntityViewInfo(fields, values);
			return getCoreBaseInfo(iDataBase, view);
		}
	}

	private static String getCoreBaseNumber(Context ctx, String id, EntityObjectInfo eo) throws BOSException {
		ICoreBase iLinkCoreBase = null;
		CoreBaseInfo corebaseinfo = null;
		if (eo != null && id != null) {
			iLinkCoreBase = getLocalInstance(ctx, eo);
			EntityViewInfo view = new EntityViewInfo();
			SelectorItemCollection sic = view.getSelector();
			sic.add(new SelectorItemInfo("id"));
			sic.add(new SelectorItemInfo("number"));
			FilterInfo filter = new FilterInfo();
			FilterItemCollection fic = filter.getFilterItems();
			fic.add(new FilterItemInfo("id", id, CompareType.EQUALS));
			view.setFilter(filter);
			CoreBaseCollection coreBaseCollection = iLinkCoreBase.getCollection(view);
			if (coreBaseCollection != null) {
				corebaseinfo = coreBaseCollection.get(0);
				if (corebaseinfo != null && corebaseinfo.get("number") != null)
					return corebaseinfo.get("number").toString();
			}
		}
		return null;
	}

	private static EntityViewInfo getEntityViewInfo(String fields[], String fieldsValue[]) {
		EntityViewInfo view = new EntityViewInfo();
		SelectorItemCollection sic = view.getSelector();
		if (fields != null && fieldsValue != null && fields.length >= fieldsValue.length) {
			sic.add(new SelectorItemInfo("*"));
			FilterInfo filter = new FilterInfo();
			FilterItemCollection fic = filter.getFilterItems();
			for (int j = 0; j < fields.length && j < fieldsValue.length; j++)
				fic.add(new FilterItemInfo(fields[j], fieldsValue[j].trim(), CompareType.EQUALS));

			view.setFilter(filter);
		}
		return view;
	}

	public static CoreBaseInfo getCoreBaseInfo(ICoreBase iDataBase, EntityViewInfo view) throws BOSException {
		CoreBaseInfo coreBaseInfo = null;
		if (iDataBase != null) {
			CoreBaseCollection coreBaseCollection = iDataBase.getCollection(view);
			if (coreBaseCollection != null && coreBaseCollection.size() > 0)
				coreBaseInfo = coreBaseCollection.get(0);
		}
		return coreBaseInfo;
	}

	public static ICoreBase getLocalInstance(Context ctx, EntityObjectInfo eo) {
		ICoreBase iCoreBase = null;
		try {
			Class cls = Class.forName(eo.getBusinessImplFactory());
			Method mtd = cls.getMethod("getLocalInstance", new Class[] {com.kingdee.bos.Context.class });
			iCoreBase = (ICoreBase) mtd.invoke(cls, new Object[] { ctx });
		} catch (Exception e) {
			logger.error(e);
		}
		return iCoreBase;
	}

	public static void setHeadSelectorItem(SelectorItemCollection selector, Map headMap) {
		for (Iterator strit = headMap.entrySet().iterator(); strit.hasNext();) {
			java.util.Map.Entry et = (java.util.Map.Entry) strit.next();
			String propertyName = et.getKey().toString();
			Object value = et.getValue();
			if (value instanceof EntityObjectInfo) {
				selector.add(new SelectorItemInfo((new StringBuilder(String.valueOf(propertyName))).append(".id")
						.toString()));
				selector.add(new SelectorItemInfo((new StringBuilder(String.valueOf(propertyName))).append(".number")
						.toString()));
			} else {
				selector.add(new SelectorItemInfo(propertyName));
			}
		}

	}

	public static void setEntrySelectorItem(SelectorItemCollection selector, String entryname, Map entiesMap) {
		for (Iterator strit = entiesMap.entrySet().iterator(); strit.hasNext();) {
			java.util.Map.Entry et = (java.util.Map.Entry) strit.next();
			String propertyName = et.getKey().toString();
			Object value = et.getValue();
			propertyName = (new StringBuilder(String.valueOf(entryname))).append(".").append(propertyName).toString();
			if (value instanceof EntityObjectInfo) {
				selector.add(new SelectorItemInfo((new StringBuilder(String.valueOf(propertyName))).append(".id")
						.toString()));
				selector.add(new SelectorItemInfo((new StringBuilder(String.valueOf(propertyName))).append(".number")
						.toString()));
			} else {
				selector.add(new SelectorItemInfo(propertyName));
			}
		}

	}

	public static Map getSelectorMap(Map xmlHeadPro, Map headMap) {
		for (Iterator strit = headMap.entrySet().iterator(); strit.hasNext();) {
			java.util.Map.Entry et = (java.util.Map.Entry) strit.next();
			String propertyName = et.getKey().toString();
			Object value = et.getValue();
			if (xmlHeadPro.containsKey(propertyName))
				xmlHeadPro.put(propertyName, value);
		}

		return xmlHeadPro;
	}

	public static PositionInfo getPrimaryPositionInfo(PersonInfo personInfo, Context ctx) {
		PositionInfo positionInfo = null;
		try {
			if (personInfo != null) {
				String id = personInfo.getId().toString();
				if (!"".equals(id)) {
					String sql = (new StringBuilder(
							"select id, position.id, position.number, position.name,  position.adminOrgUnit.id, position.adminOrgUnit.number, position.adminOrgUnit.name,position.adminOrgUnit.longNumber, position.adminOrgUnit.isCompanyOrgUnit, position.adminOrgUnit.isCostOrgUnit where  isPrimary=1 and person.id='"))
							.append(id).append("'").toString();
					PositionMemberCollection positionMemberCollection = PositionMemberFactory.getLocalInstance(ctx)
							.getPositionMemberCollection(sql);
					if (positionMemberCollection != null && positionMemberCollection.size() > 0
							&& positionMemberCollection.get(0).getPosition() != null)
						positionInfo = positionMemberCollection.get(0).getPosition();
				}
			}
		} catch (BOSException e) {
			logger.error(e.getMessage());
		}
		return positionInfo;
	}

	public static CompanyOrgUnitInfo getCompanyOrgUnitInfo(AdminOrgUnitInfo adminOrgUnitInfo, Context ctx) {
		CompanyOrgUnitInfo companyOrgUnitInfo = null;
		if (adminOrgUnitInfo != null) {
			if (!isCompany(adminOrgUnitInfo))
				adminOrgUnitInfo = getSuperiorAdminOrgUnitInfo(adminOrgUnitInfo, ctx);
			if (adminOrgUnitInfo != null) {
				companyOrgUnitInfo = new CompanyOrgUnitInfo();
				companyOrgUnitInfo.setId(adminOrgUnitInfo.getId());
				companyOrgUnitInfo.setNumber(adminOrgUnitInfo.getNumber());
				companyOrgUnitInfo.setName(adminOrgUnitInfo.getName());
				companyOrgUnitInfo.setLongNumber(adminOrgUnitInfo.getLongNumber());
			}
		}
		return companyOrgUnitInfo;
	}

	private static boolean isCompany(AdminOrgUnitInfo adminOrgUnitInfo) {
		boolean flag = false;
		if (adminOrgUnitInfo != null && adminOrgUnitInfo.isIsCompanyOrgUnit())
			flag = true;
		return flag;
	}

	private static AdminOrgUnitInfo getSuperiorAdminOrgUnitInfo(AdminOrgUnitInfo adminOrgUnitInfo, Context ctx) {
		if (adminOrgUnitInfo != null) {
			String id = adminOrgUnitInfo.getId().toString();
			if (!"".equals(id)) {
				String sql = (new StringBuilder(
						"select id, parent.id, parent.number, parent.name, parent.longNumber, parent.isCompanyOrgUnit where id='"))
						.append(id).append("'").toString();
				AdminOrgUnitCollection adminOrgUnitCollection = null;
				try {
					adminOrgUnitCollection = AdminOrgUnitFactory.getLocalInstance(ctx).getAdminOrgUnitCollection(sql);
				} catch (BOSException e) {
					logger.error(e.getMessage());
					e.printStackTrace();
				}
				if (adminOrgUnitCollection != null && adminOrgUnitCollection.size() > 0)
					adminOrgUnitInfo = adminOrgUnitCollection.get(0).getParent();
			}
			return adminOrgUnitInfo;
		} else {
			return null;
		}
	}

	public static String[] getTargetCUNumber(ArrayList list) throws Exception {
		String targetnum[] = (String[]) null;
		if (list != null) {
			targetnum = new String[list.size()];
			HashMap cunumber = null;
			int i = 0;
			for (int count = list.size(); i < count; i++) {
				cunumber = null;
				cunumber = (HashMap) list.get(i);
				String number = (String) cunumber.get("cuNumber");
				targetnum[i] = WsCommonXMLUtil.getCUtNumberByXML(number);
			}

		}
		return targetnum;
	}

	public static void setPropertyNumberByXml(Context ctx, Map headMap, String proName, String codefile)
			throws Exception {
		if (headMap.get(proName) != null && !"".equals((String) headMap.get(proName))) {
			String number = WsCommonXMLUtil.gePropertyNumberByXML(ctx, (String) headMap.get(proName), codefile);
			if (number != null && !"".equals(number))
				headMap.put(proName, number);
		}
	}

	public static CustomerInfo getCustomerInfo(Context ctx, String number, String cuId) throws Exception {
		CustomerInfo customerInfo = null;
		if (number != null && !"".equals(number))
			try {
				String sql = (new StringBuilder("select * where number='")).append(number).append("'").toString();
				if (cuId != null && !"".equals(cuId)) {
					sql = "";
					sql = (new StringBuilder("select * where number='")).append(number).append("' and CU.id='").append(
							cuId).append("'").toString();
				}
				CustomerCollection col = CustomerFactory.getLocalInstance(ctx).getCustomerCollection(sql);
				if (col != null && col.size() > 0)
					customerInfo = col.get(0);
			} catch (BOSException e) {
				throw new Exception(DataImportUtils.getResource("com.kingdee.eas.yxws.common.WebSericeResource",
						"CUSTOMERNOTEXISTS", ctx));
			}
		return customerInfo;
	}

	public static SupplierInfo getSupplierInfo(Context ctx, String number, String cuId) throws Exception {
		SupplierInfo supplierInfo = null;
		if (number != null && !"".equals(number))
			try {
				String sql = (new StringBuilder("select * where number='")).append(number).append("'").toString();
				if (cuId != null && !"".equals(cuId)) {
					sql = "";
					sql = (new StringBuilder("select * where number='")).append(number).append("' and CU.id='").append(
							cuId).append("'").toString();
				}
				SupplierCollection col = SupplierFactory.getLocalInstance(ctx).getSupplierCollection(sql);
				if (col != null && col.size() > 0)
					supplierInfo = col.get(0);
			} catch (BOSException e) {
				throw new Exception(DataImportUtils.getResource("com.kingdee.eas.yxws.common.WebSericeResource",
						"SUPPLIERNOTEXISTS", ctx));
			}
		return supplierInfo;
	}

	public static void refCode(Context ctx, Map headMap, Map refMap) throws Exception {
		if (refMap != null && refMap.size() > 0) {
			String key;
			String value;
			for (Iterator strit = refMap.entrySet().iterator(); strit.hasNext(); setPropertyNumberByXml(ctx, headMap,
					key, value)) {
				java.util.Map.Entry et = (java.util.Map.Entry) strit.next();
				key = et.getKey().toString();
				value = et.getValue().toString();
			}

		}
	}

	public static KAClassficationInfo getDefaultAccountClass(String type, String comID, String accountTableId,
			Context ctx) throws Exception {
		String typeID = "";
		if (comID == null)
			comID = "";
		if (accountTableId == null)
			accountTableId = "";
		if (type.equals("customer"))
			typeID = "7ac99937-00fb-2000-e000-0002c0a81345B999CA39";
		else if (type.equals("supplier"))
			typeID = "7ac99937-00fb-3000-e000-0002c0a81345B999CA39";
		EntityViewInfo evi = new EntityViewInfo();
		evi.getSelector().add(new SelectorItemInfo("id"));
		evi.getSelector().add(new SelectorItemInfo("number"));
		evi.getSelector().add(new SelectorItemInfo("name"));
		FilterInfo filterInfo = new FilterInfo();
		filterInfo.getFilterItems().add(new FilterItemInfo("typelink.objectType.id", typeID, CompareType.EQUALS));
		filterInfo.getFilterItems().add(new FilterItemInfo("currencyCompany.id", comID, CompareType.EQUALS));
		filterInfo.getFilterItems().add(new FilterItemInfo("accountTableId.id", accountTableId, CompareType.EQUALS));
		StringBuffer sql = new StringBuffer(100);
		sql
				.append("select min(k.fnumber) from t_bd_kaclassfication k inner join t_bd_kaclassficationtype kt on k.ftypelink=kt.fid where ");
		sql.append(" kt.fobjecttypeid='").append(typeID).append("'");
		sql.append(" and k.fcurrencycompany='").append(comID).append("'");
		sql.append(" and k.faccounttableid='").append(accountTableId).append("'");
		filterInfo.getFilterItems().add(new FilterItemInfo("number", sql.toString(), CompareType.INNER));
		filterInfo.setMaskString("#0 and #1 and #2 and #3");
		evi.setFilter(filterInfo);
		KAClassficationInfo kaClassficationInfo = null;
		KAClassficationCollection collection = KAClassficationFactory.getLocalInstance(ctx)
				.getKAClassficationCollection(evi);
		if (collection.size() > 0)
			kaClassficationInfo = collection.get(0);
		return kaClassficationInfo;
	}
	
	/**
	 * 更新单据编码
	 * @param ctx
	 * @param tableName
	 * @param id
	 * @param newNumber
	 * @throws BOSException 
	 */
	public static void updateBillNumber(Context ctx,String tableName,String id,String newNumber) throws BOSException{
		StringBuilder upSql = new StringBuilder("update ");
		upSql.append(tableName);
		upSql.append(" set fnumber='");
		upSql.append(newNumber);
		upSql.append("' where fid='");
		upSql.append(id);
		upSql.append("'");
		
		DbUtil.execute(ctx, upSql.toString());
	}

	/**
	 * 根据 自定义核算项目编码或者长编码获得自定义核算项目
	 * @param ctx
	 * @param number
	 * @return
	 * @throws BOSException 
	 */
	public GeneralAsstActTypeInfo getGAATInfoByNumber(Context ctx,String number) throws BOSException{
		GeneralAsstActTypeInfo info = null;
		try{
			String sql = "select fid from T_BD_GeneralAsstActType where fnumber=? or flongnumber =?";
			String[] args = {number,number};
			IRowSet  rs = DbUtil.executeQuery(ctx, sql, args);
			if(rs != null){
				if(rs.next()){
					String fid = rs.getString("fid");
					info = GeneralAsstActTypeFactory.getLocalInstance(ctx).getGeneralAsstActTypeInfo(new ObjectUuidPK(fid));
					
				}
//				if(rs.size() > 1){
//					throw new BOSException("");
//				}
			}
		}catch(SQLException e){
			throw new BOSException(e);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BOSException(e);
		}
		
		
		return info;
	}
}
