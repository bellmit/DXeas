package com.kingdee.eas.farm.stocking.basebizbill.app;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.bot.BOTMappingCollection;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.stocking.basebizbill.MarginBillFactory;
import com.kingdee.eas.farm.stocking.basebizbill.MarginBillInfo;
import com.kingdee.eas.farm.stocking.common.BotpCommUtils;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class MarginBillControllerBean extends AbstractMarginBillControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.stocking.basebizbill.app.MarginBillControllerBean");
    protected void _audit(Context ctx, IObjectValue model)throws BOSException
    {
    	try {
    		MarginBillInfo info = (MarginBillInfo) model;
    		
    		createToReceiveBill(ctx, info);
//    		createToPaymentBill(ctx, info);
    		
			info.setBillStatus(BillBaseStatusEnum.AUDITED);
			info.setAuditTime(new java.util.Date());
			info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (Exception ex) {
			throw new BOSException(ex);
		}
    }
    /**
     * 生成收款单
     * @param ctx
     * @param info
     */
    private void createToReceiveBill(Context ctx,MarginBillInfo info) throws BOSException {
    	try {

			BotpCommUtils btpIS = BotpCommUtils.getInstance(null);
			OrgUnitInfo orgInfo=info.getCompany();
			BOTMappingCollection btpCols = btpIS.getAllCanUsedBotps(ctx, orgInfo, info.getBOSType().toString(),BotpCommUtils.ReceiveBill_BOSTYPE,new String[]{info.getString("id")},new String[]{}, new ArrayList<String>(), null);
			for(int index=0;index<btpCols.size();index++) {
				btpIS.createToBill(ctx, info, BotpCommUtils.ReceiveBill_BOSTYPE, btpCols.get(index));
				
//				if(info.getbiz&&&btpCols.get(index).getAlias().contains("收款")) {//
//				}
//				if(btpCols.get(index).getAlias().contains("退款")) {
//					
//				}
			}
    	}catch(Exception err) {
    		throw new BOSException(err);
    	}
    }
    
    /**
     * 生成付款单
     * @param ctx
     * @param info
     */
    private void createToPaymentBill(Context ctx,MarginBillInfo info) throws BOSException {
    	try {

			BotpCommUtils btpIS = BotpCommUtils.getInstance(null);
			OrgUnitInfo orgInfo=info.getCompany();
			BOTMappingCollection btpCols = btpIS.getAllCanUsedBotps(ctx, orgInfo, info.getBOSType().toString(),BotpCommUtils.PaymentBill_BOSTYPE,new String[]{info.getString("id")},new String[]{}, new ArrayList<String>(), null);
			for(int index=0;index<btpCols.size();index++) {
				btpIS.createToBill(ctx, info, BotpCommUtils.ReceiveBill_BOSTYPE, btpCols.get(index));
				
//				if(info.getbiz&&&btpCols.get(index).getAlias().contains("收款")) {//
//				}
//				if(btpCols.get(index).getAlias().contains("退款")) {
//					
//				}
			}
    	}catch(Exception err) {
    		throw new BOSException(err);
    	}
    }
    
    protected void _unAudit(Context ctx, IObjectValue model)throws BOSException
    {
    	try {
    		MarginBillInfo info = (MarginBillInfo) model;
    		String contractNumber=checkHasUsedByContract(ctx, info.getString("id"));
    		if(StringUtils.isNotBlank(contractNumber)) {
    			throw new EASBizException(new NumericExceptionSubItem("001","单据已经被合同"+contractNumber+"引用，禁止删除！"));
    		}
    		
			info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
			info.setAuditTime(null);
			info.setAuditor(null);
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (Exception ex) {
			throw new BOSException(ex);
		}
    }
    /**
     * 检查收呗合同引用
     * @param ctx
     * @param billID
     * @return
     * @throws BOSException 
     * @throws SQLException 
     */
    private String checkHasUsedByContract(Context ctx,String billID) throws BOSException, SQLException {
    	IRowSet rs = DbUtil.executeQuery(ctx, " select fnumber from T_FM_BatchContract where FMarginBillID='"+billID+"'");
    	if(rs.size()>0) {
    		return rs.getString("fnumber");
    	}
    	return null;
    }
    
    
    @Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
    	MarginBillInfo info = (MarginBillInfo) model;
    	if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)) {
    		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
    	}
		return super._save(ctx, info);
	}
    
    @Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
    	MarginBillInfo info = (MarginBillInfo) model;
    	if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)||info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)) {
    		info.setBillStatus(BillBaseStatusEnum.SUBMITED);
    	}
		return super._submit(ctx, info);
	}
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		MarginBillInfo info = MarginBillFactory.getLocalInstance(ctx).getMarginBillInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据已经审核，禁止删除！"));
		}
		super._delete(ctx, pk);
	}
}