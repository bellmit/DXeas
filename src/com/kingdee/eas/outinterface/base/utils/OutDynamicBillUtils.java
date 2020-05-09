package com.kingdee.eas.outinterface.base.utils;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.Ostermiller.util.Base64;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.IQueryExecutor;
import com.kingdee.bos.dao.query.QueryExecutorFactory;
import com.kingdee.bos.framework.DynamicObjectFactory;
import com.kingdee.bos.framework.IDynamicObject;
import com.kingdee.bos.metadata.IMetaDataLoader;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.MetaDataLoaderFactory;
import com.kingdee.bos.metadata.MetaDataPK;
import com.kingdee.bos.metadata.entity.DataType;
import com.kingdee.bos.metadata.entity.EntityObjectInfo;
import com.kingdee.bos.metadata.entity.LinkPropertyInfo;
import com.kingdee.bos.metadata.entity.OwnPropertyInfo;
import com.kingdee.bos.metadata.entity.PropertyInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.ICoreBase;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.enums.Enum;
import com.kingdee.util.enums.EnumUtils;
import com.kingdee.util.enums.FloatEnum;
import com.kingdee.util.enums.IntEnum;
import com.kingdee.util.enums.LongEnum;
import com.kingdee.util.enums.StringEnum;

public class OutDynamicBillUtils {
private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private static Logger logger =
        Logger.getLogger("com.kingdee.eas.outinterface.base.utils.OutDynamicBillUtils");
	
	/**
	 * ��ȡ����ժҪ --��̬��������
	 * @param ctx
	 * @param param ����json�ַ���
	 * @param withData �Ƿ�Я����������
	 * @return
	 * @throws BOSException
	 */
	public static String getBillDigest(Context ctx, String param,boolean withData)throws BOSException
	{
		JSONObject jsonParam=JSONObject.parseObject(param);
		JSONObject resultJson = new JSONObject();
		resultJson.put("result", true);

		String billID = jsonParam.getString("billID");

		BOSObjectType bosType = BOSUuid.read(billID).getType();
		IMetaDataLoader loader = MetaDataLoaderFactory.getLocalMetaDataLoader(ctx);
		IMetaDataPK te=loader.getEntityObjectPK(bosType);

		EntityObjectInfo eo = getEntityObject(ctx, bosType.toString());

		HashMap<String, LinkedHashMap<String,Object>> entryPropMap=new HashMap<String,  LinkedHashMap<String,Object>>();//��¼����
		//��ѯ����
		SelectorItemCollection selector=new SelectorItemCollection();

		StringBuffer sql=new StringBuffer();
		sql.append(" select * from T_WM_BillDigest ")
		.append(" where FMetadataPK='").append(te.getFullName()).append("'")
		.append(" order by FIndex asc");
		JSONObject dataJSON=new JSONObject();
		JSONObject jo;
		String propGroup,proName;
		try {
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()) {
				propGroup=rs.getString("FPropertyGroup");
				proName=rs.getString("FPropertyName");

				selector.add(proName);

				jo=new JSONObject();
				jo.put("propertyGroup", propGroup);//����
				jo.put("propertyName", proName);//�ֶ�������
				jo.put("index", rs.getInt("Findex"));//˳��
				jo.put("showFormate", rs.getString("FShowFormate"));//��ʾ��ʽ
				jo.put("editable", rs.getString("FEditable"));//�Ƿ���޸�
				jo.put("displayName", rs.getString("FAlias_l2"));//��ʾ����
				jo.put("value", "");//ֵ
				jo.put("dataType", "");
				//�Ƿ�¼
				if(StringUtils.isBlank(propGroup)) {
					if(StringUtils.isNotBlank(proName)) {
						dataJSON.put(proName, jo);
					}
				}
				//��¼
				else {
					if(!entryPropMap.containsKey(propGroup)){
						entryPropMap.put(propGroup, new LinkedHashMap<String,Object>());
					}
					if(StringUtils.isNotBlank(proName)) {
						selector.add(propGroup + "." + proName);
						entryPropMap.get(propGroup).put(proName,jo.toString());
					}
				}
			}
		} catch (Exception e) {
			throw new BOSException(e);
		}

		//������*************
		//		selector.add("creator.name");
		//		selector.add("number");
		//		selector.add("Entrys.weighBillType");
		//		selector.add("Entrys.isAuto2Inv");
		//		dataJSON.put("creator.name", new JSONObject());
		//		dataJSON.put("number", new JSONObject());
		//		
		//		entryPropMap.put("Entrys", new LinkedHashMap<String,Object>());
		//		((LinkedHashMap)entryPropMap.get("Entrys")).put("weighBillType", new JSONObject());
		//		((LinkedHashMap)entryPropMap.get("Entrys")).put("isAuto2Inv", new JSONObject());
		//*********************

