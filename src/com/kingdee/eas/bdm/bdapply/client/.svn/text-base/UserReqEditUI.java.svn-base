/**
 * output package name
 */
package com.kingdee.eas.bdm.bdapply.client;

import java.awt.event.ActionEvent;
import java.util.EventListener;
import java.util.HashSet;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.org.AdminOrgUnitCollection;
import com.kingdee.eas.basedata.person.PersonFacadeFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class UserReqEditUI extends AbstractUserReqEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(UserReqEditUI.class);
    
    /**
     * output class constructor
     */
    public UserReqEditUI() throws Exception
    {
        super();
        
        // 图标设置
        this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));
    }
    /**
     * output loadFields method
     */
    public void loadFields()
    {
        super.loadFields();
    }

	/**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("baseStatus",new Integer(0));
        
    }  
    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.bdm.bdapply.UserReqFactory.getRemoteInstance();
    }

    /**
     * output createNewDetailData method
     */
    protected IObjectValue createNewDetailData(KDTable table)
    {
		
        return null;
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.bdm.bdapply.UserReqInfo objectValue = new com.kingdee.eas.bdm.bdapply.UserReqInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBaseStatus(BillBaseStatusEnum.ADD);
        return objectValue;
    }
    
    /**
	 * 初始化
	 */
	@Override
	public void onLoad() throws Exception {
		
		super.onLoad();
//		
//		if("ADDNEW".equals(this.getOprtState())){
//			this.baseStatus.setSelectedIndex(1);
//		}
		
		this.prmtperson.setQueryInfo("com.kingdee.eas.basedata.person.app.F7PersonQuery");
		
	}
	
	/**
	 * 保存操作
	 */
	public void actionSave_actionPerformed(ActionEvent e) throws Exception{

		if(this.baseStatus.getSelectedItem() == null || 
				BillBaseStatusEnum.ADD.equals(this.baseStatus.getSelectedItem()) || 
				BillBaseStatusEnum.TEMPORARILYSAVED.equals(this.baseStatus.getSelectedItem()) ){
			
			
			try{
				
				checkPerson();
				super.actionSave_actionPerformed(e);
				
			}catch(BOSException bose){
				MsgBox.showError(bose.getMessage());
				SysUtil.abort();
			}
			
			
		}else{
			MsgBox.showWarning("只能保存未提交的的单据");
			SysUtil.abort();
		}
	}
    /**
	 * 提交前校验
	 */
	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		
		if(this.baseStatus.getSelectedItem() == null || 
				BillBaseStatusEnum.ADD.equals(this.baseStatus.getSelectedItem()) || 
				BillBaseStatusEnum.TEMPORARILYSAVED.equals(this.baseStatus.getSelectedItem()) ||
				BillBaseStatusEnum.SUBMITED.equals(this.baseStatus.getSelectedItem()) ){
			
			
			try{
				
				checkPerson();
				super.actionSubmit_actionPerformed(e);
				
			}catch(BOSException bose){
				MsgBox.showError(bose.getMessage());
				SysUtil.abort();
			}
			
			
		}else{
			MsgBox.showWarning("只能提交未审核的单据");
			SysUtil.abort();
		}
	}
	/**
	 * 校验当前的职员
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void checkPerson() throws EASBizException, BOSException{
		PersonInfo currPerson = (PersonInfo) this.prmtperson.getValue();
		if(currPerson != null){
			HashSet hs = PersonFacadeFactory.getRemoteInstance().getUserByPerson(currPerson.getId());
			if(hs != null && hs.size() > 0){
				MsgBox.showInfo("当前职员已经存在关联的用户，请不要重复申请");
				SysUtil.abort();
			}
		}
	}
	
    /**
     * 审核
     */
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		if(this.editData == null || this.editData.getId() == null || !this.editData.getBaseStatus().equals(BillBaseStatusEnum.SUBMITED)){
			MsgBox.showWarning("不能审核未提交的单据");
			SysUtil.abort();
		}
		try{


				super.actionAudit_actionPerformed(e);
				MsgBox.showWarning("审核完成");
				reloadData();
			
		}catch(BOSException bose){
			MsgBox.showError(bose.getMessage());
			SysUtil.abort();
		}
	}
	
	/**
     * 重载单据内容
     * @throws Exception 
     * @throws BOSException 
     * @throws EASBizException 
     */
	private void reloadData() throws EASBizException, BOSException, Exception{
		
		if ((this.editData == null) || (this.editData.getId() == null)) {
			return;
		}
		IObjectPK pk = new ObjectUuidPK(this.editData.getId());
		setDataObject(getValue(pk));
		EventListener[] lsts = removeDetailTableListener(KDTPropertyChangeListener.class);
		loadFields();
		restoreDetailTableListener(KDTPropertyChangeListener.class, lsts);
		initOldData(this.editData);
		setSave(true);
		setSaved(true);
		// 中断
		SysUtil.abort();
			
			
		
	}
	/**
	 * 反审核
	 */
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		if(this.editData == null || this.editData.getId() == null || !this.editData.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)){
			MsgBox.showWarning("只能反审核处于审核状态的单据");
			SysUtil.abort();
		}
		try{
			super.actionUnAudit_actionPerformed(e);
			MsgBox.showWarning("审核完成");
			reloadData();
		}catch(BOSException bose){
			MsgBox.showError(bose.getMessage());
			SysUtil.abort();
		}
	}
	
	/**
	 * 人员变化时更新 部门
	 */
    @Override
	protected void prmtperson_dataChanged(DataChangeEvent e) throws Exception {
		PersonInfo currPerson = (PersonInfo) this.prmtperson.getValue();
		if(currPerson != null){
//			currPerson.get
			AdminOrgUnitCollection adminColl = PersonFacadeFactory.getRemoteInstance().getAdminOrgUnitByPerson(currPerson.getId());
			if(adminColl != null && adminColl.size() > 0){
				this.prmtpersonDepart.setValue(adminColl.get(0));
				this.editData.setPersonDepart(adminColl.get(0));
			}
		}else{
			this.prmtpersonDepart.setValue(null);
			this.editData.setPersonDepart(null);
		}
	}

}