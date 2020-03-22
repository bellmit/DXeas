package com.kingdee.eas.custom.salediscount.app;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.salediscount.CustomerBalanceEditFactory;
import com.kingdee.eas.custom.salediscount.CustomerBalanceEditInfo;
import com.kingdee.eas.custom.salediscount.CustomerBalanceInfo;
import com.kingdee.eas.custom.salediscount.SaleDiscountFacadeFactory;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.AppCommon;
import com.kingdee.eas.wlhlcomm.FarmException;
import com.kingdee.util.NumericExceptionSubItem;

public class CustomerBalanceEditControllerBean extends AbstractCustomerBalanceEditControllerBean
{
	

	private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.salediscount.app.CustomerBalanceEditControllerBean");
	
	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// 状态设置为保存
		CustomerBalanceEditInfo info =  (CustomerBalanceEditInfo)model;
		
		
		if(info.getBaseStatus() != null && 
				!BillBaseStatusEnum.TEMPORARILYSAVED.equals(info.getBaseStatus()) &&
				!BillBaseStatusEnum.ADD.equals(info.getBaseStatus()) &&
				!BillBaseStatusEnum.NULL.equals(info.getBaseStatus())){
			throw new EASBizException(new NumericExceptionSubItem("001","只能保存暂存或者新增状态的单据"));
			
		}
		
		
		info.setBaseStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		return super._save(ctx, model);
	}

	/**
	 * 校验 上孵单没被引用才会允许删除
	 */
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {
		CustomerBalanceEditInfo info =  CustomerBalanceEditFactory.getLocalInstance(ctx).getCustomerBalanceEditInfo(pk);
		
		
		if(!BillBaseStatusEnum.TEMPORARILYSAVED.equals(info.getBaseStatus()) &&
				!BillBaseStatusEnum.ADD.equals(info.getBaseStatus())	&& 
				!BillBaseStatusEnum.SUBMITED.equals(info.getBaseStatus())){
			throw new EASBizException(new NumericExceptionSubItem("001","只能删除暂存或者新增状态的单据"));
			
		}
		
	
		super._delete(ctx, pk);
	}
	
	/**
	 * 提交
	 */
	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		CustomerBalanceEditInfo billInfo = (CustomerBalanceEditInfo)model;
		
		
		
    	if(billInfo != null  && 
    			(billInfo.getBaseStatus() == null || 
    					BillBaseStatusEnum.ADD.equals(billInfo.getBaseStatus()) ||
						BillBaseStatusEnum.TEMPORARILYSAVED.equals(billInfo.getBaseStatus()) ||
						BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus()) || 
						BillBaseStatusEnum.NULL.equals(billInfo.getBaseStatus()))){
    		
    		billInfo.setBaseStatus( BillBaseStatusEnum.SUBMITED);
    		
    		
    		return super._submit(ctx, model);
    	}else{
    		throw new EASBizException(new NumericExceptionSubItem("001","只能提交新增或保存状态的单据"));
			
    	}
	}
	/**
	 * 审核更新余额
	 */
    @Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {

		CustomerBalanceEditInfo billInfo = (CustomerBalanceEditInfo)model;
		if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus())){
			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				throw new FarmException("已经存在下游单据，不能审核");
			}
			
			// 更新单据状态
			AppCommon.updateModelStatus(ctx, "CT_NDI_CustomerBalanceEdit", billInfo.getId().toString(), BillBaseStatusEnum.AUDITED);
			CustomerBalanceInfo customerBalance = SaleDiscountFacadeFactory.getLocalInstance(ctx).getCustomerBalanceInfo(billInfo.getCompany().getId().toString(),
					billInfo.getCustomer().getId().toString());
			if(customerBalance != null){
				
				BigDecimal addAmount = billInfo.getAddAmount();
				if(addAmount != null){
					if(addAmount.compareTo(BigDecimal.ZERO) > 0){
						// 增加余额
						SaleDiscountFacadeFactory.getLocalInstance(ctx).updateCustomerBalance(billInfo.getCompany().getId().toString(),
								billInfo.getCustomer().getId().toString(),
								null, 
								addAmount);
					
					}else{
						// 扣减余额
						addAmount = addAmount.abs();
						// 扣减余额
						SaleDiscountFacadeFactory.getLocalInstance(ctx).updateCustomerBalance(billInfo.getCompany().getId().toString(),
								billInfo.getCustomer().getId().toString(),
								addAmount, 
								null);
					}
				}
			}else{
				throw new BOSException("不存在对应客户的余额信息");
			}
		}else{
			throw new FarmException("只能审核提交状态的单据");
		}
		super._audit(ctx, model);
	}

    /**
     * 反审核 更新余额
     */
	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
			throws BOSException {

		CustomerBalanceEditInfo billInfo = (CustomerBalanceEditInfo)model;
		
		if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.AUDITED.equals(billInfo.getBaseStatus())){
			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				throw new FarmException("已经存在下游单据，不能反审核");
			}
			
			
			
			// 更新单据状态
			AppCommon.updateModelStatus(ctx, "CT_NDI_CustomerBalanceEdit", billInfo.getId().toString(), BillBaseStatusEnum.TEMPORARILYSAVED);
			CustomerBalanceInfo customerBalance = SaleDiscountFacadeFactory.getLocalInstance(ctx).getCustomerBalanceInfo(billInfo.getCompany().getId().toString(),
					billInfo.getCustomer().getId().toString());
			if(customerBalance != null && billInfo.getAddAmount() != null){
				if(billInfo.getAddAmount().compareTo(BigDecimal.ZERO) > 0 && billInfo.getAddAmount().compareTo(customerBalance.getNowBalance()) > 0){
					throw new BOSException("当前客户折让余额不足，不能反审核折让调整单");
				}
				
				
				BigDecimal addAmount = billInfo.getAddAmount();
				if(addAmount != null){
					if(addAmount.compareTo(BigDecimal.ZERO) > 0){
						// 减少余额
						SaleDiscountFacadeFactory.getLocalInstance(ctx).updateCustomerBalance(billInfo.getCompany().getId().toString(),
								billInfo.getCustomer().getId().toString(),
								addAmount, 
								null);
					
					}else{
						// 增加余额
						addAmount = addAmount.abs();
						// 增加余额
						SaleDiscountFacadeFactory.getLocalInstance(ctx).updateCustomerBalance(billInfo.getCompany().getId().toString(),
								billInfo.getCustomer().getId().toString(),
								null, 
								addAmount);
					}
				}
				// 减少余额
				SaleDiscountFacadeFactory.getLocalInstance(ctx).updateCustomerBalance(billInfo.getCompany().getId().toString(),
						billInfo.getCustomer().getId().toString(),
						billInfo.getAddAmount(),
						null
						);
			}else{
				throw new BOSException("不存在对应客户的余额信息");
			}
		}else{
			throw new FarmException("只能反审核审核状态的单据");
		}
	}
}