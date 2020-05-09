package com.kingdee.eas.outinterface.farm.duck.busniess;

import java.math.BigDecimal;
import java.rmi.RemoteException;

import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.carnivorous.basedata.BatchFactory;
import com.kingdee.eas.farm.carnivorous.basedata.BatchInfo;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo;

public class Material extends com.kingdee.eas.outinterface.base.impl.Material {
	//��Ʒ������
	public final static String fodderMaterialNum="0201";//����
	public final static String drugMaterialGroupNumber = "0103"; //ҩƷ
	@Override
	protected String getListQueryStr(Context ctx, JSONObject jo) throws BOSException {
		// TODO Auto-generated method stub
		String queryStr= super.getListQueryStr(ctx, jo);
		String batchContractID=jo.getString("batchContractID");
		String policyID=null;
		BatchInfo batchinfo=null;
		//�������κ�ͬѰ�Ҷ�Ӧ��������
		BatchContractBillInfo contractInfo=null;
		try {
			if(batchContractID!=null){
				SelectorItemCollection slor=new SelectorItemCollection();
				slor.add("batchContract.settlementPolicy");
				slor.add("batchContract.id");
				batchinfo=BatchFactory.getLocalInstance(ctx).getBatchInfo(new ObjectUuidPK(batchContractID),slor);
				contractInfo = batchinfo.getBatchContract();
				policyID=contractInfo.getSettlementPolicy().getId().toString();
				String materilGroupNum=jo.getString("materialGroup.number");
				if(materilGroupNum.equalsIgnoreCase(fodderMaterialNum)) {
					String str=" select FMaterialID from T_FM_SettlePolicyPriceEntry \n  "+
					           " where fparentid='"+policyID+"' \n"+
					           " and FSettlementItemID='4qoAAAAIVQQ7wRVt' "; //������ĿΪ����
					queryStr+=" AND id in ("+str+")";
				}else if(materilGroupNum.equalsIgnoreCase(drugMaterialGroupNumber)){
					String str=" select FMaterialID from T_FM_SettlePolicyPriceEntry \n  "+
			           " where fparentid='"+policyID+"' \n"+
			           " and FSettlementItemID in ('4qoAAAAIVQU7wRVt','4qoAAAAIVQg7wRVt') "; //������ĿΪҩƷ
			        queryStr+=" AND id in ("+str+")";
				}
			}			
		} catch (EASBizException e) {
			throw  new BOSException(e);
		}
		
		return queryStr;
	}
	@Override
	public JSONObject getData(Context ctx, String jsonStr) throws BOSException,
			EASBizException, RemoteException {
		// �������ϻ�ȡ��������Ϣ
		JSONObject paramsJson=JSONObject.parseObject(jsonStr);
		JSONObject reusltJson = super.getData(ctx, jsonStr);
		String materialID=null,batchid=null,curCompanyID=null;
		BigDecimal unitQty=BigDecimal.ZERO;
		if(reusltJson.getString("result").equals("0")) {
			JSONObject dataJson=reusltJson.getJSONObject("data");
			batchid=paramsJson.getString("batchId");//����ID
			materialID=dataJson.getString("id");
			if(batchid.isEmpty()||materialID.isEmpty()){
				return reusltJson;
			}
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add("*");
			slor.add("farm.storageOrgUnit.id");
//			slor.add("farmer.*");
			BatchInfo batchInfo = BatchFactory.getLocalInstance(ctx).getBatchInfo(new ObjectUuidPK(batchid),slor);
	        if(batchInfo!=null){
//	        	curCompanyID=batchInfo.getFarm().getStorageOrgUnit().getId().toString();
	        	curCompanyID=batchInfo.getCompany().getId().toString();
	        }
	        unitQty=StockingComm.getUnitQty(ctx, curCompanyID, materialID);
	        dataJson.put("unitQty", unitQty);
		}		
		return reusltJson;
	}
    

	
}
