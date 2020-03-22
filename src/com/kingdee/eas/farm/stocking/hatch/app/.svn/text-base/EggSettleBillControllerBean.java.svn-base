package com.kingdee.eas.farm.stocking.hatch.app;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.stocking.hatch.EggReceiveBillEntryCollection;
import com.kingdee.eas.farm.stocking.hatch.EggReceiveBillEntryFactory;
import com.kingdee.eas.farm.stocking.hatch.EggReceiveBillEntryInfo;
import com.kingdee.eas.farm.stocking.hatch.EggSettleBillFactory;
import com.kingdee.eas.farm.stocking.hatch.EggSettleBillInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.util.NumericExceptionSubItem;

public class EggSettleBillControllerBean extends AbstractEggSettleBillControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.stocking.hatch.app.EggSettleBillControllerBean");
	protected void _audit(Context ctx, IObjectValue model)throws BOSException
	{
		try {
			EggSettleBillInfo info = (EggSettleBillInfo) model;

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
			EggSettleBillInfo info = (EggSettleBillInfo) model;

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
		EggSettleBillInfo info = (EggSettleBillInfo) model;
		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)) {
			info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		}

		if(info.getAmount()==null){
			BigDecimal amt=BigDecimal.ZERO;
			for(int i=0;i<info.getEntrys().size();i++){
				amt=amt.add(info.getEntrys().get(i).getAmount()==null?BigDecimal.ZERO:info.getEntrys().get(i).getAmount());
			}
			info.setAmount(amt);
		}
		return super._save(ctx, info);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		EggSettleBillInfo info = (EggSettleBillInfo) model;
		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)||info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)) {
			info.setBillStatus(BillBaseStatusEnum.SUBMITED);
		}
		if(info.getAmount()==null){
			BigDecimal amt=BigDecimal.ZERO;
			for(int i=0;i<info.getEntrys().size();i++){
				amt=amt.add(info.getEntrys().get(i).getAmount()==null?BigDecimal.ZERO:info.getEntrys().get(i).getAmount());
			}
			info.setAmount(amt);
		}
		return super._submit(ctx, info);
	}
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		EggSettleBillInfo info = EggSettleBillFactory.getLocalInstance(ctx).getEggSettleBillInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据已经审核，禁止删除！"));
		}
		super._delete(ctx, pk);

		EggReceiveBillEntryInfo entryInfo;
		EggReceiveBillEntryCollection coll = EggReceiveBillEntryFactory.getLocalInstance(ctx).getEggReceiveBillEntryCollection("where settleBillID='"+pk.toString()+"'");
		for(int i=0;i<coll.size();i++){
			entryInfo = coll.get(i);
			entryInfo.setSettleBillID(null);
			entryInfo.setIsExistDownBill(false);
			EggReceiveBillEntryFactory.getLocalInstance(ctx).save(entryInfo);
		}
//		if(coll.size()>0){
//			EggReceiveBillEditUI ui;
//			try {
//				ui = new EggReceiveBillEditUI();
//				refreshCurPage(ui, coll.get(0).getParent());
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	}
	protected void _showPriceCol(Context ctx, IObjectValue model)throws BOSException
	{
	}
	/**
	 * 执行结算
	 * @throws EASBizException 
	 */
	protected void _exeSettle(Context ctx, IObjectValue model)throws BOSException, EASBizException
	{
		model=(IObjectValue) new StockingHatchFacadeControllerBean()._exeEggSettle(ctx, model);
		super._save(ctx, model);
	}
//	protected void refreshCurPage(EggReceiveBillEditUI ui, EggReceiveBillInfo editDate){
//
//		try {    
//			ObjectUuidPK pk = new ObjectUuidPK(editDate.getId());       //使用反射技术访问受保护的方法 , 因为在editUI中getValue是protected类型
//
//			/**   
//			 * 使用反射技术获取父类的方法   
//			 * 1、先获取自己的字节码对象： Class clazz=ui.getClass();   
//			 * 2、获取父类的字节码对象： =clazz.getSuperclass();   
//			 */    
//
//			Method m = null;    
//			Class clazz=ui.getClass();    
//			while(true){    
//				try {    
//					m=clazz.getDeclaredMethod("getValue", new Class[]{IObjectPK.class});    
//					break;    
//				} catch (NoSuchMethodException e) {    
//					clazz=clazz.getSuperclass();    
//				}    
//			}    
//			m.setAccessible(true);    
//			IObjectValue objValue=(IObjectValue) m.invoke(ui, new Object[]{pk});    
//			ui.setDataObject(objValue);    
//			ui.loadFields();    
//			ui.getUIContext().put("ID", pk);    
//			ui.getUIContext().put("InitDataObject", objValue);    
//		} catch (Exception e) {    
//			ui.handUIException(e);    
//		}    
//	}

	@Override
	protected void _batchSubmit(Context ctx, IObjectValue model)
			throws BOSException {
		// TODO Auto-generated method stub
		
	}
}