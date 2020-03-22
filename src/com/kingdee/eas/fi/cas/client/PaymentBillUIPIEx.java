package com.kingdee.eas.fi.cas.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.kingdee.bos.appframework.client.servicebinding.ActionProxyFactory;
import com.kingdee.bos.ui.face.IItemAction;
import com.kingdee.eas.fi.cas.BillStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * ���ɸ�� ��չ
 * @author USER
 *
 */
public class PaymentBillUIPIEx extends PaymentBillUI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3443835937878976962L;

	public PaymentBillUIPIEx() throws Exception {
		super();
		
	}
	
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
	}

	/**
	 * ����ִ��ǰ����
	 */
	public void beforeActionPerformed(ActionEvent e){
		
		super.beforeActionPerformed(e);
		
		if("print".equals(e.getActionCommand())){
			
		}
		
	}
	
	@Override
	protected void invokeMultiPrintFunction(boolean isPrint) throws Exception {
		if(this.editData != null && this.editData.getId() != null ){
			
			BillStatusEnum currStatus = this.editData.getBillStatus();
			
			if(BillStatusEnum.SAVE.equals(currStatus) || BillStatusEnum.SUBMIT.equals(currStatus)){
				MsgBox.showInfo("���ܴ�ӡ��������ύ״̬�ĸ��");
				SysUtil.abort();
			}
		
		}
		super.invokeMultiPrintFunction(isPrint);
	}
	@Override
	public void actionPrint_actionPerformed(ActionEvent e) throws Exception {

		if(this.editData != null && this.editData.getId() != null ){
			
			BillStatusEnum currStatus = this.editData.getBillStatus();
			
			if(BillStatusEnum.SAVE.equals(currStatus) || BillStatusEnum.SUBMIT.equals(currStatus)){
				MsgBox.showInfo("���ܴ�ӡ��������ύ״̬�ĸ��");
				SysUtil.abort();
			}
			// ֻ����˻��߸��߼���״̬���Դ�ӡ
			super.actionPrint_actionPerformed(e);
		}
	}

	@Override
	public void actionPrintPreview_actionPerformed(ActionEvent e)
			throws Exception {

		if(this.editData != null && this.editData.getId() != null ){
			
			BillStatusEnum currStatus = this.editData.getBillStatus();
			
			if(BillStatusEnum.SAVE.equals(currStatus) || BillStatusEnum.SUBMIT.equals(currStatus)){
				MsgBox.showInfo("���ܴ�ӡ��������ύ״̬�ĸ��");
				SysUtil.abort();
			}
			// ֻ����˻��߸��߼���״̬���Դ�ӡ
			super.actionPrintPreview_actionPerformed(e);
		}
	}

}