		ICoreBase is = getLocalInstance(ctx, eo);
		CoreBaseInfo info = null;
		try {
			info = is.getValue(new ObjectUuidPK(billID),selector);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String proValue;
		Iterator itr;
		if(withData) {
			//��ͷֵ���
			itr = dataJSON.keySet().iterator();
			while(itr.hasNext()){
				proName=(String) itr.next();
				proValue=getValueByProName(ctx,info,proName,eo);
				dataJSON.getJSONObject(proName).put("value", proValue);
			}
		}

		//��¼ֵ���
		itr=entryPropMap.entrySet().iterator();
		Map.Entry<String,LinkedHashMap<String,Object>> entry;
		Iterator itr2;//��¼����
		EntityObjectInfo tempeo;
		IObjectCollection tempCols;
		JSONObject tempJO;
		JSONArray tempJA,entrysJA=new JSONArray();
		while(itr.hasNext()) {
			entry= (Entry<String, LinkedHashMap<String,Object>>) itr.next();
			propGroup=entry.getKey();//��¼����

			jo=new JSONObject();
			jo.put("columns",entry.getValue());

			if(withData) {
				tempJA=new JSONArray();//��¼��
				//��¼info����
				tempeo = ((LinkPropertyInfo)eo.getPropertyByName(propGroup)).getRelationship().getSupplierObject();
				tempCols=(IObjectCollection) info.get(propGroup);
				for(int j=0;j<tempCols.size();j++) {
					tempJO=new JSONObject();
					//��¼�ֶ�
					itr2=entry.getValue().keySet().iterator();
					tempJO.put("dateType","entry");
					tempJO.put("index",j);
					while(itr2.hasNext()) {
						proName=(String)itr2.next();
						proValue=getValueByProName(ctx, tempCols.getObject(j),proName, tempeo);
						tempJO.put(proName, proValue);
						//					tempJO.put("propertyName", proName);
						//					tempJO.put("value", proValue);
					}
					tempJA.add(tempJO);
				}
				jo.put("values",tempJA);
			}
			jo.put("entryName",propGroup);
			//��¼���ԡ�ֵ
			//			dataJSON.put(propGroup,jo);
			entrysJA.add(jo);//modify
		}
		dataJSON.put("entrysArray",entrysJA);//modify

		if(StringUtils.isNotBlank(dataJSON.toString())){
			resultJson.put("data", dataJSON.toString());
//			System.out.println(resultJson.toString());
		}
		return resultJson.toJSONString();
	}

	/**
	 * ��ȡ����ֵ
	 * @param model
	 * @param proName
	 * @return
	 */
	private static String getValueByProName(Context ctx,IObjectValue model ,String orgProName,EntityObjectInfo eo) {
		//��ȡ��һ������
		int index=orgProName.indexOf(".");
		String proName=index>=0?orgProName.substring(0,index):orgProName;
		//��������
		if(eo.getPropertyByName(proName) instanceof LinkPropertyInfo) {
			if(model.get(proName) instanceof IObjectCollection) {
				return " ��֧���ӷ�¼";
			}else if(model.get(proName) instanceof IObjectValue) {
				eo=getEntityObject(ctx, model.getObjectValue(proName).getBOSType().toString());
				return getValueByProName(ctx,model.getObjectValue(proName),orgProName.substring(index+1,orgProName.length()),eo);
			}else {
				return "";
			}
		}
		//��������
		else if(eo.getPropertyByName(proName) instanceof OwnPropertyInfo) { 
			OwnPropertyInfo ss = ((OwnPropertyInfo)eo.getPropertyByName(proName));
			if(ss.getDataType().getAlias().equalsIgnoreCase("Enum")) {
				return getEnumAliasByValue(ss, model, proName);
			}if(ss.getDataType().getAlias().equalsIgnoreCase("boolean")) {
				return String.valueOf(model.getBoolean(proName));
			}else {
				if(model.get(proName)!=null) {
					return String.valueOf(model.get(proName));
				}else {
					return "";
				}
			}
		}else {
			return "";
		}
	}
	
	private static String getEnumAliasByValue(OwnPropertyInfo  proInfo,IObjectValue model,String proName) {
		try {
			Class cls = Class.forName(proInfo.getMetaDataRef());
			Class className=model.get(proName).getClass();
			if(className .equals(Integer.class)) {
				className=int.class;
			}else if(className .equals(Double.class)) {
				className=double.class;
			}else if(className .equals(Float.class)) {
				className=float.class;
			}else if(className .equals(Long.class)) {
				className=long.class;
			}
			Method mtd = cls.getMethod("getEnum", new Class[] {className});
			Object cusEnum=mtd.invoke(null, new Object[] {model.get(proName)});
			mtd = cls.getMethod("getAlias");
			return String.valueOf(mtd.invoke(cusEnum));
		}catch(Exception err) {
			return  String.valueOf(model.get(proName));
		}
	}

	public static ICoreBase getLocalInstance(Context ctx,EntityObjectInfo eo) throws BOSException {
		ICoreBase iCoreBase = null;
		try {
			Class cls = Class.forName(eo.getBusinessImplFactory());
			Method mtd = cls.getMethod("getLocalInstance", new Class[] {com.kingdee.bos.Context.class });
			iCoreBase = (ICoreBase) mtd.invoke(cls, new Object[] { ctx });
		} catch (Exception e) {
			throw new BOSException(e);
		}
		return iCoreBase;
	}

	public static EntityObjectInfo getEntityObject(Context ctx,String bosType) {
		IMetaDataLoader loader =null;
		if(ctx!=null) {
			loader=MetaDataLoaderFactory.getLocalMetaDataLoader(ctx);
		}else {
			loader=MetaDataLoaderFactory.getRemoteMetaDataLoader();
		}
		EntityObjectInfo eo = loader.getEntity(BOSObjectType.create(bosType));
		return eo;
	}

