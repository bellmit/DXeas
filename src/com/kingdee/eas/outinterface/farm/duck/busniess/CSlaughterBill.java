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
import com.kingdee.eas.farm.carnivorous.recyclebiz.CSlaughterBillFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CSlaughterBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.ICSlaughterBill;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.industry.emm.pm.SqlExecuteFacadeFactory;
import com.kingdee.eas.outinterface.base.impl.AbstractOutInterfaceImpl;
import com.kingdee.eas.outinterface.base.utils.JUtils;
import com.kingdee.eas.outinterface.base.utils.ResultUtils;
import com.kingdee.jdbc.rowset.IRowSet;
/**
 * ���׵�
 * @author zhanzg
 *
 */
public class CSlaughterBill  extends AbstractOutInterfaceImpl{

	@Override
	protected String getBosType() {
		// TODO Auto-generated method stub
		return "5A968454";
	}
	
	

	@Override
	protected String[] getDataSelector() {
		//��ϸ���棺���ڡ���������ϵ��ʽ����ֳ�������κ�ͬ����ͬ���ͣ���Ʒ�֣���
		//���أ���������+�۷�����+�������������������ء��۷����ء�����������
		//����ֻ����ֻ�ء�A��ֻ����������B��ֻ��������
		return new String[]{
				"id","number","bizDate","billStatus","confirmTime"
				,"batch.number","farmer.name","farm.name","farmerPhone","breedData.name"
				,"operator.number","operator.name","person.id","person.name"
				,"returnWeight","punishWgt","settleWeight"
				//�������ء��۷����ء���������
				,"AWeight","AQty","BQty","BWeight","receQty","avgWeight"//
				//����ֻ����ֻ�ء�A��ֻ����������B��ֻ��������
				,"punishAmt","deathQty"
				//�۷��ܽ�����ֻ��
		};
	}
	
	/**
	 * ��ȡ���ݺ���
	 */
	@Override
	public CoreBaseInfo dealBeforeGetDataJSON(Context ctx, CoreBaseInfo model) {
		CSlaughterBillInfo info=(CSlaughterBillInfo) model;
		//�Ƴ�ǩ������
//		info.setSignData(null);
		info.getQCEntrys().clear();
		return info;
	}



	@Override
	public JSONObject getData(Context ctx, String jsonStr) throws BOSException,
			EASBizException, RemoteException {
		//���أ���������+�۷�����+����������
		JSONObject paramsJson=JSONObject.parseObject(jsonStr);
		JSONObject reusltJson = super.getData(ctx, jsonStr);
        BigDecimal returnWeight =BigDecimal.ZERO ,punishWgt=BigDecimal.ZERO, settleWeight=BigDecimal.ZERO;
        BigDecimal suttleWgt =BigDecimal.ZERO;
		if(reusltJson.getString("result").equals("0")) {
			JSONObject dataJson=reusltJson.getJSONObject("data");
			returnWeight=dataJson.getBigDecimal("returnWeight")==null? BigDecimal.ZERO :dataJson.getBigDecimal("returnWeight");
			punishWgt=dataJson.getBigDecimal("punishWgt")==null? BigDecimal.ZERO : dataJson.getBigDecimal("punishWgt");
			settleWeight=dataJson.getBigDecimal("settleWeight")==null? BigDecimal.ZERO : dataJson.getBigDecimal("settleWeight");
			suttleWgt=returnWeight.add(punishWgt).add(settleWeight);
			//��ȡ��ǰ��ֳ���������κ�ͬ			
		    dataJson.put("suttleWgt", suttleWgt);
		}
		return reusltJson;
		
	}



	@Override
	protected String[] getListSelector() {
		// TODO Auto-generated method stub
		//��������(settleWeight)������ֻ��(receQty)��ֻ��(avgWeight)
		return new String[]{"id","number","bizDate","billStatus","farmer.name","farm.name","inDate","costCenter.name"
				,"batchContract.number","batchContract.name","settleWeight","receQty","qualifiedAvg","avgWeight"
				,"confirmTime","person.name"};
	}
	
