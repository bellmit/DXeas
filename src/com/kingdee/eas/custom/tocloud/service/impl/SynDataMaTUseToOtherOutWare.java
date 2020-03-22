package com.kingdee.eas.custom.tocloud.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.custom.tocloud.SynDateLogEntryInfo;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonBean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonDataBean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonF7Bean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonFAUXPROF7Bean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonFSTOCKF7Bean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonStaffF7Bean;
import com.kingdee.eas.custom.tocloud.bean.OtherOutWarehsBillBean;
import com.kingdee.eas.custom.tocloud.bean.OtherOutWarehsBillEntry;
import com.kingdee.eas.custom.tocloud.service.ISynData;
import com.kingdee.eas.farm.stocking.basedata.FarmFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEggEntryFactory;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEggEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyFactory;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyMatUserEntryFactory;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyMatUserEntryInfo;

public class SynDataMaTUseToOtherOutWare implements ISynData {

	/**
	 * ҵ����������������--����cloud�������ⵥ(005)
	 */
	@Override
	public String synData(Context ctx, String billId, String entryId,
			String targetSystemId, String bizTypeId, List<String> errorMessage,
			SynDateLogEntryInfo synDateLogEntryInfo) throws Exception {
		// TODO Auto-generated method stub

		//ʵ����
		StockingBreedDailyInfo stockingInfo = StockingBreedDailyFactory.getLocalInstance(ctx).getStockingBreedDailyInfo(new ObjectUuidPK(billId));
		StockingBreedDailyMatUserEntryInfo matUseInfo = StockingBreedDailyMatUserEntryFactory.getLocalInstance(ctx).getStockingBreedDailyMatUserEntryInfo(new ObjectUuidPK(entryId));

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
		String FStockOrgId = stockingInfo.getCompany().getNumber();
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

		//���ϲ���
		String farm = "ZQ06";
		FarmInfo farmInfo = FarmFactory.getLocalInstance(ctx).getFarmInfo(new ObjectUuidPK(stockingInfo.getFarm().getId()));
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(farm);
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
		String FNote = "��ֳ�ձ�ͬ��";
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
		MaterialInfo FMaterialId = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(matUseInfo.getMatNum().getId()));
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FMaterialId.getNumber());
		entryInfo.setFMaterialId(f7Bean);

		//��������
		entryInfo.setFAuxPropId(new CloudCommonFAUXPROF7Bean());

		//��λ
		String FUnitID = "01";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FUnitID);
		entryInfo.setFUnitID(f7Bean);

		//ʵ������
		String FQty = matUseInfo.getMatQty().toString();
		entryInfo.setFQty(FQty);

		//������λ
		String FBaseUnitId = "01";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FBaseUnitId);
		entryInfo.setFBaseUnitId(f7Bean);

		//�����ֿ�
		String FStockId = null;


		//������ֳ�� ʯ������
		if("01.02.001".equalsIgnoreCase(FMaterialId.getNumber()) && "ZQ06".equalsIgnoreCase(farmInfo.getNumber())){
			FStockId = "ZQ0200";
		}
		//�����ֳ��  ʯ������
		if("01.02.001".equalsIgnoreCase(FMaterialId.getNumber()) && "ZQ07".equalsIgnoreCase(farmInfo.getNumber())){
			FStockId = "ZQ0300";
		}
		if(!"01.02.001".equalsIgnoreCase(FMaterialId.getNumber())){
			FStockId = "ZQ08";
		}


		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FStockId);
		entryInfo.setFStockId(f7Bean);

		//��λ
		entryInfo.setFStockLocId(new CloudCommonFSTOCKF7Bean());

		//����
		String FLot = "";
		entryInfo.setFLot(new CloudCommonF7Bean());

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
		String FKeeperId = "";
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
