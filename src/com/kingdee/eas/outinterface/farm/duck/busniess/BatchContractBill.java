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
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillCollection;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.outinterface.base.impl.AbstractOutInterfaceImpl;
import com.kingdee.eas.outinterface.base.utils.JUtils;
import com.kingdee.eas.outinterface.base.utils.ResultUtils;

/**
 * ��Ʒ�����κ�ͬ
 * @author zhanzg
 *
 */
public class BatchContractBill extends AbstractOutInterfaceImpl {

	@Override
	protected String getBosType() {
		// TODO Auto-generated method stub
		return "F66F7EAF";
	}
	
	

	@Override
	protected String[] getDataSelector() {
		// TODO Auto-generated method stub
		//��ϸ���棺��ͬ��š���ͬ���ڡ���ͬ���͡���ֳ������ϵ��ʽ��������ַ����ֳ����ַ����
		//��ͬ���������ۣ�����۸񣩡���ͬ����ͬ����*���ۣ����Ƿ�������ʶ���Ƿ���ȫ���ս����־����ҵ��Ա
		return new String[]{
				"id","number","bizDate","billStatus","breedData.name"
				,"breedType","farmer.name","farm.name","mobileTel"
				,"operator.number","operator.name","person.name","person.id"
				,"farmAddress","breedPrice","femaleBreedQty","chickenCnt","isRecSettled"
		};
	}
	@Override
	public JSONObject getData(Context ctx, String jsonStr) throws BOSException,
			EASBizException, RemoteException {
		//�����ͬ���
		JSONObject paramsJson=JSONObject.parseObject(jsonStr);
		JSONObject reusltJson = super.getData(ctx, jsonStr);
        BigDecimal price =BigDecimal.ZERO ,qty=BigDecimal.ZERO, amount=BigDecimal.ZERO;
		if(reusltJson.getString("result").equals("0")) {
			JSONObject dataJson=reusltJson.getJSONObject("data");
			price=dataJson.getBigDecimal("breedPrice")==null? BigDecimal.ZERO :dataJson.getBigDecimal("breedPrice");
			qty=dataJson.getBigDecimal("femaleBreedQty")==null? BigDecimal.ZERO : dataJson.getBigDecimal("femaleBreedQty");
			amount=price.multiply(qty).setScale(2,BigDecimal.ROUND_HALF_UP);
			//��ȡ��ǰ��ֳ���������κ�ͬ			
		    dataJson.put("amount", amount);
		}
		return reusltJson;
	}
	/**
	 * ��ȡ���ݺ���
	 */
	@Override
	public CoreBaseInfo dealBeforeGetDataJSON(Context ctx, CoreBaseInfo model) {
		BatchContractBillInfo info=(BatchContractBillInfo) model;
		info.getReceiveBillEntry().clear();
		return info;
	}



	@Override
	protected String[] getListSelector() {
		//�б���棺��ͬ��š���ͬ���ڡ���ͬ���ͣ������κ�ͬ����ֳ���ͣ�����ֳ������ֳ������ͬ������
		//�����򣨿ɸ�����ֳʱ��������������������ֳ��ģ����������򡢵�������
		return new String[]{"id","number","bizDate","billStatus","farmer.name","farm.name","person.name","person.id",
				"breedType","breedData.name","femaleBreedQty","FARM.MILESTD","FARM.costCenter.name","FARM.GM","TREEID.NAME"};
	}
	
	@Override
	protected String getSortStr(JSONObject jo) {
		// TODO Auto-generated method stub
		String type=jo.getString("type");
		if(StringUtils.isNotEmpty(type)){
			type="ASC";
		}
		String farmerName=jo.getString("farmer.name");//��������
		String costCenterName=jo.getString("FARM.costCenter.name");//�ɱ�����
		String GM=jo.getString("FARM.GM");//��ֳ��ģ
		String MILESTD=jo.getString("FARM.MILESTD");//�������
		String treeName=jo.getString("TREEID.NAME");//����
		String str=null;
		if(StringUtils.isNotEmpty(farmerName)){
			str=" name " +type;
		}else if(StringUtils.isNotEmpty(costCenterName)){
			str=" costCenter.name " +type;
		}else if(StringUtils.isNotEmpty(GM)){
			str=" FARMENTRY.FARM.GM " +type;
		}else if(StringUtils.isNotEmpty(MILESTD)){
			str=" FARMENTRY.FARM.MILESTD " +type;
		}else if(StringUtils.isNotEmpty(treeName)){
			str=" TREEID.NAME " +type;
		}else{
			str=" name " +type;
		}
		return "order by number desc";
	}

	@Override
	protected String getListQueryStr(Context ctx, JSONObject jo) throws BOSException {
		String beginDate=JUtils.getDateStr(jo, "beginDate", JUtils.SDF_DAY);
		String endDate=JUtils.getDateStr(jo, "endDate", JUtils.SDF_DAY);
		StringBuffer queryStr= new StringBuffer();
		if(StringUtils.isNotEmpty(jo.getString("billFind"))){
			if(jo.getBoolean("billFind")){
				queryStr.append(" billStatus=4");
			}else{
				queryStr.append(" bizDate>={d '").append(beginDate).append("'}")
				.append(" and bizDate<{d '").append(endDate).append("'}");
				//ֻ��ʾ��˵�
				queryStr.append(" and billStatus=4");
			}
		}else{
			queryStr.append(" bizDate>={d '").append("2019-01-10").append("'}")
			.append(" and bizDate<{d '").append(endDate).append("'}");
			//ֻ��ʾ��˵�
			queryStr.append(" and billStatus=4");
		}		
		//��������
		if(StringUtils.isNotEmpty(jo.getString("farmer.id"))) {
			queryStr.append(" and farmer.id='").append(jo.getString("farmer.id")).append("'");
		}
		//��ֳ������
		if(StringUtils.isNotEmpty(jo.getString("farm.id"))) {
			queryStr.append(" and farm.id='").append(jo.getString("farm.id")).append("'");
		}
		//�Ƿ�����ѽ������κ�ͬ
		if(StringUtils.isNotEmpty(jo.getString("isRecSettled"))){
			if(jo.getBoolean("isRecSettled")){
				queryStr.append(" and isRecSettled=1");
			}
		}
		
		if(StringUtils.isNotEmpty(jo.getString("number"))) {
//			queryStr.append(" and (name like '%"+jo.getString("number")+"%' or  number like '%"+jo.getString("number")+"%')");
			queryStr.append(" and number like '%"+jo.getString("number")+"%'"); 
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
}
