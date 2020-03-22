package com.kingdee.eas.custom.tocloud.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.measure.unit.BaseUnit;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.cp.dm.web.dto.CtrlUnitInfoDTO;
import com.kingdee.eas.custom.tocloud.SynDateLogEntryInfo;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonBean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonDataBean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonF7Bean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonFAUXPROF7Bean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonFSTOCKF7Bean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonStaffF7Bean;
import com.kingdee.eas.custom.tocloud.bean.CloudMaterialReqBean;
import com.kingdee.eas.custom.tocloud.bean.CloudMaterialReqEntryBean;
import com.kingdee.eas.custom.tocloud.service.ISynData;
import com.kingdee.eas.farm.hatch.BEggHatchBillEggEntryFactory;
import com.kingdee.eas.farm.hatch.BEggHatchBillEggEntryInfo;
import com.kingdee.eas.farm.hatch.BEggHatchBillFactory;
import com.kingdee.eas.farm.hatch.BEggHatchBillInfo;
import com.kingdee.eas.farm.hatch.HatchBaseDataFactory;
import com.kingdee.eas.farm.hatch.HatchBaseDataInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.mobile.convert.util.CtrlUnitInfoConvert;

public class SynDataBEggHatchToMaterialReq implements ISynData{

	/**
	 * ҵ���������ֵ��Ϸ���--����cloud���ϳ��ⵥ��006��
	 */
	@Override
	public String synData(Context ctx, String billId, String entryId,
			String targetSystemId, String bizTypeId, List<String> errorMessage,
			SynDateLogEntryInfo synDateLogEntryInfo) throws Exception {

		//ʵ����
		BEggHatchBillInfo bEggHatchBillInfo = BEggHatchBillFactory.getLocalInstance(ctx).getBEggHatchBillInfo(new ObjectUuidPK(billId));
		BEggHatchBillEggEntryInfo entryInfo = BEggHatchBillEggEntryFactory.getLocalInstance(ctx).getBEggHatchBillEggEntryInfo(new ObjectUuidPK(entryId));
		//�趨������ʾ��ʽ
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		//�������ϳ��ⵥ��ͷ
		CloudMaterialReqBean cloudMaterialReqBean = new CloudMaterialReqBean();
		CloudCommonF7Bean f7Bean = null;


		//����id
		String FID = "0";
		cloudMaterialReqBean.setFID(FID);

		//���ݱ��
		String FBillNo = "";
		cloudMaterialReqBean.setFBillNo(FBillNo);

		//��������
		String FBillType = "JDSCLL01_SYS";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FBillType);
		cloudMaterialReqBean.setFBillType(f7Bean);

		//����
		String FDate = bEggHatchBillInfo.getBizDate().toString();
		cloudMaterialReqBean.setFDate(FDate);

		//��ע
		String FDescription = "�ֵ��Ϸ�������ͬ��";
		cloudMaterialReqBean.setFDescription(FDescription);