	/**
	 * ���ݵ���id��ȡ����info 
	 * @param ctx
	 * @param id
	 * @return
	 */
	public static JSONObject getDataByID(Context ctx,String jsonStr,IDynamicDeal ideal) throws BOSException, EASBizException {
		JSONObject json=JSONObject.parseObject(jsonStr);
		String[] slorArrays=null;
		if(json.containsKey("slor")) {
			slorArrays=new String[json.getJSONArray("slor").size()];
			for(int index=0;index<json.getJSONArray("slor").size();index++) {
				slorArrays[index]=json.getJSONArray("slor").getString(index);
			}
		}
		return getDataByID(ctx,json.getString("id"),slorArrays,ideal);
	}
	
	/**
	 * ���ݵ���id��ȡ����info 
	 * @param ctx
	 * @param id
	 * @return
	 */
	public static JSONObject getDataByID(Context ctx,String id,String[] slorArrays,IDynamicDeal ideal) throws BOSException, EASBizException {
		String bosType=BOSUuid.read(id).getType().toString();
		EntityObjectInfo eo = getEntityObject(ctx, bosType);
		CoreBaseInfo info = null;
		if(slorArrays==null||slorArrays.length<=0) {
			info=getLocalInstance(ctx, eo).getValue(new ObjectUuidPK(id));
		}else {
			SelectorItemCollection slor=new SelectorItemCollection();
			for(String s:slorArrays) {
				slor.add(s);
			}
			info=getLocalInstance(ctx, eo).getValue(new ObjectUuidPK(id),slor);
		}
		if(ideal!=null) {
			info=ideal.dealBeforeGetDataJSON(ctx, info);
		}
		JSONObject infoJSON=new JSONObject();
		if(info!=null) {
			while(eo!=null) {
				setDataValue(ctx,eo, info, infoJSON,"",slorArrays);
				eo=(EntityObjectInfo) eo.getParent();
			}
		}
		if(ideal!=null) {
			infoJSON=ideal.dealAfterGetDataJSON(ctx, info,infoJSON);
		}
		return infoJSON;
	}
	
	/**
	 * ���ݵ���Number��ȡ����info 
	 * @param ctx
	 * @param id
	 * @return
	 */
	public static JSONObject getDataByNumber(Context ctx,String jsonStr,IDynamicDeal ideal) throws BOSException, EASBizException {
		JSONObject json=JSONObject.parseObject(jsonStr);
		String[] slorArrays=null;
		if(json.containsKey("slor")) {
			slorArrays=new String[json.getJSONArray("slor").size()];
			for(int index=0;index<json.getJSONArray("slor").size();index++) {
				slorArrays[index]=json.getJSONArray("slor").getString(index);
			}
		}
		return getDataByNumber(ctx,json.getString("bosType"),json.getString("number"),slorArrays,ideal);
	}
	
	/**
	 * ���ݵ���id��ȡ����info 
	 * @param ctx
	 * @param id
	 * @return
	 */
	public static JSONObject getDataByNumber(Context ctx,String bosType,String number,String[] slorArrays,IDynamicDeal ideal) throws BOSException, EASBizException {
		EntityObjectInfo eo = getEntityObject(ctx, bosType);
		CoreBaseInfo info = null;
		if(slorArrays==null||slorArrays.length<=0) {
			CoreBaseCollection cols = getLocalInstance(ctx, eo).getCollection("select * where number='"+number+"'");
			if(!cols.isEmpty()) {
				info=cols.get(0);
			}
		}else {
			SelectorItemCollection slor=new SelectorItemCollection();
			for(String s:slorArrays) {
				slor.add(s);
			}
			CoreBaseCollection cols = getLocalInstance(ctx, eo).getCollection("where number='"+number+"'");
			if(!cols.isEmpty()) {
				info=cols.get(0);
				info=getLocalInstance(ctx, eo).getValue(new ObjectUuidPK(info.getId()),slor);
			}
		}
		if(ideal!=null) {
			info=ideal.dealBeforeGetDataJSON(ctx, info);
		}
		JSONObject infoJSON=new JSONObject();
		if(info!=null) {
			while(eo!=null) {
				setDataValue(ctx,eo, info, infoJSON,"",slorArrays);
				eo=(EntityObjectInfo) eo.getParent();
			}
		}
		if(ideal!=null) {
			infoJSON=ideal.dealAfterGetDataJSON(ctx, info,infoJSON);
		}
		return infoJSON;
	}

