/**
 * output package name
 */
package com.kingdee.eas.weighbridge.client;

import java.awt.Toolkit;
import java.awt.event.*;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.farm.food.comm.FarmCommUtils;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.weighbridge.WeighBaseStatus;
import com.kingdee.eas.weighbridge.WeighBizType;
import com.kingdee.eas.weighbridge.comm.WeighbridgeCommUtils;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.KDDatePicker;

/**
 * output class name
 */
public class OutStorageBillEditUI extends AbstractOutStorageBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(OutStorageBillEditUI.class);
    
    /**
     * output class constructor
     */
    public OutStorageBillEditUI() throws Exception
    {
        super();
        this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
    }
    /**
     * output loadFields method
     */
    public void loadFields()
    {
        super.loadFields();
        if(!this.oprtState.equalsIgnoreCase("addnew")) {
        	if(this.editData.getBizType().equals(WeighBizType.Sale)) {
				this.contorderStorageOrgUnit.setVisible(false);
				this.contcustomer.setVisible(true);
        	}else if(this.editData.getBizType().equals(WeighBizType.TransOut)||this.editData.getBizType().equals(WeighBizType.GroupSale)) {
        		this.contorderStorageOrgUnit.setVisible(true);
				this.contcustomer.setVisible(false);
        	} 
        }else {
        	this.contorderStorageOrgUnit.setVisible(false);
			this.contcustomer.setVisible(true);
        }
        if(this.editData.getBillStatus().equals(WeighBaseStatus.audit)) {
			this.mBtnAudit.setEnabled(false);
			this.mBtnUnAudit.setEnabled(true);
			this.tBtnAudit.setEnabled(false);
			this.tBtnUnAudit.setEnabled(true);
		}else if (this.editData.getBillStatus().equals(WeighBaseStatus.finish)){
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
    /**
     * output actionEdit_actionPerformed
     */
    public void actionEdit_actionPerformed(ActionEvent e) throws Exception
    {
    	if(WeighbridgeCommUtils.checkBillStatus(this.editData.getBillStatus(),WeighBaseStatus.finish)||WeighbridgeCommUtils.checkBillStatus(this.editData.getBillStatus(),WeighBaseStatus.audit)) {
			MsgBox.showWarning("单据已经完成或审核，禁止修改！");
			SysUtil.abort();
    	}
        super.actionEdit_actionPerformed(e);
    }

    /**
     * output actionRemove_actionPerformed
     */
    public void actionRemove_actionPerformed(ActionEvent e) throws Exception
    {
    	if(WeighbridgeCommUtils.checkBillStatus(this.editData.getBillStatus(),WeighBaseStatus.finish)||WeighbridgeCommUtils.checkBillStatus(this.editData.getBillStatus(),WeighBaseStatus.audit)) {
			MsgBox.showWarning("单据已经完成或审核，禁止修改！");
			SysUtil.abort();
    	}
        super.actionRemove_actionPerformed(e);
    }


    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.weighbridge.OutStorageBillFactory.getRemoteInstance();
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
        com.kingdee.eas.weighbridge.OutStorageBillInfo objectValue = new com.kingdee.eas.weighbridge.OutStorageBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBizDate(new java.util.Date());
        return objectValue;
    }
    @Override
	public void onShow() throws Exception {
		// TODO Auto-generated method stub
		super.onShow();
		initControl();
	}
    private void initControl() {
    	this.pkinTime.setTimeEnabled(true);
    	this.pkoutTime.setTimeEnabled(true);
    	
    	this.mBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.mBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		
		CompanyF7 ff7=new CompanyF7();
    	ff7.setIsCUFilter(true);
    	this.prmtcompany.setSelector(ff7);
    	ff7.setIsCUFilter(false);
    	this.prmtorderComopany.setSelector(ff7);
		
		this.contLastUpdateTime.setVisible(true);
		this.contLastUpdateUser.setVisible(true);
    	
    	 KDDatePicker kdtEntrys_weighTime_DatePicker = new KDDatePicker();
    	 //KDTimePicker kdtEntrys_weighTime_DatePicker = new KDTimePicker();
    	// kdtEntrys_weighTime_DatePicker.setDateEnabled(true);
         kdtEntrys_weighTime_DatePicker.setName("kdtEntrys_weighTime_DatePicker");
         kdtEntrys_weighTime_DatePicker.setDatePattern("yyyy-MM-dd HH:mm:ss");
         kdtEntrys_weighTime_DatePicker.setVisible(true);
         kdtEntrys_weighTime_DatePicker.setEditable(true);
         kdtEntrys_weighTime_DatePicker.setTimeEnabled(true);
         KDTDefaultCellEditor kdtEntrys_weighTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_weighTime_DatePicker);
         this.kdtEntrys.getColumn("weighTime").setEditor(kdtEntrys_weighTime_CellEditor);
         
         this.kdtEntrys.getColumn("weighTime2").setEditor(kdtEntrys_weighTime_CellEditor);
         this.kdtEntrys.getColumn("weighTimeGross").setEditor(kdtEntrys_weighTime_CellEditor);
         
         
         this.kdtEntrys.getColumn("weighTime").getStyleAttributes().setNumberFormat("yyyy-MM-dd HH:mm:ss");
         this.kdtEntrys.getColumn("weighTime2").getStyleAttributes().setNumberFormat("yyyy-MM-dd HH:mm:ss");
         this.kdtEntrys.getColumn("weighTimeGross").getStyleAttributes().setNumberFormat("yyyy-MM-dd HH:mm:ss");
         
         this.bizType.removeItem(WeighBizType.Pur);
         this.bizType.removeItem(WeighBizType.TransIn);
         this.bizType.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(bizType.getSelectedItem().equals(WeighBizType.Sale)) {
					contcustomer.setVisible(true);
					prmtorderStorageOrgUnit.setValue(null);
					contorderStorageOrgUnit.setVisible(false);
				}else{
					contorderStorageOrgUnit.setVisible(true);
					prmtcustomer.setValue(null);
					contcustomer.setVisible(false);
				}
			}});
         
         this.btnCancel.setVisible(true);
			this.btnCancelCancel.setVisible(true);
    }
    /**
     * output actionAudit_actionPerformed
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
    	if(WeighbridgeCommUtils.checkBillStatus(this.editData.getBillStatus(),WeighBaseStatus.audit)) {
    		MsgBox.showWarning("单据已经审核，禁止再次审核！");
    		SysUtil.abort();
    	}
    	if(!WeighbridgeCommUtils.checkBillStatus(this.editData.getBillStatus(),WeighBaseStatus.finish)) {
    		MsgBox.showWarning("单据尚未过磅完成，禁止审核！");
    		SysUtil.abort();
    	}
		super.actionAudit_actionPerformed(e);
		/*this.setDataObject(this.editData);
		this.loadFields();*/
		this.editData.setBillStatus(WeighBaseStatus.audit);
		this.loadData();
		
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
    	if(!WeighbridgeCommUtils.checkBillStatus(this.editData.getBillStatus(),WeighBaseStatus.audit)) {
    		MsgBox.showWarning("单据尚未审核，禁止反审核！");
    		SysUtil.abort();
    	}
		super.actionUnAudit_actionPerformed(e);
		//this.setDataObject(this.editData);
		this.loadData();
		
		setNextMessageText("反审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
    }
}	