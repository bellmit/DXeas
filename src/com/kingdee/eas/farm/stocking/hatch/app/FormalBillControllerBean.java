package com.kingdee.eas.farm.stocking.hatch.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.stocking.basedata.IStockingBatch;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.hatch.FormalBillEntryInfo;
import com.kingdee.eas.farm.stocking.hatch.FormalBillFactory;
import com.kingdee.eas.farm.stocking.hatch.FormalBillInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.util.NumericExceptionSubItem;

public class FormalBillControllerBean extends AbstractFormalBillControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.stocking.hatch.app.FormalBillControllerBean");
    protected void _audit(Context ctx, IObjectValue model)throws BOSException
    {
    	try {
    		FormalBillInfo info = (FormalBillInfo) model;
    		
    		reWriteBatch(ctx, info, true);
    		
			info.setBillStatus(BillBaseStatusEnum.AUDITED);
			info.setAuditTime(new java.util.Date());
			info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));

//			super.submit(ctx, info);
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (Exception ex) {
			throw new BOSException(ex);
		}
    }
    
    protected void _unAudit(Context ctx, IObjectValue model)throws BOSException
    {
    	try {
    		FormalBillInfo info = (FormalBillInfo) model;
    		
    		reWriteBatch(ctx, info, false);
    		
			info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
			info.setAuditTime(null);
			info.setAuditor(null);
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (Exception ex) {
			throw new BOSException(ex);
		}
    }
    /**
     * 反写批次信息
     * @param ctx
     * @param info
     * @param isAudit
     * @throws BOSException 
     * @throws EASBizException 
     */
    private void reWriteBatch(Context ctx,FormalBillInfo info,boolean isAudit) throws EASBizException, BOSException {
    	FormalBillEntryInfo entryInfo;
    	IStockingBatch ibs = StockingBatchFactory.getLocalInstance(ctx);
    	StockingBatchInfo bInfo;
    	HashMap<String,StockingBatchInfo> batchMap=new HashMap<String,StockingBatchInfo>();
    	for(int index=0;index<info.getEntrys().size();index++) {
    		entryInfo = info.getEntrys().get(index);
    		if(batchMap.containsKey(entryInfo.getStockingBatch().getString("id"))){
    			bInfo=batchMap.get(entryInfo.getStockingBatch().getString("id"));
    		}else{
    			bInfo= ibs.getStockingBatchInfo(new ObjectUuidPK(entryInfo.getStockingBatch().getId()));
    			batchMap.put(entryInfo.getStockingBatch().getString("id"), bInfo);
    		}
    		if(entryInfo.getHouse()!=null) {
    			for(int j=0;j<bInfo.getHouseEntry().size();j++) {
    				if(bInfo.getHouseEntry().get(j).getHouse().getString("id").equals(entryInfo.getHouse().getString("id"))) {
    					if(isAudit) {
    						bInfo.getHouseEntry().get(j).setFormalDate(entryInfo.getApplyDate());
    					}else{
    						bInfo.getHouseEntry().get(j).setFormalDate(null);
    					}
    					break;
    				}
    			}
    		}else{
        		if(isAudit) {
        			bInfo.setFormalDate(entryInfo.getApplyDate());
        		}else{
        			bInfo.setFormalDate(null);
        		}
    		}
    	}
    	CoreBaseCollection col=new CoreBaseCollection();
    	for(Entry<String, StockingBatchInfo> entry:batchMap.entrySet()) {
    		col.add(entry.getValue());
    	}
		ibs.update(col);
    }
    
    @Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
    	FormalBillInfo info = (FormalBillInfo) model;
    	if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)) {
    		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
    	}
		return super._save(ctx, info);
	}
    
    @Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
    	FormalBillInfo info = (FormalBillInfo) model;
    	if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)||info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)) {
    		info.setBillStatus(BillBaseStatusEnum.SUBMITED);
    	}
		return super._submit(ctx, info);
	}
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		FormalBillInfo info = FormalBillFactory.getLocalInstance(ctx).getFormalBillInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据已经审核，禁止删除！"));
		}
		super._delete(ctx, pk);
	}
}