package com.kingdee.eas.custom.taihe.contract.app;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.szcount.SzSemiProductInfo;
import com.kingdee.eas.custom.taihe.contract.AssureAmtPolicy;
import com.kingdee.eas.custom.taihe.contract.AssureAmtPolicyInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.basedata.FarmersInfo;
import com.kingdee.eas.farm.stocking.basedata.app.FarmControllerBean;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.util.NumericExceptionSubItem;



public class AssureAmtPolicyControllerBean extends AbstractAssureAmtPolicyControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.taihe.contract.app.AssureAmtPolicyControllerBean");
    @Override
    protected void _unAudit(Context ctx, IObjectValue model)throws BOSException
    {
    	AssureAmtPolicyInfo info = (AssureAmtPolicyInfo) model;
    	try {
			info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (Exception ex) {
			throw new BOSException(ex);
		}
    }
    @Override
    protected void _audit(Context ctx, IObjectValue model)throws BOSException
    {
    	AssureAmtPolicyInfo info = (AssureAmtPolicyInfo) model;
    	if(!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)) {
    		return;
    	}
    	try {
    	info.setBillStatus(BillBaseStatusEnum.AUDITED);
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		AssureAmtPolicyInfo info = (AssureAmtPolicyInfo) model;
		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)||info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)) {
			info.setBillStatus(BillBaseStatusEnum.SUBMITED);
		}
		return super._submit(ctx, info);
	}
	
	

}