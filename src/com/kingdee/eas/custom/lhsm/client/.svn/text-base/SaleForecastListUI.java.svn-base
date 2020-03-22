/**
 * output package name
 */
package com.kingdee.eas.custom.lhsm.client;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.base.commonquery.client.CommonQueryDialog;
import com.kingdee.eas.base.commonquery.client.CustomerQueryPanel;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.custom.lhsm.ForecastEnum;
import com.kingdee.eas.custom.lhsm.SaleForecastInfo;
import com.kingdee.eas.scm.common.client.SCMCommonProcessor;
import com.kingdee.eas.scm.common.client.SCMPromptBoxFactory;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class SaleForecastListUI extends AbstractSaleForecastListUI
{
	private static final Logger logger = CoreUIObject.getLogger(SaleForecastListUI.class);

	// 当前的财务组织
	protected CompanyOrgUnitInfo currOrgUnitInfo;
	// 当前财务期间
	protected PeriodInfo currPeriod;

	SaleForecastFilterAUI filterUI;
	public CommonQueryDialog commonQueryDialog = null;
	/**
	 * output class constructor
	 */
	public SaleForecastListUI() throws Exception
	{

		super();
		//        initQueryFilter();
	}

	public void onLoad() throws Exception {

		super.onLoad();
		// 当前组织
		currOrgUnitInfo = (CompanyOrgUnitInfo)SysContext.getSysContext().getCurrentOrgUnit(OrgType.Company);

		//        currOrgUnitInfo = SysContext.getSysContext().getCurrentFIUnit();
		String cuid;
		cuid = currOrgUnitInfo.getId().toString().trim();
		if (cuid.equals("00000000-0000-0000-0000-000000000000CCE7AED4")) {
			MsgBox.showInfo("当前公司为虚体，不允许使用该功能。请选择实体公司！");
			SysUtil.abort();
		}
		
		tBtnAudit.setIcon(ClientUtils.AuditIcon);
		tBtnUnAudit.setIcon(ClientUtils.UnAuditIcon);
	}
	protected boolean initDefaultFilter() {
		return true;
	}


	/**
	 * output tblMain_tableSelectChanged method
	 */
	protected void tblMain_tableSelectChanged(com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent e) throws Exception
	{
		selectedRowChanged(e.getSelectBlock().getBeginRow());
		super.tblMain_tableSelectChanged(e);
	}
	/**
	 * 行选择 改变事件
	 * @param rowIndex
	 */
	private void selectedRowChanged(int rowIndex) {
		ArrayList list = this.getSelectedFieldValues("state");
		if(list.size()>0) {
			if(list.get(0).equals("审核") || list.get(0).equals("分配完毕") || list.get(0).equals("关闭")) {
				this.actionAudit.setEnabled(false);
				this.actionUnAudit.setEnabled(true);
				this.actionEdit.setEnabled(false);
			}else if(list.get(0).equals("提交")) {
				this.actionAudit.setEnabled(true);
				this.actionUnAudit.setEnabled(false);
				this.actionEdit.setEnabled(true);
			}else{
				this.actionAudit.setEnabled(false);
				this.actionUnAudit.setEnabled(false);
				this.actionEdit.setEnabled(true);
			}
		}
	}

	/**
	 * output actionRemove_actionPerformed
	 */
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception
	{
//		MsgBox.showError("请打开界面删除！");
//		SysUtil.abort();
		super.actionRemove_actionPerformed(e);
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.custom.lhsm.SaleForecastFactory.getRemoteInstance();
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.custom.lhsm.SaleForecastInfo objectValue = new com.kingdee.eas.custom.lhsm.SaleForecastInfo();

		return objectValue;
	}
	protected CustomerQueryPanel getFilterUI()   throws Exception{
		if (this.commonQueryDialog != null) {
			this.commonQueryDialog.setHeight(460);
		}
		if (this.filterUI == null) {
			this.filterUI = new SaleForecastFilterAUI();
		}
		return this.filterUI;
	}
	protected CommonQueryDialog initCommonQueryDialog(){
		if (this.commonQueryDialog == null) {
			if (this.mainQuery == null) {
				this.mainQuery = new EntityViewInfo();
			}
			this.mainQuery = new EntityViewInfo();
			this.commonQueryDialog = super.initCommonQueryDialog();
			this.commonQueryDialog.setWidth(450);
			this.commonQueryDialog.setHeight(320);
			try{
				SCMPromptBoxFactory scmF7Factory = new SCMPromptBoxFactory(getFilterUI(), getMainBizOrgType());
				this.commonQueryDialog.setPromptBoxFactory(scmF7Factory);
				this.commonQueryDialog.setProcessor(new SCMCommonProcessor()); 
				//ISCMFilter iFilter = (ISCMFilter)getFilterUI();
				this.commonQueryDialog.addUserPanel(getFilterUI());
			} catch (Exception e) {
				handUIException(e);
				SysUtil.abort();
			}
		}
		return this.commonQueryDialog;
	}

	protected boolean isIgnoreCUFilter(){
		return true;
	}

	@Override
	protected FilterInfo getDefaultFilterForQuery() {
		// TODO Auto-generated method stub
		return super.getDefaultFilterForQuery();
	}

	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		checkSelected();
		SaleForecastInfo editData = (SaleForecastInfo) getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue()));;
		if(editData == null || editData.getId() == null){
			SysUtil.abort();
		} else{

			if(!editData.getState().equals(ForecastEnum.SUBMIT)){
				MsgBox.showError("非提交状态单据禁止审核！");
				SysUtil.abort();
			}
		}
		super.actionAudit_actionPerformed(e);
		MsgBox.showInfo("审核成功！");
		actionRefresh_actionPerformed(e);
	}

	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionUnAudit_actionPerformed(e);
		MsgBox.showInfo("反成功！");
		actionRefresh_actionPerformed(e);
	}
	
	

}