package com.kingdee.eas.farm.feedfactory.app;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.feedfactory.QualityCheckBillFactory;
import com.kingdee.eas.farm.feedfactory.QualityCheckBillInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.sm.pur.PurOrderEntryCollection;
import com.kingdee.eas.scm.sm.pur.PurOrderEntryInfo;
import com.kingdee.eas.scm.sm.pur.PurOrderInfo;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.AppCommon;
import com.kingdee.eas.wlhlcomm.FarmException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class QualityCheckBillControllerBean extends AbstractQualityCheckBillControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.feedfactory.app.QualityCheckBillControllerBean");
    
    
    
    

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// ״̬����Ϊ����
		QualityCheckBillInfo info =  (QualityCheckBillInfo)model;
		if(!BillBaseStatusEnum.TEMPORARILYSAVED.equals(info.getBaseStatus()) &&
				!BillBaseStatusEnum.ADD.equals(info.getBaseStatus())	&&
				info.getBaseStatus() != null){
			throw new EASBizException(new NumericExceptionSubItem("001","ֻ�ܱ����ݴ��������״̬�ĵ���"));
			
		}
		info.setBaseStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		// ���µ���
		info = updatePrice(ctx,info);
		
		return super._save(ctx, model);
	}
	/**
	 * ���µ���
	 * @param ctx
	 * @param info
	 * @throws BOSException 
	 */
	private QualityCheckBillInfo updatePrice(Context ctx,QualityCheckBillInfo info) throws BOSException{
		if(info != null && info.getTakeOffPrice() != null){
			BigDecimal takeOffPrice = info.getTakeOffPrice();
			// ������� �ۼ�
	    	BigDecimal takeOffBasePrice = takeOffPrice.divide(new BigDecimal("1000"),6, RoundingMode.HALF_UP);
	    	info.setTakeOffBasePrice(takeOffBasePrice);
	    	
	    	// ����ۼۺ� �����۸�
	    	BigDecimal priceBeforeTakeOff = info.getPriceBeforeTakeOff();
	    	if(priceBeforeTakeOff != null){
	    		BigDecimal priceAfterTakeoff = priceBeforeTakeOff.subtract(takeOffBasePrice);
	    		info.setPriceAfterTakeOff(priceAfterTakeoff);
	    		if(priceAfterTakeoff.compareTo(new BigDecimal("0")) <= 0){
	    			
	    			throw new BOSException("�ۼۺ󵥼۲���С��0");
	    			
	    		}
	    	}
	    	
		}
		
		return info;
	}
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {
		QualityCheckBillInfo info =  QualityCheckBillFactory.getLocalInstance(ctx).getQualityCheckBillInfo(pk);
		if(!BillBaseStatusEnum.TEMPORARILYSAVED.equals(info.getBaseStatus()) &&
				!BillBaseStatusEnum.ADD.equals(info.getBaseStatus())	&& 
				!BillBaseStatusEnum.SUBMITED.equals(info.getBaseStatus())){
			throw new EASBizException(new NumericExceptionSubItem("001","ֻ��ɾ���ݴ��������״̬�ĵ���"));
			
		}
		super._delete(ctx, pk);
	}
	
	/**
	 * �ύ
	 */
	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		QualityCheckBillInfo billInfo = (QualityCheckBillInfo)model;
    	if(billInfo != null  && 
    			(BillBaseStatusEnum.ADD.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.TEMPORARILYSAVED.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus()) || 
    						billInfo.getBaseStatus() == null)){
    		billInfo.setBaseStatus( BillBaseStatusEnum.SUBMITED);
    		
    		// ���µ���
    		billInfo = updatePrice(ctx,billInfo);
    		
    		return super._submit(ctx, model);
    	}else{
    		throw new EASBizException(new NumericExceptionSubItem("001","ֻ���ύ�����򱣴�״̬�ĵ���"));
			
    	}
	}
	/**
     * ���
     */
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		QualityCheckBillInfo billInfo = (QualityCheckBillInfo)model;
		
		if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus())){
			
			try {
				billInfo = this.getQualityCheckBillInfo(ctx, new ObjectUuidPK(billInfo.getId()));
//				boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
//				if(exist){
//					throw new FarmException("�Ѿ��������ε��ݣ��������");
//				}
				
//				// ���µ���
//	    		billInfo = updatePrice(ctx,billInfo);
	    		
//	    		// ���¶����ͳ��ⵥ �ۼ�
				//updatePurOrder(ctx,billInfo,false);
	    		// ������º�ĵ���
				super._save(ctx,billInfo);
			} catch (EASBizException e) {
				
				e.printStackTrace();
				throw new BOSException(e);
			}
			// ���µ���״̬
			AppCommon.updateModelStatus(ctx, "CT_FM_QualityCheckBill", billInfo.getId().toString(), BillBaseStatusEnum.AUDITED);
			
		}else{
			throw new FarmException("ֻ������ύ״̬�ĵ���");
		}
		
		
	}

	/**
	 * ���� �ʼ쵥  ��Ӧ�ɹ�����
	 * @throws BOSException 
	 */
	private void updatePurOrder(Context ctx, QualityCheckBillInfo billInfo,boolean isRemove) throws BOSException{
		// �ʼ쵥 ��Ϊ �� ʱ
		if(billInfo != null ){
			if(!isRemove){
				PurOrderInfo purorderInfo = billInfo.getPurOrder();
				
				BigDecimal takeOffBasePrice = billInfo.getRealAmount().setScale(2, BigDecimal.ROUND_HALF_UP);
				BigDecimal priceAfterTakeOff = billInfo.getPriceAfterTakeOff();
				BigDecimal priceBeforeTakeOff = billInfo.getPriceBeforeTakeOff();
				try{
					// �ɹ����� 
					if(purorderInfo != null){
						String upsql = "update T_SM_PurOrderEntry set cfoldBasePrice = ?,cfbasePriceAfterTakeOff=?,cfrealamount=? where fparentid=? and fseq = 1 ";
						String upsqls = "update T_SM_PurOrder set cfishasqcbill = 1 where fid=? ";
						Object[] args = {priceBeforeTakeOff,priceAfterTakeOff,takeOffBasePrice,purorderInfo.getId().toString()};
						Object[] argss = {purorderInfo.getId().toString()};
						DbUtil.execute(ctx, upsql, args);
						DbUtil.execute(ctx, upsqls, argss);

						// ��ѯ�Ƿ��Ѿ����� �ɹ���ⵥ������Ѿ����� �� ���� �ɹ���ⵥ ��Ӧ�ֶ�ֵ
						String ssql = "select fdestobjectid from t_bot_relation where fsrcobjectid=? and fdestentityid = ? and fsrcentityid=? ";
						Object[] sargs = {purorderInfo.getId().toString(),"783061E3","3171BFAD"};
						IRowSet rs = DbUtil.executeQuery(ctx, ssql, sargs);
						
						if(rs.next()){
							String purinhouseBillID = rs.getString("fdestobjectid");
							// ������ⵥ���з�¼��  �ۼ�
							String upPursql = "update T_IM_PurInWarehsEntry set cfRealAmount = ? where fparentid=? and fseq = 1 ";
							String upPursqls = "update T_IM_PurInWarehsBill set cfisQC = 1 where fid=? ";
							Object[] purargs = {takeOffBasePrice,purinhouseBillID};
							Object[] purargss = {purinhouseBillID};
							DbUtil.execute(ctx, upPursql, purargs);
							DbUtil.execute(ctx, upPursqls, purargss);
						}
					}
			
				}catch(SQLException sqle){
					sqle.printStackTrace();
					throw new BOSException(sqle);
				}
			}else{
				PurOrderInfo purorderInfo = billInfo.getPurOrder();
				
				
				try{
					// �ɹ����� 
					if(purorderInfo != null){
						String upsql = "update T_SM_PurOrderEntry set cfoldBasePrice=0,cfbasePriceAfterTakeOff=0,cfrealamount=0 where fparentid=? ";
						String upsqls = "update T_SM_PurOrder set cfishasqcbill = 0 where fid=? ";
						Object[] args = {purorderInfo.getId().toString()};
						Object[] argss = {purorderInfo.getId().toString()};
						DbUtil.execute(ctx, upsql, args);
						DbUtil.execute(ctx, upsqls,args);
						
						
						// ��ѯ�Ƿ��Ѿ����� �ɹ���ⵥ������Ѿ����� �� ���� �ɹ���ⵥ ��Ӧ�ֶ�ֵ
						String ssql = "select fdestobjectid from t_bot_relation where fsrcobjectid=? and fdestentityid = ? and fsrcentityid=? ";
						Object[] sargs = {purorderInfo.getId().toString(),"783061E3","3171BFAD"};
						IRowSet rs = DbUtil.executeQuery(ctx, ssql, sargs);
						
						if(rs.next()){
							String purinhouseBillID = rs.getString("fdestobjectid");
							// ɾ����ⵥ���з�¼��  �ۼ�
							String upPursql = "update T_IM_PurInWarehsEntry set cfRealAmount = 0 where fparentid=? ";
							String upPursqls = "update T_IM_PurInWarehsBill set cfisQC = 0 where fid=? ";
							Object[] purargs = {purinhouseBillID};
							DbUtil.execute(ctx, upPursql, purargs);
							DbUtil.execute(ctx, upPursqls,purargs);
						}
					}
			
				}catch(SQLException sqle){
					sqle.printStackTrace();
					throw new BOSException(sqle);
				}
			}
		}
		
	}
	/**
	 * �����
	 */
	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
			throws BOSException {
		
		QualityCheckBillInfo billInfo = (QualityCheckBillInfo)model;
		
		
		if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.AUDITED.equals(billInfo.getBaseStatus())){
			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				throw new FarmException("�Ѿ��������ε��ݣ����ܷ����");
			}
			// ���¶����ͳ��ⵥ �ۼ�
			//updatePurOrder(ctx,billInfo,true);
			// ���µ���״̬
			AppCommon.updateModelStatus(ctx, "CT_FM_QualityCheckBill", billInfo.getId().toString(), BillBaseStatusEnum.TEMPORARILYSAVED);
			
		}else{
			throw new FarmException("ֻ�ܷ�������״̬�ĵ���");
		}
		
	}

}