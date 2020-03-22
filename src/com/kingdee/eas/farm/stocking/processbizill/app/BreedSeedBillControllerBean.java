package com.kingdee.eas.farm.stocking.processbizill.app;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.bot.BOTMappingCollection;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillInfo;
import com.kingdee.eas.farm.stocking.basedata.BaseSysSettingInfo;
import com.kingdee.eas.farm.stocking.basedata.BreedDataFactory;
import com.kingdee.eas.farm.stocking.basedata.BreedDataInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.basedata.FarmFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmInfo;
import com.kingdee.eas.farm.stocking.basedata.IStockingBatch;
import com.kingdee.eas.farm.stocking.basedata.MaleOrFemaleEnum;
import com.kingdee.eas.farm.stocking.basedata.OutOrgEnum;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchHouseEntryInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.basedata.app.sex;
import com.kingdee.eas.farm.stocking.common.BotpCommUtils;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.farm.stocking.processbizill.BreedSeedBillFactory;
import com.kingdee.eas.farm.stocking.processbizill.BreedSeedBillInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class BreedSeedBillControllerBean extends AbstractBreedSeedBillControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.stocking.processbizill.app.BreedSeedBillControllerBean");
	protected void _audit(Context ctx, IObjectValue model)throws BOSException, EASBizException
	{
		try {
			BreedSeedBillInfo info = (BreedSeedBillInfo) model;
			StockingBatchInfo batchInfo;
			IStockingBatch iss = StockingBatchFactory.getLocalInstance(ctx);

			if(StringUtils.isBlank(info.getStockingBatchNum())) {
				throw new Exception("����Ϊ��,��ֹ��ˣ�");
			}

			/*String batchID=StockingComm.getBatchIDByContractID(ctx, info.getBatchContract().getId().toString());
    		if(StringUtils.isNotBlank(batchID)) {
				batchInfo=iss.getStockingBatchInfo(new ObjectUuidPK(batchID));
	    		if(!batchInfo.getNumber().trim().equals(info.getStockingBatchNum().trim())) {
	    			throw new Exception("�ú�ͬ�Ѿ��������ͬ���ε�Ѽ�磺"+batchInfo.getNumber()+"��ֹ��ˣ�");
	    		}
    		}*/
			//    		if(info.getStockingBatch()!=null) {
			//				batchInfo=iss.getStockingBatchInfo(new ObjectUuidPK(info.getStockingBatch().getId()));
			//    		}

			batchInfo = dealBatchInfo(ctx, info, true);


			//������ֳ������ж��Ƿ�д���κ�ͬ�ֶ�
			FarmInfo farmInfo = null;
			if(info.getFarm() != null){
				farmInfo = FarmFactory.getLocalInstance(ctx).getFarmInfo(new ObjectUuidPK(info.getFarm().getId()));
				if("��������".equalsIgnoreCase(farmInfo.getFarmType().toString())){
					reWriteContractInfo(ctx, info, true);
				}
			}
			_submit(ctx, info);

			//���ɹ�Ӧ������
			createToSCMBill(ctx, info);
			iss.submit(batchInfo);
			iss.audit(batchInfo);

			batchInfo.setBaseStatus(FarmBaseStatusEnum.enable);
			iss.save(batchInfo);

			info.setBillStatus(BillBaseStatusEnum.AUDITED);
			info.setAuditTime(new java.util.Date());
			info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));

			super.save(ctx, info);
			//			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (Exception ex) {
			throw new EASBizException(new NumericExceptionSubItem("001",ex.getMessage()));
		}
	}
	/**
	 * ��д��ͬ��Ϣ
	 * @param ctx
	 * @param info
	 * @param isAudit
	 * @throws BOSException 
	 */
	private void reWriteContractInfo(Context ctx,BreedSeedBillInfo info,boolean isAudit) throws BOSException {
		StringBuffer sql=new StringBuffer();
		if(isAudit) {
			Calendar cal=Calendar.getInstance();
			cal.setTime(info.getBizDate());
			cal.add(Calendar.MONTH, 17);//��ͬ��Ϊ17����

			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

			sql.append(" update T_FM_BatchContract ")
			.append(" set FContractDate={d'").append(sdf.format(info.getBizDate())).append("'}")
			.append(" ,FContractEndDate={d'").append(sdf.format(cal.getTime())).append("'}")
			.append(" ,FFirstBreedBillSee='").append(info.getString("id")).append("'")
			.append(" ,FStockingBatchID='").append(info.getStockingBatch().getString("id")).append("'")
			.append(" ,FActualBreedDate={d'").append(sdf.format(info.getBizDate())).append("'}")
			.append(" ,FActualbreedQty=").append(info.getStockingBatch().getBatchQty())
			.append(" ,FActualFemaleQty=").append(info.getStockingBatch().getFemaleQty())
			.append(" where fid='").append(info.getBatchContract().getString("id")).append("'")
			.append(" and FFirstBreedBillSee is null or FFirstBreedBillSee='").append(info.getString("id")).append("'")
			.append(" ");
		}else{
			sql.append(" update T_FM_BatchContract ")
			.append(" set FContractDate=null")
			.append(" ,FContractEndDate=null")
			.append(" , FFirstBreedBillSee=null")
			.append(" ,FStockingBatchID=null")
			.append(" ,FActualBreedDate=null")
			.append(" ,FActualbreedQty=null")
			.append(" ,FActualFemaleQty=null")
			.append(" where fid='").append(info.getBatchContract().getString("id")).append("'")
			.append(" and FFirstBreedBillSee='").append(info.getString("id")).append("'")
			.append(" ");
		}
		DbUtil.execute(ctx, sql.toString());
	}

	/**
	 * ����������Ϣ
	 * @param ctx
	 * @param info
	 * @param isPlus
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private StockingBatchInfo dealBatchInfo(Context ctx,BreedSeedBillInfo info,boolean isAudit) throws EASBizException, BOSException {
		/**
		 * �����µ�����
		 */
		IStockingBatch iss = StockingBatchFactory.getLocalInstance(ctx);
		StockingBatchInfo batchInfo = info.getStockingBatch();	
		if(batchInfo==null) {
			batchInfo=new StockingBatchInfo();
			batchInfo.setId(BOSUuid.create(batchInfo.getBOSType()));
		}else{
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add(new SelectorItemInfo("*"));
			slor.add(new SelectorItemInfo("HouseEntry.*"));
			slor.add(new SelectorItemInfo("HouseEntry.house.*"));
			batchInfo=iss.getStockingBatchInfo(new ObjectUuidPK(info.getStockingBatch().getId()),slor);
		}

		//�������ʱ�Ÿ�����Ϣ
		if(isAudit) {
			batchInfo.setCompany(info.getCompany());
			batchInfo.setNumber(info.getStockingBatchNum());
			batchInfo.setName(info.getStockingBatchNum());
			batchInfo.setBaseStatus(FarmBaseStatusEnum.unApprove);
			batchInfo.setBreedData(info.getBreedData());
			if(batchInfo.getInDate()==null) {
				batchInfo.setInDate(info.getBizDate());
			}
			//			batchInfo.setBatchQty(info.getQty());
			//			batchInfo.setFemaleQty(info.getFemaleQty());
			batchInfo.setAuditTime(new java.util.Date());
			batchInfo.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
			batchInfo.setFarmer(info.getFarmer());
			batchInfo.setFarm(info.getFarm());
			batchInfo.setBatchContract(info.getBatchContract());
			batchInfo.setSex(info.getSex());
		}else {
			//����������ͬ��Ϣ
			if(!isExistOtherBill(ctx, batchInfo.getString("id"), info.getCompany().getString("id"), info.getString("id"))) {
				batchInfo.setBatchContract(null);
				batchInfo.setInDate(null);
				batchInfo.setBaseStatus(FarmBaseStatusEnum.unApprove);
			}
		}

		BreedDataInfo binfo=BreedDataFactory.getLocalInstance(ctx).getBreedDataInfo(new ObjectUuidPK(info.getBreedData().getId()));
		ArrayList<String> maleList=new ArrayList<String>();//��
		ArrayList<String> femaleList=new ArrayList<String>();//ĸ
		for(int i=0;i<binfo.getSeedEntry().size();i++) {
			if(binfo.getSeedEntry().get(i).getMaleOrFemale()!=null) {
				if(binfo.getSeedEntry().get(i).getMaleOrFemale().equals(MaleOrFemaleEnum.male)) {
					maleList.add(binfo.getSeedEntry().get(i).getMaterial().getString("id"));
				}else{
					femaleList.add(binfo.getSeedEntry().get(i).getMaterial().getString("id"));
				}
			}
		}

		//�Ӽ�ϵ��
		BigDecimal mulRate=BigDecimal.ONE;
		if(!isAudit) { 
			mulRate=new BigDecimal(-1);
		}

		String materialID;
		BigDecimal qty,maleQty,femaleQty,allMaleQty=BigDecimal.ZERO,allFemalQty=BigDecimal.ZERO,allQty=BigDecimal.ZERO;
		for(int index=0;index<info.getEntrys().size();index++) {
			materialID=info.getEntrys().get(index).getMaterial().getId().toString();
			qty=(UIRuleUtil.getBigDecimal(info.getEntrys().get(index).getAllReceiveQty())).multiply(mulRate);//getConfirmQty
			//�������ԼӼ�ϵ��
			maleQty=BigDecimal.ZERO;
			femaleQty=BigDecimal.ZERO;
//			if(maleList.contains(materialID)) {
//				maleQty=qty;
//			}else {//�ǹ�ȫ��ĸ�Ľ��й���
//				//if(femaleList.contains(materialID)) {
//				femaleQty=qty;
//			}
			//����ǹ���
			//if(info.getSex().equals(sex.male)){
				maleQty= (UIRuleUtil.getBigDecimal(info.getEntrys().get(index).getCockQty())).multiply(mulRate);
			//}
			//�����ĸ��
			//if(info.getSex().equals(sex.female)){
				femaleQty= (UIRuleUtil.getBigDecimal(info.getEntrys().get(index).getHenQty())).multiply(mulRate);
			//}
			
			
			
			
			allMaleQty=allMaleQty.add(maleQty);
			allFemalQty=allFemalQty.add(femaleQty);
			allQty=allQty.add(qty);

			//add@20170216 �������η���
			if(info.getEntrys().get(index).getHouse()!=null) {
				boolean isExist=false;
				StockingBatchHouseEntryInfo tempHouseEntryInfo;
				int count=batchInfo.getHouseEntry().size();
				//�������η�¼
				for(int j=0;j<count;) {
					tempHouseEntryInfo = batchInfo.getHouseEntry().get(j);
					//�������
					if(tempHouseEntryInfo.getHouse().getId().equals(info.getEntrys().get(index).getHouse().getId())) {
						tempHouseEntryInfo.setFemaleQty(tempHouseEntryInfo.getFemaleQty()==null?femaleQty:tempHouseEntryInfo.getFemaleQty().add(femaleQty));
						tempHouseEntryInfo.setQty(tempHouseEntryInfo.getQty()==null?maleQty:tempHouseEntryInfo.getQty().add(maleQty));
						isExist=true;
					}
					if((tempHouseEntryInfo.getQty()==null||tempHouseEntryInfo.getQty().signum()<=0)&&(tempHouseEntryInfo.getFemaleQty()==null||tempHouseEntryInfo.getFemaleQty().signum()<=0)) {
						batchInfo.getHouseEntry().removeObject(j);
					}else{
						j++;
					}
					count=batchInfo.getHouseEntry().size();
					if(isExist) {
						break;
					}
				}
				if(!isExist) {
					StockingBatchHouseEntryInfo houseInfo=new StockingBatchHouseEntryInfo();
					houseInfo.setHouse(info.getEntrys().get(index).getHouse());
					houseInfo.setInData(info.getBizDate());
					houseInfo.setFemaleQty(femaleQty);
					houseInfo.setQty(maleQty);
					batchInfo.getHouseEntry().add(houseInfo);
				}

			}
		}

		//add@20170216
		if(batchInfo.getBatchQty()!=null) {
			allMaleQty=allMaleQty.add(batchInfo.getBatchQty());
		}
		if(batchInfo.getFemaleQty()!=null) {
			allFemalQty=allFemalQty.add(batchInfo.getFemaleQty());
		}

		batchInfo.setBatchQty(allMaleQty);
		batchInfo.setFemaleQty(allFemalQty);
		batchInfo.setTotalQty(allMaleQty.add(allFemalQty));
		//��������
		info.setStockingBatch(batchInfo);

		return batchInfo;
	}

	/**
	 * ����������Ϣ
	 * @param ctx
	 * @param info
	 * @param isPlus
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private StockingBatchInfo dealBatchInfoOld(Context ctx,BreedSeedBillInfo info,boolean isAudit) throws EASBizException, BOSException {
		/**
		 * �����µ�����
		 */
		IStockingBatch iss = StockingBatchFactory.getLocalInstance(ctx);
		StockingBatchInfo batchInfo = info.getStockingBatch();
		if(batchInfo==null) {
			batchInfo=new StockingBatchInfo();
			batchInfo.setId(BOSUuid.create(batchInfo.getBOSType()));
		}else{
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add(new SelectorItemInfo("*"));
			slor.add(new SelectorItemInfo("HouseEntry.*"));
			slor.add(new SelectorItemInfo("HouseEntry.house.*"));
			batchInfo=iss.getStockingBatchInfo(new ObjectUuidPK(info.getStockingBatch().getId()),slor);
		}

		//�������ʱ�Ÿ�����Ϣ
		if(isAudit) {
			batchInfo.setCompany(info.getCompany());
			batchInfo.setNumber(info.getStockingBatchNum());
			batchInfo.setName(info.getStockingBatchNum());
			batchInfo.setBaseStatus(FarmBaseStatusEnum.unApprove);
			batchInfo.setBreedData(info.getBreedData());
			if(batchInfo.getInDate()==null) {
				batchInfo.setInDate(info.getBizDate());
			}
			//			batchInfo.setBatchQty(info.getQty());
			//			batchInfo.setFemaleQty(info.getFemaleQty());
			batchInfo.setAuditTime(new java.util.Date());
			batchInfo.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
			batchInfo.setFarmer(info.getFarmer());
			batchInfo.setFarm(info.getFarm());
			batchInfo.setBatchContract(info.getBatchContract());
		}else{
			//����������ͬ��Ϣ
			if(!isExistOtherBill(ctx, batchInfo.getString("id"), info.getCompany().getString("id"), info.getString("id"))) {
				batchInfo.setBatchContract(null);
				batchInfo.setInDate(null);
				batchInfo.setBaseStatus(FarmBaseStatusEnum.unApprove);
			}
		}

		BreedDataInfo binfo=BreedDataFactory.getLocalInstance(ctx).getBreedDataInfo(new ObjectUuidPK(info.getBreedData().getId()));
		ArrayList<String> maleList=new ArrayList<String>();//��
		ArrayList<String> femaleList=new ArrayList<String>();//ĸ
		for(int i=0;i<binfo.getSeedEntry().size();i++) {
			if(binfo.getSeedEntry().get(i).getMaleOrFemale()!=null) {
				if(binfo.getSeedEntry().get(i).getMaleOrFemale().equals(MaleOrFemaleEnum.male)) {
					maleList.add(binfo.getSeedEntry().get(i).getMaterial().getString("id"));
				}else{
					femaleList.add(binfo.getSeedEntry().get(i).getMaterial().getString("id"));
				}
			}
		}

		String materialID;
		BigDecimal maleQty=BigDecimal.ZERO,femalQty=BigDecimal.ZERO,allQty=BigDecimal.ZERO;
		for(int index=0;index<info.getEntrys().size();index++) {
			BigDecimal qty=BigDecimal.ZERO;
			materialID=info.getEntrys().get(index).getMaterial().getId().toString();
			//			qty=info.getEntrys().get(index).getConfirmQty();
			qty=info.getEntrys().get(index).getAllReceiveQty();
			if(maleList.contains(materialID)) {
				maleQty=maleQty.add(qty);
			}
			if(femaleList.contains(materialID)) {
				femalQty=femalQty.add(qty);
			}
			allQty=allQty.add(qty);
		}
		//����ĸ���� ȫ��ĸ���㣿
		if(maleList.size()>0) {	
			femalQty=allQty.subtract(maleQty);
		}else {
			femalQty=allQty;
		}

		//�����������ȥ
		if(!isAudit) {
			maleQty=maleQty.multiply(new BigDecimal(-1));
			femalQty=femalQty.multiply(new BigDecimal(-1));
		}

		//���ᴦ��
		if(info.getHouse()!=null) {
			BigDecimal fQtySum=BigDecimal.ZERO,qtySum=BigDecimal.ZERO;
			boolean isExist=false;
			StockingBatchHouseEntryInfo tempHouseEntryInfo;
			int count=batchInfo.getHouseEntry().size();
			for(int index=0;index<count;) {
				tempHouseEntryInfo = batchInfo.getHouseEntry().get(index);
				if(tempHouseEntryInfo.getHouse()==null) {
					index++;
					continue;
				}

				if(tempHouseEntryInfo.getHouse().getId().equals(info.getHouse().getId())) {
					tempHouseEntryInfo.setFemaleQty(tempHouseEntryInfo.getFemaleQty()==null?femalQty:tempHouseEntryInfo.getFemaleQty().add(femalQty));
					tempHouseEntryInfo.setQty(tempHouseEntryInfo.getQty()==null?maleQty:tempHouseEntryInfo.getQty().add(maleQty));
					isExist=true;
					//					break;
				}
				if((tempHouseEntryInfo.getQty()==null||tempHouseEntryInfo.getQty().signum()<=0)&&(tempHouseEntryInfo.getFemaleQty()==null||tempHouseEntryInfo.getFemaleQty().signum()<=0)) {
					batchInfo.getHouseEntry().removeObject(index);
				}else{
					index++;
				}

				count=batchInfo.getHouseEntry().size();

				if(tempHouseEntryInfo.getFemaleQty()!=null) {
					fQtySum=tempHouseEntryInfo.getFemaleQty().add(fQtySum);
				}
				if(tempHouseEntryInfo.getQty()!=null) {
					qtySum=tempHouseEntryInfo.getQty().add(qtySum);
				}

			}
			if(!isExist) {
				StockingBatchHouseEntryInfo houseInfo=new StockingBatchHouseEntryInfo();
				houseInfo.setHouse(info.getHouse());
				houseInfo.setInData(new java.util.Date());

				if(isAudit) {
					houseInfo.setFemaleQty(femalQty);
					houseInfo.setQty(maleQty);
				}else{
					houseInfo.setFemaleQty(femalQty.multiply(new BigDecimal(-1)));
					houseInfo.setQty(maleQty.multiply(new BigDecimal(-1)));
				}
				batchInfo.getHouseEntry().add(houseInfo);

				//������
				fQtySum=fQtySum.add(femalQty);
				qtySum=qtySum.add(maleQty);
			}
			maleQty=qtySum;
			femalQty=fQtySum;
		}else {
			if(batchInfo.getBatchQty()!=null) {
				maleQty=maleQty.add(batchInfo.getBatchQty());
			}
			if(batchInfo.getFemaleQty()!=null) {
				femalQty=femalQty.add(batchInfo.getFemaleQty());
			}
		}

		batchInfo.setBatchQty(maleQty);
		batchInfo.setFemaleQty(femalQty);

		//��������
		info.setStockingBatch(batchInfo);

		//ɾ������Ϊ0�ķ�¼
		return batchInfo;
	}
	/**
	 * �Ƿ�����������������õ�
	 * @param ctx
	 * @param batchID
	 * @param billID
	 * @return
	 * @throws BOSException 
	 */
	private boolean isExistOtherBill(Context ctx,String batchID,String companyID,String billID) throws BOSException {
		StringBuffer sql=new StringBuffer();
		sql.append(" select 1 from T_FM_BreedSeedBill where fbillStatus=4 and fstockingBatchID='").append(batchID).append("'and fcompanyid='").append(companyID).append("' and fid!='").append(billID).append("'");
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		if(rs.size()>0) {
			return true;
		}
		return false;
	}

	/**
	 * ���ɹ�Ӧ������
	 * @param ctx
	 * @param info
	 */
	private void createToSCMBill(Context ctx,BreedSeedBillInfo info) throws BOSException {
		try {

			BaseSysSettingInfo sysInfo = StockingComm.getSysSetting(ctx,info.getCompany().getString("id"));
			if(!sysInfo.isIsAutoSCM()) {
				return;
			}

			String destBillType=null;
			BotpCommUtils btpIS = BotpCommUtils.getInstance(null);
			OrgUnitInfo orgInfo=info.getCompany();


			//������ڱ����ֳ��˾��������ֳ��˾���룬Ȼ�������
			for(int index=0;index<sysInfo.getStorageEntry().size();index++) {
				if(sysInfo.getStorageEntry().get(index).getOutOrgType().equals(OutOrgEnum.breedOrg)) {
					destBillType=BotpCommUtils.TransBill_BOSTYPE;
					BOTMappingCollection btpCols = btpIS.getAllCanUsedBotps(ctx, orgInfo, info.getBOSType().toString(),destBillType,new String[]{info.getString("id")},new String[]{}, new ArrayList<String>(), null);
					for(index=0;index<btpCols.size();index++) {
						btpIS.createToSCMBill(ctx, info,destBillType, btpCols.get(index));
					}
					break;
				}
			}

			//�ڲ����� �������ϳ�
			if(sysInfo.isIsInner()) {
				//Ȼ�����������ϳ�
				destBillType=BotpCommUtils.MaterialReq_BOSTYPE;
			}else{//�ⲿ���� �������۳�
				destBillType=BotpCommUtils.SaleIssueBill_BOSTYPE;
			}

			BOTMappingCollection btpCols = btpIS.getAllCanUsedBotps(ctx, orgInfo, info.getBOSType().toString(),destBillType,new String[]{info.getString("id")},new String[]{}, new ArrayList<String>(), null);
			for(int index=0;index<btpCols.size();index++) {
				btpIS.createToSCMBill(ctx, info,destBillType, btpCols.get(index));
			}
		}catch(Exception err) {
			throw new BOSException(err);
		}
	}

	protected void _unAudit(Context ctx, IObjectValue model)throws BOSException, EASBizException
	{
		try {
			BreedSeedBillInfo info = (BreedSeedBillInfo) model;


			if(DbUtil.executeQuery(ctx, "select * from T_BOT_Relation where FSrcObjectID='"+info.getString("id")+"'").size()>0)
				throw new EASBizException(new NumericExceptionSubItem("001","�����ε��ݵĵ��ݽ�ֹ�����"));

			//				if(DbUtil.executeQuery(ctx, "select * from T_FM_StockingBatch where fid='"+info.getStockingBatch().getId().toString()+"'").size()>0)
			//					throw new EASBizException(new NumericExceptionSubItem("001","�Ѿ�����������Ϣ����ֹ�����"));

			StockingBatchInfo batchInfo = dealBatchInfo(ctx, info, false);
			StockingBatchFactory.getLocalInstance(ctx).save(batchInfo);
			FarmInfo farmInfo = null;
			if(info.getFarm() != null){
				farmInfo = FarmFactory.getLocalInstance(ctx).getFarmInfo(new ObjectUuidPK(info.getFarm().getId()));
				if("��������".equalsIgnoreCase(farmInfo.getFarmType().toString())){
					reWriteContractInfo(ctx, info, false);
				}
			}
			info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
			info.setAuditTime(null);
			info.setAuditor(null);
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (Exception ex) {
			throw new BOSException(ex);
		}
	}


	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BreedSeedBillInfo info = (BreedSeedBillInfo) model;
		if(info.containsKey("emtConfirm")){

		}
		//    	if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)) {
		else if(info.getBillStatus()!=null&&!info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		}
		//    	if(info.getId()==null){
		//    		info.setId(BOSUuid.create(info.getBOSType()));
		//    	}
		//    	for(int i=0;i<info.getEntrys().size();i++){
		//    		if(info.getEntrys().get(i).getId()==null){
		//    			info.getEntrys().get(i).setId(BOSUuid.create(info.getEntrys().get(i).getBOSType()));
		//    		}
		//    	}
		return super._save(ctx, info);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {

		BreedSeedBillInfo info = (BreedSeedBillInfo) model;
		if(info.containsKey("src") && info.getString("src").equalsIgnoreCase("emt")){
			info.setBillStatus(BillBaseStatusEnum.SUBMITED);
		}else{
			if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)||info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)) {
				info.setBillStatus(BillBaseStatusEnum.SUBMITED);
			}
		}
		return super._submit(ctx, info);
	}
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BreedSeedBillInfo info = BreedSeedBillFactory.getLocalInstance(ctx).getBreedSeedBillInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","�����Ѿ���ˣ���ֹɾ����"));
		}
		if(info.getStockingBatch() != null){
			if(DbUtil.executeQuery(ctx, "select * from T_FM_StockingBatch where fid='"+info.getStockingBatch().getId().toString()+"'").size()>0){
				throw new EASBizException(new NumericExceptionSubItem("001","�Ѿ�����������Ϣ����ֹ�����"));
			}
		}
		super._delete(ctx, pk);
	}
	@Override
	protected void _chkVoucherAll(Context ctx, IObjectValue model)
	throws BOSException {
		// TODO Auto-generated method stub

	}
	@Override
	protected void _chkVoucherFlag(Context ctx, IObjectValue model)
	throws BOSException {
		// TODO Auto-generated method stub

	}
}