/**
 * output package name
 */
package com.kingdee.eas.farm.feemanager.basedata.client;

import java.awt.event.*;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.event.SelectorEvent;
import com.kingdee.bos.ctrl.swing.event.SelectorListener;
import com.kingdee.bos.dao.AbstractObjectValue;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.farm.feemanager.basedata.CarState;
import com.kingdee.eas.farm.food.comm.FarmCommUtils;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;

/**
 * output class name
 */
public class CarEditUI extends AbstractCarEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(CarEditUI.class);

	/**
	 * output class constructor
	 */
	public CarEditUI() throws Exception
	{
		super();
		//图标初始化
		this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
	}
	public void loadFields()
	{
		super.loadFields();

		btnCancel.setVisible(true);
		btnCancelCancel.setVisible(true);
		setUIStatus();
		this.prmtCarSize.setQueryInfo("com.kingdee.eas.farm.feemanager.basedata.app.CarriageFormatQuery");		
		this.prmtCarSize.setVisible(true);		
		this.prmtCarSize.setEditable(true);		
		this.prmtCarSize.setDisplayFormat("$carriagesize$");		
		this.prmtCarSize.setEditFormat("$number$");		
		this.prmtCarSize.setCommitFormat("$number$");		
		this.prmtCarSize.setRequired(false);
		prmtCarSize.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.CarriageFormatListUI prmtCarSize_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtCarSize_F7ListUI == null) {
					try {
						prmtCarSize_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.CarriageFormatListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtCarSize_F7ListUI));
					prmtCarSize_F7ListUI.setF7Use(true,ctx);
					prmtCarSize.setSelector(prmtCarSize_F7ListUI);
				}
			}
		});

		kdtEntry.getColumn("seq").getStyleAttributes().setHided(true);
		kdtEntry.addKDTEditListener(new KDTEditAdapter(){


			@Override
			public void editValueChanged(KDTEditEvent e) {
				// TODO Auto-generated method stub
				super.editValueChanged(e);
				if(kdtEntry.getColumnKey(e.getColIndex()).equals("isDefault"))
					if(e.getValue().equals(true))
						for(int i=0;i<kdtEntry.getRowCount();i++)
							if(kdtEntry.getCell(i, "isDefault").getValue().equals(true)&&i!=e.getRowIndex())
								kdtEntry.getCell(i, "isDefault").setValue(false);
			}


		});
	}



	private void setUIStatus() {
			// TODO Auto-generated method stub
			if(this.editData.getBaseStatus()!=null) {
				if(this.editData.getBaseStatus().equals(FarmBaseStatusEnum.approve)) {
					this.actionCancel.setEnabled(true);
					this.actionCancelCancel.setEnabled(false);
					this.actionEdit.setEnabled(false);
					this.actionAudit.setEnabled(false);
					this.actionUnAudit.setEnabled(true);		
				}else if(this.editData.getBaseStatus().equals(FarmBaseStatusEnum.unApprove)) {
					this.actionCancel.setEnabled(false);
					this.actionCancelCancel.setEnabled(false);
					this.actionEdit.setEnabled(true);
					this.actionAudit.setEnabled(true);
					this.actionUnAudit.setEnabled(false);		
				}else  if(this.editData.getBaseStatus().equals(FarmBaseStatusEnum.frozen)) {
					this.actionCancel.setEnabled(false);
					this.actionCancelCancel.setEnabled(true);
					this.actionEdit.setEnabled(false);
					this.actionAudit.setEnabled(false);
					this.actionUnAudit.setEnabled(false);		
				}else {
					this.actionCancel.setEnabled(false);
					this.actionCancelCancel.setEnabled(false);
					this.actionEdit.setEnabled(true);
				}
			}if(editData.getId()==null){
				this.actionCancel.setEnabled(false);
				this.actionCancelCancel.setEnabled(false);
				this.actionAudit.setEnabled(false);
				this.actionUnAudit.setEnabled(false);			
				this.actionEdit.setEnabled(false);
			}
		}
	@Override
	public void actionRemove_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBaseStatus()!=null&&!this.editData.getBaseStatus().equals(FarmBaseStatusEnum.unApprove)) {
    		MsgBox.showWarning("单据已经核准或禁用，禁止删除！");
    		return;
		}
		super.actionRemove_actionPerformed(arg0);
	}
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("核准完成");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
		setUIStatus();
	}
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionUnAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("反核准完成");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
		setUIStatus();
	}

	@Override
	public void actionCopy_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		//	super.actionCopy_actionPerformed(e);
		if (!(UtilRequest.isPrepare("ActionCopy", this)))
		{
			checkModified();
		}

		if ((this.editData != null) && (!(OprtState.VIEW.equals(getOprtState()))))
		{
			IObjectValue objectValue = (IObjectValue)getUIContext().get("CURRENT.VO");
			if (objectValue != null)
			{
				try
				{
					String id = this.idList.getID(this.idList.getCurrentIndex());
					setOprtState("RELEASEALL");
					pubFireVOChangeListener(id);
				}
				catch (Throwable E) {
				}
			}
		}
		ObjectValueUtil.copy(this.editData);

		unLockUI();

		setFieldsNull(this.editData);
		setOprtState("ADDNEW");


		this.editData.setBaseStatus(null);

		setDataObject(this.editData);
		//	loadData();
		loadFields();

		showCopyAddNew();
		this.actionCopy.setEnabled(false);
		this.chkMenuItemSubmitAndAddNew.setVisible(true);
		this.baseStatus.setSelectedIndex(0);
		setDefaultFocused();
	}

	@Override
	protected void setFieldsNull(AbstractObjectValue newData) {
		super.setFieldsNull(newData);
		newData.put("baseStatus", 1);
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		initUIComp();
	}
	private void initUIComp() {
		// TODO Auto-generated method stub
		
		
		this.review.setVisible(false);
		this.unreview.setVisible(false);
		// F7查询过滤
		SelectorListener[] selLis = prmtCarSize.getSelectorListeners();
		for(SelectorListener lis : selLis){
			prmtCarSize.removeSelectorListener(lis);
		}
		SelectorListener[] selLiss = prmtdriverID.getSelectorListeners();
		for(SelectorListener liss : selLiss){
			prmtdriverID.removeSelectorListener(liss);
		}
		contdriverID.setVisible(false);
		contdriverphone.setVisible(false);
		this.prmtCarSize.setQueryInfo("com.kingdee.eas.farm.feemanager.basedata.app.CarriageFormatQuery");		
		this.prmtCarSize.setVisible(true);		
		this.prmtCarSize.setEditable(true);		
		this.prmtCarSize.setDisplayFormat("$carriagesize$");		
		this.prmtCarSize.setEditFormat("$number$");		
		this.prmtCarSize.setCommitFormat("$number$");		
		this.prmtCarSize.setRequired(false);
		prmtCarSize.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.CarriageFormatListUI prmtCarSize_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtCarSize_F7ListUI == null) {
					try {
						prmtCarSize_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.CarriageFormatListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtCarSize_F7ListUI));
					prmtCarSize_F7ListUI.setF7Use(true,ctx);
					prmtCarSize.setSelector(prmtCarSize_F7ListUI);
				}
			}
		});


		prmtdriverID.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.DriverListUI prmtdriverID_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtdriverID_F7ListUI == null) {
					try {
						EntityViewInfo evi = new EntityViewInfo(); // 实体视图信息
						FilterInfo fi = new FilterInfo();// 过滤信息
						fi.getFilterItems().add(new FilterItemInfo("state",BillBaseStatusEnum.AUDITED_VALUE,CompareType.EQUALS));
						evi.setFilter(fi);	
						prmtdriverID_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.DriverListUI(evi);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtdriverID_F7ListUI));
					prmtdriverID_F7ListUI.setF7Use(true,ctx);

					prmtdriverID.setSelector(prmtdriverID_F7ListUI);
				}
			}
		});
		
		
		//司机添加过滤
		  final KDBizPromptBox kdtEntry_driver_PromptBox = new KDBizPromptBox();
	        kdtEntry_driver_PromptBox.setQueryInfo("com.kingdee.eas.farm.feemanager.basedata.app.DriverQuery");
	        kdtEntry_driver_PromptBox.setVisible(true);
	        kdtEntry_driver_PromptBox.setEditable(true);
	        kdtEntry_driver_PromptBox.setDisplayFormat("$number$");
	        kdtEntry_driver_PromptBox.setEditFormat("$number$");
	        kdtEntry_driver_PromptBox.setCommitFormat("$number$");
	        CompanyOrgUnitInfo companyInfo = SysContext.getSysContext().getCurrentFIUnit();
	        try {
				companyInfo = CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitInfo(new ObjectUuidPK(companyInfo.getId()));
			} catch (EASBizException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (BOSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        EntityViewInfo view = new EntityViewInfo();
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("CompanyOrgUnit.name", companyInfo.getName(), CompareType.EQUALS));
			view.setFilter(filter);
	        kdtEntry_driver_PromptBox.setEntityViewInfo(view);
	        KDTDefaultCellEditor kdtEntry_driver_CellEditor = new KDTDefaultCellEditor(kdtEntry_driver_PromptBox);
	        this.kdtEntry.getColumn("driver").setEditor(kdtEntry_driver_CellEditor);
	        ObjectValueRender kdtEntry_driver_OVR = new ObjectValueRender();
	        kdtEntry_driver_OVR.setFormat(new BizDataFormat("$drivername$"));
	        this.kdtEntry.getColumn("driver").setRenderer(kdtEntry_driver_OVR);
		
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
		return com.kingdee.eas.publicdata.CarFactory.getRemoteInstance();
	}

	/**
	 * output setDataObject method
	 */
	public void setDataObject(IObjectValue dataObject) 
	{
		super.setDataObject(dataObject);
		if(STATUS_ADDNEW.equals(getOprtState())) {
			editData.put("treeid",(com.kingdee.eas.publicdata.CarTreeInfo)getUIContext().get(UIContext.PARENTNODE));
		}
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.publicdata.CarInfo objectValue = new com.kingdee.eas.publicdata.CarInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		//设置默认值
		objectValue.setCarstate(CarState.NoSent);
		objectValue.setCompanyOrgUnit(SysContext.getSysContext().getCurrentFIUnit());
		return objectValue;
	}



}