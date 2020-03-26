/**
 * output package name
 */
package com.kingdee.eas.farm.hatch.client;

import java.awt.event.ActionEvent;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.framework.util.KDTableUtil;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.hatch.BEggHatchBillFactory;
import com.kingdee.eas.farm.hatch.BEggHatchBillInfo;
import com.kingdee.eas.farm.hatch.BHatchBabyBillFactory;
import com.kingdee.eas.farm.hatch.BHatchBabyBillInfo;
import com.kingdee.eas.farm.hatch.HatchBaseDataCollection;
import com.kingdee.eas.farm.hatch.HatchBaseDataFactory;
import com.kingdee.eas.farm.hatch.IBEggHatchBill;
import com.kingdee.eas.farm.hatch.IBHatchBabyBill;
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
public class BHatchBabyBillListUI extends AbstractBHatchBabyBillListUI
{
	private static final Logger logger = CoreUIObject.getLogger(BHatchBabyBillListUI.class);

	/**
	 * output class constructor
	 */
	public BHatchBabyBillListUI() throws Exception
	{
		super();
		// 默认 可查询当前组织 及下游组织的  上孵单 上孵单
		//        this.setFilterForQuery(this.getFilterInfo());
		// 图标设置
		this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));
	}
//	/**
//	 * 设置默认过滤条件
//	 * @return
//	 */
//	public FilterInfo getFilterInfo(){
//		FilterInfo filterInfo  = new FilterInfo();
////		AdminOrgUnitInfo currAdminOrg = SysContext.getSysContext().getCurrentAdminUnit();
////
////		filterInfo.getFilterItems().add(new FilterItemInfo("adminOrg.longNumber",currAdminOrg.getLongNumber(),CompareType.LIKE));
//
//
//		return filterInfo;
//	}
//
//
//	/**
//	 * 组织隔离
//	 */
//	@Override
//	protected FilterInfo getDefaultFilterForQuery() {
//		// TODO Auto-generated method stub
//		FilterInfo filter = super.getDefaultFilterForQuery();
//		String mskStr = filter.getMaskString();
//		int size = filter.getFilterItems().size();
//		if(SysContext.getSysContext().getCurrentStorageUnit()!=null){
//			//filter.getFilterItems().add(new FilterItemInfo("storageOrg.name",SysContext.getSysContext().getCurrentStorageUnit().getString("name"),CompareType.EQUALS));
//			//filter.setMaskString("("+mskStr+") and #"+size);
//		}
//		return filter;
//	}

	/**
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
	}


	/**
	 * output actionAudit_actionPerformed
	 */
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception
	{
		checkSelected();

		String[] selIDs = KDTableUtil.getSelectRowFieldValue(this.tblMain, getKeyFieldName());

		if (selIDs == null) {
			handleException(new OrderException(OrderException.ORDER_MUSTSELECT_ONERECORD, new String[] { SaleUtil.getUIResource("OPERATOR_AUDIT") }));
			return;
		}
		SCMClientUtils.checkCurrentBillIsInActiveWorkFlow(selIDs);
		IBHatchBabyBill iBHatchBabyBill = BHatchBabyBillFactory.getRemoteInstance();

		BHatchBabyBillInfo info;
		int num=selIDs.length;
		String error="";
		for (int i = 0;i<selIDs.length; i++) {
			info = iBHatchBabyBill.getBHatchBabyBillInfo(new ObjectUuidPK(selIDs[i]));
			if(!info.getBaseStatus().equals(BillBaseStatusEnum.SUBMITED)){
				error+=info.getString("number")+"\t"+"非提交状态的单据禁止审核"+"\n";
				num--;
				continue;
			}
			iBHatchBabyBill.audit(info);
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

	/**
	 * output actionUnAudit_actionPerformed
	 */
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
	{
		checkSelected();

		String[] selIDs = KDTableUtil.getSelectRowFieldValue(this.tblMain, getKeyFieldName());

		if (selIDs == null) {
			handleException(new OrderException(OrderException.ORDER_MUSTSELECT_ONERECORD, new String[] { SaleUtil.getUIResource("OPERATOR_AUDIT") }));
			return;
		}
		SCMClientUtils.checkCurrentBillIsInActiveWorkFlow(selIDs);
		IBHatchBabyBill iBHatchBabyBill = BHatchBabyBillFactory.getRemoteInstance();

		BHatchBabyBillInfo info;
		int num=selIDs.length;
		String error="";
		for (int i = 0;i<selIDs.length; i++) {
			info = iBHatchBabyBill.getBHatchBabyBillInfo(new ObjectUuidPK(selIDs[i]));
			if(!info.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)){
				error+=info.getString("number")+"\t"+"非审核状态的单据禁止反审核"+"\n";
				num--;
				continue;
			}
			iBHatchBabyBill.unAudit(info);
		}
		try{
			if(num==selIDs.length && num == 1)
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
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.hatch.BHatchBabyBillFactory.getRemoteInstance();
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.hatch.BHatchBabyBillInfo objectValue = new com.kingdee.eas.farm.hatch.BHatchBabyBillInfo();

		return objectValue;
	}
	  /**
     * output actionEdit_actionPerformed
     */
    public void actionEdit_actionPerformed(ActionEvent e) throws Exception
    {
    	if(this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("baseStatus").equals(BillBaseStatusEnum.AUDITED_VALUE)){
			MsgBox.showWarning("单据已审核，禁止编辑！");
			SysUtil.abort();
		}
        super.actionEdit_actionPerformed(e);
    }

}