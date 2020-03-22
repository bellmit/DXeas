package com.kingdee.eas.custom.salediscount.app;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.bot.BOTMappingFactory;
import com.kingdee.bos.metadata.bot.BOTMappingInfo;
import com.kingdee.bos.metadata.bot.DefineSysEnum;
import com.kingdee.eas.base.btp.BTPException;
import com.kingdee.eas.base.dap.DAPTransformResult;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.common.app.AppCommonUtil;
import com.kingdee.eas.custom.salediscount.DiscountRecordBillInfo;
import com.kingdee.eas.custom.salediscount.billStatus;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.eas.util.app.DbUtil;

public class DiscountRecordBillControllerBean extends AbstractDiscountRecordBillControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.salediscount.app.DiscountRecordBillControllerBean");
    /**
	 * 审核 自动生成凭证 更新状态为 审核 
	 */
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		
		
		DiscountRecordBillInfo billInfo = (DiscountRecordBillInfo)model;
		if(billInfo != null && billInfo.getStatus() != null && billStatus.submit.equals(billInfo.getStatus())){
			boolean exist = AppCommonUtil.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				throw new BOSException("已经存在下游单据，不能审核");
			}
			
			
			
			
				AppCommonUtil.updateModelStatus(ctx, "CT_NDI_DiscountRecordBill", billInfo.getId().toString(), billStatus.audit);
				
		
			
			
		}else{
			throw new BOSException("只能审核提交状态的计费单");
		}
		
		
	}
	
	
	
	/**
	 * 反审核 删除凭证 更新状态为保存
	 */
	protected void _unAudit(Context ctx, IObjectValue model)
			throws BOSException {
		
		DiscountRecordBillInfo billInfo = (DiscountRecordBillInfo)model;
		if(billInfo != null && billInfo.getStatus() != null && billInfo.getStatus().equals(billStatus.audit)){
			boolean exist = AppCommonUtil.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				throw new BOSException("已经存在下游单据，不能反审核");
			}
			// 删除凭证
			// TODO 
			// 更新状态
			AppCommonUtil.updateModelStatus(ctx, "CT_NDI_DiscountRecordBill", billInfo.getId().toString(), billStatus.save);
			
			
		}else{
			throw new BOSException("只能反审核审核状态的计费单");
		}
		
		
		
		
	}

	/**
	 * 提交计费单
	 */
	protected IObjectPK _submit(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		DiscountRecordBillInfo billInfo = (DiscountRecordBillInfo)model;
		if(billInfo != null && billInfo.getStatus() != null && (billInfo.getStatus().equals(billStatus.save) || billInfo.getStatus().equals(billStatus.add)) ){
			billInfo.setStatus(billStatus.submit);
		}
		return super._submit(ctx, model);
		
		
	}
	/**
	 * 删除时验证是否有下游单据 
	 */
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {
		boolean exist = AppCommonUtil.existDestBill(ctx, this.getBOSType().toString(), pk.toString());
		if(exist){
			throw new BOSException("已经存在下游单据，不能删除");
		}
		DiscountRecordBillInfo billInfo = this.getDiscountRecordBillInfo(ctx, pk);
		if(billInfo.getStatus() != null && billInfo.getStatus().equals(billStatus.audit)){
			throw new BOSException("不能删除已审核单据");
		}
		super._delete(ctx, pk);
	}
	
	
}