	/**
	 * 
	 * @param ctx
	 * @param eo ʵ�����
	 * @param info ���ݶ���
	 * @param infoJSON
	 * @param parentProName ��Ԫ������
	 * @param slorArrays ѡ����
	 */
	private static void setDataValue(Context ctx,EntityObjectInfo eo,IObjectValue info,JSONObject infoJSON,String parentProName,String[] slorArrays) {
		String proName;//������ 
		Object proValue;
		for(int k=0;k<eo.getProperties().size();k++) {
			PropertyInfo prop = eo.getProperties().get(k);
			proName=prop.getName();
			proValue=info.get(proName);
			if(proValue==null) {
				continue;
			}
			if(prop instanceof LinkPropertyInfo) {
//				System.out.println("*******"+proName+":"+((LinkPropertyInfo)prop).getRelationship()+"*********");
				//��¼
				if(proValue instanceof IObjectCollection) {
					JSONArray ja=new JSONArray();
					JSONObject jo;
					IObjectCollection obc=(IObjectCollection)proValue;
					String tempProName = parentProName+(StringUtils.isNotBlank(parentProName)?".":"")+proName;
					for(int index=0;index<obc.size();index++) {
						jo=new JSONObject();
						EntityObjectInfo tempEO;
						tempEO=getEntityObject(ctx,obc.getObject(index).getBOSType().toString());
						while(tempEO!=null) {
							setDataValue(ctx,tempEO,obc.getObject(index), jo,tempProName,slorArrays);
							tempEO=(EntityObjectInfo) tempEO.getParent();
						}
						ja.add(jo);
					}
					infoJSON.put(proName, ja);
				}
				//�Ƿ�¼
				else if(proValue instanceof IObjectValue) {
					JSONObject jo=new JSONObject();
					jo.put("id", ((IObjectValue) proValue).getString("id"));
					jo.put("number",  ((IObjectValue) proValue).containsKey("number")?((IObjectValue) proValue).getString("number"):null);
					jo.put("name", ((IObjectValue) proValue).containsKey("name")?((IObjectValue) proValue).getString("name"):null);
					
					//�ж�selector,����selector��ֵ
					if(slorArrays!=null&&parentProName!=null) {
						String tempProName=parentProName+(StringUtils.isNotBlank(parentProName)?".":"")+proName;
						String slor;
						int proNameIndex;
						String childProName;
						EntityObjectInfo tempEO;
						tempEO=getEntityObject(ctx,((IObjectValue) proValue).getBOSType().toString());
						for(int index=0;index<slorArrays.length;index++) {
							slor=slorArrays[index];
							proNameIndex=slor.indexOf(tempProName+".");
							if(proNameIndex==0&&(slor.length()>=(tempProName.length()+1))) {
								childProName=slor.substring(tempProName.length()+1);
								if(childProName.equals("*")) {
									for(int j=0;j<tempEO.getProperties().size();j++) {
										childProName=tempEO.getProperties().get(j).getName();
										Object object=getProtertyValue((IObjectValue) proValue, childProName);
										if(object!=null&&StringUtils.isNotBlank(object.toString())){
											jo.put(childProName, getProtertyValue((IObjectValue) proValue, childProName));
										}
										
									}
									break;
								}else {
									jo.put(childProName, getProtertyValue((IObjectValue) proValue, childProName));
								}
							}
						}
					}else {
						jo.put("number", ((IObjectValue) proValue).getString("number"));
						jo.put("name", ((IObjectValue) proValue).getString("name"));
					}
					infoJSON.put(proName, jo);
				}
			}
			if(prop instanceof OwnPropertyInfo) {
//				System.out.println("*******"+proName+":"+((OwnPropertyInfo)prop).getDataType()+"*********");
				OwnPropertyInfo tempPro = ((OwnPropertyInfo)prop);
				if(tempPro.getDataType().equals(DataType.ENUM)) {
					JSONObject jo=new JSONObject();
//					jo.put("name",proName);
					jo.put("alias",getEnumAliasByValue(tempPro, info, proName));
					jo.put("value",proValue);
					infoJSON.put(proName, jo);
				}
				else if(tempPro.getDataType().equals(DataType.DATE)||tempPro.getDataType().equals(DataType.TIMESTAMP)){
					infoJSON.put(proName, sdf.format(proValue));
				}
				else if(ctx.get("isAllStr")==null&&tempPro.getDataType().equals(DataType.BOOLEAN)) {
					infoJSON.put(proName, proValue);
				}
				else if(ctx.get("isAllStr")==null&&(tempPro.getDataType().equals(DataType.INTEGER)||tempPro.getDataType().equals(DataType.DECIMAL))) {
					infoJSON.put(proName, proValue);
				}
				else if(tempPro.getDataType().equals(DataType.BYTEARRAY)) {
					infoJSON.put(proName, Base64.encodeToString((byte[])proValue));
				}
				else {//�ַ�������ֵ���ͣ�ֱ��ȡֵ
					infoJSON.put(proName, proValue.toString());
					
//					if(eo.getProperties().get(k) instanceof OwnPropertyInfo) {
//						OwnPropertyInfo ss=(OwnPropertyInfo) eo.getProperties().get(k);
//						if(ss.getDataType().getAlias().equalsIgnoreCase("Enum")) {
//							JSONObject jo=new JSONObject();
//							jo.put("value", proValue.toString());
//							jo.put("alias", getEnumAliasByValue(ss, info, proName));
//							infoJSON.put(proName, jo);
//						}
//					}
				}
			}
			
		}
	}
	
	private static Object getProtertyValue(IObjectValue proValue,String childProName) {
		if(proValue.get(childProName) instanceof IObjectValue) {
			JSONObject tempJO = new JSONObject();
			tempJO.put("id",  proValue.getObjectValue(childProName).getString("id"));
			return tempJO;
		}else {
			return  proValue.get(childProName)!=null?String.valueOf(proValue.get(childProName)):"";
		}
	}

