package com.kingdee.eas.custom.tocloud.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONSerializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.assistant.CostObjectFactory;
import com.kingdee.eas.basedata.assistant.CostObjectInfo;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseFactory;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.tocloud.SynDateLogEntryInfo;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonBean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonDataBean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonF7Bean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonFAUXPROF7Bean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonFSTOCKF7Bean;
import com.kingdee.eas.custom.tocloud.bean.CloudManufactureRecBean;
import com.kingdee.eas.custom.tocloud.bean.CloudManufactureRecEntryBean;
import com.kingdee.eas.custom.tocloud.service.ISynData;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEggEntryFactory;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEggEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEntryFactory;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyFactory;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyInfo;

public class SynDataQcEggToManufacture implements ISynData {

	/**
	 * ���ҵ�������ǲ�����Ϣ��¼�ϸ�����--����cloud������ⵥ��002��
	 */
	@Override
	public String synData(Context ctx, 
			String billId, 
			String entryId,
			String targetSystemId, 
			String bizTypeId,
			List<String> errorMessage,
			SynDateLogEntryInfo synDateLogEntryInfo) throws Exception {

		//ʵ����
		StockingBreedDailyInfo stockingInfo = StockingBreedDailyFactory.getLocalInstance(ctx).getStockingBreedDailyInfo(new ObjectUuidPK(billId));
		StockingBreedDailyEggEntryInfo qcEntryInfo = StockingBreedDailyEggEntryFactory.getLocalInstance(ctx).getStockingBreedDailyEggEntryInfo(new ObjectUuidPK(entryId));

		//�趨������ʾ��ʽ
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


		//����������ⵥ��ͷ��Ϣ
		//ʵ����������ⵥ��ͷ����
		CloudManufactureRecBean manufactureBillInfo = new CloudManufactureRecBean();

		//����id
		CloudCommonF7Bean f7Bean = null;
		manufactureBillInfo.setFID("0");

		//���
		String billNum = "";
		manufactureBillInfo.setFBillNo(billNum);


		//�ֹ�Ա
		manufactureBillInfo.setFStockerId(new CloudCommonF7Bean());

		//����֯ҵ������
		String FTransferBizTypeId = "OverOrgPrdIn";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FTransferBizTypeId);
		manufactureBillInfo.setFTransferBizTypeId(f7Bean);

		//���к��ϴ�
		manufactureBillInfo.setFScanBox(null);

		manufactureBillInfo.setFStockerGroupId(new CloudCommonF7Bean());


		//�����֯
		CompanyOrgUnitInfo companyInfo = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo( new ObjectUuidPK(stockingInfo.getCompany().getId().toString()));


