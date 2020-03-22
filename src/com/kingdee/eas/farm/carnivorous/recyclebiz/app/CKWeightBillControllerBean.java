package com.kingdee.eas.farm.carnivorous.recyclebiz.app;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Date;

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
import java.math.BigDecimal;

import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKWeightBillEntryInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKWeightBillFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKWeightBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKWeightBillCollection;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CSlaughterBillInfo;
import com.kingdee.eas.farm.food.CCReceivingBillFactory;
import com.kingdee.eas.farm.food.ICCReceivingBill;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.BillBaseException;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.scm.sd.sale.SaleOrderFactory;
import com.kingdee.eas.scm.sd.sale.SaleOrderInfo;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;

import com.kingdee.eas.weighbridge.WeighBaseStatus;
import com.kingdee.eas.weighbridge.WeighBizType;
import com.kingdee.eas.weighbridge.comm.WeighbridgeCommUtils;
import com.kingdee.eas.wlhlcomm.BotpAppCommon;
import com.kingdee.eas.base.btp.BTPManagerFactory;
import com.kingdee.eas.base.btp.BTPTransformResult;
import com.kingdee.eas.base.btp.IBTPManager;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CKWeightBillControllerBean extends AbstractCKWeightBillControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.carnivorous.recyclebiz.app.CKWeightBillControllerBean");

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		CKWeightBillInfo info=(CKWeightBillInfo)model;
		//禁止重复审核 
		if(info.getBillStatus().equals(WeighBaseStatus.audit)) {
			return;
		}
		//非完成状态不允许审核
		if(!info.getBillStatus().equals(WeighBaseStatus.finish)&&!info.getBillStatus().equals(WeighBaseStatus.qcFinish)) {
			return;
		}
		info.setBillStatus(WeighBaseStatus.audit);
		info.setAuditTime(new java.util.Date());
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
		try {
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			logger.error(e);
			throw new BOSException(e);
		}
	}

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		//info.
		CKWeightBillInfo info=(CKWeightBillInfo)model;
		IObjectPK pk =  super._save(ctx, model);
		return pk;
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		CKWeightBillInfo info=(CKWeightBillInfo)model;
		//非完成、质检完成修改状态为完成
		if(!info.getBillStatus().equals(WeighBaseStatus.finish)&&!info.getBillStatus().equals(WeighBaseStatus.qcFinish)) {
			info.setBillStatus(WeighBaseStatus.finish);
		}	
		IObjectPK pk = super._submit(ctx, info);
		reWriteWeighBill(ctx, info,true);
		return pk;
	}

	//反写过磅单据
	private void reWriteWeighBill(Context ctx,CKWeightBillInfo info,Boolean isFinish) {
		try {
			String srcBillID;
			for(int i=0;i<info.getEntrys().size();i++) {
				for(int j=0;j<info.getEntrys().get(i).getDetail().size();j++) {
					srcBillID=info.getEntrys().get(i).getDetail().get(j).getSourceBillID();
					//添加关联(取消)
					//if(isFinish){
					//	if(info.getBizType()==WeighBizType.RecCK){
					//  	BotpAppCommon.addRelations(ctx, new CSlaughterBillInfo().getBOSType().toString(), srcBillID,this.getBOSType().toString(), info.getId().toString());
					//	}
					//}
					BigDecimal suttle = UIRuleUtil.getBigDecimal(info.getEntrys().get(i).getSuttle());
					BigDecimal tare = UIRuleUtil.getBigDecimal(info.getEntrys().get(i).getTare());
					BigDecimal gross = UIRuleUtil.getBigDecimal(info.getEntrys().get(i).getGross());
					//反写订单过磅状态
					StringBuffer sqlBuf = new StringBuffer();
					if(isFinish){
						sqlBuf.append(" update CT_FM_CSlaughterBill set cfweighed='1',cfweighbillnum='"+info.getNumber()+"'")
						.append(" ,CFCompanyTare = "+tare.toString())
						.append(",CFCompanyGross = "+gross.toString())
						.append(",CFCompanySuttle = "+suttle.toString())
						.append(" where fid='"+srcBillID+"' ");
					}else{
						sqlBuf.append(" update CT_FM_CSlaughterBill set cfweighed='0',cfweighbillnum=null")
						.append(" where fid='"+srcBillID+"' ");
					}
					DbUtil.execute(ctx, sqlBuf.toString());
				}			
			} 	

		}catch(Exception err) {
			err.printStackTrace();
		}
	}

	public static String getDatePoor(Date endDate, Date nowDate) {

		long nd = 1000 * 24 * 60 * 60;
		long nh = 1000 * 60 * 60;
		long nm = 1000 * 60;
		// long ns = 1000;
		// 获得两个时间的毫秒时间差异
		long diff = endDate.getTime() - nowDate.getTime();
		// 计算差多少天
		long day = diff / nd;
		// 计算差多少小时
		long hour = diff % nd / nh;
		// 计算差多少分钟
		long min = diff % nd % nh / nm;
		// 计算差多少秒//输出结果
		// long sec = diff % nd % nh % nm / ns;
		return day+"" ;
	}


	@Override
	protected void _unAudit(Context ctx, IObjectValue model) throws BOSException {
		CKWeightBillInfo info=(CKWeightBillInfo)model;
		//反禁止重复审核
		if(!info.getBillStatus().equals(WeighBaseStatus.audit)) {
			return;
		}
		info.setBillStatus(WeighBaseStatus.save);
		info.setAuditTime(null);
		info.setAuditor(null);
		try {
			//检查是否存在下游单据
			WeighbridgeCommUtils.isExitBTPBill(ctx, new ObjectUuidPK(info.getId()), info);
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			throw new BOSException(e);
		}
	}


	//作废
	protected void _cancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		//反禁止重复审核
		CKWeightBillInfo info=(CKWeightBillInfo)model;
		if(info.getBillStatus().equals(WeighBaseStatus.audit)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据已经审核！，禁止作废"));
		}
		info.setBillStatus(WeighBaseStatus.cancel);
		reWriteWeighBill(ctx, info, false);
		try {
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			throw new BOSException(e);
		}
	}

	/**
	 * 反作废
	 */
	protected void _cancelCancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		CKWeightBillInfo info=(CKWeightBillInfo)model;
		if(!info.getBillStatus().equals(WeighBaseStatus.cancel)) {
			throw new EASBizException(new NumericExceptionSubItem("001","该单据没有被作废!反作废失败"));
		}
		info.setBillStatus(WeighBaseStatus.save);
		try {
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			throw new BOSException(e);
		}
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		CKWeightBillInfo info = CKWeightBillFactory.getLocalInstance(ctx).getCKWeightBillInfo(pk);
		if (info.getBillStatus().equals(WeighBaseStatus.finish)||info.getBillStatus().equals(WeighBaseStatus.audit)||info.getBillStatus().equals(WeighBaseStatus.gross)) {
			throw new BillBaseException(new NumericExceptionSubItem("001", info.getNumber() + ":单据已经完成或审核，禁止删除"));
		}
		super._delete(ctx, pk);
	}
}