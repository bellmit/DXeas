/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.recyclebiz.client;

import java.awt.Toolkit;
import java.awt.event.*;
import java.math.BigDecimal;
import java.util.EventListener;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.weighbridge.WeighBaseStatus;
import com.kingdee.eas.weighbridge.WeighBizType;
import com.kingdee.eas.weighbridge.weightbridgeFacadeFactory;
import com.kingdee.eas.weighbridge.bean.OrderWeightInfo;
import com.kingdee.eas.weighbridge.client.SelectSourceOrderUI;
import com.kingdee.eas.weighbridge.comm.WeighbridgeCommUtils;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.swing.KDDatePicker;

/**
 * output class name
 */
public class CKWeightBillEditUI extends AbstractCKWeightBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(CKWeightBillEditUI.class);
    
    /**
     * output class constructor
     */
    public CKWeightBillEditUI() throws Exception
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
			MsgBox.showWarning("�����Ѿ���ɻ���ˣ���ֹ�޸ģ�");
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
			MsgBox.showWarning("�����Ѿ���ɻ���ˣ���ֹ�޸ģ�");
			SysUtil.abort();
    	}
        super.actionRemove_actionPerformed(e);
    }
    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.carnivorous.recyclebiz.CKWeightBillFactory.getRemoteInstance();
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
        com.kingdee.eas.farm.carnivorous.recyclebiz.CKWeightBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.recyclebiz.CKWeightBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBizDate(new java.util.Date());
        objectValue.setCU(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentCtrlUnit());

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
    	
    	CompanyF7 ff7=new CompanyF7();
    	ff7.setIsCUFilter(true);
    	this.prmtcompany.setSelector(ff7);
    	ff7.setIsCUFilter(false);

    	this.contLastUpdateTime.setVisible(true);
		this.contLastUpdateUser.setVisible(true);
    	
    	this.mBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.mBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
    	
    	 KDDatePicker kdtEntrys_weighTime_DatePicker = new KDDatePicker();
    	 //KDTimePicker kdtEntrys_weighTime_DatePicker = new KDTimePicker();
    	// kdtEntrys_weighTime_DatePicker.setDateEnabled(true);
    	 kdtEntrys_weighTime_DatePicker.setDatePattern("yyyy-MM-dd HH:mm:ss");
         kdtEntrys_weighTime_DatePicker.setName("kdtEntrys_weighTime_DatePicker");
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
         
         this.btnAddNew.setVisible(false);	
         this.btnEdit.setVisible(false);	
         
         this.btnCancel.setVisible(true);	
         this.btnCancelCancel.setVisible(true);	
         this.btnCancel.setEnabled(true);
         this.btnCancelCancel.setEnabled(true);	

		 this.prmtcar.setRequired(false);
    }
    /**
     * output actionAudit_actionPerformed
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
    	if(WeighbridgeCommUtils.checkBillStatus(this.editData.getBillStatus(),WeighBaseStatus.audit)) {
    		MsgBox.showWarning("�����Ѿ���ˣ���ֹ�ٴ���ˣ�");
    		SysUtil.abort();
    	}
    	if(!WeighbridgeCommUtils.checkBillStatus(this.editData.getBillStatus(),WeighBaseStatus.finish)) {
    		MsgBox.showWarning("������δ������ɣ���ֹ��ˣ�");
    		SysUtil.abort();
    	}
		super.actionAudit_actionPerformed(e);
		/*this.setDataObject(this.editData);
		this.loadFields();*/
		this.editData.setBillStatus(WeighBaseStatus.audit);
		this.loadData();
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("��˳ɹ�");
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
    		MsgBox.showWarning("������δ��ˣ���ֹ����ˣ�");
    		SysUtil.abort();
    	}
		super.actionUnAudit_actionPerformed(e);
		this.editData.setBillStatus(WeighBaseStatus.save);
		this.loadData();
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("����˳ɹ�");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
    }

	
    
    
	/**
	 * ����Դ����
	 */
	@Override
	public void actionUpdateSourceBill_actionPerformed(ActionEvent e)
			throws Exception {
		 if(!this.oprtState.equalsIgnoreCase(STATUS_ADDNEW) ) {
			 try{
				UIContext uiContext = new UIContext(ui);
		//    	uiContext.put("searchOrderNum", searchOrderNum);
		//    	uiContext.put("orderMaps", orderMaps);
				
		    	uiContext.put("currDate", this.pkBizDate.getSqlDate());
		    	uiContext.put("orderType", SelectSourceOrderUI.PUR_ORDER);
		    	IUIWindow window = null;
		    	window = UIFactory.createUIFactory(UIFactoryName.MODEL).create("com.kingdee.eas.weighbridge.client.SelectSourceOrderUI", uiContext, null, OprtState.ADDNEW);
		    	window.show();
		    	Map selectUICtx = window.getUIObject().getUIContext();
		    	// ���ѡ����ĳ������ ��ȷ��һ��  ��  ���¹�������Ϣ
		    	if(selectUICtx != null){
		    		OrderWeightInfo orderWeightInfo =  (OrderWeightInfo) selectUICtx.get("OrderInfo");

		    		boolean cancel = true;
		    		if(selectUICtx.get("isCancel") != null){
		    			cancel = (Boolean) selectUICtx.get("isCancel");
		    		}
		    		
		    		if(!cancel){
		    			// ���޸� ���أ�ë�ؽ���
		    			uiContext.put("orderWeightInfo", orderWeightInfo);
		    			uiContext.put("instorageBill", this.editData);
		    			window = null;
				    	window = UIFactory.createUIFactory(UIFactoryName.MODEL).create("com.kingdee.eas.weighbridge.client.InStorageSetnewOrderInfo", uiContext, null, OprtState.ADDNEW);
				    	window.show();
				    	selectUICtx = window.getUIObject().getUIContext();
				    	// ��ȡ���º��ë�غ�Ƥ��
				    	BigDecimal newGross = (BigDecimal) selectUICtx.get("newGross");
				    	BigDecimal newTare = (BigDecimal) selectUICtx.get("newTare");
				    	String newOrderNumber = (String) selectUICtx.get("newOrderNumber");
				    	StringBuilder checkMsg = new StringBuilder();
				    	if(newGross != null || newTare != null || StringUtils.isNotBlank(newOrderNumber)){
					    	checkMsg.append("ȷ�ϸ������ݣ�");
					    	if(StringUtils.isNotBlank(newOrderNumber)){
					    		checkMsg.append("�����Ÿ���Ϊ��");
					    		checkMsg.append(newOrderNumber);
					    		checkMsg.append("��");
					    	}
					    	if(newGross != null){
					    		checkMsg.append("��ë�ظ���Ϊ��");
					    		checkMsg.append(newGross.toPlainString());
					    		checkMsg.append("��");
					    	}
					    	if(newTare != null){
					    		checkMsg.append("��Ƥ�ظ���Ϊ��");
					    		checkMsg.append(newTare.toPlainString());
					    		checkMsg.append("��");
					    	}
					    	checkMsg.append("��ȷ�ϸ��£�");
			    			// �޸Ĺ�����
			    			if(MsgBox.showConfirm2(checkMsg.toString()) == MsgBox.OK){
			    				// ִ�и��²���
//			    				weightbridgeFacadeFactory.getRemoteInstance().updateInweightSourceBillInfo(this.editData, orderWeightInfo,newGross,newTare);
			    				MsgBox.showInfo("�������");
			    				
			    				IObjectPK pk = new ObjectUuidPK(this.editData.getId());
			    				setDataObject(getValue(pk));
			    				EventListener[] lsts = removeDetailTableListener(KDTPropertyChangeListener.class);
			    				loadFields();
			    				restoreDetailTableListener(KDTPropertyChangeListener.class, lsts);
			    				initOldData(this.editData);
			    				setSave(true);
			    				setSaved(true);
			    				// �ж�
		//	    				SysUtil.abort();
			    				// ��֯
		//	    				this.getBizInterface().update(new ObjectUuidPK(this.editData.getId().toString()), this.editData);
			    				
			    			}
			    		}
		    		}
		    	}
			 }catch(BOSException bose){
				 bose.printStackTrace();
				 MsgBox.showInfo(bose.getMessage());
				 
			 } 
		 }
		
	}
}