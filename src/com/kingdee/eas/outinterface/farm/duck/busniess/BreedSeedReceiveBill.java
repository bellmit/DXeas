package com.kingdee.eas.outinterface.farm.duck.busniess;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.castor.util.Base64Decoder;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.IBreedSeedReceiveBill;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.industry.emm.pm.SqlExecuteFacadeFactory;
import com.kingdee.eas.outinterface.base.impl.AbstractOutInterfaceImpl;
import com.kingdee.eas.outinterface.base.utils.JUtils;
import com.kingdee.eas.outinterface.base.utils.ResultUtils;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * 雏苗领用单
 * @author alex_dai
 *
 */
public class BreedSeedReceiveBill extends AbstractOutInterfaceImpl {

	@Override
	protected String getBosType() {
		// TODO Auto-generated method stub
		return "681AB2A9";
	}
	
	@Override
	protected String[] getDataSelector() {
		// TODO Auto-generated method stub
		return new String[]{"*","farm.name","batchContract.number"
				,"batch.number","farmer.name","breedData.name"
				,"driver.drivername","person.name","farmerPhone"
				,"entrys.*"
				,"entrys.material.number","entrys.material.name","entrys.material.model"
				,"unit.number","unit.name","entrys.warehouse.name"
//				,"warehouse.number","warehouse.name"
		};
	}
	
	/**
	 * 获取单据后处理
	 */
	@Override
	public CoreBaseInfo dealBeforeGetDataJSON(Context ctx, CoreBaseInfo model) {
		BreedSeedReceiveBillInfo info=(BreedSeedReceiveBillInfo) model;
		//移除签名数据
		info.setSignData(null);
		return info;
	}

	@Override
	protected String[] getListSelector() {
		// TODO Auto-generated method stub
		return new String[]{"id","number","billStatus","farmer.name","bizDate"
				,"stockingBatchNum","breedData.name","farmer.name","farm.name","farmerPhone"
				,"driver.drivername","batchContract.number"
				,"confirmTime","bizType","person.name"
				,"entrys.id","entrys.seq","entrys.receiveQty","entrys.receivePrice","entrys.confirmQty","entrys.basePrice","entrys.amount"
				,"entrys.supplementQty","entrys.lossQty","entrys.allReceiveQty"
				,"entrys.material.number","entrys.materialName","entrys.model","entrys.unit.name","entrys.warehouse.name"
				,"treeid.name","farm.gm","farm.mileStd","costObject.name"
		};
	}
	
	

	@Override
	public JSONObject getList(Context ctx, String jsonStr) throws BOSException,
			EASBizException, RemoteException {
		// TODO Auto-generated method stub
		JSONObject paramsJson=JSONObject.parseObject(jsonStr);
		JSONObject reusltJson = super.getList(ctx, jsonStr);
		JSONObject dataJsonDetail=null;
		JSONArray dataJson=null;
		StringBuffer sql=new StringBuffer();
        BigDecimal qty=BigDecimal.ZERO, amount=BigDecimal.ZERO;
        if(reusltJson.getString("result").equals("0")) {
        	dataJson=reusltJson.getJSONArray("data");
        	if(!dataJson.isEmpty()){
//        		for(int i=0;i<dataJson.size();i++){
//        			qty=qty.add(dataJson.getJSONObject(i).getBigDecimal("entrys_receiveQty")==null ?BigDecimal.ZERO
//        					:dataJson.getJSONObject(i).getBigDecimal("entrys_receiveQty"));
//        			amount=amount.add(dataJson.getJSONObject(i).getBigDecimal("entrys_amount")==null ?BigDecimal.ZERO
//        					:dataJson.getJSONObject(i).getBigDecimal("entrys_amount"));
//        		}
        		//不按页码返回，返回查询条件后的所有
        		try {
            		sql.append("select sum(isnull(entry.FAllReceiveQty,0)) FReceiveQty, sum(isnull(entry.CFAmount,0)) CFAmount from T_FM_BreedSeedReceiveBillEntry entry \n")
            		   .append(" inner join T_FM_BreedSeedReceiveBill drug on drug.fid=entry.fparentid \n")
            		   .append(" inner join CT_FM_Farmer farmer on farmer.fid= drug.FFarmerID \n")
            		   .append(" where "+getListQueryStr2(ctx,paramsJson)+"");
            		IRowSet rs= SqlExecuteFacadeFactory.getLocalInstance(ctx).executeQuery(sql.toString());
            		if(rs.next()){
            			qty=rs.getBigDecimal("FReceiveQty");
            			amount=rs.getBigDecimal("CFAmount");
            		}
				} catch (Exception e) {
					e.printStackTrace();
				} 
        		dataJsonDetail=dataJson.getJSONObject(0);
            	dataJsonDetail.put("sum_amount", amount);
            	dataJsonDetail.put("sum_qty", qty);
        	}        	
		}		
		return reusltJson;
	}

