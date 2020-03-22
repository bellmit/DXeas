package com.kingdee.eas.farm.stocking.processbizill.app;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.bot.BOTMappingCollection;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.stocking.basedata.BaseSysSettingInfo;
import com.kingdee.eas.farm.stocking.common.BotpCommUtils;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.farm.stocking.processbizill.BirdsRecycleBillFactory;
import com.kingdee.eas.farm.stocking.processbizill.BirdsRecycleBillInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.util.NumericExceptionSubItem;

public class BirdsRecycleBillControllerBean extends AbstractBirdsRecycleBillControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.stocking.processbizill.app.BirdsRecycleBillControllerBean");
    protected void _audit(Context ctx, IObjectValue model)throws BOSException
    {
    	try {
    		BirdsRecycleBillInfo info = (BirdsRecycleBillInfo) model;
    		
    		//生成供应链单据
    		createToSCMBill(ctx, info);
    		
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
    private void createToSCMBill(Context ctx,BirdsRecycleBillInfo info) throws BOSException {
    	try {
    		
    		BaseSysSettingInfo sysInfo = StockingComm.getSysSetting(ctx,info.getCompany().getString("id"));
    		
    		String destBillType=null;
    		
    		//内部管理 生产入库
    		if(sysInfo.isIsInner()) {
    			destBillType=BotpCommUtils.ManufactureRec_BOSTYPE;
    		}else{//外部管理 生成采购入库
    			destBillType=BotpCommUtils.PurInwarehouse_BOSTYPE;
    		}

			BotpCommUtils btpIS = BotpCommUtils.getInstance(null);
			OrgUnitInfo orgInfo=info.getCompany();
			BOTMappingCollection btpCols = btpIS.getAllCanUsedBotps(ctx, orgInfo, info.getBOSType().toString(),destBillType,new String[]{info.getString("id")},new String[]{}, new ArrayList<String>(), null);
			for(int index=0;index<btpCols.size();index++) {
				btpIS.createToSCMBill(ctx, info,destBillType, btpCols.get(index));
			}
    	}catch(Exception err) {
    		throw new BOSException(err);
    	}
    }
    
    
    protected void _unAudit(Context ctx, IObjectValue model)throws BOSException
    {
    	try {
    		BirdsRecycleBillInfo info = (BirdsRecycleBillInfo) model;
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
    	BirdsRecycleBillInfo info = (BirdsRecycleBillInfo) model;
    	if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)) {
    		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
    	}
		return super._save(ctx, info);
	}
    
    @Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
    	BirdsRecycleBillInfo info = (BirdsRecycleBillInfo) model;
    	if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)||info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)) {
    		info.setBillStatus(BillBaseStatusEnum.SUBMITED);
    	}
		return super._submit(ctx, info);
	}
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BirdsRecycleBillInfo info = BirdsRecycleBillFactory.getLocalInstance(ctx).getBirdsRecycleBillInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据已经审核，禁止删除！"));
		}
		super._delete(ctx, pk);
	}
}