		String targetOrgNum = companyInfo.getNumber();
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetOrgNum);
		manufactureBillInfo.setFStockOrgId(f7Bean);

		//������֯
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetOrgNum);
		manufactureBillInfo.setFPrdOrgId(f7Bean);

		//��������
		String targetProType = "JDSCRK01_SYS";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetProType);
		manufactureBillInfo.setFBillType(f7Bean);

		//����
		String fdate = sdf.format(stockingInfo.getBizDate());
		manufactureBillInfo.setFDate(fdate);
		//����
		String targetBan = "01";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetBan);
		manufactureBillInfo.setF_BANZ2(f7Bean);

		//��ע
		manufactureBillInfo.setFDescription("��ֳ�ձ��ϸ���������ͬ��");

		//��λ��
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber("PRE001");
		manufactureBillInfo.setFCurrId(f7Bean);

		//����
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetOrgNum);
		manufactureBillInfo.setFOwnerId0(f7Bean);

		//��������
		String OwnerTypeId = "BD_OwnerOrg";
		manufactureBillInfo.setFOwnerTypeId0(OwnerTypeId);

		//����������ⵥ��¼��Ϣ
		//ʵ����������ⵥ��¼
		CloudManufactureRecEntryBean entryInfo = new CloudManufactureRecEntryBean();

		String fentryid = "0";
		entryInfo.setFEntryID(fentryid);

		//����
		String targetMatNum = "06.03.01.001";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetMatNum);
		entryInfo.setFMaterialId(f7Bean);

		//�ֿ�FStockId
		String FStockId = "ZQ06";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FStockId);
		entryInfo.setFStockId(f7Bean);


		//��λ
		entryInfo.setFStockLocId(new CloudCommonFSTOCKF7Bean());

		//����
		entryInfo.setFShiftGroupId(new CloudCommonF7Bean());

		//�������
		String  inStoreNum = "1";
		entryInfo.setFInStockType(inStoreNum);

		//��λ
		String targetUnit ="mei";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetUnit);
		entryInfo.setFUnitID(f7Bean);

		String FIsAffectCost = "true";
		entryInfo.setFIsAffectCost(FIsAffectCost);

		//������λ
		String BaseUnitId = "mei";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(BaseUnitId);
		entryInfo.setFBaseUnitId(f7Bean);

		entryInfo.setFExtAuxUnitId(new CloudCommonF7Bean());

		entryInfo.setFBomId(new CloudCommonF7Bean());

		//���״̬
		String targetStatus = "KCZT01_SYS";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetStatus);
		entryInfo.setFStockStatusId(f7Bean);

		//������
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetOrgNum);
		entryInfo.setFKeeperId(f7Bean);

		//����������
		String KeeperTypeId= "BD_KeeperOrg";
		entryInfo.setFKeeperTypeId(KeeperTypeId);

		//��������FProduceDate
		entryInfo.setFProduceDate(null);

		//��Ч����
		entryInfo.setFExpiryDate(null);

		entryInfo.setFSecUnitId(new CloudCommonF7Bean());





		//����
		String targetustQty = null;
		if(qcEntryInfo.getQcEggQty() != null && !"0".equalsIgnoreCase(qcEntryInfo.getQcEggQty().toString()) )
		{
			targetustQty = qcEntryInfo.getQcEggQty().toString();
		}else{
			errorMessage.add("�ϸ񵰵���������Ϊ�գ�����Ϊ0!");
		}
		entryInfo.setFMustQty(targetustQty);
		entryInfo.setFSecRealQty(null);
		entryInfo.setFBaseMustQty(targetustQty);

		//ʵ������
		entryInfo.setFExtAuxUnitQty(null);

		//ʵ������
		entryInfo.setFRealQty(targetustQty);

		//��浥λʵ������
		entryInfo.setFStockRealQty(targetustQty);

		//������λʵ������
		entryInfo.setFBaseRealQty(targetustQty);





		//��ֳ�ձ���ͷ�ĵ�ǰ�ɱ�����
		StockingBatchInfo batchInfo = null;
		try {
			batchInfo = StockingBatchFactory.getLocalInstance(ctx).getStockingBatchInfo(new ObjectUuidPK(stockingInfo.getStockingBatch().getId()));
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//����
		String FLot = batchInfo.getNumber().substring(0, 8);
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FLot);
		entryInfo.setFLot(f7Bean);

		//�������
		entryInfo.setFProductNo(FLot);

		//��������
		FarmHouseEntryInfo houseInfo = qcEntryInfo.getHouse();
		if(houseInfo != null){
			FarmHouseEntryInfo houseInfo1 = FarmHouseEntryFactory.getLocalInstance(ctx).getFarmHouseEntryInfo(new ObjectUuidPK(qcEntryInfo.getHouse().getId()));
			f7Bean = new CloudCommonF7Bean();
			f7Bean.setFNumber(houseInfo1.getNumber());
			entryInfo.setFWorkShopId1(f7Bean);
		}else{
			errorMessage.add("������Ϣ��¼�����᲻��Ϊ�գ�");
		}

		//��������
		String OwnerEntryTypeId = "BD_OwnerOrg";
		entryInfo.setFOwnerTypeId(OwnerEntryTypeId);

		//����
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetOrgNum);
		entryInfo.setFOwnerId(f7Bean);

		//��浥λ
		String StockUnitId = "mei";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(StockUnitId);
		entryInfo.setFStockUnitId(f7Bean);

		//��������
		entryInfo.setFAuxpropId(new CloudCommonFAUXPROF7Bean());

		//Դ���ݱ��
		entryInfo.setF_abc_SourceBillNo(null);

		//�ƻ����ٺ�
		entryInfo.setFMtoNo(null);


		//����һ��jsonArray
		JSONArray entryArray = new JSONArray();
		String entryStr = JSONObject.toJSONString(entryInfo, SerializerFeature.WriteNullStringAsEmpty);
		JSONObject entryJson = JSONObject.parseObject(entryStr, Feature.OrderedField);
		entryArray.add(entryJson);

		//����¼�ŵ�������
		manufactureBillInfo.setFEntity(entryArray);

		//��ʵ��ת��ΪjsonObject
		String manuString = JSONObject.toJSONString(manufactureBillInfo, SerializerFeature.WriteNullStringAsEmpty);
		JSONObject allJson = JSONObject.parseObject(manuString, Feature.OrderedField);

		//data�����
		CloudCommonDataBean cloudCommonDataBean = new CloudCommonDataBean();
		cloudCommonDataBean.setCreator("");
		cloudCommonDataBean.setNeedUpDateFields(null);
		cloudCommonDataBean.setModel(allJson);

		//�½�CloudCommonBean����
		CloudCommonBean commonBean = new CloudCommonBean();
		commonBean.setFormid("SP_InStock");
		commonBean.setData(cloudCommonDataBean);

		//��ʵ��ת��Ϊ�ַ���
		return JSONObject.toJSONString(commonBean, SerializerFeature.WriteNullStringAsEmpty);
	}

}