	/**
	 * ����java �齨info
	 * @param ctx
	 * @param json
	 * @param bosType
	 * @return
	 * @throws BOSException
	 * @throws EASBizException
	 */
	public static CoreBaseInfo getCoreBaseInfo(Context ctx,JSONObject json,String bosType) throws BOSException, EASBizException {
		EntityObjectInfo eo = getEntityObject(ctx, bosType);
		CoreBaseInfo info=null;
		try {
			info = (CoreBaseInfo) Class.forName(eo.getBusinessImplName()+"Info").newInstance();
		} catch (Exception e) {
			throw new BOSException(e);
		}
		
		while(true) {
			setPropertiesValue(ctx, eo, json, info);
			eo=(EntityObjectInfo) eo.getParent();
			if(eo==null) {
				break;
			}
		}
		return info;
	}
	
	/**
	 * �ϴ� ����
	 * @param ctx
	 * @param bosType
	 * @return 
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	public static IObjectPK uploadDataByBosType(Context ctx,String bosType,String jsonStr,IDynamicDeal ideal) throws BOSException, EASBizException {
		JSONObject json=JSONObject.parseObject(jsonStr);
		CoreBaseInfo info=getCoreBaseInfo(ctx, json, bosType);
		EntityObjectInfo eo = getEntityObject(ctx, bosType);
		ICoreBase is = getLocalInstance(ctx, eo);
		/*CoreBaseInfo info=null;
		try {
			info = (CoreBaseInfo) Class.forName(eo.getBusinessImplName()+"Info").newInstance();
		} catch (Exception e) {
			throw new BOSException(e);
		}
		ICoreBase is = getLocalInstance(ctx, eo); 
		
		while(true) {
			setPropertiesValue(ctx, eo, json, info);
			eo=(EntityObjectInfo) eo.getParent();
			if(eo==null) {
				break;
			}
		}
		*/
		//System.out.println("����info:"+info.toString());
		//У�鵥��
		//id�ͱ��붼Ϊ��
		
		if(info.get("CU")==null) {
			info.put("CU", ContextUtil.getCurrentCtrlUnit(ctx));
		}
//		else{
//			if(StringUtils.isBlank(info.get("CU").toString())){
//				info.put("CU", ContextUtil.getCurrentCtrlUnit(ctx));
//			}
//		}
		
		
		if(StringUtils.isEmpty(info.getString("id"))&&StringUtils.isEmpty(info.getString("number"))) {
			String orgID=ContextUtil.getCurrentCtrlUnit(ctx)!=null?ContextUtil.getCurrentCtrlUnit(ctx).getString("id"):null;
			info.setString("number", OutBotpCommUtils.getAutoCode(ctx, info, orgID));
		}
		
