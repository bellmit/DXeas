package com.kingdee.eas.custom.commonld.comm;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityObjectInfo;
import com.kingdee.bos.metadata.entity.LinkPropertyInfo;
import com.kingdee.bos.metadata.entity.OwnPropertyInfo;
import com.kingdee.bos.metadata.entity.PropertyInfo;
import com.kingdee.eas.custom.wlhllicensemanager.util.WlhlDynamicBillUtils;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.ICoreBase;

import net.sf.json.JSONObject;

public class WebServiceComm {
	/**
	 * 设置bosType
	 * @param JSONObject
	 */
	public static String setBosType(String srcJsonStr,String bosType) {
		// TODO Auto-generated method stub
		JSONObject fromObject = JSONObject.fromObject(srcJsonStr);
		if(!fromObject.containsKey("bosType") || StringUtils.isEmpty(fromObject.getString("bosType"))){
			fromObject.put("bosType",bosType);
		}
		return fromObject.toString();
	}

	/**
	 * 单据获取slor
	 * @param ctx
	 * @param bosType
	 * @return
	 * @throws BOSException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static String[] getSlorList(Context ctx,String bosType,String beginStr,ArrayList<String> arrayList){
		try{
			EntityObjectInfo eo = new WlhlDynamicBillUtils().getEntityObject(ctx, bosType);
			LinkPropertyInfo lpo;
			PropertyInfo pro;//属性

			if(StringUtils.isEmpty(beginStr)){
				arrayList.add("*");
			}
			int currentLvl = 1;

			CoreBaseInfo entryInfo;
			String proName;
			for(int index=0;index<eo.getEntityProperties().size();index++){
				pro = eo.getEntityProperties().get(index);
				if(StringUtils.isEmpty(pro.getName()) || pro.getName().equals("parent"))
					continue;
				if(pro instanceof LinkPropertyInfo){
					lpo=(LinkPropertyInfo) pro;
					Class cls=Class.forName(lpo.getRelationship().getSupplierObject().getBusinessImplName()+"Info");
					if(lpo.getMappingField()==null){
						proName = StringUtils.isEmpty(beginStr)?(pro.getName()+".*"):(beginStr+"."+pro.getName()+".*");
						if(!arrayList.contains(proName)){
							arrayList.add(proName);
						}
						entryInfo = (CoreBaseInfo) cls.newInstance();
						getSlorList(ctx,entryInfo.getBOSType().toString(),(StringUtils.isEmpty(beginStr)?(pro.getName()):(beginStr+"."+pro.getName())),arrayList);
					}else{
						proName = StringUtils.isEmpty(beginStr)?(pro.getName()+".*"):(beginStr+"."+pro.getName()+".*");
						if(!arrayList.contains(proName)){
							arrayList.add(proName);
						}
					}
				}
			}
			return arrayList.toArray(new String[arrayList.size()]);
		}catch(Exception err) {
			err.printStackTrace();
		}
		return new String[]{"*"};
	}
}
