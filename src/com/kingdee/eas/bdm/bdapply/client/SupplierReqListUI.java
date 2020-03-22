/**
 * output package name
 */
package com.kingdee.eas.bdm.bdapply.client;

import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.data.SortType;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.bos.ctrl.kdf.table.event.KDTDataFillListener;
import com.kingdee.bos.ctrl.kdf.table.event.KDTDataRequestEvent;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.IQueryExecutor;
import com.kingdee.eas.base.commonquery.client.CommonQueryDialog;
import com.kingdee.eas.base.core.util.KDTableUtil;
import com.kingdee.eas.bdm.bdapply.SupplierReqFactory;
import com.kingdee.eas.bdm.bdapply.SupplierReqInfo;
import com.kingdee.eas.bdm.bdapply.ISupplierReq;
import com.kingdee.eas.bdm.bdapply.bdaApplyBillStatus;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.client.SCMClientUtils;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class SupplierReqListUI extends AbstractSupplierReqListUI
{
	private static final Logger logger = CoreUIObject.getLogger(SupplierReqListUI.class);
	private static final Color APPROVEColor = new Color(252, 255, 206);
	/**
	 * output class constructor
	 */
	public SupplierReqListUI() throws Exception
	{
		super();
		this.tblMain.addKDTDataFillListener(new KDTDataFillListener(){
			public void afterDataFill(KDTDataRequestEvent e) {
				setBackGround();
			}
		});
		this.btnAllAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
	}

	/**
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.bdm.bdapply.SupplierReqFactory.getRemoteInstance();
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.bdm.bdapply.SupplierReqInfo objectValue = new com.kingdee.eas.bdm.bdapply.SupplierReqInfo();

		return objectValue;
	}

	public void actionAllAudit_actionPerformed(ActionEvent e) throws Exception {
		checkSelected();
		String currentCompanyId = SysContext.getSysContext().getCurrentFIUnit().getId().toString();
		if (!currentCompanyId.equals("00000000-0000-0000-0000-000000000000CCE7AED4")) {
			MsgBox.showInfo("非集团组织下不允许审核！");
			SysUtil.abort();
		}

		String[] selIDs = KDTableUtil.getSelectRowFieldValue(this.tblMain, getKeyFieldName());

		if (selIDs == null) {
			commUtils.giveUserTipsAndRetire("请选择数据");
			return;
		}
		SCMClientUtils.checkCurrentBillIsInActiveWorkFlow(selIDs);
		ArrayList ids = getSelectedIdValues();
		String number = "";
		SupplierReqInfo info;
		ISupplierReq is = SupplierReqFactory.getRemoteInstance();
		for (int i = 0; i < ids.size(); ++i) {
			if (ids.get(i) == null)
				continue;
			info = is.getSupplierReqInfo(new ObjectUuidPK(ids.get(i).toString()));
			//if (info.getBillStatus().equals(bdaApplyBillStatus.Audit)|| info.getBillStatus().equals(bdaApplyBillStatus.unAudit)) {// 已经审核或审核不通过
			if (!info.getBillStatus().equals(bdaApplyBillStatus.Submit)) {//操作已经提交的单据
				if (StringUtils.isNotBlank(number)) 
					number +=",";
				if (StringUtils.isNotBlank(info.getNumber())) {
					number += info.getNumber();
				}
				else {
					number +="选择的第"+(i+1)+"行";
				}
			} else {
				is.supplierAudit(info);
			}
		}
		if(StringUtils.isBlank(number)){
			MsgBox.showInfo("批量审核成功！");
		}else{
			MsgBox.showError(number+"\n非提交状态单据，审核不通过！");
		}
		refresh(e);
	}
	/**
	 * output actionBasenotby_actionPerformed
	 */
	public void actionBasenotby_actionPerformed(ActionEvent e) throws Exception
	{
		String currentCompanyId = SysContext.getSysContext().getCurrentFIUnit().getId().toString();
		if (!currentCompanyId.equals("00000000-0000-0000-0000-000000000000CCE7AED4")) {
			MsgBox.showInfo("非集团组织下不允许操作！");
			SysUtil.abort();
		}
		checkSelected();
		ArrayList ids = getSelectedIdValues();
		ObjectUuidPK pk = new ObjectUuidPK(ids.get(0).toString());
		SupplierReqInfo info = SupplierReqFactory.getRemoteInstance().getSupplierReqInfo(pk);
		//if (!info.getBillStatus().equals(bdaApplyBillStatus.Audit)&& !info.getBillStatus().equals(bdaApplyBillStatus.unAudit)) {
		if (info.getBillStatus().equals(bdaApplyBillStatus.Submit)) {//操作已经提交的单据
			String billId = info.getId().toString();
			String uiname = "com.kingdee.eas.custom.cbd.client.UpdateErrorMsgUI";
			UIContext uicontext = new UIContext();
			uicontext.put("cuid", "");
			uicontext.put("billType", "供应商");
			uicontext.put("billId", billId);
			IUIWindow iuiwindow = UIFactory.createUIFactory(UIFactoryName.MODEL).create(uiname, uicontext, null,OprtState.VIEW);
			iuiwindow.show();
		} else {
			MsgBox.showError("请选择提交状态的单据！");
			SysUtil.abort();
		}
		refresh(e);
	}
	protected boolean initDefaultFilter() {
		return true;
	}

	protected FilterInfo getDefaultFilterForQuery() {
		FilterInfo filter = new FilterInfo();
		try {
			//if (isIgnoreCUFilter()) {
			String cuID=SysContext.getSysContext().getCurrentCtrlUnit().getId().toString();
			if(!cuID.equals("00000000-0000-0000-0000-000000000000CCE7AED4")){
				filter.getFilterItems().add(new FilterItemInfo("CU.id", cuID,CompareType.EQUALS));
				filter.setMaskString("#0");
			}
			//}
		} catch (Exception e)  {
			super.handUIException(e);
		}
		return filter;
	}

	@Override
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		checkSelected();
		if(this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("billStatus").equals(bdaApplyBillStatus.AUDIT_VALUE)){
			MsgBox.showWarning("单据已经完成审核操作，禁止修改！");
			SysUtil.abort();
		}
		super.actionEdit_actionPerformed(e);
	}
	public void setBackGround() {
		for (int i = 0; i < this.tblMain.getRowCount(); i++) {
			//审核通过
			if (this.tblMain.getRow(i).getCell("billStatus").getValue() !=null &&this.tblMain.getRow(i).getCell("billStatus").getValue().toString().equals(bdaApplyBillStatus.Audit.getAlias())) {
				this.tblMain.getRow(i).getStyleAttributes().setBackground(APPROVEColor);
			}
			//审核未通过
			if (this.tblMain.getRow(i).getCell("billStatus").getValue() !=null &&this.tblMain.getRow(i).getCell("billStatus").getValue().toString().equals(bdaApplyBillStatus.unAudit.getAlias())) {
				if(this.tblMain.getCell(i, "colordisplay").getValue().toString().equals("2")){
					this.tblMain.getRow(i).getStyleAttributes().setBackground(APPROVEColor);
				}else{
					this.tblMain.getRow(i).getStyleAttributes().setBackground(Color.red);
				}
			}

		}
	}
	@Override
	protected IQueryExecutor getQueryExecutor(IMetaDataPK arg0, EntityViewInfo ev) {
		/* 7921 */     SelectorItemCollection selectors = getSelectors();
		/* 7922 */     for (int i = 0; i < selectors.size(); ++i)
		/*      */     {
			/* 7924 */       SelectorItemInfo selector = selectors.get(i);
			/* 7925 */       if (ev.getSelector().contains(selector))
				/*      */         continue;
			/* 7927 */       ev.getSelector().add(selector);
			/*      */
		/*      */     }

		SorterItemCollection sic=new SorterItemCollection();
		SorterItemInfo si =new SorterItemInfo("bizDate");
		si.setSortType(SortType.DESCEND);
		sic.add(si);
		ev.setSorter(sic);
		return super.getQueryExecutor(arg0, ev);
	}


	/**
	 * output getSelectors method
	 */
	@Override
	public SelectorItemCollection getSelectors()
	{
		SelectorItemCollection sic = super.getSelectors();
		sic.add(new SelectorItemInfo("CSSGroup.name"));

		return sic;
	}  
	@Override
	protected CommonQueryDialog initCommonQueryDialog() {
		// TODO Auto-generated method stub
		CommonQueryDialog ds = super.initCommonQueryDialog();
		Date nowDate = new java.util.Date();
		Calendar cal=Calendar.getInstance();
		cal.setTime(nowDate);
		cal.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
		Date beginDate = cal.getTime();
		cal.add(Calendar.MONTH,1);//月增加1天 
		cal.add(Calendar.DAY_OF_MONTH,-1);//日期倒数一日,既得到本月最后一天 
		Date endDate = cal.getTime();

		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("bizDate",beginDate,CompareType.GREATER_EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("bizDate",endDate,CompareType.LESS_EQUALS));
		ev.setFilter(filter);
		ds.setDefalutEntityViewInfo(ev);
		return ds;
	}
}