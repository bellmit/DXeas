package com.kingdee.eas.fi.cas.client;

import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.bot.BOTRelationFactory;
import com.kingdee.bos.metadata.bot.IBOTRelation;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;
import com.kingdee.eas.farm.stocking.processbizill.ITheLifeFeeOfFemaleDuck;
import com.kingdee.eas.farm.stocking.processbizill.TheLifeFeeOfFemaleDuckFactory;
import com.kingdee.eas.farm.stocking.processbizill.TheLifeFeeOfFemaleDuckInfo;
import com.kingdee.eas.fi.cas.BillStatusEnum;
import com.kingdee.eas.fi.cas.IPaymentBill;
import com.kingdee.eas.fi.cas.PaymentBillInfo;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * 出纳管理付款单叙事簿扩展
 * @author USER
 *
 */
public class CasPaymentBillListUIPIEx extends CasPaymentBillListUI{

	public CasPaymentBillListUIPIEx() throws Exception {
		super();
		// TODO Auto-generated constructor stub
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


	@SuppressWarnings("unchecked")
	@Override
	public void actionRemove_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		ArrayList selectedIdValues = this.getSelectedIdValues();
		IBOTRelation remoteInstance = BOTRelationFactory.getRemoteInstance();
		ArrayList<String> colls=new ArrayList<String>();
		for(int j=0;j<selectedIdValues.size();j++){
			ArrayList coll = remoteInstance.getSrcObjIdBySrcType(selectedIdValues.get(j).toString(), "56FE1CDA");
			if(coll.size()>0)
				if(!colls.contains(coll.get(0).toString()))
					colls.add(coll.get(0).toString());
		}
		super.actionRemove_actionPerformed(arg0);


		TheLifeFeeOfFemaleDuckInfo theLifeFeeOfFemaleDuckInfo;
		BigDecimal settleAmt = BigDecimal.ZERO;
		ITheLifeFeeOfFemaleDuck remoteInstance2 = TheLifeFeeOfFemaleDuckFactory.getRemoteInstance();
		for(int j=0;j<colls.size();j++){
			if(colls.size()>0){
				theLifeFeeOfFemaleDuckInfo=remoteInstance2.getTheLifeFeeOfFemaleDuckInfo(new ObjectUuidPK(colls.get(0).toString()));
				settleAmt = BigDecimal.ZERO;
				for(int i=0;i<theLifeFeeOfFemaleDuckInfo.getEntrys().size();i++){
					settleAmt=settleAmt.add(UIRuleUtil.getBigDecimal(theLifeFeeOfFemaleDuckInfo.getEntrys().get(i).getSettleAmt()));
				}
				CommFacadeFactory.getRemoteInstance().excuteUpdateSql("update T_FM_TheLifeFeeOfFemaleDuck set FSettleAmt="+settleAmt+" where fid='"+theLifeFeeOfFemaleDuckInfo.getString("id")+"'");
			}
		}
	}

}
