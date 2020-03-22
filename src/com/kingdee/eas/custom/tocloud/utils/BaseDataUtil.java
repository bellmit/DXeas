package com.kingdee.eas.custom.tocloud.utils;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.tocloud.BaseDataRelCollection;
import com.kingdee.eas.custom.tocloud.BaseDataRelEntryCollection;
import com.kingdee.eas.custom.tocloud.BaseDataRelEntryInfo;
import com.kingdee.eas.custom.tocloud.BaseDataRelFactory;
import com.kingdee.eas.custom.tocloud.BaseDataRelInfo;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class BaseDataUtil {

	private static String KEY_SPLIT_VALUE = "-";
	
	public static Map<String, String> baseDataMap = null;
	
	/**
	 * ����Ŀ��ϵͳ ������������ ��Դϵͳ�������ϱ��� ��ȡ ��Ŀ��ϵͳ�������ϱ��롿
	 * @param ctx
	 * @param targetSystemId ---Ŀ��ϵͳid
	 * @param baseDataTypeId ---������������id
	 * @param srcBaseDataNumber --Դϵͳ����
	 * @return
	 */
	public static String getTargetBaseDataNumberByMap(Context ctx, String targetSystemId, String baseDataTypeId, String srcBaseDataNumber){
		
		if(baseDataMap == null){
			initBaseDataMap(ctx);
		}
		
		StringBuffer baseDataMapKey = new StringBuffer();
		baseDataMapKey.append(targetSystemId);
		baseDataMapKey.append(KEY_SPLIT_VALUE);
		baseDataMapKey.append(baseDataTypeId);
		baseDataMapKey.append(KEY_SPLIT_VALUE);
		baseDataMapKey.append(srcBaseDataNumber);
		
		String targetBaseDataNumber = "";
		
		if(baseDataMap.containsKey(baseDataMapKey.toString())){
			targetBaseDataNumber = baseDataMap.get(baseDataMapKey.toString());
		}
			
		if(StringUtils.isBlank(targetBaseDataNumber)){
			targetBaseDataNumber = getTargetBaseDataNumberByDb(ctx, targetSystemId, baseDataTypeId, srcBaseDataNumber);
		}
		
		return targetBaseDataNumber;
	}
	
	/**
	 * ����Ŀ��ϵͳid ������������id ��Դϵͳ�������ϱ��� ��ȡ Ŀ��ϵͳ�������ϱ���
	 * @param ctx
	 * @param targetSystemId
	 * @param baseDataTypeId
	 * @param srcBaseDataNumber
	 * @return
	 */
	public static String getTargetBaseDataNumberByDb(Context ctx, String targetSystemId, String baseDataTypeId, String srcBaseDataNumber){
		
		if(StringUtils.isBlank(targetSystemId) || 
				StringUtils.isBlank(baseDataTypeId) ||
				StringUtils.isBlank(srcBaseDataNumber)){
			return null;
		}
		
		StringBuffer sql = new StringBuffer();
		sql.append(" select t1.cftargetnumber ");
		sql.append(" from ct_cld_basedatarel t ");
		sql.append(" inner join ct_cld_basedatarelentry t1 on t1.fparentid = t.fid ");
		sql.append(" where t.cftargetsystemid = '");
		sql.append(targetSystemId);
		sql.append("' ");
		sql.append(" and t.cfbasedatatypeid = '");
		sql.append(baseDataTypeId);
		sql.append("' ");
		sql.append(" and t1.cfsrcnumber = '");
		sql.append(srcBaseDataNumber);
		sql.append("' ");
		
		try {
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()){
				return rs.getString("cftargetnumber");
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 
	 * @param ctx
	 * @param targetSystemId
	 * @param baseDataTypeId
	 * @param srcBaseDataNumber
	 * @param targetBaseDataNumber
	 */
	public static void setBaseDataMap(Context ctx, String targetSystemId, String baseDataTypeId, String srcBaseDataNumber, String targetBaseDataNumber){
		
		if(StringUtils.isBlank(targetSystemId) || 
				StringUtils.isBlank(baseDataTypeId) ||
				StringUtils.isBlank(srcBaseDataNumber)){
			return;
		}
		
		if(baseDataMap == null){
			baseDataMap = new HashMap<String, String>();
		}
		
		StringBuffer baseDataMapKey = new StringBuffer();
		baseDataMapKey.append(targetSystemId);
		baseDataMapKey.append(KEY_SPLIT_VALUE);
		baseDataMapKey.append(baseDataTypeId);
		baseDataMapKey.append(KEY_SPLIT_VALUE);
		baseDataMapKey.append(srcBaseDataNumber);
		
		//baseDataMap�д�ŵ�   ��--��Ŀ��ϵͳid_������������id_Դϵͳ���룩
		//baseDataMap�д�ŵ�   ֵ--��Ŀ��ϵͳ���룩
		baseDataMap.put(baseDataMapKey.toString(), targetBaseDataNumber);
		
	}
	
	/**
	 * ��ʼ��������������
	 * �����л����������÷ŵ�map
	 * @param ctx
	 */
	public static void initBaseDataMap(Context ctx){
		try {
			if(baseDataMap != null){
				baseDataMap.clear();
			}
			baseDataMap = new HashMap<String, String>();
			StringBuffer baseDataMapKey = new StringBuffer();
			//��ȡ���ж��չ�ϵ
			BaseDataRelCollection collection = BaseDataRelFactory.getLocalInstance(ctx).getBaseDataRelCollection();
			if(collection != null && collection.size() > 0){
				for(int i=0;i<collection.size();i++){
					BaseDataRelInfo baseDataRelInfo = collection.get(i);
					BaseDataRelEntryCollection baseDataRelEntryCollection = baseDataRelInfo.getEntry();
					//��ȡ�������չ�ϵ��¼
					if(baseDataRelEntryCollection != null && baseDataRelEntryCollection.size() > 0){
						for(int k=0;k<baseDataRelEntryCollection.size();k++){
							BaseDataRelEntryInfo baseDataRelEntryInfo = baseDataRelEntryCollection.get(k);
							baseDataMapKey.setLength(0);
							baseDataMapKey.append(baseDataRelInfo.getTargetSystem().getId().toString());
							baseDataMapKey.append(KEY_SPLIT_VALUE);
							baseDataMapKey.append(baseDataRelInfo.getBaseDataType().getId().toString());
							baseDataMapKey.append(KEY_SPLIT_VALUE);
							baseDataMapKey.append(baseDataRelEntryInfo.getSrcNumber());
							
							if(!baseDataMap.containsKey(baseDataMapKey.toString())){
								baseDataMap.put(baseDataMapKey.toString(), baseDataRelEntryInfo.getTargetNumber());	
							}
							
						}
						
					}
					
				}
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
