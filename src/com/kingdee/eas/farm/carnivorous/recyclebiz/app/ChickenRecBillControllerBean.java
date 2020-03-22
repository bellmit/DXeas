package com.kingdee.eas.farm.carnivorous.recyclebiz.app;

import org.apache.log4j.Logger;

import java_cup.internal_error;

import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;

import com.kingdee.bos.*;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillCollection;
import com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.ICSlaughterBill;
import com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBill;
import com.kingdee.bos.metadata.bot.BOTMappingCollection;
import com.kingdee.bos.metadata.bot.BOTMappingFactory;
import com.kingdee.bos.metadata.bot.BOTMappingInfo;
import com.kingdee.bos.metadata.bot.BOTRelationCollection;
import com.kingdee.bos.metadata.bot.IBOTMapping;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillBaseInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillInfo;
import com.kingdee.eas.farm.stocking.common.BotpCommUtils;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.base.botp.BOTPException;
import com.kingdee.eas.base.btp.BTPManagerFactory;
import com.kingdee.eas.base.btp.BTPTransformResult;
import com.kingdee.eas.base.btp.IBTPManager;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ChickenRecBillControllerBean extends AbstractChickenRecBillControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.carnivorous.recyclebiz.app.ChickenRecBillControllerBean");

	protected void _audit(Context ctx, IObjectValue model)throws BOSException, EASBizException
	{
		ChickenRecBillInfo info = (ChickenRecBillInfo) model;

		if(info.getBillStatus()==null||!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED))
			throw new EASBizException(new NumericExceptionSubItem("001","ֻ���ύ�ĵ��Ӳſ���ִ�д˲���"));

		info.setBillStatus(BillBaseStatusEnum.AUDITED);
		info.setAuditTime(new java.util.Date());
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));

		//�������Զ����ɽ��㵥
		createSettle(ctx,info);
		
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}

