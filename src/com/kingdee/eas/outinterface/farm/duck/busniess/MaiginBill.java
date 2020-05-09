package com.kingdee.eas.outinterface.farm.duck.busniess;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.carnivorous.basebiz.MaiginBillEntryCollection;
import com.kingdee.eas.farm.carnivorous.basebiz.MaiginBillEntryInfo;
import com.kingdee.eas.farm.carnivorous.basebiz.MaiginBillFactory;
import com.kingdee.eas.farm.carnivorous.basebiz.MaiginBillInfo;
import com.kingdee.eas.farm.carnivorous.basedata.BatchFactory;
import com.kingdee.eas.farm.carnivorous.basedata.BatchInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.outinterface.base.impl.AbstractOutInterfaceImpl;
import com.kingdee.eas.outinterface.base.utils.JUtils;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * 商品禽保证金收退单
 * @author zhanzg
 *
 */
public class MaiginBill extends AbstractOutInterfaceImpl {


	@Override
	protected String getBosType() {
		// TODO Auto-generated method stub
		return "AB4CBAD5";
	}
	
	
	@Override
	protected String[] getListSelector() {
		// TODO Auto-generated method stub
		return new String[]{"id","number","name","farm.name","person.name"
				,"farmer.name","isBorrow","bizdate","actualPayAmt","bizType"
				//业务类型、日期、金额
//				,"batchContract.number"				
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
				,"farmer.name","bizType","bizdate","actualPayAmt"
				//业务类型、日期、金额
		};
	}


	@Override
	public JSONObject getData(Context ctx, String jsonStr) throws BOSException, EASBizException, RemoteException {
		// TODO Auto-generated method stub
		JSONObject paramsJson=JSONObject.parseObject(jsonStr);		
		JSONObject reusltJson = super.getData(ctx, jsonStr);
		if(reusltJson.getString("result").equals("0")) {
			JSONObject dataJson=reusltJson.getJSONObject("data");
			String billid=dataJson.getString("id");			
			MaiginBillInfo info=MaiginBillFactory.getLocalInstance(ctx).getMaiginBillInfo(new ObjectUuidPK(billid));
			int entrycount=info.getEntrys().size();
			String batchContract=null;
			MaiginBillEntryInfo einfo=null;
			String status=null;
			if(entrycount>1){
				//获取在养批次合同
				MaiginBillEntryCollection colls=info.getEntrys();
				for(int i=0;i<colls.size();i++){
					einfo=colls.get(i);
					status=einfo.getStatus();
					if(status.isEmpty()){
						continue;
					}else{
						if(status.equals("在养")){
							batchContract=einfo.getBatchContract().getNumber();
							batchContract=BatchContractBillFactory
							.getLocalInstance(ctx).getBatchContractBillInfo(new ObjectUuidPK(einfo.getBatchContract().getId())).getNumber();
							break;
						}
					}
				}
			}
			dataJson.put("batchContract", batchContract);//在养批次
		}
		
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
			queryStr.append(" AND (").append(rolesStr).append(")");
		}

		return queryStr.toString();
	}
}
