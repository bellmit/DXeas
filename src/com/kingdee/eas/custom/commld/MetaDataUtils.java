package com.kingdee.eas.custom.commld;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.InvalidDAOMetaDataException;
import com.kingdee.bos.metadata.IMetaDataLoader;
import com.kingdee.bos.metadata.MetaDataLoaderFactory;
import com.kingdee.bos.metadata.entity.EntityObjectInfo;
import com.kingdee.bos.metadata.entity.LinkPropertyInfo;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.util.BOSUuid;

public class MetaDataUtils {

	/**
	 * ���ݵ���info����ID��ȡʵ�����ͱ���
	 * @param ctx
	 * @param id
	 * @return
	 */
	public static HashMap<String,Object> getEntityInfoByBosIDOrInfo(Context ctx,Object id){
		HashMap<String, Object> result=new HashMap<String, Object>(); 
		BOSObjectType objectType =null;
		if(id instanceof String){
			BOSUuid uuid=BOSUuid.read(id.toString());
			objectType=uuid.getType();
		}
		else if(id instanceof IObjectValue)
			objectType= ((IObjectValue)id).getBOSType();
		else
			return null;
		IMetaDataLoader IMetaDataLoader;
		if(ctx!=null)
			IMetaDataLoader = MetaDataLoaderFactory.getLocalMetaDataLoader(ctx);
		else
			IMetaDataLoader = MetaDataLoaderFactory.getRemoteMetaDataLoader();

		EntityObjectInfo entityObjectInfo = IMetaDataLoader.getEntity(objectType);

		//ʵ�����ͱ���
		result.put("entityName", entityObjectInfo.getFullName());
		result.put("entityAlias", entityObjectInfo.getAlias());

		result.put("tableName", entityObjectInfo.getTable());
		if(entityObjectInfo.getTable()!=null)
			result.put("tableAlias", entityObjectInfo.getTable().getName());
		return result;
	}

	/**
	 * ���ݵ���Info��id��ȡ����
	 * @param ctx
	 * @param id
	 * @return
	 */
	public static String getTableNameByBosIDOrInfo(Context ctx,Object id){
		HashMap<String, Object> result = getEntityInfoByBosIDOrInfo(ctx,id);
		if(result==null)
			return null;
		if(result.containsKey("tableAlias")&&StringUtils.isNotEmpty(result.get("tableAlias").toString()))
			return result.get("tableAlias").toString();
		else
			return null;
	}


	/**
	 * ��ȡentityViewInfo
	 * @param ctx
	 * @param id
	 * @return
	 */
	public static EntityObjectInfo getEntityObjectInfo(Context ctx,Object id){
		BOSObjectType objectType =null;
		if(id instanceof String){
			BOSUuid uuid=BOSUuid.read(id.toString());
			objectType=uuid.getType();
		}
		else if(id instanceof IObjectValue)
			objectType= ((IObjectValue)id).getBOSType();
		else
			return null;
		IMetaDataLoader IMetaDataLoader;
		if(ctx!=null)
			IMetaDataLoader = MetaDataLoaderFactory.getLocalMetaDataLoader(ctx);
		else
			IMetaDataLoader = MetaDataLoaderFactory.getRemoteMetaDataLoader();

		EntityObjectInfo entityObjectInfo = IMetaDataLoader.getEntity(objectType);

		return entityObjectInfo;
	}

	public static String getAliasByPropertyName(Context ctx,EntityObjectInfo eoInfo,String proName) {
		try {
			return eoInfo.getFieldByFullName(proName).getAlias();
		} catch (InvalidDAOMetaDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return proName;
	}
}