/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.basedata.client;

import java.awt.event.ActionEvent;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.framework.ObjectValueUtil;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class PersonFarmerRelationEditUI extends AbstractPersonFarmerRelationEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(PersonFarmerRelationEditUI.class);
    private String curCompanyID=null;
    
    /**
     * output class constructor
     */
    public PersonFarmerRelationEditUI() throws Exception
    {
        super();
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
        return com.kingdee.eas.farm.stocking.basedata.PersonFarmerRelationFactory.getRemoteInstance();
    }

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject) 
    {
        super.setDataObject(dataObject);
        if(STATUS_ADDNEW.equals(getOprtState())) {
            editData.put("treeid",(com.kingdee.eas.farm.stocking.basedata.PersonFarmerRelationTreeInfo)getUIContext().get(UIContext.PARENTNODE));
        }
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.basedata.PersonFarmerRelationInfo objectValue = new com.kingdee.eas.farm.stocking.basedata.PersonFarmerRelationInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        objectValue.setBaseStatus(FarmBaseStatusEnum.unApprove);
        return objectValue;
    }
    @Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		curCompanyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
		initControl();
	}
    
    private void initControl() {
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		
    	
    	CompanyF7 cf7=new CompanyF7();
    	cf7.setIsCUFilter(true);
    	this.prmtcompany.setSelector(cf7);
    	
    	//人员过滤
		StockingClientComm.makeApplierF7(this.prmtperson, curCompanyID, this, false);
		//养殖户过滤
		StockingClientComm.setFarmerFilter((KDBizPromptBox) kdtEntry.getColumn("farmer").getEditor().getComponent(), curCompanyID,false);
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
		setNextMessageText("反核准完成");
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
	protected void verifyInput(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.verifyInput(e);
		String billID=null;
		if(this.editData.getId()!=null) {
			billID=this.editData.getId().toString();
		}
		String personName;
		for(int rowIndex=0;rowIndex<this.kdtEntry.getRowCount();rowIndex++) {
			if(kdtEntry.getCell(rowIndex, "farmer").getValue()==null) {
				continue;
			}
			personName=checkHasExists(curCompanyID,billID, ((IPropertyContainer) kdtEntry.getCell(rowIndex, "farmer").getValue()).getString("id"));
			if(StringUtils.isNotBlank(personName)) {
				MsgBox.showWarning("养殖户("+((IPropertyContainer) kdtEntry.getCell(rowIndex, "farmer").getValue()).getString("name")+")已经被其他的技术员("+personName+")管理！");
//				SysUtil.abort();
			}
		}
	}
	/**
	 * 检查养殖场是否已经被其他业务员添加
	 * @param billID
	 * @param farmerID
	 * @return
	 */
	private String checkHasExists(String companyID,String billID,String farmerID) {
		try{
			StringBuffer sql=new StringBuffer();
			sql.append(" select tp.fname_l2 fname")
			.append(" from T_FM_PersonFarmerRelation tmain")
			.append(" inner join T_FM_PersonFarmerRelationEntry tentry on tentry.fparentid=tmain.fid")
			.append(" inner join t_bd_person tp on tp.fid=tmain.FPersonID")
			.append(" where tmain.FCompanyID='").append(companyID).append("'")
			.append(" and tentry.FFarmerID='").append(farmerID).append("'");
			if(StringUtils.isNotEmpty(billID)){
				sql.append(" and tmain.fid!='").append(billID).append("'");
			}
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			if(rs.next()) {
				return rs.getString("fname");
			}
		}catch(Exception err){
			err.printStackTrace();
		}
		return null;
	}
	
	
}