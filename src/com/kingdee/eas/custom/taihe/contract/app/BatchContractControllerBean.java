package com.kingdee.eas.custom.taihe.contract.app;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.apache.derby.tools.sysinfo;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.taihe.contract.BatchContractInfo;
import com.kingdee.eas.custom.taihe.contract.SuccessiveContractFactory;
import com.kingdee.eas.custom.taihe.contract.SuccessiveContractInfo;
import com.kingdee.eas.framework.BillBaseException;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class BatchContractControllerBean extends AbstractBatchContractControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.taihe.contract.app.BatchContractControllerBean");

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BatchContractInfo info  = (BatchContractInfo) model;
		//保证金正数
		StringBuffer beforePositive = new StringBuffer();
		beforePositive.append("/*dialect*/ select nvl(sum(CFPayAmount),0)	moneys from CT_CON_BailAmount where  CFMoneytypes= '0' and FcompanyID = '")
		.append(info.getCompany().getId())
		.append("' and FBillStatus = '4' and CFpartyBID = '")
		.append(info.getSupplier().getId())
		.append("'");
		//保证金负数
		StringBuffer beforeNegative = new StringBuffer();
		beforeNegative.append("/*dialect*/ select nvl(sum(CFPayAmount),0)	moneys from CT_CON_BailAmount where  CFMoneytypes <> '0' and FcompanyID = '")
		.append(info.getCompany().getId())
		.append("' and FBillStatus = '4' and CFpartyBID = '")
		.append(info.getSupplier().getId())
		.append("'");
		//供应商所有批次合同之和
		StringBuffer supplier = new StringBuffer();
		supplier.append("/*dialect*/ select nvl(sum(CFRECEIVEAMT),0) moneys from CT_CON_BatchContract where CFWHETHERCLOSE = '0' and CFSupplierID = '")
		.append(info.getSupplier().getId())
		.append("' and CFCompanyID = '")
		.append(info.getCompany().getId())
		.append("' and FBillStatus = '4'");
		
			IRowSet rsPositive = SQLExecutorFactory.getLocalInstance(ctx, beforePositive.toString()).executeSQL();
			IRowSet rsNegative = SQLExecutorFactory.getLocalInstance(ctx, beforeNegative.toString()).executeSQL();
			IRowSet rsSupplier = SQLExecutorFactory.getLocalInstance(ctx, supplier.toString()).executeSQL();
			BigDecimal bdPositive = null ;
			BigDecimal bdNegative = null ;
			BigDecimal bdSupplier = null ;
			try {
				if(rsPositive.next()){
					bdPositive=new BigDecimal(rsPositive.getString("moneys")); 
				}
				if(rsNegative.next()){
					bdNegative=new BigDecimal(rsNegative.getString("moneys")); 
				}
				if(rsSupplier.next()){
					bdSupplier=new BigDecimal(rsSupplier.getString("moneys")); 
				}
				BigDecimal thismoney = null;
				if(info.getReceiveAmt()==null){
					thismoney = new BigDecimal(0);
				}else{
					thismoney = info.getReceiveAmt();
				}
				if(bdPositive.compareTo(thismoney.add(bdNegative).add(bdSupplier))>=0){
					super._audit(ctx, model);
					updateSuccessSive(ctx,model);
				}else{
					throw new BillBaseException(new NumericExceptionSubItem("001","该供应商保证金不足，禁止审核"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BatchContractInfo info  = (BatchContractInfo) model;
		if(info.getSuccessiveContract()!=null){
			String bizDateStr=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(info.getBizDate());
			StringBuffer sql=new StringBuffer();
			sql.append(" select fid,CFWhetherRepeat")
			.append(" from CT_CON_BatchContract  ")
			.append(" where FSuccessiveContrac='").append(info.getSuccessiveContract().getString("id")).append("'")
			.append(" and (FBillStatus=2 or  FBillStatus=4)")
			.append(" and FBizDate<={ts '").append(bizDateStr).append("'}");
			if(info.getId()!=null) {
				sql.append(" and fid!='").append(info.getString("id")).append("'");
			}
			sql.append(" order by FBizDate asc")
			;
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			try {
				int batchCount=0;
				Boolean isSameBatch=false,isSameBatchKeep=false;
				while(rs.next()) {
					isSameBatch=rs.getBoolean("CFWhetherRepeat");
					if(rs.getRow()==1) {
						isSameBatchKeep=isSameBatch;
						batchCount=1;
					}else {
						if(!isSameBatch) {
							batchCount++;
							isSameBatchKeep=isSameBatch;
						}
					}
				}
				if(!info.isWhetherRepeat()) {
					batchCount++;
				}
				
				SuccessiveContractInfo cInfo = SuccessiveContractFactory.getLocalInstance(ctx).getSuccessiveContractInfo(new ObjectUuidPK(info.getSuccessiveContract().getId()));
				if(batchCount>cInfo.getSuccessiveQty()) {
					throw new EASBizException(new NumericExceptionSubItem("","连养批次数已超过连养合同限定数量！"));
				}
				info.setSuccessiveQty(new BigDecimal(batchCount));
			} catch (SQLException e) {
				throw new BOSException(e);
			}
		}
		return super._submit(ctx, info);
		
	}



	private void judegEnsureMoney(Context ctx, IObjectValue model) {
		// TODO Auto-generated method stub
		BatchContractInfo info  = (BatchContractInfo) model;
		//保证金正数
		StringBuffer beforePositive = new StringBuffer();
		beforePositive.append("/*dialect*/ select nvl(sum(CFPayAmount),0)	moneys from CT_CON_BailAmount where  CFMoneytypes= '0' and FcompanyID = '")
		.append(info.getCompany().getId())
		.append("' and FBillStatus = '4' and CFpartyBID = '")
		.append(info.getSupplier().getId())
		.append("'");
		//保证金负数
		StringBuffer beforeNegative = new StringBuffer();
		beforeNegative.append("/*dialect*/ select nvl(sum(CFPayAmount),0)	moneys from CT_CON_BailAmount where  CFMoneytypes <> '0' and FcompanyID = '")
		.append(info.getCompany().getId())
		.append("' and FBillStatus = '4' and CFpartyBID = '")
		.append(info.getSupplier().getId())
		.append("'");
		//供应商所有批次合同之和
		StringBuffer supplier = new StringBuffer();
		supplier.append("/*dialect*/ select nvl(sum(CFRECEIVEAMT),0) from CT_CON_BatchContract where CFSupplierID = '")
		.append(info.getSupplier().getId())
		.append("' and CFCompanyID = '")
		.append(info.getCompany().getId())
		.append("' and FBillStatus = '4'");
		
		try {
			IRowSet rsPositive = SQLExecutorFactory.getLocalInstance(ctx, beforePositive.toString()).executeSQL();
			IRowSet rsNegative = SQLExecutorFactory.getLocalInstance(ctx, beforeNegative.toString()).executeSQL();
			IRowSet rsSupplier = SQLExecutorFactory.getLocalInstance(ctx, supplier.toString()).executeSQL();
			BigDecimal bdPositive = null ;
			BigDecimal bdNegative = null ;
			BigDecimal bdSupplier = null ;
			if(rsPositive.next()){
				bdPositive=new BigDecimal(rsPositive.getString("moneys")); 
			}
			if(rsNegative.next()){
				bdNegative=new BigDecimal(rsNegative.getString("moneys")); 
			}
			if(rsSupplier.next()){
				bdSupplier=new BigDecimal(rsSupplier.getString("moneys")); 
			}
			BigDecimal thismoney = info.getReceiveAmt();
			if(bdPositive.compareTo(thismoney.add(bdNegative).add(bdSupplier))>=0){
				System.out.print("过关了");
			}else{
				throw new BillBaseException(new NumericExceptionSubItem("001","该供应商保证金不足，禁止审核"));
			}
			
			
			
			
			
			
			
			
			
			
			
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BillBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	protected void _unAudit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		super._unAudit(ctx, model);
		updateSuccessSive(ctx,model);
	}
    private void updateSuccessSive(Context ctx,IObjectValue model) throws BOSException {
		StringBuffer sql=new StringBuffer();
		BatchContractInfo info  = (BatchContractInfo) model;
		
		if(info.getSuccessiveContract()!=null){
			BOSUuid successiveID= info.getSuccessiveContract().getId();
			String cxSql = "/*dialect*/  select nvl(max(CFsuccessiveQty),0) qty from CT_CON_BatchContract where FSuccessivecontrac ='"+successiveID.toString()+"'  and FBillStatus = '4'";
			IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, cxSql).executeSQL();
			int a = 0 ;
			try {
				if(rs.next()){
				a =	Integer.valueOf(rs.getString("qty")).intValue();
				}
			
			sql.append(" /*dialect*/ update CT_CON_SuccessiveContract  set FHasSuccessiveQty=nvl(FInitBatchQty,0)+").append(a);
			DbUtil.execute(ctx, sql.toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
    }

	@Override
	protected void _close(Context ctx, IObjectValue model) throws BOSException {
		// TODO Auto-generated method stub
		super._close(ctx, model);
		BatchContractInfo info = (BatchContractInfo) model;
		info.setWhetherClose(true);
		SelectorItemCollection selector=new SelectorItemCollection();
		selector.add("whetherClose");
		try {
			super._updatePartial(ctx, info, selector);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BOSException(e);
		}
	}

	@Override
	protected void _backClose(Context ctx, IObjectValue model) throws BOSException {
		// TODO Auto-generated method stub
		super._backClose(ctx, model);
		BatchContractInfo info = (BatchContractInfo) model;
		info.setWhetherClose(false);
		SelectorItemCollection selector=new SelectorItemCollection();
		selector.add("whetherClose");
			try {
				super._updatePartial(ctx, info, selector);
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new BOSException(e);
			}
		
	}
    
}