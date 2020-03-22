/**
 * output package name
 */
package com.kingdee.eas.farm.hatch.client;

import java.awt.event.*;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.framework.util.KDTableUtil;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.hatch.BEggHatchBillFactory;
import com.kingdee.eas.farm.hatch.BEggHatchBillInfo;
import com.kingdee.eas.farm.hatch.BEggTrayingBillFactory;
import com.kingdee.eas.farm.hatch.BEggTrayingBillInfo;
import com.kingdee.eas.farm.hatch.HatchBaseDataCollection;
import com.kingdee.eas.farm.hatch.HatchBaseDataFactory;
import com.kingdee.eas.farm.hatch.IBEggHatchBill;
import com.kingdee.eas.farm.hatch.IBEggTrayingBill;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.client.SCMClientUtils;
import com.kingdee.eas.scm.sd.sale.OrderException;
import com.kingdee.eas.scm.sd.sale.util.SaleUtil;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.util.NumericExceptionSubItem;

/**
 * output class name
 */
public class BEggTrayingBillListUI extends AbstractBEggTrayingBillListUI
{
	private static final Logger logger = CoreUIObject.getLogger(BEggTrayingBillListUI.class);

	/**
	 * output class constructor
	 */
	public BEggTrayingBillListUI() throws Exception
	{
		super();
	}

	/**
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
	}



	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		checkSelected();

		String[] selIDs = KDTableUtil.getSelectRowFieldValue(this.tblMain, getKeyFieldName());

		if (selIDs == null) {
			handleException(new OrderException(OrderException.ORDER_MUSTSELECT_ONERECORD, new String[] { SaleUtil.getUIResource("OPERATOR_AUDIT") }));
			return;
		}
		SCMClientUtils.checkCurrentBillIsInActiveWorkFlow(selIDs);
		IBEggTrayingBill iBEggTrayingBill = BEggTrayingBillFactory.getRemoteInstance();

		BEggTrayingBillInfo info;
		int num=selIDs.length;
		String error="";
		for (int i = 0;i<selIDs.length; i++) {
			info = iBEggTrayingBill.getBEggTrayingBillInfo(new ObjectUuidPK(selIDs[i]));
			if(!info.getBaseStatus().equals(BillBaseStatusEnum.SUBMITED)){
				error+=info.getString("number")+"\t"+"非提交状态的单据禁止审核"+"\n";
				num--;
				continue;
			}
			iBEggTrayingBill.audit(info);
		}
		try{
			if(num==selIDs.length&&num==1)
				MsgBox.showInfo("审核成功");
			else if(num==selIDs.length)
				MsgBox.showInfo("审核成功(操作单子数:"+selIDs.length+")");
			else if(num==0&&selIDs.length==1)
				MsgBox.showInfo("审核失败");
			else if(num==0)
				MsgBox.showInfo("审核失败,没有符合审核条件的单子");
			else{
				throw new EASBizException(new NumericExceptionSubItem("","操作完成但存在异常，共有"+num+"张单子审核完成\n"+error));
			}
		}
		finally{
			refreshList();
		}

		//		super.actionAudit_actionPerformed(e);



	}

	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		checkSelected();

		String[] selIDs = KDTableUtil.getSelectRowFieldValue(this.tblMain, getKeyFieldName());

		if (selIDs == null) {
			handleException(new OrderException(OrderException.ORDER_MUSTSELECT_ONERECORD, new String[] { SaleUtil.getUIResource("OPERATOR_AUDIT") }));
			return;
		}
		SCMClientUtils.checkCurrentBillIsInActiveWorkFlow(selIDs);
		IBEggTrayingBill iBEggHatchBill = BEggTrayingBillFactory.getRemoteInstance();

		BEggTrayingBillInfo info;
		int num=selIDs.length;
		String error="";
		for (int i = 0;i<selIDs.length; i++) {
			info = iBEggHatchBill.getBEggTrayingBillInfo(new ObjectUuidPK(selIDs[i]));
			if(!info.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)){
				error+=info.getString("number")+"\t"+"非审核状态的单据禁止反审核"+"\n";
				num--;
				continue;
			}
			iBEggHatchBill.unAudit(info);
		}
		try{
			if(num==selIDs.length&&num==1)
				MsgBox.showInfo("反审核成功");
			else if(num==selIDs.length)
				MsgBox.showInfo("反审核成功(操作单子数:"+selIDs.length+")");
			else if(num==0&&selIDs.length==1)
				MsgBox.showInfo("反审核失败");
			else if(num==0)
				MsgBox.showInfo("反审核失败,没有符合反审核条件的单子");
			else{
				throw new EASBizException(new NumericExceptionSubItem("","操作完成但存在异常，共有"+num+"张单子反审核完成\n"+error));
			}
		}
		finally{
			refreshList();
		}

		//		super.actionAudit_actionPerformed(e);



	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		// 图标设置
		this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));
	}

	/**
	 * output actionTDPrint_actionPerformed
	 */
	public void actionTDPrint_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionTDPrint_actionPerformed(e);
	}
//	/**
//	 * 组织隔离
//	 */
//	@Override
//	protected FilterInfo getDefaultFilterForQuery() {
//		// TODO Auto-generated method stub
//		FilterInfo filterInfo  = new FilterInfo();
//		AdminOrgUnitInfo currAdminOrg = SysContext.getSysContext().getCurrentAdminUnit();
//
//		filterInfo.getFilterItems().add(new FilterItemInfo("adminOrg.longNumber",currAdminOrg.getLongNumber(),CompareType.LIKE));
//
//
//		return filterInfo;
//	}

	/**
	 * output actionTDPrintPreview_actionPerformed
	 */
	public void actionTDPrintPreview_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionTDPrintPreview_actionPerformed(e);
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.hatch.BEggTrayingBillFactory.getRemoteInstance();
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.hatch.BEggTrayingBillInfo objectValue = new com.kingdee.eas.farm.hatch.BEggTrayingBillInfo();

		return objectValue;
	}
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception
    {
    	if(this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("baseStatus").equals(BillBaseStatusEnum.AUDITED_VALUE)){
			MsgBox.showWarning("单据已审核，禁止编辑！");
			SysUtil.abort();
		}
        super.actionEdit_actionPerformed(e);
    }

}