package com.kingdee.eas.custom.tocloud.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseFactory;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.tocloud.SynDateLogEntryInfo;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonBean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonDataBean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonF7Bean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonFAUXPROF7Bean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonFSTOCKF7Bean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonStaffF7Bean;
import com.kingdee.eas.custom.tocloud.bean.CloudManufactureOutWareBean;
import com.kingdee.eas.custom.tocloud.bean.CloudManufactureOutWareEntryBean;
import com.kingdee.eas.custom.tocloud.bean.CloudManufactureRecBean;
import com.kingdee.eas.custom.tocloud.bean.CloudManufactureRecEntryBean;
import com.kingdee.eas.custom.tocloud.bean.OtherOutWarehsBillBean;
import com.kingdee.eas.custom.tocloud.bean.OtherOutWarehsBillEntry;
import com.kingdee.eas.custom.tocloud.service.ISynData;
import com.kingdee.eas.farm.hatch.BEggHatchBillEggEntryFactory;
import com.kingdee.eas.farm.hatch.BEggHatchBillEggEntryInfo;
import com.kingdee.eas.farm.hatch.BEggHatchBillFactory;
import com.kingdee.eas.farm.hatch.BEggHatchBillInfo;
import com.kingdee.eas.farm.hatch.HatchBaseDataFactory;
import com.kingdee.eas.farm.hatch.HatchBaseDataInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEggEntryFactory;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEggEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyFactory;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyMatUserEntryFactory;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyMatUserEntryInfo;

public class SynDataBEggHatchToManufacture implements ISynData{

	/**
	 * �ֵ��Ϸ����˵�����ͬ���������ⵥ
	 */
//	@Override
	public String synData(Context ctx, String billId, String entryId,
			String targetSystemId, String bizTypeId, List<String> errorMessage,
			SynDateLogEntryInfo synDateLogEntryInfo) throws Exception {
		//ʵ����
		BEggHatchBillInfo stockingInfo = BEggHatchBillFactory.getLocalInstance(ctx).getBEggHatchBillInfo(new ObjectUuidPK(billId));
		BEggHatchBillEggEntryInfo qcEntryInfo = BEggHatchBillEggEntryFactory.getLocalInstance(ctx).getBEggHatchBillEggEntryInfo(new ObjectUuidPK(entryId));


		//�趨������ʾ��ʽ
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");



		//����һ���������ⵥ��¼
		OtherOutWarehsBillBean billInfo = new OtherOutWarehsBillBean();
		CloudCommonF7Bean f7Bean = null;
		//fid
		billInfo.setFID("0");

		//���ݱ��
		billInfo.setFBillNo(null);

		//��������
		String FBillTypeID = "QTCKD01_SYS";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FBillTypeID);
		billInfo.setFBillTypeID(f7Bean);

