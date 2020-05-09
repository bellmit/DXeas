package com.kingdee.eas.outinterface.farm.duck.stocking;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.stocking.processbizill.FodderReceiveBillInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.outinterface.base.impl.AbstractOutInterfaceImpl;

/**
 * 养殖场
 * @author alex_dai
 *
 */
public class Farm extends AbstractOutInterfaceImpl {

	@Override
	protected String getBosType() {
		// TODO Auto-generated method stub
		return "AD78C307";
	}

	@Override
	protected String[] getListSelector() {
		// TODO Auto-generated method stub
		return new String[]{"id","number","name","company.name","farmer.id","farmer.name","farmType","baseStatus"};
	}
	
	@Override
	public JSONObject dealAfterGetDataJSON(Context ctx, CoreBaseInfo model,
			JSONObject infoJSON) {
		// TODO Auto-generated method stub
		return super.dealAfterGetDataJSON(ctx, model, infoJSON);
	}

	public CoreBaseInfo dealBeforeGetDataJSON(Context ctx, CoreBaseInfo model) {
		com.kingdee.eas.farm.stocking.basedata.FarmInfo info=(com.kingdee.eas.farm.stocking.basedata.FarmInfo) model;
		info.getHouseEntry().clear();
		return info;
	}
	@Override
	protected String[] getDataSelector() {
		// 编码、名称、财务组织、养殖模式、发运路线、棚舍数量、养殖规模
        // 养殖面积、建筑面积 、地址、
		return new String[] {
				"id","name","number","company.name"
				,"FaemsType","route.id","route.name","succahQty","gm"
				,"area","floorArea","address"
		};
	}

	@Override
	protected String getListQueryStr(Context ctx, JSONObject jo) throws BOSException {
		StringBuffer queryStr=new StringBuffer();
		queryStr.append(" baseStatus=3 ");//启用状态
		if(StringUtils.isNotEmpty(jo.getString("number"))) {
			queryStr.append(" and (number like '%"+jo.getString("number")+"%' or  name like '%"+jo.getString("number")+"%')");
		}
		if(StringUtils.isNotEmpty(jo.getString("name"))) {
			queryStr.append(" and (number like '%"+jo.getString("name")+"%' or  name like '%"+jo.getString("name")+"%')");
		}
		
		//角色
		StringBuffer rolesStr=new StringBuffer();
		JSONArray rolesArray = jo.getJSONArray("roles");
		for(int index=0;index<rolesArray.size();index++) {
			String role=rolesArray.getString(index);
			if(rolesStr.length()>0) {
				rolesStr.append(" OR ");
			}
			if(StringUtils.equalsIgnoreCase(role,"farmer")){
				rolesStr.append(" id in (")
				.append(" select distinct tffe.FFarmID")
				.append(" from T_FM_Farmers tff")
				.append(" inner join T_FM_FarmersFarmEntry tffe on tffe.FParentid=tff.fid")
				.append(" and tff.FIdentity='").append(jo.getString("idNo")).append("'")
				.append(")");
			}
			if(StringUtils.equalsIgnoreCase(role,"manager")){
//				rolesStr.append(" id in (")
//				.append(" select distinct tffe.FFarmID")
//				.append(" from T_FM_PersonFarmerRelation tmain")
//				.append(" inner join T_FM_PersonFarmerRelationEntry tentry on tentry.fparentid=tmain.fid")
//				.append(" inner join T_FM_FarmersFarmEntry tffe on tffe.FParentid=tentry.FFarmerId")
//				.append(" inner join t_pm_user tuser on tuser.fpersonid=tmain.FPersonID")
//				.append(" where tuser.fnumber='").append(jo.getString("userNum")).append("'")
//				.append(" and tmain.FBaseStatus=3")
//				.append(")");
				//从种禽而牧通权限维护表查
				rolesStr.append("" +
						"id in(select distinct per.CFFarmID from CT_FM_EmtPermission per\r\n" + 
						"inner join CT_FM_EmtPermissionUserEntrys  pere on per.fid=pere.fparentid\r\n" + 
						"inner join t_pm_user tuser on tuser.fpersonid=pere.CFPersonNameID\r\n" + 
						"where tuser.fnumber='"+jo.getString("userNum")+"' )" );
			}
			//司机--根据养户范围过滤
			if(StringUtils.equalsIgnoreCase(role,"driver")){
				rolesStr.append(" id in (")
				.append(" select distinct tffe.FFarmID")
				.append(" from T_FM_DriverFarmerRealtion tmain")
				.append(" inner join T_FM_PersonFarmerRelationEntry tentry on tentry.fparentid=tmain.fid")
				.append(" inner join T_FM_FarmersFarmEntry tffe on tffe.FParentid=tentry.FFarmerId")
				.append(" inner join CT_FM_Driver tp on tp.fid=tmain.FDriverID")
				.append(" where tp.CFDrivercardid='").append(jo.getString("idNo")).append("'")
				.append(" and tmain.FBaseStatus=3")
				.append(")");
			}
		}
		if(rolesStr.length()>0) {
			queryStr.append(" AND (").append(rolesStr).append(")");
		}
		
		return queryStr.toString();
	}
	
}
