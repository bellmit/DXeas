package com.kingdee.eas.outinterface.farm.duck.busniess;

import java.math.BigDecimal;
import java.rmi.RemoteException;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.carnivorous.basedata.FarmFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.DrugReceiveBillInfo;
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
		return "E33948D8";
	}

	@Override
	protected String[] getListSelector() {
		return new String[]{"id","number","name","company.name","farmer.id","farmer.name","farmType","baseStatus","area"};
	}
	
	@Override
	public JSONObject dealAfterGetDataJSON(Context ctx, CoreBaseInfo model,
			JSONObject infoJSON) {
		// TODO Auto-generated method stub
		return super.dealAfterGetDataJSON(ctx, model, infoJSON);
	}

	@Override
	public CoreBaseInfo dealBeforeGetDataJSON(Context ctx, CoreBaseInfo model) {
		FarmInfo info=(FarmInfo)model;
//		info.getTransEntry().clear();
		return info;
	}
	

	@Override
	public JSONObject getData(Context ctx, String jsonStr) throws BOSException,
			EASBizException, RemoteException {
		JSONObject paramsJson=JSONObject.parseObject(jsonStr);
		JSONObject reusltJson = super.getData(ctx, jsonStr);
		//补充显示信息
		if(reusltJson.getString("result").equals("0")) {
			JSONObject dataJson=reusltJson.getJSONObject("data");
			String farmID=dataJson.getString("id");
			SelectorItemCollection sic=new SelectorItemCollection();
//			sic.add(new SelectorItemInfo("fodderRoute.distance"));
			FarmInfo info=FarmFactory.getLocalInstance(ctx).getFarmInfo(new ObjectUuidPK(farmID));
			BigDecimal distance=info.getMileStd();
			dataJson.put("distance", distance);//饲料里程			
		}
		return reusltJson; 
	}

	@Override
	protected String[] getDataSelector() {
		// TODO Auto-generated method stub
		return new String[]{
				"id","number","name","company.name","farmer.id","farmer.name","farmType","baseStatus",
				"address","totalSettleBatchNum","gm","succahQty","area","costCenter.name"//地址、累计结算批次、规模、棚舍数量
		};
	}

	@Override
	protected String getListQueryStr(Context ctx, JSONObject jo) throws BOSException {
		StringBuffer queryStr=new StringBuffer();
		queryStr.append(" baseStatus=2 ");//启用状态
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
				//为什么养殖场没有养户字段呢
//				rolesStr.append(" farmer.identity='").append(jo.getString("idNo")).append("'");
				rolesStr.append("id in (")
				.append(" select distinct entry.FFarmID from CT_FM_FarmerFarmEntry entry ")
				.append(" inner join CT_FM_Farmer farmer on farmer.fid=entry.fparentid")
				.append(" where farmer.FIdentity ='"+jo.getString("idNo")+"')");
			}
			if(StringUtils.equalsIgnoreCase(role,"manager")){
				//根据用户找到养殖户，在获取养殖场ID
				rolesStr.append("id in (")
				.append(" select distinct entry.FFarmID from CT_FM_FarmerFarmEntry entry ")
				.append(" inner join CT_FM_Farmer farmer on farmer.fid=entry.fparentid")
				.append(" where farmer.fid in(")
				.append(" select distinct tentry.FFarmerID")
				.append(" from T_FM_PersonFarmerRange tmain")
				.append(" inner join T_FM_PersonFarmerRangeEntry tentry on tentry.fparentid=tmain.fid")
				.append(" inner join t_pm_user tuser on tuser.fpersonid=tmain.FPersonID")
				.append(" where tuser.fnumber='").append(jo.getString("userNum")).append("'")
				.append(" and tmain.FBaseStatus=2 )")
				.append(")");
			}
			//司机--根据养户范围过滤
			if(StringUtils.equalsIgnoreCase(role,"driver")){
				rolesStr.append(" farmer.id in (")
				.append(" select distinct tentry.FFarmerID")
				.append(" from T_FM_DriverFarmerRealtion tmain")
				.append(" inner join T_FM_DriverFarmerRealtionEntry tentry on tentry.fparentid=tmain.fid")
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
