package com.kingdee.eas.dep.client;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.ui.face.IUIObject;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.ep.client.UIParam;
import com.kingdee.eas.fi.cas.PaymentBillInfo;
import com.kingdee.eas.fi.cas.PaymentBillTypeInfo;
import com.kingdee.eas.fi.cas.client.CasPaymentBillUI;
import com.kingdee.eas.fi.cas.client.PaymentBillUI;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

/**
 * 付款单扩展类
 * @author USER
 *
 */
public class PaymentBillEditDEP {
	
	
	
	
	/**
	 * 校验 付款类型属于某几个特定类型 的不能保存和提交
	 * @throws BOSException 
	 */
	public String checkPaymenttypes(UIParam param,PaymentBillInfo billInfo) throws BOSException{
		
		try{
			// 有id的 先查询是否有上游单据，如果有上游单据 那么不校验，如果没有则校验单据状态
			if(billInfo  != null && billInfo.getId() != null){
				
				StringBuilder sb = new StringBuilder();
				sb.append("select t.fid from t_bot_relation t where FDestObjectID='");
				sb.append(billInfo.getId());
				sb.append("'");
				
				IRowSet rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
				if(rs.next()){
					return "";
				}
			}
//			prmtPayType
			
			// 没有上有单据的 付款单则验证特定付款类型的 不能提交或者保存
			KDBizPromptBox prmtPayType =  param.getKDBizPromptBox("f7PayBillType");
			if(prmtPayType == null){
				prmtPayType =  param.getKDBizPromptBox("prmtPayType");
			}
			if(prmtPayType == null){
				return "";
			}
			PaymentBillTypeInfo paymentbillTypeInfo = (PaymentBillTypeInfo)prmtPayType .getValue();
//			billInfo.getPayBillType();
			
			if(paymentbillTypeInfo != null && paymentbillTypeInfo.getId() != null){
				StringBuilder sb = new StringBuilder();
				sb.append("select 1 from T_CAS_PaymentBillType where  cfcanmanul = 1 and fid='");
				sb.append(paymentbillTypeInfo.getId().toString());
				sb.append("'");
				
				IRowSet rs1 = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
				if(rs1.next()){
					return "";
				}else{
					
					return "对应付款类型不应手工做付款单,请重新选择";
				}
				
			}
			
			return "";
		}catch(Exception e){
			throw new BOSException(e);
		}
			
		
	}
}