	@Override
	protected String getSortStr(JSONObject jo) {
		// TODO Auto-generated method stub
		String type=jo.getString("type");
		if(StringUtils.isEmpty(type)){
			type="ASC";
		}
		String bizDate=jo.getString("bizDate");
		String inDate=jo.getString("inDate");
		String farmerName=jo.getString("farmer.name");
		String costCenter=jo.getString("costCenter.name");
		String str=null;
		if(StringUtils.isNotEmpty(bizDate)){
			str=" bizDate desc";
		}else if(StringUtils.isNotEmpty(inDate)){
			str=" inDate desc ";
		}else if(StringUtils.isNotEmpty(farmerName)){
			str=" farmer.name " +type;
		}else if(StringUtils.isNotEmpty(costCenter)){
			str=" costCenter.name " +type;
		}else{
			str=" bizDate desc";
		}
		return "order by "+str;
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
        BigDecimal settleWeight=BigDecimal.ZERO, receQty=BigDecimal.ZERO;
        if(reusltJson.getString("result").equals("0")) {
        	dataJson=reusltJson.getJSONArray("data");
        	if(!dataJson.isEmpty()){
        		for(int i=0;i<dataJson.size();i++){
//        			settleWeight=settleWeight.add(dataJson.getJSONObject(i).getBigDecimal("settleWeight")==null ?BigDecimal.ZERO
//        					:dataJson.getJSONObject(i).getBigDecimal("settleWeight"));
//        			receQty=receQty.add(dataJson.getJSONObject(i).getBigDecimal("receQty")==null ?BigDecimal.ZERO
//        					:dataJson.getJSONObject(i).getBigDecimal("receQty"));
        			
        			//����ҳ�뷵�أ����ز�ѯ�����������
            		try {
                		sql.append("select sum(isnull(cs.CFsettleWeight,0)) settleWeight, sum(isnull(cs.CFReceQty,0)) CFReceQty from CT_FM_CSlaughterBill cs \n")
                		   .append(" inner join CT_FM_Farmer farmer on farmer.fid= cs.CFFarmerID \n")
                		   .append(" where "+getListQueryStr2(ctx,paramsJson)+"");
                		IRowSet rs= SqlExecuteFacadeFactory.getLocalInstance(ctx).executeQuery(sql.toString());
                		if(rs.next()){
                			settleWeight=rs.getBigDecimal("settleWeight");
                			receQty=rs.getBigDecimal("CFReceQty");
                		}
    				} catch (Exception e) {
    					e.printStackTrace();
    				} 
        		}
        		dataJsonDetail=dataJson.getJSONObject(0);
            	dataJsonDetail.put("sum_settleWeight", settleWeight);
            	dataJsonDetail.put("sum_receQty", receQty);
        	}        	
		}		
		return reusltJson;
	}
	@Override
	protected String getListQueryStr(Context ctx, JSONObject jo) throws BOSException {
		String beginDate=JUtils.getDateStr(jo, "beginDate", JUtils.SDF_DAY);
		String endDate=JUtils.getDateStr(jo, "endDate", JUtils.SDF_DAY);
		StringBuffer queryStr= new StringBuffer();
		//ֻ��ʾ��˵�
		queryStr.append("  billStatus=4");
		//���isCsQuery=true ���ڲ���Ĭ��ȡ������죬������������
		if(jo.getString("isCsQuery").equals(true)){
		queryStr.append("and bizDate>={d '").append(beginDate).append("'}")
		.append(" and bizDate<{d '").append(endDate).append("'}");
		}
		//��������
		if(StringUtils.isNotEmpty(jo.getString("farmer.id"))) {
			queryStr.append(" and farmer.id='").append(jo.getString("farmer.id")).append("'");
		}
		//��ֳ������
		if(StringUtils.isNotEmpty(jo.getString("farm.id"))) {
			queryStr.append(" and farm.id='").append(jo.getString("farm.id")).append("'");
		}
		//���κ�ͬ
		if(StringUtils.isNotEmpty(jo.getString("batchContract.id"))) {
			queryStr.append(" and batchContract.id='").append(jo.getString("batchContract.id")).append("'");
		}
		//��ɫ
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
	
	/**
	 * ȷ�ϵ���
	 */
	public static String confirm(Context ctx,String jsonStr) {
		JSONObject jo=JSONObject.parseObject(jsonStr);
		String id=jo.getString("id");
		String signData=jo.getString("signData");
		jo=ResultUtils.getResultSuccess();
		try {
			ICSlaughterBill is= CSlaughterBillFactory.getLocalInstance(ctx);
			SelectorItemCollection slor=new SelectorItemCollection();
			
			CSlaughterBillInfo info = is.getCSlaughterBillInfo(new ObjectUuidPK(id));
//			info.setConfirmTime(new Date());
//			slor.add("confirmTime");			
//			if(StringUtils.isNotBlank(signData)){
//				info.setSignData(Base64Decoder.decode(signData));
//				slor.add("signData");
//			}
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
		
		//ֻ��ʾ��˵�
		queryStr.append(" and CFBillStatus=4");
		//��������
		if(StringUtils.isNotEmpty(jo.getString("farmer.id"))) {
			queryStr.append(" and CFFarmerID='").append(jo.getString("farmer.id")).append("'");
		}
		 //��ֳ������
		if(StringUtils.isNotEmpty(jo.getString("farm.id"))) {
			queryStr.append(" and CFFarmID='").append(jo.getString("farm.id")).append("'");
		}
		//���κ�ͬ
		if(StringUtils.isNotEmpty(jo.getString("batchContract.id"))) {
			queryStr.append(" and CFBatchContractID='").append(jo.getString("batchContract.id")).append("'");
		}
		//��ɫ
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
