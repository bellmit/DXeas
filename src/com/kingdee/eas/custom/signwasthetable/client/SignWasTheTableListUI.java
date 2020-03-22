/**
 * output package name
 */
package com.kingdee.eas.custom.signwasthetable.client;

import java.awt.Dialog;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.access.Select;
import com.kingdee.bos.metadata.access.SelectKey;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.ctrl.kdf.servertable.IRow;
import com.kingdee.bos.ctrl.semantic.design.client.action.Refresh;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.IQueryExecutor;
import com.kingdee.eas.base.commonquery.client.CommonQueryDialog;
import com.kingdee.eas.base.commonquery.client.CustomerQueryPanel;
import com.kingdee.eas.base.form.extend.menu.BillStatusEnum;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.assistant.ExchangeRate;
import com.kingdee.eas.basedata.assistant.ExchangeRateFactory;
import com.kingdee.eas.basedata.assistant.IExchangeRate;
import com.kingdee.eas.basedata.org.CompanyOrgUnit;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.cm.cal.CheckStatus;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.custom.signwasthetable.ISignWasTheTable;
import com.kingdee.eas.custom.signwasthetable.SignWasTheTable;
import com.kingdee.eas.custom.signwasthetable.SignWasTheTableFactory;
import com.kingdee.eas.custom.signwasthetable.SignWasTheTableInfo;
import com.kingdee.eas.custom.signwasthetable.billStatus;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.client.ITableLocate;
import com.kingdee.eas.scm.common.client.PrmtSelectorFactory;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class SignWasTheTableListUI extends AbstractSignWasTheTableListUI
{
	private static final Logger logger = CoreUIObject.getLogger(SignWasTheTableListUI.class);
    private CommonQueryDialog dialog;
    protected SignTableQueryPanel userPanel;

	/**
	 * output class constructor
	 */
	public SignWasTheTableListUI() throws Exception{
		super();
//		this.setFilterForQuery(getDefaultFilterForQuery());
	}



	
	
	
	


	/** output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
	}

	
	/**
	 * 打开列表前  先弹出过滤框
	 */
	@Override
	protected boolean initDefaultFilter() {
		return true;
	}






	@Override
	protected CommonQueryDialog initCommonQueryDialog() {
		// TODO Auto-generated method stub
		dialog = super.initCommonQueryDialog();
		try {
			dialog.addUserPanel(getUserPannel());
			dialog.setShowFilter(true);
			dialog.setShowSorter(true);
			dialog.setHeight(380);
			dialog.setWidth(500);
			dialog.setTitle("自定义过滤框");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dialog;
	}
	protected CustomerQueryPanel getUserPannel() throws Exception{
		if(this.userPanel==null)
			userPanel=new SignTableQueryPanel();
//		userPanel.onLoad();
		return userPanel;
	}






	/**
	 * 设置过滤条件  分录不占据行数
	 */
	protected FilterInfo getDefaultFilterForQuery(){
		FilterInfo filter =  super.getDefaultFilterForQuery();
		FilterInfo filterNew = new FilterInfo();
		filterNew.getFilterItems().add(new FilterItemInfo("Entry.seq",new Integer(1),CompareType.EQUALS));
		filterNew.getFilterItems().add(new FilterItemInfo("Entry.seq",null,CompareType.EQUALS));
		filterNew.setMaskString("#0 or #1");
		
		try{
			if(filter != null){
				filter.mergeFilter(filterNew, "and");
			}else{
				filter = filterNew;
			}
			
		}catch(BOSException e){
			e.printStackTrace();
			this.handleException(e);
		}
		return filter;
		
	}
	

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.custom.signwasthetable.SignWasTheTableFactory.getRemoteInstance();
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.custom.signwasthetable.SignWasTheTableInfo objectValue = new com.kingdee.eas.custom.signwasthetable.SignWasTheTableInfo();

		return objectValue;
	}
	

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		this.audit.setIcon(EASResource.getIcon("imgTbtn_auditing"));
		this.unAudit.setIcon(EASResource.getIcon("imgTbtn_fauditing"));		

	}
	@Override
	public void loadFields() {
		// TODO Auto-generated method stub
		super.loadFields();
	}

	public void actionEdit_actionPerformed(ActionEvent e) throws Exception
	{

		String id=this.getSelectedKeyValue();
		if(id==null)
		{
			MsgBox.showInfo("请选择记录行");
			SysUtil.abort();
		}
		ObjectUuidPK pk=new ObjectUuidPK(id);
		ISignWasTheTable is=SignWasTheTableFactory.getRemoteInstance();
		SignWasTheTableInfo info=is.getSignWasTheTableInfo(pk);
		if(info.getBillStatus().equals(billStatus.Audit)){
			MsgBox.showInfo("已审核的签呈不可编辑");
			return;
		}		
		super.actionEdit_actionPerformed(e);
	}

	/**
	 * output actionRemove_actionPerformed
	 */
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception
	{

		String id=this.getSelectedKeyValue();
		if(id==null)
		{
			MsgBox.showInfo("请选择记录行!");
			SysUtil.abort();
		}
		ObjectUuidPK pk=new ObjectUuidPK(id);
		ISignWasTheTable is=SignWasTheTableFactory.getRemoteInstance();
		SignWasTheTableInfo info=is.getSignWasTheTableInfo(pk);
		if(info.getBillStatus().equals(com.kingdee.eas.custom.signwasthetable.billStatus.Audit)){
			MsgBox.showInfo("该单据已审核，不能删除");
			return;
		}
		if(info.getBillStatus().equals(billStatus.submit))
		{
			MsgBox.showInfo("该单据已提交");
			abort();
		}
		super.actionRemove_actionPerformed(e);
	}

	@Override
	public void actionCheck_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub


		// 获取当前选择行的id
		String id = this.getSelectedKeyValue();
		// 把字符窜类型的ID,转成eas系统所需要的id格式，
		if(id==null)
		{
			MsgBox.showInfo("请选择记录行");
			SysUtil.abort();
		}

		ObjectUuidPK pk = new ObjectUuidPK(id);
		// 获取单据对象接口
		ISignWasTheTable is = SignWasTheTableFactory.getRemoteInstance();
		// 根据单据对象接口和id获取单据对象

		SignWasTheTableInfo info = is.getSignWasTheTableInfo(pk);
		Boolean bool = ClientUtils.checkBillInWorkflow(this, info.getId().toString());
		if(bool){
			MsgBox.showInfo("单据正处在工作流中，请稍后再试");
			SysUtil.abort();
		};
		if (info.getBillStatus().equals(com.kingdee.eas.custom.signwasthetable.billStatus.submit)) {
			if (getSelectedKeyValue() == null)
				return;
			super.actionCheck_actionPerformed(e);
			MsgBox.showInfo("审核通过");
		} else {
			MsgBox.showInfo("该状态下不能审核");
		}
		refresh(e);
	}
	@Override
	public void actionRefresh_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