/**
 * �������Զ����ɽ��㵥
 * @param ctx
 * @param info
 */
	private void createSettle(Context ctx, ChickenRecBillInfo info) {
		// TODO Auto-generated method stub
		try {
			BatchContractBillInfo contractInfo = info.getBatchContract();

			String s1 = "/*dialect*/ select t1.fid setBillid from CT_FM_CKSettleBill t1 where t1.CFBatchContractID = '"+contractInfo.getId()+"'";
			IRowSet r1 = DbUtil.executeQuery(ctx, s1.toString());
			String setBillid = null;
			if(r1.next()){
				setBillid = r1.getString("setBillid");
			}else{//��������κ�ͬ�����ڽ��㵥�������ʱ�Զ����ɽ��㵥
				CoreBillBaseCollection coreBillBaseColl = new CoreBillBaseCollection();

				//ת������ȡ   �ɹ���ⵥ  -- ���۳��ⵥ
				String botpName = "mjhs-mjjsd";

				//���׵�
				IChickenRecBill iSaleOrder = ChickenRecBillFactory.getLocalInstance(ctx);
				IBOTMapping iMapping    = BOTMappingFactory.getLocalInstance(ctx);

				//��ȡbtp�ı��ؽӿ�
				IBTPManager iBTPManager = BTPManagerFactory.getLocalInstance(ctx);
				//��ȡ�ɹ���ⵥ��������Ϣ----Դ����
				SelectorItemCollection slor = new SelectorItemCollection();
				slor.add("*");
				slor.add("SaleOrgUnit.*");
				ChickenRecBillInfo saleOrderInfo = iSaleOrder.getChickenRecBillInfo(new ObjectUuidPK(info.getId()),slor );
				coreBillBaseColl.add(saleOrderInfo);
				if(coreBillBaseColl.size() > 0){
					//���� ����ת������  ��ȡ   ����ת�������ʵ��--��������õĵ���ת������
					BOTMappingInfo botMappingInfo = iMapping.getBOTMappingInfo("where name='" + botpName + "'");
					if(botMappingInfo.getExtRule().isIsEffected()){
						//transformResult Ϊת���ɹ����Զ����ɵ�Ŀ�굥�ݣ�coreBillBaseColl--Դ���ݣ�botMappingInfo--����ת������
						BTPTransformResult transformResult = iBTPManager.transform(coreBillBaseColl, botMappingInfo);
						//��ȡת��֮���Ŀ�굥��
						IObjectCollection bills = transformResult.getBills();
						BOTRelationCollection botRelationCols = transformResult.getBOTRelationCollection();
						for (int i = 0; i < bills.size(); i++) {
							CoreBillBaseInfo destBillInfo = (CoreBillBaseInfo) bills.getObject(i);
							iBTPManager.submitRelations(destBillInfo, botRelationCols);
						}
					}

				}
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


	protected void _unAudit(Context ctx, IObjectValue model)throws BOSException, EASBizException
	{
		ChickenRecBillInfo info = (ChickenRecBillInfo) model;

		if(DbUtil.executeQuery(ctx, "select * from T_BOT_Relation where FSrcObjectID='"+info.getString("id")+"'").size()>0)
			throw new EASBizException(new NumericExceptionSubItem("001","�����ε��ݵĵ��ݽ�ֹ�����"));

		if(info.getBillStatus()==null||!info.getBillStatus().equals(BillBaseStatusEnum.AUDITED))
			throw new EASBizException(new NumericExceptionSubItem("001","ֻ����˵ĵ��Ӳſ���ִ�д˲���"));

		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		info.setAuditTime(null);
		info.setAuditor(null);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}


	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		ChickenRecBillInfo info = (ChickenRecBillInfo) model;

		if(info.getBillStatus()!=null&&info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)&&!info.getBillStatus().equals(BillBaseStatusEnum.ADD))


			throw new EASBizException(new NumericExceptionSubItem("001","ֻ���������߱���ĵ��Ӳſ���ִ�д˲���"));

		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)) {
			info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		}
		return super._save(ctx, info);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		ChickenRecBillInfo info = (ChickenRecBillInfo) model;

		if(info.getBillStatus()!=null&&info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)&&!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)&&!info.getBillStatus().equals(BillBaseStatusEnum.ADD))

			throw new EASBizException(new NumericExceptionSubItem("001","ֻ��������������ύ�ĵ��Ӳſ���ִ�д˲���"));

		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)||info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)) {
			info.setBillStatus(BillBaseStatusEnum.SUBMITED); 
		}
		_audit(ctx, info);
		return super._submit(ctx, info);
	}
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		ChickenRecBillInfo info = ChickenRecBillFactory.getLocalInstance(ctx).getChickenRecBillInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","�����Ѿ���ˣ���ֹɾ����"));
		}
		super._delete(ctx, pk);
	}

	@Override
	//�������������������ɳ���
	protected void _manageCarSeq(Context ctx, IObjectValue model, Map map)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		Boolean isHasCCarsendBill=false;
		int seq= map.get("seq")==null?0:(Integer)map.get("seq");
		int qty= map.get("qty")==null?0:(Integer)map.get("qty");
		ChickenRecBillInfo cInfo = (ChickenRecBillInfo) model;
		String destBillType=null;
		ICodingRuleManager iCodingRuleManager = CodingRuleManagerFactory.getLocalInstance(ctx);
		BotpCommUtils btpIS = BotpCommUtils.getInstance(null);
		OrgUnitInfo orgInfo=cInfo.getFICompany();
		destBillType=new CCarSendBillInfo().getBOSType().toString();
		BOTMappingCollection btpCols;
		btpCols = btpIS.getAllCanUsedBotps(ctx, orgInfo, cInfo.getBOSType().toString(),destBillType,new String[]{cInfo.getString("id")},new String[]{}, new ArrayList<String>(), null);
		if(btpCols.size()!=1){
			throw new EASBizException(new NumericExceptionSubItem("001","���ն��������ɳ�����ת������δ����,��ǰ���ݲ�����ת������Ĺ�������,�������˶������������ת������,����ϵ�����Ա�˶Թ���."));
		}
		CCarSendBillInfo ccarInfo  = (CCarSendBillInfo)btpIS.createToOrderBill(ctx, cInfo, destBillType, btpCols.get(0));
		try {
			String orgUnitID=ContextUtil.getCurrentOrgUnit(ctx).getId().toString();
			if(iCodingRuleManager.isExist(ccarInfo, orgUnitID)){
				if(iCodingRuleManager.isUseIntermitNumber(ccarInfo, orgUnitID)){
					//�����������Ϻ� --> ��ȡ�Ϻű���
					ccarInfo.setNumber(iCodingRuleManager.getNonbreakNumber(ccarInfo,orgUnitID));
				}else{
					ccarInfo.setNumber(iCodingRuleManager.getNumber(ccarInfo,orgUnitID));
				}
				ccarInfo.setDeliverQty(qty);
				ccarInfo.setSeq(seq);
				CCarSendBillFactory.getLocalInstance(ctx).save(ccarInfo);
//				cInfo.setIsHasPaiChe(true);
				ChickenRecBillFactory.getLocalInstance(ctx).update(new ObjectUuidPK(cInfo.getId()), cInfo);
				isHasCCarsendBill=true;
			}
		} catch (BOTPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isHasCCarsendBill=false;
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isHasCCarsendBill=false;
		} 
	}
}