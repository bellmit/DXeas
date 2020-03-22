/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.basedata.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import jxl.format.Orientation;

import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.KDTableHelper;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.framework.ObjectValueUtil;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.scm.common.util.F7ContextManager;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class BreedStandardEditUI extends AbstractBreedStandardEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(BreedStandardEditUI.class);
    private String curCompanyID;//��ǰ������֯
    private F7ContextManager f7Manager;
    private OrgUnitInfo orgInfo = null;//�����֯
    
    /**
     * output class constructor
     */
    public BreedStandardEditUI() throws Exception
    {
        super();
        this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
    }
    @Override
	public void loadFields() {
		// TODO Auto-generated method 
		super.loadFields();
		if(this.editData.getBaseStatus()!=null) {
			if(this.editData.getBaseStatus().equals(FarmBaseStatusEnum.enable)) {
				this.actionCancel.setEnabled(true);
				this.actionCancelCancel.setEnabled(false);
				this.actionEdit.setEnabled(false);
			}
			else if(this.editData.getBaseStatus().equals(FarmBaseStatusEnum.approve)) {
				this.actionCancel.setEnabled(false);
				this.actionCancelCancel.setEnabled(true);
				this.actionEdit.setEnabled(false);
			} else {
				this.actionCancel.setEnabled(false);
				this.actionCancelCancel.setEnabled(false);
				this.actionEdit.setEnabled(true);
			}
		}
	}

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.basedata.BreedStandardFactory.getRemoteInstance();
    }

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject) 
    {
        super.setDataObject(dataObject);
        if(STATUS_ADDNEW.equals(getOprtState())) {
            editData.put("treeid",(com.kingdee.eas.farm.stocking.basedata.BreedStandardTreeInfo)getUIContext().get(UIContext.PARENTNODE));
        }
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.basedata.BreedStandardInfo objectValue = new com.kingdee.eas.farm.stocking.basedata.BreedStandardInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        return objectValue;
    }

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
    	curCompanyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
    	//enter������
    	KDTableHelper.setEnterKeyJumpOrientation(kdtLayEggEntrys, Orientation.HORIZONTAL.getValue());
    	KDTableHelper.setEnterKeyJumpOrientation(kdtEntrys, Orientation.HORIZONTAL.getValue());
    	KDTableHelper.setEnterKeyJumpOrientation(kdtDrugEntry, Orientation.HORIZONTAL.getValue());

		super.onLoad();
		orgInfo = StorageOrgUnitFactory.getRemoteInstance().getOrgUnitInfo(new ObjectUuidPK(curCompanyID));
		f7Manager = new F7ContextManager(this, OrgType.Storage);
		
		this.mBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.mBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		
		CompanyF7 cf7=new CompanyF7();
		cf7.setIsCUFilter(true);
		this.prmtcompany.setSelector(cf7);
		

//		f7Manager.registerBizMaterialF7( (KDBizPromptBox) this.kdtEntrys.getColumn("material").getEditor().getComponent(), null, null, orgInfo,false);
//		f7Manager.registerMeasureUnitF7(kdtEntrys, "material", "unit");
		f7Manager.registerBizMaterialF7( (KDBizPromptBox) this.kdtEntrys.getColumn("henMaterial").getEditor().getComponent(), null, null, orgInfo,false);
		f7Manager.registerBizMaterialF7( (KDBizPromptBox) this.kdtEntrys.getColumn("cockMaterial").getEditor().getComponent(), null, null, orgInfo,false);
		
		f7Manager.registerBizMaterialF7( (KDBizPromptBox) this.kdtDrugEntry.getColumn("material").getEditor().getComponent(), null, null, orgInfo,false);
		f7Manager.registerMeasureUnitF7(kdtDrugEntry, "material", "unit");
	}
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("��׼���");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
		this.actionCancelCancel.setEnabled(true);
		this.actionEdit.setEnabled(false);
		
	}
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionUnAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("����׼���");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}
	@Override
	public void actionCopy_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
