package com.kingdee.eas.custom.tocloud.service.impl;

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
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
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
import com.kingdee.eas.farm.hatch.BHatchBabyBillEntryFactory;
import com.kingdee.eas.farm.hatch.BHatchBabyBillEntryInfo;
import com.kingdee.eas.farm.hatch.BHatchBabyBillFactory;
import com.kingdee.eas.farm.hatch.BHatchBabyBillInfo;
import com.kingdee.eas.farm.hatch.HatchBaseDataFactory;
import com.kingdee.eas.farm.hatch.HatchBaseDataInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;

public class SynDatabHatchBabToManufacture implements ISynData{

	/**
	 * ������ͬ������cloud������ⵥ��008��
	 */
//	@Override
	public String synData(Context ctx, String billId, String entryId,
			String targetSystemId, String bizTypeId, List<String> errorMessage,
			SynDateLogEntryInfo synDateLogEntryInfo) throws Exception {
		// TODO Auto-generated method stub

		//ʵ����
		BHatchBabyBillInfo bHatchBabyBillInfo = BHatchBabyBillFactory.getLocalInstance(ctx).getBHatchBabyBillInfo(new ObjectUuidPK(billId));
		BHatchBabyBillEntryInfo entryInfo = BHatchBabyBillEntryFactory.getLocalInstance(ctx).getBHatchBabyBillEntryInfo(new ObjectUuidPK(entryId));



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
		manufactureBillInfo.setFTransferBizTypeId(new CloudCommonF7Bean());
		//���к��ϴ�
		manufactureBillInfo.setFScanBox(null);
		manufactureBillInfo.setFStockerGroupId(new CloudCommonF7Bean());


		//�����֯
		StorageOrgUnitInfo storageInfo = StorageOrgUnitFactory.getLocalInstance(ctx).getStorageOrgUnitInfo(new ObjectUuidPK((bHatchBabyBillInfo.getCU().getId())));
		String targetOrgNum = storageInfo.getNumber();
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
		String fdate = bHatchBabyBillInfo.getBizDate().toString();
		manufactureBillInfo.setFDate(fdate);
		//����
		String targetBan = "01";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetBan);
		manufactureBillInfo.setF_BANZ2(f7Bean);

		//��ע
		manufactureBillInfo.setFDescription("����������ͬ��������ⵥ");

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
		CloudManufactureRecEntryBean entryInfo1 = new CloudManufactureRecEntryBean();

		String fentryid = "0";
		entryInfo1.setFEntryID(fentryid);

		//����
		String targetMatNum = "06.002";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetMatNum);
		entryInfo1.setFMaterialId(f7Bean);

		//�ֿ�FStockId
		String entryWareNum = "ZQ07";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(entryWareNum);
		entryInfo1.setFStockId(f7Bean);

		//��λ
		entryInfo1.setFStockLocId(new CloudCommonFSTOCKF7Bean());

		//����
		entryInfo1.setFShiftGroupId(new CloudCommonF7Bean());

		//�������
		String  inStoreNum = "1";
		entryInfo1.setFInStockType(inStoreNum);

		//��λ
		String targetUnit ="yu";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetUnit);
		entryInfo1.setFUnitID(f7Bean);

		String FIsAffectCost = "true";
		entryInfo1.setFIsAffectCost(FIsAffectCost);

		//������λ
		String BaseUnitId = "yu";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(BaseUnitId);
		entryInfo1.setFBaseUnitId(f7Bean);
		entryInfo1.setFExtAuxUnitId(new CloudCommonF7Bean());
		entryInfo1.setFBomId(new CloudCommonF7Bean());

		//���״̬
		String targetStatus = "KCZT01_SYS";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetStatus);
		entryInfo1.setFStockStatusId(f7Bean);

		//������
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetOrgNum);
		entryInfo1.setFKeeperId(f7Bean);

		//����������
		String KeeperTypeId= "BD_KeeperOrg";
		entryInfo1.setFKeeperTypeId(KeeperTypeId);
		//��������FProduceDate
		entryInfo1.setFProduceDate(null);
		//��Ч����
		entryInfo1.setFExpiryDate(null);
		entryInfo1.setFSecUnitId(new CloudCommonF7Bean());

		//����
		String targetustQty =String.valueOf(entryInfo.getHealthQty());
		entryInfo1.setFMustQty(targetustQty);
		entryInfo1.setFSecRealQty(null);
		entryInfo1.setFBaseMustQty(targetustQty);
		entryInfo1.setFExtAuxUnitQty(null);
		//ʵ������
		entryInfo1.setFRealQty(targetustQty);
		//��浥λʵ������
		entryInfo1.setFStockRealQty(targetustQty);
		//������λʵ������
		entryInfo1.setFBaseRealQty(targetustQty);




		//��ֳ�ձ���ͷ�ĵ�ǰ�ɱ�����
		StockingBatchInfo batchIfo = null;
		try {
			batchIfo = StockingBatchFactory.getLocalInstance(ctx).getStockingBatchInfo(new ObjectUuidPK(entryInfo.getStrockbatch().getId().toString()));
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//����
		String FLot = batchIfo.getNumber().substring(0, 8);
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FLot); 
		entryInfo1.setFLot(f7Bean);

		//�������
		entryInfo1.setFProductNo(FLot);

		//��������
		String WorkShopId = "ZQ08";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(WorkShopId);
		entryInfo1.setFWorkShopId1(f7Bean);

		//��������
		String OwnerEntryTypeId = "BD_OwnerOrg";
		entryInfo1.setFOwnerTypeId(OwnerEntryTypeId);

		//����
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetOrgNum);
		entryInfo1.setFOwnerId(f7Bean);

		//��浥λ
		String StockUnitId = "yu";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(StockUnitId);
		entryInfo1.setFStockUnitId(f7Bean);

		//��������
		entryInfo1.setFAuxpropId(new CloudCommonFAUXPROF7Bean());

		//Դ���ݱ��
		entryInfo1.setF_abc_SourceBillNo(null);

		//�ƻ����ٺ�
		entryInfo1.setFMtoNo(null);





		//����һ��jsonArray
		JSONArray entryArray = new JSONArray();
		String entryStr = JSONObject.toJSONString(entryInfo1, SerializerFeature.WriteNullStringAsEmpty);
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