//		this.excuteQuery(getDefaultEntityViewInfo(), false, null);
//		execQuery();
		super.actionRefresh_actionPerformed(e);
	}


	/*      */   protected boolean isLazyMode()
	/*      */   {
	/* 6478 */     return false;
	/*      */   }


	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		String id=this.getSelectedKeyValue();
		if(id==null)
		{
			MsgBox.showInfo("请选择记录行");
			SysUtil.abort();
		}
		ObjectUuidPK pk=new ObjectUuidPK(id);
		ISignWasTheTable is=SignWasTheTableFactory.getRemoteInstance();
		SignWasTheTableInfo info=is.getSignWasTheTableInfo(pk);
		if(info.getBillStatus().equals(billStatus.Audit)){
			super.actionUnAudit_actionPerformed(e);
			MsgBox.showInfo("反审核通过");
		}else
			MsgBox.showInfo("该状态下签呈无法反审核");
		refresh(e);

	}

	@Override
	protected void execQuery() {
		// TODO Auto-generated method stub
		super.execQuery();
	}

	@Override
	public FilterInfo getFilterInfo() {
		// TODO Auto-generated method stub
		return super.getFilterInfo();
	}

	@Override
	protected IQueryExecutor getQueryExecutor(IMetaDataPK queryPK,
			EntityViewInfo viewInfo) {
		// TODO Auto-generated method stub
		return super.getQueryExecutor(queryPK, viewInfo);
	}

}