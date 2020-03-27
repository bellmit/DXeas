package com.kingdee.eas.farm.carnivorous.recyclebiz.app;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.ctrl.data.engine.rows.IRow;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.bot.BOTMappingCollection;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.master.cssp.ICustomer;
import com.kingdee.eas.basedata.master.cssp.SupplierFactory;
import com.kingdee.eas.basedata.master.cssp.SupplierInfo;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.IStorageOrgUnit;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.eas.farm.carnivorous.basebiz.IMarginUnlockBill;
import com.kingdee.eas.farm.carnivorous.basebiz.MarginUnlockBillFactory;
import com.kingdee.eas.farm.carnivorous.basebiz.MarginUnlockBillInfo;
import com.kingdee.eas.farm.carnivorous.basedata.CalUnit;
import com.kingdee.eas.farm.carnivorous.basedata.CarviousFeedComMeatEntryCollection;
import com.kingdee.eas.farm.carnivorous.basedata.CarviousFeedComMeatEntryFactory;
import com.kingdee.eas.farm.carnivorous.basedata.CarviousFeedComMeatEntryInfo;
import com.kingdee.eas.farm.carnivorous.basedata.CarviousFeedComMeatFactory;
import com.kingdee.eas.farm.carnivorous.basedata.CarviousFeedComMeatInfo;
import com.kingdee.eas.farm.carnivorous.basedata.ConFeedPolicyFactory;
import com.kingdee.eas.farm.carnivorous.basedata.ConFeedPolicyInfo;
import com.kingdee.eas.farm.carnivorous.basedata.CustomerViewTypeFactory;
import com.kingdee.eas.farm.carnivorous.basedata.DateRelate;
import com.kingdee.eas.farm.carnivorous.basedata.FarmFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo;
import com.kingdee.eas.farm.carnivorous.basedata.ICustomerViewType;
import com.kingdee.eas.farm.carnivorous.basedata.IRewardAndPunishItem;
import com.kingdee.eas.farm.carnivorous.basedata.LessSymbol;
import com.kingdee.eas.farm.carnivorous.basedata.MarginPolicyInfo;
import com.kingdee.eas.farm.carnivorous.basedata.MaterialType;
import com.kingdee.eas.farm.carnivorous.basedata.PunishType;
import com.kingdee.eas.farm.carnivorous.basedata.RewardAndPunishItemFactory;
import com.kingdee.eas.farm.carnivorous.basedata.RewardAndPunishItemInfo;
import com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo;
import com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyRecycleEntryFactory;
import com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyRecycleEntryInfo;
import com.kingdee.eas.farm.carnivorous.basedata.TempPolicyFactory;
import com.kingdee.eas.farm.carnivorous.basedata.TempPolicyInfo;
import com.kingdee.eas.farm.carnivorous.basedata.highSymbol;
import com.kingdee.eas.farm.carnivorous.basedata.recType;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.BizTypeEnum;
import com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.DrugBizType;
import com.kingdee.eas.farm.carnivorous.feedbiz.FodderBillType;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKCloseAccountFacadeFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillDrugEntryInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillEntryInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillFodderEntryInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillPreHouseEntryInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillQCEntryInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillSaleEntryInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillSeedEntryInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillSeedSourceEntryInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillSlaughterEntryInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillTempPolicyEntryInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillViewReqEntryInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.RecType;
import com.kingdee.eas.farm.feemanager.basedata.DriverFactory;
import com.kingdee.eas.farm.feemanager.basedata.DriverInfo;
import com.kingdee.eas.farm.hatch.HatchBaseDataFactory;
import com.kingdee.eas.farm.hatch.HatchBaseDataInfo;
import com.kingdee.eas.farm.stocking.basedata.BreedDataInfo;
import com.kingdee.eas.farm.stocking.common.BotpCommUtils;
import com.kingdee.eas.publicdata.CarFactory;
import com.kingdee.eas.publicdata.CarInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.BotpAppCommon;
import com.kingdee.eas.wlhlcomm.DateCommon;
import com.kingdee.eas.wlhlcomm.WorkFlowUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class CKSettleBillControllerBean extends AbstractCKSettleBillControllerBean{

	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.carnivorous.recyclebiz.app.CKSettleBillControllerBean");
	public static final SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat sdfTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
	public static final SimpleDateFormat sdfMM=new SimpleDateFormat("yyyy-MM");
	private IMaterial ims =null;
	private IRewardAndPunishItem IQCItem =null;
	private ICustomer iCustomer=null;
	private ICustomerViewType iViewType=null;
	private IRowSet rs;
	private String message=null;
	private IStorageOrgUnit iStorageOrgUnit=null;
	private Map result=new HashMap<String, Object>();
	private boolean isUpDateActAmt=false;

	@Override
	protected void _hasPay(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		//		super._hasPay(ctx, model);
		if(UIRuleUtil.isNotNull(((CKSettleBillInfo) model).getId())){
			String id = ((CKSettleBillInfo) model).getId().toString();
			CKSettleBillInfo info = CKSettleBillFactory.getLocalInstance(ctx).getCKSettleBillInfo(new ObjectUuidPK(((CKSettleBillInfo) model).getId()));
			String s1 = "/*dialect*/ update  CT_FM_CKSettleBill set CFHasPay = 1  where fid ='"+id+"'";
			com.kingdee.eas.util.app.DbUtil.execute(ctx, s1.toString());
		}

	}


	protected void _audit(Context ctx, IObjectValue model)throws BOSException, EASBizException{
		CKSettleBillInfo info = CKSettleBillFactory.getLocalInstance(ctx).getCKSettleBillInfo(new ObjectUuidPK(((CKSettleBillInfo) model).getId()));
		if(info.getBillStatus()==null||!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED))
			throw new EASBizException(new NumericExceptionSubItem("001","ֻ���ύ�ĵ��Ӳſ���ִ�д˲���"));
		if(StockingComm.checkIsHasSettled(ctx, info.getBatchContract().getId().toString())){
			throw new EASBizException(new NumericExceptionSubItem("001","�������ѽ������"));
		}
		if(info.getActualPayAmt()==null){
			throw new EASBizException(new NumericExceptionSubItem("001","����δִ�й�����,����ʧ��!"));
		}
		checkIsGuanZhang(ctx, info);
		checkIsHasUnAuditBill(ctx, info);
		info.setBillStatus(BillBaseStatusEnum.AUDITED);
		info.setAuditTime(new java.util.Date());
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
		updateBatchData(ctx, info,true);	
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
		createToDestBill(ctx, info);
	}


	protected void _unAudit(Context ctx, IObjectValue model)throws BOSException, EASBizException{
		CKSettleBillInfo info = CKSettleBillFactory.getLocalInstance(ctx).getCKSettleBillInfo(new ObjectUuidPK(((CKSettleBillInfo) model).getId()));
		if(info.getBillStatus()==null||!info.getBillStatus().equals(BillBaseStatusEnum.AUDITED))
			throw new EASBizException(new NumericExceptionSubItem("001","ֻ����˵ĵ��Ӳſ���ִ�д˲���"));
		beforeUnAudit(ctx, info);
		if(DbUtil.executeQuery(ctx, "select * from T_BOT_Relation where FSrcObjectID='"+info.getString("id")+"'").size()>0)
			throw new EASBizException(new NumericExceptionSubItem("001","�����ε��ݵĵ��ݽ�ֹ�����"));
		checkIsGuanZhang(ctx, info);
		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		info.setAuditTime(null);
		info.setAuditor(null);
		updateBatchData(ctx, info,false);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}

	@Override
	protected void _close(Context ctx, IObjectValue model) throws BOSException,
	EASBizException {
		CKSettleBillInfo info = CKSettleBillFactory.getLocalInstance(ctx).getCKSettleBillInfo(new ObjectUuidPK(((CKSettleBillInfo) model).getId()));
		if(info.getBillStatus()==null||!info.getBillStatus().equals(BillBaseStatusEnum.AUDITED))
			throw new EASBizException(new NumericExceptionSubItem("001","ֻ����˵ĵ��Ӳſ���ִ�д˲���"));
		info.setBillStatus(BillBaseStatusEnum.CLOSED);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}

	@Override
	protected void _unClose(Context ctx, IObjectValue model) throws BOSException,
	EASBizException {
		CKSettleBillInfo info = CKSettleBillFactory.getLocalInstance(ctx).getCKSettleBillInfo(new ObjectUuidPK(((CKSettleBillInfo) model).getId()));
		if(info.getBillStatus()==null||!info.getBillStatus().equals(BillBaseStatusEnum.CLOSED))
			throw new EASBizException(new NumericExceptionSubItem("001","ֻ�йرյĵ��Ӳſ���ִ�д˲���"));
		info.setBillStatus(BillBaseStatusEnum.AUDITED);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		CKSettleBillInfo info = (CKSettleBillInfo) model;
		if(StockingComm.checkIsHasPreHouseSettleBill(ctx, info.getBatchContract().getId().toString(),info.getId().toString())){
			throw new EASBizException(new NumericExceptionSubItem("001","���������ɹ����㵥"));
		}
		//		if(info.getBillStatus()!=null&&info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)&&!info.getBillStatus().equals(BillBaseStatusEnum.ADD))
		//			throw new EASBizException(new NumericExceptionSubItem("001","ֻ���������߱���ĵ��Ӳſ���ִ�д˲���"));
		if(StockingComm.checkIsHasSettled(ctx, info.getBatchContract().getId().toString())){
			throw new EASBizException(new NumericExceptionSubItem("001","�������ѽ������"));
		}	
		//		checkIsGuanZhang(ctx, info);
		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)) {
			info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		}
		return super._save(ctx, info);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		CKSettleBillInfo info = (CKSettleBillInfo) model;   	
		if(StockingComm.checkIsHasPreHouseSettleBill(ctx, info.getBatchContract().getId().toString(),info.getId().toString())){
			throw new EASBizException(new NumericExceptionSubItem("001","���������ɹ����㵥"));
		}
		//		if(info.getBillStatus()!=null&&info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)&&!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)&&!info.getBillStatus().equals(BillBaseStatusEnum.ADD))
		//			throw new EASBizException(new NumericExceptionSubItem("001","ֻ��������������ύ�ĵ��Ӳſ���ִ�д˲���"));
		if(StockingComm.checkIsHasSettled(ctx, info.getBatchContract().getId().toString())){
			throw new EASBizException(new NumericExceptionSubItem("001","�������ѽ������"));
		}
		//		checkIsGuanZhang(ctx, info);
		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)||info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)) {
			info.setBillStatus(BillBaseStatusEnum.SUBMITED); 
		}
		return super._submit(ctx, info);
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		CKSettleBillInfo info = CKSettleBillFactory.getLocalInstance(ctx).getCKSettleBillInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","�����Ѿ���ˣ���ֹɾ����"));
		}
		if(WorkFlowUtil.checkBillInWorkflow(ctx,pk.toString())){
			throw new EASBizException(new NumericExceptionSubItem("001","��ǰ�������ڹ�����ִ�й���,����ִ�иò���"));
		}
		//��д��ǰ����
		updatePreHouseBill(ctx, info, false);
		super._delete(ctx, pk);
	}

	//����������Ϣ
	@Override
	protected void _updateSaleData(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		CKSettleBillInfo info = (CKSettleBillInfo) model; 
		//		if(info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)||info.getBillStatus().equals(BillBaseStatusEnum.CLOSED)){
		//			throw new EASBizException(new NumericExceptionSubItem("001","����˻�رյĽ��㵥�޷�ִ�иò���"));
		//		}
		setSaleEntrys(ctx, info);
		//		super._save(ctx, info);
	}

	/**
	 * �б���� ����������Ϣ������
	 */
	@Override
	protected void _updateSale(Context ctx, IObjectValue model)
	throws BOSException {
		// TODO Auto-generated method stub
		CKSettleBillInfo info = (CKSettleBillInfo) model; 
		//		setSaleEntrys(ctx, info);
	}


	private void setSaleEntrys(Context ctx, CKSettleBillInfo info) {
		// TODO Auto-generated method stub

		//ɾ�����۷�¼
		CKSettleBillSaleEntryInfo saleInfo = null;
		for(int i = 0,size = info.getSaleEntrys().size();i<size;i++){
			saleInfo = info.getSaleEntrys().get(i);
			String s2 = "/*dialect*/ delete from CT_FM_CKSettleBillSaleEntrys where fid = '"+saleInfo.getId()+"'";
			try {
				com.kingdee.eas.util.app.DbUtil.execute(ctx, s2.toString());
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append("/*dialect*/ select t3.FBizDate  bizDate, t3.fnumber   fnumber,t3.FBaseStatus billStatus,")
		.append(" t3.FCustomerID  customerID,t4.FQty  qty,t4.FTaxPrice taxPrice,t4.FAmount amount from")
		.append(" CT_FM_CSlaughterBill  t1 inner join T_BOT_Relation t2 on t2.FSrcObjectID = t1.fid")
		.append(" inner join T_IM_SaleIssueBill t3 on t3.fid = t2.FDestObjectID")
		.append(" inner join T_IM_SaleIssueEntry t4 on t4.FPARENTID = t3.fid")
		.append(" where t1.CFBillStatus in (4,7) and t1.CFBatchContractID = '").append(info.getBatchContract().getId().toString()).append("'");
		try { 
			rs=DbUtil.executeQuery(ctx, sqlBuf.toString());
			Date bizDate = null;
			String fnumber = null;
			int billStatus = 1;
			String customerID = null;
			BigDecimal qty = BigDecimal.ZERO;
			BigDecimal taxPrice = BigDecimal.ZERO;
			BigDecimal amount = BigDecimal.ZERO;
			while(rs.next()) {
				//������Ϣ
				bizDate = rs.getDate("bizDate");
				fnumber = rs.getString("fnumber");
				billStatus = rs.getInt("billStatus");
				customerID = rs.getString("customerID");
				qty = rs.getBigDecimal("qty");
				taxPrice = rs.getBigDecimal("taxPrice");
				amount = rs.getBigDecimal("amount");

				String s5 = "/*dialect*/ SELECT newbosid('69C9FAB4') bosid FROM dual"; 
				String bosid = null;
				IRowSet r5 = DbUtil.executeQuery(ctx, s5);
				if(r5.next()){ 
					bosid = r5.getString("bosid");
					if(bosid != null){
						//�������۷�¼
						String s1 = "/*dialect*/ insert into  CT_FM_CKSettleBillSaleEntrys (fid,FParentID,CFBizDate,CFBillNumber,CFBaseStatus,CFCustomerID,CFRecSuttle,CFOutSalePrice,CFOutSaleAmt)" +
						" values('"+bosid+"','"+info.getId()+"', to_date('"+bizDate+"','yyyy-MM-dd') ,'"+fnumber+"','"+billStatus+"','"+customerID+"','"+qty+"','"+taxPrice+"','"+amount+"')";
						com.kingdee.eas.util.app.DbUtil.execute(ctx, s1.toString());
					}
				}
			}

			//���¹�˾�����ֶ� = ���״̬�����۳��ⵥ��˰�ϼƻ��� - �ܳɱ�
			StringBuffer sql = new StringBuffer();
			sql.append("/*dialect*/ select sum(nvl(t4.FAmount,0))  amount1 from")
			.append(" CT_FM_CSlaughterBill  t1 inner join T_BOT_Relation t2 on t2.FSrcObjectID = t1.fid")
			.append(" inner join T_IM_SaleIssueBill t3 on t3.fid = t2.FDestObjectID")
			.append(" inner join T_IM_SaleIssueEntry t4 on t4.FPARENTID = t3.fid")
			.append(" where t1.CFBillStatus in (4,7) and t3.FBaseStatus = 4 and t1.CFBatchContractID = '").append(info.getBatchContract().getId().toString()).append("'"); 
			BigDecimal amount1 = BigDecimal.ZERO;
			IRowSet r1=DbUtil.executeQuery(ctx, sql.toString());
			if(r1.next()){
				amount1 = UIRuleUtil.getBigDecimal(r1.getBigDecimal("amount1"));
			}
			BigDecimal companyProfit = amount1.subtract(UIRuleUtil.getBigDecimal(info.getAllCost()));	
			String s1 = "/*dialect*/ update  CT_FM_CKSettleBill  set CFCompanyProfit ="+companyProfit+"  where fid = '"+info.getId()+"'";
			com.kingdee.eas.util.app.DbUtil.execute(ctx, s1.toString());

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (BOSException e) {
			e.printStackTrace();
		}
	}




	//ִ�н���
	@Override
	protected Map _execSettle(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		CKSettleBillInfo info = (CKSettleBillInfo) model; 
		if(StockingComm.checkIsHasSettled(ctx, info.getBatchContract().getId().toString())){
			throw new EASBizException(new NumericExceptionSubItem("001","�������ѽ������"));
		}
		if(info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)||info.getBillStatus().equals(BillBaseStatusEnum.CLOSED)){
			throw new EASBizException(new NumericExceptionSubItem("001","����˻�رյĽ��㵥��ֹ���½���"));
		}
		//У������ε���״̬
		checkIsHasUnAuditBill(ctx, info);		
		checkIsGuanZhang(ctx, info);
		ims=MaterialFactory.getLocalInstance(ctx);
		iStorageOrgUnit=StorageOrgUnitFactory.getLocalInstance(ctx);
		//������Դ
		setSeedSourceEntry(ctx, info);
		//��
		setBreedSeedEntry(ctx, info);
		//��
		setFodderEntry(ctx, info);
		//ҩ
		setDrugEntry(ctx, info);
		//���׵�
		setSlaughterEntry(ctx, info);
		//������Ϣ����ǰ������¼
		setRecDataAndPreEntry(ctx, info);
		//���ݼ���
		setDataByInfo(ctx, info);

		//����������Ϣ
		setSaleEntrys(ctx, info);
		super._save(ctx, info);
		return result;
	}



	@Override
	public Map updateActAmt(Context ctx, CKSettleBillInfo model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		return super.updateActAmt(ctx, model);
	}


	//������Դ
	private void setSeedSourceEntry(Context ctx, CKSettleBillInfo info) {
		// TODO Auto-generated method stub
		info.getSeedSourceEntrys().clear();
		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append(" /*dialect*/select  ")
		.append(" t3.fid storageOrgUnit, ")
		.append(" t2.flot lot, ")
		.append(" sum(t2.fqty) qty ")
		.append(" from T_IM_SaleIssueBill t1 ")
		.append(" inner join T_IM_SaleIssueEntry t2 on t1.fid=t2.fparentid ")
		.append(" inner join T_ORG_Storage t3 on t1.FStorageOrgUnitID=t3.fid ")
		.append(" where t1.fid in  (select  t2.FDestObjectID from T_FM_BreedSeedReceiveBill t1 ")
		.append(" inner  join T_BOT_Relation t2 on (t1.fid=t2.FSrcObjectID and t2.FDestEntityID='CC3E933B') ")
		.append(" where t1.FBatchContractID='"+info.getBatchContract().getId().toString()+"') ")
		.append(" and t1.FBaseStatus in (4,7) ")
		.append(" group by t3.fid,t2.flot ");
		try {
			rs=DbUtil.executeQuery(ctx, sqlBuf.toString());
			while(rs.next()){
				CKSettleBillSeedSourceEntryInfo entryInfo=new CKSettleBillSeedSourceEntryInfo();
				entryInfo.setStorageOrgUnit(iStorageOrgUnit.getStorageOrgUnitInfo(new ObjectUuidPK(rs.getString("storageOrgUnit"))));
				entryInfo.setLot(rs.getString("lot"));
				entryInfo.setQty(rs.getBigDecimal("qty"));
				info.getSeedSourceEntrys().add(entryInfo);
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void setDataByInfo(Context ctx, CKSettleBillInfo info) throws EASBizException, BOSException {
		//����� = ��������/��������
		info.setMeatRate(UIRuleUtil.getBigDecimal(info.getSettleWgt()).signum()==0?BigDecimal.ZERO:UIRuleUtil.getBigDecimal(info.getFeedWgt()).divide(UIRuleUtil.getBigDecimal(info.getSettleWgt()),2,RoundingMode.HALF_UP));
		info.setActualMRate(info.getMeatRate());
		//�ɻ��� = ����ֻ��/��������
		info.setSurvivalRate(UIRuleUtil.getBigDecimal(info.getBatchQty()).signum()==0?BigDecimal.ZERO:UIRuleUtil.getBigDecimal(info.getRecQty()).divide(UIRuleUtil.getBigDecimal(info.getBatchQty()),4,RoundingMode.HALF_UP).multiply(new BigDecimal(100)));
		//ë������ = ��������/����ֻ��
		info.setChickenAveWgt(UIRuleUtil.getIntValue(info.getRecQty())==0?BigDecimal.ZERO:UIRuleUtil.getBigDecimal(info.getSettleWgt()).divide(UIRuleUtil.getBigDecimal(info.getRecQty()),2,RoundingMode.HALF_UP));
		//ֻ���� = ��������/��������
		info.setSingleFeedWgt(UIRuleUtil.getBigDecimal(info.getBatchQty()).signum()==0?BigDecimal.ZERO:UIRuleUtil.getBigDecimal(info.getFeedWgt()).divide(UIRuleUtil.getBigDecimal(info.getBatchQty()),2,RoundingMode.HALF_UP));
		//ֻ��ҩ = ��ҩ���/��������
		info.setSingleDrugAmt(UIRuleUtil.getBigDecimal(info.getBatchQty()).signum()==0?BigDecimal.ZERO:UIRuleUtil.getBigDecimal(info.getDrugAmt()).divide(UIRuleUtil.getBigDecimal(info.getBatchQty()),2,RoundingMode.HALF_UP));
		//����ҩ�ܽ��
		info.setMlyAllAmt(UIRuleUtil.getBigDecimal(info.getDrugAmt()).add(UIRuleUtil.getBigDecimal(info.getBatchAmt())).add(UIRuleUtil.getBigDecimal(info.getFeedAmt())));
		//�����������û���ڼ�
		PeriodInfo period=DateUtilsComm.getPeriodInfoByDate(ctx,info.getBizDate());
		info.setPeriod(period);

		SelectorItemCollection slor=new SelectorItemCollection();
		slor.add("*");
		slor.add("conFeedContract.*");
		slor.add("settlementPolicy.*");
		slor.add("breedData.*");
		slor.add("marginPolicy.*");
		slor.add("farmer.*");
		BatchContractBillInfo contractInfo=null; 
		ConFeedContractInfo conFeedContract=null;
		try {
			contractInfo = BatchContractBillFactory.getLocalInstance(ctx).getBatchContractBillInfo(new ObjectUuidPK(info.getBatchContract().getId()),slor);
			if(contractInfo.getConFeedContract()!=null){
				conFeedContract = contractInfo.getConFeedContract();
			}else{
				if(info.getConFeedContract()!=null){
					conFeedContract=ConFeedContractFactory.getLocalInstance(ctx).getConFeedContractInfo(new ObjectUuidPK(info.getConFeedContract().getId()));
				}			
			}
			if(conFeedContract!=null){
				info.setCFBeginDate(conFeedContract.getBeginDate());
				info.setCFEndDate(conFeedContract.getEndDate());
				info.setConFeededNum(conFeedContract.getCurSettledNum());
			}
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//������ϸ��۲���Ϣ��������Ϣ
		setRecEntryAndKPData(ctx, info, contractInfo);
	}

	private void setRecEntryAndKPData(Context ctx,CKSettleBillInfo info,BatchContractBillInfo contractInfo) throws EASBizException, BOSException {

		FarmerInfo farmer = info.getFarmer();
		FarmInfo farm = null;
		try {
			farm = FarmFactory.getLocalInstance(ctx).getFarmInfo(new ObjectUuidPK(info.getFarm().getId()));
		} catch (BOSException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		};
		try {
			farmer = FarmerFactory.getLocalInstance(ctx).getFarmerInfo(new ObjectUuidPK(farmer.getId()));
		} catch (BOSException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		if(contractInfo==null){
			return;
		}

		info.getEntrys().clear();
		BigDecimal standardRecRate = UIRuleUtil.getBigDecimal(contractInfo.getSettlementPolicy().getStandardRecRate()).multiply(new BigDecimal(0.01));
		BigDecimal survivalRate = UIRuleUtil.getBigDecimal(info.getSurvivalRate()).divide(new BigDecimal(100));
		BigDecimal chickenAveWgt = UIRuleUtil.getIntValue(info.getRecQty())==0?BigDecimal.ZERO:UIRuleUtil.getBigDecimal(info.getRecSuttle()).divide(UIRuleUtil.getBigDecimal(info.getRecQty()),8,RoundingMode.HALF_UP); 
		SettlePolicyInfo settlementPolicy = contractInfo.getSettlementPolicy();
		MarginPolicyInfo marginPolicy = contractInfo.getMarginPolicy();

		//������ֳģʽ�ͽ�������
		info.setFarmsType(farm.getFaemsType());
		info.setSettlePolicy(settlementPolicy);


		BigDecimal inWeight=BigDecimal.ZERO;

		//���û�����Ϣ��¼
		setSettleBillEntry(ctx,info,contractInfo);




		/****A��****/
		//		CKSettleBillEntryInfo outEntry=new CKSettleBillEntryInfo();
		//		outEntry=new CKSettleBillEntryInfo();
		//		outEntry.setRecType(RecType.inner);
		//		outEntry.setQty(UIRuleUtil.getIntValue(AQty));
		//		outEntry.setWeight(suttle.subtract(Bweight).subtract(returnWeight).subtract(UIRuleUtil.getBigDecimal(info.getPunishWgt())));
		//		outEntry.setPrice(hAbasePrice);
		//		outAmount=(suttle.subtract(Bweight).subtract(returnWeight).subtract(UIRuleUtil.getBigDecimal(info.getPunishWgt()))).multiply(hAbasePrice).setScale(2,BigDecimal.ROUND_HALF_UP);
		//		outEntry.setAmount(outAmount);
		//		outEntry.setAverageWgt(outEntry.getQty()==0?BigDecimal.ZERO:outEntry.getWeight().divide(UIRuleUtil.getBigDecimal(outEntry.getQty()),2,RoundingMode.HALF_UP));
		//		outWeight=UIRuleUtil.getBigDecimal(outEntry.getWeight());
		//		outQty=UIRuleUtil.getIntValue(outEntry.getQty());
		//
		//		/****B��****/
		//		CKSettleBillEntryInfo inEntry=new CKSettleBillEntryInfo();
		//		inEntry.setRecType(RecType.out);
		//		inEntry.setQty(UIRuleUtil.getIntValue(BQty));
		//		inEntry.setWeight(Bweight);
		//		inEntry.setPrice(oBbasePrice);
		//		inAmount=UIRuleUtil.getBigDecimal(inEntry.getWeight()).multiply(UIRuleUtil.getBigDecimal(inEntry.getPrice())).setScale(2,BigDecimal.ROUND_HALF_UP);
		//		inEntry.setAmount(inAmount);
		//		inEntry.setAverageWgt(UIRuleUtil.getBigDecimal(inEntry.getQty()).signum()==0?BigDecimal.ZERO:UIRuleUtil.getBigDecimal(inEntry.getWeight()).divide(UIRuleUtil.getBigDecimal(inEntry.getQty()),2,RoundingMode.HALF_UP));
		//		inQty=UIRuleUtil.getIntValue(inEntry.getQty());
		//		inWeight=UIRuleUtil.getBigDecimal(inEntry.getWeight());
		//
		//		info.getEntrys().add(inEntry);
		//		info.getEntrys().add(outEntry);










		//���ñ�׼����ȣ�ʵ������ȣ�����ȿ۷���׼
		String s4 = "/*dialect*/ select t2.CFPrice  standRate from CT_FM_CarviousFeedComMeat t1" +
		" inner join CT_FM_CarviousFeedComMeatEntry t2 on t2.fparentid = t1.fid" +
		" where t1.CFBreedDataID ='"+contractInfo.getBreedData().getId().toString()+"' and t2.CFMinValue<"+info.getFeedDays()+"  and t2.CFMaxValue>="+info.getFeedDays();
		BigDecimal standRate = BigDecimal.ZERO;
		try {
			IRowSet r4 = DbUtil.executeQuery(ctx, s4.toString());
			if(r4.next()){
				standRate = UIRuleUtil.getBigDecimal(r4.getBigDecimal("standRate"));
			}
		} catch (BOSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		//��׼�����
		info.setStandardMRate(standRate);    
		//����ȿ۷���׼
		BigDecimal fmRatePunishStd = UIRuleUtil.getBigDecimal(settlementPolicy.getFmRatePunishStd());
		info.setFmRatePunishStd(fmRatePunishStd);
		//����ȿ۷���� = ����׼����-ʵ�����ϣ�*����ȿ۷���׼
		BigDecimal mRatePAmt = BigDecimal.ZERO;
		if(!UIRuleUtil.getBooleanValue(info.isNoCalFodderPunish())){
			if(UIRuleUtil.getBigDecimal(info.getFeedWgt())
					.subtract(standRate.multiply(UIRuleUtil.getBigDecimal(info.getSettleWgt())))
					.compareTo(BigDecimal.ZERO)>=0){
				mRatePAmt = BigDecimal.ZERO;
			}else{
				mRatePAmt = (info.getSettleWgt().multiply(standRate).subtract(info.getFeedWgt())).multiply(fmRatePunishStd).setScale(2,BigDecimal.ROUND_HALF_UP);
				mRatePAmt = mRatePAmt.multiply(new BigDecimal("-1"));
			}
		}

		info.setMRatePAmt(mRatePAmt);

		//��ֻ/���߷�
		BigDecimal singleMargin = UIRuleUtil.getBigDecimal(settlementPolicy.getImmuneCost());
		info.setSingleMargin(singleMargin);
		BigDecimal unLockedMargin = singleMargin.multiply(info.getBatchQty());
		info.setUnLockedMargin(unLockedMargin);

		//ʵ����ҩ = ����ҳǩ��ҩ���+��������*��������������߷�
		BigDecimal actDrug = info.getDrugAmt();
		info.setSingleActualDrug(actDrug);
		//��׼��ҩ
		//ȡ����ȱ�׼�� ��ֻҩ��
		BigDecimal singleDrugStd = getOneDrug(ctx,info,contractInfo);
		BigDecimal drugAmtStd = UIRuleUtil.getBigDecimal(info.getBatchQty()).multiply(singleDrugStd).subtract(unLockedMargin);
		info.setSingleStandardDrug(drugAmtStd); 

		//����ѡ����--ҩƷ����۷���׼
		if(!UIRuleUtil.getBoolean(info.isNoCalDrupPunish())){
			if(actDrug.compareTo(drugAmtStd)>=0){
				info.setDrugLackPAmt(BigDecimal.ZERO);
			}else{
				info.setDrugLackPAmt(actDrug.subtract(drugAmtStd));
			}
		}else{//��ѡ�ˣ�������
			info.setDrugLackPAmt(BigDecimal.ZERO);
		}

		//�����������(Ԫ/ֻ)

		info.setImmuneCostOne(UIRuleUtil.getBigDecimal(settlementPolicy.getImmuneTost()));

		//���������
		String s5 = "/*dialect*/ select sum(t2.FAllReceiveQty) allRec from T_FM_BreedSeedReceiveBill  t1" +
		" inner join T_FM_BreedSeedReceiveBillEntry t2 on t2.fparentid = t1.fid" +
		" where t1.FBatchContractID = '"+contractInfo.getId()+"' and t1.CFIsInsertImm = 1 ";
		BigDecimal allRec = BigDecimal.ZERO;
		try {
			IRowSet r5 = DbUtil.executeQuery(ctx, s5.toString());
			if(r5.next()){
				allRec = UIRuleUtil.getBigDecimal(r5.getBigDecimal("allRec"));
			}
		} catch (BOSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		info.setImmuneCost(UIRuleUtil.getBigDecimal(settlementPolicy.getImmuneTost()).multiply(allRec).multiply(new BigDecimal("-1")));


		//����ʵ������
		info.setActualFoder(info.getFeedWgt());
		//���ñ�׼����
		info.setStandFodder(standRate.multiply(UIRuleUtil.getBigDecimal(info.getSettleWgt())));



		//����ռ�ñ�֤��
		//		BigDecimal usedMargin = UIRuleUtil.getBigDecimal(contractInfo.getUsedMargin());
		//		info.setBatchOccupyMargin(usedMargin);
		//��׼��֤��
		BigDecimal standardMargin = BigDecimal.ZERO;
		if(marginPolicy != null){
			standardMargin = UIRuleUtil.getBigDecimal(marginPolicy.getSingleMargin()).multiply(info.getBatchQty());
			info.setStandardMargin(standardMargin);
		}


		//��ͬ������
		info.setContractCKWgt(inWeight);
		//��������
		try {
			ConFeedPolicyInfo conFeedPolicy;
			if(info.getKbConFeedPolicy()==null){
				info.setConFeedSubsidies(BigDecimal.ZERO);
			}else{
				conFeedPolicy=ConFeedPolicyFactory.getLocalInstance(ctx).getConFeedPolicyInfo(new ObjectUuidPK(info.getKbConFeedPolicy().getId())) ;
				BigDecimal conFeedSubsidy = UIRuleUtil.getBigDecimal(conFeedPolicy.getSubsidy());
				info.setConFeedSubsidies(inWeight.multiply(conFeedSubsidy).setScale(2,BigDecimal.ROUND_HALF_UP));
			}
		} catch (BOSException e) {
			e.printStackTrace();
		}
		//�˷Ѳ�����׼
		BigDecimal freightSubsidiesStd = UIRuleUtil.getBigDecimal(settlementPolicy.getFreightSubsidiesStd());
		info.setFreightSubsidiesStd(freightSubsidiesStd);
		//�˷Ѳ�۲���
		BigDecimal lFeedWgt = UIRuleUtil.getBigDecimal(info.getLFeedWgt());
		BigDecimal freightPrice = UIRuleUtil.getBigDecimal(info.getFreightPrice());
		if(freightSubsidiesStd.compareTo(freightPrice)>0){
			info.setFreightDiffSubsidies(BigDecimal.ZERO);
		}else{
			info.setFreightDiffSubsidies((freightSubsidiesStd.subtract(freightPrice)).multiply(lFeedWgt).divide(new BigDecimal(1000)).setScale(2,BigDecimal.ROUND_HALF_UP));
		}
		//��֤���ܶ�/ռ��/����
		info.setTotalMargin(farmer.getTotalMargin());
		info.setEnableMargin(farmer.getEnableMargin());
		//		info.setUnLockedMargin(contractInfo.getUnlockMargin());

		//��֤��
		info.setOccupyMargin(farmer.getOccupyMargin());




		//��������(%)
		BigDecimal loanRate = UIRuleUtil.getBigDecimal(settlementPolicy.getDepositRate());
		info.setLoanRate(loanRate);
		//�ʽ�ռ������
		BigDecimal moneyOccupyDays = UIRuleUtil.getBigDecimal(info.getMoneyOccupyDays());
		//��Ԥ����
		BigDecimal deductAdPayAmt = UIRuleUtil.getBigDecimal(info.getDeductAdPayAmt());
		info.setAdPayAmount(deductAdPayAmt);
		//��Ԥ����ռ�÷���Ԥ�������
		BigDecimal adPayBalance = UIRuleUtil.getBigDecimal(info.getAdPayBalance());
		info.setKYFKOccupyFee(adPayBalance.multiply(moneyOccupyDays).divide(new BigDecimal(30),8,RoundingMode.HALF_UP).multiply(loanRate.divide(new BigDecimal(100))).setScale(2,BigDecimal.ROUND_HALF_UP).negate());

		//���ս��  = ���������еĻ��ձ��׼�*��ǰ�����ܾ���
		BigDecimal basePrice = BigDecimal.ZERO;
		for(int i = 0,size = settlementPolicy.getRecycleEntry().size();i<size;i++){
			SettlePolicyRecycleEntryInfo entryInfo = SettlePolicyRecycleEntryFactory.getLocalInstance(ctx).getSettlePolicyRecycleEntryInfo(new ObjectUuidPK(settlementPolicy.getRecycleEntry().get(i).get("id").toString()));
			if(entryInfo.getRecType().equals(recType.GA)){
				basePrice = entryInfo.getBasePrice();
			}
		}
		info.setRecAmt(basePrice.multiply(info.getSettleWgt()));





		//��������
		BigDecimal deductMargin = BigDecimal.ZERO;
		if(contractInfo.getConFeedPolicy() != null){
			ConFeedPolicyInfo CfPolicyInfo = ConFeedPolicyFactory.getLocalInstance(ctx).getConFeedPolicyInfo(new ObjectUuidPK(contractInfo.getConFeedPolicy().getId()));
			deductMargin = UIRuleUtil.getBigDecimal(CfPolicyInfo.getSubsidy());
		}
		info.setMarginAmt(deductMargin.multiply(info.getBatchQty()));

		BigDecimal qcPunishAmt=BigDecimal.ZERO,viewAmt=BigDecimal.ZERO,otherAmt=BigDecimal.ZERO,tempAmt=BigDecimal.ZERO,kbAmt=BigDecimal.ZERO;
		//Ʒ�ʿۿ��¼
		qcPunishAmt=setQCEntrys(ctx, info, qcPunishAmt);
		//���߲����¼
		viewAmt=setViewEntrys(ctx, info, viewAmt);
		//�����۲���¼
		StringBuffer otherKbDetail=new StringBuffer();
		for(int i=0;i<info.getOtherEntrys().size();i++){
			BigDecimal entryAmt = info.getOtherEntrys().get(i).getAmount();
			String rptype = info.getOtherEntrys().get(i).getRpType();
			if(entryAmt.signum()!=0){
				otherKbDetail.append(rptype+" "+entryAmt+"��");
			}
			otherAmt=otherAmt.add(entryAmt);
		}
		if (otherKbDetail.length() - 1>=0) 
			otherKbDetail.deleteCharAt(otherKbDetail.length()-1);
		String detail = otherKbDetail.toString();
		if(detail.length()>255){
			detail=otherKbDetail.toString().substring(0,255);
		}
		info.setOtherKbDetail(detail);


		//		//�����۲���
		//		BigDecimal outSaleKbAmt = UIRuleUtil.getBigDecimal(info.getOutSaleKbAmt());
		//		info.setOutSaleKbAmt2(outSaleKbAmt);

		kbAmt =UIRuleUtil.getBigDecimal(info.getDrugLackPAmt())
		.add(UIRuleUtil.getBigDecimal(info.getMRatePAmt()))
		.add(UIRuleUtil.getBigDecimal(info.getImmuneCost()))
		.add(UIRuleUtil.getBigDecimal(info.getCleanHouse()));



		//ŷָ
		BigDecimal oValue =BigDecimal.ZERO;
		if(UIRuleUtil.getBigDecimal(info.getMeatRate()).signum()==0||UIRuleUtil.getBigDecimal(info.getFeedDays()).signum()==0){
			oValue=BigDecimal.ZERO;
		}else{
			oValue= ((info.getSurvivalRate().multiply(UIRuleUtil.getBigDecimal(info.getChickenAveWgt()))).divide(new BigDecimal(100))).divide((info.getMeatRate().multiply(UIRuleUtil.getBigDecimal(info.getFeedDays()))),6,RoundingMode.HALF_UP).setScale(6,BigDecimal.ROUND_HALF_UP);
			oValue = oValue.multiply(new BigDecimal("10000"));
		}
		info.setOValue(oValue);





		//���˷� = ���õ���������*�˷ѵ��ۣ���ֳ����Ϣ��ά�����˷ѵ��ۣ�
		BigDecimal tranCost = UIRuleUtil.getBigDecimal(farm.getTransPrice()).multiply(info.getFeedWgt());
		info.setTranCost(tranCost);

		BigDecimal standTran = getStandTran(ctx,info,farm);
		if(UIRuleUtil.getBigDecimal(farm.getTransPrice()).compareTo(standTran) > 0){
			//��˾�˷�
			BigDecimal companyTC = standTran.multiply(info.getFeedWgt());
			//˾���˷�
			BigDecimal diverCt = tranCost.subtract(companyTC);
			info.setCompanyTC(diverCt);
			info.setDiverCt(companyTC);
		}else{
			info.setDiverCt(tranCost);
			info.setCompanyTC(BigDecimal.ZERO);
		}


		//��֤����ȡ���
		BigDecimal occupyMargin = BigDecimal.ZERO;
		if(marginPolicy != null){
			occupyMargin = info.getBatchQty().multiply(UIRuleUtil.getBigDecimal(marginPolicy.getSingleMargin()));
		} 
		info.setMarginGAmount(occupyMargin);

		//����ֳ�
		BigDecimal proDiv = proDivCal(ctx,info,contractInfo,basePrice);
		info.setProDiv(proDiv);

		//������ = ���ս��+����ֳ�+ʵ�ʴ�����+��������+�۲���Ŀ���+���ϲ���ۿ�+��ҩ����ۿ�
		//-����ҩ�ܽ��-Ʒ�ʿۿ�-���˷�-���߷�
		BigDecimal dyFee = info.getRecAmt()
		.add(UIRuleUtil.getBigDecimal(info.getProDiv()))
		.add(UIRuleUtil.getBigDecimal(info.getOutSaleKbAmt2()))
		.add(UIRuleUtil.getBigDecimal(info.getMarginAmt()))
		.add(UIRuleUtil.getBigDecimal(info.getKbItemAmt()))
		.add(UIRuleUtil.getBigDecimal(info.getDrugLackPAmt()))
		.add(UIRuleUtil.getBigDecimal(info.getMRatePAmt()))
		.subtract(UIRuleUtil.getBigDecimal(info.getMlyAllAmt()))
		.subtract(UIRuleUtil.getBigDecimal(info.getQCItemAmt()))
		.subtract(UIRuleUtil.getBigDecimal(info.getTranCost()))
		.subtract(UIRuleUtil.getBigDecimal(info.getUnLockedMargin()));
		dyFee = dyFee.divide(BigDecimal.ONE,2,BigDecimal.ROUND_HALF_UP);
		info.setDyFee(dyFee);
		//���óɱ���Ϣҳǩ������
		info.setDaiyFee(dyFee);

		//ֻ������
		BigDecimal singleDyFee = UIRuleUtil.getBigDecimal(info.getBatchQty()).signum()==0?BigDecimal.ZERO:info.getDyFee().divide(info.getBatchQty(),2,RoundingMode.HALF_UP);
		info.setSingleDyFee(singleDyFee);


		//Ƿ����
		BigDecimal noPfoRetAmt = UIRuleUtil.getBigDecimal(info.getLongBorrowAmount())
		.subtract(UIRuleUtil.getBigDecimal(info.getLongBorrowReturn()))
		.subtract(UIRuleUtil.getBigDecimal(info.getDyFee()));
		info.setNoPfoRetAmt(noPfoRetAmt);


		//���ù�˾ë���͵�ֻë��
		BigDecimal farmerOnlyPro = UIRuleUtil.getBigDecimal(info.getRecAmt())
		.subtract(UIRuleUtil.getBigDecimal(info.getDyFee()))
		.subtract(UIRuleUtil.getBigDecimal(info.getMlyAllAmt()))
		.subtract(UIRuleUtil.getBigDecimal(info.getUnLockedMargin()));
		info.setFarmeronlyPro(farmerOnlyPro);
		info.setFarmerOnlyProOne(farmerOnlyPro.
				divide(UIRuleUtil.getBigDecimal(info.getBatchQty()),2,BigDecimal.ROUND_HALF_UP));




		//ʵ��֧��=������-��֤����ȡ���-����������
		BigDecimal actualPayAmt = dyFee
		.subtract(UIRuleUtil.getBigDecimal(info.getMarginGAmount()))
		.subtract(UIRuleUtil.getBigDecimal(info.getLongBorrowReturn()));
		info.setActualPayAmt(actualPayAmt);


		//�����������ۼ���� = �������+Ԥ������Ѻ��+��֤����ȡ���+�豸������+����������+����������
		BigDecimal nowAccountBac = UIRuleUtil.getBigDecimal(info.getBeforeBatchAmount())
		.add(UIRuleUtil.getBigDecimal(info.getReserveRiskCost()))
		.add(UIRuleUtil.getBigDecimal(info.getMarginGAmount()))
		.add(UIRuleUtil.getBigDecimal(info.getEquipmentReAmt()));
		info.setNowAccountBac(nowAccountBac);


		//���ó�Դ
		String s13 = "/*dialect*/ select CFSourceHatchAreaI hatch,CFPurSupplierID suppid  from T_FM_BreedSeedReceiveBill t1 where t1.FBatchContractID = '"+contractInfo.getId()+"'";
		try {
			IRowSet r13 = DbUtil.executeQuery(ctx, s13);
			String hatch = null;
			String suppid = null;
			String chickenSource = null;
			if(r13.next()){
				hatch = UIRuleUtil.getString(r13.getString("hatch"));
				suppid = UIRuleUtil.getString(r13.getString("suppid"));
				if(UIRuleUtil.isNotNull(hatch)){
					HatchBaseDataInfo hatchInfo = HatchBaseDataFactory.getLocalInstance(ctx).getHatchBaseDataInfo(new ObjectUuidPK(hatch));
					chickenSource = hatchInfo.getName();
				}else{
					SupplierInfo suppInfo = SupplierFactory.getLocalInstance(ctx).getSupplierInfo(new ObjectUuidPK(suppid));
					chickenSource = suppInfo.getName();
				}
			}
			info.setChickenSource(chickenSource);
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/**
	 * ���û�����Ϣ��¼
	 * @param ctx
	 * @param info
	 * @param contractInfo
	 */
	private void setSettleBillEntry(Context ctx, CKSettleBillInfo info,
			BatchContractBillInfo contractInfo) {
		// TODO Auto-generated method stub
		try {
			String s1 = "/*dialect*/ select t2.CFSettlementItem rectype,t2.CFChickenQty  qty,t2.CFHouseNetWeight  wgt," +
			" t2.CFMarketPrice  price,t2.CFSaleAmount  amount from CT_FM_ChickenRecBill t1" +
			" inner join CT_FM_ChickenRBWE t2 on t2.fparentid = t1.fid" +
			" where t1.CFBatchContractID = '"+contractInfo.getId()+"' order by t2.CFSettlementItem";
			IRowSet r1 = DbUtil.executeQuery(ctx,s1);
			BigDecimal rectype = BigDecimal.ZERO;
			BigDecimal qty = BigDecimal.ZERO;
			BigDecimal wgt = BigDecimal.ZERO;
			BigDecimal price = BigDecimal.ZERO;
			BigDecimal amount = BigDecimal.ZERO;
			BigDecimal avgWgt = BigDecimal.ZERO;
			while(r1.next()){
				rectype = UIRuleUtil.getBigDecimal(r1.getBigDecimal("rectype"));
				qty = UIRuleUtil.getBigDecimal(r1.getBigDecimal("qty"));
				wgt = UIRuleUtil.getBigDecimal(r1.getBigDecimal("wgt"));
				price = UIRuleUtil.getBigDecimal(r1.getBigDecimal("price"));
				amount = UIRuleUtil.getBigDecimal(r1.getBigDecimal("amount"));
				avgWgt = wgt.divide(qty,3,BigDecimal.ROUND_HALF_UP);
				CKSettleBillEntryInfo entryInfo=new CKSettleBillEntryInfo();
				if(rectype.compareTo(BigDecimal.ONE) == 0){
					entryInfo.setRecType(RecType.out);
				}else{
					entryInfo.setRecType(RecType.inner);
				}
				entryInfo.setQty(UIRuleUtil.getIntValue(qty));
				entryInfo.setWeight(wgt);
				entryInfo.setPrice(price);
				entryInfo.setAmount(amount);
				entryInfo.setAverageWgt(avgWgt);
				info.getEntrys().add(entryInfo);
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
	 * ��ȡ��׼�˷ѵ���
	 * @param ctx
	 * @param info
	 * @param farm
	 * @return
	 */
	private BigDecimal getStandTran(Context ctx, CKSettleBillInfo info,
			FarmInfo farm) {
		// TODO Auto-generated method stub
		String s1 = "/*dialect*/ select t2.CFStandInstance stPrice from CT_FM_FeedCostPrice t1" +
		" inner join CT_FM_FeedCostPriceEntry t2 on t2.fparentid = t1.fid" +
		" where t1.CFBaseStatus = 2 and t1.CFCompanyID ='"+info.getFICompany().getId()+"' " +
		" and t1.CFBreedID = '"+info.getBreedData().getId()+"' and t2.CFFarmID = '"+farm.getTreeid().getId()+"'";
		IRowSet r1;
		BigDecimal stPrice = BigDecimal.ZERO;
		try {
			r1 = DbUtil.executeQuery(ctx,s1);
			if(r1.next()){
				stPrice = UIRuleUtil.getBigDecimal(r1.getBigDecimal("stPrice"));
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stPrice;
	}


	/**
	 * ����ֳɼ���
	 * @param contractInfo 
	 * @param info 
	 * @param ctx 
	 * @param basePrice2 
	 * @return
	 */
	private BigDecimal proDivCal(Context ctx, CKSettleBillInfo info, BatchContractBillInfo contractInfo, BigDecimal basePrice) {
		// TODO Auto-generated method stub
		BigDecimal allproDiv = BigDecimal.ZERO;
		String s1 = "/*dialect*/ select t2.CFMarketPrice price, t2.CFHouseNetWeight netWgt from CT_FM_ChickenRecBill t1" +
		" inner join CT_FM_ChickenRBWE t2 on t2.fparentid = t1.fid where t2.CFSettlementItem = 1 and t1.CFBillStatus in (4,7)" +
		" and t1.CFBatchContractID = '"+contractInfo.getId()+"'";
		try {
			IRowSet r1 = DbUtil.executeQuery(ctx, s1);
			BigDecimal price = BigDecimal.ZERO;
			BigDecimal netWgt = BigDecimal.ZERO;
			while(r1.next()){
				price = UIRuleUtil.getBigDecimal(r1.getBigDecimal("price"));
				netWgt = UIRuleUtil.getBigDecimal(r1.getBigDecimal("netWgt"));
				BigDecimal proDiv = (price.subtract(basePrice)).multiply(new BigDecimal("0.5")).multiply(netWgt);
				allproDiv = allproDiv.add(proDiv);
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allproDiv;
	}


	/**
	 * ȡ����ȱ�׼�� ��ֻҩ��
	 * @param ctx
	 * @param info
	 * @param contractInfo
	 */
	private BigDecimal getOneDrug(Context ctx, CKSettleBillInfo info,
			BatchContractBillInfo contractInfo) {
		//��ȡ��Ʒ������ȱ�׼
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			CompanyOrgUnitInfo companyInfo = info.getFICompany();
			String dateStr = sdf.format(info.getBizDate());
			BreedDataInfo bredInfo = info.getBreedData();
			String s1 = "/*dialect*/ select fid  billid  from CT_FM_CarviousFeedComMeat where CFFICompanyID = '"+companyInfo.getId()+"' and CFBreedDataID = '"+bredInfo.getId()+"'" +
			" and to_char(CFBeginDate,'yyyy-MM-dd')<='"+dateStr+"' and to_char(CFEndDate,'yyyy-MM-dd')>='"+dateStr+"'";
			IRowSet r1 = DbUtil.executeQuery(ctx,s1);
			String billid = null;
			if(r1.next()){
				billid = UIRuleUtil.getString(r1.getString("billid"));
				CarviousFeedComMeatInfo meatInfo = CarviousFeedComMeatFactory.getLocalInstance(ctx).getCarviousFeedComMeatInfo(new ObjectUuidPK(billid));
				CarviousFeedComMeatEntryCollection entryColl = meatInfo.getEntrys();
				for(int i = 0,szie = entryColl.size();i<szie;i++){
					CarviousFeedComMeatEntryInfo entryInfo = CarviousFeedComMeatEntryFactory.getLocalInstance(ctx).getCarviousFeedComMeatEntryInfo(new ObjectUuidPK(entryColl.get(i).getId().toString()));
					BigDecimal detectionResult = info.getBatchQty();
					//���ޱȽϷ���Ϊ�գ����ޱȽϷ�Ϊ��
					if(!entryInfo.getMinSymbol().equals(highSymbol.empty)
							&& entryInfo.getMaxSymbol().equals(LessSymbol.empty)){
						//����
						if(entryInfo.getMinSymbol().equals(highSymbol.high)){
							BigDecimal highSymbolValue = UIRuleUtil.getBigDecimal(entryInfo.getMinValue());
							if(detectionResult.compareTo(highSymbolValue) > 0){
								return entryInfo.getOneDrugAmt();
							}
						}
						//���ڵ���
						if(entryInfo.getMinSymbol().equals(highSymbol.highEqual)){
							BigDecimal highSymbolValue = UIRuleUtil.getBigDecimal(entryInfo.getMinValue());
							if(detectionResult.compareTo(highSymbolValue) >= 0){
								return entryInfo.getOneDrugAmt();
							}
						}

						//����
						if(entryInfo.getMinSymbol().equals(highSymbol.equal)){
							BigDecimal highSymbolValue = UIRuleUtil.getBigDecimal(entryInfo.getMinValue());
							if(detectionResult.compareTo(highSymbolValue) == 0){
								return entryInfo.getOneDrugAmt();
							}
						}
					}else if(entryInfo.getMinSymbol().equals(highSymbol.empty)
							&& !entryInfo.getMaxSymbol().equals(LessSymbol.empty)){
						//С��
						if(entryInfo.getMaxSymbol().equals(LessSymbol.less)){
							BigDecimal LessSymbolValue = UIRuleUtil.getBigDecimal(entryInfo.getMaxValue());
							if(detectionResult.compareTo(LessSymbolValue) < 0){
								return entryInfo.getOneDrugAmt();
							}
						}

						//С�ڵ���
						if(entryInfo.getMaxSymbol().equals(LessSymbol.lessEqual)){
							BigDecimal LessSymbolValue = UIRuleUtil.getBigDecimal(entryInfo.getMaxValue());
							if(detectionResult.compareTo(LessSymbolValue) <= 0){
								return entryInfo.getOneDrugAmt();
							}
						}

						//����
						if(entryInfo.getMaxSymbol().equals(LessSymbol.equal)){
							BigDecimal LessSymbolValue = UIRuleUtil.getBigDecimal(entryInfo.getMaxValue());
							if(detectionResult.compareTo(LessSymbolValue) == 0){
								return entryInfo.getOneDrugAmt();
							}
						}

					}else if(!entryInfo.getMinSymbol().equals(highSymbol.empty)
							&& !entryInfo.getMaxSymbol().equals(LessSymbol.empty)){

						//����   С��
						if(entryInfo.getMinSymbol().equals(highSymbol.high)
								&& entryInfo.getMaxSymbol().equals(LessSymbol.less)){
							BigDecimal highSymbolValue = UIRuleUtil.getBigDecimal(entryInfo.getMinValue());
							BigDecimal LessSymbolValue = UIRuleUtil.getBigDecimal(entryInfo.getMaxValue());
							if(detectionResult.compareTo(highSymbolValue) > 0
									&& detectionResult.compareTo(LessSymbolValue) < 0){
								return entryInfo.getOneDrugAmt();
							}
						}

						//���ڵ���   С��
						if(entryInfo.getMinSymbol().equals(highSymbol.highEqual)
								&& entryInfo.getMaxSymbol().equals(LessSymbol.less)){
							BigDecimal highSymbolValue = UIRuleUtil.getBigDecimal(entryInfo.getMinValue());
							BigDecimal LessSymbolValue = UIRuleUtil.getBigDecimal(entryInfo.getMaxValue());
							if(detectionResult.compareTo(highSymbolValue) >= 0
									&& detectionResult.compareTo(LessSymbolValue) < 0){
								return entryInfo.getOneDrugAmt();
							}
						}

						//���ڵ���   С�ڵ���
						if(entryInfo.getMinSymbol().equals(highSymbol.highEqual)
								&& entryInfo.getMaxSymbol().equals(LessSymbol.lessEqual)){
							BigDecimal highSymbolValue = UIRuleUtil.getBigDecimal(entryInfo.getMinValue());
							BigDecimal LessSymbolValue = UIRuleUtil.getBigDecimal(entryInfo.getMaxValue());
							if(detectionResult.compareTo(highSymbolValue) >= 0
									&& detectionResult.compareTo(LessSymbolValue) <= 0){
								return entryInfo.getOneDrugAmt();
							}
						}
						//����   С�ڵ���
						if(entryInfo.getMinSymbol().equals(highSymbol.high)
								&& entryInfo.getMaxSymbol().equals(LessSymbol.lessEqual)){
							BigDecimal highSymbolValue = UIRuleUtil.getBigDecimal(entryInfo.getMinValue());
							BigDecimal LessSymbolValue = UIRuleUtil.getBigDecimal(entryInfo.getMaxValue());
							if(detectionResult.compareTo(highSymbolValue) > 0
									&& detectionResult.compareTo(LessSymbolValue) <= 0){
								return entryInfo.getOneDrugAmt();
							}
						}
					}
				} 
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	private void setBreedSeedEntry(Context ctx, CKSettleBillInfo info) {
		// TODO Auto-generated method stub
		info.getSeedEntrys().clear();
		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append(" /*dialect*/select   ")
		.append(" t1.fbizdate bizdate,t1.fnumber fnumber,t1.FBillStatus billStatus,t1.FBizType bizType,t3.fid materialID, ")
		.append(" t2.FAllReceiveQty qty,t2.CFActualPrice acPrice,t2.CFActualAmt actAmount ,t2.CFContractAmt  contAmount,t2.CFContractPrice conPrice,t2.FReceivePrice price,t2.CFAmount amount ")
		.append(" from T_FM_BreedSeedReceiveBill t1 ")
		.append(" inner join T_FM_BreedSeedReceiveBillEntry t2 on t1.fid=t2.fparentid ")
		.append(" inner join T_BD_Material t3 on t2.FMaterialID=t3.fid ")
		.append(" where   t1.FBatchContractID='"+info.getBatchContract().getId().toString()+"' ")
		.append(" order by t1.FBizDate,t1.fnumber,t1.FBillStatus  ");
		try {
			rs=DbUtil.executeQuery(ctx, sqlBuf.toString());
			BigDecimal sumAmount=BigDecimal.ZERO,sumQty=BigDecimal.ZERO;
			//���ߴ������
			BigDecimal viewItemAmt = BigDecimal.ZERO;
			BigDecimal acPrice=BigDecimal.ZERO;
			BigDecimal conPrice=BigDecimal.ZERO;
			BigDecimal contAmount=BigDecimal.ZERO;
			BigDecimal actAmount=BigDecimal.ZERO;
			BigDecimal allactAmount=BigDecimal.ZERO;
			if(rs.size()>0) {
				MaterialInfo mInfo;
				while(rs.next()) {
					CKSettleBillSeedEntryInfo entryInfo=new CKSettleBillSeedEntryInfo();
					acPrice = rs.getBigDecimal("acPrice");
					conPrice = rs.getBigDecimal("conPrice");
					actAmount = rs.getBigDecimal("actAmount");
					allactAmount = allactAmount.add(actAmount);
					contAmount = rs.getBigDecimal("contAmount");
					entryInfo.setBizDate(rs.getDate("bizdate"));
					entryInfo.setBillNumber(rs.getString("fnumber"));
					entryInfo.setBillStatus(BillBaseStatusEnum.getEnum(rs.getInt("billStatus")));
					entryInfo.setBizType(BizTypeEnum.getEnum(rs.getString("bizType")));
					mInfo=ims.getMaterialInfo(new ObjectUuidPK(rs.getString("materialID")));
					entryInfo.setMaterial(mInfo);
					entryInfo.setMaterialName(mInfo.getName());
					entryInfo.setQty(rs.getBigDecimal("qty"));
					entryInfo.setPolicyPrice(rs.getBigDecimal("price"));
					entryInfo.setAmount(rs.getBigDecimal("amount"));	
					entryInfo.setActAmount(actAmount);
					entryInfo.setActPrice(acPrice);
					entryInfo.setContPrice(conPrice);
					entryInfo.setContAmount(contAmount);
					//����������
					if(rs.getString("billStatus").equals("4")||rs.getString("billStatus").equals("7") ){
						sumQty=sumQty.add(rs.getBigDecimal("qty"));
						sumAmount=sumAmount.add(rs.getBigDecimal("amount"));
					}
					info.getSeedEntrys().add(entryInfo);
					//���ߴ������
					viewItemAmt = BigDecimal.ONE.subtract(rs.getBigDecimal("price").divide(acPrice,4,BigDecimal.ROUND_HALF_UP));
					info.setViewItemAmt(viewItemAmt);
				}
			}


			//���ߴ������
			BigDecimal otherItemAmt = sumQty.multiply(viewItemAmt);
			info.setOtherItemAmt(otherItemAmt);
			//���ߴ�����
			BigDecimal tempItemAmt = acPrice.multiply(otherItemAmt);
			info.setTempItemAmt(tempItemAmt);
			//ʵ�ʴ������
			BigDecimal punishAmt = BigDecimal.ONE.subtract(conPrice.divide(acPrice,4,BigDecimal.ROUND_HALF_UP));
			info.setPunishAmt(punishAmt);
			//ʵ�ʴ������
			BigDecimal chickenRetunAmt = sumQty.multiply(punishAmt);
			info.setChickenRetunAmt(chickenRetunAmt);
			//ʵ�ʴ�����
			BigDecimal outSaleKbAmt2 = acPrice.multiply(chickenRetunAmt);
			info.setOutSaleKbAmt2(outSaleKbAmt2);

			info.setBatchQty(sumQty);
			info.setBatchAmt(allactAmount.setScale(2,BigDecimal.ROUND_HALF_UP));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void setFodderEntry(Context ctx, CKSettleBillInfo info) {
		// TODO Auto-generated method stub
		info.getFodderEntrys().clear();
		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append(" /*dialect*/select   ")
		.append(" t1.fbizdate bizdate,t1.fnumber fnumber,t1.FBillStatus billStatus,t1.FBillType billType,t3.fid materialID, ")
		.append(" t2.FUnitQty unitQty,sum(nvl(t2.FBagQty,0)) bagQty,sum(t2.FReceiveQty) qty, sum(nvl(t2.cfhjfee,0)) hjFee,")
		.append(" t2.FReceivePrice price,sum(t2.CFAmount) amount,t1.CFCarID carID,t1.FDriverID driverID")
		.append(" from T_FM_FodderReception t1 ")
		.append(" inner join T_FM_FodderReceptionEntry t2 on t1.fid=t2.fparentid ")
		.append(" inner join T_BD_Material t3 on t2.FMaterialID=t3.fid ")
		.append(" where  t1.CFBatchContractID='"+info.getBatchContract().getId().toString()+"' ")
		.append(" group by t1.fbizdate,t1.fnumber,t1.FBillStatus,t1.FBillType,t1.CFCarID,t1.FDriverID,t3.fid,t2.FUnitQty,t2.FReceivePrice ")
		.append(" order by t1.fbizdate,t1.fnumber,t1.FBillStatus,t1.FBillType,t1.CFCarID,t1.FDriverID,t3.fid,t2.FUnitQty,t2.FReceivePrice ");
		try {
			rs=DbUtil.executeQuery(ctx, sqlBuf.toString());
			BigDecimal sumAmount=BigDecimal.ZERO,sumQty=BigDecimal.ZERO,sumLWgt=BigDecimal.ZERO;
			int sumBagQty=0;
			if(rs.size()>0) {
				MaterialInfo mInfo;
				while(rs.next()) {
					CKSettleBillFodderEntryInfo entryInfo=new CKSettleBillFodderEntryInfo();
					entryInfo.setBizDate(rs.getDate("bizdate"));
					entryInfo.setBillNumber(rs.getString("fnumber"));
					entryInfo.setBillStatus(BillBaseStatusEnum.getEnum(rs.getInt("billStatus")));
					entryInfo.setBizType(FodderBillType.getEnum(rs.getString("billType")));
					if(StringUtils.isNotBlank(rs.getString("carID"))){
						try{
							CarInfo car=CarFactory.getLocalInstance(ctx).getCarInfo(new ObjectUuidPK(rs.getString("carID")));
							entryInfo.setCar(car);
						} catch (EASBizException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if(StringUtils.isNotBlank(rs.getString("driverID"))){
						try{
							DriverInfo driver=DriverFactory.getLocalInstance(ctx).getDriverInfo(new ObjectUuidPK(rs.getString("driverID")));
							entryInfo.setDriver(driver);
						} catch (EASBizException e) {
							e.printStackTrace();
						}
					}
					mInfo=ims.getMaterialInfo(new ObjectUuidPK(rs.getString("materialID")));
					entryInfo.setMaterial(mInfo);
					entryInfo.setMaterialName(mInfo.getName());
					entryInfo.setUnitQty(rs.getBigDecimal("unitQty"));
					entryInfo.setBagQty(rs.getInt("bagQty"));
					entryInfo.setQty(rs.getBigDecimal("qty"));
					entryInfo.setPolicyPrice(rs.getBigDecimal("price"));
					entryInfo.setAmount(rs.getBigDecimal("amount"));
					entryInfo.setHjFee(rs.getBigDecimal("hjFee"));
					info.getFodderEntrys().add(entryInfo);
					if(rs.getString("billStatus").equals("4")||rs.getString("billStatus").equals("7") ){
						//������������������(�����ϻػ���)
						sumQty=sumQty.add(rs.getBigDecimal("qty"));
						sumAmount=sumAmount.add(rs.getBigDecimal("amount")).add(rs.getBigDecimal("hjFee"));
						sumBagQty=sumBagQty+rs.getInt("bagQty");
						//��������
						sumLWgt=sumLWgt.add(rs.getBigDecimal("qty"));
					}
				}
			}
			info.setFeedWgt(sumQty);
			info.setFeedQty(sumBagQty);
			info.setFeedAmt(sumAmount.setScale(2,BigDecimal.ROUND_HALF_UP));
			info.setLFeedWgt(sumLWgt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void setDrugEntry(Context ctx, CKSettleBillInfo info) {
		// TODO Auto-generated method stub
		info.getDrugEntrys().clear();
		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append(" /*dialect*/select   ")
		.append(" t1.fbizdate bizdate,t1.fnumber fnumber,t1.FBillStatus billStatus,t1.CFBizType billType,t3.fid materialID, ")
		.append(" sum(t2.FReceiveQty) qty,t2.FReceivePrice price,sum(t2.CFAmount) amount ")
		.append(" from T_FM_DrugReceiveBill t1 ")
		.append(" inner join T_FM_DrugReceiveBillEntry t2 on t1.fid=t2.fparentid ")
		.append(" inner join T_BD_Material t3 on t2.FMaterialID=t3.fid ")
		.append(" where  t1.FBatchContractID='"+info.getBatchContract().getId().toString()+"' ")
		.append(" group by t1.fbizdate,t1.FBillStatus,t1.fnumber,t1.CFBizType,t3.fid,t2.FReceivePrice ")
		.append(" order by t1.fbizdate,t1.fnumber,t1.FBillStatus,t1.CFBizType,t3.fid,t2.FReceivePrice ");
		try {
			rs=DbUtil.executeQuery(ctx, sqlBuf.toString());
			BigDecimal sumAmount=BigDecimal.ZERO,sumQty=BigDecimal.ZERO;
			BigDecimal drugQty = BigDecimal.ZERO;
			if(rs.size()>0) {
				MaterialInfo mInfo;
				while(rs.next()) {
					CKSettleBillDrugEntryInfo entryInfo=new CKSettleBillDrugEntryInfo();
					entryInfo.setBizDate(rs.getDate("bizdate"));
					entryInfo.setBillNumber(rs.getString("fnumber"));
					entryInfo.setBillStatus(BillBaseStatusEnum.getEnum(rs.getInt("billStatus")));
					entryInfo.setBizType(DrugBizType.getEnum(rs.getString("billType")));
					mInfo=ims.getMaterialInfo(new ObjectUuidPK(rs.getString("materialID")));
					entryInfo.setMaterial(mInfo);
					entryInfo.setMaterialName(mInfo.getName());
					entryInfo.setQty(rs.getBigDecimal("qty"));
					entryInfo.setPolicyPrice(rs.getBigDecimal("price"));
					entryInfo.setAmount(rs.getBigDecimal("amount"));
					info.getDrugEntrys().add(entryInfo);
					drugQty = drugQty.add(UIRuleUtil.getBigDecimal(rs.getBigDecimal("qty")));
					//ҩƷ��������
					if(rs.getString("billStatus").equals("4")||rs.getString("billStatus").equals("7") ){
						sumQty=sumQty.add(rs.getBigDecimal("qty"));
						sumAmount=sumAmount.add(rs.getBigDecimal("amount"));
					}
				}
			}	
			info.setDrugQty(drugQty);
			info.setDrugAmt(sumAmount.setScale(2,BigDecimal.ROUND_HALF_UP));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void setSlaughterEntry(Context ctx, CKSettleBillInfo info) {
		// TODO Auto-generated method stub
		info.getSlaughterEntrys().clear();
		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append(" /*dialect*/select  ")
		.append(" FBizDate bizDate,fnumber fnumber,CFBillStatus billStatus, ")
		.append(" CFReceQty receQty,CFAQty AQty,CFAWeight AWeight,CFPunishWgt punishAllWgt,CFSettleWeight settlementWgt,CFBQty BQty,CFBWeight BWeight,CFReturnWeight returnWeight")
		.append(" from CT_FM_CSlaughterBill where ")
		.append(" CFBatchContractID ='"+info.getBatchContract().getId().toString()+"' ")
		.append(" order by FBizDate,fnumber  ");
		try {
			rs=DbUtil.executeQuery(ctx, sqlBuf.toString());
			BigDecimal sumPunishWgt=BigDecimal.ZERO;
			while(rs.next()) {
				CKSettleBillSlaughterEntryInfo entryInfo=new CKSettleBillSlaughterEntryInfo();
				entryInfo.setBizDate(rs.getDate("bizdate"));
				entryInfo.setBillNumber(rs.getString("fnumber"));
				entryInfo.setBillStatus(BillBaseStatusEnum.getEnum(rs.getInt("billStatus")));
				entryInfo.setRecQty(rs.getInt("receQty"));
				entryInfo.setPreHouseSuttle(rs.getBigDecimal("BWeight"));
				entryInfo.setCarcassQty(rs.getInt("AQty"));
				entryInfo.setCarcassWgt(rs.getBigDecimal("BQty"));
				entryInfo.setInCompleteWgt(rs.getBigDecimal("returnWeight"));

				entryInfo.setAWeight(rs.getBigDecimal("AWeight"));
				entryInfo.setPunishAllWeight(rs.getBigDecimal("punishAllWgt"));
				entryInfo.setSettlementAllWig(rs.getBigDecimal("settlementWgt"));
				info.getSlaughterEntrys().add(entryInfo);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void setRecDataAndPreEntry(Context ctx, CKSettleBillInfo info) {
		// TODO Auto-generated method stub
		info.getPreHouseEntrys().clear();
		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append(" /*dialect*/select FBizDate bizDate,FNumber fnumber,CFBillStatus billStatus, ")
		.append(" nvl(CFPreHouseTare,0) preHouseTare,nvl(CFPreHouseGross,0) preHouseGross,")
		.append(" nvl(CFPreHouseSuttle,0) preHouseSuttle,nvl(CFPreHouseQty,0) preHouseQty, ")
		.append(" nvl(CFRecQty,0) recQty,nvl(CFSettleWgt,0) settleWgt, nvl(CFRecSuttle,0) recSuttle,")
		.append(" to_date(to_char(FBizDate,'yyyy-mm-dd'),'yyyy-mm-dd')-to_date(to_char(CFInDate,'yyyy-mm-dd'),'yyyy-mm-dd') feedDays")
		.append(" from CT_FM_PreHouseWgtBill ")
		.append(" where CFBatchContractID ='"+info.getBatchContract().getId().toString()+"' ")
		.append(" order by FBizDate,fnumber  ");
		try {
			rs=DbUtil.executeQuery(ctx, sqlBuf.toString());
			BigDecimal sumPreHouseSuttle=BigDecimal.ZERO,sumSettleWgt=BigDecimal.ZERO,
			sumRecSuttle=BigDecimal.ZERO,sumSettleWgtDays=BigDecimal.ZERO,recsuttle=BigDecimal.ZERO;
			int sumRecQty=0;
			while(rs.next()) {
				//������Ϣ
				if(rs.getString("billStatus").equals("4")||rs.getString("billStatus").equals("7") ){
					sumRecQty=sumRecQty+rs.getInt("recQty");
					sumPreHouseSuttle=sumPreHouseSuttle.add(rs.getBigDecimal("preHouseSuttle"));
					sumSettleWgt=sumSettleWgt.add(rs.getBigDecimal("settleWgt"));
					sumRecSuttle=sumRecSuttle.add(rs.getBigDecimal("recSuttle"));
					sumSettleWgtDays=sumSettleWgtDays.add(UIRuleUtil.getBigDecimal(rs.getBigDecimal("feedDays")).multiply(rs.getBigDecimal("settleWgt")));
				}	
				//��ǰ������¼
				CKSettleBillPreHouseEntryInfo entryInfo = new CKSettleBillPreHouseEntryInfo();
				entryInfo.setBizDate(rs.getDate("bizDate"));
				entryInfo.setBillNumber(rs.getString("fnumber"));
				entryInfo.setBillStatus(BillBaseStatusEnum.getEnum(rs.getInt("billStatus")));
				entryInfo.setPreHouseQty(rs.getInt("preHouseQty"));
				entryInfo.setPreHouseTare(rs.getBigDecimal("preHouseTare"));
				entryInfo.setPreHouseGross(rs.getBigDecimal("preHouseGross"));
				entryInfo.setPreHouseSuttle(rs.getBigDecimal("preHouseSuttle"));
				entryInfo.setRecQty(rs.getInt("recQty"));
				entryInfo.setSettleWgt(rs.getBigDecimal("settleWgt"));
				entryInfo.setRecSuttle(rs.getBigDecimal("recSuttle"));
				info.getPreHouseEntrys().add(entryInfo);
			}
			info.setRecQty(sumRecQty);
			info.setPreHouseWgt(sumPreHouseSuttle);
			info.setRecSuttle(sumRecSuttle);






			//�������� = ��ѯ�������õ���������
			String s0 = "/*dialect*/ select min(FBizDate) mixBizdate from T_FM_BreedSeedReceiveBill  where FBillStatus in (4,7) and FBatchContractID ='"+info.getBatchContract().getId().toString()+"'";
			IRowSet r0 = DbUtil.executeQuery(ctx, s0);
			Date maxBreedbizdate = new Date();
			if(r0.next()){
				maxBreedbizdate = UIRuleUtil.getDateValue(r0.getDate("mixBizdate"));
				if(maxBreedbizdate != null){
					info.setInDate(maxBreedbizdate);
				}
			}

			//���û�������=��һ��ë�����յ�����
			Date maxBizdate = info.getRecDate();

			//������������ = ��������-��������+1���������䣩
			if(maxBizdate != null && maxBreedbizdate != null){
				int betweenDate = DateCommon.dateDiff(maxBizdate, maxBreedbizdate);
				info.setFeedDays(betweenDate+1);
			}



			//���û���ֻ��=ë�����յ�����ֻ��,������������ǰ�����ܺϼ�
			String s2 = "/*dialect*/ select sum(t2.CFChickenQty) receQty,sum(t2.CFHouseNetWeight) returnWeight from CT_FM_ChickenRecBill t1 " +
			" inner join CT_FM_ChickenRBWE t2 on t2.FParentID = t1.fid  where t1.CFBatchContractID ='"+info.getBatchContract().getId().toString()+"'";
			IRowSet r2 = DbUtil.executeQuery(ctx, s2);
			BigDecimal receQty = BigDecimal.ZERO;
			BigDecimal returnWeight = BigDecimal.ZERO;//���׵��ķ���������
			if(r2.next()){
				receQty = UIRuleUtil.getBigDecimal(r2.getBigDecimal("receQty"));
				returnWeight = UIRuleUtil.getBigDecimal(r2.getBigDecimal("returnWeight"));
				info.setRecQty(UIRuleUtil.getIntValue(receQty));
				info.setSettleWgt(returnWeight);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private BigDecimal setQCEntrys(Context ctx, CKSettleBillInfo info,BigDecimal punishAmt) {
		// TODO Auto-generated method stub
		info.getQCEntrys().clear();
		StringBuffer qcDetail=new StringBuffer();
		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append(" /*dialect*/select  t1.fnumber fnumber,t2.*")
		.append(" from CT_FM_CSlaughterBill t1 ")
		.append(" inner join CT_FM_CSlaughterBillQCEntrys t2 on t1.fid=t2.fparentid  ")
		.append(" where t1.CFBillStatus =4  ")
		.append(" and t1.CFBatchContractID ='"+info.getBatchContract().getId().toString()+"' ")
		.append(" order by t1.fbizdate,t1.fnumber,t2.CFQCItemID,t2.CFRandPType  ");
		try {
			IQCItem=RewardAndPunishItemFactory.getLocalInstance(ctx);
			rs=DbUtil.executeQuery(ctx, sqlBuf.toString());
			while(rs.next()) {
				CKSettleBillQCEntryInfo entryInfo=new CKSettleBillQCEntryInfo();
				entryInfo.setBillNumber(rs.getString("fnumber"));
				RewardAndPunishItemInfo QCItem = IQCItem.getRewardAndPunishItemInfo(new ObjectUuidPK(rs.getString("CFQCItemID")));
				entryInfo.setQCItem(QCItem);
				entryInfo.setRandPType(PunishType.getEnum(rs.getString("CFRandPType")));
				entryInfo.setActualRate(rs.getBigDecimal("CFActualRate"));
				entryInfo.setPunishAmt(rs.getBigDecimal("CFPunishAmt"));
				entryInfo.setActualWgt(rs.getBigDecimal("CFActualWgt"));
				entryInfo.setPunishWgt(rs.getBigDecimal("CFPunishWgt"));
				punishAmt=punishAmt.add(UIRuleUtil.getBigDecimal(rs.getBigDecimal("CFPunishAmt")));
				info.getQCEntrys().add(entryInfo);
			}
			sqlBuf = new StringBuffer();
			sqlBuf.append(" /*dialect*/select  t2.CFQCItemID CFQCItemID, sum(nvl(t2.CFPunishAmt,0)) CFPunishAmt")
			.append(" from CT_FM_CSlaughterBill t1 ")
			.append(" inner join CT_FM_CSlaughterBillQCEntrys t2 on t1.fid=t2.fparentid  ")
			.append(" where t1.CFBillStatus =4  ")
			.append(" and t1.CFBatchContractID ='"+info.getBatchContract().getId().toString()+"' ")
			.append(" group by t2.CFQCItemID  ");
			rs=DbUtil.executeQuery(ctx, sqlBuf.toString());
			while(rs.next()) {
				RewardAndPunishItemInfo QCItem = IQCItem.getRewardAndPunishItemInfo(new ObjectUuidPK(rs.getString("CFQCItemID")));
				if(UIRuleUtil.getBigDecimal(rs.getBigDecimal("CFPunishAmt")).signum()!=0){
					qcDetail.append(QCItem.getName()+" "+UIRuleUtil.getBigDecimal(rs.getBigDecimal("CFPunishAmt"))+"��");
				}
			}		
			if (qcDetail.length() - 1>=0) 
				qcDetail.deleteCharAt(qcDetail.length()-1);
			String detail = qcDetail.toString();
			if(detail.length()>255){
				detail=qcDetail.toString().substring(0,255);
			}
			info.setQCKbDetail(detail);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return punishAmt.setScale(2,BigDecimal.ROUND_HALF_UP);
	}

	private BigDecimal setViewEntrys(Context ctx, CKSettleBillInfo info,BigDecimal viewAmt) {
		// TODO Auto-generated method stub
		info.getViewReqEntrys().clear();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		BatchContractBillInfo contInfo = info.getBatchContract();
		try {
			contInfo = BatchContractBillFactory.getLocalInstance(ctx).getBatchContractBillInfo(new ObjectUuidPK(contInfo.getId()));
		} catch (EASBizException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (BOSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//��ȡ��һ������
		String s1 = " /*dialect*/ select t2.billid billid from (  select t1.fid billid from T_FM_BatchContractBill t1" +
		" where  to_char(t1.FBizDate,'yyyy-MM-dd')   < '"+sdf.format(contInfo.getBizDate())+"'  " +
		"and FFarmID ='"+info.getFarm().getId()+"' and t1.fid != '"+info.getBatchContract().getId()+"'  order by t1.FBizDate desc  ) t2  where rownum = 1";
		IRowSet r1;
		String billid = null;
		try {
			r1 = DbUtil.executeQuery(ctx, s1);
			if(r1.next()){
				billid = UIRuleUtil.getString(r1.getString("billid"));
			}
		} catch (BOSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(UIRuleUtil.isNotNull(billid)){
			//�������κ�ͬ�ҵ���Ӧ�Ŀ������뵥
			String sqlBuf = " /*dialect*/ select t1.FBizDate bizDate,t1.fnumber fnumber,t1.CFBillStatus billStatus,t1.CFViewTypeID viewID,t1.CFAmount amount,t1.CFAuditAmt auditAmt" +
			" from CT_FM_CustomerViewReqBill t1 where t1.CFBatchContractID = '"+billid+"'";
			//		StringBuffer sqlBuf = new StringBuffer();
			//		sqlBuf.append(" /*dialect*/ select t1.bizDate,t1.fnumber,t1.billStatus,t1.viewID,t1.amount,t1.auditAmt from (")
			//		.append(" select FBizDate  bizDate,fnumber fnumber,CFBillStatus billStatus, CFViewTypeID viewID,CFAmount amount,")
			//		.append(" nvl(CFAuditAmt,0) auditAmt from CT_FM_CustomerViewReqBill where  to_char(CFInDate,'yyyy-MM-dd')   < '"+sdf.format(contInfo.getBizDate())+"' and CFFarmID ='")
			//		.append(info.getFarm().getId())
			//		.append("' and CFBatchContractID != '")
			//		.append(info.getBatchContract().getId())
			//		.append("' order by CFInDate desc ) t1  where rownum = 1");
			try {
				rs=DbUtil.executeQuery(ctx, sqlBuf.toString());
				if(rs.size()>0) {
					while(rs.next()) {
						CKSettleBillViewReqEntryInfo entryInfo=new CKSettleBillViewReqEntryInfo();
						entryInfo.setBizDate(rs.getDate("bizDate"));
						entryInfo.setBillNumber(rs.getString("fnumber"));
						entryInfo.setBillStatus(BillBaseStatusEnum.getEnum(rs.getInt("billStatus")));
						iViewType=CustomerViewTypeFactory.getLocalInstance(ctx);
						entryInfo.setViewType(iViewType.getCustomerViewTypeInfo(new ObjectUuidPK(rs.getString("viewID"))));
						entryInfo.setAmount(rs.getBigDecimal("amount"));
						entryInfo.setAuditAmt(rs.getBigDecimal("auditAmt"));
						if(rs.getString("billStatus").equals("4")||rs.getString("billStatus").equals("7") ){
							viewAmt=viewAmt.add(UIRuleUtil.getBigDecimal(rs.getBigDecimal("auditAmt")));
						}
						info.getViewReqEntrys().add(entryInfo);
					}
				}	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return viewAmt.setScale(2,BigDecimal.ROUND_HALF_UP);
	}

	private BigDecimal setTempPolicyEntrys(Context ctx, CKSettleBillInfo info,BigDecimal chickenAveWgt,int inQty,BigDecimal inWeight,BigDecimal outSalePrice,BigDecimal tempAmt) {
		// TODO Auto-generated method stub
		info.getTempPolicyEntrys().clear();
		//		HashSet<TempPolicyInfo> tempPolicys = StockingComm.getTempPolicy(ctx, info, chickenAveWgt);
		//		BigDecimal batchQty = UIRuleUtil.getBigDecimal(info.getBatchQty());
		try {

			String s0 = "/*dialect*/ select to_char(t1.FBizDate,'yyyy-MM-dd') maxBizdate ,sum(t2.FAllReceiveQty) allReceiveQty from T_FM_BreedSeedReceiveBill  t1" +
			" inner join T_FM_BreedSeedReceiveBillEntry t2 on t2.fparentid = t1.fid where FBillStatus in (4,7)  " +
			" and FBatchContractID ='"+info.getBatchContract().getId().toString()+"'  group by to_char(t1.FBizDate,'yyyy-MM-dd')";
			IRowSet r0 = DbUtil.executeQuery(ctx, s0);
			Date maxBreedbizdate = new Date();
			BigDecimal batchQty = BigDecimal.ZERO;
			while(r0.next()){
				maxBreedbizdate = UIRuleUtil.getDateValue(r0.getDate("maxBizdate"));
				batchQty = UIRuleUtil.getBigDecimal(r0.getBigDecimal("allReceiveQty"));
				if(maxBreedbizdate != null){

					//���㵥����Ʒ��  ��ʼ���ڣ��������ڴ���ʱ���ߵ�������ϸҳǩȡֵ
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
					String s1 = "/*dialect*/ select t2.CFPrice CFPrice,t1.fid  policyid,t2.CFMatSelect CFMatSelect," +
					"t2.CFUnit  CFUnit,t2.CFPolicyDatR CFPolicyDatR," +
					" t2.CFBeginDate CFBeginDate,t2.CFEndDate  CFEndDate from  CT_FM_TempPolicy t1  " +
					" inner join  CT_FM_TempPolicyPolicyEntry t2 on t1.fid=t2.fparentid where t1.CFBaseStatus in (2,3)" +
					" and t1.CFFICompanyID='"+info.getFICompany().getId().toString()+"' and t1.CFBreedDataID='"+info.getBreedData().getId().toString()+"' " +
					" and to_char(t2.CFBeginDate,'yyyy-mm-dd')<='"+sdf.format(maxBreedbizdate)+"' " + //info.getInDate()
					" and to_char(t2.CFEndDate,'yyyy-mm-dd')>='"+sdf.format(maxBreedbizdate)+"'";
					IRowSet rs;
					rs=SQLExecutorFactory.getLocalInstance(ctx,s1.toString()).executeSQL();
					String policyid = null;
					String CFMatSelect = null;
					String CFUnit = null;
					String CFPolicyDatR = null;
					Date CFBeginDate = null;
					Date CFEndDate = null;
					BigDecimal CFPrice = BigDecimal.ZERO;
					while(rs.next()){
						CKSettleBillTempPolicyEntryInfo entryInfo = new CKSettleBillTempPolicyEntryInfo();
						policyid = UIRuleUtil.getString(rs.getString("policyid"));
						TempPolicyInfo policyInfo = TempPolicyFactory.getLocalInstance(ctx).getTempPolicyInfo(new ObjectUuidPK(policyid));
						entryInfo.setTempPolicy(policyInfo);
						//����ѡ��
						CFMatSelect = UIRuleUtil.getString(rs.getString("CFMatSelect"));
						if("0".equalsIgnoreCase(CFMatSelect)){//����
							entryInfo.setMaterialType(MaterialType.seedCK);
						}else if("1".equalsIgnoreCase(CFMatSelect)){//ë��
							entryInfo.setMaterialType(MaterialType.recCK);
						}else if("2".equalsIgnoreCase(CFMatSelect)){//ë��
							entryInfo.setMaterialType(MaterialType.marketPrice);
						}
						//������λ
						CFUnit = UIRuleUtil.getString(rs.getString("CFUnit"));
						if("0".equalsIgnoreCase(CFUnit)){//ֻ
							entryInfo.setCalUnit(CalUnit.qty);
						}else if("1".equalsIgnoreCase(CFUnit)){//kg
							entryInfo.setCalUnit(CalUnit.kg);
						}
						//�������ڹ���
						CFPolicyDatR = UIRuleUtil.getString(rs.getString("CFPolicyDatR"));
						if("0".equalsIgnoreCase(CFPolicyDatR)){//����
							entryInfo.setDateRelate(DateRelate.inDate);
						}else if("1".equalsIgnoreCase(CFPolicyDatR)){//����
							entryInfo.setDateRelate(DateRelate.recDate);
						}

						//�۲�����
						CFPrice = UIRuleUtil.getBigDecimal(rs.getBigDecimal("CFPrice"));
						entryInfo.setKbPrice(CFPrice);
						//��ʼ����
						CFBeginDate = UIRuleUtil.getDateValue(rs.getDate("CFBeginDate"));
						entryInfo.setBeginDate(CFBeginDate);//��ʼ����
						//��������
						CFEndDate = UIRuleUtil.getDateValue(rs.getDate("CFEndDate"));
						entryInfo.setEndDate(CFEndDate);//��������

						BigDecimal kbAmount=BigDecimal.ZERO;
						if("0".equalsIgnoreCase(CFMatSelect)){
							kbAmount=batchQty.multiply(CFPrice).setScale(2,RoundingMode.HALF_UP);
						}else if("1".equalsIgnoreCase(CFMatSelect)){
							if("0".equalsIgnoreCase(CFUnit)){
								kbAmount=UIRuleUtil.getBigDecimal(inQty).multiply(CFPrice).setScale(2,RoundingMode.HALF_UP);
							}else if("1".equalsIgnoreCase(CFUnit)){
								kbAmount=inWeight.multiply(CFPrice).setScale(2,RoundingMode.HALF_UP);
							}
						}else if("2".equalsIgnoreCase(CFMatSelect)){
							BigDecimal kbPrice = StockingComm.calPriceByTempPolicy(ctx, policyInfo, outSalePrice);
							entryInfo.setKbPrice(kbPrice);
							if("0".equalsIgnoreCase(CFUnit)){
								kbAmount=UIRuleUtil.getBigDecimal(inQty).multiply(kbPrice).setScale(2,RoundingMode.HALF_UP);
							}else if("1".equalsIgnoreCase(CFUnit)){
								kbAmount=inWeight.multiply(kbPrice).setScale(2,RoundingMode.HALF_UP);
							}
						}
						entryInfo.setKbAmount(kbAmount);//�۲����
						tempAmt=tempAmt.add(kbAmount);
						info.getTempPolicyEntrys().add(entryInfo);
					}

				}}



		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		//		for(TempPolicyInfo policy:tempPolicys){
		//			CKSettleBillTempPolicyEntryInfo entryInfo = new CKSettleBillTempPolicyEntryInfo();
		//			entryInfo.setTempPolicy(policy);//��ʱ����
		//			entryInfo.setMaterialType(policy.getMaterialType());//����ѡ��
		//			entryInfo.setCalUnit(policy.getCalUnit());//������λ
		//			entryInfo.setKbPrice(policy.getKbPrice());//�۲�����
		//			entryInfo.setDateRelate(policy.getDateRelate());//�������ڹ���
		//			entryInfo.setBeginDate(policy.getBeginDate());//��ʼ����
		//			entryInfo.setEndDate(policy.getEndDate());//��������
		//			BigDecimal kbAmount=BigDecimal.ZERO;
		//			if(policy.getMaterialType()==MaterialType.seedCK){
		//				kbAmount=batchQty.multiply(policy.getKbPrice()).setScale(2,RoundingMode.HALF_UP);
		//			}else if(policy.getMaterialType()==MaterialType.recCK){
		//				if(policy.getCalUnit()==CalUnit.qty){
		//					kbAmount=UIRuleUtil.getBigDecimal(inQty).multiply(policy.getKbPrice()).setScale(2,RoundingMode.HALF_UP);
		//				}else if(policy.getCalUnit()==CalUnit.kg){
		//					kbAmount=inWeight.multiply(policy.getKbPrice()).setScale(2,RoundingMode.HALF_UP);
		//				}
		//			}else if(policy.getMaterialType()==MaterialType.marketPrice){
		//				BigDecimal kbPrice = StockingComm.calPriceByTempPolicy(ctx, policy, outSalePrice);
		//				entryInfo.setKbPrice(kbPrice);
		//				if(policy.getCalUnit()==CalUnit.qty){
		//					kbAmount=UIRuleUtil.getBigDecimal(inQty).multiply(kbPrice).setScale(2,RoundingMode.HALF_UP);
		//				}else if(policy.getCalUnit()==CalUnit.kg){
		//					kbAmount=inWeight.multiply(kbPrice).setScale(2,RoundingMode.HALF_UP);
		//				}
		//			}
		//			entryInfo.setKbAmount(kbAmount);//�۲����
		//			tempAmt=tempAmt.add(kbAmount);
		//			info.getTempPolicyEntrys().add(entryInfo);
		//		}
		return tempAmt;
	}	

	//��д��ǰ������
	private void updatePreHouseBill(Context ctx, CKSettleBillInfo info,Boolean isSettled) {
		// TODO Auto-generated method stub
		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append(" /*dialect*/update CT_FM_PreHouseWgtBill ")
		.append(" set CFIsSettled=").append(isSettled?1:0)
		.append(" where  CFBatchContractID ='"+info.getBatchContract().getId().toString()+"' ");
		try {
			DbUtil.execute(ctx, sqlBuf.toString());
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//��д���κ�ͬ/������ͬ/��ֳ��/��ֳ��
	private void updateBatchData(Context ctx, CKSettleBillInfo info,Boolean isSettled) {
		// TODO Auto-generated method stub
		//������ͬ
		if(info.getBatchContract().getConFeedContract()!=null||info.getConFeedContract()!=null){
			ConFeedContractInfo conFeedContract=null;
			if(info.getBatchContract().getConFeedContract()!=null){
				conFeedContract = info.getBatchContract().getConFeedContract();
			}else{
				conFeedContract=info.getConFeedContract();
			}
			BigDecimal conFeedSubsidies = UIRuleUtil.getBigDecimal(info.getConFeedSubsidies());
			StringBuffer sql=new StringBuffer();
			if(isSettled){
				sql.append(" /*dialect*/update CT_FM_ConFeedContract ")
				.append(" set CFCurSettledNum=nvl(CFCurSettledNum,0)+1,")
				.append(" CFCumulativeSub=nvl(CFCumulativeSub,0)+").append(conFeedSubsidies)
				.append(" where fid ='"+conFeedContract.getId().toString()+"' ");
			}else{
				sql.append(" /*dialect*/update CT_FM_ConFeedContract ")
				.append(" set CFCurSettledNum=nvl(CFCurSettledNum,0)-1,")
				.append(" CFCumulativeSub=nvl(CFCumulativeSub,0)-").append(conFeedSubsidies)
				.append(" where fid ='"+conFeedContract.getId().toString()+"' ");
			}	
			try {
				DbUtil.execute(ctx, sql.toString());
			} catch (BOSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		try {
			//���κ�ͬ
			StringBuffer sqlBuf = new StringBuffer();
			sqlBuf.append(" /*dialect*/update T_FM_BatchContractBill ")
			.append(" set CFIsRecSettled=").append(isSettled?1:0)
			.append(" where fid ='"+info.getBatchContract().getId().toString()+"' ");
			//��ֳ��
			StringBuffer sqlFarm=new StringBuffer();
			if(isSettled){
				sqlFarm.append(" /*dialect*/update CT_FM_Farm ")
				.append(" set CFSettledBatchNum=nvl(CFSettledBatchNum,0)+1,")
				.append(" CFTotalSettleBatchNum=nvl(CFInitSettleBatchNum,0)+nvl(CFSettledBatchNum,0)+1")
				.append(" where fid ='"+info.getFarm().getId().toString()+"' ");
			}else{
				sqlFarm.append(" /*dialect*/update CT_FM_Farm ")
				.append(" set CFSettledBatchNum=nvl(CFSettledBatchNum,0)-1,")
				.append(" CFTotalSettleBatchNum=nvl(CFInitSettleBatchNum,0)+nvl(CFSettledBatchNum,0)-1")
				.append(" where fid ='"+info.getFarm().getId().toString()+"' ");
			}

			DbUtil.execute(ctx, sqlBuf.toString());
			DbUtil.execute(ctx, sqlFarm.toString());

		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	private void checkIsGuanZhang(Context ctx,CKSettleBillInfo info) throws EASBizException {
		// TODO Auto-generated method stub
		boolean isGuanZhang=false;
		String companyID = info.getFICompany().getId().toString();
		PeriodInfo period=DateUtilsComm.getPeriodInfoByDate(ctx,info.getBizDate());
		String periodID=period==null?"":period.getId().toString();
		try {
			isGuanZhang= CKCloseAccountFacadeFactory.getLocalInstance(ctx).checkIsClosed(companyID, periodID);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(isGuanZhang){
			throw new EASBizException(new NumericExceptionSubItem("001","ҵ�����ڶ�Ӧ�ڼ��ڸù�˾��ִ���˹��˲���,��ǰ����ʧ��!"));
		}
	}

	/**
	 * �������״̬�ı�֤�������
	 */
	private void createToDestBill(Context ctx, CKSettleBillInfo info) throws BOSException, EASBizException {
		String destBillType=null;
		ICodingRuleManager iCodingRuleManager = CodingRuleManagerFactory.getLocalInstance(ctx);
		BotpCommUtils btpIS = BotpCommUtils.getInstance(null);
		OrgUnitInfo orgInfo=info.getFICompany();
		destBillType=new MarginUnlockBillInfo().getBOSType().toString();
		BOTMappingCollection btpCols;
		btpCols = btpIS.getAllCanUsedBotps(ctx, orgInfo, info.getBOSType().toString(),destBillType,new String[]{info.getString("id")},new String[]{}, new ArrayList<String>(), null);
		for(int index=0;index<btpCols.size();index++) {
			MarginUnlockBillInfo marginUnlockBillInfo  = (MarginUnlockBillInfo)btpIS.createToOrderBill(ctx, info, destBillType, btpCols.get(index));
			String orgUnitID=ContextUtil.getCurrentOrgUnit(ctx).getId().toString();
			if(iCodingRuleManager.isExist(info, orgUnitID)){
				if(iCodingRuleManager.isUseIntermitNumber(info, orgUnitID)){
					//�����������Ϻ� --> ��ȡ�Ϻű���
					marginUnlockBillInfo.setNumber(iCodingRuleManager.getNonbreakNumber(info,orgUnitID));
				}else{
					marginUnlockBillInfo.setNumber(iCodingRuleManager.getNumber(info,orgUnitID));
				}
			}
			marginUnlockBillInfo.setIsFromSettleBill(true);
			marginUnlockBillInfo.setBillStatus(BillBaseStatusEnum.SUBMITED);
			MarginUnlockBillFactory.getLocalInstance(ctx).update(new ObjectUuidPK(marginUnlockBillInfo.getId()), marginUnlockBillInfo);
			MarginUnlockBillFactory.getLocalInstance(ctx).audit(marginUnlockBillInfo);
		}
	}

	private void beforeUnAudit(Context ctx, CKSettleBillInfo info) throws EASBizException {
		// TODO Auto-generated method stub
		Map<String, HashSet<String>> result1;
		try {
			IMarginUnlockBill iMarginUnlockBill = MarginUnlockBillFactory.getLocalInstance(ctx);
			result1 = BotpAppCommon.getBillIDsByRelation(ctx, info.getBOSType().toString(), info.getId().toString(), new MarginUnlockBillInfo().getBOSType().toString(), null);
			HashSet<String> destBillIDs=result1.get("destBillIDs");
			if(destBillIDs.size()>0){
				for(String destBillID :destBillIDs){
					Map<String, HashSet<String>> result2=BotpAppCommon.getBillIDsByRelation(ctx,new MarginUnlockBillInfo().getBOSType().toString(), destBillID, null, null);
					HashSet<String> destBillIDs2=result2.get("destBillIDs");
					if(destBillIDs2.size()<0){
						throw new EASBizException(new NumericExceptionSubItem("001","���ݵ����ε��������������ε���,��ֹ�����"));
					}else{
						//ɾ�����ε���(��֤�������)
						MarginUnlockBillInfo marginUnlockBillInfo=iMarginUnlockBill.getMarginUnlockBillInfo(new ObjectUuidPK(destBillID));
						if(marginUnlockBillInfo.getBillStatus().equals(BillBaseStatusEnum.AUDITED)){
							marginUnlockBillInfo.setIsFromSettleBill(false);
							iMarginUnlockBill.update(new ObjectUuidPK(marginUnlockBillInfo.getId()), marginUnlockBillInfo);
							iMarginUnlockBill.unAudit(marginUnlockBillInfo);
						}
						iMarginUnlockBill.delete(new ObjectUuidPK(destBillID));
					}
				}
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void checkIsHasUnAuditBill(Context ctx, CKSettleBillInfo info) throws EASBizException {
		// TODO Auto-generated method stub
		try {		
			StringBuffer s1 = new StringBuffer();
			s1.append("/*dialect*/ select t1.fnumber billid from T_FM_BreedSeedReceiveBill t1")
			.append(" where t1.FBillStatus in (1,2) and  t1.FBatchContractID = '").append(info.getBatchContract().getId()).append("'").append("\n");
			IRowSet r1 = DbUtil.executeQuery(ctx, s1.toString());
			if(r1.next()){
				String billid = UIRuleUtil.getString(r1.getString("billid"));
				throw new EASBizException(new NumericExceptionSubItem("001","�������õ���"+billid+"  ���ڱ�������ύ�ĵ��ݣ�����ʧ�ܣ�"));
			}
			StringBuffer s2 = new StringBuffer();
			s2.append(" /*dialect*/  select t1.fnumber billid from T_FM_FodderReception t1").append("\n")
			.append(" where t1.FBillStatus in (1,2) and  t1.CFBatchContractID = '").append(info.getBatchContract().getId()).append("'").append("\n");
			IRowSet r2 = DbUtil.executeQuery(ctx, s2.toString());
			if(r2.next()){
				String billid = UIRuleUtil.getString(r2.getString("billid"));
				throw new EASBizException(new NumericExceptionSubItem("001","�������õ���"+billid+"  ���ڱ�������ύ�ĵ��ݣ�����ʧ�ܣ�"));
			}

			StringBuffer s3 = new StringBuffer();
			s3.append(" /*dialect*/  select t1.fnumber billid from T_FM_DrugReceiveBill t1").append("\n")
			.append(" where t1.FBillStatus in (1,2) and  t1.FBatchContractID = '").append(info.getBatchContract().getId()).append("'").append("\n");
			IRowSet r3 = DbUtil.executeQuery(ctx, s3.toString());
			if(r3.next()){
				String billid = UIRuleUtil.getString(r3.getString("billid"));
				throw new EASBizException(new NumericExceptionSubItem("001","ҩƷ���õ���"+billid+"  ���ڱ�������ύ�ĵ��ݣ�����ʧ�ܣ�"));
			}
			StringBuffer s4 = new StringBuffer();
			s4.append(" /*dialect*/  select t1.fnumber billid from CT_FM_CTransDrugBill t1").append("\n")
			.append(" where t1.FBillStatus in (1,2) and  (t1.CFTargetBatchContr = '").append(info.getBatchContract().getId()).append("' or t1.CFBatchContractID='").append(info.getBatchContract().getId()).append("')").append("\n");
			IRowSet r4 = DbUtil.executeQuery(ctx, s4.toString());
			if(r4.next()){
				String billid = UIRuleUtil.getString(r4.getString("billid"));
				throw new EASBizException(new NumericExceptionSubItem("001","ҩƷ��������"+billid+"  ���ڱ�������ύ�ĵ��ݣ�����ʧ�ܣ�"));
			}
			StringBuffer s5 = new StringBuffer();
			s5.append(" /*dialect*/  select t1.fnumber billid from CT_FM_CTransFodderBill t1").append("\n")
			.append(" where t1.FBillStatus in (1,2) and  (t1.CFTargetBatchContr = '").append(info.getBatchContract().getId()).append("' or t1.CFBatchContractID = '").append(info.getBatchContract().getId()).append("')").append("\n");
			IRowSet r5 = DbUtil.executeQuery(ctx, s5.toString());
			if(r5.next()){
				String billid = UIRuleUtil.getString(r5.getString("billid"));
				throw new EASBizException(new NumericExceptionSubItem("001","���ϵ�������"+billid+"  ���ڱ�������ύ�ĵ��ݣ�����ʧ�ܣ�"));
			}
			StringBuffer s6 = new StringBuffer();
			s6.append(" /*dialect*/  select t1.fnumber billid from CT_FM_CSlaughterBill t1").append("\n")
			.append(" where t1.CFBillStatus in (1,2) and  t1.CFBatchContractID = '").append(info.getBatchContract().getId()).append("'").append("\n");
			IRowSet r6 = DbUtil.executeQuery(ctx, s6.toString());	
			if(r6.next()){
				String billid = UIRuleUtil.getString(r6.getString("billid"));
				throw new EASBizException(new NumericExceptionSubItem("001","���׵���"+billid+"  ���ڱ�������ύ�ĵ��ݣ�����ʧ�ܣ�"));
			}
			StringBuffer s7 = new StringBuffer();
			s7.append(" /*dialect*/  select t1.fnumber billid from CT_WHB_InStorageBill t1").append("\n")
			.append(" where t1.CFBillStatus in (0) and  t1.CFBatchContractID = '").append(info.getBatchContract().getId()).append("'").append("\n");
			IRowSet r7 = DbUtil.executeQuery(ctx, s7.toString());
			if(r7.next()){
				String billid = UIRuleUtil.getString(r7.getString("billid"));
				throw new EASBizException(new NumericExceptionSubItem("001","ë����������"+billid+"  ���ڱ�������ύ�ĵ��ݣ�����ʧ�ܣ�"));
			}

			StringBuffer s8 = new StringBuffer();
			s8.append(" /*dialect*/  select t1.fnumber billid from T_FM_BatchContractBill t1").append("\n")
			.append(" where t1.FBillStatus in (1,2) and  t1.fid = '").append(info.getBatchContract().getId()).append("'").append("\n");
			IRowSet r8 = DbUtil.executeQuery(ctx, s8.toString());
			if(r8.next()){
				String billid = UIRuleUtil.getString(r8.getString("billid"));
				throw new EASBizException(new NumericExceptionSubItem("001","���κ�ͬ��"+billid+"  ���ڱ�������ύ�ĵ��ݣ�����ʧ�ܣ�"));
			}

			StringBuffer s9 = new StringBuffer();
			s9.append(" /*dialect*/  select t1.fnumber billid from CT_FM_MaiginBill t1").append("\n")
			.append(" where t1.CFBillStatus in (1,2) and  t1.CFFarmID = '").append(info.getFarm().getId()).append("'").append("\n");
			IRowSet r9 = DbUtil.executeQuery(ctx, s9.toString());
			if(r9.next()){
				String billid = UIRuleUtil.getString(r9.getString("billid"));
				throw new EASBizException(new NumericExceptionSubItem("001","��֤�����˵���"+billid+"  ���ڱ�������ύ�ĵ��ݣ�����ʧ�ܣ�"));
			}

			StringBuffer s10 = new StringBuffer();
			s10.append(" /*dialect*/  select t1.fnumber billid from CT_FM_FarmerBorrowNew t1").append("\n")
			.append(" where t1.CFBaseStatus in (1) and  t1.CFFarmID = '").append(info.getFarm().getId()).append("'").append("\n");
			IRowSet r10 = DbUtil.executeQuery(ctx, s10.toString());
			if(r10.next()){
				String billid = UIRuleUtil.getString(r10.getString("billid"));
				throw new EASBizException(new NumericExceptionSubItem("001","��ֳ������"+billid+"  ���ڱ�������ύ�ĵ��ݣ�����ʧ�ܣ�"));
			}

			StringBuffer s11 = new StringBuffer();
			s11.append(" /*dialect*/  select t1.fnumber billid from CT_FM_CustomerViewReqBill t1").append("\n")
			.append("where t1.CFBillStatus in (1,2) and  t1.CFBatchContractID = '").append(info.getBatchContract().getId()).append("'");
			IRowSet r11 = DbUtil.executeQuery(ctx, s11.toString());
			if(r11.next()){
				String billid = UIRuleUtil.getString(r11.getString("billid"));
				throw new EASBizException(new NumericExceptionSubItem("001","�������뵥��"+billid+"  ���ڱ�������ύ�ĵ��ݣ�����ʧ�ܣ�"));
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}