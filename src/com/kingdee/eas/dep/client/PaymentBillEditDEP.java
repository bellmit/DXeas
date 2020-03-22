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
 * �����չ��
 * @author USER
 *
 */
public class PaymentBillEditDEP {
	
	
	
	
	/**
	 * У�� ������������ĳ�����ض����� �Ĳ��ܱ�����ύ
	 * @throws BOSException 
	 */
	public String checkPaymenttypes(UIParam param,PaymentBillInfo billInfo) throws BOSException{
		
		try{
			// ��id�� �Ȳ�ѯ�Ƿ������ε��ݣ���������ε��� ��ô��У�飬���û����У�鵥��״̬
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
			
			// û�����е��ݵ� �������֤�ض��������͵� �����ύ���߱���
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
					
					return "��Ӧ�������Ͳ�Ӧ�ֹ������,������ѡ��";
				}
				
			}
			
			return "";
		}catch(Exception e){
			throw new BOSException(e);
		}
			
		
	}
}