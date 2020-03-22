package com.kingdee.eas.farm.carnivorous.feedbiz.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import com.kingdee.eas.farm.carnivorous.basedata.ConFeedPolicyFactory;
import com.kingdee.eas.farm.carnivorous.basedata.ConFeedPolicyInfo;
import com.kingdee.eas.farm.carnivorous.basedata.IConFeedPolicy;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.CloseStatus;
import com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractFeedEntryInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.IBatchContractBill;
import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.FarmException;
import com.kingdee.eas.wlhlcomm.WorkFlowUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.eas.custom.commld.ServerUtils;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ConFeedContractControllerBean extends AbstractConFeedContractControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.carnivorous.feedbiz.app.ConFeedContractControllerBean");

	private SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		model = ServerUtils.audit(ctx, model, null);
		ConFeedContractInfo info = (ConFeedContractInfo) model;
		checkIsOverlap(ctx, info);
		super._save(ctx, model);
	}

	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		ConFeedContractInfo info = (ConFeedContractInfo) model;
		//		checkIsCanDo(ctx, info);
		model = ServerUtils.unAudit(ctx, model, null);
		super._save(ctx, model);
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		ConFeedContractInfo info = ConFeedContractFactory.getLocalInstance(ctx).getConFeedContractInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)||info.getBillStatus().equals(BillBaseStatusEnum.cancel)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据已经审核或禁用，禁止删除！"));
		}
		checkIsCanDo(ctx, info);
		super._delete(ctx, pk);
	}

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		if(model.getInt("billStatus")!=-1&&model.getInt("billStatus")!=0&&model.getInt("billStatus")!=1)
			throw new EASBizException(ServerUtils.CHECKSAVE);

		ConFeedContractInfo info = (ConFeedContractInfo) model;
		checkIsOverlap(ctx, info);
		model.setDate("bizDate", DateUtilsComm.clearDateHMS(model.getDate("bizDate")));
		model.setInt("billStatus", 1);
		return super._save(ctx, model);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		if(model.getInt("billStatus")!=-1&&model.getInt("billStatus")!=0&&model.getInt("billStatus")!=1&&model.getInt("billStatus")!=2)
			throw new EASBizException(ServerUtils.CHECKSUBMIT);
		ConFeedContractInfo info = (ConFeedContractInfo) model;
		checkIsOverlap(ctx, info);
		model.setDate("bizDate", DateUtilsComm.clearDateHMS(model.getDate("bizDate")));
		model.setInt("billStatus", 2);
		return super._submit(ctx, model);
	}

	//禁用
	protected void _cancel(Context ctx, IObjectPK pk, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		ConFeedContractInfo info = (ConFeedContractInfo) model;
		if(info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.AUDITED))
			throw new EASBizException(new NumericExceptionSubItem("001","只有审核的单子才可以执行此操作"));
		info.setBillStatus(BillBaseStatusEnum.cancel);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}

	//启用
	protected void _cancelCancel(Context ctx, IObjectPK pk, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		ConFeedContractInfo info = (ConFeedContractInfo) model;
		if(info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.cancel))
			throw new EASBizException(new NumericExceptionSubItem("001","只有禁用的单子才可以执行此操作"));
		checkIsOverlap(ctx, info);
		info.setBillStatus(BillBaseStatusEnum.AUDITED);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}


	@Override
	protected void _updateFeed(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		ConFeedContractInfo info = (ConFeedContractInfo) model;
		checkIsOverlap(ctx, info);
		info.getFeedEntrys().clear();
		if(info.getFarmer()==null||info.getFarm()==null){
			return;
		}
		String farmerID=info.getFarmer().getId().toString();
		String farmID=info.getFarm().getId().toString();
		try {
			IBatchContractBill iBatchContractBill = BatchContractBillFactory.getLocalInstance(ctx);
			IConFeedPolicy iConFeedPolicy = ConFeedPolicyFactory.getLocalInstance(ctx);
			StringBuffer sqlBuf = new StringBuffer();
			sqlBuf.append(" SELECT  t1.fid fid, ")
			.append(" t1.CFConFeedPolicyID CFConFeedPolicyID, ")
			.append(" t1.CFSUBSIDYPRICE subsidyPrice, ")
			.append(" t1.FActualBreedDate actualBreedDate, ")
			.append(" t1.FActualFemaleQty actualFemaleQty, ")
			.append(" t2.CFConFeedSubsidies conFeedSubsidies, ")
			.append(" case when (t1.CFIsRecSettled is null or t1.CFIsRecSettled=0) then  '未结算' ")
			.append(" else  '已结算' end settleStatus, ")
			.append(" t2.CFRecDate recDate, ")
			.append(" t2.CFContractCKWgt contractCKWgt ")
			.append(" FROM T_FM_BatchContractBill t1 ")
			.append(" left join CT_FM_CKSettleBill t2 on (t1.fid=t2.CFBatchContractID and t2.CFBillStatus=4) ")
			.append(" where t1.FBILLSTATUS=4 ")
			.append(" and t1.FFarmerID='"+farmerID+"' and t1.FFarmID='"+farmID+"'")
			.append(" and t1.CFConFeedContractI='"+info.getId().toString()+"'")
			.append(" order by t1.FBizDate desc");
			IRowSet rs =DbUtil.executeQuery(ctx, sqlBuf.toString());
			while(rs.next()){
				ConFeedContractFeedEntryInfo entry = new ConFeedContractFeedEntryInfo();
				BatchContractBillInfo batchContractBill = iBatchContractBill.getBatchContractBillInfo(new ObjectUuidPK(rs.getString("fid")));
				entry.setBatchContract(batchContractBill);
				if(rs.getString("CFConFeedPolicyID")!=null){
					ConFeedPolicyInfo conFeedPolicy = iConFeedPolicy.getConFeedPolicyInfo(new ObjectUuidPK(rs.getString("CFConFeedPolicyID")));
					entry.setConFeedPolicy(conFeedPolicy);
				}
				entry.setSubsidyPrice(rs.getBigDecimal("subsidyPrice"));
				entry.setInDate(rs.getDate("actualBreedDate"));
				entry.setBatchQty(rs.getInt("actualFemaleQty"));
				entry.setRecDate(rs.getDate("recDate"));
				entry.setInContractWgt(rs.getBigDecimal("contractCKWgt"));
				entry.setSubsidyAmount(rs.getBigDecimal("conFeedSubsidies"));
				entry.setSettleStatus(rs.getString("settleStatus"));
				info.getFeedEntrys().add(entry);
			}
		} catch (BOSException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (EASBizException e) {
			e.printStackTrace();
		}
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}

	private void checkIsCanDo(Context ctx,ConFeedContractInfo info) throws EASBizException {
		// TODO Auto-generated method stub
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select count(*) FCount from T_FM_BatchContractBill where CFConFeedContractI='").append(info.getId().toString()).append("'");
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			StringBuffer sql2=new StringBuffer();
			sql2.append(" select count(*) FCount from CT_FM_CKSettleBill where CFConFeedContractI='").append(info.getId().toString()).append("'");
			IRowSet rs2 = DbUtil.executeQuery(ctx, sql2.toString());
			if(rs.next()&&rs.getInt("Fcount")>0) {
				throw new EASBizException(new NumericExceptionSubItem("001","该合同已被批次合同引用，无法执行该操作！"));
			}
			if(rs2.next()&&rs2.getInt("Fcount")>0) {
				throw new EASBizException(new NumericExceptionSubItem("001","该合同已被结算单引用，无法执行该操作！"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//判断期间是否已有其他合同
	private void checkIsOverlap(Context ctx,ConFeedContractInfo info) throws EASBizException {
		// TODO Auto-generated method stub
		String farmID=info.getFarm().getId().toString();
		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append(" /*dialect*/select * from CT_FM_ConFeedContract where FFarmID='"+farmID+"' ")
		.append(" and to_char(CFEndDate,'yyyy-mm-dd')>='"+sdf.format(info.getBeginDate())+"' ")
		.append(" and to_char(CFBeginDate,'yyyy-mm-dd') <='"+sdf.format(info.getEndDate())+"' ")
		.append(" and CFBillStatus='4' ");
		if(BillBaseStatusEnum.AUDITED==info.getBillStatus()){
			sqlBuf.append(" and fid<>'"+info.getId().toString()+"'");
		}
		try {
			IRowSet rs = DbUtil.executeQuery(ctx, sqlBuf.toString());
			if(rs.size()>0){
				throw new EASBizException(new NumericExceptionSubItem("001","当前养殖场的合同开始与结束期间内存在其他已审核的连养合同，操作失败"));
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}