		//�����֯
		String FStockOrgId = "TYZQ";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FStockOrgId);
		billInfo.setFStockOrgId(f7Bean);

		//������֯
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FStockOrgId);
		billInfo.setFPickOrgId(f7Bean);

		//��淽��
		String FStockDirect = "GENERAL";
		billInfo.setFStockDirect(FStockDirect);

		//����
		String FDate = stockingInfo.getBizDate().toString();
		billInfo.setFDate(FDate);

		//�ͻ�
		billInfo.setFCustId(new CloudCommonF7Bean());

		//���ϲ���--����
		FarmHouseEntryInfo house = FarmHouseEntryFactory.getLocalInstance(ctx).getFarmHouseEntryInfo(new ObjectUuidPK(qcEntryInfo.getOutHouse().getId()));
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(house.getNumber());
		billInfo.setFDeptId(f7Bean);


		//������
		billInfo.setFPickerId( new CloudCommonStaffF7Bean());

		//�ֹ�Ա
		billInfo.setFStockerId(new CloudCommonF7Bean());

		//�����
		billInfo.setFStockerGroupId(new CloudCommonF7Bean());

		//ҵ������
		String FBizType = "0";
		billInfo.setFBizType(FBizType);

		//��������
		String FOwnerTypeIdHead = "BD_OwnerOrg";
		billInfo.setFOwnerTypeIdHead(FOwnerTypeIdHead);

		//����
		String FOwnerIdHead = "TYZQ";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FOwnerIdHead);
		billInfo.setFOwnerIdHead(f7Bean);

		//��ע
		String FNote = "�ֵ��Ϸ����˵�����ͬ���������ⵥ";
		billInfo.setFNote(FNote);

		//��λ��
		String FBaseCurrId = "PRE001";		
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FBaseCurrId);
		billInfo.setFBaseCurrId(f7Bean);

		//���к��ϴ�
		String FScanBox = "FScanBox";
		billInfo.setFScanBox(FScanBox);

		//��������
		String F_abc_Base = "001";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(F_abc_Base);
		billInfo.setF_abc_Base(f7Bean);





		//����һ���������ⵥ��¼
		OtherOutWarehsBillEntry entryInfo = new OtherOutWarehsBillEntry();
		//����һ��jsonArray
		JSONArray entryArray = new JSONArray();

		//��¼ID
		String FEntryID = "0";
		entryInfo.setFEntryID(FEntryID);

		//���ϱ���
		String FMaterialId = "06.03.01.001";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FMaterialId);
		entryInfo.setFMaterialId(f7Bean);

		//��������
		entryInfo.setFAuxPropId(new CloudCommonFAUXPROF7Bean());

		//��λ
		String FUnitID = "01";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FUnitID);
		entryInfo.setFUnitID(f7Bean);

		//ʵ������
		String FQty = String.valueOf(qcEntryInfo.getReFundEgg());
		entryInfo.setFQty(FQty);

		//������λ
		String FBaseUnitId = "01";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FBaseUnitId);
		entryInfo.setFBaseUnitId(f7Bean);

		//�����ֿ�
		String FStockId = "ZQ06";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FStockId);
		entryInfo.setFStockId(f7Bean);

		//��λ
		entryInfo.setFStockLocId(new CloudCommonFSTOCKF7Bean());

		//����
		StockingBatchInfo batchInfo = qcEntryInfo.getOutBatch();
		StockingBatchInfo batchInfo1 = null;
		if(batchInfo != null){
			batchInfo1 = StockingBatchFactory.getLocalInstance(ctx).getStockingBatchInfo(new ObjectUuidPK(batchInfo.getId()));
			String batchNum = batchInfo1.getNumber().substring(0, 8);
			f7Bean = new CloudCommonF7Bean();
			f7Bean.setFNumber(batchNum);
			entryInfo.setFLot(f7Bean);
		} else {
			throw new Exception("��ά���ֵ��Ϸ�������������");
		}

		//��Ʒ��
		entryInfo.setFPRODUCTGROUPID(new CloudCommonF7Bean());

		//��ע
		entryInfo.setFEntryNote(null);

		//BOM�汾
		entryInfo.setFBomId(new CloudCommonF7Bean());

		//��Ŀ���
		entryInfo.setFProjectNo(null);

		//��������
		entryInfo.setFProduceDate(null);

		//����������
		entryInfo.setFServiceContext(null);

		//���״̬
		String FStockStatusId = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FStockStatusId);
		entryInfo.setFStockStatusId(f7Bean);

		//�ƻ����ٺ�
		entryInfo.setFMtoNo(null);

		//�ɱ���Ŀ
		entryInfo.setFCostItem(new CloudCommonF7Bean());

		//����������
		String FKeeperTypeId = "BD_KeeperOrg";
		entryInfo.setFKeeperTypeId(FKeeperTypeId);

		//�μӷ��÷���
		String FDistribution = "false";
		entryInfo.setFDistribution(FDistribution);

		//������
		String FKeeperId = "TYZQ";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FKeeperId);
		entryInfo.setFKeeperId(f7Bean);

		//����λ
		entryInfo.setFExtAuxUnitId(new CloudCommonF7Bean());

		//����
		String F_abc_Price = "0";
		entryInfo.setF_abc_Price(F_abc_Price);

		//ʵ������(����λ)
		String FExtAuxUnitQty = "0";
		entryInfo.setFExtAuxUnitQty(FExtAuxUnitQty);

		//���
		String F_abc_Amount = "0";
		entryInfo.setF_abc_Amount(F_abc_Amount);


		//����ʵ��List
		String entryStr = JSONObject.toJSONString(entryInfo, SerializerFeature.WriteNullStringAsEmpty);
		JSONObject entryJson = JSONObject.parseObject(entryStr, Feature.OrderedField);


		entryArray.add(entryJson);


		//����  ��ͷ�� FEntityֵ
		billInfo.setFEntity(entryArray);


		//��ʵ��ת��ΪjsonObject
		String manuString = JSONObject.toJSONString(billInfo, SerializerFeature.WriteNullStringAsEmpty);
		JSONObject allJson = JSONObject.parseObject(manuString, Feature.OrderedField);

		//data�����
		CloudCommonDataBean cloudCommonDataBean = new CloudCommonDataBean();
		cloudCommonDataBean.setCreator("");
		cloudCommonDataBean.setNeedUpDateFields(null);
		cloudCommonDataBean.setModel(allJson);

		//�½�CloudCommonBean����
		CloudCommonBean commonBean = new CloudCommonBean();
		commonBean.setFormid("STK_MisDelivery");
		commonBean.setData(cloudCommonDataBean);

		//��ʵ��ת��Ϊ�ַ���
		return JSONObject.toJSONString(commonBean, SerializerFeature.WriteNullStringAsEmpty);
	}

}