		//������֯
		StorageOrgUnitInfo storageInfo = StorageOrgUnitFactory.getLocalInstance(ctx).getStorageOrgUnitInfo(new ObjectUuidPK((bEggHatchBillInfo.getCU().getId())));
		String targetOrgNum = storageInfo.getNumber();
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetOrgNum);
		cloudMaterialReqBean.setFStockOrgId(f7Bean);

		//�����
		String FStockerGroupId = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FStockerGroupId);
		cloudMaterialReqBean.setFStockerGroupId(f7Bean);

		//�ֹ�Ա
		String FStockerId = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FStockerId);
		cloudMaterialReqBean.setFStockerId(f7Bean);

		//������
		String FPickerId = "";
		CloudCommonStaffF7Bean f8Bean = new CloudCommonStaffF7Bean();
		f8Bean.setFStaffNumber(FPickerId);
		cloudMaterialReqBean.setFPickerId(f8Bean);

		//��λ��
		String FCurrId = "PRE001";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FCurrId);
		cloudMaterialReqBean.setFCurrId(f7Bean);

		//��������
		String FOwnerTypeId0 = "BD_OwnerOrg";
		cloudMaterialReqBean.setFOwnerTypeId0(FOwnerTypeId0);

		//����
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetOrgNum);
		cloudMaterialReqBean.setFOwnerId0(f7Bean);

		//������֯
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetOrgNum);
		cloudMaterialReqBean.setFPrdOrgId(f7Bean);

		//��������
		StorageOrgUnitInfo hatchInfo = StorageOrgUnitFactory.getLocalInstance(ctx).getStorageOrgUnitInfo(new ObjectUuidPK(bEggHatchBillInfo.getStorageOrgUnit().getId()));
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(hatchInfo.getNumber());
		cloudMaterialReqBean.setFWorkShopId(f7Bean);

		//����֯ҵ������
		String FTransferBizTypeId = "OverOrgPick";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FTransferBizTypeId);
		cloudMaterialReqBean.setFTransferBizTypeId(f7Bean);

		//���к��ϴ�
		String FScanBox = "";
		cloudMaterialReqBean.setFScanBox(FScanBox);

		//���
		String F_F_BANZ1 = "01";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(F_F_BANZ1);
		cloudMaterialReqBean.setF_F_BANZ1(f7Bean);






		JSONArray entryArray = new JSONArray();

		//���÷�¼
		CloudMaterialReqEntryBean cloudMaterialReqEntryBeanInfo = new CloudMaterialReqEntryBean();

		//����FEntryID
		String FEntryID = "0";
		cloudMaterialReqEntryBeanInfo.setFEntryID(FEntryID);

		//���ϱ���
		String FMaterialId = "06.03.01.001";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FMaterialId);
		cloudMaterialReqEntryBeanInfo.setFMaterialId(f7Bean);

		//��������
		String FAuxPropId = "";
		CloudCommonFAUXPROF7Bean  FAuxPropIdfaux = new CloudCommonFAUXPROF7Bean();
		FAuxPropIdfaux.setFAUXPROPID__FOPCODE(FAuxPropId);
		cloudMaterialReqEntryBeanInfo.setFAuxPropId(FAuxPropIdfaux);

		//BOM�汾
		String FBomId = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FBomId);
		cloudMaterialReqEntryBeanInfo.setFBomId(f7Bean);

		//��λ
		String FUnitID = "mei";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FUnitID);
		cloudMaterialReqEntryBeanInfo.setFUnitID(f7Bean);

		//��������
		String FAppQty = String.valueOf(entryInfo.getEggQty());
		cloudMaterialReqEntryBeanInfo.setFAppQty(FAppQty);

		//ʵ������
		cloudMaterialReqEntryBeanInfo.setFActualQty(FAppQty);

		//�ֿ�
		String FStockId = "ZQ06";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FStockId);
		cloudMaterialReqEntryBeanInfo.setFStockId(f7Bean);

		//��λ
		String FStockLocId = "";
		CloudCommonFSTOCKF7Bean FStockLocIdStock = new CloudCommonFSTOCKF7Bean();
		FStockLocIdStock.setFSTOCKLOCID__FOPCODE(FStockLocId);
		cloudMaterialReqEntryBeanInfo.setFStockLocId(FStockLocIdStock);

		//����
		StockingBatchInfo batchInfo = entryInfo.getOutBatch();
		StockingBatchInfo batchInfo1 = null;
		if(batchInfo != null){
			batchInfo1 = StockingBatchFactory.getLocalInstance(ctx).getStockingBatchInfo(new ObjectUuidPK(batchInfo.getId()));
			String batchNum = batchInfo1.getNumber().substring(0, 8);
			f7Bean = new CloudCommonF7Bean();
			f7Bean.setFNumber(batchNum);
			cloudMaterialReqEntryBeanInfo.setFLot(f7Bean);
		} else {
			throw new Exception("��ά���ֵ��Ϸ�������������");
		}


		//��������
		String FProductId = "06.002";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FProductId);
		cloudMaterialReqEntryBeanInfo.setFProductId(f7Bean);

		//�������
		String FProductNo = batchInfo1.getNumber().substring(0,8);
		cloudMaterialReqEntryBeanInfo.setFProductNo(FProductNo);

		//�������Ӱ��ɱ�
		String FIsAffectCost = "true";
		cloudMaterialReqEntryBeanInfo.setFIsAffectCost(FIsAffectCost);

		//��Ʒ��
		String FPRODUCTGROUPID = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FPRODUCTGROUPID);
		cloudMaterialReqEntryBeanInfo.setFPRODUCTGROUPID(f7Bean);

		//��浥λ
		String FStockUnitId = "mei";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FStockUnitId);
		cloudMaterialReqEntryBeanInfo.setFStockUnitId(f7Bean);

		//��浥λʵ������
		cloudMaterialReqEntryBeanInfo.setFStockActualQty(FAppQty);

		//��������
		String FOwnerTypeId = "BD_OwnerOrg";
		cloudMaterialReqEntryBeanInfo.setFOwnerTypeId(FOwnerTypeId);

		//����
		String FEntryWorkShopId = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FEntryWorkShopId);
		cloudMaterialReqEntryBeanInfo.setFEntryWorkShopId(f7Bean);

		//����
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetOrgNum);
		cloudMaterialReqEntryBeanInfo.setFOwnerId(f7Bean);

		//����λ 
		String FExtAuxUnitId = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FExtAuxUnitId);
		cloudMaterialReqEntryBeanInfo.setFExtAuxUnitId(f7Bean);

		//ʵ������������λ��
		String FExtAuxUnitQty = "0";
		cloudMaterialReqEntryBeanInfo.setFExtAuxUnitQty(FExtAuxUnitQty);

		//�ɱ���
		cloudMaterialReqEntryBeanInfo.setFPrice(null);

		//�ܳɱ�
		cloudMaterialReqEntryBeanInfo.setFAmount(null);

		//��Ʒ��������
		String FParentOwnerTypeId = "BD_OwnerOrg";
		cloudMaterialReqEntryBeanInfo.setFParentOwnerTypeId(FParentOwnerTypeId);

		//��Ʒ����
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetOrgNum);
		cloudMaterialReqEntryBeanInfo.setFParentOwnerId(f7Bean);

		//������λ
		String FBaseUnitId = "01";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FBaseUnitId);
		cloudMaterialReqEntryBeanInfo.setFBaseUnitId(f7Bean);

		//����������
		String FServiceContext = "";
		cloudMaterialReqEntryBeanInfo.setFServiceContext(FServiceContext);

		//������λ����
		cloudMaterialReqEntryBeanInfo.setFBaseActualQty(FAppQty);

		//���״̬
		String FStockStatusId = "KCZT01_SYS";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FStockStatusId);
		cloudMaterialReqEntryBeanInfo.setFStockStatusId(f7Bean);

		//��������
		String FProduceDate = "";
		cloudMaterialReqEntryBeanInfo.setFProduceDate(FProduceDate);

		//��渨��λ
		String FSecUnitId = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FSecUnitId);
		cloudMaterialReqEntryBeanInfo.setFSecUnitId(f7Bean);

		//ʵ������(��渨��λ)
		String FSecActualQty = "";
		cloudMaterialReqEntryBeanInfo.setFSecActualQty(FSecActualQty);

		//��ע
		String FEntrtyMemo = "";
		cloudMaterialReqEntryBeanInfo.setFEntrtyMemo(FEntrtyMemo);

		//�ƻ����ٺ�
		String FMtoNo = "";
		cloudMaterialReqEntryBeanInfo.setFMtoNo(FMtoNo);

		//������λ��������
		cloudMaterialReqEntryBeanInfo.setFBaseAppQty(FAppQty);

		//����������
		String FKeeperTypeId = "BD_KeeperOrg";
		cloudMaterialReqEntryBeanInfo.setFKeeperTypeId(FKeeperTypeId);

		//������
		f7Bean  = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetOrgNum);
		cloudMaterialReqEntryBeanInfo.setFKeeperId(f7Bean);

		//��Ч����
		String FExpiryDate = "";
		cloudMaterialReqEntryBeanInfo.setFExpiryDate(FExpiryDate);

		//����
		String F_abc_Text = "1";
		cloudMaterialReqEntryBeanInfo.setF_abc_Text(F_abc_Text);



		entryArray.add(cloudMaterialReqEntryBeanInfo);
		//���ñ�ͷ��FEntity
		cloudMaterialReqBean.setFEntity(entryArray);




		//��ʵ��ת��ΪjsonObject
		String manuString = JSONObject.toJSONString(cloudMaterialReqBean, SerializerFeature.WriteNullStringAsEmpty);
		JSONObject allJson = JSONObject.parseObject(manuString, Feature.OrderedField);

		//data�����
		CloudCommonDataBean cloudCommonDataBean = new CloudCommonDataBean();
		cloudCommonDataBean.setCreator("");
		cloudCommonDataBean.setNeedUpDateFields(null);
		cloudCommonDataBean.setModel(allJson);

		//�½�CloudCommonBean����
		CloudCommonBean commonBean = new CloudCommonBean();
		commonBean.setFormid("SP_PickMtrl");
		commonBean.setData(cloudCommonDataBean);

		//��ʵ��ת��Ϊ�ַ���
		return JSONObject.toJSONString(commonBean, SerializerFeature.WriteNullStringAsEmpty);
	}
}