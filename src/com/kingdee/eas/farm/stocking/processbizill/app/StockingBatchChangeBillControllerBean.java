package com.kingdee.eas.farm.stocking.processbizill.app;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.stocking.processbizill.BatchChangeTypeEnum;
import com.kingdee.eas.farm.stocking.processbizill.StockingBatchChangeBillFactory;
import com.kingdee.eas.farm.stocking.processbizill.StockingBatchChangeBillInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.util.NumericExceptionSubItem;

public class StockingBatchChangeBillControllerBean extends AbstractStockingBatchChangeBillControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.stocking.processbizill.app.StockingBatchChangeBillControllerBean");
    protected void _audit(Context ctx, IObjectValue model)throws BOSException
    {
    	try {
    		 StockingBatchChangeBillInfo info = ( StockingBatchChangeBillInfo) model;
    		
			info.setBillStatus(BillBaseStatusEnum.AUDITED);
			info.setAuditTime(new java.util.Date());
			info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
			
			//补苗不改变批次数量
			if(info.getBizType()==null||!info.getBizType().equals(BatchChangeTypeEnum.SUPPLEMENT_VALUE)) {
				String batchID=info.getStockingBatch().getId().toString();
				BigDecimal qty=info.getChangeQty();
				BigDecimal femaleQty=info.getFemaleChangeQty();
				if(qty==null) {
					qty=BigDecimal.ZERO;
				}
				if(femaleQty==null) {
					femaleQty=BigDecimal.ZERO;
				}
				DbUtil.execute(ctx, "update T_FM_StockingBatch set FBatchQty=isnull(FBatchQty,0)+("+qty+"),FFemaleQty=isnull(FFemaleQty,0)+("+femaleQty+"),FTotalQty=isnull(FTotalQty,0)+("+femaleQty.add(qty)+") where fid='"+batchID+"'");
			}
			info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
			info.setAuditTime(new Date());
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (Exception ex) {
			throw new BOSException(ex);
		}
    }
    
    protected void _unAudit(Context ctx, IObjectValue model)throws BOSException
    {
    	try {
    		 StockingBatchChangeBillInfo info = ( StockingBatchChangeBillInfo) model;
    		 
    		 String batchID=info.getStockingBatch().getId().toString();
 			BigDecimal qty=info.getChangeQty();
 			BigDecimal femaleQty=info.getFemaleChangeQty();
 			if(qty==null) {
 				qty=BigDecimal.ZERO;
 			}
 			if(femaleQty==null) {
 				femaleQty=BigDecimal.ZERO;
 			}
 			DbUtil.execute(ctx, "update T_FM_StockingBatch set FBatchQty=isnull(FBatchQty,0)-("+qty+"),FFemaleQty=isnull(FFemaleQty,0)-("+femaleQty+") where fid='"+batchID+"'");

    		 
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
    	 StockingBatchChangeBillInfo info = ( StockingBatchChangeBillInfo) model;
    	if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)) {
    		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
    	}
		return super._save(ctx, info);
	}
    
    @Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
    	 StockingBatchChangeBillInfo info = ( StockingBatchChangeBillInfo) model;
    	if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)||info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)) {
    		info.setBillStatus(BillBaseStatusEnum.SUBMITED);
    	}
		return super._submit(ctx, info);
	}
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		 StockingBatchChangeBillInfo info =  StockingBatchChangeBillFactory.getLocalInstance(ctx).getStockingBatchChangeBillInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据已经审核，禁止删除！"));
		}
		super._delete(ctx, pk);
	}
}