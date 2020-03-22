/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basebiz.client;

import java.awt.Toolkit;
import java.awt.event.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.bot.BOTRelationFactory;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.dao.DataAccessException;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.custom.commld.UIUtil;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.WorkFlowUtil;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;

/**
 * output class name
 */
public class MaiginReturnBillEditUI extends AbstractMaiginReturnBillEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(MaiginReturnBillEditUI.class);
	private boolean isLoadField=false;
	/**
	 * output class constructor
	 */
	public MaiginReturnBillEditUI() throws Exception
	{
		super();
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		btnAudit.setIcon(ClientUtils.AuditIcon);
		btnUnAudit.setIcon(ClientUtils.UnAuditIcon);
		setUITitle("保证金退还单");
		initControl();
	}

	private void initControl() {
		// TODO Auto-generated method stub
		moneySource.setEnabled(true);	
		if(prmtcompany.getValue()!=null){
			String companyID;
			try {
				companyID = UIRuleUtil.getProperty((IObjectValue) prmtcompany.getValue(), "id").toString();
				StockingComm.setFarmerFilter(prmtfarmer, companyID);
			} catch (DataAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (BOSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		prmtcompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent areg0) {
				if(prmtcompany.getValue()!=null){
					String companyID=(String) prmtcompany.getValue();
					StockingComm.setFarmerFilter(prmtfarmer, companyID);
				}
			}	
		});


		prmtfarmer.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				if(prmtfarmer.getValue()!=null){
					try {
						SelectorItemCollection slor =new SelectorItemCollection();
						slor.add("*");
						slor.add("person.*");
						slor.add("bEBank.*");
						FarmerInfo farmer=FarmerFactory.getRemoteInstance().getFarmerInfo(new ObjectUuidPK(((IPropertyContainer)prmtfarmer.getValue()).getString("id")), slor);				
						txttotalMargin.setValue(farmer.getTotalMargin());
						txtoccupyMargin.setValue(farmer.getOccupyMargin());
						txtenableMargin.setValue(farmer.getEnableMargin());
						txtidentity.setText(farmer.getIdentity());
						txtbankNo.setText(farmer.getBankNo());
						prmtbEBank.setValue(farmer.getBEBank());
						txtphone.setText(farmer.getMobileTel());
						prmtperson.setValue(farmer.getPerson());
					} catch (DataAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (BOSException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (EASBizException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				}else{
					txttotalMargin.setValue(null);
					txtoccupyMargin.setValue(null);
					txtenableMargin.setValue(null);
					txtidentity.setText(null);
					txtbankNo.setText(null);
					txtphone.setText(null);
					prmtperson.setValue(null);
					prmtbEBank.setValue(null);
				}		
			}
		});

		bizType.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if(bizType.getSelectedItem()!=null){
					if(bizType.getSelectedItem()==com.kingdee.eas.farm.carnivorous.basebiz.bizType.receive){
						moneySource.setSelectedItem(com.kingdee.eas.farm.carnivorous.basebiz.moneySource.FromSettle);
						moneySource.setEnabled(true);						
					}else{
						moneySource.setEnabled(false);	
						moneySource.setSelectedItem(com.kingdee.eas.farm.carnivorous.basebiz.moneySource.NULL);
					}
				}
			}
		});

		//		moneySource.addItemListener(new ItemListener(){
		//			public void itemStateChanged(ItemEvent e) {
		//				if(moneySource.getSelectedItem()!=null){
		//					if(moneySource.getSelectedItem()==com.kingdee.eas.farm.carnivorous.basebiz.moneySource.FromBank){
		//						txtbankNo.setEnabled(true);						
		//					}else{
		//						txtbankNo.setEnabled(false);	
		//						txtbankNo.setText(null);
		//					}
		//				}
		//			}
		//		});
	}

	@Override
	protected void verifyInput(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.verifyInput(e);

		if(editData.getPayAmount()!=null&&editData.getPayAmount().signum()==0){
			MsgBox.showWarning("保证金不能为空或等于0！");
			SysUtil.abort();
		}

		if(editData.getBizType()==com.kingdee.eas.farm.carnivorous.basebiz.bizType.returnBack){
			BigDecimal payAmount =editData.getPayAmount()==null?BigDecimal.ZERO:editData.getPayAmount();
			BigDecimal enableMargin = editData.getEnableMargin()==null?BigDecimal.ZERO:editData.getEnableMargin();
			if(payAmount.compareTo(enableMargin)>0){
				MsgBox.showWarning("退还保证金不能大于可用保证金！");
				SysUtil.abort();
			}
		}else{
			if(editData.getMoneySource()==null||editData.getMoneySource()==com.kingdee.eas.farm.carnivorous.basebiz.moneySource.NULL){
				MsgBox.showWarning("收取保证金时,款项来源不能为空！");
				SysUtil.abort();
			}			
			if(editData.getMoneySource()==com.kingdee.eas.farm.carnivorous.basebiz.moneySource.Arrears&&txtpayAmount.getBigDecimalValue().signum()>=0){
				MsgBox.showWarning("款项来源为赊借款时,本次保证金金额必须为负数！");
				SysUtil.abort();
			}
		}
		if(editData.getMoneySource()==null||editData.getMoneySource()!=com.kingdee.eas.farm.carnivorous.basebiz.moneySource.Arrears){
			if(txtpayAmount.getBigDecimalValue().signum()<=0){
				MsgBox.showWarning("退保证金或收保证金且款项来源不为赊借款时,本次保证金金额必须为正数！");
				SysUtil.abort();
			}
		}
	}

	public void loadFields()
	{
		isLoadField=true;
		super.loadFields();
		isLoadField=false;

		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			this.actionAudit.setEnabled(false);
			this.actionUnAudit.setEnabled(true);
		}else if (this.editData.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)){
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(false);
		}else {
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(true);
		}
		
		bizType.removeItem(com.kingdee.eas.farm.carnivorous.basebiz.bizType.receive);
	}


	@Override
	public void actionVoucher_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionVoucher_actionPerformed(e);
		if(editData.getId()==null)
			return;
		//校验生成凭证
		ArrayList<String> destObejctIDs = BOTRelationFactory.getRemoteInstance().getDestObjIdByDestType(editData.getId().toString(), "2652E01E");
		if(destObejctIDs.size()==1){
			CommFacadeFactory.getRemoteInstance().excuteUpdateSql("update CT_FM_MaiginBill set CFVoucherNumID='"+destObejctIDs.get(0)+"' where fid='"+editData.getString("id")+"'");
		}
		UIUtil.refreshEditUI(this);
	}



	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSave_actionPerformed(e);
	}

	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止修改！");
			SysUtil.abort();
		}
		super.actionEdit_actionPerformed(e);
	}

	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
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
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止再次审核！");
			SysUtil.abort();
		}
		if(!this.editData.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)) {
			MsgBox.showWarning("单据尚未提交，禁止审核！");
			SysUtil.abort();
		}
		if(WorkFlowUtil.checkBillInWorkflow(null,editData.getId().toString())){
			MsgBox.showWarning("当前单据尚在工作流执行过程,不能执行该操作");
			SysUtil.abort();
		}
		super.actionAudit_actionPerformed(e);

		this.doAfterSave(new ObjectUuidPK(editData.getId()));

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
		if(!this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据尚未审核，禁止反审核！");
			SysUtil.abort();
		}
		super.actionUnAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
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
		return com.kingdee.eas.farm.carnivorous.basebiz.MaiginReturnBillFactory.getRemoteInstance();
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
		com.kingdee.eas.farm.carnivorous.basebiz.MaiginReturnBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.basebiz.MaiginReturnBillInfo();
		if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")) != null && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")).getBoolean("isBizUnit"))
			objectValue.put("company",com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")));
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		objectValue.setBizDate(new Date());
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));

		return objectValue;
	}

}