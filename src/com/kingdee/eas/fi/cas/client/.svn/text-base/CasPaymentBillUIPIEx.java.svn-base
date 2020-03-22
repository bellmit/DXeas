package com.kingdee.eas.fi.cas.client;

import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.util.ArrayList;

import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.bot.BOTRelationEntryFactory;
import com.kingdee.bos.metadata.bot.BOTRelationFactory;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;
import com.kingdee.eas.farm.stocking.processbizill.TheLifeFeeOfFemaleDuckFactory;
import com.kingdee.eas.farm.stocking.processbizill.TheLifeFeeOfFemaleDuckInfo;
import com.kingdee.eas.fi.cas.BillStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * 出纳管理编辑界面扩展
 * @author USER
 *
 */
public class CasPaymentBillUIPIEx extends CasPaymentBillUI {

	private static final String TheLifeFeeOfFemaleDuckInfo = null;

	public CasPaymentBillUIPIEx() throws Exception {
		super();

	}

	@Override
	public void actionTDPrint_actionPerformed(ActionEvent e) throws Exception {

		if(this.editData != null && this.editData.getId() != null ){

			BillStatusEnum currStatus = this.editData.getBillStatus();

			if(BillStatusEnum.SAVE.equals(currStatus) || BillStatusEnum.SUBMIT.equals(currStatus)){
				MsgBox.showInfo("不能打印保存或者提交状态的付款单");
				SysUtil.abort();
			}
			// 只有审核或者更高级的状态可以打印
			super.actionTDPrint_actionPerformed(e);
		}

	}

	@Override
	public void actionTDPrintView_actionPerformed(ActionEvent e)
	throws Exception {

		if(this.editData != null && this.editData.getId() != null ){

			BillStatusEnum currStatus = this.editData.getBillStatus();

			if(BillStatusEnum.SAVE.equals(currStatus) || BillStatusEnum.SUBMIT.equals(currStatus)){
				MsgBox.showInfo("不能打印保存或者提交状态的付款单");
				SysUtil.abort();
			}
			// 只有审核或者更高级的状态可以打印
			super.actionTDPrintView_actionPerformed(e);
		}
	}
	@Override
	public void actionSubmit_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		super.actionSubmit_actionPerformed(arg0);
		if(editData.getString("id")!=null){
			ArrayList coll = BOTRelationFactory.getRemoteInstance().getSrcObjIdBySrcType(editData.getString("id"), "56FE1CDA");
			if(coll.size()>0){
				TheLifeFeeOfFemaleDuckInfo theLifeFeeOfFemaleDuckInfo=TheLifeFeeOfFemaleDuckFactory.getRemoteInstance().getTheLifeFeeOfFemaleDuckInfo(new ObjectUuidPK(coll.get(0).toString()));
				BigDecimal settleAmt = BigDecimal.ZERO;
				for(int i=0;i<theLifeFeeOfFemaleDuckInfo.getEntrys().size();i++){
					settleAmt=settleAmt.add(UIRuleUtil.getBigDecimal(theLifeFeeOfFemaleDuckInfo.getEntrys().get(i).getSettleAmt()));
				}
				CommFacadeFactory.getRemoteInstance().excuteUpdateSql("update T_FM_TheLifeFeeOfFemaleDuck set FSettleAmt="+settleAmt+" where fid='"+theLifeFeeOfFemaleDuckInfo.getString("id")+"'");
			}
		}
	}

	@Override
	public void actionRemove_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		ArrayList coll = BOTRelationFactory.getRemoteInstance().getSrcObjIdBySrcType(editData.getString("id"), "56FE1CDA");
		super.actionRemove_actionPerformed(arg0);
		if(editData.getString("id")!=null){
			if(coll.size()>0){
				TheLifeFeeOfFemaleDuckInfo theLifeFeeOfFemaleDuckInfo=TheLifeFeeOfFemaleDuckFactory.getRemoteInstance().getTheLifeFeeOfFemaleDuckInfo(new ObjectUuidPK(coll.get(0).toString()));
				BigDecimal settleAmt = BigDecimal.ZERO;
				for(int i=0;i<theLifeFeeOfFemaleDuckInfo.getEntrys().size();i++){
					settleAmt=settleAmt.add(UIRuleUtil.getBigDecimal(theLifeFeeOfFemaleDuckInfo.getEntrys().get(i).getSettleAmt()));
				}
				CommFacadeFactory.getRemoteInstance().excuteUpdateSql("update T_FM_TheLifeFeeOfFemaleDuck set FSettleAmt="+settleAmt+" where fid='"+theLifeFeeOfFemaleDuckInfo.getString("id")+"'");
			}
		}
	}


}