//		super.actionCopy_actionPerformed(e);
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
//		loadData();
		loadFields();

		showCopyAddNew();
		this.actionCopy.setEnabled(false);
		this.chkMenuItemSubmitAndAddNew.setVisible(true);
		this.baseStatus.setSelectedIndex(0);
		setDefaultFocused();
	}
	@Override
	protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		super.beforeStoreFields(arg0);
		checkEntryWeekAndDay(kdtEntrys,"��ι�淶");
		checkEntryWeekAndDay(kdtLayEggEntrys,"�����淶");
		checkEntryWeekAndDay(kdtDrugEntry,"���߹淶");
		
		/*int beginWeek,beginDay;
		for(int rowIndex=0;rowIndex<kdtDrugEntry.getRowCount();rowIndex++) {
			IRow row = kdtDrugEntry.getRow(rowIndex);
			beginWeek=0;beginDay=0;
			if(row.getCell("week").getValue()!=null) {
				beginWeek=(Integer) row.getCell("week").getValue();
			}
			if(row.getCell("days").getValue()!=null) {
				beginDay=(Integer) row.getCell("days").getValue();
			}
			if(beginDay>7) {
				MsgBox.showWarning("���߹淶\n"+"��"+(rowIndex+1)+"�У����䲻�ܴ���7��");
				SysUtil.abort();
			}
			if(beginDay<1) {
				MsgBox.showWarning("���߹淶\n"+"��"+(rowIndex+1)+"�У����䲻��С��1��");
				SysUtil.abort();
			}
		}*/
	}
	private void checkEntryWeekAndDay(KDTable table,String entryName) {
		IRow row;
		int beginWeek,beginDay,endWeek,endDay=0,endWeekKeep=0,endDayKeep=0;
		for(int rowIndex=0;rowIndex<table.getRowCount();rowIndex++) {
			row=table.getRow(rowIndex);
			beginWeek=0;beginDay=0;endWeek=0;endDay=0;
			if(row.getCell("week").getValue()!=null) {
				beginWeek=(Integer) row.getCell("week").getValue();
			}
			if(row.getCell("days").getValue()!=null) {
				beginDay=(Integer) row.getCell("days").getValue();
			}
			if(row.getCell("endWeek").getValue()!=null) {
				endWeek=(Integer) row.getCell("endWeek").getValue();
			}
			if(row.getCell("endDays").getValue()!=null) {
				endDay=(Integer) row.getCell("endDays").getValue();
			}
			if((beginWeek>0&&beginDay>7)||(endWeek>0&&endDay>7)) {
				MsgBox.showWarning(entryName+"\n"+"��"+(rowIndex+1)+"�У����䲻�ܴ���7��");
				SysUtil.abort();
			}
			if(beginDay<1||endDay<1) {
				MsgBox.showWarning(entryName+"\n"+"��"+(rowIndex+1)+"�У����䲻��С��1��");
				SysUtil.abort();
			}
			if(endWeek<beginWeek) {
				MsgBox.showWarning(entryName+"\n"+"��"+(rowIndex+1)+"�У�����������ڿ�ʼ���䣡");
				SysUtil.abort();
			}else if(endWeek==beginWeek)  {
				if(endDay<beginDay) {
					MsgBox.showWarning(entryName+"\n"+"��"+(rowIndex+1)+"�У�����������ڿ�ʼ���䣡");
					SysUtil.abort();
				}
			}
			if(rowIndex==0) {
				endWeekKeep=endWeek;
				endDayKeep=endDay;
			}else{
				if(beginWeek<endWeekKeep) {
					MsgBox.showWarning(entryName+"\n"+"��"+(rowIndex+1)+"�У���ʼ����С����һ�н������䣡");
					SysUtil.abort();
				}else if(beginWeek==endWeekKeep){
//					if(beginDay<=endDayKeep) {
//						MsgBox.showWarning(entryName+"\n"+"��"+(rowIndex+1)+"�У���ʼ����С�ڵ�����һ�н������䣡");
//						SysUtil.abort();
//					}
					
					if(beginDay<endDayKeep) {
						MsgBox.showWarning(entryName+"\n"+"��"+(rowIndex+1)+"�У���ʼ����С����һ�н������䣡");
						SysUtil.abort();
					}
					
				}
			}
			endWeekKeep=endWeek;
			endDayKeep=endDay;
		}
	}
	
}