/**
 * output package name
 */
package com.kingdee.eas.farm.food.client;

import java.awt.event.ActionEvent;

import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.PositionFactory;
import com.kingdee.eas.basedata.org.client.f7.AdminF7;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.food.comm.FarmCommUtils;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class OutsidePersonRecordBillEditUI extends AbstractOutsidePersonRecordBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(OutsidePersonRecordBillEditUI.class);
    
    /**
     * output class constructor
     */
    public OutsidePersonRecordBillEditUI() throws Exception
    {
        super();
        this.setUITitle("外来人员访问申请单");
    }

    /**
     * output loadFields method
     */
    public void loadFields()
    {
        super.loadFields();
        if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			this.mBtnAudit.setEnabled(false);
			this.mBtnUnAudit.setEnabled(true);
			this.tBtnAudit.setEnabled(false);
			this.tBtnUnAudit.setEnabled(true);
		}else if (this.editData.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)){
			this.mBtnAudit.setEnabled(true);
			this.mBtnUnAudit.setEnabled(false);
			this.tBtnAudit.setEnabled(true);
			this.tBtnUnAudit.setEnabled(false);
		}else {
			this.mBtnAudit.setEnabled(false);
			this.mBtnUnAudit.setEnabled(false);
			this.tBtnAudit.setEnabled(false);
			this.tBtnUnAudit.setEnabled(false);
		}
    }


    
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
    	if(FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("单据已经审核，禁止修改！");
    		SysUtil.abort();
    	}
		super.actionEdit_actionPerformed(e);
	}
	
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("单据已经审核，禁止修改！");
    		SysUtil.abort();
    	}
		super.actionRemove_actionPerformed(e);
	}
	/**
     * output actionAudit_actionPerformed
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
    	if(FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("单据已经审核，禁止再次审核！");
    		SysUtil.abort();
    	}
    	if(!FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.SUBMITED)) {
    		MsgBox.showWarning("单据尚未提交，禁止审核！");
    		SysUtil.abort();
    	}
		super.actionAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(this.editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
    }

    /**
     * output actionUnAudit_actionPerformed
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
    	if(!FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("单据尚未审核，禁止反审核！");
    		SysUtil.abort();
    	}
		super.actionUnAudit_actionPerformed(e);
	
		this.doAfterSave(new ObjectUuidPK(this.editData.getId()));
		
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("反审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.food.OutsidePersonRecordBillFactory.getRemoteInstance();
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
        com.kingdee.eas.farm.food.OutsidePersonRecordBillInfo objectValue = new com.kingdee.eas.farm.food.OutsidePersonRecordBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBizDate(new java.util.Date());
        objectValue.setAdminOrgUnit(SysContext.getSysContext().getCurrentAdminUnit());
        objectValue.setApplerPerson(SysContext.getSysContext().getCurrentUserInfo().getPerson());
        
        return objectValue;
    }

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		initControl();
	}
	/**
	 * 初始化控件
	 */
	private void initControl() {
		this.mBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.mBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		
		AdminF7 af7=new AdminF7();
		af7.setIsCUFilter(true);
		this.prmtadminOrgUnit.setSelector(af7);
		
		this.pkhappenDate.setTimeEnabled(true);
		this.pkmealtime.setTimeEnabled(true);
		this.pksendCarTime.setTimeEnabled(true);
		
		AdminF7 af72=new AdminF7();
		this.prmtdepartment.setSelector(af72);
		
		this.prmtperson.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				personChanged(e);
			}});
		
	}
	/**
	 * 接待人改变
	 * @param e
	 */
	private void personChanged(DataChangeEvent e) {
		try {
			if(e.getNewValue()!=null) {
				StringBuffer sql=new StringBuffer();
				sql.append(" select tpo.fid,tpo.FAdminOrgUnitID");
				sql.append(" from t_bd_person tP");//人员
				sql.append(" inner join T_ORG_PositionMember tpom on tpom.FPersonID=tp.fid");//职位
				sql.append(" inner join T_ORG_Position tpo on tpo.fid=tpom.FPositionID");
				//sql.append(" inner join T_ORG_Job tjob on tjob.fid=tpo.fjobid");//职务
				sql.append(" where tpom.FIsPrimary=1");
				sql.append(" and tp.fid='").append(((IPropertyContainer) e.getNewValue()).getString("id")).append("'");
				IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
				if(rs.next()) {
					//this.prmtposition.setValue(JobFactory.getRemoteInstance().getJobInfo(new ObjectUuidPK(rs.getString("fid"))));
					this.prmtposition.setValue(PositionFactory.getRemoteInstance().getPositionInfo(new ObjectUuidPK(rs.getString("fid"))));
					this.prmtdepartment.setValue(AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(rs.getString("FAdminOrgUnitID"))));
				}
			}else{
				this.prmtposition.setValue(null);
			}
			
		}catch(Exception err) {
			err.printStackTrace();
		}
	}
}