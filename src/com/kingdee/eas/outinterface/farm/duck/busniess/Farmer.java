package com.kingdee.eas.outinterface.farm.duck.busniess;

import java.rmi.RemoteException;

import org.apache.commons.lang.StringUtils;
import org.exolab.castor.xml.handlers.ValueOfFieldHandler;

import com.alibaba.fastjson.JSON;
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
import com.kingdee.eas.farm.carnivorous.basedata.FarmerType;
import com.kingdee.eas.farm.carnivorous.basedata.IFarm;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillCollection;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingFarmTypeEnum;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.outinterface.base.impl.AbstractOutInterfaceImpl;

/**
 * ��ֳ��
 * @author alex_dai
 *
 */
public class Farmer extends AbstractOutInterfaceImpl {
	@Override
	protected String getBosType() {
		// TODO Auto-generated method stub
		return "FA0A7F85";
	}

	@Override
	protected String[] getListSelector() {
		// TODO Auto-generated method stub
		return new String[]{"id","number","name","sex","identity","tel","company.name","baseStatus","mobileTel","person.id","person.name",
				"FarmEntry.farm.id","FarmEntry.farm.name","FarmEntry.farm.number","TREEID.NAME","FARMENTRY.FARM.MILESTD","FARMENTRY.FARM.GM"
				,"FARMENTRY.FARM.ADDRESS","costCenter.name"};
	}
	
	@Override
	protected String getSortStr(JSONObject jo) {
		// TODO Auto-generated method stub
		String type=jo.getString("type");
		if(StringUtils.isEmpty(type)){
			type="ASC";
		}
		String farmerName=jo.getString("name");
		String costCenterName=jo.getString("costCenter.name");
		String GM=jo.getString("FARMENTRY.FARM.GM");
		String MILESTD=jo.getString("FARMENTRY.FARM.MILESTD");
		String treeName=jo.getString("TREEID.NAME");
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
		return "order by "+str;
	}

	@Override
	protected String[] getDataSelector() {
		//��ϸ���棺��������������ϵ��ʽ����ֳ���ֻ����룩��֤�����루��ֳ�����֤�ţ���ҵ��Ա����ֳ������ַ����ֳ���ĵ�ַ��
		//��ֳ��֯����ֳ��ģ����ֳ������ֳ��ģ������ֳ�������ֳ������ֳ��������������
		//��ϸ���桪����ѯ�����������Բ�ѯ�������������ˡ�Ѻ�𡢶�λ��������ͬ�������ͬ���������ͬ����ɲ�ѯ�����κ�ͬ����ʼʱ�䡢����ʱ�䣩
		return new String[]{"TREEID.NAME","name","number","address","mobileTel","identity","person.id","person.name"
				,"FarmEntry.farm.id","FarmEntry.farm.name","FarmEntry.farm.number","occupyMargin","enableMargin","FarmEntry.farm.farmType"
				,"FarmEntry.farm.mnemonicCode","FarmEntry.farm.address","FarmEntry.farm.gm","FarmEntry.farm.area","FarmEntry.memoryCode"
				,"FarmEntry.farm.mileStd","FarmEntry.farm.costCenter.name","FarmEntry.farm.costCenter.id"
				};
	}

	
	@Override
	public JSONObject getData(Context ctx, String jsonStr) throws BOSException,
			EASBizException, RemoteException {
		//����������ͬ��ѯ�������˲�ѯ  
		JSONObject paramsJson=JSONObject.parseObject(jsonStr);
		JSONObject reusltJson = super.getData(ctx, jsonStr);
        String bContractName=null;
		BatchContractBillCollection  batchColl=null;
		BatchContractBillInfo bInfo=null;
		if(reusltJson.getString("result").equals("0")) {
			JSONObject dataJson=reusltJson.getJSONObject("data");			
			String farmerID=dataJson.getString("id");
			JSONArray FarmEntry=dataJson.getJSONArray("FarmEntry");
			JSONObject farm=null;
			String farmType=null;
			FarmInfo  finfo=null;
			IFarm ifarm=FarmFactory.getLocalInstance(ctx);
			String farmid=null;
			String costCenterName=null;
			String costcenterID=null;
			SelectorItemCollection sic=new SelectorItemCollection();
			sic.add(new SelectorItemInfo("costCenter.id"));
			sic.add(new SelectorItemInfo("costCenter.name"));
			for(int i=0;i<FarmEntry.size();i++){
				farm=FarmEntry.getJSONObject(i).getJSONObject("farm");
				farmType=FarmEntry.getJSONObject(i).getJSONObject("farm").getString("farmType");
				farmType=StockingFarmTypeEnum.getEnum(Integer.valueOf(farmType)).getAlias();
				farm.put("farmTypeAlias", farmType);
				farmid=FarmEntry.getJSONObject(i).getJSONObject("farm").getString("id");
				finfo=ifarm.getFarmInfo(new ObjectUuidPK(farmid),sic);
				costCenterName=finfo.getCostCenter().getName();
				costcenterID=finfo.getCostCenter().getId().toString();
				farm.put("costCenter.id", costcenterID);
				farm.put("costCenter.name", costCenterName);
				
			}
			if(farmerID!=null){
				batchColl=BatchContractBillFactory.getLocalInstance(ctx).getBatchContractBillCollection("where farmer.id='"+farmerID+"' and isRecSettled=0");
				for(int i=0;i<batchColl.size();i++){
					bInfo=batchColl.get(i);
					if(bContractName==null){
						bContractName=" ";
						bContractName=bContractName.concat(bInfo.getNumber()==null?"":bInfo.getNumber());
					}else{
						bContractName=bContractName.concat(";").concat(bInfo.getNumber()==null ? "":bInfo.getNumber());
					}					
				}				
			}
			//��ȡ��ǰ��ֳ���������κ�ͬ			
		    dataJson.put("currBatchContract", bContractName);
		}
		return reusltJson;
	}