	@Override
	protected String getSortStr(JSONObject jo) {
		// TODO Auto-generated method stub
		String type=jo.getString("type");
		if(StringUtils.isEmpty(type)){
			type="ASC";
		}
		String bizDate=jo.getString("bizDate");
		String farmerName=jo.getString("farmer.name");
		String costCenterName=jo.getString("costCenter.name");
		String GM=jo.getString("farm.gm");
		String MILESTD=jo.getString("farm.mileStd");
		String treeName=jo.getString("treeid.name");
		String str=null;
		if(StringUtils.isNotEmpty(bizDate)){
			str=" bizDate desc ";
		}else if(StringUtils.isNotEmpty(costCenterName)){
			str=" costObject.name " +type;
		}else if(StringUtils.isNotEmpty(GM)){
			str=" farm.gm " +type;
		}else if(StringUtils.isNotEmpty(MILESTD)){
			str="farm.mileStd " +type;
		}else if(StringUtils.isNotEmpty(treeName)){
			str=" treeid.name " +type;
		}else if(StringUtils.isNotEmpty(farmerName)){
			str=" farmer.name " +type;
		}else{
			str=" bizDate desc ";
		}
		return "order by "+str+" ,entrys.seq";
//		return "order by number desc,entrys.seq";
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
		//批次合同
		if(StringUtils.isNotEmpty(jo.getString("batchContract.id"))) {
			queryStr.append(" and batchContract.id='").append(jo.getString("batchContract.id")).append("'");
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
		}
		if(rolesStr.length()>0) {
			queryStr.append(" AND (").append(rolesStr).append(")");
		}
		
		return queryStr.toString();
	}
	
	@Override
	public JSONObject getData(Context ctx, String jsonStr) throws BOSException,
			EASBizException, RemoteException {
		// TODO Auto-generated method stub
		return super.getData(ctx, jsonStr);
	}

	/**
	 * 确认单据
	 */
	public static String confirm(Context ctx,String jsonStr) {
		JSONObject jo=JSONObject.parseObject(jsonStr);
		String id=jo.getString("id");
		String signData=jo.getString("signData");
		jo=ResultUtils.getResultSuccess();
		try {
			IBreedSeedReceiveBill is = BreedSeedReceiveBillFactory.getLocalInstance(ctx);
			SelectorItemCollection slor=new SelectorItemCollection();
			
			BreedSeedReceiveBillInfo info = is.getBreedSeedReceiveBillInfo(new ObjectUuidPK(id));
			info.setConfirmTime(new Date());//确认时间
			slor.add("confirmTime");
			
			if(StringUtils.isNotBlank(signData)){
				info.setSignData(Base64Decoder.decode(signData));
				slor.add("signData");
			}
			is.updatePartial(info,slor);
		} catch (Exception e) {
			jo=ResultUtils.getResultError(e);
		}
		return jo.toJSONString();
	}
	protected String getListQueryStr2(Context ctx, JSONObject jo) throws BOSException {
		String beginDate=JUtils.getDateStr(jo, "beginDate", JUtils.SDF_DAY);
		String endDate=JUtils.getDateStr(jo, "endDate", JUtils.SDF_DAY);
		StringBuffer queryStr= new StringBuffer();
		queryStr.append(" FBizDate>={d '").append(beginDate).append("'}")
		.append(" and FBizDate<{d '").append(endDate).append("'}");
		
		//养户过滤
		if(StringUtils.isNotEmpty(jo.getString("farmer.id"))) {
			queryStr.append(" and FFarmerID='").append(jo.getString("farmer.id")).append("'");
		}
		 //养殖场过滤
		if(StringUtils.isNotEmpty(jo.getString("farm.id"))) {
			queryStr.append(" and FFarmID='").append(jo.getString("farm.id")).append("'");
		}
		//批次合同
		if(StringUtils.isNotEmpty(jo.getString("batchContract.id"))) {
			queryStr.append(" and FBatchContractID='").append(jo.getString("batchContract.id")).append("'");
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
				rolesStr.append(" farmer.FIdentity='").append(jo.getString("idNo")).append("'");
			}
			if(StringUtils.equalsIgnoreCase(role,"manager")){
				rolesStr.append(" farmer.fid in (")
				.append(" select distinct tentry.FFarmerID")
				.append(" from T_FM_PersonFarmerRange tmain")
				.append(" inner join T_FM_PersonFarmerRangeEntry tentry on tentry.fparentid=tmain.fid")
				.append(" inner join t_pm_user tuser on tuser.fpersonid=tmain.FPersonID")
				.append(" where tuser.fnumber='").append(jo.getString("userNum")).append("'")
				.append(" and tmain.FBaseStatus=2")
				.append(")");
			}
		}
		if(rolesStr.length()>0) {
			queryStr.append(" AND (").append(rolesStr).append(")");
		}
		
		return queryStr.toString();
	}


}
