/**
 * output package name
 */
package com.kingdee.eas.custom.taihe.contract.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.bdm.bdapply.SupplierReqInfo;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.custom.commld.ListenerUtil;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.client.PrmtSelectorFactory;
import com.kingdee.eas.scm.common.util.F7ContextManager;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class SuccessiveContractEditUI extends AbstractSuccessiveContractEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(SuccessiveContractEditUI.class);
	private F7ContextManager f7Manager;
	private OrgUnitInfo orgInfo = null;//组织
	private boolean isLoad=false;
	/**
	 * output class constructor
	 */
	public SuccessiveContractEditUI() throws Exception
	{
		super();
	}
	/**
	 * output loadFields method
	 */
	public void loadFields()
	{
		ListenerUtil.F7RemoveDateChangeListener(prmtSupplier);
		ListenerUtil.F7RemoveDateChangeListener(prmtfarm);
//		ListenerUtil.F7RemoveDateChangeListener(prmtfarmer);
		super.loadFields();
		prmtSupplier.addDataChangeListener(new DataChangeListener(){

			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				if(prmtSupplier.getValue()!=null){
					//					txtpartyBCell.setStringValue(String.valueOf(((SupplierReqInfo)prmtSupplier.getValue()).getTelephone()));
					txtpartyBAddress.setStringValue(((SupplierReqInfo)prmtSupplier.getValue()).getAddress());
					txtpartyBBank.setStringValue(((SupplierReqInfo)prmtSupplier.getValue()).getBank());
					txtpartyBBankNo.setStringValue(((SupplierReqInfo)prmtSupplier.getValue()).getAccountNum());
					txtpartyBID.setStringValue(((SupplierReqInfo)prmtSupplier.getValue()).getTaxRegisterNo());

				}
			}});


//		prmtfarmer.addDataChangeListener(new DataChangeListener(){
//
//			public void dataChanged(DataChangeEvent paramDataChangeEvent) {
//				// TODO Auto-generated method stub
//				if(!isLoad){
//					isLoad=true;
//					StockingComm.setFarmInfoByFarmer(prmtfarmer, prmtfarm);
//					isLoad=false;
//				}
//			}});
		prmtfarm.addDataChangeListener(new DataChangeListener(){

			public void dataChanged(DataChangeEvent paramDataChangeEvent) {
				// TODO Auto-generated method stub
				if(!isLoad){
					isLoad=true;
//					prmtfarmer.setValue(StockingComm.getFarmerInfoByFarm(null, prmtfarm));
					isLoad=false;
				}
			}});
	}

	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSubmit_actionPerformed(e);
		if(editData.getId()==null){
			super.actionPre_actionPerformed(e);
		}
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
		return com.kingdee.eas.custom.taihe.contract.SuccessiveContractFactory.getRemoteInstance();
	}

	/**
	 * output createNewDetailData method
	 */
	protected IObjectValue createNewDetailData(KDTable table)
	{

		return null;
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		contCreateTime.setVisible(true);
		contLastUpdateUser.setVisible(true);
		contLastUpdateTime.setVisible(true);
		CompanyF7 cf7=new CompanyF7();
		prmtcompany.setSelector(cf7);
//		btnAudit.setIcon(ClientUtils.AuditIcon);
//		btnUnAudit.setIcon(ClientUtils.UnAuditIcon);

		orgInfo = SysContext.getSysContext().getCurrentFIUnit();
		f7Manager = new F7ContextManager(this, OrgType.Company);
		f7Manager.registerBizSupplierF7(prmtSupplier, null, null, orgInfo);
		prmtcompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				setFilter();
			}});
		setFilter();
		setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());

	}

	//设置隔离
	private void setFilter() {
		// TODO Auto-generated method stub

		String curCompanyID;
		if(this.prmtcompany.getValue()!=null) {
			curCompanyID=((IPropertyContainer) this.prmtcompany.getValue()).getString("id");
		}else{
			curCompanyID=null;
		}

		String farmerID=null,farmID=null,houseID=null;
//		if(prmtfarmer.getValue()!=null) {
//			farmerID=((IPropertyContainer) prmtfarmer.getValue()).getString("id");
//		}
		if(prmtfarm.getValue()!=null) {
			farmID=((IPropertyContainer) prmtfarm.getValue()).getString("id");
		}
		//养殖户过滤
//		StockingComm.setFarmerFilter(prmtfarmer, curCompanyID,false);
		//养殖场过滤
		StockingComm.setFarmFilter(this.prmtfarm, curCompanyID, farmerID,true);


	}
	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.custom.taihe.contract.SuccessiveContractInfo objectValue = new com.kingdee.eas.custom.taihe.contract.SuccessiveContractInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		objectValue.setBizDate(new Date());
		objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		return objectValue;
	}
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAudit_actionPerformed(e);
		if(editData.getId()!=null)
			doAfterSave(new ObjectUuidPK(editData.getId().toString()));
		MsgBox.showInfo("审核完成");
	}
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionUnAudit_actionPerformed(e);
		if(editData.getId()!=null)
			doAfterSave(new ObjectUuidPK(editData.getId().toString()));
		MsgBox.showInfo("反审核完成");
	}


}