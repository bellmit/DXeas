package com.kingdee.eas.farm.carnivorous.recyclebiz.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.kingdee.bos.*;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import java.lang.String;
import java.math.BigDecimal;
import java.math.RoundingMode;

import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.basedata.assistant.PeriodFactory;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.eas.farm.carnivorous.basedata.FarmFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKPECostbillFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKPECostbillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillDrugEntryFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillDrugEntryInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillFodderEntryFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillFodderEntryInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillSeedEntryFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillSeedEntryInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.ICKPECostbill;
import com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBill;
import com.kingdee.eas.farm.stocking.basedata.FarmsType;
import com.kingdee.eas.farm.stocking.basedata.StockingFarmTypeEnum;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.util.NumericExceptionSubItem;

public class CKCostCalFacadeControllerBean extends AbstractCKCostCalFacadeControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.carnivorous.recyclebiz.app.CKCostCalFacadeControllerBean");
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat sdfMonth=new SimpleDateFormat("yyyy-MM");
	private SimpleDateFormat sdfTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private ICKSettleBill iCKSettleBill=null;
	private BigDecimal allCost=BigDecimal.ZERO,allSettleWgt=BigDecimal.ZERO;

	@Override
	protected void _calCost(Context ctx, String companyID, String periodID)
	throws BOSException, EASBizException {
		PeriodInfo period=PeriodFactory.getLocalInstance(ctx).getPeriodInfo(new ObjectUuidPK(periodID));
		iCKSettleBill=CKSettleBillFactory.getLocalInstance(ctx);
		//ִ�гɱ�����֮ǰУ�� �ݹ��ɱ���  �Ƿ��Ѿ� �������ε��ݣ����û�У���ɾ�����ڵ��ݹ��ɱ���
		beforeCalCost(ctx, companyID, period);
		calCost(ctx, companyID, period);
	}

	//ִ��ǰɾ���������ɳɱ��������ɵ��ݹ��ɱ���
	private void beforeCalCost(Context ctx,String companyID,PeriodInfo period) throws EASBizException {
		try {	
			StringBuffer sqlBuf = new StringBuffer();
			sqlBuf.append(" /*dialect*/select * from CT_FM_CKPECostbill  t1")
			.append(" inner join T_BOT_Relation t2 on t1.fid=t2.FSrcObjectID")
			.append(" where t1.CFPeriodID='"+period.getId().toString()+"'" +
					" and t1.CFCompanyID = '"+companyID+"'");
			IRowSet rs = DbUtil.executeQuery(ctx, sqlBuf.toString());
			if(rs.size()>0){
				throw new EASBizException(new NumericExceptionSubItem("001","��ǰ��˾���ڳɱ��������ɵ��ݹ��ɱ������������ε���,�뽫��Ӧ�ݹ��ɱ�������ε���ɾ������ִ��."));
			}

			String s1 = "/*dialect*/ select t2.periodid periodid from ( select t1.fid periodid from T_BD_Period t1 " +
			" where fnumber >'"+period.getNumber()+"' order by FPeriodYear,FPeriodNumber ) t2 where rownum = 1";
			IRowSet r1 = DbUtil.executeQuery(ctx, s1);
			String periodid = null;
			PeriodInfo pInfo = null;
			if(r1.next()){
				periodid = r1.getString("periodid");
				pInfo = PeriodFactory.getLocalInstance(ctx).getPeriodInfo(new ObjectUuidPK(periodid));
			}else{
				throw new EASBizException(new NumericExceptionSubItem("001","���ڵĻ���ڼ�δ����"));
			}


			sqlBuf = new StringBuffer();
			sqlBuf.append(" /*dialect*/select * from CT_FM_CKPECostbill   ")
			.append(" where (CFPeriodID='"+period.getId().toString()+"' and (CFIsNextPeriod = 0 or CFIsNextPeriod is null)) " +
					"or (CFPeriodID='"+pInfo.getId()+"' and CFIsNextPeriod = 1) " +
					" and CFCompanyID = '"+companyID+"'");
			rs = DbUtil.executeQuery(ctx, sqlBuf.toString());
			while(rs.next()){
				CKPECostbillFactory.getLocalInstance(ctx).delete(new ObjectUuidPK(rs.getString("fid")));
			}
		} catch (BOSException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//ִ�гɱ�����
	private void calCost(Context ctx, String companyID, PeriodInfo period)
	throws  EASBizException {
		//����ɱ������£������ݹ��ɱ���
		calAndUpdate(ctx, companyID, period);
		//�ݹ���λ�ɱ�
		BigDecimal unitCost=allSettleWgt.signum()==0?BigDecimal.ZERO:allCost.divide(allSettleWgt,8,RoundingMode.HALF_UP);

		//����δ��ȫ�������ε��ݹ��ɱ���--�������׵������κ�ͬ
		try {
			ICKPECostbill iCKPECostbill=CKPECostbillFactory.getLocalInstance(ctx);
			ICodingRuleManager iCodingRuleManager = CodingRuleManagerFactory.getLocalInstance(ctx);
			StringBuffer sqlBuf = new StringBuffer();
			sqlBuf.append(" /*dialect*/ select distinct t1.CFBatchContractID contractid from CT_FM_CSlaughterBill t1 where t1.CFBillStatus in (4,7)")
			.append(" and t1.CFFICompanyID = '").append(companyID).append("'")
			.append(" and t1.FBizDate >= to_date('"+sdf.format(period.getBeginDate())+"','yyyy-MM-dd hh24:mi:ss') ")
			.append(" and t1.FBizDate <= to_date('"+sdf.format(period.getEndDate())+" 23:59:59','yyyy-MM-dd hh24:mi:ss') ")
			.append(" and t1.CFBatchContractID not in ( select  distinct  t1.CFBatchContractID from CT_FM_CSlaughterBill t1 ")
//			.append(" inner join T_BOT_Relation t2 on t2.FSrcObjectID = t1.fid ")
			.append(" inner join CT_FM_CKSettleBill t3 on t3.CFBatchContractid = t1.CFBatchContractID  ")
			.append(" where t1.CFBillStatus in (4,7)  and t3.CFBillStatus in (4,7) ")
			.append(" and t1.CFFICompanyID = '").append(companyID).append("'")
//			.append(" and t1.FBizDate >= to_date('"+sdf.format(period.getBeginDate())+"','yyyy-MM-dd hh24:mi:ss') ")
//			.append(" and t1.FBizDate <= to_date('"+sdf.format(period.getEndDate())+" 23:59:59','yyyy-MM-dd hh24:mi:ss') ")
			.append(" and t3.FBizDate >= to_date('"+sdf.format(period.getBeginDate())+"','yyyy-MM-dd hh24:mi:ss') ")
			.append(" and t3.FBizDate <= to_date('"+sdf.format(period.getEndDate())+" 23:59:59','yyyy-MM-dd hh24:mi:ss') )");
			IRowSet rs = DbUtil.executeQuery(ctx, sqlBuf.toString());
			while(rs.next()){
				BatchContractBillInfo contractInfo = BatchContractBillFactory.getLocalInstance(ctx).getBatchContractBillInfo(new ObjectUuidPK(rs.getString("contractid")) );							

				//�����������ݹ��ɱ���
				if(1 == 1){
					CKPECostbillInfo info=new CKPECostbillInfo();
					//��λ�ɱ� = ��������˵Ľ��㵥�ܳɱ�/��������˵Ľ��㵥�ܽ�������
					info.setUnitCost(unitCost);
					//�������� = �����κ�ͬ���״̬�����׵��ϵĽ�������
					BigDecimal settleWgt = getAuditSettWgt(ctx, contractInfo.getId().toString(),period);   //getSettleWgt(ctx, contractInfo.getId().toString(),period);
					//�ݹ��ɱ�
					BigDecimal peCost = settleWgt.multiply(unitCost).setScale(2,RoundingMode.HALF_UP);
					info.setPeCost(peCost);
					if(iCodingRuleManager.isExist(info, companyID)){
						if(iCodingRuleManager.isUseIntermitNumber(info, companyID)){
							info.setNumber(iCodingRuleManager.getNonbreakNumber(info,companyID));
						}else{
							info.setNumber(iCodingRuleManager.getNumber(info,companyID));
						}
					}
					info.setFICompany(ContextUtil.getCurrentFIUnit(ctx));
					info.setPeriod(period);
					info.setFarmer(contractInfo.getFarmer());
					info.setFarm(contractInfo.getFarm());
					info.setBatchContract(contractInfo);
					info.setBreedData(contractInfo.getBreedData());
					//���ý�������
					info.setSettleWgt(settleWgt);
					info.setBizDate(new Date());
					//���ù�˾
					info.setCompany(contractInfo.getCompany());

					iCKPECostbill.addnew(info);
				}
				//���ڸ������ݹ��ɱ���
				if(2 == 2){
					CKPECostbillInfo info=new CKPECostbillInfo();
					//��λ�ɱ� = ��������˵Ľ��㵥�ܳɱ�/��������˵Ľ��㵥�ܽ�������
					info.setUnitCost(unitCost);
					//�������� = �����κ�ͬ���״̬�����׵��ϵĽ�������
					BigDecimal settleWgt = getAuditSettWgt(ctx, contractInfo.getId().toString(),period);   //getSettleWgt(ctx, contractInfo.getId().toString(),period);
					//�ݹ��ɱ�
					BigDecimal peCost = settleWgt.multiply(unitCost).setScale(2,RoundingMode.HALF_UP);
					info.setPeCost(peCost.negate());
					if(iCodingRuleManager.isExist(info, companyID)){
						if(iCodingRuleManager.isUseIntermitNumber(info, companyID)){
							info.setNumber(iCodingRuleManager.getNonbreakNumber(info,companyID));
						}else{
							info.setNumber(iCodingRuleManager.getNumber(info,companyID));
						}
					}
					info.setFICompany(ContextUtil.getCurrentFIUnit(ctx));
					//���ұ��ڵ�����
					String s1 = "/*dialect*/ select t2.periodid periodid from ( select t1.fid periodid from T_BD_Period t1 " +
					" where fnumber >'"+period.getNumber()+"' order by FPeriodYear,FPeriodNumber ) t2 where rownum = 1";
					IRowSet r1 = DbUtil.executeQuery(ctx, s1);
					String periodid = null;
					PeriodInfo pInfo = null;
					if(r1.next()){
						periodid = r1.getString("periodid");
						pInfo = PeriodFactory.getLocalInstance(ctx).getPeriodInfo(new ObjectUuidPK(periodid));
					}else{
						throw new EASBizException(new NumericExceptionSubItem("001","���ڵĻ���ڼ�δ����"));
					}

					info.setPeriod(pInfo);
					info.setFarmer(contractInfo.getFarmer());
					info.setFarm(contractInfo.getFarm());
					info.setBatchContract(contractInfo);
					info.setBreedData(contractInfo.getBreedData());
					//���ý�������
					info.setSettleWgt(settleWgt.negate());
					//���ù�˾
					info.setCompany(contractInfo.getCompany());
					info.setBizDate(new Date());
					info.setIsNextPeriod(true);
					iCKPECostbill.addnew(info);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 *  �����κ�ͬ���״̬�Ľ��㵥�ϵĽ�������
	 * @param ctx
	 * @param string
	 * @param period
	 * @return
	 */
	private BigDecimal getAuditSettWgt(Context ctx, String contractid,
			PeriodInfo period) {
		// TODO Auto-generated method stub
		if("ofk9pKI6SemT5QR+uV1yi/Zvfq8=".equalsIgnoreCase(contractid)){
			System.out.println("ֹͣ");
		}
		String s1 = "/*dialect*/ select sum(t1.CFSettleWeight) settleWeight from CT_FM_CSlaughterBill t1" +
		" inner join T_FM_BatchContractBill t2 on t2.fid = t1.CFBatchContractID" +
		" where t1.CFBillStatus in (4,7) and t2.fid = '"+contractid+"'" +
		" and t1.FBizDate >= to_date('"+sdf.format(period.getBeginDate())+"','yyyy-MM-dd hh24:mi:ss')" +
		" and t1.FBizDate <= to_date('"+sdf.format(period.getEndDate())+" 23:59:59','yyyy-MM-dd hh24:mi:ss')";
		BigDecimal settleWeight = BigDecimal.ZERO;
		try {
			IRowSet r1 = DbUtil.executeQuery(ctx, s1);
			if(r1.next()){
				settleWeight = UIRuleUtil.getBigDecimal(r1.getBigDecimal("settleWeight"));
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return settleWeight;
	}

	//��ȡ���㾻��
	private BigDecimal getSettleWgt(Context ctx,String contractID,PeriodInfo period) {
		// TODO Auto-generated method stub
		BigDecimal settleWgt=BigDecimal.ZERO;
		StringBuffer sqlBuf = new StringBuffer();
		//		sqlBuf.append(" /*dialect*/select nvl(sum(nvl(CFsettleWgt,0)),0) settleWgt from CT_FM_PreHouseWgtBill   ")
		//		.append(" where CFBillStatus=4 ") 
		//		.append(" and CFBatchContractID='"+contractID+"'")
		//		.append(" and FBizDate >= to_date('"+sdf.format(period.getBeginDate())+"','yyyy-MM-dd hh24:mi:ss') ")
		//		.append(" and FBizDate <= to_date('"+sdf.format(period.getEndDate())+" 23:59:59','yyyy-MM-dd hh24:mi:ss') ");	
		sqlBuf.append("/*dialect*/ select nvl(sum(nvl(t4.settleWgt,0)),0) settleWgt from (  select  nvl(sum(nvl(t1.CFSettleWeight,0)),0) settleWgt from CT_FM_CSlaughterBill t1")
		.append(" inner join T_FM_BatchContractBill t2 on t2.fid = t1.CFBatchContractID")
		.append(" inner join CT_FM_CKSettleBill t3 on t3.CFBatchContractID = t2.fid")
		.append(" where t1.CFBillStatus in (4,7)  and t3.CFBillStatus not in (4,7)")
		.append(" and t1.CFBatchContractID = '").append(contractID).append("'")
		.append(" and t1.FBizDate >= to_date('"+sdf.format(period.getBeginDate())+"','yyyy-MM-dd hh24:mi:ss') ")
		.append(" and t1.FBizDate <= to_date('"+sdf.format(period.getEndDate())+" 23:59:59','yyyy-MM-dd hh24:mi:ss') ")
		.append(" union all select  nvl(sum(nvl(t1.CFSettleWeight,0)),0) settleWgt  from CT_FM_CSlaughterBill t1")
		.append(" inner join T_FM_BatchContractBill t2 on t2.fid = t1.CFBatchContractID")
		.append(" left join CT_FM_CKSettleBill t3 on t3.CFBatchContractID = t2.fid")
		.append(" where t1.CFBillStatus in (4,7)  and t3.fid is null")
		.append(" and t1.CFBatchContractID = '").append(contractID).append("'")
		.append(" and t1.FBizDate >= to_date('"+sdf.format(period.getBeginDate())+"','yyyy-MM-dd hh24:mi:ss') ")
		.append(" and t1.FBizDate <= to_date('"+sdf.format(period.getEndDate())+" 23:59:59','yyyy-MM-dd hh24:mi:ss') ) t4");		
		try {
			IRowSet rs = DbUtil.executeQuery(ctx, sqlBuf.toString());
			if(rs.next()){
				settleWgt=rs.getBigDecimal("settleWgt");
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return settleWgt;
	}

	//����ɱ�������(����δ��˼��رճɱ��������)
	private void calAndUpdate(Context ctx, String companyID, PeriodInfo period) throws EASBizException {
		// TODO Auto-generated method stub
		allCost=BigDecimal.ZERO;
		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append(" /*dialect*/select fid from CT_FM_CKSettleBill ")
		.append(" where FBizDate >= to_date('"+sdf.format(period.getBeginDate())+"','yyyy-MM-dd hh24:mi:ss') ")
		.append(" and FBizDate <= to_date('"+sdf.format(period.getEndDate())+" 23:59:59','yyyy-MM-dd hh24:mi:ss') ")
		//		.append(" and (CFIsFromCB is null or CFIsFromCB=0)")
		.append(" and CFFICompanyID='"+companyID+"'");
		try {
			IRowSet rs = DbUtil.executeQuery(ctx, sqlBuf.toString());
			while(rs.next()){
				CKSettleBillInfo settleBillInfo = iCKSettleBill.getCKSettleBillInfo(new ObjectUuidPK(rs.getString("fid")));
				String contractID = settleBillInfo.getBatchContract().getId().toString();
				if(settleBillInfo.getBillStatus()!=null
						&& (settleBillInfo.getBillStatus()==BillBaseStatusEnum.AUDITED
								|| settleBillInfo.getBillStatus()==BillBaseStatusEnum.CLOSED)
				){
					//��������ҩ�ܳɱ�
					BigDecimal[] mlyCost=calMLYCost(ctx, period, contractID, settleBillInfo);
					BigDecimal seedCost = mlyCost[0];
					BigDecimal fodderCost = mlyCost[1];
					BigDecimal drugCost  = mlyCost[2];
					BigDecimal allocateCost = calAllocateCost(ctx, period, contractID);
					BigDecimal dyFee = UIRuleUtil.getBigDecimal(settleBillInfo.getDyFee());

					//��ȡ��ֳ��
					FarmInfo farmInfo = settleBillInfo.getFarm();
					farmInfo = FarmFactory.getLocalInstance(ctx).getFarmInfo(new ObjectUuidPK(farmInfo.getId()));

					//����Ʒ
					BigDecimal otherMatQty = BigDecimal.ZERO;
					if(farmInfo.getFarmType().equals(StockingFarmTypeEnum.company)
							&& farmInfo.getFaemsType().equals(FarmsType.ly)){
						otherMatQty = UIRuleUtil.getBigDecimal(settleBillInfo.getRecQty()).multiply(new BigDecimal("-0.1")).divide(BigDecimal.ONE,2,BigDecimal.ROUND_HALF_UP);
					}
					//�ܳɱ�ԭ���Ļ����ϼ��ϸ���Ʒ�ɱ�
					BigDecimal billCost = (seedCost.add(fodderCost).add(drugCost).add(allocateCost).add(dyFee).add(otherMatQty)).divide(BigDecimal.ONE,2,BigDecimal.ROUND_HALF_UP);
					BigDecimal settleWgt = UIRuleUtil.getBigDecimal(settleBillInfo.getSettleWgt());
					BigDecimal billUnitCost= settleWgt.signum()==0?BigDecimal.ZERO:billCost.divide(settleWgt,2,RoundingMode.HALF_UP);



					StringBuffer updateSql=new StringBuffer();
					//ֻ����ֳ������Ϊ������ֳ�� �� ��ֳģʽΪ�����İ���ʽ���㸱��Ʒ�ɱ�
					if(farmInfo.getFarmType().equals(StockingFarmTypeEnum.company)
							&& farmInfo.getFaemsType().equals(FarmsType.ly)){
						updateSql.append("update CT_FM_CKSettleBill set CFSeedCost=").append(seedCost)
						.append(",CFFodderCost=").append(fodderCost)
						.append(",CFDrugCost=").append(drugCost)
						.append(",CFOtherMatCost=").append(otherMatQty)
						.append(",CFAllocateAmt=").append(allocateCost)
						.append(",CFUnitCost=").append(billUnitCost)
						.append(",CFAllCost=").append(billCost).append(" where fid='"+settleBillInfo.getId().toString()+"'");
					}else{
						updateSql.append("update CT_FM_CKSettleBill set CFSeedCost=").append(seedCost)
						.append(",CFFodderCost=").append(fodderCost)
						.append(",CFDrugCost=").append(drugCost)
						.append(",CFOtherMatCost=").append(BigDecimal.ZERO)
						.append(",CFAllocateAmt=").append(allocateCost)
						.append(",CFUnitCost=").append(billUnitCost)
						.append(",CFAllCost=").append(billCost).append(" where fid='"+settleBillInfo.getId().toString()+"'");
					}

					DbUtil.execute(ctx, updateSql.toString());
					allCost=allCost.add(dyFee);
					allSettleWgt=allSettleWgt.add(settleWgt);
				}
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	//�ѽ������θ���ǰ���ڼ����ɵ��ݹ��ɱ������ɶ�Ӧ�����ݹ��ɱ���
	private void hedgeCKPECostbill(Context ctx,PeriodInfo period,String contractID) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		ICKPECostbill iCKPECostbill=CKPECostbillFactory.getLocalInstance(ctx);
		ICodingRuleManager iCodingRuleManager = CodingRuleManagerFactory.getLocalInstance(ctx);

		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append("/*dialect*/ select * from  CT_FM_CKPECostbill t1 ")
		.append(" inner join T_BD_Period t2 on t1.CFPeriodID=t2.fid ")
		.append(" where t2.FBeginDate< to_date('").append(sdf.format(period.getBeginDate())).append("','yyyy-mm-dd')")
		.append(" and t1.CFBatchContractID='").append(contractID).append("'");
		try {
			IRowSet rs = DbUtil.executeQuery(ctx, sqlBuf.toString());
			while(rs.next()){
				CKPECostbillInfo preInfo=CKPECostbillFactory.getLocalInstance(ctx).getCKPECostbillInfo(new ObjectUuidPK(rs.getString("fid")));
				CKPECostbillInfo info=new CKPECostbillInfo();
				String orgUnitID=ContextUtil.getCurrentOrgUnit(ctx).getId().toString();
				if(iCodingRuleManager.isExist(info, orgUnitID)){
					if(iCodingRuleManager.isUseIntermitNumber(info, orgUnitID)){
						//�����������Ϻ� --> ��ȡ�Ϻű���
						info.setNumber(iCodingRuleManager.getNonbreakNumber(info,orgUnitID));
					}else{
						info.setNumber(iCodingRuleManager.getNumber(info,orgUnitID));
					}
				}
				info.setPeriod(period);
				info.setFICompany(preInfo.getFICompany());
				info.setBizDate(new Date());
				info.setFarmer(preInfo.getFarmer());
				info.setFarm(preInfo.getFarm());
				info.setBatchContract(preInfo.getBatchContract());
				info.setBreedData(preInfo.getBreedData());
				info.setSettleWgt(preInfo.getSettleWgt().negate());
				info.setPeCost(UIRuleUtil.getBigDecimal(preInfo.getPeCost()).negate());
				iCKPECostbill.addnew(info);
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//����ҩ�ɱ�
	private BigDecimal[] calMLYCost(Context ctx,PeriodInfo period,String contractID,CKSettleBillInfo info) throws EASBizException {
		// TODO Auto-generated method stub
		BigDecimal[] mlyCost=new BigDecimal[3];
		BigDecimal seedCost=BigDecimal.ZERO;
		BigDecimal fodderCost=BigDecimal.ZERO;
		BigDecimal drugCost=BigDecimal.ZERO;
		try {
			BatchContractBillInfo batchContractInfo = info.getBatchContract();
			//��
			StringBuffer s1 = new StringBuffer(); 
			s1.append("/*dialect*/ select sum(nvl(t3.FActualCost,0)) seedCost from T_FM_BreedSeedReceiveBill  t1 ")
			.append(" inner join T_FM_BreedSeedReceiveBillEntry t2 on t2.fparentid = t1.fid")
			.append(" inner join T_IM_MaterialReqBillEntry t3 on t3.FSourceBillEntryID = t2.fid ")
			.append(" inner join T_IM_MaterialReqBill t4 on t4.fid = t3.fparentid")
			.append(" where t4.FBaseStatus = 4 and  t1.FBatchContractID = '").append(batchContractInfo.getId()).append("'");
			IRowSet r1 = DbUtil.executeQuery(ctx, s1.toString());
			if(r1.next()){
				seedCost = UIRuleUtil.getBigDecimal(r1.getBigDecimal("seedCost"));
			}

			//��
			StringBuffer s2 = new StringBuffer(); 
			s2.append("/*dialect*/ select sum(nvl(t3.FActualCost,0)) fodderCost from T_FM_FodderReception  t1 ")
			.append(" inner join T_FM_FodderReceptionEntry t2 on t2.fparentid = t1.fid")
			.append(" inner join T_IM_MaterialReqBillEntry t3 on t3.FSourceBillEntryID = t2.fid ")
			.append(" inner join T_IM_MaterialReqBill t4 on t4.fid = t3.fparentid")
			.append(" where t4.FBaseStatus = 4 and  t1.CFBatchContractID = '").append(batchContractInfo.getId()).append("'");
			IRowSet r2 = DbUtil.executeQuery(ctx, s2.toString());
			if(r2.next()){
				fodderCost = UIRuleUtil.getBigDecimal(r2.getBigDecimal("fodderCost"));
			}
			//ҩ
			StringBuffer s3 = new StringBuffer(); 
			s3.append(" /*dialect*/ select sum(nvl(t3.FActualCost,0)) drugCost from T_FM_DrugReceiveBill  t1 ")
			.append(" inner join T_FM_DrugReceiveBillEntry t2 on t2.fparentid = t1.fid")
			.append(" inner join T_IM_MaterialReqBillEntry t3 on t3.FSourceBillEntryID = t2.fid ")
			.append(" inner join T_IM_MaterialReqBill t4 on t4.fid = t3.fparentid")
			.append(" where t4.FBaseStatus = 4 and  t1.FBatchContractID = '").append(batchContractInfo.getId()).append("'");
			IRowSet r3 = DbUtil.executeQuery(ctx, s3.toString());
			if(r3.next()){
				drugCost = UIRuleUtil.getBigDecimal(r3.getBigDecimal("drugCost"));
			}

			allCost=allCost.add(seedCost).add(fodderCost).add(drugCost);
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		mlyCost[0]=seedCost;
		mlyCost[1]=fodderCost;
		mlyCost[2]=drugCost;
		return mlyCost;
	}

	//���÷�̯
	private BigDecimal calAllocateCost(Context ctx,PeriodInfo period,String contractID) {
		// TODO Auto-generated method stub
		BigDecimal alocateCost=BigDecimal.ZERO;
		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append(" /*dialect*/select CFAmount amount ")
		.append(" from  CT_FM_CKCostAllocateBill t1 ")
		.append(" inner join CT_FM_CKCostAllocateBillEntry t2 on t1.fid=t2.fparentid ")
		.append(" where  t1.CFBillStatus=4  ")
		.append(" and t2.CFBatchContractID='"+contractID+"' ")
		.append(" and t1.CFPeriodID='"+period.getId().toString()+"' ");
		try {
			IRowSet rs = DbUtil.executeQuery(ctx, sqlBuf.toString());
			if(rs.next()){
				alocateCost=rs.getBigDecimal("amount");
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		allCost=allCost.add(alocateCost);
		return alocateCost;
	}
}