	/**
	 * ��ȡ���ݺ���
	 */
	@Override
	public CoreBaseInfo dealBeforeGetDataJSON(Context ctx, CoreBaseInfo model) {
		FarmerInfo info=(FarmerInfo) model;
//		info.getFarmEntry().clear();
		return info;
	}
	@Override
	protected String getListQueryStr(Context ctx, JSONObject jo) throws BOSException {
		StringBuffer queryStr=new StringBuffer();
		queryStr.append(" baseStatus=2 ");//����״̬
		if(StringUtils.isNotEmpty(jo.getString("person.id"))) {//ҵ��Ա
			queryStr.append(" and person.id='").append(jo.getString("person.id")).append("'");
		}
		if(StringUtils.isNotEmpty(jo.getString("tree.id"))) {//����(���)
			queryStr.append(" and treeid.id='").append(jo.getString("tree.id")).append("'");
		}
		if(StringUtils.isNotEmpty(jo.getString("farmerName"))) {//����
			queryStr.append(" and name like '%"+jo.getString("farmerName")+"%'");
		}
		if(StringUtils.isNotEmpty(jo.getString("name"))) {//����
			queryStr.append(" and name like '%"+jo.getString("name")+"%'");
		}
//		if(StringUtils.isNotEmpty(jo.getString("company.id"))) {//��ֳ��֯
//			queryStr.append(" and company.id='").append(jo.getString("company.id")).append("'");
//		}
		
		//��ɫ
		StringBuffer rolesStr=new StringBuffer();
		JSONArray rolesArray = jo.getJSONArray("roles");
		for(int index=0;index<rolesArray.size();index++) {
			String role=rolesArray.getString(index);
			if(rolesStr.length()>0) {
				rolesStr.append(" OR ");
			}
			if(StringUtils.equalsIgnoreCase(role,"farmer")){
				rolesStr.append(" identity='").append(jo.getString("idNo")).append("'");
			}
			if(StringUtils.equalsIgnoreCase(role,"manager")){
				rolesStr.append(" id in (")
				.append(" select distinct tentry.FFarmerID")
				.append(" from T_FM_PersonFarmerRange tmain")
				.append(" inner join T_FM_PersonFarmerRangeEntry tentry on tentry.fparentid=tmain.fid")
				.append(" inner join t_pm_user tuser on tuser.fpersonid=tmain.FPersonID")
				.append(" where tuser.fnumber='").append(jo.getString("userNum")).append("'")
				.append(" and tmain.FBaseStatus=2")
				.append(")");
			}
			//˾��--����������Χ����
			if(StringUtils.equalsIgnoreCase(role,"driver")){
				rolesStr.append(" id in (")
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
			if(StringUtils.isNotEmpty(jo.getString("find"))){
				queryStr.append(" AND (").append(rolesStr).append(") and FarmEntry.seq=1");
			}else{
				queryStr.append(" AND (").append(rolesStr).append(") ");
			}
		}		
		return queryStr.toString();
	}
}