		info.setBoolean("_isFromDynamicInterface", true);
		IObjectPK pk = null;
		if(ideal!=null) {
			info=ideal.dealBeforeSave(ctx,info);
		}
		if(info==null) {
			return null;
		}
//		if(is instanceof IWlhlBillBase) {
//			pk=((IWlhlBillBase)is).dynamicSave(info);
//		}else if(is instanceof IWlhlDataBase) {
//			pk=((IWlhlDataBase)is).dynamicSave(info);
//		}else {
			pk=is.save(info);
//		}
		if(ideal!=null) {
			ideal.dealAfterSave(ctx,info);
		}
		return pk;
	}
	
	/**
	 * �ϴ� ����
	 * @param ctx
	 * @param bosType
	 * @return 
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	public static IObjectPK[] uploadDataWithArray(Context ctx,String bosType,String jsonArrayStr,IDynamicDeal ideal) throws BOSException, EASBizException {
		JSONArray jsonArray = JSONArray.parseArray(jsonArrayStr);
		EntityObjectInfo orgEO = getEntityObject(ctx, bosType);
//		EntityObjectInfo eo;
		CoreBaseInfo info=null;
		ICoreBase is = getLocalInstance(ctx, orgEO);
		AbstractObjectCollection cols=null;
		try {
			cols = (AbstractObjectCollection) Class.forName(orgEO.getBusinessImplName()+"Collection").newInstance();
		} catch (Exception e1) {
			throw new BOSException(e1);
		} 
		CtrlUnitInfo cuInfo = ContextUtil.getCurrentCtrlUnit(ctx);
		for(int index=0;index<jsonArray.size();index++) {
			JSONObject json=jsonArray.getJSONObject(index);
			info = getCoreBaseInfo(ctx, json, bosType);
//			eo=orgEO;
//			try {
//				info = (CoreBaseInfo) Class.forName(eo.getBusinessImplName()+"Info").newInstance();
//			} catch (Exception e) {
//				throw new BOSException(e);
//			}
//			
//			while(true) {
//				setPropertiesValue(ctx, eo, json, info);
//				eo=(EntityObjectInfo) eo.getParent();
//				if(eo==null) {
//					break;
//				}
//			}
			//System.out.println("����info:"+info.toString());
			//id�ͱ��붼Ϊ��
			if(info.get("CU")==null) {
				info.put("CU",cuInfo);
			}
			String orgID=ContextUtil.getCurrentCtrlUnit(ctx)!=null?ContextUtil.getCurrentCtrlUnit(ctx).getString("id"):null;
			if(StringUtils.isEmpty(info.getString("id"))&&StringUtils.isEmpty(info.getString("number"))) {
				info.setString("number", OutBotpCommUtils.getAutoCode(ctx, info, orgID));
			}
			info.setBoolean("_isFromDynamicInterface", true);
			if(ideal!=null) {
				info=ideal.dealBeforeSave(ctx,info);
			}
			if(info!=null) {
				cols.addObject(info);
			}
		}
		IObjectPK[] pks = null;
		if(cols instanceof CoreBaseCollection) {
			pks = is.saveBatchData((CoreBaseCollection) cols);
		}else {
			pks=new IObjectPK[cols.size()];
			for(int index=0;index<cols.size();index++){
				pks[index]=is.save((CoreBaseInfo) cols.getObject(index));
				if(ideal!=null) {
					ideal.dealAfterSave(ctx,info);
				}
			}
		}
		return pks;
	}
	
	/**
	 * �ϴ�����-����ֵ
	 * @param eo
	 * @param json
	 * @param info
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private static void setPropertiesValue(Context ctx,EntityObjectInfo eo,JSONObject json,CoreBaseInfo info) throws BOSException, EASBizException {
		OwnPropertyInfo opo;
		LinkPropertyInfo lpo;
		String proName;//������
		PropertyInfo pro;//����
		JSONObject tempJO;
		Object jsonObj;
		Iterator itr = json.keySet().iterator();
		try {
			String jsonProNames,jsonProName;
			String[] jsonProNamesArray;
			while(itr.hasNext()) {
				jsonProNames=((String)itr.next());
//				System.out.println(jsonProNames);
				/*if("borno".equals(jsonProNames)){
					System.out.println(jsonProNames);
				}*/
				jsonProNamesArray=jsonProNames.split("\\.");
				jsonProName=jsonProNamesArray[0];//json������ߵ�һ
				
				for(int index=0;index<eo.getProperties().size();index++) {
					pro = eo.getProperties().get(index);
					proName=pro.getName();
					//json��entity������ͬ
					if(!jsonProName.equals(proName)) {
						continue;
					}
					
					if(pro instanceof LinkPropertyInfo) {
						lpo=(LinkPropertyInfo) pro;
						Class cls=Class.forName(lpo.getRelationship().getSupplierObject().getBusinessImplName()+"Info");
						//					//��¼
						//û���ֶξ��Ƿ�¼
						EntityObjectInfo entryEO;
						if(lpo.getMappingField()==null){
							for(int j=0;j<json.getJSONArray(proName).size();j++) {
								CoreBaseInfo entryInfo = (CoreBaseInfo) cls.newInstance();
								entryEO=getEntityObject(ctx,entryInfo.getBOSType().toString());
								entryInfo.setNull("id");
								while(true) {
									setPropertiesValue(ctx,entryEO,json.getJSONArray(proName).getJSONObject(j),entryInfo);
									entryEO=(EntityObjectInfo) entryEO.getParent();
									if(entryEO==null) {
										break;
									}
								}
								//��ӷ�¼
								((AbstractObjectCollection)info.get(proName)).addObject(entryInfo);
							}
						}else {
							//����ȫ��(aa.bb)�ƻ�ȡֵ
							jsonObj=json.get(jsonProNames);
							if(jsonObj instanceof JSONObject) {
								tempJO=json.getJSONObject(jsonProNames);
							}else {
								tempJO=new JSONObject();
								for(String s:jsonProNamesArray) {
									if(s.equalsIgnoreCase("id")) {
										tempJO.put("id", String.valueOf(jsonObj));
									}else if(s.equalsIgnoreCase("number")) {
										tempJO.put("number", String.valueOf(jsonObj));
									}
								}
							}
							//��ID������INFO 
							Object obj=cls.newInstance();
							if(tempJO.containsKey("id")&&BOSUuid.isValid(tempJO.getString("id"), true)) {
								System.out.println("******************"+tempJO.getString("id"));
								((IObjectValue)obj).setString("id", tempJO.getString("id"));
							}else if(tempJO.containsKey("number")){
								entryEO=getEntityObject(ctx,((IObjectValue)obj).getBOSType().toString());
								//����ID��Ĭ�ϴ�number
								obj= getObjectValueByNumber(ctx, entryEO, tempJO.getString("number"));
							}
							//����ֵ
							info.put(proName, obj);
						}
					}else if(pro instanceof OwnPropertyInfo) {
						opo=(OwnPropertyInfo) pro;
						if(opo.getDataType().equals(DataType.STRING)) {
							info.setString(proName,json.getString(proName));
						}
						else if(opo.getDataType().equals(DataType.BOOLEAN)) {
							info.setBoolean(proName, json.getBoolean(proName));
						}
						else if(opo.getDataType().equals(DataType.DECIMAL)) {
							info.setBigDecimal(proName, json.getBigDecimal( proName));
						}
						else if(opo.getDataType().equals(DataType.DATE)) {
							info.setDate(proName, json.getDate(proName));
						}
						else if(opo.getDataType().equals(DataType.TIMESTAMP)) {
							info.setTimestamp(proName,new Timestamp(json.getDate(proName).getTime()));
						}
						else if(opo.getDataType().equals(DataType.INTEGER)) {
							info.setInt(proName, json.getIntValue(proName));
						}
						else if(opo.getDataType().equals(DataType.ENUM)) {
							if(json.get(proName) instanceof JSONObject) {
								info.setString(proName,json.getJSONObject(proName).getString("value"));
							}else {
								info.setString(proName,json.getString(proName));
							}
						}else if(opo.getDataType().equals(DataType.BYTEARRAY)) {
							info.setBytes(proName, json.getBytes(proName));//base64����
						}else {
							info.setString(proName,json.getString(proName));
						}
					}
				}
			}
		} catch (InstantiationException err) {
			System.out.println(err);
			throw new BOSException(err);
		} catch (IllegalAccessException err) {
			System.out.println(err);
			throw new BOSException(err);
		} catch (ClassNotFoundException err) {
			System.out.println(err);
			throw new BOSException(err);
		}
	}

	/**
	 * ���ݱ����ȡ����
	 * @param ctx
	 * @param eo
	 * @param number
	 * @return 
	 */
	private static CoreBaseInfo getObjectValueByNumber(Context ctx,EntityObjectInfo eo,String number) throws BOSException{
		CoreBaseCollection collection = getLocalInstance(ctx, eo).getCollection("where number='"+number+"'");
		if(collection.size()>0){
			return collection.get(0); 
		}
		return null;
	}
	/**
	 * ��ȡö������
	 * @param ctx
	 * @param enumPath
	 * @return
	 * @throws BOSException
	 */
	public static JSONArray getEnumArray(Context ctx,String enumPath) throws BOSException {
		JSONArray ja=new JSONArray();
		try {
			Class enumClass=Class.forName(enumPath);
			List<Enum> list = EnumUtils.getEnumList(enumClass);
			JSONObject jo;
			String value=null;
			for(Enum eu:list) {
				jo=new JSONObject();
				jo.put("name", eu.getName());
				jo.put("alias", eu.getAlias());
				if(eu instanceof IntEnum) {
					value=String.valueOf(((IntEnum)eu).getValue());
				}else if(eu instanceof FloatEnum) {
					value=String.valueOf(((FloatEnum)eu).getValue());
				}else if(eu instanceof LongEnum) {
					value=String.valueOf(((LongEnum)eu).getValue());
				}else if(eu instanceof StringEnum) {
					value=((StringEnum)eu).getValue();
				}
				jo.put("value",value);
				ja.add(jo);
			}
			
		}catch(Exception err) {
			throw new BOSException(err);
		}
		return ja;
	}

	/**
	 * ��ȡ�����б���Ϣ
	 * @param ctx
	 * @param jsonStr
	 * isNeedReplaceSplit �Ƿ���Ҫ�滻�ָ���
	 * @return
	 * @throws BOSException
	 */
	public static JSONArray getBillList(Context ctx, String bosType,String queryInfo,String queryStr,String[] queryCols,
			int beginRow,int length,String replaceSplitStr) throws BOSException {
		if(StringUtils.isEmpty(queryStr)) {
			throw new BOSException("������������Ϊ�գ�");
		}
		if(StringUtils.isEmpty(queryInfo)) {
			EntityObjectInfo eo = getEntityObject(ctx, bosType);
			queryInfo=eo.getExtendedProperty("defaultF7Query");
		}
		JSONArray ja=new JSONArray();
		if(StringUtils.isNotEmpty(queryInfo)) {
			IMetaDataPK pk=new MetaDataPK(queryInfo);

//						QueryInfo qi = MetaDataLoaderFactory.getLocalMetaDataLoader(ctx).getQuery(pk);
			//			qi.getSelector().get(0).getDisplayName()
			if(beginRow==0&&length==0) {
				beginRow=0;
				length=1000;
			}
			IQueryExecutor iexec = QueryExecutorFactory.getLocalInstance(ctx, pk);
			iexec.setObjectView(queryStr);
			iexec.option().isIgnoreOrder = true;
//			iexec.option().isAutoIgnoreZero = false;
			iexec.option().isAutoTranslateBoolean = true;
			iexec.option().isAutoTranslateEnum = true;
			iexec.option().topCount = 1000000;
//			iexec.option().isIgnoreRowCount = false;
			iexec.option().isIgnorePermissionCheck = true;
//			iexec.option().transactionIsolation = 1;
//			IRowSet rs = iexec.executeQuery(beginRow,length);
			IRowSet rs  = null;
			
			Map execMap = iexec.doAllQueryTask(iexec.openQuery(), beginRow, length, null, true, "id");
			rs=(IRowSet)execMap.get("rowSet");
			
			JSONObject jo;
			Object obj;
			try {
				while(rs.next()) {
					
					jo=new JSONObject();
					//����ֵ
					if(queryCols!=null&&queryCols.length>0) {
						for(String s:queryCols) {
							try {
								rs.findColumn(s);
							}catch(Exception err) {
								jo.put(s,null);
								continue;
							}
							obj=rs.getObject(s);
							if(replaceSplitStr!=null){
								s=s.replaceAll("\\.",replaceSplitStr);
							}
							if(obj==null) {
								jo.put(s,"");
								
							}else if(ctx.get("isAllStr")==null&&obj instanceof Boolean) {
								jo.put(s,obj);
//								System.out.println(rs.getObject(s));
								
							}else if(obj instanceof Date){
								if(obj!=null) {
									obj=sdf.format(obj);
									jo.put(s,String.valueOf(obj));
//									System.out.println(String.valueOf(obj));
								}
							}else {
								jo.put(s,String.valueOf(obj));
//								System.out.println(String.valueOf(obj));
								
							}
						}
					}else {
						String s;
						for(int colIndex=1;colIndex<=rs.getMetaData().getColumnCount();colIndex++) {
							obj=rs.getObject(colIndex);
							s=rs.getMetaData().getColumnName(colIndex);
							if(replaceSplitStr!=null){
								s=s.replaceAll("\\.",replaceSplitStr);
							}
//							System.out.println(s);
							if(obj==null) {
								jo.put(s,"");
							}else if(ctx.get("isAllStr")==null&&obj instanceof Boolean) {
								jo.put(s,obj);
//								System.out.println(rs.getObject(s));
								
							}else if(obj instanceof Date){
								if(obj!=null) {
									obj=sdf.format(rs.getObject(colIndex));
									jo.put(s,String.valueOf(obj));
//									System.out.println(String.valueOf(obj));
								}
							}else {
								jo.put(s,String.valueOf(obj));
//								System.out.println(String.valueOf(obj));
							}
						}
					}
					ja.add(jo);
				}
			} catch (SQLException e) {
				throw new BOSException(e);
			}
		}
		return ja;
	}

	/**
	 * ͨ��id ��ȡ����ʵ�����
	 * @param ctx
	 * @param id
	 * @return
	 * @throws BOSException 
	 */
	public static IObjectValue getObjectValueByID(Context ctx,String id,SelectorItemCollection selector) throws BOSException {
		if(StringUtils.isEmpty(id)) {
			return null;
		}
		BOSObjectType bosType = BOSUuid.read(id).getType();
		IDynamicObject is =null;
		if(ctx!=null) {
			is=DynamicObjectFactory.getLocalInstance(ctx);
		}else {
			is=DynamicObjectFactory.getRemoteInstance();
		}
		if(selector==null) {
			return is.getValue(bosType,new ObjectUuidPK(id));
		}else {
			return is.getValue(bosType,new ObjectUuidPK(id),selector);
		}
	}
	
	/**
	 * ִ�й���
	 * @param ctx
	 * @param bosType
	 * @param id
	 * @param functionName
	 * @throws BOSException 
	 */
	public static Object exeFunciton(Context ctx, String bosType,String id,String functionName,Class<?>[] paramsTypes,Object[] paramValues) throws BOSException {
		ICoreBase is = getLocalInstance(ctx, getEntityObject(ctx, bosType));
		try {
			Class cls = is.getClass();
			Method[] mds = cls.getMethods();
			boolean isExists=false;
			for(Method m:mds) {
//				System.out.println(m.getName());
				if(!m.getName().equals(functionName)) {
					continue;
				}
				 Class<?>[] pts= m.getParameterTypes();
				 
				 if((paramsTypes==null||paramsTypes.length<=0)&&pts.length>0) {
					 continue;
				 }
				 
				 if(paramsTypes!=null&&paramsTypes.length!=pts.length) {
					 continue;
				 }
				 Object obj=null;
				 Class pt;
				 boolean isRight=true;
				 for(int index=0;index<pts.length;index++) {
					 pt=pts[index];
					 if(!pt.equals(paramsTypes[index])) {
						 isRight=false;
						 break;
					 }
					 obj=paramValues[index];
					 if(pt.equals(IObjectPK.class)) {
						 obj=new ObjectUuidPK(String.valueOf(obj));
					 }else if(obj instanceof IObjectValue) {
//						 obj=new CoreBaseInfo();
					 }
					 paramValues[index]=obj;
				 }
				 if(isRight) {
					 isExists=true;
				 }
				 switch(paramValues.length) {
				     case 1:
						 return m.invoke(is, paramValues[0]);
				     case 2:
				    	 return m.invoke(is, paramValues[0],paramValues[1]);
				     case 3:
				    	 return m.invoke(is, paramValues[0],paramValues[1],paramValues[2]);
				     case 4:
				    	 return m.invoke(is, paramValues[0],paramValues[1],paramValues[2],paramValues[3]);
				     case 5:
				    	 return m.invoke(is, paramValues[0],paramValues[1],paramValues[2],paramValues[3],paramValues[4]);
				     case 6:
				    	 return m.invoke(is, paramValues[0],paramValues[1],paramValues[2],paramValues[3],paramValues[4],paramValues[5]);
				     case 7:
				    	 return m.invoke(is, paramValues[0],paramValues[1],paramValues[2],paramValues[3],paramValues[4],paramValues[5],paramValues[6]);
				     case 8:
				    	 return m.invoke(is, paramValues[0],paramValues[1],paramValues[2],paramValues[3],paramValues[4],paramValues[5],paramValues[6],paramValues[7]);
				     case 9:
				    	 return m.invoke(is, paramValues[0],paramValues[1],paramValues[2],paramValues[3],paramValues[4],paramValues[5],paramValues[6],paramValues[7],paramValues[8]);
				     case 10:
				    	 return m.invoke(is, paramValues[0],paramValues[1],paramValues[2],paramValues[3],paramValues[4],paramValues[5],paramValues[6],paramValues[7],paramValues[8],paramValues[9]);
				 }
			}
			if(!isExists) {
				throw new BOSException("�����ڸ÷�����");
			}
			
		} catch (Exception e) {
			throw new BOSException(e);
		}
		return "success";
	}
}
