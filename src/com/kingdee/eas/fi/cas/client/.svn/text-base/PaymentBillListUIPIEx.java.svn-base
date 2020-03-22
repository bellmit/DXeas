package com.kingdee.eas.fi.cas.client;

import java.awt.event.ActionEvent;
import java.util.List;

import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.fi.cas.BillStatusEnum;
import com.kingdee.eas.fi.cas.IPaymentBill;
import com.kingdee.eas.fi.cas.PaymentBillInfo;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * 出纳付款单叙事簿扩展
 * @author USER
 *
 */
public class PaymentBillListUIPIEx extends PaymentBillListUI {

	public PaymentBillListUIPIEx() throws Exception {
		super();
		
	}


	@Override
	public void actionTDPrint_actionPerformed(ActionEvent e) throws Exception {

		List selIDs = this.getSelectedIdValues();
		IPaymentBill paymentBill = (IPaymentBill) super.getBizInterface();
		for(int i = 0; i < selIDs.size(); i++){
			
			PaymentBillInfo editData = paymentBill.getPaymentBillInfo(new ObjectUuidPK(selIDs.get(i).toString()));
			if(editData != null && editData.getId() != null ){
				
				BillStatusEnum currStatus = editData.getBillStatus();
				
				if(BillStatusEnum.SAVE.equals(currStatus) || BillStatusEnum.SUBMIT.equals(currStatus)){
					MsgBox.showInfo("不能打印保存或者提交状态的付款单");
					SysUtil.abort();
				}
				
			}

		}
		
		// 只有审核或者更高级的状态可以打印
		super.actionTDPrint_actionPerformed(e);
	}

	@Override
	public void actionMultiPrint_actionPerformed(ActionEvent e) throws Exception {

		List selIDs = this.getSelectedIdValues();
		IPaymentBill paymentBill = (IPaymentBill) super.getBizInterface();
		for(int i = 0; i < selIDs.size(); i++){
			
			PaymentBillInfo editData = paymentBill.getPaymentBillInfo(new ObjectUuidPK(selIDs.get(i).toString()));
			if(editData != null && editData.getId() != null ){
				
				BillStatusEnum currStatus = editData.getBillStatus();
				
				if(BillStatusEnum.SAVE.equals(currStatus) || BillStatusEnum.SUBMIT.equals(currStatus)){
					MsgBox.showInfo("不能打印保存或者提交状态的付款单");
					SysUtil.abort();
				}
				
			}

		}
		
		// 只有审核或者更高级的状态可以打印
		super.actionMultiPrint_actionPerformed(e);
	}
	@Override
	public void actionTDPrintView_actionPerformed(ActionEvent e)
			throws Exception {

		List selIDs = this.getSelectedIdValues();
		IPaymentBill paymentBill = (IPaymentBill) super.getBizInterface();
		for(int i = 0; i < selIDs.size(); i++){
			
			PaymentBillInfo editData = paymentBill.getPaymentBillInfo(new ObjectUuidPK(selIDs.get(i).toString()));
			if(editData != null && editData.getId() != null ){
				
				BillStatusEnum currStatus = editData.getBillStatus();
				
				if(BillStatusEnum.SAVE.equals(currStatus) || BillStatusEnum.SUBMIT.equals(currStatus)){
					MsgBox.showInfo("不能打印保存或者提交状态的付款单");
					SysUtil.abort();
				}
				
			}

		}
		
		// 只有审核或者更高级的状态可以打印
		super.actionTDPrintView_actionPerformed(e);
	}
	
	@Override
	public void actionMultiPrintPreview_actionPerformed(ActionEvent e)
			throws Exception {

		List selIDs = this.getSelectedIdValues();
		IPaymentBill paymentBill = (IPaymentBill) super.getBizInterface();
		for(int i = 0; i < selIDs.size(); i++){
			
			PaymentBillInfo editData = paymentBill.getPaymentBillInfo(new ObjectUuidPK(selIDs.get(i).toString()));
			if(editData != null && editData.getId() != null ){
				
				BillStatusEnum currStatus = editData.getBillStatus();
				
				if(BillStatusEnum.SAVE.equals(currStatus) || BillStatusEnum.SUBMIT.equals(currStatus)){
					MsgBox.showInfo("不能打印保存或者提交状态的付款单");
					SysUtil.abort();
				}
				
			}

		}
		
		// 只有审核或者更高级的状态可以打印
		super.actionMultiPrintPreview_actionPerformed(e);
	}

}
