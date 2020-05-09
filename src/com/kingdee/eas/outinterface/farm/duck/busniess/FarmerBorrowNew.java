package com.kingdee.eas.outinterface.farm.duck.busniess;

import java.rmi.RemoteException;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.outinterface.base.impl.AbstractOutInterfaceImpl;
import com.kingdee.eas.outinterface.base.utils.JUtils;

public class FarmerBorrowNew extends AbstractOutInterfaceImpl{
	@Override
	protected String getBosType() {
		// TODO Auto-generated method stub
		return "A6258D66";
	}
	
	
	@Override
	protected String[] getListSelector() {
		// TODO Auto-generated method stub
		return new String[]{"id","number","name","farm.name","person.name"
				,"farmer.name","isBorrow","browerItem.id","browerItem.name","bizdate","amount"
				//业务类型、借款项目、日期、金额
				,"remark","batchContract.id","batchContract.name","batchContract.number"
				//摘要、批次合同
		};
	}
	
	
	@Override
	protected String getSortStr(JSONObject jo) {
		// TODO Auto-generated method stub
		return "order by bizdate desc";
	}
	

	@Override
	protected String[] getDataSelector() {
		// TODO Auto-generated method stub
		return new String[]{"id","number","name","farm.name","person.name"
				,"farmer.name","isBorrow","browerItem.id","browerItem.name","bizdate","amount"
				//业务类型、借款项目、日期、金额
				,"remark","batchContract.id","batchContract.name","batchContract.number"
				//摘要、批次合同
		};
	}


	@Override
	public JSONObject getData(Context ctx, String jsonStr) throws BOSException, EASBizException, RemoteException {
		// TODO Auto-generated method stub
		JSONObject paramsJson=JSONObject.parseObject(jsonStr);		
		JSONObject reusltJson = super.getData(ctx, jsonStr);
		return reusltJson;
	}
	
	
	
	

	@Override
	protected String getListQueryStr(Context ctx, JSONObject jo) throws BOSException {
		String beginDate=JUtils.getDateStr(jo, "beginDate", JUtils.SDF_DAY);
		String endDate=JUtils.getDateStr(jo, "endDate", JUtils.SDF_DAY);
		StringBuffer queryStr= new StringBuffer();
		queryStr.append(" bizDate>={d '").append(beginDate).append("'}")
		.append(" and bizDate<{d '").append(endDate).append("'}");
		
		//养户过滤
		if(StringUtils.isNotEmpty(jo.getString("farmer.id"))) {
			queryStr.append(" and farmer.id='").append(jo.getString("farmer.id")).append("'");
		}
		//养殖场过滤
		if(StringUtils.isNotEmpty(jo.getString("farm.id"))) {
			queryStr.append(" and farm.id='").append(jo.getString("farm.id")).append("'");
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
				rolesStr.append(" farmer.identity='").append(jo.getString("idNo")).append("'");
			}
			if(StringUtils.equalsIgnoreCase(role,"manager")){
				rolesStr.append(" farmer.id in (")
				.append(" select distinct tentry.FFarmerID")
				.append(" from T_FM_PersonFarmerRange tmain")
				.append(" inner join T_FM_PersonFarmerRangeEntry tentry on tentry.fparentid=tmain.fid")
				.append(" inner join t_pm_user tuser on tuser.fpersonid=tmain.FPersonID")
				.append(" where tuser.fnumber='").append(jo.getString("userNum")).append("'")
				.append(" and tmain.FBaseStatus=2")
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
			queryStr.append(" AND (").append(rolesStr).append(") ");
		}

		return queryStr.toString();
	}
}
